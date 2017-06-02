import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.UIManager;

import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;


public class BrowserFace extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrowserFace frame = new BrowserFace();
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
	 */
	public BrowserFace() throws BadLocationException {
		setTitle("\u7528\u6237\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 370);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JPanel panel = new JPanel();
		panel.setBounds(117, 22, 296, 278);
		contentPane.add(panel);
		final CardLayout card = new CardLayout(0, 0);
		panel.setLayout(card);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 204));
		panel.add(panel_1, "panel_1");
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("\u4F60\u597D!");
		label.setForeground(new Color(0, 0, 153));
		label.setFont(new Font("幼圆", Font.BOLD, 20));
		label.setBounds(57, 86, 61, 31);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("\u4EB2\u7231\u7684\u7528\u6237");
		label_1.setFont(new Font("幼圆", Font.BOLD, 20));
		label_1.setForeground(new Color(0, 0, 153));
		label_1.setBounds(119, 139, 122, 23);
		panel_1.add(label_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 255, 204));
		panel.add(panel_2, "panel_2");
		panel_2.setLayout(null);
		
		JLabel label_2 = new JLabel("\u4E0B\u8F7D\u6587\u4EF6");
		label_2.setForeground(new Color(0, 0, 153));
		label_2.setFont(new Font("楷体", Font.BOLD, 20));
		label_2.setBounds(102, 23, 84, 24);
		panel_2.add(label_2);
		
		JLabel label_5 = new JLabel("\u6587\u4EF6\u53F7\uFF1A");
		label_5.setForeground(new Color(0, 0, 0));
		label_5.setFont(new Font("宋体", Font.BOLD, 13));
		label_5.setBounds(25, 95, 84, 15);
		panel_2.add(label_5);
		
	    //文件号文本框
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputID = textField_2.getText();
			}
		});
		textField_2.setBounds(102, 92, 115, 21);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		//下载按钮
		JButton button_3 = new JButton("\u4E0B\u8F7D");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id;
				Doc file = null;
                id= textField_2.getText();
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
		button_3.setForeground(Color.BLACK);
		button_3.setFont(new Font("宋体", Font.BOLD, 13));
		button_3.setBounds(102, 173, 84, 38);
		panel_2.add(button_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 255, 204));
		panel.add(panel_3, "panel_3");
		panel_3.setLayout(null);
		
		JLabel label_3 = new JLabel("\u6587\u4EF6\u5217\u8868");
		label_3.setForeground(new Color(0, 0, 153));
		label_3.setFont(new Font("楷体", Font.BOLD, 20));
		label_3.setBounds(96, 35, 84, 24);
		panel_3.add(label_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 67, 276, 201);
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		//文件列表文本区
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(204, 204, 255));
		textPane.setBounds(0, 0, 276, 201);
		panel_5.add(textPane);
		Document txt = textPane.getStyledDocument();  
		Enumeration<Doc> e  = DataProcessing.docs.elements();
		Doc doc;
		while(e.hasMoreElements() ){
			doc=e.nextElement();
			String text=("ID:"+doc.getID()+"  Creator:"+doc.getCreator()+"     Time:"+doc.getTimestamp()+"     Description:"+doc.getDescription()+"     Filename:"+doc.getFilename()+"\t");
			txt.insertString(txt.getLength(), text,null);//插入文字
			//System.out.println("ID:"+doc.getID()+"\t Creator:"+doc.getCreator()+"\t Time:"+doc.getTimestamp()+"\t Description:"+doc.getDescription()+"\t Filename:"+doc.getFilename());
		}
		textPane.setEditable(false); 
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 255, 204));
		panel.add(panel_4, "panel_4");
		panel_4.setLayout(null);
		
		JLabel label_4 = new JLabel("\u4FEE\u6539\u5BC6\u7801");
		label_4.setForeground(new Color(0, 0, 153));
		label_4.setFont(new Font("楷体", Font.BOLD, 20));
		label_4.setBounds(93, 31, 84, 24);
		panel_4.add(label_4);
		
		JLabel label_6 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label_6.setFont(new Font("宋体", Font.BOLD, 13));
		label_6.setBounds(35, 103, 68, 15);
		panel_4.add(label_6);
		
		//新密码文本框
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputNewPass = textField.getText();
			}
		});
		textField.setBounds(93, 100, 131, 21);
		panel_4.add(textField);
		textField.setColumns(10);
		
		//修改按钮
		JButton button_4 = new JButton("\u4FEE\u6539");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User man = null;
				try {
					man = DataProcessing.searchUser(FrameFace.textField.getText(),FrameFace.textField_1.getText());
				} catch (IllegalStateException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					DataProcessing.updateUser(man.name, textField.getText(),man.role);
				} catch (IllegalStateException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//返回
				card.show(panel,"panel_1");
			}
		});
		button_4.setBackground(UIManager.getColor("Button.light"));
		button_4.setFont(new Font("宋体", Font.BOLD, 13));
		button_4.setBounds(96, 165, 93, 31);
		panel_4.add(button_4);
		
		//文件列表按钮
		JButton button = new JButton("\u6587\u4EF6\u5217\u8868");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel,"panel_3");
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 13));
		button.setForeground(new Color(0, 0, 0));
		button.setBounds(0, 35, 93, 36);
		contentPane.add(button);
		
		//修改密码按钮
		JButton button_1 = new JButton("\u4FEE\u6539\u5BC6\u7801");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel,"panel_4");
			}
		});
		button_1.setFont(new Font("宋体", Font.BOLD, 13));
		button_1.setForeground(new Color(0, 0, 0));
		button_1.setBounds(0, 70, 93, 36);
		contentPane.add(button_1);
		
		//退出按钮
		JButton button_2 = new JButton("\u9000\u51FA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//返回上一页
				dispose();                    //关闭当前页面
				FrameFace aframe = new FrameFace();
				aframe.main(null);
			}
		});
		button_2.setForeground(new Color(0, 0, 0));
		button_2.setFont(new Font("宋体", Font.BOLD, 13));
		button_2.setBounds(0, 105, 93, 36);
		contentPane.add(button_2);
		
		//下载文件按钮
		JButton btnNewButton = new JButton("\u4E0B\u8F7D\u6587\u4EF6");
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel,"panel_2");
			}
		});
		btnNewButton.setBounds(0, 0, 93, 36);
		contentPane.add(btnNewButton);
	}

}
