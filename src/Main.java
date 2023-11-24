import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Skole skole=new Skole();
        DbSql db=new DbSql();
        db.alleStuderende();


        Scanner input=new Scanner(System.in);
        System.out.println("1. Opret Studerende");
        System.out.println("2. Opret fag");
        System.out.println("3. Tilmeld studerende til fag");
        System.out.println("4. Frameld studerende fra fag");
        System.out.println("5. Udskriv alle studerende");
        System.out.println("6. Udskriv alle fag");
        System.out.println("7. Søg oplysninger om en studerende");
        System.out.println("8. Søg oplysninger om et fag");
        System.out.println("9. Slet studerende");
        System.out.println("Indtast dit valg: ");
        int valg=input.nextInt();
        switch(valg){
            case 1:
                Studerende s= new Studerende(10,"Kamilla","Andersen","Holbækvej 9","2200","89674523",'a');
                db.opretStuderende(s);
            break;
            case 2:
                Fag f1= new Fag(5,"Programmering");
                db.opretFag(f1);
            break;
            case 3:
                db.tilmeldStuderendeTilFag(5,4,12);
            break;
            case 4:

            break;
            case 5:
                ArrayList<Studerende>studliste=db.alleStuderende();
                udskrivAlleStuderende(studliste);
            break;
            case 6:
                ArrayList<Fag>fagliste=db.alleFag();
                udskrivAlleFag(fagliste);
            break;
            case 7:
                //System.out.println("Indtast studienummeret");
                //studerende s =db.soegOplysningerStuderende

            break;
            case 8:

            break;
            case 9:
                //db.sletStuderene();
                db.sletStud(14);
            break;
        }
    }
    public static void udskrivAlleStuderende(ArrayList<Studerende>a){
            System.out.println(a);

    }
    public static void udskrivAlleFag(ArrayList<Fag>a){
        System.out.println(a);
    }

}