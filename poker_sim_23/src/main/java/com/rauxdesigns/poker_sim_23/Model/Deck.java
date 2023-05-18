package com.rauxdesigns.poker_sim_23.Model;

import com.rauxdesigns.poker_sim_23.Model.Card;

/**
 *
 * @author alexander thompson
 * Poker Sim 23
 * at.raux@gmail.com
 * 0728007475
 * 
 */
public class Deck {
    private Card[] cards;

    // PUBLIC
    public Card[] getDeck() {
        return cards;
    }

    public void setDeck(Card[] cards) {
        this.cards = cards;
    }   
}