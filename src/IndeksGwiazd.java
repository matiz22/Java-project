import execptions.*;
import wartosci.LiteryGreckie;
import wartosci.Polkula;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IndeksGwiazd {
    ArrayList<Gwiazda> indeks = new ArrayList<>();

    public void add() {
        Gwiazda gwiazda = new Gwiazda();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę 3 Duże literi i 4 Cyfry np: JCJ2138");
        boolean loop = true;
        while (loop) {
            try {
                gwiazda.setNazwa(scanner.next());
                loop = false;
            } catch (ZlaNazwa e) {
                System.out.println(e.getMessage());
            }
        }
        loop = true;
        System.out.println("Podaj gwiazdozbiór: ");
        gwiazda.gwiazdozbior = scanner.next();
        gwiazda.NazwaKatalogowa = LiteryGreckie.values()[setNazwaKatalogowa(gwiazda.gwiazdozbior)];
        System.out.println("Wybierz półkulę 1.PN, 2.PD wpisz odpowiednia cyfre");
        while (loop) {
            try {
                gwiazda.polkula = Polkula.values()[scanner.nextInt() - 1];
                loop = false;
            } catch (Exception e) {
                System.out.println("Zła wartość");
            }
        }
        loop = true;
        System.out.println("Podaj mase wzgledem słońca, min 0.1 max 50");
        while (loop) {
            try {
                gwiazda.setMasaWSkaliSlonca(scanner.nextDouble());
                loop = false;
            } catch (ZlaMasaGwiazdy e) {
                System.out.println(e.getMessage());
            }
        }
        loop = true;
        System.out.println("Podaj temperature min 2000");
        while (loop) {
            try {
                gwiazda.setTemperatura(scanner.nextInt());
                loop = false;
            } catch (ZlaTemperatura e) {
                System.out.println(e.getMessage());
            }catch (InputMismatchException e){
                System.out.println("Oczekiwano liczby całkowitej");
            }
        }
        loop = true;
        System.out.println("Podaj deklinacje, format współrzędnych np. xx stopni yy minut zz.zz sekund");
        while (loop) {
            try {
                gwiazda.setDeklinacja(scanner.nextLine());
                loop = false;
            } catch (ZlaDeklinacja e) {
                System.out.println(e.getMessage());
            }
        }
        loop = true;
        System.out.println("Podaj rektascensje, format przykładowych danych: 12 h 30 min 23 ss");
        while (loop) {
            try {
                gwiazda.setRektascensja(scanner.nextLine());
                loop = false;
            } catch (ZlaRektascensja e) {
                System.out.println(e.getMessage());
            }
        }
        loop = true;
        System.out.println("Podaj obserwowalną wielkośc gwiazdowa z zakresu od -26.74 do 15.00");
        while (loop) {
            try {
                gwiazda.setObserwowanaWielkoscGwiazdowa(scanner.nextDouble());
                loop = false;
            } catch (ZlaObserwowanaWielkoscGwiazdowa e) {
                System.out.println(e.getMessage());
            }catch (InputMismatchException e){
                System.out.println("Oczekiwano liczby zmienno przecinkowej");
            }
        }
        loop =true;
        System.out.println("Podaj odległość od gwiazdy w parsekach");
        while (loop) {
            try {
                gwiazda.setAbsolutnaWielkoscGwiazdowaILataSwietlne(scanner.nextDouble());
                loop = false;
            }catch (InputMismatchException e){
                System.out.println("Oczekiwano liczby zmienno przecinkowej");
            }
        }


    }

    private int setNazwaKatalogowa(String gwiazdozbior) {
        int suma = 0;
        for (Gwiazda g : indeks
        ) {
            if (g.gwiazdozbior == gwiazdozbior) {
                suma++;
            }
            if (suma == 22) break;
        }
        return suma;
    }
    public void wypisz(){
        String a = String.format("|%-10s|","Nazwa" );
        for (Gwiazda x: indeks
             ) {
            System.out.println(x.toString());
        }
    }

}
