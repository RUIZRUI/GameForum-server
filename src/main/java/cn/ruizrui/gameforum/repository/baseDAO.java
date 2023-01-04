package cn.ruizrui.gameforum.repository;
import cn.ruizrui.gameforum.config.SQLConfig;
import java.sql.*;

public class baseDAO {
	Connection con = null;

	private static SQLConfig config = new SQLConfig();

	public Connection getConnection()  {
		try {
			Class.forName(config.getDriver());
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPwd());
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void closeAll(Connection conn,Statement stmt,ResultSet rs)  {
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public int executeUpdate(String preparedSql,Object[] param) {
		PreparedStatement pstmt=null;
		con=getConnection();
		int num=0;
		try {
			pstmt=con.prepareStatement(preparedSql);
			if(param!=null) {
				for(int i=0;i<param.length;i++)
					pstmt.setObject(i+1,param[i]);
			}
			num=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
}
