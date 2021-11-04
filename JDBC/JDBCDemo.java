package JDBC;

import java.sql.*;
import java.util.*;

public class JDBCDemo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cse_ai?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                    "root", "password");
            Statement s = conn.createStatement();
            PreparedStatement stmt = conn.prepareStatement("insert into student (name,regno) values(?,?)");
            stmt.setString(1, "somename");
            stmt.setString(2, "1000");
            int i = stmt.executeUpdate();
            System.out.println(i + " records inserted");
            String query = "select * from student;";
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("name") + "  " + rs.getString("regno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
