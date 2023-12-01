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
    public void frameldStuderendeFraFag(Integer id){
        try {
            String sql = "DELETE FROM Studfag WHERE id=" + String.valueOf(id);
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void sletStud(Integer stdnr) {
        try {
            String sql = "DELETE FROM Studerende WHERE stdnr=" + String.valueOf(stdnr);
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void sletStudereneFraFag(Integer stdnr, Integer fagNr) {
        try {
            String sql = "DELETE FROM Studfag WHERE stdnr=" + String.valueOf(stdnr)+"AND fagNr = "+String.valueOf(fagNr);
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

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
    public ArrayList<Fag> alleFag(){
        ArrayList<Fag>fagliste=new ArrayList<>();
        try {
            String sql = "select * from Fag";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Fag f=new Fag();
                f.setFagnr(rs.getInt("fagnr"));
                f.setFagnavn(rs.getString("fagnavn"));
                fagliste.add(f);
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return fagliste;
    }
    public Studerende soegOplysningerStuderende(Integer stdnr){
        Studerende s1=new Studerende();
        try {
        String sql = "select * from Studerende where stdnr ="+ String.valueOf(stdnr);
        Statement stmt = connection.createStatement();
        stmt.execute(sql);
        System.out.println("Connection to SQLite has been established.");
        stmt.close();
    } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return s1;
    }



}