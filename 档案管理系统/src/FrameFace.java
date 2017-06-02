import java.awt.*;
import java.awt.Event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Scanner;


public class FrameFace extends JFrame {

public static Scanner scan=new Scanner(System.in);

	private JPanel contentPane;
	private JLabel label_1;
	private JButton button;
	private JButton button_1;
	static JTextField textField;
	static JTextField textField_1;

	/**
	 *  
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DataProcessing.MySQLConnect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameFace frame = new FrameFace();
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
	public FrameFace() {
	
		setTitle("\u6863\u6848\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setForeground(new Color(0, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label_1 = new JLabel("\u6B22\u8FCE\u8FDB\u5165\u6863\u6848\u7BA1\u7406\u7CFB\u7EDF");
		label_1.setForeground(new Color(0, 0, 205));
		label_1.setFont(new Font("楷体", Font.BOLD, 20));
		label_1.setLabelFor(label_1);
		label_1.setBounds(113, 38, 222, 28);
		contentPane.add(label_1);
		
	//退出
		button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_1.setBackground(new Color(176, 224, 230));
		button_1.setFont(new Font("宋体", Font.BOLD, 15));
		button_1.setBounds(246, 179, 76, 35);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setFont(new Font("宋体", Font.BOLD, 14));
		label.setBounds(113, 87, 54, 15);
		contentPane.add(label);
		//用户名
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputName = textField.getText();
			}
		});
		textField.setBounds(163, 84, 158, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u53E3  \u4EE4");
		label_2.setFont(new Font("宋体", Font.BOLD, 14));
		label_2.setBounds(113, 126, 54, 15);
		contentPane.add(label_2);
		//口令
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputPass = textField_1.getText();
			}
		});
		textField_1.setBounds(163, 123, 159, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		//登陆
		button = new JButton("\u767B\u9646");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User man = null;
				   try {
					man = DataProcessing.searchUser(textField.getText(),textField_1.getText());
					 dispose();                    //关闭当前页面
					  //跳转到管理员界面
					  System.out.println("role="+man.getRole()+man.getName()+man.getPassword());
					   if ( man.getRole().equals( "administrator" )) {
			             AdminiFrame aframe;
						try {
							try {
								aframe = new AdminiFrame();
							} catch (IllegalStateException | SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} catch (BadLocationException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			             AdminiFrame.main(null);
					   }
					    if  (man.getRole().equals ("operator"))
					   {
						   OperatorFrame oframe;
						try {
							oframe = new OperatorFrame();
						} catch (BadLocationException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						   OperatorFrame.main(null);
					   }
					    if  (man.getRole().equals ("browser"))
					   {
						   BrowserFace bframe;
						try {
							bframe = new BrowserFace();
						} catch (BadLocationException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						   BrowserFace.main(null);
					   }
				} catch (IllegalStateException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				   /*
				   try {
					User.MySQLConnect();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				  */
				 
			}
		});
		button.setBackground(new Color(176, 224, 230));
		button.setToolTipText("");
		button.setForeground(new Color(0, 0, 0));
		button.setFont(new Font("宋体", Font.BOLD, 15));
		button.setBounds(146, 179, 76, 35);
		contentPane.add(button);
		
		
	}
}
