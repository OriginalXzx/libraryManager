package xzx.bookManager;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class bookSearch extends JFrame implements ActionListener{
	Container c;
	JLabel jLabel1 = new JLabel();
	JTextField sFrom = new JTextField(4);
	JButton confirm = new JButton();
	
	public bookSearch(){
		this.setTitle("按图书ID查询");
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
		jLabel1.setText("请输入图书ID: ");
		jLabel1.setFont(new Font("Dialog",0,12));
		c.add(jLabel1);
		sFrom.setText(null);
		sFrom.setFont(new Font("Dialog",0,12));
		c.add(sFrom);
		confirm.setText("确定");
		confirm.setFont(new Font("Dialog",0,12));
		c.add(confirm);
		confirm.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj == confirm){
			Resultbook rs = new Resultbook("book_id",sFrom.getText());
			this.dispose();
		}
	}
}
