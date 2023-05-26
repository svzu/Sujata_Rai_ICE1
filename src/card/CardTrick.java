/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author Sujata Rai
 */
import java.util.*;

class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

public class CardTrick {
    public static void main(String[] args) {
        // Create an array to hold the cards
        Card[] magicHand = new Card[7];

        // Fill the magic hand with random cards
        fillMagicHand(magicHand);

        // Display the cards in the magic hand
        System.out.println("Magic Hand:");
        displayCards(magicHand);

        // Ask the user to pick a card
        Card userCard = getUserCard();

        // Search for the match to the user's card
        boolean foundMatch = searchCard(magicHand, userCard);

        // Display the result
        if (foundMatch) {
            System.out.println("Congratulations! Your card was found in the magic hand.");
        } else {
            System.out.println("Sorry! Your card was not found in the magic hand.");
        }
    }

    public static void fillMagicHand(Card[] magicHand) {
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

        Random random = new Random();

        for (int i = 0; i < magicHand.length; i++) {
            String suit = suits[random.nextInt(suits.length)];
            String rank = ranks[random.nextInt(ranks.length)];
            magicHand[i] = new Card(suit, rank);
        }
    }

    public static void displayCards(Card[] cards) {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    public static Card getUserCard() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick a card:");
        System.out.print("Enter the suit: ");
        String suit = scanner.nextLine();
        System.out.print("Enter the rank: ");
        String rank = scanner.nextLine();

        return new Card(suit, rank);
    }

    public static boolean searchCard(Card[] cards, Card targetCard) {
        for (Card card : cards) {
            if (card.getSuit().equalsIgnoreCase(targetCard.getSuit()) && card.getRank().equalsIgnoreCase(targetCard.getRank())) {
                return true;
            }
        }
        return false;
    }
}
    
