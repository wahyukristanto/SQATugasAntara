import java.util.Random;
import java.awt.Color;

public final class Dadu {
  public static final int DEFAULT_SISI = 6;

  private static Random randGenerator = new Random();

  private final int jumSisi;
  private String[] warnaSisi;
  private int hasil;
  private int[] cekBedaNilai;
  private int perulangan;

  public Dadu() {
    this(DEFAULT_SISI);
  }

  public Dadu(int numSides) {
    this.jumSisi = numSides;
    int perulangan = 0;
    cekBedaNilai = new int[jumSisi];
    randomWarna();
  }

  public void randomWarna(){
    int random;
    warnaSisi = new String[jumSisi];

    for(int i=0; i<jumSisi; i++){
      random = randGenerator.nextInt(16777215);
      Color sisi = new Color(random);

      /*if(i != 0){
        for(int j=0; j<i; j++){
          while(sisi.toString() == warnaSisi[j]){
            random = randGenerator.nextInt(16777215);
            sisi = new Color(random);
          }
        }
      }*/

      int beda = 0;
      if(i != 0){
        int j=0;
        while(beda != i){
          System.out.println(sisi.toString() +" -- " +warnaSisi[j]);
          if(sisi.toString() == warnaSisi[j]){
            random = randGenerator.nextInt(16777215);
            sisi = new Color(random);
            beda = 0;
            j = 0;
            System.out.println(" PODO GAN! ");
          }else{
            j++;
            beda++;
          }
        }
      }

      warnaSisi[i] = sisi.toString();
    }

    for(int i=0; i<jumSisi; i++){
      System.out.println(i +" = " +warnaSisi[i]);
    }
  }

  public String getWarnaSisi(int hasil){
    return warnaSisi[hasil];
  }

  public int lempar() {
    if(perulangan == jumSisi){
      System.out.println("Semua sisi sudah ditampilkan");
    }else{
      hasil = randGenerator.nextInt(jumSisi) + 1;
      int beda = 0;
      if(perulangan != 0){
        int j=0;
        while(beda != perulangan){
          System.out.println(hasil +" -- " +cekBedaNilai[j]);
          if(hasil == cekBedaNilai[j]){
            hasil = randGenerator.nextInt(jumSisi) + 1;
            beda = 0;
            j = 0;
            System.out.println(" PODO GAN! ");
          }else{
            j++;
            beda++;
          }
        }
      }
      cekBedaNilai[perulangan] = hasil;
      System.out.println("Warna sisi ke-" +hasil +" adalah " +getWarnaSisi(hasil-1));
      perulangan++;
    }

    return hasil;
  }

  public int getJumSisi() {
    return jumSisi;
  }

  public int getHasil() {
    return hasil;
  }

  @Override
  public String toString() {
    for(int i=0; i<jumSisi; i++){
      System.out.println(i +" = " +cekBedaNilai[i]);
    }
    return "Jumlah sisi dadu: " + getJumSisi() + " hasil: " + getHasil();
  }
}
