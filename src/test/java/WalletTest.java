import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class WalletTest extends TestCase {
    @Test
    public void testConstructor() {
        // Membuat objek Owner dengan nama "DragonBall" dan usia 17
        Owner owner = new Owner("DragonBall", 17);

        // Membuat objek Wallet dengan menggunakan konstruktor
        Wallet wallet = new Wallet(owner, new ArrayList<>(), 100.0);

        // Memeriksa apakah objek wallet tidak null
        assertNotNull(wallet.toString(), "Objek wallet tidak boleh null");

        // Memeriksa apakah objek owner pada wallet adalah objek yang sama dengan owner yang dibuat
        assertSame("Owner harus menjadi objek yang sama", owner, wallet.getOwner());

        // Memeriksa apakah jumlah kartu dalam wallet adalah 0
        assertEquals(0, wallet.getCards().size());

        // Memeriksa apakah jumlah uang tunai dalam wallet adalah 100.0
        assertEquals(100.0, wallet.getCash());
    }


    @Test
    public void testWithdraw() {
        // Membuat objek Wallet dengan pemilik "Alice", usia 25, dan saldo awal 200.0
        Wallet wallet = new Wallet(new Owner("Alice", 25), new ArrayList<>(), 200.0);

        // Menarik uang sebesar 50.0 dari wallet
        double withdrawnAmount = wallet.withdraw(50.0);

        // Memeriksa apakah saldo uang tunai setelah penarikan adalah 150.0
        assertEquals(150.0, wallet.getCash());

        // Memeriksa apakah jumlah uang yang ditarik sesuai dengan yang diharapkan (50.0)
        assertEquals(50.0, withdrawnAmount);
    }


    @Test
    public void testDeposit() {
        // Membuat objek Wallet dengan pemilik "Bob", usia 35, dan saldo awal 300.0
        Wallet wallet = new Wallet(new Owner("Bob", 35), new ArrayList<>(), 300.0);

        // Melakukan deposit sebesar 50.0 ke dalam wallet
        double depositedAmount = wallet.deposit(50.0);

        // Memeriksa apakah saldo uang tunai setelah deposit adalah 350.0
        assertEquals(350.0, wallet.getCash());

        // Memeriksa apakah jumlah yang dideposit sesuai dengan yang diharapkan (50.0)
        assertEquals(50.0, depositedAmount);

        // Memeriksa apakah saldo uang tunai tidak negatif
        assertTrue("Cash tidak boleh negatif", wallet.getCash() >= 0);
    }

    @Test
    public void testWithdrawMoreThanBalance() {
        // Membuat objek Wallet dengan pemilik "Charlie", usia 28, dan saldo awal 150.0
        Wallet wallet = new Wallet(new Owner("Charlie", 28), new ArrayList<>(), 100.0);

        // Menarik uang sebesar 150.0 dari wallet
        double withdrawnAmount = wallet.withdraw(150.0);

        // Memeriksa apakah jumlah uang yang ditarik adalah 0.0 (karena tidak mencukupi)
        assertEquals(0.0, withdrawnAmount);

        // Memeriksa apakah saldo uang tunai tetap 100.0 setelah penarikan
        assertEquals(100.0, wallet.getCash());
    }


    @Test
    public void testAddCards() {
        // Membuat objek Wallet dengan saldo awal 0.0
        Wallet wallet = new Wallet(new Owner("DragonBolls", 17), new ArrayList<>(), 0.0);

        // Menambahkan kartu ke dalam dompet
        wallet.addCards("BRI", 1234567890);

        // Memeriksa apakah kartu berhasil ditambahkan
        List<Card> cards = wallet.getCards();
        assertEquals(1, cards.size()); // Memastikan ada satu kartu di dalam dompet

        Card addedCard = cards.get(0);
        assertEquals("DragonBolls", addedCard.getNamaPemilik()); // Memeriksa nama pemilik kartu
        assertEquals("BRI", addedCard.getNamaBank()); // Memeriksa nama bank kartu
        assertEquals("1234567890", addedCard.getNoRek()); // Memeriksa nomor rekening kartu
        assertNull(addedCard.getMasaAktif()); // Memeriksa apakah masa aktif kartu belum diinisialisasi (null)
    }

    @Test
    public void testRemoveCard() {
        // Membuat objek Wallet dengan saldo awal 0.0
        Wallet wallet = new Wallet(new Owner("DragonBolls", 17), new ArrayList<>(), 0.0);

        // Menambahkan dua kartu ke dalam dompet
        wallet.addCards("BRI", 1234567890);
        wallet.addCards("BCA", 987654321);

        // Memeriksa apakah kartu berhasil ditambahkan
        List<Card> cardsBeforeRemove = wallet.getCards();
        assertEquals(2, cardsBeforeRemove.size()); // Memastikan ada dua kartu di dalam dompet

        // Menghapus salah satu kartu
        wallet.removeCard(1234567890);

        // Memeriksa apakah kartu berhasil dihapus
        List<Card> cardsAfterRemove = wallet.getCards();
        assertEquals(1, cardsAfterRemove.size()); // Memastikan hanya satu kartu yang tersisa

        Card remainingCard = cardsAfterRemove.get(0);
        assertEquals("BCA", remainingCard.getNamaBank()); // Memeriksa bank kartu yang tersisa
        assertEquals("987654321", remainingCard.getNoRek()); // Memeriksa nomor rekening kartu yang tersisa
    }
}