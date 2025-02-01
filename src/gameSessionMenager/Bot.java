package gameSessionMenager;

import java.util.ArrayList;
import java.util.Random;

/**
 * Bot class that holds a list of cards, acts as a container for computer bots.
 * 
 * @author Aykut Bir
 * @since 08/05/2024
 * 
 */

public abstract class Bot extends Player{
	
	private static final String[] botNames = new String[] {"BOT Jane", "BOT John", "BOT Alex", "BOT Jake", "BOT Ash", "BOT Aria","BOT Josh", "BOT Ace", "BOT Mike"};
	
	/**
	 * Constructor
	 * 
	 * @param i :int used to decide bot name from the predfined bot name list.
	 */
	public Bot(int i) {
		super(botNames[i]);
	}
	
	/**
	 * Adds a new card from draw pile, removes card from top of draw pile and adds it to HumanPlayer's hand.
	 * 
	 * @see GameScreen 
	 */
	
	public void drawCard(ArrayList<Card> drawPile) {
		this.getHand().add(drawPile.remove(drawPile.size() -1));
	}
	
	/**
	 * Checks if bot has any discardable cards, using isDiscardable method
	 * 
	 * @see GameScreen 
	 */
	public boolean hasDiscardableCard(Card lastCard){
		
		boolean hasDiscardableCard = false;
		for (Card card : this.getHand()) {
			if (card.isDiscardable(lastCard)) {
				hasDiscardableCard = true;
			}
		}
		return hasDiscardableCard;
	}
	
	public abstract boolean askUNO();
	
	public abstract Card playCard(Card lastCard);
	
}
