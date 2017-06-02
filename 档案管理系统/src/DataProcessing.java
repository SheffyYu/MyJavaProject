import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.sql.*;



public  class DataProcessing {
	private static boolean MySQLConnect = false;
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
    private static int numberofRows;
    private static PreparedStatement ps;
    private static ResultSetMetaData metaData;
	private static boolean connectToDB=false;
	
	static Hashtable<String, User> users;
	static Hashtable<String, Doc> docs;

	static {
		users = new Hashtable<String, User>();
		users.put("jack", new Operator("jack","123","operator"));
		users.put("rose", new Browser("rose","123","browser"));
		users.put("kate", new Administrator("kate","123","administrator"));
		Init();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis()); 
		docs = new Hashtable<String,Doc>();
		docs.put("0001",new Doc("0001","jack",timestamp,"Age Source Java","Age.java"));
		
		try {
			MySQLConnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//数据库链接
		public static void MySQLConnect() throws SQLException{
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("找不到驱动程序类，加载驱动失败！");
				e.printStackTrace();
			}
			String url = "jdbc:mysql://localhost:3306/dp" ;    
		     String username = "root" ;
		     String password = "583593" ;
		try{
			 con = DriverManager.getConnection(url , username , password ) ; 	  
		}catch(SQLException se){   
			System.out.println("数据库连接失败！");   
			se.printStackTrace() ;   
		     }   
		MySQLConnect=true;
		  System.out.println("数据库连接成功！");
		}
		
		
		public void disconnectFromDB() {
			if ( connectToDB ){
				// close Statement and Connection            
				try{
					rs.close();                        
				    st.close();                        
				    con.close();                       
				}catch ( SQLException sqlException ){                                            
				    sqlException.printStackTrace();           
				}finally{                                            
					connectToDB = false;              
				}                             
			} 
	   }      
		
		private static void setQuery(String query) throws SQLException, IllegalStateException{

			if ( !MySQLConnect)
				throw new IllegalStateException( "Not Connected to Database" );
			rs = st.executeQuery( query );
			metaData = rs.getMetaData();
			rs.last();             
			numberofRows = rs.getRow();  
	   } 
	
	public static  void Init(){
		// connect to database
		//con = DriverManager.getConnection( "url", "username", "password" );

		// create Statement to query database
		//st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );

		// update database connection status
//		if (Math.random()>0.3)
//			connectToDB = true;
//		else
//			connectToDB = false;
	}
	
	public static Doc searchDoc(String ID) throws SQLException,IllegalStateException {
		Doc temp = null;
		if (!MySQLConnect)
			 throw new IllegalStateException( "Not Connected to Database" );
		st =con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,
		         rs.CONCUR_READ_ONLY );
		String str="select * from doc where ID='"+ID+"'";
		rs = st.executeQuery(str);
		
		if (rs.next()){
			String id=rs.getString("ID");
			String creator=rs.getString("creator");
			Timestamp timestamp=rs.getTimestamp("time");
			String description=rs.getString("description");
			String filename=rs.getString("filename");
			temp=new Doc(id,creator, timestamp, description, filename);
		}
		
		return temp;
		
		//if (docs.containsKey(ID)) {
			//Doc temp =docs.get(ID);
			//return temp;
		//}
		//return null;
	}
	
	public static Enumeration<Doc> getAllDocs() throws SQLException,IllegalStateException{
		Vector <Doc> docs = new Vector<Doc>();
		Doc temp=null; 
		if ( !MySQLConnect ) 
	        throw new IllegalStateException( "Not Connected to Database" );
		
		st = con.createStatement( 
		         rs.TYPE_SCROLL_INSENSITIVE,
		         rs.CONCUR_READ_ONLY );
		String sql="select * from doc";
		rs = st.executeQuery(sql);
		
		while (rs.next()){
			String id=rs.getString("Id");
			String creator=rs.getString("creator");
			Timestamp timestamp=rs.getTimestamp("time");
			String description=rs.getString("description");
			String filename=rs.getString("filename");
			temp =new Doc(id,creator, timestamp, description, filename);
			docs.addElement(temp);
		}
		
		return docs.elements();	

		//Enumeration<Doc> e  = docs.elements();
		//return e;
	} 
	
	public static boolean insertDoc(String ID, String creator, Timestamp timestamp, String description, String filename) throws SQLException,IllegalStateException{
		if ( !MySQLConnect ) 
	        throw new IllegalStateException( "Not Connected to Database" );
		
		String sql = "INSERT INTO doc (ID,creator,time,description,filename) VALUES(?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, ID);
		ps.setString(2, creator);
		ps.setTimestamp(3, timestamp);
		ps.setString(4, description);
		ps.setString(5, filename);
		
		int temp =ps.executeUpdate();
		
		if (temp!=0)
			return true;
		else
			return false;
				
		//Doc doc;		
	
		//if (docs.containsKey(ID))
			//return false;
		//else{
			//doc = new Doc(ID,creator,timestamp,description,filename);
			//docs.put(ID, doc);
			//return true;
		//}
	} 
	
	
	public static User searchUser(String name, String password) throws SQLException,IllegalStateException {
		User temp= null;
		if ( !	MySQLConnect ) 
	        throw new IllegalStateException( "Not Connected to Database" );
		
		st = con.createStatement( 
		         rs.TYPE_SCROLL_INSENSITIVE,
		         rs.CONCUR_READ_ONLY );
		String sql="select * from user where username='"+name+"' and password='"+password+"'";
		rs = st.executeQuery(sql);
		
		if (rs.next()){
			String username=rs.getString("username");
			String pass=rs.getString("password");
			String role=rs.getString("role");
			
			if (role.equals("administrator")){
				temp = new Administrator(username,pass,role);
			}else if(role.equals("operator")){
				temp = new Operator(username,pass,role);
			}else
				temp = new Browser(username,pass,role);
				
		}
		
		return temp;
				
		}

	//		if ( !connectToDB ) 
//        throw new IllegalStateException( "Not Connected to Database" );
//
//	
//	if (Math.random()>0.7)
//		throw new SQLException( "Error in excecuting Query" );
//	
//	if (users.containsKey(name)) {
//		User temp =users.get(name);
	//	if ((temp.getPassword()).equals(password))
		//	return temp;
//	}
//	return null;

//}
	
	public static User searchUser(String name) throws SQLException,IllegalStateException {
		User temp= null;
		if ( !MySQLConnect ) 
	        throw new IllegalStateException( "Not Connected to Database" );
		
		st = con.createStatement( 
		        rs.TYPE_SCROLL_INSENSITIVE,
		         rs.CONCUR_READ_ONLY );
		String sql="select * from user where username='"+name+"'";
		rs = st.executeQuery(sql);
		
		if (rs.next()){
			String username=rs.getString("username");
			String password=rs.getString("password");
			String role=rs.getString("role");
			
			if (role.equals("administrator")){
				temp = new Administrator(username,password,role);
			}else if(role.equals("operator")){
				temp = new Operator(username,password,role);
			}else
				temp = new Browser(username,password,role);
				
		}
		
		return temp;
	}
		
	
	public static Enumeration<User> getAllUser() throws SQLException,IllegalStateException{
		Vector <User> users = new Vector<User>();
		User temp=null; 
		if ( !MySQLConnect ) 
	        throw new IllegalStateException( "Not Connected to Database" );
		
		st = con.createStatement( 
		         rs.TYPE_SCROLL_INSENSITIVE,
		         rs.CONCUR_READ_ONLY );
		String sql="select * from user";
		rs = st.executeQuery(sql);
		
		while (rs.next()){
			String username=rs.getString("username");
			String password=rs.getString("password");
			String role=rs.getString("role");
			
			if (role.equals("administrator")){
				temp = new Administrator(username,password,role);
			}else if(role.equals("operator")){
				temp = new Operator(username,password,role);
			}else
				temp = new Browser(username,password,role);
			
			users.addElement(temp);
		}
		
		return users.elements();	
//		if ( !connectToDB ) 
//	        throw new IllegalStateException( "Not Connected to Database" );
//		
//		if (Math.random()>0.7)
//			throw new SQLException( "Error in excecuting Query" );
		
		//Enumeration<User> e  = users.elements();
		//return e;
	}
	
	
	
	public static boolean updateUser(String name, String password, String role) throws SQLException,IllegalStateException{
		if ( !MySQLConnect ) 
	        throw new IllegalStateException( "Not Connected to Database" );
		
		String sql = "UPDATE user SET password=?, role=? where username=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, password);
		ps.setString(2, role);
		ps.setString(3, name);
		
		int temp =ps.executeUpdate();
		
		if (temp!=0)
			return true;
		else
			return false;
		//User user;
//		if ( !connectToDB ) 
//	        throw new IllegalStateException( "Not Connected to Database" );
//		
//		if (Math.random()>0.7)
//			throw new SQLException( "Error in excecuting Update" );
	//	if (users.containsKey(name)) {
		//	if (role.equalsIgnoreCase("administrator"))
			//	user = new Administrator(name,password, role);
		//	else if (role.equalsIgnoreCase("operator"))
		//		user = new Operator(name,password, role);
		//	else
			//	user = new Browser(name,password, role);
		//	users.put(name, user);
		//	return true;
		//}else
		//	return false;
	}
	
	public static boolean insertUser(String name, String password, String role) throws SQLException,IllegalStateException{
		//User user;
		
//		if ( !connectToDB ) 
//	        throw new IllegalStateException( "Not Connected to Database" );
//		
//		if (Math.random()>0.7)
//			throw new SQLException( "Error in excecuting Insert" );
		
		//if (users.containsKey(name))
		//	return false;
		//else{
		//	if (role.equalsIgnoreCase("administrator"))
			//	user = new Administrator(name,password, role);
			//else if (role.equalsIgnoreCase("operator"))
			//	user = new Operator(name,password, role);
			//else
			//	user = new Browser(name,password, role);
		//	users.put(name, user);
		//	return true;
		//}
		if ( !MySQLConnect ) 
	        throw new IllegalStateException( "Not Connected to Database" );
		
		String sql = "INSERT INTO user (username,password,role) VALUES(?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, password);
		ps.setString(3, role);

		
		int temp =ps.executeUpdate();
		
		if (temp!=0)
			return true;
		else
			return false;
				
	}
	
	public static boolean deleteUser(String name) throws SQLException,IllegalStateException{
//		if ( !connectToDB ) 
//	        throw new IllegalStateException( "Not Connected to Database" );
//		
//		if (Math.random()>0.7)
//			throw new SQLException( "Error in excecuting Delete" );
		
		//if (users.containsKey(name)){
			//users.remove(name);
			//return true;
		//}else
		//	return false;
		if ( !MySQLConnect ) 
	        throw new IllegalStateException( "Not Connected to Database" );
		
		String sql = "DELETE FROM  user where username=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, name);
				
		int temp =ps.executeUpdate();
		
		if (temp!=0)
			return true;
		else
			return false;
		
	}	
            
	

		

	
	public static void main(String[] args) {		
		Menu menu=new Menu();
    	try {
			MySQLConnect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			try {
				menu.MajorMenu();
			} catch (IllegalStateException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}

	
	
	
	
