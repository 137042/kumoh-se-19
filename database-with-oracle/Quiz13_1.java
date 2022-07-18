package chapter5;

import java.sql.*;
import java.sql.CallableStatement;
import java.util.Scanner;

public class Quiz13_1 {

    Connection con;

    public Quiz13_1(){
        try{
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String userid = "c##madang";
            String pwd = "madang";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url,userid,pwd);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    void sqlRun(){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("삽입할 고객 정보 (아이디,이름,주소,전화번호)");
            String input = sc.nextLine();
            String[] data = input.split(",");
            String query = "{call InsertCustomer(?,?,?,?)}";
            CallableStatement call = con.prepareCall(query);
            call.setInt(1,Integer.parseInt(data[0]));
            call.setString(2,data[1]);
            call.setString(3,data[2]);
            call.setString(4,data[3]);
            boolean worked = call.execute();

            Statement stmt;
            ResultSet rs;
            stmt = con.createStatement();
            query = "SELECT * FROM Customer";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.print(rs.getInt(1) +", " + rs.getString(2));
                System.out.println(", " + rs.getString(3) + ", " + rs.getString(4));
            }
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
