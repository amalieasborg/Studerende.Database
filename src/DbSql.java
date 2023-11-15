import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class DbSql {
    private Connection connection;
    private Statement stmt;
    private Statement stmt1;

    DbSql() {
        connection = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:C://Users/Bruger/Documents/Zealand/StuderendeDataBase.db";
            connection = DriverManager.getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void opretStuderende(Studerende s){
        try {
            String sql = "insert into Studerende (stdnr,fnavn,enavn,adresse,postnr,mobil,klasse)";
            sql+="values ("+String.valueOf(s.getStdnr())+",'"+s.getFnavn()+"','"+s.getEnavn()+"','"+s.getAdresse()+"','"+s.getPostnr()+"','"+s.getMobil()+"','"+s.getKlasse()+"')";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }



    public void alleStuderende(){
        try {
            String sql = "select * from Studerende";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Connection to SQLite has been established.");
            while (rs.next()) {
                System.out.println(rs.getInt("stdnr"));
                System.out.println(rs.getString("fnavn"));
                System.out.println(rs.getString("enavn"));
                System.out.println(rs.getString("adresse"));
                System.out.println(rs.getString("postnr"));
                System.out.println(rs.getString("mobil"));
                System.out.println(rs.getString("klasse"));
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }



}