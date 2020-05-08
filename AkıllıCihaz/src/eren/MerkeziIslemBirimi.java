package eren;

public class MerkeziIslemBirimi implements IObservable {
    private SicaklikAlgilayici sicaklikAlgilayiciErisim = new SicaklikAlgilayici();
    private Eyleyici eyleyciErisim = new Eyleyici();


    public void sicakligiGoster(){
        System.out.println(sicaklikAlgilayiciErisim.sicaklikOku());
    }
    @Override
    public boolean sogutucuAc(IObserver observer){
        sogutucuAciliyor(observer);
        if(eyleyciErisim.sogutucuAc(sicaklikAlgilayiciErisim))
            return true;
        else
            return false;
    }
    @Override
    public boolean sogutucuKapat(IObserver observer){
        sogutucuKapatiliyor(observer);
        if(eyleyciErisim.sogutucuKapat(sicaklikAlgilayiciErisim))
            return true;
        else
            return false;
    }

    @Override
    public void sogutucuAciliyor(IObserver observer) {
        System.out.println("Sogutucu aciliyor..");
    }

    @Override
    public void sogutucuKapatiliyor(IObserver observer) {
        System.out.println("Sogutucu kapatiliyor..");
    }
}
