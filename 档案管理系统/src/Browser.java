import java.sql.SQLException;
import java.util.*;
import java.io.*;

public class Browser extends User {
	public Scanner scan2=new Scanner(System.in);
	
	Browser(String name, String password, String role) {
		super(name, password, role);
		this.setRole("browser");
	}
	
   //�����ļ�
	public void downloadFile() throws IllegalStateException, SQLException, IOException{
		String id;
		Doc file;
	
		System.out.println("��ѡ���ļ��ţ�");
		id=scan2.next();
		//�ҵ�Doc�е��ļ�
		file=DataProcessing.searchDoc(id);
		//�����ļ���ָ��Ŀ¼
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
			int byteRead=fi.read(buf); //���ļ������ݸ��ֽ�����
            if (byteRead==-1) //���ļ�β�������ݿɶ�
                break;  //�˳�ѭ��           
            fo.write(buf,0,byteRead);  //������������д��Ŀ���ļ�
        }
        */
		fi.close();
		fo.close();
		System.out.println("���سɹ���");
	}

	//��ʾ�ļ��б�
	public void  showFileList(){
		Enumeration<Doc> e  = DataProcessing.docs.elements();
		Doc doc;
		while(e.hasMoreElements() ){
			doc=e.nextElement();
			System.out.println("ID:"+doc.getID()+"\t Creator:"+doc.getCreator()+"\t Time:"+doc.getTimestamp()+"\t Description:"+doc.getDescription()+"\t Filename:"+doc.getFilename());
		}
	}
	
	//�޸��Լ�������
	public boolean  ChangeInfo(String name,String password,String role) throws IllegalStateException, SQLException{

		return (DataProcessing.updateUser(name, password, role));
	}
	
	//�˳�
   public void exitBrowser() throws IllegalStateException, SQLException{
	   Menu menu=new Menu();
		menu.MajorMenu();
	}
	
   //�˵�
	public void ShowMenu() {
		int choose =999;
		System.out.println("************************��ӭ��������߲˵�**************************");
		System.out.println("                                           1�������ļ�");
		System.out.println("                                           2���ļ��б�");
		System.out.println("                                           3���޸�����");
		System.out.println("                                           0���˳�");
		
		while(choose!=0){
		System.out.printf("��ѡ�������");
	   choose = scan2.nextInt();
	   
		switch(choose){
		case 1:
			System.out.println("#�����ļ�#");
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
			System.out.println("#�ļ��б�#");
			showFileList();
			break;
			
		case 3:
			System.out.println("#�޸�����#");
			System.out.println("�����������룺");
			String newpassword=null;
			scan2.nextLine();                                         //ϵͳ��Ҫ����
			newpassword =  scan2.nextLine();
			try {
				super.setPassword(newpassword);
					ChangeInfo(this.getName(), newpassword, this.getRole());
			} catch (IllegalStateException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
			
  //�˳�
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