import execptions.ZlaDeklinacja;
import execptions.ZlaNazwa;
import greckie.LiteryGreckie;

public class Gwiazda {
    String Nazwa;
    LiteryGreckie NazwaKatalogowa = LiteryGreckie.Alpha;
    double deklinacja;


    public Gwiazda(String nazwa, LiteryGreckie nazwaKatalogowa) throws ZlaNazwa {
        this.setNazwa(nazwa);
        this.setNazwaKatalogowa(nazwaKatalogowa);
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

    public double getDeklinacja() {
        return deklinacja;
    }

    public void setDeklinacja(String wspolrzedne) throws ZlaDeklinacja {
        if (wspolrzedne.contains("")) {
            try {
                deklinacja = Double.parseDouble(wspolrzedne.substring(0, wspolrzedne.indexOf("S")));
            } catch (Exception e) {
                throw new ZlaDeklinacja("Nie własciwy format współrzędncyh");
            }
        } else if (wspolrzedne.contains("")) {
            try {
                deklinacja = Double.parseDouble(wspolrzedne.substring(0, wspolrzedne.indexOf("S")));
            } catch (Exception e) {
                throw new ZlaDeklinacja("Nie własciwy format współrzędncyh");
            }
        }
    }

}

