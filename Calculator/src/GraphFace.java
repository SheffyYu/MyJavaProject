//filename:GraphFace.java 
//included file Caculator
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

//界面设置
public class GraphFace extends JFrame{
	 JPanel panel1,panel2;
	 JTextField text;
	 private boolean start;
	 private String lastCommand;
	  private double result;
	//创建顶层容器-最外层窗口
	public static final int DEFAULT_WIDTH=220;   //窗口默认宽度	
    public static final int DEFAULT_HEIGHT=280;  //窗口默认高度
	
	public GraphFace(){
		start=true;
		lastCommand="=";
		result=0.0;
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		setTitle("计算器");
		
	    panel1=new JPanel();
	    panel2=new JPanel();
	    getContentPane().add(panel1,"North");
	    getContentPane().add(panel2,"Center");
	    text=new JTextField(17);
	    text.setHorizontalAlignment(JTextField.RIGHT);
	    text.setEditable(false);
	    panel1.add(text);
	    panel2.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
	    
	    ActionListener insert=new InsertAction();
	    ActionListener command=new CommandAction();
	    
	    addButton("1",insert);
	    addButton("2",insert);
	    addButton("3",insert);
	    addButton("+",command);
	    addButton("4",insert);
	    addButton("5",insert);
	    addButton("6",insert);
	    addButton("-",command);
	    addButton("7",insert);
	    addButton("8",insert);
	    addButton("9",insert);
	    addButton("*",command);
	    addButton("0",insert);
	    addButton(".",insert);
	    addButton("=",command);
	    addButton("/",command);
	    
		setVisible(true);
		setResizable(false);
	}

private void addButton(String label,ActionListener listener){
	JButton button=new JButton(label);
	panel2.add(button);
	button.setPreferredSize(new Dimension(41,41));
	button.addActionListener(listener);
}

private class InsertAction implements ActionListener{
	public void actionPerformed(ActionEvent event){
		String input=event.getActionCommand();
		if(start){
			text.setText("");
			start=false;
		}
		text.setText(text.getText() + input);
	}	
}
	

private class CommandAction implements ActionListener{
	public void actionPerformed(ActionEvent event){
		String command=event.getActionCommand();
		if(start){
			//text.setText("");
			lastCommand=command;
			//start=true;
		}
		else{
			Operate(Double.parseDouble(text.getText()));
			lastCommand=command;
			start=true;
		}
	}	
}

public void Operate(double x){
	if(lastCommand.equals("+")){
		result+=x;
	}
	
	if(lastCommand.equals("-")){
		result-=x;
	}

	if(lastCommand.equals("*")){
		result*=x;
	}

	if(lastCommand.equals("/")){
		result/=x;
	}

	if(lastCommand.equals("=")){
		result=x;
	}
	text.setText(""+result);
}
	

}