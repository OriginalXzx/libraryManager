package xzx.bookManager;

import java.awt.*;
import javax.swing.*;

public class bookDisplay extends JFrame {
	JLabel jLabel1 = new JLabel();
	JButton jBExit = new JButton();
	JScrollPane jScrollPane1;
	JTable jTabstuInfo;
	String sNum;
	String[] 列名 = { "图书ID", "图书名", "图书所有者", "图书状态", "使用者" };
	String[][] 列值;
	String sColValue;
	String sColName;
	String sFromValue;
	String sToValue;

	public bookDisplay() {
		this.setTitle("学生信息查询结果");
		// --------设置运行位置居中---------
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int) (screenSize.width - 400) / 2, (int) (screenSize.height - 300) / 2 + 45);

		bookBean rstu = new bookBean();
		try {
			列值 = rstu.bookAllSearch();
			if (列值 == null) {
				JOptionPane.showMessageDialog(null, "没有符合条件的记录");
				this.dispose();
			} else {
				jTabstuInfo = new JTable(列值, 列名);
				jScrollPane1 = new JScrollPane(jTabstuInfo);
				this.getContentPane().add(jScrollPane1, BorderLayout.CENTER);
				this.pack();
				this.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


