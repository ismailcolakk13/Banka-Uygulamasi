package proje;

import java.util.HashMap;


public class Main {
	public static HashMap<String,Musteri> müşteridatabase=new HashMap<String,Musteri>();
	public static HashMap<Integer,Hesap> hesapdatabase= new HashMap<Integer,Hesap>();
	public static HashMap<Integer,Fatura> faturadatabase=new HashMap<Integer,Fatura>();
	public static HashMap<Long,KrediKartı> kartdatabase= new HashMap<Long,KrediKartı>();
	public static HashMap<Integer,Personel> personeldatabase=new HashMap<Integer,Personel>();
	public static void OrnekleriOlustur() {
		// TODO Auto-generated method stub
		new Musteri("Seçil","Erzan","1905").kreditalebi=2000000000;
		new Musteri("Sinan","Engin","1903").kreditalebi=20000;
		new Musteri("Ali","Cabbar","1907").kredikartıOnayı=true;
		new Hesap("tl","100000000");
		new Hesap("tl","100000000");
		new Hesap("tl","100000001");
		new Hesap("tl","100000001");
		new Hesap("tl","100000002");
		new Hesap("tl","100000002");
		new Fatura("elektrik",12345678,250);
		new Fatura("su",1234567,750);
		new Fatura("doğalgaz",123456,1000);
		new Personel(2024);
		new Müdür(2023);
		new KrediKartı("100000000",50000);
		new KrediKartı("100000000",50000).istenenLimit=150000;
		new KrediKartı("100000000",50000).istenenLimit=90000;
		new KrediKartı("100000001",50000).blokemi=true;
		new KrediKartı("100000002",50000).blokemi=true;
	}

}
