import wartosci.LiteryGreckie;
import java.util.ArrayList;

public class IndeksGwiazd {
    ArrayList<Gwiazda> indeks = new ArrayList<>();
    static final String nagglowek = String.format("|%-10s", "Nazwa") + String.format("|%-20s", "Nazwa Katalogowa") + String.format("|%-20s", "Deklinacja") + String.format("|%-20s", "Rektascensja")
            + String.format("|%-35s", "Obserwowana Wielkosc Gwiazdowa") + String.format("|%-35s", "Absolutna Wielkosc Gwiazdowa") + String.format("|%-20s", "Lata Swietlne")
            + String.format("|%-20s", "Gwiazdozbior") + String.format("|%-10s", "Polkula") + String.format("|%-20s", "Masa w skali slonca") + String.format("|%-20s|", "Temperatura");

    public void add() {
        Gwiazda gwiazda = new Gwiazda();
        gwiazda.insertNazwa();
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

    public void wypisz() {

        System.out.println(nagglowek);
        for (Gwiazda x : indeks
        ) {
            System.out.println(x.toString());
        }
    }

}
