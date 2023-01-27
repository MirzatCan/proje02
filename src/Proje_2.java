import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Proje_2 {

    public static <ArraysList> void main(String[] args) {

        // Scanner Class tanimlayin...
        Scanner scan = new Scanner(System.in);
        Scanner intOku=new Scanner(System.in);

        // Banka Islemleri Listesi tanimlayin..."Para_Yatir", "Para_Cek", "Transfer", "Hesap_Ac"...
        List<String> actions = new ArrayList<>(Arrays.asList("Para_Yatir", "Para_Cek", "Transfer", "Cikis"));

        // Banka musterileri kullanici adi listesi tanimlayin..."User1", "User2", "User3"...
        List<String> kullanici = new ArrayList<>();
        kullanici.add("Mirzat");
        kullanici.add("Xirzat");
        kullanici.add("Tumaris");

        // Banka musterileri sifreleri listesi tanimlayin..."password1", "password2", "password3"...
        List<String> sifre = new ArrayList<>();
        sifre.add("970324");
        sifre.add("000518");
        sifre.add("190715");
        // Banka musterilerine ait banka hesap numaralari listesi tanimlayin.."1234", "5678", "9999"
        List<String> hesapNo = new ArrayList<>(Arrays.asList("1234", "5678", "9999"));

        // Banka musterilerine ait banka hesaplarinda bulunan para miktarlarini tanimlayin...200, 1000, 5000
        List<Integer> paraMiktar = new ArrayList<>(Arrays.asList(200, 1000, 5000));
        // TODO ONEMLI NOT : Yukarida gireceginiz listelerdeki veriler index numarasina gore birbirleri ile iliskilidir
        // TODO Mesela -> 'User1' in passwordu 'password1', hesap numarasi '1234' ve hesabiundaki para miktari '200' dur...


        while (true) {
            System.out.print("Please enter your username:");
            String userName=scan.nextLine();
            System.out.print("Please enter your password:");
            String passWord=scan.nextLine();
            if (confirmUsernameAndPassword(kullanici,sifre,userName,passWord)){
                System.out.println("Basarili bir sekilde giris yaptiniz");
                break;
            }
            else
                System.out.println("Sistemde kayitli boyle bir kullanici bulunamadi.. Tekrar deneyin");


//         Sonsuz bir dongu icerisinde kullanicidan username ve password girmesini isteyelim...
//         Konsoldan girilen username ve passwordu confirmUsernameAndPassword() methodunu cagirarak teyit edelim...
//         Eger dogru username ve password girilmis ise "Basarili bir sekilde giris yaptiniz" mesaji yazdirarak yapmak istedigi islemi soralim ...
//         Kayitli olmayan username ve password girilmis ise "Sistemde kayitli boyle bir kullanici bulunamadi.. Tekrar deneyin" mesaji
//         gosterip kullaniciyi tekrar username ve password girisine geri dondurelim..

    }



        while (true){
            System.out.println("Yapmak istediginiz islemi seciniz...");
            for(int i = 0; i<actions.size();i++){
                System.out.println(actions.get(i) + " - " + (i + 1));
            }
            int userChoice = intOku.nextInt();

            switch(userChoice)
            {
                case 1: {
                    System.out.println("Bu bankamatik gecici olarak para yatirma islemine kapalidir...Uzgunuz.");
                    break;
                }
                case 2: {
                    while (true){
                        System.out.println("Hangi hesaptan para cekmek istiyorsunuz?");
                        for (int i = 0; i < hesapNo.size(); i++) {
                        System.out.println(hesapNo.get(i));
                        }
                        String cekmekIsteyenHesap=scan.nextLine();
                        if (hesapDoguruMu(hesapNo,cekmekIsteyenHesap)){
                            System.out.println("hatali hedap numarasi girdiniz. lutfen tekrar giriniz");
                            continue;
                        }
                        System.out.println("Cekmek istediginiz para giriniz:");
                        int cekmekIstenenPara=intOku.nextInt();
                        paraCek(hesapNo,paraMiktar,cekmekIsteyenHesap,cekmekIstenenPara);
                        break;
                    }
                    break;
                }
                case 3: {System.out.println("Bu islemi su an gerceklestiremiyoruz...");
                    break;


                }
                case 4:
                    System.exit(1);

                default: {
                    System.out.println("Basarili bir secim yapmadiniz...");
                }

            }

        }

//         Secim hatali ise "Basarili bir secim yapmadiniz..." ikazi vererek tekrar secim yapmasini isteyelim..
//         Dogru bir secim yapildiginda kullanici tarafindan secilen islem SWITCH Statements vasitasiyla koda aktarilsin
//         Case 1: "Bu bankamatik gecici olarak para yatirma islemine kapalidir...Uzgunuz" ikazi versin..
//         Case 2: "Hangi hesaptan para cekmek istiyorsunuz?" diye kullaniciya sorsun
//                  Hesap numaralarini yukaridaki List ten alarak ekrana yazdirin.. Kullanici sectigi hesap numarasini tuslasin..
//                 "Ne kadar para cekmek istiyorsunuz?" diye soralim..Kullanici girdisini alalim...
//                  asagida bulunan withdraw() methodunu cagirarak hesaptan para cekme islemini tamamlayalim...
//                  tekrar islemler dongusune geri donelim...
//         Case 3: "Bu islemi su an gerceklestiremiyoruz..." diyerek basa donsun..
//         Case 4:  System.exit(1);  buradaki kodu case 4 e aynen kopyalayip yapistirin...
//         default:"Basarili bir secim yapmadiniz..." mesaji versin..


       /*
        }
       */
}

    private static void paraCek(List<String> hesapNo, List<Integer> paraMiktari, String cekmekIsteyenHesap, int cekmekIstenenPara) {
        int kalanBakiye=0;
        int cekmekistenilenHesapIndex=hesapNo.indexOf(cekmekIsteyenHesap);
        if (paraMiktari.get(cekmekistenilenHesapIndex)<cekmekIstenenPara){
            System.out.println("Hesabinizda yeterli bakiye bulunmamaktadir...");
        }
        else {
            kalanBakiye=paraMiktari.get(cekmekistenilenHesapIndex)-cekmekIstenenPara;
            paraMiktari.add(cekmekistenilenHesapIndex,kalanBakiye);
            System.out.println("Lutfen paranizi aliniz");
            System.out.println("kalan Bakiye = " + kalanBakiye);
        }




        /*
        Bu method parametre olarak aldigi accounts (hesaplar) ve funds (hesapta bulunan para miktarlari) listelerinde bulunan degerleri
        kullanici tarafindan girilen degerler ile birlikte kullanabilmek icin olusturulmusutur...
        Mesela : Kullanici 1234 numarali hesaptan para cekmek istemis ise, hangi hesaptan para cekilecegini ve cekilecek para miktarini
        hesap bakiyesinden dusebilmek icin hangi index numarali hesap oldugu bulunmali, ayni index e sahip para miktari funds listesinden
        eksiltilerek kullaniciya hesabinda kalan para miktari belitilmalidir..

        Eger kullanici hesap numarasini yanlis girmisse veya hesabinda bulunan para miktari yeterli degilse
        "Beklenmedik bir hata olustu...Iyi gunler dileriz..." ikazi vermelidir...

         */

    }
    private static boolean hesapDoguruMu(List<String> hesapNo, String cekmekIsteyenHesap){
        for (int i = 0; i < hesapNo.size(); i++) {
            if (hesapNo.get(i).equals(cekmekIsteyenHesap))
            return false;
        }
        return true;
    }


    private static boolean confirmUsernameAndPassword(List<String> kullanici, List<String> sifre, String username, String password) {
        for (int i = 0; i < kullanici.size(); i++) {
            if (kullanici.get(i).equals(username)&&sifre.get(i).equals(password))
                return true;
        }
    /*
        Kullanici yukarida olusturdugumuz kullanici adi ve password lerden birini girmez ise bu method FALSE dondurmelidir..
        Buna gore verile parametreleri kullanarak kullanici teyitini yapiniz..
     */
        return false;
    }
}


