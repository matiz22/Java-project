package execptions;

public class ZlaDeklinacja extends Exception {
    public ZlaDeklinacja(String nazwaBledu) {
        super(nazwaBledu);
    }
}
