package chapter5;

import java.sql.*;
import java.util.Scanner;

public class Quiz12_1 {

    Connection con;

    public Quiz12_1(){
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
        Scanner sc = new Scanner(System.in);
        System.out.println("고객 이름 입력과 바꿀 주소 입력 (예: 박지성,경북 구미시)");
        String input = sc.nextLine();
        String[] data = input.split(",");

        try{
            Statement stmt;
            String update = "UPDATE Customer SET address = '" + data[1] + "' WHERE name = '" + data[0] + "'";
            ResultSet rs;
            stmt = con.createStatement();
            stmt.executeUpdate(update);

            String query = "SELECT name, address FROM Customer";
            rs = stmt.executeQuery(query);

            System.out.println("Name\tAddress");
            while(rs.next()){
                System.out.print(rs.getString(1));
                System.out.println("\t" + rs.getString(2));
            }
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
