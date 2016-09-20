package ch.makery.address.model;

/**
 * Players in the guild. 
 * 
 * @author Spazkat
 */
public enum Player {
	NONE(""),
	JOKER87 ("Joker87"), 
	HEATDUDE ("HeatDude"),
	JELLYPANTS ("Jelly!"),
	SWEEPEA ("Sweepea"), 
	ZORDA ("Zorda"),
	BUDDYHAWKS ("BuddyHawks"),
	GOATONABOAT ("GoatOnABoat"),
	WATERSPIRIT ("WaterSpirit"),
	ENNOBLAZE ("EnnoBlaze"),
	RAWLER ("Rawler"),
	NEANT ("Neant"),
	TRAINERYELLOW ("Yellow"),
	ELLIPSIS ("Ellipsis");
	
	private final String name; 
	
	Player( final String name )
	{
		this.name = name;
	}
	
	public String toString() { return name; } 
}
