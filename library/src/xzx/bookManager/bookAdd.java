package xzx.bookManager;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class bookAdd extends JFrame implements ActionListener{
	Container c;
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JTextField sid = new JTextField(10);
	JTextField sname = new JTextField(10);
	JTextField sowner = new JTextField(10);
	JTextField sstatus = new JTextField(10);
	JTextField suser = new JTextField(10);
	JButton addconfirm = new JButton();
	
	public bookAdd(){
		this.setTitle("增加图书信息");
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
		jLabel1.setText("图书ID: ");
		jLabel1.setFont(new Font("Dialog",0,12));
		c.add(jLabel1);
		sid.setText(null);
		sid.setFont(new Font("Dialog",0,12));
		c.add(sid);
		
		jLabel2.setText("图书名称: ");
		jLabel2.setFont(new Font("Dialog",0,12));
		c.add(jLabel2);
		sname.setText(null);
		sname.setFont(new Font("Dialog",0,12));
		c.add(sname);
		
		jLabel3.setText("图书所有者: ");
		jLabel3.setFont(new Font("Dialog",0,12));
		c.add(jLabel3);
		sowner.setText(null);
		sowner.setFont(new Font("Dialog",0,12));
		c.add(sowner);
		
		addconfirm.setText("确认增加");
		addconfirm.setFont(new Font("Dialog",0,12));
		c.add(addconfirm);
		addconfirm.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj == addconfirm){
			bookBean rs = new bookBean();
			rs.bookAdd(sid.getText(),sname.getText(),sowner.getText());
			this.dispose();
		}
	}
}

