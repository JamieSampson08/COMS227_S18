package lab7;

import lab7.Card.Suit;

/**
 * Creates a standard 5 card hand for poker, and identifies which type of hand
 * it is, e.g. straight, flush, or full-house.
 */
public class PokerHand
{

  /**
   * The 5 cards comprising a hand.
   */
  private Card[] cards;

  /**
   * Creates a hand using the 5 cards passed in.
   */
  public PokerHand(Card[] cards)
  {
    this.setHand(cards);
  }

  /**
   * Sets the cards in the hand.
   * 
   * @param cards
   *          a 5 card array. If not 5 cards, a RuntimeException is thrown.
   */
  public void setHand(Card[] cards)
  {
    if (cards.length == 5)
    {
      this.cards = cards;
    }
    else
    {
      throw new RuntimeException("Wrong number of cards. ");
    }
  }

  /**
   * Determines whether or not a hand is made up of cards from a single suit.
   * Should work with more than 4 suits, and any number of cards.
   * 
   * @return true iff all the cards have the same suit
   */
  public boolean isFlush()
  {
    sortWithSuit();
    return cards[0].getSuit().equals(cards[cards.length - 1].getSuit());
  }

  /**
   * Determines whether or not a hand is made up of consecutively increasing
   * ranks. E.g. 2, 3, 4, 5, 6. Should work with more than 4 suits, and any
   * number of cards.
   * 
   * @return true iff we have a straight
   */
  /*
   * Complete the isStraight() method. A straight is whenever you have 5 cards 
   * in a row, for example: 4, 5, 6, 7, 8. (Note: We are interpreting the ranks 
   * literally, meaning that we ignore the situation in many versions of the game 
   * of poker in which the ace or 1 card may be counted as higher than a king.) 
   */
  public boolean isStraight()
  {
    sortNoSuit();
    boolean straight = true;
    int value = cards[0].getRank();
    for(int i = 1; i < cards.length; i++) {
    	if(!(value +1 == cards[i].getRank())) {
    		straight = false;
    	}
    	value = cards[i].getRank();
    }
    return straight;
  }

  /**
   * Looks if we have a pair and a three of a kind in the hand.
   * 
   * @return true iff we have a full house.
   */
  /*Complete the isFullHouse() method. A full house is whenever you 
   *have a pair and a triple, such as 3, 3, K, K, K or 3, 3, 3, K, K. 
   * 
   */
  public boolean isFullHouse()
  {
    sortNoSuit();
    boolean pair = false;
    boolean triple = false;
    int prevRank = 0;
    int i = 0;
    int count = 0;
    int start = i;
    int k = 0;
    for(int j = 0; j < cards.length; j++) {
    	count = 0;
    	do {
    		if(i < cards.length) {
    			prevRank = cards[i].getRank();
    			i++;
    			count ++;
    			start = i;
    			if(i == cards.length) {
    				break;
    			}

    		}
    		else {
    			break;
    		}
    	}while(cards[i].getRank() == prevRank);
    	if(count == 2) {
    		pair = true;
    	}
    	if(count == 3) {
    		triple = true;
    	}
    	if(pair && start == 1) {
    		if(cards[start+1].getSuit() == cards[start+2].getSuit() && cards[start+3].getSuit() == cards[start+2].getSuit()){
    			triple = true;
    		}
    	}
    	else if(triple && start == 2) {
    		if(cards[start+1].getSuit() == cards[start+2].getSuit()) {
    			pair = true;
    		}
    	}

    }
    
    return pair && triple;
  }

  /**
   * Sorts the cards by their suit and then their rank.
   */
  private void sortWithSuit()
  {
    for (int i = 0; i < cards.length - 1; ++i)
    {
      // Step 1: find the "minimal" element to the right of position i
      int indexOfMin = findIndexOfMin(i);

      // Step 2: swap the minimal element into position i
      swap(i, indexOfMin);
    }
  }

  /**
   * Returns the index of the minimal element to the right of position 'start',
   * where cards are ordered first by suit, and within the same suit, by rank.
   * 
   * @param start
   *          first index at which to look
   * @return index of the smallest element to the right of 'start'
   */
  private int findIndexOfMin(int start)
  {
    int indexOfMin = start;
    for (int j = start + 1; j < cards.length; ++j)
    {
      // look at the two cards, the minimal one we've found,
      // and the one at the current position j
      Card min = cards[indexOfMin];
      Card current = cards[j];

      // if current has a lower suit than the current min, then it should come
      // first
      if (current.getSuit().compareTo(min.getSuit()) < 0)
      {
        indexOfMin = j;
      }
      else if (current.getSuit().equals(min.getSuit()))
      {
        // suits are the same, so compare ranks
        if (current.getRank() < min.getRank())
        {
          indexOfMin = j;
        }
      }
      // otherwise, current does not come before min, so ignore it
    }
    return indexOfMin;
  }

  /**
   * Sorts the cards according to their rank, ignoring their suits.
   */
  private void sortNoSuit()
  {
	  int indexOfMin = 0;
	  Card min;
	  Card current;
	  for (int i = 0; i < cards.length - 1; ++i) {
		  indexOfMin = i;
		    for (int j = i + 1; j < cards.length; ++j)
		    {
		    	min = cards[indexOfMin];
		    	current = cards[j];
		        if (current.getRank() < min.getRank())
		        {
		          indexOfMin = j;
		        }
		    }
		  swap(i, indexOfMin);
	  }
  }

  /**
   * Swaps the cards i and j in the hand.
   * 
   * @param i
   *          the first card to swap
   * @param j
   *          the card to swap with
   */
  private void swap(int i, int j)
  {
    Card c = cards[i];
    cards[i] = cards[j];
    cards[j] = c;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
  {
    if (isFullHouse())
    {
      return "a Full House!";
    }
    else if (isFlush())
    {
      if (isStraight())
      {
        return "a Straight Flush!";
      }
      else
      {
        return "a Flush!";
      }
    }
    else if (isStraight())
    {
      return "a Straight!";
    }
    return "Nothing";
  }

  /**
   * Prints out the suit and rank of each card in the hand in order.
   */
  public void printHand()
  {
    for (int i = 0; i < 5; i++)
    {
      System.out.print(cards[i].getSuit() + ":" + cards[i].getRank() + ", ");
    }
    System.out.println();
  }

}