package ch.makery.address.model;

import java.util.ArrayList;

import javafx.scene.control.Label;

/**
 * Result Output is an interface to outline how to handle result output. 
 * @author Spazkat
 *
 */
public interface ResultOutput {
	
	/**
	 * Opens the file.
	 */
	public abstract void openFile();
	
	/**
	 * Closes the file. 
	 */
	public abstract void closeFile();
	
	/**
	 * Outputs one result to the opened file. The file output will be flushed to the file. 
	 * @param players List of players
	 * @param heros List of player heros. 
	 * @param map The map that was played on. 
	 * @param times The point times. 
	 */
	public abstract void outputResults( ArrayList<Player> players, 
			                            ArrayList<Hero> heros, 
			                            OMap map, 
			                            ArrayList<Label> times );
}
