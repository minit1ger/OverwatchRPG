package ch.makery.address.view;

import java.util.ArrayList;
import java.util.HashMap;

import ch.makery.address.MainApp;
import ch.makery.address.model.Hero;
import ch.makery.address.model.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.ContextMenuEvent;

public class PersonalOverviewController {
	
	@FXML
	private ComboBox<Hero> hero1 = new ComboBox<Hero>();
	@FXML
	private ComboBox<Hero> hero2 = new ComboBox<Hero>();
	@FXML
	private ComboBox<Hero> hero3 = new ComboBox<Hero>();
	@FXML
	private ComboBox<Hero> hero4 = new ComboBox<Hero>();
	@FXML
	private ComboBox<Hero> hero5 = new ComboBox<Hero>();
	@FXML
	private ComboBox<Hero> hero6 = new ComboBox<Hero>();
	@FXML
	private ComboBox<Player> player1 = new ComboBox<Player>();
	@FXML
	private ComboBox<Player> player2 = new ComboBox<Player>();
	@FXML
	private ComboBox<Player> player3 = new ComboBox<Player>();
	@FXML
	private ComboBox<Player> player4 = new ComboBox<Player>();
	@FXML
	private ComboBox<Player> player5 = new ComboBox<Player>();
	@FXML
	private ComboBox<Player> player6 = new ComboBox<Player>();
	
	private ObservableList<Hero> hero = FXCollections.observableArrayList ();
	private ObservableList<Player> player = FXCollections.observableArrayList ();
	private ArrayList<ComboBox<Player>> player_list = new ArrayList<ComboBox<Player>>(); 
	private ArrayList<ComboBox<Hero>> hero_list = new ArrayList<ComboBox<Hero>>(); 
	private HashMap<String, Hero> selected_hero = new HashMap<String, Hero> (); 
	private HashMap<String, Player> selected_player = new HashMap<String, Player>();
	
	private MainApp mainApp; 
	
	@FXML
	private void initialize()
	{
		initializeHeros();
		initializePlayers();	
	}

	final EventHandler<ActionEvent> showHero = new EventHandler<ActionEvent>() 
	{
		@Override
		public void handle( final ActionEvent event ) {
			System.out.println("showHero");
			ComboBox<Hero> x = (ComboBox<Hero>) event.getSource();
			
			for ( ComboBox<Hero> h : hero_list )
			{
				if ( x.getId().equals(h.getId()))
				{ 
					System.out.println("Selected: " + x.getValue().toString());
					if ( selected_hero.containsKey(x.getId()) )
					{
						
					}
				}
			}
		}
	};
	
	final EventHandler<ContextMenuEvent> saveHero = new EventHandler<ContextMenuEvent>() 
	{
		@Override
		public void handle( final ContextMenuEvent event ) {
			System.out.println("saveHero");
			ComboBox x = (ComboBox) event.getSource();
			
			for ( ComboBox h : hero_list )
			{
				if ( x.getId().equals(h.getId()))
				{
					System.out.println("ID: " + x.getId());
				}
			}
		}
	};
	
	@FXML
	private void test()
	{
		System.out.println("test");
	}
	
	/**
	 * Returns the list of players written in the combo boxes. 
	 * @return
	 */
	public ArrayList<Player> getPlayers()
	{
		ArrayList<Player> players = new ArrayList<Player>();
		
		for ( int i = 0; i < player_list.size(); i++ )
		{
			if ( hero_list.get(i).getValue() != null ||
					 player_list.get(i).getValue() != null )
			{
				players.add(player_list.get(i).getValue());
			}
			else
			{
				players.add(Player.NONE);
			}
		}
		
		return players; 
	}
	
	/**
	 * Returns the list of heros written in the combo boxes. 
	 * @return
	 */
	public ArrayList<Hero> getHeros()
	{
		ArrayList<Hero> heros = new ArrayList<Hero>(); 
		
		for ( int i = 0; i < hero_list.size(); i++)
		{
			if ( hero_list.get(i).getValue() != null ||
				 player_list.get(i).getValue() != null )
			{
				heros.add(hero_list.get(i).getValue());
			}
			else
			{
			    heros.add(Hero.NONE);
			}
		}
		
		return heros; 
	}
	
	/**
	 * Is called by the main application to give a reference back to itself. 
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp)
	{
		this.mainApp = mainApp;
	}
	
	/**
	 * Adds heros to the combo boxes. 
	 * Adds heros to array list to easy access. 
	 */
	private void initializeHeros()
	{
		for ( Hero h : Hero.values() )
		{
			hero.add(h);
		}
		
		hero_list.add(hero1);
		hero_list.add(hero2);
		hero_list.add(hero3);
		hero_list.add(hero4);
		hero_list.add(hero5);
		hero_list.add(hero6);
		
		for ( ComboBox<Hero> c : hero_list )
		{
			c.setItems(hero);
			c.setOnAction(showHero);
			c.setOnContextMenuRequested(saveHero);
		}
	}
	
	/**
	 * Adds players to the combo boxes. 
	 * Adds players to array list to easy access. 
	 */
	private void initializePlayers() 
	{
		for ( Player p : Player.values() )
		{
		    player.add(p);
		}

		player_list.add(player1);
		player_list.add(player2);
		player_list.add(player3);
		player_list.add(player4);
		player_list.add(player5);
		player_list.add(player6);
		
		for ( ComboBox<Player> p : player_list )
		{
			p.setItems(player);
		}
	}
}
