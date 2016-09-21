package ch.makery.address.view;

import java.io.File;

import ch.makery.address.MainApp;
import ch.makery.address.model.CSVResultOutput;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * SubmitDataController will submit the selected data to file (OverwatchGames.csv)
 * or clear the form. 
 * @author Spazkat
 *
 */
public class SubmitDataController {


	private CSVResultOutput output = new CSVResultOutput(); 
	private MainApp mainApp; 
	
	@FXML
	TextField file_path = new TextField();
	
	@FXML
	Button submit = new Button();
	
	public void setMainApp(MainApp mainApp) 
	{
		this.mainApp = mainApp;
	}
	
	@FXML
	/**
	 * The initialization of the SubmitData panel.
	 */
	private void initialize()
	{
		//output.openFile();
		file_path.setEditable(false);
	}
	
	/**
	 * Submits the form. If this the first time the data is submitted, this action
	 * will prompt the user to pick a directory. The file will be submitted to the 
	 * file OverwatchGames.csv in the selected directory.  
	 */
	@FXML
	private void submitForm()
	{
    	System.out.println("submitted");
    	submit.setDisable(true);
    	if ( file_path.getText().isEmpty() )
    	{
    		final DirectoryChooser fileChooser = new DirectoryChooser(); 
    		Stage stage = new Stage();
    		stage.setTitle("Choose Directory");
    		
    		File folder = fileChooser.showDialog(stage);
    		output.openFile(folder.toString() + "\\OverwatchGames.csv");
    		file_path.setText(folder.toString() + "\\OverwatchGames.csv");
    	}
    	else
    	{
    		System.out.println("File Path: " + file_path.getText());
    	}
    	output.outputResults( mainApp.getPlayers(),
    			mainApp.getHeros(), 
    			mainApp.getMap(), 
    			mainApp.getTimerList());
    	submit.setDisable(false);
	}
	
	@FXML 
    private void clearForm()
    {
		System.out.println("ClearForm");
		mainApp.clear();
    }
	
    public void closeForm()
    {
    	output.closeFile();
    }
    
 

}
