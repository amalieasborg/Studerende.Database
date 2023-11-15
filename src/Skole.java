import java.util.ArrayList;

public class Skole {
    private ArrayList<Studerende> studerendeListe = new ArrayList<>();
    private ArrayList<Fag> fagListe = new ArrayList<>();
    private ArrayList<Laerer> laererListe = new ArrayList<>();

    public Skole() {
    }

    public Skole(ArrayList<Studerende> studerendeListe, ArrayList<Fag> fagListe, ArrayList<Laerer> laererListe) {
        this.studerendeListe = studerendeListe;
        this.fagListe = fagListe;
        this.laererListe = laererListe;
    }

    public ArrayList<Studerende> getStuderendeListe() {
        return studerendeListe;
    }

    public void setStuderendeListe(ArrayList<Studerende> studerendeListe) {
        this.studerendeListe = studerendeListe;
    }

    public ArrayList<Fag> getFagListe() {
        return fagListe;
    }

    public void setFagListe(ArrayList<Fag> fagListe) {
        this.fagListe = fagListe;
    }

    public ArrayList<Laerer> getLaererListe() {
        return laererListe;
    }

    public void setLaererListe(ArrayList<Laerer> laererListe) {
        this.laererListe = laererListe;
    }

    public void tilmeldStuderendeSkole(Studerende s) {
        studerendeListe.add(s);
    }

    public void tilmeldFagSkole(Fag f) {
        fagListe.add(f);
    }

    public void tilmeldLaererSkole(Laerer l) {
        laererListe.add(l);
    }

    public Studerende getStuderende(int stdnr) {
        int index = getStuderendeIndexNr(stdnr);
        return studerendeListe.get(index);
    }

    public Fag getFag(int fagnr) {
        int index = getFagIndexNr(fagnr);
        return fagListe.get(index);
    }

    public Laerer getLaerer(int laerernr) {
        int index = getLaererIndexNr(laerernr);
        return laererListe.get(index);
    }

    private int getStuderendeIndexNr(int stdnr) {
        for (int i = 0; i < studerendeListe.size(); i++) {
            if (studerendeListe.get(i).getStdnr() == stdnr)
                return i;
        }
        return -1;
    }

    private int getStuderendeIndexNr(Studerende s) {
        return studerendeListe.indexOf((s));
    }


    private int getFagIndexNr(int fagnr) {
        for (int i = 0; i < fagListe.size(); i++) {
            if (fagListe.get(i).getFagnr() == fagnr)
                return i;
        }
        return -1;
    }

    private int getFagIndexNr(Fag f) {
        return fagListe.indexOf((f));
    }


    private int getLaererIndexNr(int lnr) {
        for (int i = 0; i < laererListe.size(); i++) {
            if (laererListe.get(i).getlnr() == lnr)
                return i;
        }
        return -1;
    }

    private int getLaererIndexNr(Laerer l) {
        return laererListe.indexOf((l));
    }

    public void tilmeldStuderendeFag(Studerende s, Fag f) {
        int sindex = getStuderendeIndexNr(s);
        int findex = getFagIndexNr(f);
        studerendeListe.get(sindex).tilmeldFag(f);
        fagListe.get(findex).tilmeldStuderende(s);
    }

    public void tilmeldStuderendeFag(int stdnr, int fagnr) {
        Studerende s = studerendeListe.get(getStuderendeIndexNr(stdnr));
        Fag f = fagListe.get(getFagIndexNr(fagnr));
        tilmeldStuderendeFag(s, f);
    }

    public void tilmeldLaererFag(int lnr, int fagnr) {
        Laerer l = laererListe.get(getLaererIndexNr(lnr));
        Fag f = fagListe.get(getFagIndexNr(fagnr));
        l.tilmeldFag(f);
        f.setL(l);
    }

    public void frameldStuderendeFag(int stdnr, int fagnr) {
        Studerende s = studerendeListe.get(getStuderendeIndexNr(stdnr));
        Fag f = fagListe.get(getFagIndexNr(fagnr));
        s.frameldFag(f);
        f.frameldStuderende(s);
    }

}

