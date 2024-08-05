package proje;
import java.util.*;


public class Musteri {
	static Integer count=100000000;
	public String id,ad,soyad;
	protected String müşteriŞifre;
	public boolean kredikartıOnayı=false;
	public HashMap<Integer,Hesap> kişiselhesaplar;
	public HashMap<Long,KrediKartı> kişiselkartlar;
	public int kreditalebi=0;
	public Musteri(String ad,String soyad,String sifre){
		id=count.toString();
		this.ad=ad;
		this.soyad=soyad;
		setMüşteriŞifre(sifre);
		kişiselhesaplar=new HashMap<Integer,Hesap>();
		kişiselkartlar=new HashMap<Long,KrediKartı>();
		Main.müşteridatabase.put(id, this);
		count++;
	}
	public String getMüşteriŞifre() {return müşteriŞifre;}
	public void setMüşteriŞifre(String müşteriŞifre) {this.müşteriŞifre = müşteriŞifre;}	
	public void krediTalebi(int miktar) {kreditalebi=miktar;}
	public String hesapListem() {
		StringBuffer x=new StringBuffer();
		for (Integer key : kişiselhesaplar.keySet()) {
            Hesap value = kişiselhesaplar.get(key);
            x.append("->Hesap Numarası:"+value.hesapno+" Bakiye:"+value.bakiye+" "+value.doviztipi+"\n");
        }
		String son=x.toString();
		return son;
	}
	public String[] toArrayhesap() {
		Iterator<Hesap> iterator = kişiselhesaplar.values().iterator();
		String[] dizi= new String[kişiselhesaplar.size()];
		int a=0;
		while(iterator.hasNext()) {
			Integer hesap = iterator.next().hesapno;
            dizi[a]=hesap.toString();
            a++;
		}
		return dizi;
	}
	public String[] toArraykart() {
		Iterator<KrediKartı> iterator = kişiselkartlar.values().iterator();
		String[] dizi= new String[kişiselkartlar.size()];
		int a=0;
		while(iterator.hasNext()) {
			Long hesap = iterator.next().kartNo;
            dizi[a]=hesap.toString();
            a++;
		}
		return dizi;
	}
}
