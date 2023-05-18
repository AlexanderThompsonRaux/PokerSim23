
package com.rauxdesigns.poker_sim_23.Utilities;

/**
 *
 * @author alexander
 */
public class Config {
    //===================================== Concideration 2
    public final static int handSize = 5; //handSize refers to the amount of cards dealt to the player. This can be changed for different versions of the game
    public final static String gameType = "5 Card Poker"; //gameType refers to the type of game that is played (5 hand poker /  Badugi etc.)
    //=====================================

    // Standard Deck of card values
    public final static String faces = "AKQJT98765432"; 
    public final static String suits = "♥♦♠♣";
    
    public final static boolean runUnitTest = true; // Turn unit testing on/off
}
