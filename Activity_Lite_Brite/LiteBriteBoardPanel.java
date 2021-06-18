import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * 
 * @author Mike Taylor
 * The JPanel for litebrite
 */
public class LiteBriteBoardPanel extends JPanel {

	int width, height;
	private LitePegButton[][] pegButtons;
	
	public LiteBriteBoardPanel(ActionListener LitePegListener, int width, int height) {
		this.width = width;
		this.height = height;
		this.pegButtons = new LitePegButton[width][height];
		
		this.setLayout(new GridLayout(width, height));
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				LitePegButton pegButton = new LitePegButton();
				 pegButton.addActionListener(LitePegListener);
				 pegButtons[i][j] = pegButton;
				 this.add(pegButton);
			}				
		}
	}
	
	/**
	 * Resets color of all pegs
	 */
	public void reset() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				pegButtons[i][j].resetColor();
			}
		}
	}


}
