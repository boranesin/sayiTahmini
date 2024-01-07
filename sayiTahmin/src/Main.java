import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int number = (int) (Math.random() * 100);

        Scanner input = new Scanner(System.in);
        int kullaniciHakki = 0;
        int kullaniciTahmini;
        int[] kullaniciTahminGecmisi = new int[5];
        boolean kazandiMi = false;
        boolean hataliMi = false;

        System.out.println(number);
        while (kullaniciHakki < 5) {
            System.out.print("Lütfen tahmininizi giriniz : ");
            kullaniciTahmini = input.nextInt();

            if (kullaniciTahmini < 0 || kullaniciTahmini > 99) {
                System.out.println("Lütfen 0-100 arasında bir değer giriniz.");
                if (hataliMi) {
                    kullaniciHakki++;
                    System.out.println("Çok fazla hatalı giriş yaptınız. Kalan hak : " + (5 - kullaniciHakki));
                } else {
                    hataliMi = true;
                    System.out.println("Bir daha hatalı girişinizde hakkınızdan düşülecektir.");
                }
                continue;
            }

            if (kullaniciTahmini == number) {
                System.out.println("Tebrikler, doğru tahmin ! Tahmin ettiğini sayı : " + number);
                kazandiMi = true;
                break;
            } else {
                System.out.println("Hatalı bir sayı girdiniz !");
                if (kullaniciTahmini > number) {
                    System.out.println(kullaniciTahmini + " sayısı, gizli sayıdan büyüktür.");
                } else {
                    System.out.println(kullaniciTahmini + " sayısı, gizli sayıdan küçüktür.");
                }

                kullaniciTahminGecmisi[kullaniciHakki++] = kullaniciTahmini;
                System.out.println("Kalan hakkı : " + (5 - kullaniciHakki));
            }
        }

        if (!kazandiMi) {
            System.out.println("Kaybettiniz ! ");
            if (!hataliMi) {
                System.out.println("Tahminleriniz : " + Arrays.toString(kullaniciTahminGecmisi));
            }
        }

    }
}