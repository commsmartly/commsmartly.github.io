import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LiteBritePanel extends JPanel
{
	private LiteBriteBoardPanel board;
	private JButton resetButton;
//	private JButton peg = new LitePegButton();
	
	/**
	 * Creates a new LiteBrite GUI with specified width and height.
	 * @param width The number of pegs in the horizontal axis.
	 * @param height The number of pegs in the vertical axis.
	 */
	public LiteBritePanel(int width, int height)
	{
		// Create new LiteBriteBoard with specified dimensions
		board = new LiteBriteBoardPanel(new LitePegListener(), width, height);
		
		// Create reset button and add ActionListener to it.
		resetButton = new JButton("Reset");
		resetButton.addActionListener(new ResetButtonListener());
		
		// Add sub-components to this main panel.
		this.add(board);
		this.add(resetButton);
	}
	
	/**
	 * The ActionListener for the button to reset the game.
	 */
	private class ResetButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			board.reset();
		}
	}
	
	private class LitePegListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JButton clicked = (JButton) e.getSource();
			Random rand = new Random();		
			Color randomColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
			
			clicked.setBackground(randomColor);
			
	//		clicked.getColor();
	// 		Commented this out because I couldn't figure this part out, but wanted to show what I tried to do. I made a random color generator instead.
	//		I don't know what I can't seem to find a way to call the method getColor() and I tried a lot of ways. Must be overlooking something stupid.	Also commented out an instance variable that I thought I needed	
			
		}
		
	}
	
}