package ch.makery.address.model;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;

public class Team {

	static ArrayList<Hero> hero = new ArrayList<Hero>();
    
	static
    {
      hero.add(Hero.GENJI);
      hero.add(Hero.MCCREE);
      hero.add(Hero.PHERAH);
      hero.add(Hero.REAPER);
      hero.add(Hero.SOLDIER);
      hero.add(Hero.TRACER);
      hero.add(Hero.BASTION);
      hero.add(Hero.HANZO);
      hero.add(Hero.JUNKRAT);
      hero.add(Hero.MEI);
      hero.add(Hero.TORBJORN);
      hero.add(Hero.WIDOWMAKER);
      hero.add(Hero.DVA);
      hero.add(Hero.REINHARDT);
      hero.add(Hero.ROADHOG);
      hero.add(Hero.WINSTON);
      hero.add(Hero.ZARYA);
      hero.add(Hero.ANA);
      hero.add(Hero.LUCIO);
      hero.add(Hero.MERCY);
      hero.add(Hero.SYMMETRA);
      hero.add(Hero.ZENYATTA);
    }
	
	public Team()
	{
		
	}
}
