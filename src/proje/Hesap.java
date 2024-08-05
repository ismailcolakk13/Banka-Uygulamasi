package proje;



public class Hesap implements BankaUrunleri {
	
	static int count=1000;
	int hesapno;
	public double bakiye;
	public String doviztipi;
	Musteri sahibi;
	public Hesap(String doviztipi,String musteriID) {
		bakiye=0;
		hesapno=count;
		this.doviztipi=doviztipi.toUpperCase();
		this.sahibi=Main.müşteridatabase.get(musteriID);
		sahibi.kişiselhesaplar.put(hesapno, this);
		Main.hesapdatabase.put(hesapno, this);
		count++;
	}
	public static void yatır(int hesapno,double miktar) {Main.hesapdatabase.get(hesapno).bakiye+=miktar;}
	public static double bakiye(int hesapno) {return Main.hesapdatabase.get(hesapno).bakiye;}
	public static void cek(int hesapno,double miktar) {Main.hesapdatabase.get(hesapno).bakiye-=miktar;}
	public static void hesabaGonder(int göndericihesapNo,int alıcıhesapNo,double miktar) {
		cek(göndericihesapNo,miktar);
		yatır(alıcıhesapNo,miktar);
	}
	public static void dovizeCevir(int alınanhesapNo,int dönüşenhesapNo,int cevrilenmiktar) {
		cek(alınanhesapNo,cevrilenmiktar);
		if(Main.hesapdatabase.get(dönüşenhesapNo).doviztipi.equals("USD")&&Main.hesapdatabase.get(alınanhesapNo).doviztipi.equals("TL"))
			yatır(dönüşenhesapNo,(cevrilenmiktar*tl_dolar));
		if(Main.hesapdatabase.get(dönüşenhesapNo).doviztipi.equals("EURO")&&Main.hesapdatabase.get(alınanhesapNo).doviztipi.equals("TL"))
			yatır(dönüşenhesapNo,(cevrilenmiktar*tl_euro));
		if(Main.hesapdatabase.get(dönüşenhesapNo).doviztipi.equals("TL")&&Main.hesapdatabase.get(alınanhesapNo).doviztipi.equals("USD"))
			yatır(dönüşenhesapNo,(cevrilenmiktar*dolar_tl));
		if(Main.hesapdatabase.get(dönüşenhesapNo).doviztipi.equals("TL")&&Main.hesapdatabase.get(alınanhesapNo).doviztipi.equals("EURO"))
			yatır(dönüşenhesapNo,(cevrilenmiktar*tl_dolar));
		if(Main.hesapdatabase.get(dönüşenhesapNo).doviztipi.equals("USD")&&Main.hesapdatabase.get(alınanhesapNo).doviztipi.equals("EURO"))
			yatır(dönüşenhesapNo,(cevrilenmiktar*euro_dolar));
		if(Main.hesapdatabase.get(dönüşenhesapNo).doviztipi.equals("EURO")&&Main.hesapdatabase.get(alınanhesapNo).doviztipi.equals("USD"))
			yatır(dönüşenhesapNo,(cevrilenmiktar*dolar_euro));
	}
	public String toString() {
		return "Hesap Numarası "+bakiye+" "+doviztipi+"=Bakiye";
	}
}
