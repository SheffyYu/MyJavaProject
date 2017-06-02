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
	
    //�ϴ��ļ�
	public void uploadFile() throws IOException, IllegalStateException, SQLException{
		String FileName = null;
		String FilePath = "";
		String id = null;
		String Desciption = null;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis()); 
		
		//Դ�ļ�·�����ļ���
		System.out.println("������Դ�ļ���·����");
		FilePath = scan3.next();
		System.out.println("������Դ�ļ����ļ�����");
		FileName = scan3.next();
		File uploadFile = new File (FilePath,FileName);
		//Ŀ���ļ�·��
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
		
		//��Doc������ϴ��ļ�����Ϣ
		
		System.out.println("��������ӵ����ļ����ļ��ţ�");
		id = scan3.next();
		System.out.println("���������ļ���������");
		Desciption = scan3.next();
		DataProcessing.insertDoc(id, this.getName(), timestamp, Desciption, FileName);
		
		System.out.println("�ϴ��ɹ���");
	}
	
	  //�����ļ�
		public void downloadFile() throws IllegalStateException, SQLException, IOException{
			String id;
			Doc file;
		
			System.out.println("��ѡ���ļ��ţ�");
			id=scan3.next();
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
			//�ر��ļ�
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
	
	//�˳�
	public void exitOperator() throws IllegalStateException, SQLException{
		Menu menu=new Menu();
		menu.MajorMenu();
	}
	
	//�޸��Լ�������
	public boolean  ChangeInfo(String name,String password,String role) throws IllegalStateException, SQLException{

		return (DataProcessing.updateUser(name, password, role));
	}
	
	public void ShowMenu() {
		int choose=999;
		System.out.println("************************��ӭ����¼��Ա�˵�**************************");
		System.out.println("                                           1���ϴ��ļ�");
		System.out.println("                                           2�������ļ�");
		System.out.println("                                           3���ļ��б�");
		System.out.println("                                           4���޸�����");
		System.out.println("                                           0���˳�");
		while(choose!=0){
		System.out.printf("��ѡ�������");
	    choose = scan3.nextInt();
		switch(choose){
		case 1:
			System.out.println("#�ϴ��ļ�#");
			
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
			System.out.println("#�����ļ�#");
			try {
				downloadFile();
			} catch (IllegalStateException | SQLException | IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break;
		case 3:
			System.out.println("#�ļ��б�#");
			showFileList();
			break;
		case 4:
			System.out.println("#�޸�����#");
			System.out.println("�����������룺");
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
			//�˳�
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