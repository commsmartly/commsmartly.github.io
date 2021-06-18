import java.awt.Color;

import javax.swing.JButton;

/**
 * 
 * @author Mike Taylor
 * 
 * Represents the state of a single button
 *
 */

public class LitePegButton extends JButton {

	final Color[] COLORS = { Color.BLACK, Color.BLUE, Color.GREEN, Color.YELLOW, Color.RED, Color.PINK }; //array of possible colors
	int colorIndex = 0; // current color index
	
	public LitePegButton() {
		this.resetColor(); // this way the buttons start off black	
	}
	
	public Color getColor() {
		return COLORS[colorIndex % COLORS.length];
	}
	
	/**
	 * Changes index to 0 and updates background color or button
	 */
	public void resetColor() {
		colorIndex = 0;
		this.setBackground(COLORS[colorIndex]);
	}
	/**
	 * Changes index to next color and updates background color or button
	 */
	public void changeColor() {
		colorIndex++;
		this.setBackground(COLORS[colorIndex % COLORS.length]); //modulo
	}
}
