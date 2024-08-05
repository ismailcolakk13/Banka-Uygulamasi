package proje;

public class Müdür extends Personel {

	Müdür(int sifre){
		super(sifre);
	}
	public static void kartÇıkart(String musteriID) {
		new KrediKartı(musteriID,30000);
	}
	public static void krediVer(String musteriID,int miktar) {
		new Hesap("tl",musteriID).bakiye=miktar;	
	}
	
}
