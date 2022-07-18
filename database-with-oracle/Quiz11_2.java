package chapter5;

import java.sql.*;

public class Quiz11_2 {

    Connection con;

    public Quiz11_2(){
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
        String query = "SELECT publisher,SUM(price) FROM Book GROUP BY publisher";
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.printf("%s\t%s\n","publisher","price_sum");
            while(rs.next()){
                System.out.printf("%-10s",rs.getString(1));
                System.out.printf("%7d\n",rs.getInt(2));
            }
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
