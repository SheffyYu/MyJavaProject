/**
 *Tile: FileEditor
 *Description: ʵ��¥ʵ��֮���±�
 * @author Sheffy
 * @date 2017��3��9�� {time}
 *Problems:1���ı�����û�й�����--�ѽ������JTextArea����TextArea
 *         2��ֻ�ܶ������һ��--�ѽ��
 *         3������ֱ�Ӳ��ô��ļ��Ի���ķ�ʽ���ļ�--�ѽ�����ɲ�������·���ʹ򿪶Ի���ķ�ʽ���ļ�
 */
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.io.*;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import java.awt.SystemColor;

/**
 *Class Name: FileEditor
 *Description: 
 * @author Sheffy
 * @date 2017��3��9�� {time}
 */
public class FileEditor extends JFrame {

	/**
	 *Title:
	 *Description: 
	 * @author Sheffy
	 * @date 2017��3��13�� {time}
	 *Problems:
	 */
	private static final long serialVersionUID = 5366318700755219138L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnSave;
	private TextArea textArea;
	private JButton btnBrowser;
	private int level=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileEditor frame = new FileEditor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FileEditor() {
		setBackground(Color.DARK_GRAY);
		setTitle("Editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 484, 41);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//·����ť
		btnBrowser = new JButton("Browser");
		btnBrowser.setBackground(SystemColor.info);
		btnBrowser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				FileEditor.this.level=0;
				String path=textField.getText();
				//���Ŀ¼���ļ�
				System.out.println(path);
				//����������ʽƥ��·��
			    openDirOrFile(path.replace("//", "\\\\"));
			}
		});
		btnBrowser.setBounds(387, 10, 87, 24);
		panel.add(btnBrowser);
		
		textField = new JTextField();
		textField.setBounds(10, 10, 367, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(0, 43, 484, 418);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		//���水ť
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFile();
			}
		});
		btnSave.setBackground(SystemColor.info);
		btnSave.setBounds(397, 385, 77, 23);
		panel_1.add(btnSave);
		
		
		
		textArea = new TextArea();
		textArea.setBounds(10, 10, 464, 358);
		panel_1.add(textArea);
	}
	
	/**
	 *��������saveFile
	 *���ܣ������ļ�
	 *���ã�
	 *�����ã�FileEditor()
	 *�޸ļ�¼��
	 */
	private void saveFile(){
		FileDialog fDialog=new FileDialog(this,"Save File");//���������ļ��ĶԻ���
		
		fDialog.setFile("untitle.txt");//Ĭ���ļ�����
		
		fDialog.setMode(FileDialog.SAVE);
		fDialog.setVisible(true);
		
		String filenameString=fDialog.getFile();
		
		String dirString =fDialog.getDirectory();
		
		File newFile=new File(dirString+File.separator+filenameString);
		PrintWriter pWriter=null;
		try {
			pWriter=new PrintWriter(new OutputStreamWriter(new FileOutputStream(newFile)));
		    String string=textArea.getText();
		    pWriter.println(string);
		    pWriter.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pWriter.close();
		}
		textArea.setText("");
		textField.setText("");
	}
	
	/**
	 *��������openDirOrFile
	 *���ܣ����ļ�
	 *���ã�showDir
	 *�����ã�FileEditor()
	 *�޸ļ�¼��
	 */
	private void openDirOrFile(String DirPath) {
		if(DirPath.equalsIgnoreCase("")){
			FileDialog fDialog=new FileDialog(this,"Open File");//���������ļ��ĶԻ���
			
			fDialog.setMode(FileDialog.LOAD);
			fDialog.setVisible(true);
			
			String filenameString=fDialog.getFile();
			
			String dirString =fDialog.getDirectory();
			
			DirPath=dirString+File.separator+filenameString;
			
			textField.setText(DirPath);
		}
		
		File file=new File(DirPath);
		
		if(!(file.exists())){
			textArea.setText("�ļ������ڣ�");
		}else if(file.isDirectory()){
			textArea.setText(null);
			showDir(file);
		}else if(file.isFile()){
			try {
				String text="";
				FileInputStream fis=new FileInputStream(file);
				BufferedReader bReader=new BufferedReader(new InputStreamReader(fis));
				String string=null;
				textArea.setText(null);
				while((string=bReader.readLine())!=null){
					//�����ļ��е���������
					text=text+string+"\r\n";
					textArea.setText(text);
				}
				bReader.close();
				fis.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	/**
	 *��������showDir
	 *���ܣ�
	 *���ã�
	 *�����ã�openDirOrFile
	 *�޸ļ�¼��
	 * @param file
	 */
	private void showDir(File directory) {
		File[] files=directory.listFiles();
		int len=files.length;
		for(int i=0;i<len;i++){
			if(files[i].isDirectory()){
				for(int j=0;j<this.level;j++){
					//���ı���������׷������  
					textArea.append(" ");
				}
				textArea.append("|--"+files[i].getName()+"(Folder)\r\n");;
				this.level++;
				showDir(files[i]);
				this.level--;
			}else if(files[i].isFile()){
				for(int j=0;j<this.level;j++)
				{
					textArea.append(" ");
				}
				textArea.append("|--"+files[i].getAbsolutePath()+"\r\n");
			}
		}
	}
}

