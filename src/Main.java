import execptions.ZlaDeklinacja;
import execptions.ZlaNazwa;
import execptions.ZlaObserwowanaWielkoscGwiazdowa;
import execptions.ZlaRektascensja;

public class Main {
    public static void main(String[] args) throws ZlaNazwa, ZlaDeklinacja, ZlaRektascensja, ZlaObserwowanaWielkoscGwiazdowa {
        IndeksGwiazd indeksGwiazd = new IndeksGwiazd();
        indeksGwiazd.add();

    }
}