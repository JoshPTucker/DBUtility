package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtility {
	
	//This Should return the entire table
	public static void checkTableData(String table) {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql ="select * from "+table;
		String printStatement = "Still not working";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// con = DriverManager.getConnection("jdbc:oracle:thin:sys as
			// sysdba/oracle@localhost:1521:orcl");
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			System.err.println("You have enetered an invalid sql statement");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("Data you are searching for is unavailable");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void updateSingleField(String table,String field,String newVal) {

		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql ="update "+table+" ("+field+") set values(\'"+newVal+"\')";
		String printStatement = "Still not working";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// con = DriverManager.getConnection("jdbc:oracle:thin:sys as
			// sysdba/oracle@localhost:1521:orcl");
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			System.err.println("You have enetered an invalid sql statement");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("Data you are searching for is unavailable");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	public static void addDataSingleField(String table,String field,String newVal){
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql ="insert into "+table+" ("+field+") values(\'"+newVal+"\')";
		String printStatement = "Still not working";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// con = DriverManager.getConnection("jdbc:oracle:thin:sys as
			// sysdba/oracle@localhost:1521:orcl");
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			System.err.println("You have enetered an invalid sql statement");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("Data you are searching for is unavailable");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static int getNumberOfCol(String table){
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql ="SELECT * FROM "+table;
		String printStatement = "Still not working";
		int nc=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// con = DriverManager.getConnection("jdbc:oracle:thin:sys as
			// sysdba/oracle@localhost:1521:orcl");
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			 nc = rsmd.getColumnCount();
		} catch (SQLException e) {
			System.err.println("You have enetered an invalid sql statement");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("Data you are searching for is unavailable");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return nc;
	}
	public static String getColNames(String table){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql ="SELECT * FROM "+table;
		String printStatement="";
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// con = DriverManager.getConnection("jdbc:oracle:thin:sys as
			// sysdba/oracle@localhost:1521:orcl");
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			for(int i=1;i<rsmd.getColumnCount()+1;i++){
			 printStatement +=" "+ rsmd.getColumnName(i);
			}
		} catch (SQLException e) {
			System.err.println("You have enetered an invalid sql statement");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("Data you are searching for is unavailable");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return printStatement;
	}
}
