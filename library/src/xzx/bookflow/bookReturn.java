package xzx.bookflow;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import xzx.bookManager.bookBean;

public class bookReturn extends JFrame implements ActionListener{
	Container c;
	JLabel jLabel1 = new JLabel();
	JTextField sname = new JTextField(10);
	JButton reconfirm = new JButton();
	
	public bookReturn(){
		this.setTitle("归还图书");
		this.setResizable(false);
		try{Init();}catch (Exception e){e.printStackTrace();}
		//设置居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int)(screenSize.width - 400)/2,(int)(screenSize.height - 300)/2 +45);
	}
	
	public void Init() throws Exception{
		this.setSize(300,500);
		c = this.getContentPane();
		c.setLayout(new FlowLayout());
		jLabel1.setText("归还图书名称: ");
		jLabel1.setFont(new Font("Dialog",0,12));
		c.add(jLabel1);
		sname.setText(null);
		sname.setFont(new Font("Dialog",0,12));
		c.add(sname);
		
		reconfirm.setText("确定");
		reconfirm.setFont(new Font("Dialog",0,12));
		c.add(reconfirm);
		reconfirm.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj == reconfirm){
			bookBean rs = new bookBean();
			rs.bookReturn(sname.getText());
			this.dispose();
		}
	}
}

