package eren;

import java.util.Random;

public class SicaklikAlgilayici {
    private Random rnd = new Random();
    private int sicaklik = rnd.nextInt(30);
    public int sicaklikOku(){
        return sicaklik;
    }
    public void sicaklikArtir(){
        sicaklik += 5;
    }
    public void sicaklikAzalt(){
        sicaklik -= 5;
    }
}
