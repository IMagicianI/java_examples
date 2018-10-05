
import java.util.ArrayList;
import kuva.Fotari;
import kuva.Kuva;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> tiedostot = new ArrayList<>();
//        Kuva kuva = new Kuva(200,100);
//        Fotari.nayta(kuva);
        // Tiedostot löytyvät tehtäväpohjasta alla listatuilla nimillä.

        tiedostot.add("G0010099.png");
        tiedostot.add("G0010108.png");
        tiedostot.add("G0010109.png");
        tiedostot.add("G0010110.png");
        tiedostot.add("G0010111.png");
        tiedostot.add("G0010132.png");
        tiedostot.add("G0010159.png");
        tiedostot.add("G0010161.png");
        tiedostot.add("G0010163.png");
        Yhdistin yhdistin = new Yhdistin("vaalein");
        ArrayList<Kuva> kuvat = yhdistin.lataaKuvat(tiedostot);
        
     yhdistin.yhdistaKuvat(kuvat);
//
       Fotari.nayta( yhdistin.yhdistaKuvat(kuvat));
       Yhdistin pahdistin = new Yhdistin("tummin");
        ArrayList<Kuva> puvat = pahdistin.lataaKuvat(tiedostot);
        Yhdistin kahdistin = new Yhdistin("mediaani");
     pahdistin.yhdistaKuvat(kuvat);
//
       Fotari.nayta( kahdistin.yhdistaKuvat(puvat));
      
    }
}
