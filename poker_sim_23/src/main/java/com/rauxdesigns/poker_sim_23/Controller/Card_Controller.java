package com.rauxdesigns.poker_sim_23.Controller;

import com.rauxdesigns.poker_sim_23.Model.Card;

/**
 *
 * @author alexander thompson
 * Poker Sim 23
 * at.raux@gmail.com
 * 0728007475
 * 
 */
public class Card_Controller {
    
    
    public static String parseCard(Card card){ // Convert Card object to a displayable string value;
        if(card != null){
            return "" + card.getFace() + card.getSuit();
        }else{
            System.err.println("Error CC001: NullPointer error. Contact Administrator"); // card can't be null;
            return "";
        }
    }
}