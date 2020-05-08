package eren;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class VeriTabani {
    private static VeriTabani instance = null;
    private synchronized static void createInstance() {
        if (instance == null)
            instance = new VeriTabani();
    }
    public static VeriTabani getInstance() {
        if (instance == null)
            createInstance();
        return instance;
    }

    private String DBkullaniciAdi = null;
    private String DBsifre = null;

    private Scanner scan = new Scanner(System.in);

    private static Connection baglan(){

        Connection conn=null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SogutucuSistemi",
                    "postgres", "123456");
            /*if (conn != null)
                System.out.println("Veritabanına bağlanıldı.");
            else
                System.out.println("Bağlantı girişimi başarısız.");*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public boolean kullaniciGiris(){
        Connection conn=this.baglan();

        String sql= "SELECT * FROM \"Sema1\".\"Kullanici\"";

        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //Bağlantı sonlandırıldı.
            conn.close();

            while(rs.next())
            {
                DBkullaniciAdi  = rs.getString("KullaniciAdi");
                DBsifre = rs.getString("KullaniciSifre");
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print("Kullanici adi:");
        String kullaniciAdi = scan.nextLine();
        System.out.print("Şifre:");
        String sifre = scan.nextLine();

        if (kullaniciAdi.equals(DBkullaniciAdi) && sifre.equals(DBsifre)){
            System.out.println("Giris basarili");
            return true;
        }
        else
            return false;
    }
}
