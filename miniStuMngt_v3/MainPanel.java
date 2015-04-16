package miniStuMngt_v3;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

public class MainPanel extends JFrame implements ActionListener {

	/**
	 * @param args
	 */
	JPanel jpUp,jpDown;
	JTextField jtf;
	JButton jb1,jb2,jb3,jb4,jb5;
	JTable jt;
	JScrollPane jsp;
	JLabel jl1;
	
	StuModel sm = null;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainPanel();
	}
	
	public MainPanel(){
		
		jpUp = new JPanel();
		jl1 = new JLabel("StuName");
		jtf = new JTextField(10);
		jb1 = new JButton("query");
		jb1.addActionListener(this);
		jb1.setActionCommand("query");
		jpUp.add(jl1);
		jpUp.add(jtf);
		jpUp.add(jb1);
		
		
		sm = new StuModel();
		String sql = "select * from stu where 1=?";
		String[] parameters ={"1"};
		sm.queryStu(sql, parameters);
		jt = new JTable(sm);
		jsp = new JScrollPane(jt);
		
		jpDown = new JPanel();
		jb2 = new JButton("Add");
		jb2.addActionListener(this);
		jb2.setActionCommand("add");
		jb3 = new JButton("Update");
		jb3.addActionListener(this);
		jb3.setActionCommand("update");
		jb4 = new JButton("Delete");
		jb4.addActionListener(this);
		jb4.setActionCommand("delete");
		jb5 = new JButton("Check");
		jb5.addActionListener(this);
		jb5.setActionCommand("check");
		jpDown.add(jb5);
		jpDown.add(jb2);
		jpDown.add(jb3);
		jpDown.add(jb4);
		
		this.setLayout(new BorderLayout());
		this.add(jsp);
		this.add(jpUp,"North");
		this.add(jpDown,"South");
		this.setSize(400, 300);
		this.setLocation(300, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}


	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("query")){
			String name = jtf.getText().trim();
			String sql = "select * from stu where stuName=?";
			String[] parameters = {name};
			sm = new StuModel();
			sm.queryStu(sql, parameters);
			jt.setModel(sm);
			
		}
		else if(e.getActionCommand().equals("add")){
			new StuAddDialog(this, "Add a Student", true);
			sm = new StuModel();
			String sql = "select * from stu";
			sm.queryStu(sql,null);
			jt.setModel(sm);
		}
		else if(e.getActionCommand().equals("update")){
			
			int num = jt.getSelectedRow();
			if(num==-1){
				JOptionPane.showMessageDialog(this, "Please select one row that you want to update");
				return;
			}
			Vector temp = (Vector) sm.rowData.get(num);
			new StuModifyDialog(this, "Update Info", true,temp);
			sm = new StuModel();
			String sql2 = "select * from stu";
			sm.queryStu(sql2,null);
			jt.setModel(sm);
			
		}
		else if(e.getActionCommand().equals("delete")){
			
			int num = jt.getSelectedRow();
			if(num==-1){
				JOptionPane.showMessageDialog(this, "Please select one row that you want to delete");
				return;
			}
			String[] id = {(String)jt.getValueAt(num, 0)};
			String sql = "delete from stu where stuId=?";
			sm.updateStu(sql, id);
			sm = new StuModel();
			String sql2 = "select * from stu";
			sm.queryStu(sql2,null);
			jt.setModel(sm);
		}
		else if(e.getActionCommand().equals("check")){
			sm = new StuModel();
			String sql = "select * from stu where 1=?";
			String[] parameters ={"1"};
			sm.queryStu(sql, parameters);
			jt.setModel(sm);
		}
	}
}



