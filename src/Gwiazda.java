import Wartosci.Polkula;
import execptions.*;
import Wartosci.LiteryGreckie;

public class Gwiazda {
    String Nazwa;
    LiteryGreckie NazwaKatalogowa = LiteryGreckie.Alpha;
    int deklinacja;

    int rektascensja;

    double obserwowanaWielkoscGwiazdowa;
    double absolutnaWielkoscGwiazdowa;
    int lataSwietlne;
    String gwiazdozbior;

    Polkula polkula;

    double masaWSkaliSlonca;

    int temperatura;

    public Gwiazda(String nazwa, LiteryGreckie nazwaKatalogowa, String deklinacja, String rektascensja, double obserwowanaWielkoscGwiazdowa,
                   double absolutnaWielkoscGwiazdowa, int lataSwietlne, String gwiazdozbior, Polkula polkula, double masaWSkaliSlonca, int temperatura
    ) throws ZlaNazwa, ZlaDeklinacja, ZlaRektascensja, ZlaObserwowanaWielkoscGwiazdowa, ZlaMasaGwiazdy, ZlaTemperatura {
        setNazwa(nazwa);
        NazwaKatalogowa = nazwaKatalogowa;
        setDeklinacja(deklinacja);
        setRektascensja(rektascensja);
        setObserwowanaWielkoscGwiazdowa(obserwowanaWielkoscGwiazdowa);
        setAbsolutnaWielkoscGwiazdowa(absolutnaWielkoscGwiazdowa);
        setLataSwietlne(lataSwietlne);
        setGwiazdozbior(gwiazdozbior);
        setPolkula(polkula);
        setMasaWSkaliSlonca(masaWSkaliSlonca);
        setTemperatura(temperatura);

    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String newName) throws ZlaNazwa {
        if (newName.length() != 7) {
            throw new ZlaNazwa("Zla długość nazwy gwiazdy");
        }
        char[] doSprawdzenia = newName.toCharArray();
        for (int i = 0; i < 7; i++) {
            if (i < 3) {
                if ((byte) doSprawdzenia[i] < 65 || (byte) doSprawdzenia[i] > 90) {
                    throw new ZlaNazwa("Powinna być wielka liter na początku");
                }
            } else {
                if ((byte) doSprawdzenia[i] < 48 || (byte) doSprawdzenia[i] > 57) {
                    throw new ZlaNazwa("4 ostatnie znaki to powinny być liczby");
                }
            }
        }
        this.Nazwa = newName;
    }

    public LiteryGreckie getNazwaKatalogowa() {
        return NazwaKatalogowa;
    }

    public void setNazwaKatalogowa(LiteryGreckie nazwaKatalogowa) {
        NazwaKatalogowa = nazwaKatalogowa;
    }

    public int getDeklinacja() {
        return deklinacja;
    }

    public void setDeklinacja(String wspolrzedne) throws ZlaDeklinacja {
        if (wspolrzedne.contains("N")) {
            try {
                deklinacja = Integer.parseInt(wspolrzedne.substring(0, wspolrzedne.indexOf("N")).replace(" ", ""));
                if (deklinacja < 0 || deklinacja > 90) {
                    throw new ZlaDeklinacja("Zły zakres współrzędnych");
                }
            } catch (Exception e) {
                throw new ZlaDeklinacja("Nie własciwy format współrzędncyh");
            }
        } else if (wspolrzedne.contains("S")) {
            try {
                deklinacja = -1 * Integer.parseInt(wspolrzedne.substring(0, wspolrzedne.indexOf("S")).replace(" ", ""));
                if (deklinacja < -90 || deklinacja > 0) {
                    throw new ZlaDeklinacja("Zły zakres współrzędnych");
                }
            } catch (Exception e) {
                throw new ZlaDeklinacja("Nie własciwy format współrzędncyh");
            }
        } else {
            throw new ZlaDeklinacja("Nie własciwy format współrzędncyh");
        }
    }

    public int getRektascensja() {
        return rektascensja;
    }

    public void setRektascensja(String czas) throws ZlaRektascensja {
        try {
            rektascensja = Integer.parseInt(czas.substring(0, czas.indexOf('h')).replace(" ", ""));
            if (rektascensja > 24 || rektascensja < 0) {
                throw new ZlaRektascensja("Nie prawidłowy format czasu");
            }
        } catch (Exception e) {
            throw new ZlaRektascensja("Zla Rektascensja");
        }
    }

    public double getObserwowanaWielkoscGwiazdowa() {
        return obserwowanaWielkoscGwiazdowa;
    }

    public void setObserwowanaWielkoscGwiazdowa(double obserwowanaWielkoscGwiazdowa) throws ZlaObserwowanaWielkoscGwiazdowa {
        if (obserwowanaWielkoscGwiazdowa < -26.74 || obserwowanaWielkoscGwiazdowa > 15.00) {
            throw new ZlaObserwowanaWielkoscGwiazdowa("Zly zakres wartosci");
        } else {
            this.obserwowanaWielkoscGwiazdowa = obserwowanaWielkoscGwiazdowa;
        }
    }

    public double getAbsolutnaWielkoscGwiazdowa() {
        return absolutnaWielkoscGwiazdowa;
    }

    public void setAbsolutnaWielkoscGwiazdowa(double r) {
        absolutnaWielkoscGwiazdowa = obserwowanaWielkoscGwiazdowa - (5 * Math.log10(r)) + 5;
    }

    public int getLataSwietlne() {
        return lataSwietlne;
    }

    public void setLataSwietlne(int lataSwietlne) {
        this.lataSwietlne = lataSwietlne;
    }

    public String getGwiazdozbior() {
        return gwiazdozbior;
    }

    public void setGwiazdozbior(String gwiazdozbior) {
        this.gwiazdozbior = gwiazdozbior;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) throws ZlaTemperatura {
        if (temperatura < 2000) {
            throw new ZlaTemperatura("Temperatura musi byc wieksza niz 2000 C");
        }
    }

    public Polkula getPolkula() {
        return polkula;
    }

    public void setPolkula(Polkula polkula) {
        this.polkula = polkula;
    }

    public double getMasaWSkaliSlonca() {
        return masaWSkaliSlonca;
    }

    public void setMasaWSkaliSlonca(double masaWSkaliSlonca) throws ZlaMasaGwiazdy {
        if (masaWSkaliSlonca < 0.1 || masaWSkaliSlonca > 50.0) {
            throw new ZlaMasaGwiazdy("Masa Gwiazdy musi się mieścic w zakresie od 0.1 do 50");
        } else {
            this.masaWSkaliSlonca = masaWSkaliSlonca;
        }
    }


}

