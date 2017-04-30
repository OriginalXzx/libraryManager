package xzx.frame;
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import xzx.bookManager.*;
import xzx.bookflow.*;
import xzx.entity.bookInfo;
public class bookMain extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	//----------建立菜单栏----------
	JMenuBar mainMenu = new JMenuBar();
	//--------------建立系统管理菜单组--------------
	 JMenu menuSystem = new JMenu();
	 JMenuItem itemExit = new JMenuItem();
	 JMenu menubook = new JMenu();
	 JMenu menuevent = new JMenu();
	 JMenuItem itemAdd  = new JMenuItem();
	 JMenuItem itemEdit  = new JMenuItem();
	 JMenuItem itemDelete  = new JMenuItem();
	 JMenuItem itemSelect  = new JMenuItem();
	 JMenuItem itemBook = new JMenuItem();
	 JMenuItem itemReturn = new JMenuItem();
	 JMenuItem itemDisplay = new JMenuItem();
	 //------------创建窗体模板对象--------------
	 public static bookInfo m_stu = new bookInfo();
	 
	 public bookMain(){
		 enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.pack();
		 this.setSize(600,480);
		 this.setTitle("图书管理系统");
		 try{
			 Init();
		 }catch (Exception e) {e.printStackTrace();}
	 }
	 
	 private void Init() throws Exception {
		 Container contentPane = this.getContentPane();
		 contentPane.setLayout(new BorderLayout());
		 //------添加菜单组-------
		 menuSystem.setText("系统操作");
		 menuSystem.setFont(new Font("Dialog",0,12));
		 menubook.setText("图书信息管理");
		 menubook.setFont(new Font("Dialog",0,12));
		 menuevent.setText("图书流通管理");
		 menuevent.setFont(new Font("Dialog",0,12));
		 //---------生成系统管理菜单组---------
		 itemExit.setText("退出");
		 itemExit.setFont(new Font("Dialog",0,12));
		 //--------------生成学生菜单组----------------
		 itemAdd.setText("增加图书");
		 itemAdd.setFont(new Font("Dialog",0,12));
		 itemEdit.setText("修改信息");
		 itemEdit.setFont(new Font("Dialog",0,12));
		 itemDelete.setText("删除图书");
		 itemDelete.setFont(new Font("Dialog",0,12));	 
		 itemSelect.setText("查询");
		 itemSelect.setFont(new Font("Dialog",0,12));
		 itemDisplay.setText("显示全部信息");
		 itemDisplay.setFont(new Font("Dialog",0,12));
		//--------------生成管理事务菜单组----------------
		 itemBook.setText("图书借阅");
		 itemBook.setFont(new Font("Dialog",0,12));
		 itemReturn.setText("图书归还");
		 itemReturn.setFont(new Font("Dialog",0,12));
		 menuSystem.add(itemExit);
		 menubook.add(itemAdd);
		 menubook.add(itemEdit);
		 menubook.add(itemDelete);
		 menubook.add(itemSelect);	
		 menubook.add(itemDisplay);
		 menuevent.add(itemBook);
		 menuevent.add(itemReturn);
		  //----组合菜单栏---
		 mainMenu.add(menuSystem);
		 mainMenu.add(menubook);
		 mainMenu.add(menuevent);
		 this.setJMenuBar(mainMenu);
		 //添加事件监听
		 itemExit.addActionListener(this);
		 itemAdd.addActionListener(this);
		 itemEdit.addActionListener(this);
		 itemDelete.addActionListener(this);
		 itemSelect.addActionListener(this);
		 itemBook.addActionListener(this);
		 itemReturn.addActionListener(this);
		 itemDisplay.addActionListener(this);
		 setVisible(true);
		 this.addWindowListener(new WindowAdapter(){
			 public void windowClosing(WindowEvent e){System.exit(0);}
		 })	;
	 }
	 
	 public void actionPerformed(ActionEvent e){
		 Object obj = e.getSource();
		 if(obj == itemExit){System.exit(0);}
		 else if(obj == itemAdd){
			 bookAdd asi = new bookAdd();
     		 //asi.downInit();
			 asi.pack();
			 asi.setVisible(true);
		 }else if(obj == itemEdit){
			 bookEdit esi = new bookEdit();
    		 //esi.downInit();
			 esi.pack();
			 esi.setVisible(true);
		 }else if(obj == itemDelete){
			 bookDel dsi = new bookDel();
			 //dsi.downInit();
			 dsi.pack();
			 dsi.setVisible(true);
		 }else if(obj == itemSelect){
			 bookSearch sbid = new bookSearch();
			 sbid.pack();
			 sbid.setVisible(true);
		 }else if(obj == itemBook){
			 bookBook sboo = new bookBook();
			 sboo.pack();
			 sboo.setVisible(true);
		 }else if(obj == itemReturn){
			 bookReturn sre = new bookReturn();
			 sre.pack();
			 sre.setVisible(true);
		 }else if(obj == itemDisplay){
			 bookDisplay sre = new bookDisplay();
			 sre.pack();
			 sre.setVisible(true);
		 }	 
	 }
	 public static void main(String[] args){new bookMain();}
}
