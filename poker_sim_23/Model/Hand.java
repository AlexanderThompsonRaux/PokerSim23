package poker_sim_23.Model;

import poker_sim_23.Model.Card;

/**
 *
 * @author alexander thompson
 * Poker Sim 23
 * at.raux@gmail.com
 * 0728007475
 * 
 */
public class Hand {
    private Card[] cards;

    // PUBLIC
    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }
}