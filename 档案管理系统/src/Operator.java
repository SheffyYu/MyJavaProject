import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.Scanner;

public class Operator extends User{
	public Scanner scan3=new Scanner(System.in);
	
	Operator(String name, String password, String role) {
		super(name, password, role);
		this.setRole("operator");
	}
	
    //上传文件
	public void uploadFile() throws IOException, IllegalStateException, SQLException{
		String FileName = null;
		String FilePath = "";
		String id = null;
		String Desciption = null;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis()); 
		
		//源文件路径和文件名
		System.out.println("请输入源文件的路径：");
		FilePath = scan3.next();
		System.out.println("请输入源文件的文件名：");
		FileName = scan3.next();
		File uploadFile = new File (FilePath,FileName);
		//目标文件路径
		File targetFile = new File ("D:\\uploadfile",FileName);
	
		if(! (targetFile.exists())){
			targetFile.createNewFile();	
		}
		
		BufferedInputStream fi = new BufferedInputStream ( new FileInputStream(uploadFile));
		BufferedOutputStream  fo = new BufferedOutputStream ( new FileOutputStream(targetFile));
		byte [] buf= new byte [1024];
		int a;
		while((a=fi.read(buf)) != -1){
			fo.write(buf,0,a);
		}
		fi.close();
		fo.close();
		
		//在Doc中添加上传文件的信息
		
		System.out.println("请输入添加的新文件的文件号：");
		id = scan3.next();
		System.out.println("请输入新文件的描述：");
		Desciption = scan3.next();
		DataProcessing.insertDoc(id, this.getName(), timestamp, Desciption, FileName);
		
		System.out.println("上传成功！");
	}
	
	  //下载文件
		public void downloadFile() throws IllegalStateException, SQLException, IOException{
			String id;
			Doc file;
		
			System.out.println("请选择文件号：");
			id=scan3.next();
			//找到Doc中的文件
			file=DataProcessing.searchDoc(id);
			//复制文件到指定目录
			File tempFile= new File("D:\\uploadfile",file.getFilename());
			File targetFile= new File("D:\\downloadfile",file.getFilename());
			if(! (targetFile.exists())){
				//System.out.println("!!!");
				targetFile.createNewFile();	
			}
			
			BufferedInputStream fi = new BufferedInputStream( new FileInputStream(tempFile));
			BufferedOutputStream  fo = new BufferedOutputStream( new FileOutputStream(targetFile));
			byte [] buf= new byte [1024];
			int a;
			while((a=fi.read(buf)) != -1){
				fo.write(buf,0,a);
			}
			//关闭文件
			fi.close();
			fo.close();
			System.out.println("下载成功！");
		}

	
   //显示文件列表
	public void  showFileList(){
		Enumeration<Doc> e  = DataProcessing.docs.elements();
		Doc doc;
		while(e.hasMoreElements() ){
			doc=e.nextElement();
			System.out.println("ID:"+doc.getID()+"\t Creator:"+doc.getCreator()+"\t Time:"+doc.getTimestamp()+"\t Description:"+doc.getDescription()+"\t Filename:"+doc.getFilename());
		}
	}
	
	//退出
	public void exitOperator() throws IllegalStateException, SQLException{
		Menu menu=new Menu();
		menu.MajorMenu();
	}
	
	//修改自己的密码
	public boolean  ChangeInfo(String name,String password,String role) throws IllegalStateException, SQLException{

		return (DataProcessing.updateUser(name, password, role));
	}
	
	public void ShowMenu() {
		int choose=999;
		System.out.println("************************欢迎进入录入员菜单**************************");
		System.out.println("                                           1、上传文件");
		System.out.println("                                           2、下载文件");
		System.out.println("                                           3、文件列表");
		System.out.println("                                           4、修改密码");
		System.out.println("                                           0、退出");
		while(choose!=0){
		System.out.printf("请选择操作：");
	    choose = scan3.nextInt();
		switch(choose){
		case 1:
			System.out.println("#上传文件#");
			
			try {
				uploadFile();
			} catch (IOException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.println("#下载文件#");
			try {
				downloadFile();
			} catch (IllegalStateException | SQLException | IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break;
		case 3:
			System.out.println("#文件列表#");
			showFileList();
			break;
		case 4:
			System.out.println("#修改密码#");
			System.out.println("请输入新密码：");
			String newpassword=null;
			scan3.nextLine();
			newpassword =  scan3.nextLine();
			try {
				super.setPassword(newpassword);
					ChangeInfo(this.getName(), newpassword, this.getRole());
			} catch (IllegalStateException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
			//退出
		case 0:
			try {
				exitOperator();
			} catch (IllegalStateException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		System.out.println("\n");
		}
	}
	
}