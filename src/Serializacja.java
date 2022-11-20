import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Serializacja {
    public static <T> void serializeToXML(T indeksGwiazd) throws IOException {
        FileOutputStream fos = new FileOutputStream("xml/Gwiazdy.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                System.out.println("Exception! :" + e.toString());
            }
        });
        encoder.writeObject(indeksGwiazd);
        encoder.close();
        fos.close();
    }

    public static <T> T deserializeFromXML() throws IOException {
        FileInputStream fis = new FileInputStream("xml/Gwiazdy.xml");
        XMLDecoder decoder = new XMLDecoder(fis);
        T indeks = (T) decoder.readObject();
        decoder.close();
        fis.close();
        return indeks;
    }
}
