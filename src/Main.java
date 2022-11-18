import execptions.*;
import wartosci.LiteryGreckie;
import wartosci.Polkula;

public class Main {
    public static void main(String[] args) throws ZlaNazwa, ZlaDeklinacja, ZlaRektascensja, ZlaObserwowanaWielkoscGwiazdowa, ZlaTemperatura, ZlaMasaGwiazdy {
        IndeksGwiazd indeksGwiazd = new IndeksGwiazd();
        //indeksGwiazd.add();
        indeksGwiazd.indeks.add(new Gwiazda("JCJ2138", "Orzeł", Polkula.PN, 20, 2001, "50 stopni 50 minut 30.30 sekund", "12 h 30 min 23 ss", 14, 2, LiteryGreckie.Chi));
        indeksGwiazd.indeks.add(new Gwiazda("JCJ2138", "Orzeł", Polkula.PN, 20, 2001, "50 stopni 50 minut 30.30 sekund", "12 h 30 min 23 ss", 14, 2, LiteryGreckie.Chi));
        indeksGwiazd.indeks.add(new Gwiazda("JCJ2138", "Orzeł", Polkula.PN, 20, 2001, "50 stopni 50 minut 30.30 sekund", "12 h 30 min 23 ss", 14, 2, LiteryGreckie.Chi));
        indeksGwiazd.indeks.add(new Gwiazda("JCJ2137", "Orzeł", Polkula.PN, 20, 2001, "50 stopni 50 minut 30.30 sekund", "12 h 30 min 23 ss", 14, 2, LiteryGreckie.Chi));

        indeksGwiazd.wypisz();
        indeksGwiazd.add();
    }
}