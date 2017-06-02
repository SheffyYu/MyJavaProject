/**
 *Tile: bridgeFrame
 *Description: �������̰�ȫԤ��
 * @author Sheffy
 * @date 2016��9��26�� {time}
 *Problems:
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JButton;


public class bridgeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	//��������Ӷ�
	private double maxDeflection;
	
	//����羶
	private static double span;
	
	//����
	private static double cantilever;
	
	//�۶�����Ӷ�
	private double maxArmDef;
	private JTextField textField_3;
	private JTextField textField_4;
	
	//�ѷ쳤
	private double fissureLen;
	
	//�ѷ��
	private double fissureWid;
	
	//����ߴ�
	private static double SectDim;
	
	//��ֵ
	private static double Wel;
	

	/**
	 *Class Name: bridgeFrame
	 *Description: 
	 * @author Sheffy
	 * @date 2016��9��26�� {time}
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bridgeFrame frame = new bridgeFrame();
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
	public bridgeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 490);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6320\u5EA6\u9884\u8B66");
		label.setBounds(20, 20, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8DE8\u4E2D\u6700\u5927\u6320\u5EA6\uFF1A");
		label_1.setBounds(20, 56, 99, 15);
		contentPane.add(label_1);
		
		//��������Ӷ�
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String input=event.getActionCommand();
				maxDeflection=Integer.valueOf(input).intValue();
			}
		});
		textField.setBounds(135, 53, 107, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u60AC\u81C2\u7AEF\u6700\u5927\u6320\u5EA6\uFF1A");
		lblNewLabel.setBounds(20, 94, 96, 15);
		contentPane.add(lblNewLabel);
		
		//�۶�����Ӷ�
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String input=event.getActionCommand();
				maxArmDef=Integer.valueOf(input).intValue();
			}
		});
		textField_1.setBounds(135, 91, 107, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		
	/*****************************************************************************************/	
		
		
	
		JLabel label_2 = new JLabel("\u9884\u8B66\u7EA7\u522B\uFF1A");
		label_2.setBounds(20, 125, 85, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u6865\u53F0\u57FA\u7840\u88C2\u7F1D");
		label_3.setBounds(20, 212, 99, 15);
		contentPane.add(label_3);
		
		//�쳤
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String input=event.getActionCommand();
				fissureLen=Integer.valueOf(input).intValue();
			}
		});
		textField_3.setBounds(135, 247, 107, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("\u7F1D\u957F\uFF1A");
		label_4.setBounds(20, 250, 54, 15);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u7F1D\u5BBD\uFF1A");
		label_5.setBounds(20, 296, 54, 15);
		contentPane.add(label_5);
		
		//�ѷ��
		textField_4 = new JTextField();
		textField_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String input=event.getActionCommand();
				fissureWid=Integer.valueOf(input).intValue();
			}
		});
		textField_4.setColumns(10);
		textField_4.setBounds(135, 293, 107, 21);
		contentPane.add(textField_4);
		
		JLabel label_6 = new JLabel("\u9884\u8B66\u7EA7\u522B\uFF1A");
		label_6.setBounds(20, 339, 85, 15);
		contentPane.add(label_6);
		
		//ȷ����ˢ�£������
		JButton btnQueding = new JButton("ȷ��");
		btnQueding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDef();
				showAbutBasic();
				contentPane.repaint();
			}
		});
		btnQueding.setBounds(78, 388, 93, 23);
		contentPane.add(btnQueding);
	}
	
	/**
	 *��������judgeDef
	 *���ܣ��ж��Ӷȵ�Ԥ������
	 *���ã�
	 *�����ã�
	 *�޸ļ�¼��
	 * @return Ԥ������ grade
	 */
	public int judgeDef(){
		int grade=0;
		span=100;
		cantilever=100;
		//��ɫԤ��
		if((maxDeflection > span/1000 && maxDeflection <= span/600) || 
				(maxArmDef > cantilever/600 && maxArmDef <= cantilever/300)){
			grade=4;
		}//��ɫԤ��
		else if(maxDeflection > span/600 || maxArmDef > cantilever/300){
			grade=5;
		}//��ɫ
		else if(maxDeflection < span/1000 || maxArmDef < cantilever/600){
			grade=3;
		}
		else {
			grade=1;
		}	
		
		return grade;
	}
	
	public void showDef(){
		int result = judgeDef();
		if(result == 3){
			final JLabel lblNewLabel_1 = new JLabel("��ɫԤ��");
			lblNewLabel_1.setBounds(135, 125, 107, 15);
			contentPane.add(lblNewLabel_1);
		}
		else if(result == 4){
			final JLabel lblNewLabel_1 = new JLabel("��ɫԤ��");
			lblNewLabel_1.setBounds(135, 125, 107, 15);
			contentPane.add(lblNewLabel_1);
		}
		else if(result == 5){
			final JLabel lblNewLabel_1 = new JLabel("��ɫԤ��");
			lblNewLabel_1.setBounds(135, 125, 107, 15);
			contentPane.add(lblNewLabel_1);
		}
		else{
			final JLabel lblNewLabel_1 = new JLabel("��ȫ");
			lblNewLabel_1.setBounds(135, 125, 107, 15);
			contentPane.add(lblNewLabel_1);
		}
		
	}
	
	
	/**
	 *��������judgeAbutBasic
	 *���ܣ��ж���̨����Ԥ������
	 *���ã�
	 *�����ã�
	 *�޸ļ�¼��
	 * @return grade
	 */
	public int judgeAbutBasic(){
		int grade=0;
		
		SectDim=1;
		Wel=1;
		
		//��ɫԤ��
		if(fissureLen <= SectDim/3 && fissureLen >0){
			grade=2;
		}//��ɫԤ��
		else if(fissureLen <= SectDim/2 && fissureLen > SectDim/3){
			grade=3;
		}//��ɫԤ��
		else if(fissureLen > SectDim/2 || (fissureWid > Wel && fissureWid <= 1)){
			grade=4;
		}//��ɫԤ��
		else if(fissureLen > SectDim/2 || fissureWid > 1){
			grade=5;
		}
		else {
			grade=1;
		}
		
		return grade;
	}
	
	public void showAbutBasic(){
		int result = judgeAbutBasic();
		if(result == 2){
			final JLabel label_7 = new JLabel("��ɫԤ��");
			label_7.setBounds(135, 339, 107, 15);
			contentPane.add(label_7);
		}
		else if(result == 3){
			final JLabel label_7 = new JLabel("��ɫԤ��");
			label_7.setBounds(135, 339, 107, 15);
			contentPane.add(label_7);
		}
		else if(result == 4){
			final JLabel label_7 = new JLabel("��ɫԤ��");
			label_7.setBounds(135, 339, 107, 15);
			contentPane.add(label_7);
		}
		else if(result == 5){
			final JLabel label_7 = new JLabel("��ɫԤ��");
			label_7.setBounds(135, 339, 107, 15);
			contentPane.add(label_7);
		}
		else{
			final JLabel label_7 = new JLabel("��ȫ");
			label_7.setBounds(135, 339, 107, 15);
			contentPane.add(label_7);
		}
	}
}


