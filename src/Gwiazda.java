import wartosci.Polkula;
import execptions.*;
import wartosci.LiteryGreckie;

import java.util.InputMismatchException;

public class Gwiazda {
    String Nazwa;
    LiteryGreckie NazwaKatalogowa = LiteryGreckie.Alpha;
    int deklinacja;
    int rektascensja;
    double obserwowanaWielkoscGwiazdowa;
    double absolutnaWielkoscGwiazdowa;
    double lataSwietlne;
    String gwiazdozbior;
    Polkula polkula;
    double masaWSkaliSlonca;
    int temperatura;

    public Gwiazda(String nazwa, String gwiazdozbior, Polkula polkula, double masaWSkaliSlonca, int temperatura, String deklinacja, String rektascensja, double obserwowanaWielkoscGwiazdowa, double absolutnaWielkoscGwiazdowa ,LiteryGreckie nazwaKatalogowa

    ) throws ZlaNazwa, ZlaDeklinacja, ZlaRektascensja, ZlaObserwowanaWielkoscGwiazdowa, ZlaMasaGwiazdy, ZlaTemperatura {
        setNazwa(nazwa); //
        NazwaKatalogowa = nazwaKatalogowa; //
        setDeklinacja(deklinacja);//
        setRektascensja(rektascensja);//
        setObserwowanaWielkoscGwiazdowa(obserwowanaWielkoscGwiazdowa);
        setAbsolutnaWielkoscGwiazdowaILataSwietlne(absolutnaWielkoscGwiazdowa);
        setGwiazdozbior(gwiazdozbior); //
        setPolkula(polkula);//
        setMasaWSkaliSlonca(masaWSkaliSlonca); //
        setTemperatura(temperatura); //

    }

    public Gwiazda() {
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
    public void setDeklinacja(String wspolrzedne) throws ZlaDeklinacja {
        try {
            deklinacja = Integer.parseInt(wspolrzedne.substring(0,wspolrzedne.indexOf("stopni")).replace(" ",""));
        }catch (InputMismatchException e ){
            throw new ZlaDeklinacja("Niepoprawny format danych");
        }catch (StringIndexOutOfBoundsException e){
            throw new ZlaDeklinacja("Niepoprawny format danych");
        }
        if(deklinacja > 90 || deklinacja < 0) throw new ZlaDeklinacja("Deklinacja nie z zakresu");
        if (polkula == Polkula.PD){
            deklinacja = -1*deklinacja;
        }
    }

    public void setRektascensja(String czas) throws ZlaRektascensja {
        try {
            rektascensja = Integer.parseInt(czas.substring(0, czas.indexOf('h')).replace(" ", ""));
        } catch (Exception e) {
            throw new ZlaRektascensja("Zla Rektascensja");
        }
        if (rektascensja > 24 || rektascensja < 0) {
            throw new ZlaRektascensja("Nieprawidłowy format czasu");
        }
    }
    public void setObserwowanaWielkoscGwiazdowa(double obserwowanaWielkoscGwiazdowa) throws ZlaObserwowanaWielkoscGwiazdowa {
        if (obserwowanaWielkoscGwiazdowa < -26.74 || obserwowanaWielkoscGwiazdowa > 15.00) {
            throw new ZlaObserwowanaWielkoscGwiazdowa("Zly zakres wartosci");
        } else {
            this.obserwowanaWielkoscGwiazdowa = obserwowanaWielkoscGwiazdowa;
        }
    }
    public void setAbsolutnaWielkoscGwiazdowaILataSwietlne(double r) {
        absolutnaWielkoscGwiazdowa = obserwowanaWielkoscGwiazdowa - (5 * Math.log10(r)) + 5;
        lataSwietlne = 3.26 * r;
    }
    public void setGwiazdozbior(String gwiazdozbior) {
        this.gwiazdozbior = gwiazdozbior;
    }

    public void setTemperatura(int temperatura) throws ZlaTemperatura {
        if (temperatura < 2000) {
            throw new ZlaTemperatura("Temperatura musi byc wieksza niz 2000 C");
        }
        this.temperatura =temperatura;
    }
    public void setPolkula(Polkula polkula) {
        this.polkula = polkula;
    }
    public void setMasaWSkaliSlonca(double masaWSkaliSlonca) throws ZlaMasaGwiazdy {
        if (masaWSkaliSlonca < 0.1 || masaWSkaliSlonca > 50.0) {
            throw new ZlaMasaGwiazdy("Masa Gwiazdy musi się mieścic w zakresie od 0.1 do 50");
        } else {
            this.masaWSkaliSlonca = masaWSkaliSlonca;
        }
    }
    @Override
    public String toString() {
        return "Gwiazda{" +
                "Nazwa='" + Nazwa + '\'' +
                ", NazwaKatalogowa=" + NazwaKatalogowa +
                ", deklinacja=" + deklinacja +
                ", rektascensja=" + rektascensja +
                ", obserwowanaWielkoscGwiazdowa=" + obserwowanaWielkoscGwiazdowa +
                ", absolutnaWielkoscGwiazdowa=" + absolutnaWielkoscGwiazdowa +
                ", lataSwietlne=" + lataSwietlne +
                ", gwiazdozbior='" + gwiazdozbior + '\'' +
                ", polkula=" + polkula +
                ", masaWSkaliSlonca=" + masaWSkaliSlonca +
                ", temperatura=" + temperatura +
                '}';
    }
}

