package proje;

public class Fatura {
	public String tip;
	public int faturaborç,sözleşmeNo;
	public Fatura(String tip,int sözleşmeNo,int tutar){
		this.tip=tip.toLowerCase();
		this.sözleşmeNo=sözleşmeNo;
		faturaborç+=tutar;
		Main.faturadatabase.put(sözleşmeNo, this);
	}
	public static void faturaOde(String kart_hesap,int sozlesmeNo,long hesap_kartNo) {
		if(kart_hesap.toLowerCase().equals("kart")&&!Main.kartdatabase.get(hesap_kartNo).blokemi) {
			Main.kartdatabase.get(hesap_kartNo).borc+=Main.faturadatabase.get(sozlesmeNo).faturaborç;
			Main.faturadatabase.remove(sozlesmeNo);
		}
		else if(kart_hesap.toLowerCase().equals("hesap")) {
			Main.hesapdatabase.get((int)hesap_kartNo).bakiye-=Main.faturadatabase.get(sozlesmeNo).faturaborç;
			Main.faturadatabase.remove(sozlesmeNo);
			}		
		
	}
	@Override
	public String toString() {
		return "Sözleşme No "+tip+"=Fatura türü "+"Tutar:"+faturaborç;
	}
}
