import wartosci.LiteryGreckie;
import wartosci.Polkula;

import java.io.IOException;
import java.util.*;


public class IndeksGwiazd {

    ArrayList<Gwiazda> indeks = new ArrayList<Gwiazda>();
    static final String naglowek = String.format("|%-10s", "Nazwa")
            + String.format("|%-20s", "Nazwa Katalogowa")
            + String.format("|%-20s", "Gwiazdozbior")
            + String.format("|%-20s", "Deklinacja")
            + String.format("|%-20s", "Rektascensja")
            + String.format("|%-35s", "Obserwowana Wielkosc Gwiazdowa")
            + String.format("|%-35s", "Absolutna Wielkosc Gwiazdowa")
            + String.format("|%-20s", "Lata Swietlne")
            + String.format("|%-10s", "Polkula")
            + String.format("|%-20s", "Masa w skali slonca")
            + String.format("|%-20s|", "Temperatura");

    public IndeksGwiazd() {
    }

    public void wczytajZPliku() {
        try {
            indeks = Serializacja.deserializeFromXML();
        } catch (IOException e) {
            System.out.println("Błąd pliku");
        }
    }

    public void zapiszDoPliku() {
        try {
            Serializacja.serializeToXML(indeks);
        } catch (IOException e) {
            System.out.println("Błąd pliku" + e.toString());
        }
    }

    public void dodaj() {
        Gwiazda gwiazda = new Gwiazda();
        boolean czyZawiera = true;
        while (czyZawiera) {
            gwiazda.insertNazwa();
            for (Gwiazda x : indeks
            ) {
                if (x.Nazwa.equals(gwiazda.Nazwa)) {
                    czyZawiera = false;
                    break;
                }
            }
            if (!czyZawiera) {
                System.out.println("Gwiazda już jest w spisie");
                break;
            }
            gwiazda.insertGwiazdozbior();
            gwiazda.NazwaKatalogowa = LiteryGreckie.values()[setNazwaKatalogowa(gwiazda.gwiazdozbior)];
            gwiazda.insertPolkula();
            gwiazda.insertMasaWzgledemSlonca();
            gwiazda.insertTemperatura();
            gwiazda.insertDeklinacja();
            gwiazda.insertRektascensja();
            gwiazda.insertObserwowanaWielkoscGwiazdowa();
            gwiazda.insertAbsolutnaWielkoscGwiazdowaILataSwietlne();
            indeks.add(gwiazda);
            czyZawiera = false;
            System.out.println("Dodano");
        }
    }

    public void usun() {
        System.out.println("Podaj nazwe gwiazdy do usuniecia:");
        String nazwaDoUsuniecia = (new Scanner(System.in)).nextLine();
        boolean czyUsunieto = false;
        String gwiazdozbior = "";
        for (Gwiazda gwiazda : indeks
        ) {
            if (gwiazda.Nazwa.equals(nazwaDoUsuniecia)) {
                gwiazdozbior = gwiazda.gwiazdozbior;
                indeks.remove(gwiazda);
                czyUsunieto = true;
                break;
            }
        }
        if (czyUsunieto) {
            System.out.println("Usunieto gwiazde");
            int numerWGwiazdozbiorze = 0;
            for (Gwiazda gwiazda : indeks
            ) {
                if (gwiazda.gwiazdozbior.equals(gwiazdozbior)) {
                    gwiazda.NazwaKatalogowa = LiteryGreckie.values()[numerWGwiazdozbiorze];
                    numerWGwiazdozbiorze++;
                }
            }
        } else System.out.println("Brak podanej gwiazdy");
    }

    public void wypisz() {
        IndeksGwiazd.wypisz(indeks);
    }

    public void wyszukaj() {
        System.out.println("Podaj nazwę gwiazdy:");
        String szukanaGwiazda = (new Scanner(System.in)).nextLine();
        String wyszukana = "";
        for (Gwiazda gwiazda : indeks
        ) {
            if (gwiazda.Nazwa.equals(szukanaGwiazda)) {
                wypisz(gwiazda);
                break;
            }
        }
    }

    public void wyszukajParseki() {
        double r = -1;
        boolean loop = true;
        System.out.println("Podaj parseki:");
        while (loop) {
            try {
                r = (new Scanner(System.in)).nextDouble();
                loop = false;
            } catch (InputMismatchException e) {
                System.out.println("Oczekiwano liczby zmienno przecinkowej");
            }
        }

        ArrayList<Gwiazda> wyniki = new ArrayList<Gwiazda>();
        for (Gwiazda gwiazda : indeks
        ) {
            if (r * 3.26 == gwiazda.lataSwietlne) {
                wyniki.add(gwiazda);
            }
        }
        IndeksGwiazd.wypisz(wyniki);

    }

    public void wyszukajTemperatura() {
        int dol = -1;
        int gora = -1;
        boolean loop = true;
        while (loop) {
            try {
                System.out.println("Podaj dolna granice");
                dol = (new Scanner(System.in)).nextInt();
                System.out.println("Podaj gorna granice");
                gora = (new Scanner(System.in)).nextInt();
                loop = false;
            } catch (InputMismatchException e) {
                System.out.println("Oczekiwano liczby całkowitej");
            }
        }
        ArrayList<Gwiazda> wynik = new ArrayList<Gwiazda>();
        for (Gwiazda gwiazda : indeks
        ) {
            if (gwiazda.temperatura > dol && gwiazda.temperatura < gora) {
                wynik.add(gwiazda);
            }
        }
        wypisz(wynik);

    }

    public void wyszukajMase() {
        double dol = -1;
        double gora = -1;
        boolean loop = true;
        while (loop) {
            try {
                System.out.println("Podaj dolna granice");
                dol = (new Scanner(System.in)).nextDouble();
                System.out.println("Podaj gorna granice");
                gora = (new Scanner(System.in)).nextDouble();
                loop = false;
            } catch (InputMismatchException e) {
                System.out.println("Oczekiwano liczby zmienno przecinkowej");
            }
        }
        ArrayList<Gwiazda> wyniki = new ArrayList<Gwiazda>();
        for (Gwiazda gwiazda : indeks
        ) {
            if (gwiazda.masaWSkaliSlonca > dol && gwiazda.masaWSkaliSlonca < gora) {
                wyniki.add(gwiazda);
            }
        }
        System.out.println("Gwiazdy spełniajace kryteria");
        IndeksGwiazd.wypisz(wyniki);

    }

    public void wyszukjaPolkula() {
        int i = -1;
        boolean loop = true;
        System.out.println("1.PN, 2.PD");
        while (loop) {
            try {
                i = (new Scanner(System.in)).nextInt() - 1;
                if (!(i == 0 || i == 1)) throw new InputMismatchException();
                loop = false;
            } catch (InputMismatchException e) {
                System.out.println("Zły wybor");
            }
        }
        ArrayList<Gwiazda> wynik = new ArrayList<Gwiazda>();
        for (Gwiazda gwiazda : indeks
        ) {
            if (Polkula.values()[i] == gwiazda.polkula) {
                wynik.add(gwiazda);
            }
        }
        if (!wynik.isEmpty()) {
            IndeksGwiazd.wypisz(wynik);
        } else {
            System.out.println("Nie ma gwiazd na tej polkuli");
        }
    }

    public void wyszukajPotencjalneSupernowy() {
        ArrayList<Gwiazda> wynik = new ArrayList<Gwiazda>();
        for (Gwiazda gwiazda : indeks
        ) {
            if (gwiazda.masaWSkaliSlonca > 1.44) {
                wynik.add(gwiazda);
            }
        }
        if (!wynik.isEmpty()) {
            wypisz(wynik);
        } else {
            System.out.println("Nie ma gwiazd supernovy");
        }
    }

    public void wyszukajPoAbsolutnejWielkosciGwiazdowej() {
        double dol = -1;
        double gora = -1;
        boolean loop = true;
        while (loop) {
            try {
                System.out.println("Podaj dolna granice");
                dol = (new Scanner(System.in)).nextDouble();
                System.out.println("Podaj gorna granice");
                gora = (new Scanner(System.in)).nextDouble();
                loop = false;
            } catch (InputMismatchException e) {
                System.out.println("Oczekiwano liczby zmienno przecinkowej");
            }
        }
        ArrayList<Gwiazda> wynik = new ArrayList<Gwiazda>();
        for (Gwiazda gwiazda : indeks
        ) {
            if (gwiazda.absolutnaWielkoscGwiazdowa > dol && gwiazda.absolutnaWielkoscGwiazdowa < gora) {
                wynik.add(gwiazda);
            }
        }
        if (!wynik.isEmpty()) {
            wypisz(wynik);
        } else {
            System.out.println("Nie ma gwiazd z tą wielkoscia");
        }
    }

    private static String kreska() {
        String krecha = "";
        for (int i = 0; i < naglowek.length(); i++) {
            krecha += "_";
        }
        return krecha + "\n";
    }

    private int setNazwaKatalogowa(String gwiazdozbior) {
        int suma = 0;
        for (Gwiazda g : indeks
        ) {
            if (g.gwiazdozbior.equals(gwiazdozbior)) {
                suma++;
            }
            if (suma == 22) break;
        }
        return suma;
    }

    private static void wypisz(ArrayList<Gwiazda> lista) {
        System.out.println(kreska());
        System.out.println(naglowek);
        for (Gwiazda x : lista
        ) {
            System.out.println(kreska());
            System.out.println(x.toString());
        }
        System.out.println(kreska());
    }
    private static void wypisz(Gwiazda gwiazda) {
        System.out.println(kreska());
        System.out.println(naglowek);
        System.out.println(gwiazda);
        System.out.println(kreska());
    }

    //metody potrzebne do serializacji
    public ArrayList<Gwiazda> getIndeks() {
        return indeks;
    }

    public void setIndeks(ArrayList<Gwiazda> indeks) {
        this.indeks = indeks;
    }

}
