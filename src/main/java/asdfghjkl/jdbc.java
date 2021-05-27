package asdfghjkl;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class jdbc {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306";
		String user = "root";
		String password = "techouts";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = con.prepareStatement("update ravindradb.thriller set image=? where bookId=?");
			ps.setInt(2, 175);
//			ps.setString(3, "GOT");
//			ps.setString(2, "Martin");
//		    ps.setDouble(4, 600);
			

			FileInputStream fin = new FileInputStream("D:\\Action\\t5.jpg");
			ps.setBinaryStream(1, fin, fin.available());
			//ps.setString(6, " Stars");
			int i = ps.executeUpdate();
			System.out.println(i + " records affected");

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
