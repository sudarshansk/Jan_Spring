import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PlainJdbcUser {
	public static void main(String[] args) throws Exception{
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/intuit_spring_training";
			con = DriverManager.getConnection(url,"root","durasoft");
			Statement stmt = con.createStatement();
			String sql = "insert into persons(name,age) values('Sam',12)";
			stmt.executeUpdate(sql);
			stmt.close();
			System.out.println("Done");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}
	}

}
