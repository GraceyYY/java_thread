package future;

public class Card {
    private String id;
    private String type;
    private int credit;

    public Card(String id, String type, int credit) {
        this.id = id;
        this.type = type;
        this.credit = credit;
    }

    public String getId() {
        return this.id;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getCredit() {
        return this.credit;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Card: [type: " + this.getType() + ", id: " + this.getId() + ", credit: " + this.getCredit() + "]";
    }
}
