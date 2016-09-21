package ch.makery.address.view;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import ch.makery.address.MainApp;
import ch.makery.address.model.CSVResultOutput;
import ch.makery.address.model.OMap;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 * MapOverviewController is a javaFX container that contains the following: 
 *  	1.) The Overwatch MAP that was played. 
 *  	2.) Times to complete each point and thus the map. 
 *  	3.) If the round was attack or defend. 
 * @author Spazkat
 *
 */
public class MapOverviewController {

	@FXML
	ComboBox<OMap> map_name = new ComboBox<OMap>();
	private ObservableList<OMap> mapList = FXCollections.observableArrayList ();
	
	// The point labels. 
	@FXML
	Label point1 = new Label();
	@FXML
	Label point2 = new Label();
	@FXML
	Label point3 = new Label();
	@FXML
	Label point4 = new Label();
	@FXML
	Label point5 = new Label();
	
	//Time labels
	@FXML
	Label time1 = new Label();
	@FXML
	Label time2 = new Label();
	@FXML
	Label time3 = new Label();
	@FXML
	Label time4 = new Label();
	@FXML
	Label time5 = new Label();
	
	@FXML
	//indicates if the records are attack or defense. 
	CheckBox attack = new CheckBox();
	
	@FXML
	//Timer to track time.
	Button triggerTimer = new Button(); 
	
	//Containers to iterate through GUI items. 
	ArrayList<Label> timer_list = new ArrayList<Label>();
	ArrayList<Label> point_list = new ArrayList<Label>(); 
	ArrayList<Timeline> timeline_list = new ArrayList<Timeline>();
	
	//The number of points captured. 
	private int pointCount = 0; 
	
	private MainApp mainApp; 

	long start_time = 0; 
	long duration = 0;
	
	/**
	 * MapOverviewController constructor.
	 */
	public MapOverviewController()
	{
	}
	

	@FXML
	/**
	 * The initialization of the Environment panel.
	 */
	private void initialize()
	{
		System.out.println("Environment:initialize!");
		pointCount = 0;
		  
		// Update the map lists.
		for ( OMap m : OMap.values() )
		{
			mapList.add(m);
		}
		map_name.setItems(mapList);
		
	    initializePointLabels();
	    initalizeTimerLabels();

	}
	
	
    @FXML
	private void updateTimer()
	{
		System.out.println("Updating Timer");
		
		start_time = System.currentTimeMillis();
		int currentPoint = pointCount; 
	
		
		if ( currentPoint == 0 )
		{
			attack.setDisable(true);
			attack.setText("Defend");
			triggerTimer.setText("Interval");
		}
		else
		{
			// Stop the previous timer
			timeline_list.get(currentPoint - 1).stop();
		}
		
		if ( currentPoint == timer_list.size() - 1 )
		{
			triggerTimer.setText("Stop");
		}
		
		if ( currentPoint == timer_list.size() )
		{
			triggerTimer.setDisable(true);
		}
		
		if ( (currentPoint) < timer_list.size() )
		{
		  timer_list.get(currentPoint).setVisible(true);
		  point_list.get(currentPoint).setVisible(true); 
		  
		  timeline_list.get(currentPoint).setCycleCount(Timeline.INDEFINITE);
		  timeline_list.get(currentPoint).getKeyFrames().add(
		    new KeyFrame(Duration.seconds(1),
		      new EventHandler() {

				@Override
				public void handle(Event event) {
				  if ( currentPoint < timer_list.size() + 1 )
				  {
					  timer_list.get(currentPoint).setText(getTime());
				  }
				} 
				
				public String getTime( )
				{
					duration = System.currentTimeMillis() - start_time; 
					return String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(duration), 
							TimeUnit.MILLISECONDS.toSeconds(duration) - 
							TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
				}
		    	
				  }));
		  timeline_list.get(currentPoint).playFromStart();

		}
		  pointCount++;
	}
	
    public void clearForm()
    {
    	System.out.println("clear");
		for ( Timeline t : timeline_list )
		{
			t.stop();
		}
		
		mapList.clear();
		point_list.clear();
		timer_list.clear();
		timeline_list.clear();
    	initialize();
    }
    
    /**
     * initializes the point labels. The labels will start as invisible with the
     * exception of the first one. 
     */
	public void initializePointLabels()
	{
		point_list.add(point1);
		point_list.add(point2);
		point_list.add(point3);
		point_list.add(point4);
		point_list.add(point5);
		
		for ( Label point : point_list )
		{
			point.setVisible(false);
		}
		point1.setVisible(true);
	}
	
	/**
	 * initializes the timer labels. The labels will start as invisible with the 
	 * exception of the first one. 
	 */
	public void initalizeTimerLabels()
	{
		timer_list.add(time1);
		timer_list.add(time2);
		timer_list.add(time3);
		timer_list.add(time4);
		timer_list.add(time5);
		for ( Label timer : timer_list )
		{
			timer.setVisible(false);
			timer.setText("00:00");
			timeline_list.add(new Timeline());
		}
		time1.setVisible(true);
	}
	
    
    /**
     * 
     * @return
     */
    public OMap getMap( )
    {
    	if ( map_name.getValue() == null )
    	{
    		return OMap.NONE;
    	}
    	return map_name.getValue();
    }

    public ArrayList<Label> getTimerList()
    {
    	return timer_list;
    }
    
	public void setMainApp(MainApp mainApp)
	{
		this.mainApp = mainApp;
	}
}
