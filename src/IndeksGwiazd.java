import wartosci.LiteryGreckie;
import wartosci.Polkula;

import java.io.IOException;
import java.util.*;


public class IndeksGwiazd {

    ArrayList<Gwiazda> indeks = new ArrayList<>();
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

    public void add() {
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

    public void remove() {
        System.out.println("Podaj nazwe gwiazdy do usuniecia:");
        String nazwaDoUsuniecia = (new Scanner(System.in)).nextLine();
        boolean czyUsunieto = false;
        String gwiazdozbior = "";
        for (Gwiazda x : indeks
        ) {
            if (x.Nazwa.equals(nazwaDoUsuniecia)) {
                gwiazdozbior = x.gwiazdozbior;
                indeks.remove(x);
                czyUsunieto = true;
                break;
            }
        }
        if (czyUsunieto) {
            System.out.println("Usunieto gwiazde");
            int a = 0;
            for (Gwiazda x : indeks
            ) {
                if (x.gwiazdozbior.equals(gwiazdozbior)) {
                    x.NazwaKatalogowa = LiteryGreckie.values()[a];
                    a++;
                }
            }
        } else System.out.println("Brak podanej gwiazdy");
    }

    public void wypisz() {
        System.out.println(kreska());
        System.out.println(naglowek);
        for (Gwiazda x : indeks
        ) {
            System.out.println(kreska());
            System.out.println(x.toString());
        }
        System.out.println(kreska());
    }

    public void wyszukaj() {
        System.out.println("Podaj nazwę gwiazdy:");
        String szukanaGwiazda = (new Scanner(System.in)).nextLine();
        String wyszukana = "";
        for (Gwiazda x : indeks
        ) {
            if (x.Nazwa.equals(szukanaGwiazda)) {
                wyszukana = x.toString();
                break;
            }
        }
        if (!Objects.equals(wyszukana, "")) {
            System.out.println(kreska());
            System.out.println(naglowek);
            System.out.println(kreska());
            System.out.println(wyszukana);
            System.out.println(kreska());
        } else {
            System.out.println("Nie ma takie gwiazdy");
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

        String parsek = "";
        for (Gwiazda x : indeks
        ) {
            if (r * 3.26 == x.lataSwietlne) {
                parsek += x.toString() + "\n" + kreska() + "\n";
            }
        }
        if (!Objects.equals(parsek, "")) {
            System.out.println(kreska());
            System.out.println(naglowek);
            System.out.println(kreska());
            System.out.println(parsek);
        } else {
            System.out.println("Nie ma gwiazd w tym zasięgu");
        }
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
        String temperatura = "";
        for (Gwiazda x : indeks
        ) {
            if (x.temperatura > dol && x.temperatura < gora) {
                temperatura += x.toString() + "\n" + kreska() + "\n";
            }
        }
        if (!Objects.equals(temperatura, "")) {
            System.out.println(kreska());
            System.out.println(naglowek);
            System.out.println(kreska());
            System.out.println(temperatura);
        } else {
            System.out.println("Nie ma gwiazd z tą temperatura");
        }
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
        String masa = "";
        for (Gwiazda x : indeks
        ) {
            if (x.masaWSkaliSlonca > dol && x.masaWSkaliSlonca < gora) {
                masa += x.toString() + "\n" + kreska() + "\n";
            }
        }
        if (!Objects.equals(masa, "")) {
            System.out.println(kreska());
            System.out.println(naglowek);
            System.out.println(kreska());
            System.out.println(masa);
        } else {
            System.out.println("Nie ma gwiazd z tą masa");
        }
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
        String polkula = "";
        for (Gwiazda x : indeks
        ) {
            if (Polkula.values()[i] == x.polkula) {
                polkula += x.toString() + "\n" + kreska() + "\n";
            }
        }
        if (!Objects.equals(polkula, "")) {
            System.out.println(kreska());
            System.out.println(naglowek);
            System.out.println(kreska());
            System.out.println(polkula);
        } else {
            System.out.println("Nie ma gwiazd na tej polkuli");
        }
    }

    public void wyszukajPotencjalneSupernowy() {
        String masa = "";
        for (Gwiazda x : indeks
        ) {
            if (x.masaWSkaliSlonca > 1.44) {
                masa += x.toString() + "\n" + kreska() + "\n";
            }
        }
        if (!Objects.equals(masa, "")) {
            System.out.println(kreska());
            System.out.println(naglowek);
            System.out.println(kreska());
            System.out.println(masa);
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
        String absolutna = "";
        for (Gwiazda x : indeks
        ) {
            if (x.absolutnaWielkoscGwiazdowa > dol && x.absolutnaWielkoscGwiazdowa < gora) {
                absolutna += x.toString() + "\n" + kreska() + "\n";
            }
        }
        if (!Objects.equals(absolutna, "")) {
            System.out.println(kreska());
            System.out.println(naglowek);
            System.out.println(kreska());
            System.out.println(absolutna);
        } else {
            System.out.println("Nie ma gwiazd z tą masa");
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

    //metody potrzebne do serializacji
    public ArrayList<Gwiazda> getIndeks() {
        return indeks;
    }

    public void setIndeks(ArrayList<Gwiazda> indeks) {
        this.indeks = indeks;
    }

}
