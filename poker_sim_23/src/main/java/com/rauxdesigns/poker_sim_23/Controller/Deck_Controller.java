package com.rauxdesigns.poker_sim_23.Controller;

import com.rauxdesigns.poker_sim_23.Model.Deck;
import com.rauxdesigns.poker_sim_23.Model.Card;
import com.rauxdesigns.poker_sim_23.Utilities.Config;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

/**
 *
 * @author alexander thompson
 * Poker Sim 23
 * at.raux@gmail.com
 * 0728007475
 * 
 */
public class Deck_Controller { 

    public static Deck buildDeck(){ // Builds a standard deck(Array of Cards) gotten from Config.faces and Config.suits;
        Deck deck = null;
        
        if((Config.suits != null && Config.suits.length() > 0) && (Config.faces != null && Config.faces.length() > 0)){
            
            int deckSize = Config.faces.length() * Config.suits.length();
            deck = new Deck();
            Card[] cards = new Card[deckSize];
            int index = 0;
            
            for (char s : Config.suits.toCharArray()) {
                for (char f : Config.faces.toCharArray()) {
                    Card card = new Card();
                    cards[index] = card.createCard(f, s);
                    index++;
                }
            }
            deck.setDeck(cards);
        } else{
            System.err.println("Error DC001: NoValue/NullPointer error. Contact Administrator"); //Config.suits and Config.faces can't be empty;
        }
        
        return deck;
    }
    
    public static Deck shuffelDeck(Deck deck){
        if(deck != null){
            
            Card[] cards = deck.getDeck();

            if(cards.length > 0){
                //=================================================== Concideration 1 - Replace with new shuffel method;
                List<Card> cardList = Arrays.asList(cards);
                Collections.shuffle(cardList);
                cardList.toArray(cards);
                //===================================================

                deck.setDeck(cards);    
            }else{
                System.err.println("Error DC002: NoValue error. Contact Administrator");//"Deck.cards can't be empty;
            }
        }else{
            System.err.println("Error DC003: NullPointer error. Contact Administrator");//"Deck can't be null;
        }
        
        return deck;
    }
    
    public static Deck createDeckFromCardString(String cardString){ // For Unit Testing Purposes - Create a deck with given cards;
        
        Deck deck = null;
        
        if(cardString != null && cardString.isEmpty() == false && Config.handSize > 0){
            
            deck = new Deck();
            cardString = cardString.replaceAll(" ", "");
            
            Card[] cards = new Card[Config.handSize];
            int index = 0;
            char[] chars = cardString.toCharArray();
            for (int i = 0; i < chars.length - 1 ; i = i + 2) {

                    Card card = new Card();
                    cards[index] = card.createCard(chars[i], chars[i+1]);
                    index++;

            }
            deck.setDeck(cards);
            
        }else{
            System.err.println("Error DC004: NoValue error. Contact Administrator");//"cardString and Config.handSize can't be empty;
        }
        
        return deck;
    }
}