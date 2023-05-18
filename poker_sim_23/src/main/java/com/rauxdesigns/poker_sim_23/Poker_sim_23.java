package com.rauxdesigns.poker_sim_23;

import com.rauxdesigns.poker_sim_23.Controller.Hand_Controller;
import com.rauxdesigns.poker_sim_23.Controller.Deck_Controller;
import com.rauxdesigns.poker_sim_23.View.PokerTable;
import com.rauxdesigns.poker_sim_23.Model.Hand;
import com.rauxdesigns.poker_sim_23.Model.Deck;
import com.rauxdesigns.poker_sim_23.Utilities.Config;

/**
 *
 * @author alexander thompson
 * Poker Sim 23
 * at.raux@gmail.com
 * 0728007475
 * 
 */

public class Poker_sim_23 {    

    public static void main(String[] args) {

        if(Config.gameType.equals("5 Card Poker")){
            
            System.out.println("STANDARD RUN:");
            runOneHandfiveCardPoker();
            
            if(Config.runUnitTest == true){
                System.out.println("\nUNIT TEST:");
                fiveCardPokerUnitTester();
            }
        }
//      else if(Config.gameType.equals("Badugi")){
//          // Concideration 2 : add new gameType's main script here;
//      }
        else{
            // * Error code handel for if something goes wrong the developers know what issue the client is experiencing;
            System.err.println("Error PS001: gameType Config Setup error. Contact Admministrator");//Config.gameType needs to have a valid value;
        }
    }
    
    private static void runOneHandfiveCardPoker(){
        Deck deck = Deck_Controller.buildDeck();
        Hand hand = null;

        PokerTable.shuffelTheDeck(); // Print : shuffle... shuffle... shuffle...
        
        if(deck != null){
            deck = Deck_Controller.shuffelDeck(deck);
        }
        
        if(deck != null){
            hand = Hand_Controller.dealHand(deck);
        }
        
        dealAndCheckHand(hand);
    }
    
    private static void fiveCardPokerUnitTester(){
        runfiveCardPokerUnitTest("2♥ 2♦ 2♠ K♠ Q♦");
        runfiveCardPokerUnitTest("2♥ 5♥ 7♦ 8♠ 9♦");
        runfiveCardPokerUnitTest("A♥ 2♦ 3♠ 4♠ 5♠");
        runfiveCardPokerUnitTest("2♥ 3♥ 2♦ 3♠ 3♦");
        runfiveCardPokerUnitTest("2♥ 7♥ 2♦ 3♠ 3♦");
        runfiveCardPokerUnitTest("2♥ 7♥ 7♦ 7♠ 7♠");
        runfiveCardPokerUnitTest("2♥ Q♥ Q♦ Q♠ Q♣");
        runfiveCardPokerUnitTest("T♥ J♥ Q♥ K♥ A♥");
        runfiveCardPokerUnitTest("4H 4♠ K♠ 5♦ T♠");
        runfiveCardPokerUnitTest("Q♠ T♠ 7♠ 6♠ 4♠");
        runfiveCardPokerUnitTest("Q♠ T♠ 7♠ 7♠ T♦");
        runfiveCardPokerUnitTest("K♣ K♠ 2♠ 7♠ T♦");
    }
    
    private static void runfiveCardPokerUnitTest(String testHand){
        
        Hand hand = null;
        // In the unitTest we are not building a standard deck as with a normal run;
        // One hand is injected manually into the deck via 'testHand' string;
        // And we are also not shuffeling as we want a specific hand for the unit Test;
        
        Deck deck = Deck_Controller.createDeckFromCardString(testHand);
         
        if(deck != null){
            hand = Hand_Controller.dealHand(deck);
        }
        
        dealAndCheckHand(hand);  
    }
    
    private static void dealAndCheckHand(Hand hand){
        
        String check = null;
        
        if(hand != null){
            PokerTable.dealAHand(Hand_Controller.parseHandToValue(hand));
            check = Hand_Controller.analyzeHand(hand);
        }
        
        if(check != null){
            PokerTable.checkHand(check);
        }
    }
}