package proje;

import java.util.*;

public class Personel {
	int id;
	private int sifre;
	static int count=1;
	public Personel(int sifre){
		setSifre(sifre);
		id=count;
		count++;
		Main.personeldatabase.put(id, this);
	}	
	public int getSifre() {
		return sifre;
	}
	public void setSifre(int sifre) {
		this.sifre = sifre;
	}
	public static void kartBlokeDurumuDegis(long kartNo,boolean durum) {//bloke etmek için true,bloke kaldırmak için false
		Main.kartdatabase.get(kartNo).blokemi=durum;
	}

	public static void kartLimitYukseltme(long kartNo,int yenilimit) {
		KrediKartı.setLimit(kartNo, yenilimit);
	}
	public static void yeniMüsteri(String ad,String soyad) {
		new Musteri(ad,soyad,"0000");
	}
	
	public static String[] krediIstekleri() {
		Iterator<Musteri> iterator = Main.müşteridatabase.values().iterator();
		ArrayList<String> dizi=new ArrayList<String>();
		while(iterator.hasNext()) {
			Musteri musteri=iterator.next();
			if(musteri.kreditalebi>0) {
				dizi.add(musteri.id+" Miktar:"+musteri.kreditalebi+" TL");
			}
		}
		return dizi.toArray(new String[dizi.size()]);
	}
	public static String[] krediKartıIstekleri() {
		Iterator<Musteri> iterator = Main.müşteridatabase.values().iterator();
		ArrayList<String> dizi=new ArrayList<String>();
		while(iterator.hasNext()) {
			Musteri musteri=iterator.next();
			if(musteri.kredikartıOnayı) {
				dizi.add(musteri.id);
			}
		}
		return dizi.toArray(new String[dizi.size()]);
	}
	public static String[] krediKartıLimitIstekleri() {
		Iterator<KrediKartı> iterator = Main.kartdatabase.values().iterator();
		ArrayList<String> dizi=new ArrayList<String>();
		while(iterator.hasNext()) {
			KrediKartı kart=iterator.next();
			if(kart.istenenLimit>0) {
				Long l=kart.kartNo;
				dizi.add(l.toString()+" İstenen Limit: "+kart.istenenLimit);
			}
		}
		return dizi.toArray(new String[dizi.size()]);
	}
	public static String[] blokeKartlar() {
		Iterator<KrediKartı> iterator = Main.kartdatabase.values().iterator();
		ArrayList<String> dizi=new ArrayList<String>();
		while(iterator.hasNext()) {
			KrediKartı kart=iterator.next();
			if(kart.blokemi) {
				Long l=kart.kartNo;
				dizi.add(l.toString());
			}
		}
		return dizi.toArray(new String[dizi.size()]);
	}
}
