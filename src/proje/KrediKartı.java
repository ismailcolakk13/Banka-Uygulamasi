package proje;

public class KrediKartı implements BankaUrunleri {
	
	static long count=1000000000000000L;
	private int kartsifre;
	public int limit,borc;
	public long kartNo;
	public boolean limityükseltmeisteği=false;
	public int istenenLimit;
	public boolean blokemi=false;
	Musteri sahibi;
	public KrediKartı(String müşteriID,int limit) {
		this.limit=limit;
		this.sahibi=Main.müşteridatabase.get(müşteriID);
		kartNo=count;
		count++;
		Main.kartdatabase.put(kartNo, this);
		sahibi.kişiselkartlar.put(kartNo, this);
	}
	static void setLimit(long kartNo,int a) {Main.kartdatabase.get(kartNo).limit=a;}
	void setSifre(int b) {kartsifre=b;}
	int getKartsifre() {return kartsifre;}	
	public static void yatır(long kartNo,int miktar) {Main.kartdatabase.get(kartNo).borc-=miktar;}
	public void bakiye() {System.out.println("Kalan harcama limitiniz:"+(limit-borc));}
	public String toString() {
		return sahibi+"-> "+kartNo+" Borç:"+borc+" Kalan limit:"+(limit-borc);
	}	
}
