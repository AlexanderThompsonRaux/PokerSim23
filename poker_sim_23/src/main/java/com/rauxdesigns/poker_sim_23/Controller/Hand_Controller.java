package com.rauxdesigns.poker_sim_23.Controller;

import com.rauxdesigns.poker_sim_23.Model.Hand;
import com.rauxdesigns.poker_sim_23.Model.Deck;
import com.rauxdesigns.poker_sim_23.Model.Card;
import com.rauxdesigns.poker_sim_23.Utilities.Config;
import java.util.Arrays;
import java.util.HashSet;
/**
 *
 * @author alexander thompson
 * Poker Sim 23
 * at.raux@gmail.com
 * 0728007475
 * 
 */
public class Hand_Controller {
    
    public static String parseHandToValue(Hand hand){ // Convert Hand of Cards to a displayable string value;
                
        String parsedHand = null;
        
        if(hand != null){
            Card[] handCards = hand.getCards();
            if(handCards.length > 0){
               
                parsedHand = "";
                for(Card card : handCards){
                    if(parsedHand.length() == 0){
                        parsedHand = Card_Controller.parseCard(card);
                    }else{
                        parsedHand = parsedHand + " " + Card_Controller.parseCard(card);
                    }
                }
            }else{
                System.err.println("Error HC001: NoVlaue error. Contact Admministrator");//Hand.cards can't be empty;
            }
        } else{
            System.err.println("Error HC002: NullPointer error. Contact Admministrator");//Hand can't be null;

        }
        
        return parsedHand;
    }
    
    public static String[] parseHandToCollection(Hand hand){ // Convert Hand of Cards to String Array;
        
        Card[] handCards = hand.getCards();
        String[] parsedHand = new String[handCards.length];
        int index = 0;
        
        for(Card card : handCards){            
            parsedHand[index] = Card_Controller.parseCard(card);
            index ++;
        }
        
        return parsedHand;
    }
    
    public static Hand dealHand(Deck deck){ // Create a Hand (Collection of Cards) from the built deck;
        
        Hand hand = null;
        if(Config.handSize > 0){
            hand = new Hand();
            Card[] deckCards = deck.getDeck();
            Card[] handCards = new Card[Config.handSize];

            if(deckCards.length >= Config.handSize){
                System.arraycopy(deckCards, 0, handCards, 0, Config.handSize); //Take the first 5 cards from the DECK and add it to Hand;
                
                //**************************
                //* Upgrade possibility - Not to only take the first 5 cards from the deck, but keeping track of hands already dealt and dealing from the rest of the deck for consecutive gameplay;
                //**************************
                
                hand.setCards(handCards);
            }else{
                System.err.println("Error HC003: ConfigSetup error. Contact Admministrator");//Deck does not have enough cards for this Variant of play. 'Config.handSize' or greater  cards are needed;
            }
        }
        else{
            System.err.println("Error HC004: NullPointer/NoValue error. Contact Admministrator");//Config.handSize has no value or has a nullPointer;

        }
        
        return hand;
    }
    
    
    
    public static String analyzeHand(Hand hand){// Local function to plug Analyzer Method (below), gotten online, into app;
        
        String handScore = null;
        
        if(hand != null &&  (Config.suits != null && Config.suits.length() > 0) && (Config.faces != null && Config.faces.length() > 0)){
            Score score = analyzerMethod(parseHandToCollection(hand), Config.faces, Config.suits);

            if(score != null){
                handScore = score.name;
            }
        }else{
            System.err.println("Error HC005: NullPointer error. Contact Admministrator");//Hand can't be null and Config.suits and Config.Faces cant be null or empty;
        }
        return handScore;
    }
    
 // ONLINE HAND ANALYZER CODE
 //======================================================================================================   
    
    private static Score analyzerMethod(final String[] hand, String faces, String suits) {
        if (hand.length != 5)
            return new Score("invalid hand: wrong number of cards", -1, hand);

        if (new HashSet<>(Arrays.asList(hand)).size() != hand.length)
            return new Score("invalid hand: duplicates", -1, hand);

        int[] faceCount = new int[faces.length()];
        long straight = 0, flush = 0;
        for (String card : hand) {

            int face = faces.indexOf(card.charAt(0));
            if (face == -1)
                return new Score("invalid hand: non existing face", -1, hand);
            straight |= (1 << face);

            faceCount[face]++;

            if (suits.indexOf(card.charAt(1)) == -1)
                return new Score("invalid hand: non-existing suit", -1, hand);
            flush |= (1 << card.charAt(1));
        }

        // shift the bit pattern to the right as far as possible
        while (straight % 2 == 0)
            straight >>= 1;

        // straight is 00011111; A-2-3-4-5 is 1111000000001
        boolean hasStraight = straight == 0b11111 || straight == 0b1111000000001;

        // unsets right-most 1-bit, which may be the only one set
        boolean hasFlush = (flush & (flush - 1)) == 0;

        if (hasStraight && hasFlush)
            return new Score("straight-flush", 9, hand);

        int total = 0;
        for (int count : faceCount) {
            if (count == 4)
                return new Score("four-of-a-kind", 8, hand);
            if (count == 3)
                total += 3;
            else if (count == 2)
                total += 2;
        }

        if (total == 5)
            return new Score("full-house", 7, hand);

        if (hasFlush)
            return new Score("flush", 6, hand);

        if (hasStraight)
            return new Score("straight", 5, hand);

        if (total == 3)
            return new Score("three-of-a-kind", 4, hand);

        if (total == 4)
            return new Score("two-pair", 3, hand);

        if (total == 2)
            return new Score("one-pair", 2, hand);

        return new Score("high-card", 1, hand);
    }


    private static class Score {
        final String name;
        final String[] hand;

        Score(String n, int w, String[] h) {
            name = n;
            hand = h != null ? h.clone() : h;
        }

        @Override
        public String toString() {
            return Arrays.toString(hand) + " " + name;
        }
    }
    //================================================================================================
    
} 