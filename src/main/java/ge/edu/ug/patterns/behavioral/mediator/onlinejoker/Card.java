package ge.edu.ug.patterns.behavioral.mediator.onlinejoker;

// A playing card. Jokers have rank JOKER; their suit only tells red from black.
public record Card(Rank rank, Suit suit) {

    public enum Suit {
        SPADES("♠"), CLUBS("♣"), HEARTS("♥"), DIAMONDS("♦");

        private final String symbol;

        Suit(String symbol) {
            this.symbol = symbol;
        }

        public String symbol() {
            return symbol;
        }
    }

    // Declared from lowest to highest, so ordinal() gives the card's strength
    public enum Rank {
        SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"),
        JACK("J"), QUEEN("Q"), KING("K"), ACE("A"), JOKER("Joker");

        private final String label;

        Rank(String label) {
            this.label = label;
        }

        public String label() {
            return label;
        }
    }

    public static final Card RED_JOKER = new Card(Rank.JOKER, Suit.HEARTS);
    public static final Card BLACK_JOKER = new Card(Rank.JOKER, Suit.SPADES);

    public boolean isJoker() {
        return rank == Rank.JOKER;
    }

    // Parses "10♥", "A♠", "Red Joker" or "Black Joker"
    public static Card of(String text) {
        if (text.equals(RED_JOKER.toString())) {
            return RED_JOKER;
        }
        if (text.equals(BLACK_JOKER.toString())) {
            return BLACK_JOKER;
        }
        String rankLabel = text.substring(0, text.length() - 1);
        String suitSymbol = text.substring(text.length() - 1);
        Rank rank = null;
        for (Rank r : Rank.values()) {
            if (r.label().equals(rankLabel)) {
                rank = r;
            }
        }
        Suit suit = null;
        for (Suit s : Suit.values()) {
            if (s.symbol().equals(suitSymbol)) {
                suit = s;
            }
        }
        if (rank == null || suit == null || rank == Rank.JOKER) {
            throw new IllegalArgumentException("Not a card: " + text);
        }
        return new Card(rank, suit);
    }

    @Override
    public String toString() {
        if (isJoker()) {
            return (this.equals(RED_JOKER) ? "Red" : "Black") + " Joker";
        }
        return rank.label() + suit.symbol();
    }
}
