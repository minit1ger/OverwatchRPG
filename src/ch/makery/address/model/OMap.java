package ch.makery.address.model;

/**
 * The different Overwatch game maps. 
 * @author Spazkat
 */
public enum OMap {
	NONE ("", MapType.UNKNOWN, 0),
	
	// Assualt map. 
	// Take control of 2 checkpoints. 
	HANAMURA ("Hanamura", MapType.ASSAULT, 2),
	ANUBUS ("Temple of Anubis", MapType.ASSAULT, 2),
	VOLSKAYA ( "Volskaya Industries", MapType.ASSAULT, 2),
	
	// Control map: 
	// Control maps are the best out of 3 format. 
	ILLIOS ( "Illios", MapType.CONTROL, 5),
	LIJIANG ( "Lijiang Tower", MapType.CONTROL, 5),
	NEPAL ( "Nepal", MapType.CONTROL, 5),
	
	//Escort map: Escort the payload through 2 checkpoints. 
	DORADO ( "Dorado", MapType.ESCORT, 2),
	ROUTE66 ( "Route 66", MapType.ESCORT, 2),
	WATCHPOINT ( "Watchpoint", MapType.ESCORT, 2),
	
	// Hybrid: Must take control of the payload and push though 2 checkpoints.
	EICHENWALDE ( "Eichenwalde", MapType.HYBRID, 3),
	HOLLYWOOD ( "Hollywood", MapType.HYBRID, 3),
	KINGS_ROW ( "King's Row", MapType.HYBRID, 3),
	NUMBANI ( "Numbani", MapType.HYBRID, 3);
	
	private final String name; 
	private final MapType type; 
	
	OMap( final String s, final MapType t, final int checkpoints )
	{
		name = s;
		type = t; 
	}
	
	public String toString() { return name; }
}
