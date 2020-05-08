package eren;

public interface IObservable {
    void sicakligiGoster();
    boolean sogutucuAc(IObserver observer);
    boolean sogutucuKapat(IObserver observer);
    void sogutucuAciliyor(IObserver observer);
    void sogutucuKapatiliyor(IObserver observer);
}
