package miniStuMngt_v3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class SQLHelper {

	private PreparedStatement ps;
	private Connection ct;
	private ResultSet rs;
	
	private static String driver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
	private static String url = "jdbc:microsoft:sqlserver://127.0.0.1:1433;databaseName=sqldb1";
	private static String username = "Learn";
	private static String password = "Lurui0213";
	
	//turn off rs,ps and ct
	public void close(){
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(ct!=null) ct.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	static{
		
		try {
			Class.forName(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//execute UPDATA
	public boolean executeUpdate(String sql, String[] parameters){
		
		boolean check = true;
		try {
			ct = DriverManager.getConnection(url,username,password);
			ps = ct.prepareStatement(sql);
			//给参数赋值
			for(int i=0;i<parameters.length;i++){
				ps.setString(i+1, parameters[i]);
			}
			//执行ps
			if(ps.executeUpdate()!=1){
				check = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			check = false;
			e.printStackTrace();
		} finally{
			this.close();
		}
	
		return check;
	}
	
	//execute QUERY
	public ResultSet executeQuery(String sql, String[] parameters){
		
		try {
			ct = DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:1433;databaseName=sqldb1","Learn","Lurui0213");
			ps = ct.prepareStatement(sql);
			if(parameters!=null){
				for(int i=0;i<parameters.length;i++){
					ps.setString(i+1, parameters[i]);
				}
			}

			rs = ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return rs;

	}
}
