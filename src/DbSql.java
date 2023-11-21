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
    public void opretFag(Fag f){
        try {
            String sql = "insert into Fag (fagNr,fagNavn)";
            sql+="values ("+String.valueOf(f.getFagnr())+",'"+f.getFagnavn()+"')";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void tilmeldStuderendeTilFag(int stdnr, int fagNr,int kar){
        try {
            String sql = "insert into Studfag(stdnr,fagNr,kar)values(";
            sql+=String.valueOf(stdnr)+","+String.valueOf(fagNr)+","+String.valueOf(kar)+")";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");

            stmt.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    /*public void frameldStuderendeFraFag(){
        try {
            String sql = "insert into Studfag(stdnr,fagNr,kar)values(";
            sql+=String.valueOf(stdnr)+","+String.valueOf(fagNr)+","+String.valueOf(kar)+")";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");

            stmt.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }*/

    public ArrayList<Studerende> alleStuderende(){
        ArrayList<Studerende>studliste=new ArrayList<>();
        try {
            String sql = "select * from Studerende";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {
                Studerende s=new Studerende();
                s.setStdnr(rs.getInt("stdnr"));
                s.setFnavn(rs.getString("fnavn"));
                s.setEnavn(rs.getString("enavn"));
                s.setAdresse(rs.getString("adresse"));
                s.setPostnr(rs.getString("postnr"));
                s.setMobil(rs.getString("mobil"));
                String k=rs.getString("klasse");
                s.setKlasse(k.charAt(0));
                studliste.add(s);
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studliste;
    }
    public void alleFag(){
        try {
            String sql = "select * from Fag";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Connection to SQLite has been established.");
            while (rs.next()) {
                System.out.println(rs.getInt("fagNr"));
                System.out.println(rs.getString("fagNavn"));
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}