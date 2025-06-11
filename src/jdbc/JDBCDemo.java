package jdbc;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/studentdb";
        String user = "postgres";
        String password = "root";

        try {

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully!");


            String insertSQL = "INSERT INTO students (name, marks) VALUES (?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
            insertStmt.setString(1, "Aditya");
            insertStmt.setInt(2, 99 );
            insertStmt.executeUpdate();
            System.out.println("Data inserted.");


            String selectSQL = "SELECT * FROM students";
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery(selectSQL);

            System.out.println("Fetching data:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int marks = rs.getInt("marks");
                System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
            }


            rs.close();
            insertStmt.close();
            selectStmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
