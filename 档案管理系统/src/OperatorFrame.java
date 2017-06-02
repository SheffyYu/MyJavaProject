import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.UIManager;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Enumeration;

import javax.swing.JTextPane;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;


public class OperatorFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperatorFrame frame = new OperatorFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws BadLocationException 
	 * @throws SQLException 
	 * @throws IllegalStateException 
	 */
	public OperatorFrame() throws BadLocationException, IllegalStateException, SQLException {
		setTitle("\u64CD\u4F5C\u5458\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 376);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JPanel panel = new JPanel();
		panel.setBounds(135, 28, 299, 285);
		contentPane.add(panel);
		final CardLayout card = new CardLayout(0, 0);
		panel.setLayout(card);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 204));
		panel.add(panel_1, "panel_1");
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("\u4F60\u597D\uFF01");
		label.setFont(new Font("幼圆", Font.BOLD, 18));
		label.setForeground(new Color(0, 0, 102));
		label.setBounds(58, 95, 101, 30);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("\u64CD\u4F5C\u5458");
		label_1.setForeground(new Color(0, 0, 153));
		label_1.setFont(new Font("幼圆", Font.BOLD, 18));
		label_1.setBounds(121, 135, 119, 40);
		panel_1.add(label_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 255, 204));
		panel.add(panel_2, "panel_2");
		panel_2.setLayout(null);
		
		JLabel label_2 = new JLabel("\u4E0A\u4F20\u6587\u4EF6");
		label_2.setForeground(new Color(0, 0, 153));
		label_2.setFont(new Font("楷体", Font.BOLD, 20));
		label_2.setBounds(105, 27, 94, 30);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("\u6E90\u6587\u4EF6\u540D\uFF1A");
		label_3.setFont(new Font("宋体", Font.BOLD, 12));
		label_3.setBounds(33, 74, 74, 30);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("\u6E90\u6587\u4EF6\u8DEF\u5F84\uFF1A");
		label_4.setFont(new Font("宋体", Font.BOLD, 12));
		label_4.setBounds(33, 114, 86, 26);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("\u6587\u4EF6\u53F7\uFF1A");
		label_5.setFont(new Font("宋体", Font.BOLD, 12));
		label_5.setBounds(33, 150, 74, 33);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("\u6587\u4EF6\u63CF\u8FF0\uFF1A");
		label_6.setFont(new Font("宋体", Font.BOLD, 12));
		label_6.setBounds(33, 193, 74, 30);
		panel_2.add(label_6);
		
		//源文件名文本框
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputFileName = textField.getText();
			}
		});
		textField.setBounds(107, 79, 115, 21);
		panel_2.add(textField);
		textField.setColumns(10);
		
		//源文件路径文本框
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputFileSrc = textField_1.getText();
			}
		});
		textField_1.setBounds(107, 114, 115, 21);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		//文件号文本框
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputID = textField_2.getText();
			}
		});
		textField_2.setBounds(105, 156, 117, 21);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		//文件描述文本框
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputFileDescription = textField_3.getText();
			}
		});
		textField_3.setBounds(105, 198, 117, 21);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		//上传按钮
		JButton button_5 = new JButton("\u4E0A\u4F20");
		button_5.addActionListener(new ActionListener() {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis()); 
			public void actionPerformed(ActionEvent e) {
				try {
					//源文件路径和文件名
					//System.out.println("请输入源文件的路径：");
					String FilePath = textField_1.getText();
				//	System.out.println("请输入源文件的文件名：");
					String FileName = textField.getText();
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
					System.out.println(DataProcessing.insertDoc(textField_2.getText(),FrameFace.textField.getText(), timestamp, textField_3.getText(),textField.getText()));
				} catch (IllegalStateException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				card.show(panel,"panel_1");
			}
		});
		button_5.setForeground(new Color(0, 0, 0));
		button_5.setFont(new Font("宋体", Font.BOLD, 13));
		button_5.setBounds(125, 239, 74, 36);
		panel_2.add(button_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 255, 204));
		panel.add(panel_3, "panel_3");
		panel_3.setLayout(null);
		
		JLabel label_7 = new JLabel("\u4E0B\u8F7D\u6587\u4EF6");
		label_7.setForeground(new Color(0, 0, 102));
		label_7.setFont(new Font("楷体", Font.BOLD, 20));
		label_7.setBounds(111, 30, 92, 21);
		panel_3.add(label_7);
		
		JLabel label_8 = new JLabel("\u6587\u4EF6\u53F7\uFF1A");
		label_8.setFont(new Font("宋体", Font.BOLD, 13));
		label_8.setBounds(36, 114, 69, 21);
		panel_3.add(label_8);
		
		//下载文件的文件号文本框
		textField_4 = new JTextField();
		textField_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputID = textField_4.getText();
			}
		});
		textField_4.setBounds(99, 114, 126, 21);
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		//下载按钮
		JButton button_6 = new JButton("\u4E0B\u8F7D");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id;
				Doc file = null;
                id= textField_4.getText();
				//找到Doc中的文件
				try {
					file=DataProcessing.searchDoc(id);
				} catch (IllegalStateException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//复制文件到指定目录
				File tempFile= new File("D:\\uploadfile",file.getFilename());
				File targetFile= new File("D:\\downloadfile",file.getFilename());
				if(! (targetFile.exists())){
					//System.out.println("!!!");
					try {
						targetFile.createNewFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
				
				BufferedInputStream fi = null;
				try {
					fi = new BufferedInputStream( new FileInputStream(tempFile));
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				BufferedOutputStream fo = null;
				try {
					fo = new BufferedOutputStream( new FileOutputStream(targetFile));
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				byte [] buf= new byte [1024];
				int a;
				try {
					while((a=fi.read(buf)) != -1){
						fo.write(buf,0,a);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//关闭文件
				try {
					fi.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					fo.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				card.show(panel,"panel_1");
			}
		});
		button_6.setBackground(UIManager.getColor("Button.light"));
		button_6.setFont(new Font("宋体", Font.BOLD, 13));
		button_6.setBounds(110, 182, 93, 35);
		panel_3.add(button_6);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 255, 204));
		panel.add(panel_4, "panel_4");
		panel_4.setLayout(null);
		
		JLabel label_9 = new JLabel("\u6587\u4EF6\u5217\u8868");
		label_9.setForeground(new Color(0, 0, 153));
		label_9.setFont(new Font("楷体", Font.BOLD, 20));
		label_9.setBounds(99, 23, 105, 30);
		panel_4.add(label_9);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 65, 279, 210);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		//文件清单文本框
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(204, 204, 255));
		textPane.setBounds(0, 0, 279, 210);
		panel_6.add(textPane);
		Document txt = textPane.getStyledDocument();  
		Enumeration<Doc> e  = DataProcessing.getAllDocs();
		Doc doc;
		while(e.hasMoreElements() ){
			doc=e.nextElement();
			String text=("ID:"+doc.getID()+"  Creator:"+doc.getCreator()+"     Time:"+doc.getTimestamp()+"     Description:"+doc.getDescription()+"     Filename:"+doc.getFilename()+"\t");
			txt.insertString(txt.getLength(), text,null);//插入文字
			//System.out.println("ID:"+doc.getID()+"\t Creator:"+doc.getCreator()+"\t Time:"+doc.getTimestamp()+"\t Description:"+doc.getDescription()+"\t Filename:"+doc.getFilename());
		}
		textPane.setEditable(false); 
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(204, 255, 204));
		panel.add(panel_5, "panel_5");
		panel_5.setLayout(null);
		
		JLabel label_10 = new JLabel("\u4FEE\u6539\u5BC6\u7801");
		label_10.setForeground(new Color(0, 0, 153));
		label_10.setFont(new Font("楷体", Font.BOLD, 20));
		label_10.setBounds(106, 35, 89, 28);
		panel_5.add(label_10);
		
		JLabel label_11 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label_11.setFont(new Font("宋体", Font.BOLD, 14));
		label_11.setBounds(40, 104, 77, 28);
		panel_5.add(label_11);
		
		//修改密码新密码文本框
		textField_5 = new JTextField();
		textField_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputNewPass = textField_5.getText();
			}
		});
		textField_5.setBounds(97, 108, 134, 21);
		panel_5.add(textField_5);
		textField_5.setColumns(10);
		
		//修改按钮
		JButton button_7 = new JButton("\u4FEE\u6539");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User man = null;
				try {
					man = DataProcessing.searchUser(FrameFace.textField.getText(),FrameFace.textField_1.getText());
				} catch (IllegalStateException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					DataProcessing.updateUser(man.name, textField_5.getText(),man.role);
				} catch (IllegalStateException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//返回
				card.show(panel,"panel_1");
			}
		});
		button_7.setBackground(UIManager.getColor("Button.light"));
		button_7.setFont(new Font("宋体", Font.BOLD, 14));
		button_7.setBounds(106, 182, 93, 35);
		panel_5.add(button_7);
		
		//上传文件按钮
		JButton button = new JButton("\u4E0A\u4F20\u6587\u4EF6");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel,"panel_2");
			}
		});
		button.setBackground(UIManager.getColor("Button.light"));
		button.setFont(new Font("宋体", Font.BOLD, 13));
		button.setBounds(0, 0, 93, 38);
		contentPane.add(button);
		
		//下载文件按钮
		JButton button_1 = new JButton("\u4E0B\u8F7D\u6587\u4EF6");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel,"panel_3");
			}
		});
		button_1.setBackground(UIManager.getColor("Button.light"));
		button_1.setFont(new Font("宋体", Font.BOLD, 13));
		button_1.setBounds(0, 35, 93, 38);
		contentPane.add(button_1);
		
		//文件列表按钮
		JButton button_2 = new JButton("\u6587\u4EF6\u5217\u8868");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel,"panel_4");
			}
		});
		button_2.setBackground(UIManager.getColor("Button.light"));
		button_2.setFont(new Font("宋体", Font.BOLD, 13));
		button_2.setBounds(0, 72, 93, 38);
		contentPane.add(button_2);
		
		//修改密码按钮
		JButton button_3 = new JButton("\u4FEE\u6539\u5BC6\u7801");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel,"panel_5");
			}
		});
		button_3.setBackground(UIManager.getColor("Button.light"));
		button_3.setFont(new Font("宋体", Font.BOLD, 13));
		button_3.setBounds(0, 108, 93, 38);
		contentPane.add(button_3);
		
		//退出按钮
		JButton button_4 = new JButton("\u9000\u51FA");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//返回上一页
				dispose();                    //关闭当前页面
				FrameFace aframe = new FrameFace();
				aframe.main(null);
			}
		});
		button_4.setBackground(UIManager.getColor("Button.light"));
		button_4.setFont(new Font("宋体", Font.BOLD, 13));
		button_4.setBounds(0, 143, 93, 38);
		contentPane.add(button_4);
	}
}
