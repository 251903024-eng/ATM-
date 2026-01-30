import java.util.Locale;
import  java.util.Scanner;



public class ATM1{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner locale =scanner.useLocale(Locale.US);
        


        // BAKİYELER EN DIŞARIDA (Sıfırlanmaması için)
        double veyselBakiye = 5000.0;
        String veyselKullaniciAdi = "11156895423";
        String veyselSifre = "1234";

        double kadirBakiye = 3000.0;
        String kadirKullaniciAdi = "74236945712";
        String kadirSifre = "4321";

        System.out.println("ATM'YE HOŞGELDİNİZ");
        

        // --- DIŞ DÖNGÜ: GİRİŞ EKRANI DÖNGÜSÜ ---
        // Bu döngü asla bitmez (Program kapatılana kadar)
        while (true) {
            System.out.println("--------------------------------");
            System.out.println("TC'nizi GİRİNİZ:");
            String kullaniciadi = scanner.nextLine();

            System.out.println("ŞİFRENİZİ GİRİNİZ:");
            String sifre = scanner.nextLine();

            // --- VEYSEL GİRİŞİ ---
            if (kullaniciadi.equals(veyselKullaniciAdi) && sifre.equals(veyselSifre)) {
                System.out.println("HOŞGELDİNİZ VEYSEL YILDIZ");
                
                // İÇ DÖNGÜ KONTROLÜ
                boolean sistemdeMi = true; 

                // --- İÇ DÖNGÜ: KULLANICI MENÜSÜ ---
                // Kullanıcı 4'e basıp 'sistemdeMi'yi false yapana kadar döner
                while (sistemdeMi) {
                    System.out.println("\nİŞLEMİNİZİ SEÇİNİZ:");
                    System.out.println("1- Para Yatır\n2- Para Çek\n3- Bakiye Sorgula\n4- ÇIKIŞ YAP (Ana Menü)");
                    String islem = scanner.nextLine();

                    switch (islem) {
                        case "1":
                            System.out.println("Yatırılacak tutar:");
                            double tutar = scanner.nextDouble();
                           
                            scanner.nextLine(); // Hata önleyici
                            veyselBakiye += tutar;
                            System.out.println("Yeni Bakiye: " + veyselBakiye);
                            System.err.println("Başka bir işelem  yapmak için lütfen 1' e basın");
                            String değer=  scanner.nextLine();
                            break; // Switch'ten çıkar, while(sistemdeMi) başa döner

                        case "2":
                            System.out.println("Çekilecek tutar:");
                            double cekilen = scanner.nextDouble();
                            scanner.nextLine(); // Hata önleyici
                            if (cekilen > veyselBakiye) {
                                System.out.println("Yetersiz Bakiye!");
                            } else {
                                veyselBakiye -= cekilen;
                                System.out.println("Yeni Bakiye: " + veyselBakiye);
                            }
                             System.err.println("Başka bir işelem  yapmak için lütfen 1' e basın");
                            String değer2=  scanner.nextLine();
                            break; // Switch'ten çıkar, tekrar işlem sorar

                        case "3":
                            System.out.println("Mevcut Bakiyeniz: " + veyselBakiye);
                             System.err.println("Başka bir işelem  yapmak için lütfen 1' e basın");
                            String değer3=  scanner.nextLine();
                            break; // Switch'ten çıkar, tekrar işlem sorar
                            
                        case "4":
                            System.out.println("Ana menüye dönülüyor...");
                            sistemdeMi = false; // İÇ DÖNGÜYÜ BİTİRİR
                            break; 
                        default:
                            System.out.println("Geçersiz işlem!");
                    }
                } // Veysel İç Döngü Sonu

            // --- KADİR GİRİŞİ ---
            } else if (kullaniciadi.equals(kadirKullaniciAdi) && sifre.equals(kadirSifre)) {
                System.out.println("HOŞGELDİNİZ KADİR YILDIZ");
                
                boolean sistemdeMi = true; // Kadir için döngü anahtarı

                while (sistemdeMi) {
                    System.out.println("\nİŞLEMİNİZİ SEÇİNİZ:");
                    System.out.println("1- Para Yatır\n2- Para Çek\n3- Bakiye Sorgula\n4- ÇIKIŞ YAP (Ana Menü)");
                    String islem = scanner.nextLine();

                    switch (islem) {
                        case "1":
                            System.out.println("Yatırılacak tutar:");
                            double tutar = scanner.nextDouble();
                            scanner.nextLine();
                            kadirBakiye += tutar;
                            System.out.println("Yeni Bakiye: " + kadirBakiye);
                            break;
                        case "2":
                            System.out.println("Çekilecek tutar:");
                            double cekilen = scanner.nextDouble(); 
                            scanner.nextLine();
                            if (cekilen > kadirBakiye) {
                                System.out.println("Yetersiz Bakiye!");
                            } else {
                                kadirBakiye -= cekilen;
                                System.out.println("Yeni Bakiye: " + kadirBakiye);
                            }
                            break;
                        case "3":
                            System.out.println("Mevcut Bakiyeniz: " + kadirBakiye);
                            break;
                        case "4":
                            System.out.println("Ana menüye dönülüyor...");
                            sistemdeMi = false; // Döngüyü kırar
                            break;
                        default:
                            System.out.println("Geçersiz işlem!");
                    }
                } // Kadir İç Döngü Sonu

            } else {
                System.out.println("HATALI KULLANICI ADI VEYA ŞİFRE!");
            }
            
        } // Dış Döngü Sonu
    }
}