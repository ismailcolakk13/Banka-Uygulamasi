Örnek olarak 3 müşteri(id ler 100000000 den başlıyor)
		1. müşteri şifre 1905 id 100000000,
		2. müşteri şifre 1903 id 100000001,
		3. müşteri şifre 1907 id 100000002.

Bunlara bağlı 6 tl hesabı(hesapnolar 1000 den başlıyor)
		2 hesap 1. müşterinin,
		2 hesap 2. müşterinin,
		2 hesap 3. müşterinindir.
3 tane Fatura(faturalar müşteriden bağımsız)
		Sözleşme no  tutar
		12345678     250
		1234567	     750
		123456 	     1000
Personel ve müdürler aynı hashmapte saklanır
 1 personel id 1 şifre 2024
 1 müdür id 2 şifre 2023 tür

1.müşterinin 3 kredi kartı 2 sinin limitini arttırmak istiyor
2. müşterinin 1 kartı var ve bloklu
3. müşterinin de tek kartı var ve bloklu

Bloklama işlemi borç limiti aşınca otomatik gerçekleşiyor

Personel veya müdür tarafından yapılan müşteri kayıtlarında müşteri şifreleri ve id leri otomatik atanır.Her yeni müşterinin şifresi "0000" olarak belirlenir bunu müşteri kendi değiştirmesi gerekir.

Verileri veritabanında değil HashMaplerde tuttum bu yüzden işlem yaparken uygulama açık kalmalı yani uygulamayı kapatmayın çıkış yaparak başka müşteri,müdür ya da personel hesabına giriş yapın.