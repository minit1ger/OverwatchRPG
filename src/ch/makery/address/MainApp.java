package ch.makery.address;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import ch.makery.address.model.Hero;
import ch.makery.address.model.OMap;
import ch.makery.address.model.Player;
import ch.makery.address.view.MapOverviewController;
import ch.makery.address.view.PersonalOverviewController;
import ch.makery.address.view.SubmitDataController;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout; 
	
	private PersonalOverviewController pcontroller;
	private MapOverviewController mcontroller; 
	private SubmitDataController scontroller; 
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Overwatch Records");
		
		initRootLayout();
		
		showEnvironmentOverview();
		showPersonalOverview();
		showSubmitData();
		
		this.primaryStage.setOnCloseRequest( new EventHandler<WindowEvent>()
		{
			public void handle(WindowEvent we)
			{
				System.out.println("Stage is closing");
			}
		} );
	}

	
	/**
	 * Initialize the root layout. This layout includes the menu bar. 
	 */
	public void initRootLayout()
	{
		try 
		{
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( MainApp.class.getResource("view/RootLayout.fxml") );
			rootLayout = (BorderPane) loader.load(); 
			
			Scene scene = new Scene(rootLayout); 
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch ( IOException ex ) 
		{
			ex.printStackTrace();
		}
	}
	
	/**
	 *  This pane will show all the players and their selections.
	 */
	public void showPersonalOverview() 
	{
		try 
		{
			FXMLLoader loader = new FXMLLoader(); 
			loader.setLocation(MainApp.class.getResource("view/PersonalOverview.fxml"));
			AnchorPane personalOverview = (AnchorPane) loader.load();
			
			rootLayout.setTop(personalOverview);
			
	        // Give the controller access to the main app.
	        pcontroller = loader.getController();
	        System.out.println("Controller: " + pcontroller);
	        pcontroller.setMainApp(this);
		} 
		catch ( IOException ex )
		{
			ex.printStackTrace();
		}
	}
	
	/**
	 * This pane will allow the user to select which environment for the game 
	 * and the times it took to complete each point. 
	 */
	public void showEnvironmentOverview()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(); 
			loader.setLocation(MainApp.class.getResource("view/MapOverview.fxml"));
			AnchorPane mapOverview = (AnchorPane) loader.load();
			
			rootLayout.setCenter(mapOverview);
			
			mcontroller = loader.getController(); 
			mcontroller.setMainApp(this);
		}		
		catch ( IOException ex )
		{
			ex.printStackTrace();
		}
	}
	
	/**
	 * Submits the data to a file. 
	 */
	public void showSubmitData()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(); 
			loader.setLocation(MainApp.class.getResource("view/SubmitData.fxml"));
			AnchorPane submitData = (AnchorPane) loader.load(); 
			
			rootLayout.setBottom(submitData);
			
			scontroller = loader.getController(); 
			System.out.println(scontroller);
	        scontroller.setMainApp(this);
		}
		catch ( IOException ex )
		{
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() 
	{
		return primaryStage;
	}
	
	public ArrayList<Player> getPlayers()
	{
		return pcontroller.getPlayers();
	}
	
	public ArrayList<Hero> getHeros()
	{
		return pcontroller.getHeros();
	}
	
	public void closeFile()
	{
		scontroller.closeForm();
	}
	
	public OMap getMap()
	{
		return mcontroller.getMap();
	}
	
	public ArrayList<Label> getTimerList()
	{
		return mcontroller.getTimerList();
	}
	
	public void clear()
	{
		mcontroller.clearForm();
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
