package jdbc;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
        try {
            Connection connection = getDatabaseConnection();
            System.out.println("Connection to database successful - " + connection);

            insertStudent(connection);

            fetchStudent(connection);

            updateStudent(connection);

            fetchStudent(connection);

            deleteStudent(connection);

            fetchStudent(connection);

            closeConnection(connection);

        } catch (Exception e) {
            System.out.println("Exception occurred while calling functions - " + e.getMessage() + e);
        }
    }

    public static Connection getDatabaseConnection() {
        try {
            String url = "jdbc:postgresql://localhost:5432/studentdb";
            String user = "postgres";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection to database established successfully !");
            return connection;
        } catch (SQLException e) {
            System.out.println("Exception occurred while connecting to database - " + e.getMessage() + e);
            throw new RuntimeException(e);
        }
    }

    public static void insertStudent(Connection connection) {
        try {
            String insertSQL = "INSERT INTO students (name, marks) VALUES (?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(insertSQL);
            insertStmt.setString(1, "Test177");
            insertStmt.setInt(2, 99);
            insertStmt.executeUpdate();
            System.out.println("Data inserted.");
            insertStmt.close();
        } catch (SQLException e) {
            System.out.println("Exception occurred while inserting student - " + e.getMessage() + e);
            throw new RuntimeException(e);
        }
    }

    public static void fetchStudent(Connection connection) {
        try {
            String selectSQL = "SELECT * FROM students WHERE name = ?";
            PreparedStatement selectStmt = connection.prepareStatement(selectSQL);
            selectStmt.setString(1, "Test177");
            ResultSet rs = selectStmt.executeQuery();

            System.out.println("Fetching data:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int marks = rs.getInt("marks");
                System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
            }

            selectStmt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Exception occurred while fetching student - " + e.getMessage() + e);
            throw new RuntimeException(e);
        }
    }

    public static void updateStudent(Connection connection) {
        try {
            String updateSQL = "UPDATE students SET marks = ? WHERE name = ?";
            PreparedStatement updateStmt = connection.prepareStatement(updateSQL);
            updateStmt.setInt(1, 77);
            updateStmt.setString(2, "Test177");
            updateStmt.executeUpdate();
            System.out.println("Data updated.");
            updateStmt.close();

        } catch (SQLException e) {
            System.out.println("Exception occurred while updating student - " + e.getMessage() + e);
            throw new RuntimeException(e);
        }
    }

    public static void deleteStudent(Connection connection) {
        try {
            String deleteSQL = "DELETE FROM students WHERE name = ?";
            PreparedStatement deleteStmt = connection.prepareStatement(deleteSQL);
            deleteStmt.setString(1, "Test177");
            deleteStmt.executeUpdate();
            System.out.println("Data deleted.");
            deleteStmt.close();
        } catch (Exception e) {
            System.out.println("Exception occurred while deleting student - " + e.getMessage() + e);
            throw new RuntimeException(e);
        }
    }


    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Exception occurred while closing database connection - " + e.getMessage() + e);
            throw new RuntimeException(e);
        }
    }

}
