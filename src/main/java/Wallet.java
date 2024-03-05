import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Wallet {
    private Owner owner;
    private List<Card> cards = new ArrayList<>();
    private Double cash;

    public Wallet(){

    }

    public Wallet(Owner owner, List<Card> cards, Double cash) {
        this.owner = owner;
        this.cards = cards;
        this.cash = cash;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Double withdraw(Double amount){
        if (this.cash < amount) {
            System.out.println("Uang Kurang");
            return 0.0;
        }
        else {
            this.cash -= amount;
            return amount;
        }
    }

    public Double deposit(Double amount){
        this.cash += amount;
        return this.cash;
    }

    public void addCards(String bank, int accountNumber){
        Card card = new Card();
        card.setNamaPemilik(this.owner.getNama());
        card.setNamaBank(bank);
        card.setNoRek(String.valueOf(accountNumber));
        this.cards.add(card);
    }

    public void removeCard(int accountNumber) {
        Iterator<Card> iterator = cards.iterator();
        while (iterator.hasNext()) {
            Card card = iterator.next();
            if (card.getNoRek().equals(String.valueOf(accountNumber))) {
                iterator.remove();
                break; // Hentikan iterasi setelah kartu dihapus
            }
        }
    }

}