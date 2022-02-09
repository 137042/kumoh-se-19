package chapter5;

import java.sql.*;

public class Quiz11_1 {

    Connection con;

    public Quiz11_1(){
        String Driver = "";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String userid = "c##madang";
        String pwd = "madang";

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            con = DriverManager.getConnection(url,userid,pwd);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    void sqlRun(){
        String query = "SELECT bookname, price FROM Book WHERE publisher = '이상미디어'";
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Book_name\tBook_price");
            while(rs.next()){
                System.out.print(rs.getString(1));
                System.out.print("\t" + rs.getInt(2));
                System.out.println();
            }
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
