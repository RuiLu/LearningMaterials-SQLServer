package miniStuMngt_v3;

import javax.swing.*;

import java.sql.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StuAddDialog extends JDialog implements ActionListener {

	
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	JPanel jp1,jp2,jp3;
	JButton jb1,jb2;
	
	public StuAddDialog(Frame owner, String title, boolean modal){
		
		super(owner,title,modal);
		
		jl1 = new JLabel("StuID");
		jl2 = new JLabel("StuName");
		jl3 = new JLabel("StuSex");
		jl4 = new JLabel("StuAge");
		jl5 = new JLabel("StuHome");
		jl6 = new JLabel("StuJob");
		
		jtf1 = new JTextField(10);
		jtf2 = new JTextField(10);
		jtf3 = new JTextField(10);
		jtf4 = new JTextField(10);
		jtf5 = new JTextField(10);
		jtf6 = new JTextField(10);
		
		
		jb1 = new JButton("add");
		jb1.addActionListener(this);
		jb1.setActionCommand("add");
		jb2 = new JButton("exit");
		jb2.addActionListener(this);
		jb2.setActionCommand("exit");
		
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
		if(e.getActionCommand().equals("add")){
			//Êý¾Ý¿â£¡
			StuModel sm = new StuModel();
			String sql = "insert into stu values(?,?,?,?,?,?)";
			String[] parameters = {jtf1.getText().trim(),jtf2.getText().trim(),jtf3.getText().trim(),jtf4.getText().trim(),jtf5.getText().trim(),jtf6.getText().trim()};
			if(!sm.updateStu(sql, parameters)){
				JOptionPane.showMessageDialog(this, "Add Failed!");
			}
			this.dispose();
		}
		else if(e.getActionCommand().equals("exit")){
			this.dispose();
		}
	}
	
}
