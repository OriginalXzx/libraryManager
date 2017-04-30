package xzx.bookManager;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class bookDel extends JFrame implements ActionListener{
	Container c;
	JLabel jLabel1 = new JLabel();
	JTextField sid = new JTextField(10);
	JButton delconfirm = new JButton();
	
	public bookDel(){
		this.setTitle("删除图书信息");
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
		jLabel1.setText("要删除的图书ID: ");
		jLabel1.setFont(new Font("Dialog",0,12));
		c.add(jLabel1);
		sid.setText(null);
		sid.setFont(new Font("Dialog",0,12));
		c.add(sid);
		
		delconfirm.setText("确认删除");
		delconfirm.setFont(new Font("Dialog",0,12));
		c.add(delconfirm);
		delconfirm.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj == delconfirm){
			bookBean rs = new bookBean();
			rs.bookDel(sid.getText());
			this.dispose();
		}
	}
}

