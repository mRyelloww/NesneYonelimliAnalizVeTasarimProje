package eren;

public class Eyleyici{
    private boolean sogutucuAcikMi = false;
    public boolean  sogutucuAc(SicaklikAlgilayici nesne){
        if (sogutucuAcikMi == false) {
            nesne.sicaklikAzalt();
            sogutucuAcikMi = true;
            return true;
        }
        else {
            System.out.println("Sogutucu zaten acik.");
            return false;
        }
    }
    public boolean sogutucuKapat(SicaklikAlgilayici nesne){
        if (sogutucuAcikMi == true) {
            nesne.sicaklikArtir();
            sogutucuAcikMi = false;
            return true;
        }
        else{
            System.out.println("Sogutucu zaten kapali.");
            return false;}
    }


}
