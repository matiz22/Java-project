import wartosci.LiteryGreckie;

import java.util.ArrayList;

public class IndeksGwiazd {
    ArrayList<Gwiazda> indeks = new ArrayList<>();
    static final String nagglowek = String.format("|%-10s", "Nazwa") + String.format("|%-20s", "Nazwa Katalogowa") + String.format("|%-20s", "Gwiazdozbior") + String.format("|%-20s", "Deklinacja")
            + String.format("|%-20s", "Rektascensja") + String.format("|%-35s", "Obserwowana Wielkosc Gwiazdowa") + String.format("|%-35s", "Absolutna Wielkosc Gwiazdowa") + String.format("|%-20s", "Lata Swietlne")
            + String.format("|%-10s", "Polkula") + String.format("|%-20s", "Masa w skali slonca") + String.format("|%-20s|", "Temperatura");

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
            czyZawiera = true;
        }


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
        kreska();
        System.out.println(nagglowek);
        for (Gwiazda x : indeks
        ) {
            kreska();
            System.out.println(x.toString());
        }
        kreska();
    }

    private static void kreska() {
        for (int i = 0; i < 243; i++) {
            System.out.print('_');
        }
        System.out.println();
    }

}
