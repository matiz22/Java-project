import execptions.ZlaNazwa;
import greckie.LiteryGreckie;

public class Main {
    public static void main(String[] args) throws ZlaNazwa {
        Gwiazda test = new Gwiazda("JCJ2137", LiteryGreckie.values()[1] );
        System.out.println(test.getNazwa());
        System.out.println(test.getNazwaKatalogowa());
    }
}