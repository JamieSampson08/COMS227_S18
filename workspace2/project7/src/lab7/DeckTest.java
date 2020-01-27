package lab7;

import java.util.Random;

public class DeckTest
{
  public static void main(String[] args)
  {
	Random rand = new Random(42);
    Deck deck = new Deck(rand);
    Card[] hand = deck.select(5);
    System.out.println(Card.toString(hand));
  }
}