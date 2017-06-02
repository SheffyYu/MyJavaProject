import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuBar;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenu;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.SystemColor;

import javax.swing.JMenuItem;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;


public class AdminiFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminiFrame frame = new AdminiFrame();
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
	public AdminiFrame() throws BadLocationException, IllegalStateException, SQLException {
		setTitle("\u7BA1\u7406\u5458\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 403);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JPanel panel = new JPanel();
		panel.setBounds(139, 31, 355, 296);
		contentPane.add(panel);
		final CardLayout card = new CardLayout(0, 0);
		panel.setLayout(card);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 255, 204));
		panel.add(panel_3, "panel_3");
		panel_3.setLayout(null);
		
		JLabel label_14 = new JLabel("\u4F60\u597D\uFF01");
		label_14.setForeground(new Color(0, 0, 102));
		label_14.setFont(new Font("幼圆", Font.BOLD, 17));
		label_14.setBounds(111, 103, 76, 26);
		panel_3.add(label_14);
		
		JLabel label_15 = new JLabel("\u7BA1\u7406\u5458");
		label_15.setForeground(new Color(0, 0, 102));
		label_15.setFont(new Font("幼圆", Font.BOLD, 17));
		label_15.setBounds(157, 139, 130, 40);
		panel_3.add(label_15);
		card.first(panel);
		
		//用户列表
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(204, 255, 204));
		panel.add(panel_6, "panel_6");
		panel_6.setLayout(null);
		
		JLabel label_13 = new JLabel("\u7528\u6237\u5217\u8868");
		label_13.setForeground(new Color(0, 0, 153));
		label_13.setFont(new Font("楷体", Font.BOLD, 20));
		label_13.setBounds(130, 39, 92, 29);
		panel_6.add(label_13);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(204, 255, 153));
		panel_7.setBounds(10, 90, 335, 181);
		panel_6.add(panel_7);
		panel_7.setLayout(null);
		
		//显示用户清单文本区
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("宋体", Font.PLAIN, 12));
		textPane.setBounds(0, 0, 342, 181);
		panel_7.add(textPane);
		textPane.setBackground(new Color(204, 204, 255));
		Document doc = textPane.getStyledDocument();  
	  // MutableAttributeSet set = new MutableAttributeSet();  
				Enumeration<User> e  = DataProcessing.getAllUser();
				User user;
				while(e.hasMoreElements() ){
					user=e.nextElement();
					String text=("Name:"+user.getName()+"      Password:"+user.getPassword()+"       Role:"+user.getRole()+"\n");
					doc.insertString(doc.getLength(), text,null);//插入文字
				}
				textPane.setEditable(false); 
		
		//新角色选择
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 255, 204));
		panel.add(panel_4, "panel_4");
		panel_4.setLayout(null);
		
		JLabel label_6 = new JLabel("\u4FEE\u6539\u7528\u6237");
		label_6.setForeground(new Color(0, 0, 153));
		label_6.setFont(new Font("楷体", Font.BOLD, 20));
		label_6.setBounds(124, 27, 115, 38);
		panel_4.add(label_6);
		
		//原用户名输入框
		textField_6 = new JTextField();
		textField_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String OldName = textField_6.getText();
			}
		});
		
		JLabel label_10 = new JLabel("\u539F\u7528\u6237\u540D\uFF1A");
		label_10.setFont(new Font("宋体", Font.BOLD, 13));
		label_10.setBounds(50, 85, 75, 26);
		panel_4.add(label_10);
		textField_6.setBounds(124, 88, 144, 21);
		panel_4.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label_8 = new JLabel("\u65B0 \u5BC6 \u7801\uFF1A");
		label_8.setFont(new Font("宋体", Font.BOLD, 13));
		label_8.setBounds(50, 127, 75, 26);
		panel_4.add(label_8);
		
		//新密码输入框
		textField_4 = new JTextField();
		textField_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NewPassword = textField_4.getText();
			}
		});
		textField_4.setBounds(124, 130, 144, 21);
		panel_4.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_9 = new JLabel("\u65B0 \u89D2 \u8272\uFF1A");
		label_9.setFont(new Font("宋体", Font.BOLD, 13));
		label_9.setBounds(50, 176, 75, 15);
		panel_4.add(label_9);
		
		
		//选择用户角色选择框
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(124, 173, 144, 21);
		panel_4.add(comboBox_1);
		comboBox_1.addItem("administrator");
		comboBox_1.addItem("operator");
		comboBox_1.addItem("browser");
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NewRole = (String) comboBox_1.getSelectedItem();
			}
		});
		
		//确认修改按钮
		JButton button_8 = new JButton("\u786E\u8BA4\u4FEE\u6539");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User man = null;
				try {
					man = DataProcessing.searchUser(textField_6.getText());
				} catch (IllegalStateException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					DataProcessing.updateUser(textField_6.getText(), textField_4.getText(),(String) comboBox_1.getSelectedItem());
				} catch (IllegalStateException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//返回
				card.first(panel);
			}
		});
		button_8.setForeground(Color.BLACK);
		button_8.setFont(new Font("宋体", Font.BOLD, 13));
		button_8.setBounds(146, 215, 93, 36);
		panel_4.add(button_8);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(204, 255, 204));
		panel.add(panel_5, "panel_5");
		panel_5.setLayout(null);
		
		JLabel label_11 = new JLabel("\u5220\u9664\u7528\u6237");
		label_11.setForeground(new Color(0, 0, 153));
		label_11.setFont(new Font("楷体", Font.BOLD, 20));
		label_11.setBounds(134, 37, 94, 24);
		panel_5.add(label_11);
		
		JLabel label_12 = new JLabel("\u7528\u6237\u540D\uFF1A");
		label_12.setFont(new Font("宋体", Font.BOLD, 13));
		label_12.setBounds(62, 104, 68, 24);
		panel_5.add(label_12);
		
		//删除用户用户名输入框
		textField_5 = new JTextField();
		textField_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputName = textField_5.getText();
				
			}
		});
		textField_5.setBounds(113, 106, 149, 21);
		panel_5.add(textField_5);
		textField_5.setColumns(10);
		
		//确认删除按钮
		JButton button_9 = new JButton("\u786E\u8BA4\u5220\u9664");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataProcessing.deleteUser(textField_5.getText());
				} catch (IllegalStateException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button_9.setBackground(UIManager.getColor("Button.light"));
		button_9.setFont(new Font("宋体", Font.BOLD, 13));
		button_9.setBounds(135, 180, 93, 36);
		panel_5.add(button_9);
		
		
		
		final JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 204));
		panel.add(panel_1, "panel_1");
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("\u4FEE\u6539\u5BC6\u7801");
		label.setForeground(new Color(0, 0, 153));
		label.setFont(new Font("楷体", Font.BOLD, 20));
		label.setBounds(137, 10, 86, 44);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("宋体", Font.BOLD, 14));
		label_1.setBounds(63, 99, 70, 23);
		panel_1.add(label_1);
		
		//输入新密码
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NewPass = textField.getText();
			}
		});
		textField.setBounds(121, 99, 150, 22);
		panel_1.add(textField);
		textField.setColumns(10);
		
		//修改密码内确认按钮
		JButton button_6 = new JButton("\u4FEE\u6539");
		button_6.setBackground(UIManager.getColor("Button.light"));
		button_6.addActionListener(new ActionListener() {
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
			card.first(panel);
			}
		});
		button_6.setForeground(Color.BLACK);
		button_6.setFont(new Font("宋体", Font.BOLD, 13));
		button_6.setBounds(137, 184, 93, 38);
		panel_1.add(button_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 255, 204));
		panel.add(panel_2, "panel_2");
		panel_2.setLayout(null);
		
		JLabel label_2 = new JLabel("\u6DFB\u52A0\u7528\u6237");
		label_2.setForeground(new Color(0, 0, 153));
		label_2.setFont(new Font("楷体", Font.BOLD, 20));
		label_2.setBounds(136, 28, 104, 24);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("\u65B0\u7528\u6237\uFF1A");
		label_3.setFont(new Font("宋体", Font.BOLD, 15));
		label_3.setBounds(51, 74, 73, 24);
		panel_2.add(label_3);
		
		//添加新用户
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NewUser = textField_1.getText();
			}
		});
		textField_1.setBounds(119, 76, 150, 21);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_4 = new JLabel("\u5BC6  \u7801\uFF1A");
		label_4.setFont(new Font("宋体", Font.BOLD, 15));
		label_4.setBounds(51, 108, 76, 29);
		panel_2.add(label_4);
		
		//添加密码
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NewPass = textField_2.getText();
			}
		});
		textField_2.setBounds(119, 112, 150, 21);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		
		//选择角色按钮
		final JComboBox<String> comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NewRole = (String) comboBox.getSelectedItem();
			}
		});
		
		//添加按钮
		JButton button_7 = new JButton("\u6DFB\u52A0");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*User man = null;
				try {
					man = DataProcessing.searchUser(FrameFace.textField.getText(),FrameFace.textField_1.getText());
				} catch (IllegalStateException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}*/
				try {
					DataProcessing.insertUser(textField_1.getText(), textField_2.getText(),(String) comboBox.getSelectedItem());
					System.out.println("执行插入");
				} catch (IllegalStateException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//返回
				card.show(panel,"panel_3");
			}
		});
		
		comboBox.setBounds(119, 150, 150, 21);
		panel_2.add(comboBox);
		comboBox.addItem("administrator");
		comboBox.addItem("operator");
		comboBox.addItem("browser");
		button_7.setFont(new Font("宋体", Font.BOLD, 12));
		button_7.setBackground(UIManager.getColor("Button.light"));
		button_7.setBounds(147, 206, 93, 34);
		panel_2.add(button_7);
		
		JLabel label_5 = new JLabel("\u89D2  \u8272\uFF1A");
		label_5.setFont(new Font("宋体", Font.BOLD, 15));
		label_5.setBounds(51, 147, 73, 26);
		panel_2.add(label_5);
		
		//修改密码按钮
		JButton button_4 = new JButton("\u4FEE\u6539\u5BC6\u7801");
		button_4.setBounds(0, 124, 93, 34);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel,"panel_1");
			}
		});
		button_4.setBackground(UIManager.getColor("Button.light"));
		button_4.setFont(new Font("宋体", Font.BOLD, 12));
		contentPane.add(button_4);
		
		//退出按钮
		JButton button_5 = new JButton("\u9000\u51FA");
		button_5.setBounds(0, 156, 93, 34);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//返回上一页
				dispose();                    //关闭当前页面
				FrameFace aframe = new FrameFace();
				aframe.main(null);
			}
		});
		button_5.setFont(new Font("宋体", Font.BOLD, 12));
		button_5.setBackground(UIManager.getColor("Button.light"));
		contentPane.add(button_5);
		
		//添加用户按钮
		JButton button = new JButton("\u6DFB\u52A0\u7528\u6237");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel,"panel_2");
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 12));
		button.setBounds(0, 0, 93, 34);
		contentPane.add(button);
		
		//修改用户按钮
		JButton button_1 = new JButton("\u4FEE\u6539\u7528\u6237");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel,"panel_4");
			}
		});
		button_1.setFont(new Font("宋体", Font.BOLD, 12));
		button_1.setBounds(0, 31, 93, 34);
		contentPane.add(button_1);
		
		//删除用户按钮
		JButton button_2 = new JButton("\u5220\u9664\u7528\u6237");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel,"panel_5");
			}
		});
		button_2.setFont(new Font("宋体", Font.BOLD, 12));
		button_2.setBounds(0, 62, 93, 34);
		contentPane.add(button_2);
		
		//用户列表
		JButton button_3 = new JButton("\u7528\u6237\u5217\u8868");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel,"panel_6");
			}
		});
		button_3.setFont(new Font("宋体", Font.BOLD, 12));
		button_3.setBounds(0, 93, 93, 34);
		contentPane.add(button_3);
		
	}
}
