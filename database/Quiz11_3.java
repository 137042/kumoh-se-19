package chapter5;

import java.sql.*;

public class Quiz11_3 {

    Connection con;

    public Quiz11_3() {
        String Driver = "";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String userid = "c##madang";
        String pwd = "madang";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(url, userid, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void sqlRun() {
        String query = "SELECT bookname FROM Book b1 WHERE price > (" +
                "SELECT AVG(price) FROM Book b2 WHERE b1.publisher = b2.publisher)";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("book_name");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
