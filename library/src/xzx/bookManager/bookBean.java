package xzx.bookManager;

import java.sql.ResultSet;
import java.util.Arrays;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import xzx.core.database.DatabaseConn;
public class bookBean {
	String sql;
	ResultSet rs = null;
	
	String sid;
	String sname;
	String sowner;
	String sstatus;
	String suser;
	
	String colName;
	String colValue;
	
	//-----------------添加图书信息------------------
	public void bookAdd(String id,String name,String owner){
		//System.out.println(id+name+owner);
		DatabaseConn DB = new DatabaseConn();
		this.sid = id;
		this.sname = name;
		this.sowner = owner;
		this.sstatus = "空闲";
		this.suser = null;
		if(sid.equals("")){
			JOptionPane.showMessageDialog(null,"请输入图书ID","错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		else{
			sql = "insert into book(book_id,book_name,book_owner,book_status,book_user) values('"+sid+"','"+sname+"','"+sowner+"','"+sstatus+"','"+suser+"');";
			System.out.println(sql);
			try{
				DB.OpenConn();
				DB.executeUpdate(sql);
				JOptionPane.showMessageDialog(null,"成功添加一条记录!");
			}catch (Exception e){
				System.out.println(e);
				JOptionPane.showMessageDialog(null,"保存失败!","错误",JOptionPane.ERROR_MESSAGE);
			}finally {DB.closeStmt();DB.closeConn();}
		}
	}
	//-----------------修改图书信息------------------
	public void bookModify(String id,String name,String owner){
		DatabaseConn DB = new DatabaseConn();
		this.sid = id;
		this.sname = name;
		this.sowner = owner;
		if(sid.equals("")){
			JOptionPane.showMessageDialog(null,"请输入图书ID","错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		else{
			sql = "update book set book_name='"+sname+"',book_owner='"+sowner+"' where book_id= "+sid+"";
			try{DB.OpenConn();
				DB.executeUpdate(sql);
				JOptionPane.showMessageDialog(null,"成功修改一条记录!");
			}catch (Exception e){
				System.out.println(e);
				JOptionPane.showMessageDialog(null,"更新失败!","错误",JOptionPane.ERROR_MESSAGE);
			}finally {DB.closeStmt();DB.closeConn();}
		}
	}
	//-----------------删除图书信息------------------
	public void bookDel(String id){
		DatabaseConn DB = new DatabaseConn();
		this.sid = id;
		sql = "delete from book where book_id = "+id+"";
		//System.out.println(sql);
		try{
			DB.OpenConn();
			DB.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"成功删除一条记录!");
		}catch (Exception e){
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"删除失败!","错误",JOptionPane.ERROR_MESSAGE);
		}finally {DB.closeStmt();DB.closeConn();}
	}
	
	//------------根据指定ID查询图书信息------------------
		public String [][]bookSearch(String id){
			this.colValue = id;
			DatabaseConn DB = new DatabaseConn();
			String [][] sn = null;
			int row = 0;
			int i = 0;
			sql = "select * from book where book_id="+colValue+"";
			try{
				DB.OpenConn();
				rs  = DB.executeQuery(sql);
				if(rs.last()){ row = rs.getRow();
				}
				if(row == 0)
				{sn = null;}
				else
				{	sn  = new String[row][5];
					rs.first();
					rs.previous();
					while(rs.next())
					{	sn[i][0] = rs.getString("book_id");
						sn[i][1] = rs.getString("book_name");
						sn[i][2] = rs.getString("book_owner");
						sn[i][3] = rs.getString("book_status");
						sn[i][4] = rs.getString("book_user");
						i++;
					}
				}
			}catch (Exception e) {} finally {DB.closeStmt();DB.closeConn();}
			return sn;
		}
		//-----------------借阅图书------------------
		public void bookBook(String name,String user){
			DatabaseConn DB = new DatabaseConn();
			this.sname = name;
			this.suser = user;
			String temp ="已借";
			if(sname.equals("")){
				JOptionPane.showMessageDialog(null,"请输入图书名称","错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			else{
				sql = "update book set book_status='"+temp+"',book_user='"+suser+"' where book_name= '"+sname+"'";
				try{DB.OpenConn();
					DB.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"成功借阅!");
				}catch (Exception e){
					System.out.println(e);
					JOptionPane.showMessageDialog(null,"借阅失败!","错误",JOptionPane.ERROR_MESSAGE);
				}finally {DB.closeStmt();DB.closeConn();}
			}
		}
		//-----------------归还图书------------------
		public void bookReturn(String name){
			DatabaseConn DB = new DatabaseConn();
			this.sname = name;
			String temp ="空闲";
			String temp2 =null;
			if(sname.equals("")){
				JOptionPane.showMessageDialog(null,"请输入图书名称","错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			else{
				sql = "update book set book_status='"+temp+"',book_user='"+temp2+"' where book_name= '"+sname+"'";
				try{DB.OpenConn();
					DB.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"成功归还!");
				}catch (Exception e){
					System.out.println(e);
					JOptionPane.showMessageDialog(null,"归还失败!","错误",JOptionPane.ERROR_MESSAGE);
				}finally {DB.closeStmt();DB.closeConn();}
			}
		}
		//------------显示全部图书信息-------------
		public String [][]bookAllSearch(){
			DatabaseConn DB = new DatabaseConn();
			String [][] sn = null;
			int row = 0;
			int i = 0;
			sql = "select *from book";
			System.out.println("---------"+rs);
			try{
				
				DB.OpenConn();
				rs  = DB.executeQuery(sql);
				System.out.println("---------2"+rs);
				if(rs.last()){row = rs.getRow();
				}
				if(row == 0)
				{sn = null;}
				else
				{  	sn  = new String[row][6];
					rs.first();
					rs.previous();
					while(rs.next())
					{	sn[i][0] = rs.getString("book_id");
						sn[i][1] = rs.getString("book_name");
						sn[i][2] = rs.getString("book_owner");
						sn[i][3] = rs.getString("book_status");
						sn[i][4] = rs.getString("book_user");
						i++;
					}
				}
			}catch (Exception e) {} //finally {DB.closeStmt();DB.closeConn();}
			System.out.println(Arrays.toString(sn));
			return sn;
		}
}

