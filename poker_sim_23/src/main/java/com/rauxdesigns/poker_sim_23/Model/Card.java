package com.rauxdesigns.poker_sim_23.Model;

/**
 *
 * @author alexander thompson
 * Poker Sim 23
 * at.raux@gmail.com
 * 0728007475
 * 
 */
public class Card {
    private char face;
    private char suit;
    
    
    // PRIVATE
    private void setFace(char face) {
        this.face = face;
    }

    private void setSuit(char suit) {
        this.suit = suit;
    }

    
    // PUBLIC
    public char getFace() {
        return face;
    }

    public char getSuit() {
        return suit;
    }    
    
    public Card createCard(char face, char suit){
        Card card = new Card();
        
        card.setFace(face);
        card.setSuit(suit);
        
        return card;
    }   
}