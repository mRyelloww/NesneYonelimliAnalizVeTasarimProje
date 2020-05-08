package eren;

import java.util.Scanner;

public class AgArayuzu implements IObserver{
    private Scanner scan = new Scanner(System.in);
    public void Arayuz() {
        MerkeziIslemBirimi erisim = new MerkeziIslemBirimi();
        int secim = 0;
        while(true){
        boolean girisBasariliMi = VeriTabani.getInstance().kullaniciGiris();

        if (girisBasariliMi == true) {
            while (true) {
                System.out.println("1 - Sıcaklıgı goruntule");
                System.out.println("2 - Soğutucuyu ac");
                System.out.println("3 - Soğutucuyu kapat");
                System.out.println("4 - Cikis");
                System.out.print("Seciminiz:");
                secim = Integer.parseInt(scan.nextLine());
                if (secim == 1) {
                    System.out.print("Sıcaklık:");
                    erisim.sicakligiGoster();
                }
                if (secim == 2) {
                    if(erisim.sogutucuAc(this))
                    uyariSogutucuAcildi();
                }
                if (secim == 3) {
                    if(erisim.sogutucuKapat(this))
                    uyariSogutucuKapatildi();
                }
                if (secim == 4) {
                    System.out.println("Cikis yapiliyor..");
                    break;
                }
            }
            break;
        }
        else
            System.out.println("Giris basarisiz.Tekrar deneyin.");
        }
    }

    @Override
    public void uyariSogutucuAcildi() {
        System.out.println("Sogutucu acildi.");
    }

    @Override
    public void uyariSogutucuKapatildi() {
        System.out.println("Sogutucu kapatildi.");
    }
}
