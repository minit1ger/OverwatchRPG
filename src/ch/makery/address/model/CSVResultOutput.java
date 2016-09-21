package ch.makery.address.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.stage.FileChooser;

/**
 * Outputs the CVS information to a file OverwatchGames.csv. 
 * @author Spazkat
 *
 */
public class CSVResultOutput implements ResultOutput {

	PrintWriter pw = null;
	File dir = null;
	
	/**
	 * Opens the file
	 */
	@Override
	public void openFile( String file_name) {
		FileWriter file;
		try 
		{
            file = new FileWriter( file_name, true); //Create file at Directory
            pw = new PrintWriter( file, true );                                 //Write file
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Closes the file. 
	 */
	@Override
	public void closeFile() {
		pw.close();		
	}

	/**
	 * Outputs one result to the opened file. The file output will be flushed to the file. 
	 * @param players List of players
	 * @param heros List of player heros. 
	 * @param map The map that was played on. 
	 * @param times The point times. 
	 */
	@Override
	public void outputResults(ArrayList<Player> players, 
			                  ArrayList<Hero> heros, 
			                  OMap map, 
			                  ArrayList<Label> times) {
		
		StringBuffer output = new StringBuffer();
		
		output.append(map.toString()).append(",");
		for ( int i = 0; i < players.size(); i++ )
		{
			output.append(players.get(i).toString()).append(",");
			output.append(heros.get(i).toString()).append(",");
		}
		
		for ( Label time : times )
		{
			output.append(time.getText()).append(",");
		}
		
		if ( pw != null )
		{
			pw.println(output.toString());
			pw.flush();
		}

	}

}
