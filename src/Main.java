import execptions.*;
import wartosci.LiteryGreckie;
import wartosci.Polkula;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ZlaNazwa, ZlaDeklinacja, ZlaRektascensja, ZlaObserwowanaWielkoscGwiazdowa, ZlaTemperatura, ZlaMasaGwiazdy {
        IndeksGwiazd indeksGwiazd = new IndeksGwiazd();
        indeksGwiazd.indeks.add(new Gwiazda("JCJ2138", "Orzeł", Polkula.PN, 0.1, 2001, "50 stopni 50 minut 30.30 sekund", "12 h 30 min 23 ss", 14, 2, LiteryGreckie.Chi));
        indeksGwiazd.indeks.add(new Gwiazda("JCJ2138", "Orzeł", Polkula.PD, 20, 5001, "50 stopni 50 minut 30.30 sekund", "12 h 30 min 23 ss", 14, 2, LiteryGreckie.Chi));
        indeksGwiazd.indeks.add(new Gwiazda("JCJ2138", "Orzeł", Polkula.PN, 48, 10001, "50 stopni 50 minut 30.30 sekund", "12 h 30 min 23 ss", 14, 8, LiteryGreckie.Chi));
        indeksGwiazd.indeks.add(new Gwiazda("JCJ2137", "Orzeło", Polkula.PD, 50, 24001, "50 stopni 50 minut 30.30 sekund", "12 h 30 min 23 ss", 14, 2, LiteryGreckie.Chi));
        int control;
        while (true) {
            menu();
            try {
                control = (new Scanner(System.in)).nextInt();
            } catch (InputMismatchException e) {
                System.out.println();
                control = 0;
            }
            switch (control) {
                case 1:
                    indeksGwiazd.wczytajZPliku();
                    break;
                case 2:
                    indeksGwiazd.zapiszDoPliku();
                    break;
                case 3:
                    indeksGwiazd.wypisz();
                    break;
                case 4:
                    indeksGwiazd.add();
                    break;
                case 5:
                    indeksGwiazd.remove();
                    break;
                case 6:
                    indeksGwiazd.wyszukaj();
                    break;
                case 7:
                    indeksGwiazd.wyszukajTemperatura();
                    break;
                case 8:
                    indeksGwiazd.wyszukjaPolkula();
                    break;
                case 9:
                    indeksGwiazd.wyszukajParseki();
                    break;
                case 10:
                    indeksGwiazd.wyszukajMase();
                    break;
                case 11:
                    indeksGwiazd.wyszukajPotencjalneSupernowy();
                    break;
                case 12:
                    indeksGwiazd.wyszukajPoAbsolutnejWielkosciGwiazdowej();
                    break;
                case 13:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Zły wybor");
            }

        }
    }

    public static void menu() {
        System.out.println("1.Wczytaj z pliku");
        System.out.println("2.Zapisz obecny indeks do pliku");
        System.out.println("3.Wyswietl indeks");
        System.out.println("4.Dodaj do indeksu");
        System.out.println("5.Usun po nazwie");
        System.out.println("6.Wyszukaj po nazwie");
        System.out.println("7.Wyszukaj po temrperaturze");
        System.out.println("8.Wyszukaj na polkuli");
        System.out.println("9.Wyszukaj uzywajac parsekow");
        System.out.println("10.Wyszukaj po masie w odniesieniu do slonca");
        System.out.println("11.Wyszukaj potencjalne supernovy");
        System.out.println("12.Wyszukaj po Absolutnej Wielkości");
        System.out.println("13.Wyjscie");

    }
}