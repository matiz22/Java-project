import execptions.ZlaMasaGwiazdy;
import execptions.ZlaTemperatura;
import wartosci.LiteryGreckie;
import wartosci.Polkula;
import execptions.ZlaNazwa;

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
                System.out.println("Oczekiwanu liczby całkowitej");
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

}
