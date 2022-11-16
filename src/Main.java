import execptions.ZlaDeklinacja;
import execptions.ZlaNazwa;
import greckie.LiteryGreckie;

public class Main {
    public static void main(String[] args) throws ZlaNazwa, ZlaDeklinacja {
        Gwiazda test = new Gwiazda("JCJ2137", LiteryGreckie.values()[1] );
        test.setDeklinacja("50 stopnie 29 minuty 53.25 sekundy");
        System.out.println(test.getNazwa());
        System.out.println(test.getNazwaKatalogowa());
        System.out.println(test.getDeklinacja());
    }
}