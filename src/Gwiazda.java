import wartosci.Polkula;
import execptions.*;
import wartosci.LiteryGreckie;

import java.util.InputMismatchException;
import java.util.Scanner;

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
    static Scanner scanner = new Scanner(System.in);

    public Gwiazda(String nazwa, String gwiazdozbior, Polkula polkula, double masaWSkaliSlonca, int temperatura, String deklinacja, String rektascensja, double obserwowanaWielkoscGwiazdowa, double absolutnaWielkoscGwiazdowa, LiteryGreckie nazwaKatalogowa

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
            deklinacja = Integer.parseInt(wspolrzedne.substring(0, wspolrzedne.indexOf("stopni")).replace(" ", ""));
        } catch (InputMismatchException e) {
            throw new ZlaDeklinacja("Niepoprawny format danych");
        } catch (StringIndexOutOfBoundsException e) {
            throw new ZlaDeklinacja("Niepoprawny format danych");
        }
        if (deklinacja > 90 || deklinacja < 0) throw new ZlaDeklinacja("Deklinacja nie z zakresu");
        if (polkula == Polkula.PD) {
            deklinacja = -1 * deklinacja;
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
        this.temperatura = temperatura;
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

    public void insertNazwa() {
        System.out.println("Podaj nazwę 3 Duże literi i 4 Cyfry np: JCJ2138");
        boolean loop = true;
        while (loop) {
            try {
                setNazwa(scanner.next());
                loop = false;
            } catch (ZlaNazwa e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void insertGwiazdozbior() {
        System.out.println("Podaj gwiazdozbiór: ");
        gwiazdozbior = scanner.next();
    }

    public void insertPolkula() {
        System.out.println("Wybierz półkulę 1.PN, 2.PD wpisz odpowiednia cyfre");
        boolean loop = true;
        while (loop) {
            try {
                polkula = Polkula.values()[scanner.nextInt() - 1];
                loop = false;
            } catch (Exception e) {
                System.out.println("Zła wartość");
            }
        }
    }

    public void insertMasaWzgledemSlonca() {
        System.out.println("Podaj mase wzgledem słońca, min 0.1 max 50");
        boolean loop = true;
        while (loop) {
            try {
                setMasaWSkaliSlonca(scanner.nextDouble());
                loop = false;
            } catch (ZlaMasaGwiazdy e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void insertTemperatura() {
        System.out.println("Podaj temperature min 2000");
        boolean loop = true;
        while (loop) {
            try {
                setTemperatura(scanner.nextInt());
                loop = false;
            } catch (ZlaTemperatura e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Oczekiwano liczby całkowitej");
            }
        }
    }

    public void insertDeklinacja() {
        System.out.println("Podaj deklinacje, format współrzędnych np. xx stopni yy minut zz.zz sekund");
        boolean loop = true;
        while (loop) {
            try {
                setDeklinacja(scanner.nextLine());
                loop = false;
            } catch (ZlaDeklinacja e) {
                System.out.println(e.getMessage());
            }
        }
    } //TODO pierwszy input jest zly

    public void insertRektascensja() {
        System.out.println("Podaj rektascensje, format przykładowych danych: 12 h 30 min 23 ss");
        boolean loop = true;
        while (loop) {
            try {
                setRektascensja(scanner.nextLine());
                loop = false;
            } catch (ZlaRektascensja e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void insertObserwowanaWielkoscGwiazdowa() {
        System.out.println("Podaj obserwowalną wielkośc gwiazdowa z zakresu od -26.74 do 15.00");
        boolean loop = true;
        while (loop) {
            try {
                setObserwowanaWielkoscGwiazdowa(scanner.nextDouble());
                loop = false;
            } catch (ZlaObserwowanaWielkoscGwiazdowa e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Oczekiwano liczby zmienno przecinkowej");
            }
        }
    }

    public void insertAbsolutnaWielkoscGwiazdowaILataSwietlne() {
        System.out.println("Podaj odległość od gwiazdy w parsekach");
        boolean loop = true;
        while (loop) {
            try {
                setAbsolutnaWielkoscGwiazdowaILataSwietlne(scanner.nextDouble());
                loop = false;
            } catch (InputMismatchException e) {
                System.out.println("Oczekiwano liczby zmienno przecinkowej");
            }
        }
    }


    @Override
    public String toString() {
        return String.format("|%-10s", Nazwa)
                + String.format("|%-20s", NazwaKatalogowa)
                + String.format("|%-20s", gwiazdozbior)
                + String.format("|%-20s", deklinacja)
                + String.format("|%-20s", rektascensja)
                + String.format("|%-35s", obserwowanaWielkoscGwiazdowa)
                + String.format("|%-35s", absolutnaWielkoscGwiazdowa)
                + String.format("|%-20s", lataSwietlne)
                + String.format("|%-10s", polkula)
                + String.format("|%-20s", masaWSkaliSlonca)
                + String.format("|%-20s|", temperatura);
    }
}

