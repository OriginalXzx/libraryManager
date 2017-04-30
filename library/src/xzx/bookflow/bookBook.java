package xzx.bookflow;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import xzx.bookManager.bookBean;

public class bookBook extends JFrame implements ActionListener{
	Container c;
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JTextField sname = new JTextField(10);
	JTextField suser = new JTextField(10);
	JButton bookconfirm = new JButton();
	
	public bookBook(){
		this.setTitle("借阅图书");
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
		jLabel1.setText("借阅图书名称: ");
		jLabel1.setFont(new Font("Dialog",0,12));
		c.add(jLabel1);
		sname.setText(null);
		sname.setFont(new Font("Dialog",0,12));
		c.add(sname);
		jLabel2.setText("借阅者姓名: ");
		jLabel2.setFont(new Font("Dialog",0,12));
		c.add(jLabel2);
		suser.setText(null);
		suser.setFont(new Font("Dialog",0,12));
		c.add(suser);
		
		bookconfirm.setText("确定");
		bookconfirm.setFont(new Font("Dialog",0,12));
		c.add(bookconfirm);
		bookconfirm.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj == bookconfirm){
			bookBean rs = new bookBean();
			rs.bookBook(sname.getText(),suser.getText());
			this.dispose();
		}
	}
}

