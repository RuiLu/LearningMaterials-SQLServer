package miniStuMngt_v3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
import javax.swing.*;


public class StuModifyDialog extends JDialog implements ActionListener{
	
	private JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	private JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	private JPanel jp1,jp2,jp3;
	private JButton jb1,jb2;
	
	public StuModifyDialog(JFrame owner, String title, boolean modal, Vector SelectedRowData){
		
		super(owner,title,modal);
		
		jl1 = new JLabel("StuID");
		jl2 = new JLabel("StuName");
		jl3 = new JLabel("StuSex");
		jl4 = new JLabel("StuAge");
		jl5 = new JLabel("StuHome");
		jl6 = new JLabel("StuJob");
		
		jtf1 = new JTextField(10);
		jtf1.setText((String)SelectedRowData.get(0));
		jtf1.setEditable(false);
		jtf2 = new JTextField(10);
		jtf2.setText((String)SelectedRowData.get(1));
		jtf3 = new JTextField(10);
		jtf3.setText((String)SelectedRowData.get(2));
		jtf4 = new JTextField(10);
		jtf4.setText((String)SelectedRowData.get(3));
		jtf5 = new JTextField(10);
		jtf5.setText((String)SelectedRowData.get(4));
		jtf6 = new JTextField(10);
		jtf6.setText((String)SelectedRowData.get(5));
		
		jb1 = new JButton("Update");
		jb1.addActionListener(this);
		jb1.setActionCommand("update");
		jb2 = new JButton("Exit");
		jb2.addActionListener(this);
		jb2.setActionCommand("exit");
		
		jp1 = new JPanel(new GridLayout(6,1));
		jp1 = new JPanel(new GridLayout(6,1));
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		jp2 = new JPanel(new GridLayout(6,1));
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		jp3 = new JPanel();
		jp3.add(jb1);
		jp3.add(jb2);

		
		this.setLocation(400, 300);
		this.add(jp1,"West");
		this.add(jp2,"Center");
		this.add(jp3,"South");
		this.setSize(400,300);
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("update")){
			String sql = "update stu set stuName=?,stuSex=?,stuAge=?,stuJg=?,stuDept=? where stuId=?";
			String[] parameters ={jtf2.getText().trim(),jtf3.getText().trim(),jtf4.getText().trim(),jtf5.getText().trim(),jtf6.getText().trim(),jtf1.getText().trim(),};
		    System.out.println(sql);
			StuModel sm = new StuModel();
			sm.updateStu(sql, parameters);
			this.dispose();
			
		}
		else if(e.getActionCommand().equals("exit")){
			this.dispose();
		}
	}
	
	

}
