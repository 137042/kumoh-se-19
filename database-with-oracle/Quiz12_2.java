package chapter5;

import java.sql.*;
import java.util.Scanner;

public class Quiz12_2 {

    Connection con;

    public Quiz12_2(){
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
            Statement stmt;
            ResultSet rs;

            String query = "SELECT * FROM Book";
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            System.out.println("Id\tName\t\t\t\tPublisher\t\tPrice");
            while(rs.next()){
                System.out.print(rs.getInt(1));
                System.out.printf("\t%-20s",rs.getString(2));
                System.out.printf("%s",rs.getString(3));
                System.out.printf("%10s\n",rs.getString(4));
            }

            Scanner sc = new Scanner(System.in);
            System.out.println("\n삽입할 도서 정보 (아이디,이름,출판사,가격)");
            String input = sc.nextLine();
            String[] data = input.split(",");

            String insert = "INSERT INTO Book(bookid, bookname, publisher, price)" +
                    " VALUES("+ data[0] +", '" + data[1] + "', '" + data[2] + "', " + data[3] + ")";
            stmt = con.createStatement();
            stmt.execute(insert);

            rs = stmt.executeQuery(query);
            System.out.println("\nId\tName\tPublisher\tPrice");
            while(rs.next()){
                System.out.print(rs.getInt(1));
                System.out.print("\t" + rs.getString(2));
                System.out.print("\t" + rs.getString(3));
                System.out.println("\t" + rs.getString(4));
            }
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
