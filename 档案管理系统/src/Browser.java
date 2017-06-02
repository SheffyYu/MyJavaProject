import java.sql.SQLException;
import java.util.*;
import java.io.*;

public class Browser extends User {
	public Scanner scan2=new Scanner(System.in);
	
	Browser(String name, String password, String role) {
		super(name, password, role);
		this.setRole("browser");
	}
	
   //下载文件
	public void downloadFile() throws IllegalStateException, SQLException, IOException{
		String id;
		Doc file;
	
		System.out.println("请选择文件号：");
		id=scan2.next();
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
		/*while (true) {
			int byteRead=fi.read(buf); //从文件读数据给字节数组
            if (byteRead==-1) //在文件尾，无数据可读
                break;  //退出循环           
            fo.write(buf,0,byteRead);  //将读到的数据写入目标文件
        }
        */
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
	
	//修改自己的密码
	public boolean  ChangeInfo(String name,String password,String role) throws IllegalStateException, SQLException{

		return (DataProcessing.updateUser(name, password, role));
	}
	
	//退出
   public void exitBrowser() throws IllegalStateException, SQLException{
	   Menu menu=new Menu();
		menu.MajorMenu();
	}
	
   //菜单
	public void ShowMenu() {
		int choose =999;
		System.out.println("************************欢迎进入浏览者菜单**************************");
		System.out.println("                                           1、下载文件");
		System.out.println("                                           2、文件列表");
		System.out.println("                                           3、修改密码");
		System.out.println("                                           0、退出");
		
		while(choose!=0){
		System.out.printf("请选择操作：");
	   choose = scan2.nextInt();
	   
		switch(choose){
		case 1:
			System.out.println("#下载文件#");
			try {
				downloadFile();
			} catch (IllegalStateException | SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 2:
			System.out.println("#文件列表#");
			showFileList();
			break;
			
		case 3:
			System.out.println("#修改密码#");
			System.out.println("请输入新密码：");
			String newpassword=null;
			scan2.nextLine();                                         //系统需要缓冲
			newpassword =  scan2.nextLine();
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
				exitBrowser();
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