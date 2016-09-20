package ch.makery.address.model;

public enum Hero {
	
	NONE (""),
	//OFFENSE
	GENJI ("Genji"),
	MCCREE ("McCree"),
	PHERAH ("Pherah"),
	REAPER ("Reaper"),
	SOLDIER ("Soldier: 76"),
	TRACER ("Tracer"),
	
	//DEFENSE
	BASTION ("Bastion"),
	HANZO ("Hanzo"),
	JUNKRAT ("Junkrat"),
	MEI ("Mei"),
	TORBJORN ("Torbjorn"),
	WIDOWMAKER ("Widowmaker"),
	
	//TANK
	DVA ("D.Va"),
	REINHARDT ("Reighardt"),
	ROADHOG ("Roadhog"),
	WINSTON ("Winston"),
	ZARYA ("Zarya"),
	
	//SUPPORT
	ANA ("Ana"),
	LUCIO ("Lucio"),
	MERCY ("Mercy"),
	SYMMETRA ("Symmetra"),
	ZENYATTA ("Zenyatta");
	
	private final String heroName; 
	
	private Hero ( final String s ) { heroName = s; }
	public String toString() { return heroName; }
}
