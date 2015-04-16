package miniStuMngt_v3;

import java.util.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import java.awt.*;


public class StuModel extends AbstractTableModel {

	Vector rowData;
	Vector columnNames;
	Vector temp;
	
	public static boolean updateStu(String sql, String[] parameters){
		
		SQLHelper sh = new SQLHelper();
		return sh.executeUpdate(sql, parameters);
		
	}
	
	public void queryStu(String sql, String[] parameters){
		
		rowData = new Vector();
		columnNames = new Vector();
		columnNames.add("StuID");
		columnNames.add("StuName");
		columnNames.add("StuSex");
		columnNames.add("StuAge");
		columnNames.add("StuHome");
		columnNames.add("StuJob");
		
		SQLHelper sh = new SQLHelper();
		ResultSet rs = sh.executeQuery(sql, parameters);
		try {
			while(rs.next()){
				
				temp = new Vector();
				temp.add(rs.getString(1));
				temp.add(rs.getString(2));
				temp.add(rs.getString(3));
				temp.add(rs.getString(4));
				temp.add(rs.getString(5));
				temp.add(rs.getString(6));
			
				rowData.add(temp);
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			try {
				if(rs!=null) rs.close();
				sh.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public StuModel(){
		
		
	}
	
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
	}


	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)this.columnNames.get(column);
	}

}
