package ch.makery.address.model;

/**
 * The different Overwatch game maps. 
 * @author Spazkat
 */
public enum OMap {
	NONE ("", MapType.UNKNOWN),
	HANAMURA ("Hanamura", MapType.ASSAULT),
	ANUBUS ("Temple of Anubis", MapType.ASSAULT),
	VOLSKAYA ( "Volskaya Industries", MapType.ASSAULT),
	ILLIOS ( "Illios", MapType.CONTROL),
	LIJIANG ( "Lijiang Tower", MapType.CONTROL),
	NEPAL ( "Nepal", MapType.CONTROL),
	DORADO ( "Dorado", MapType.ESCORT ),
	ROUTE66 ( "Route 66", MapType.ESCORT ),
	WATCHPOINT ( "Watchpoint", MapType.ESCORT ),
	EICHENWALDE ( "Eichenwalde", MapType.HYBRID ),
	HOLLYWOOD ( "Hollywood", MapType.HYBRID ),
	KINGS_ROW ( "King's Row", MapType.HYBRID ),
	NUMBANI ( "Numbani", MapType.HYBRID );
	
	private final String name; 
	private final MapType type; 
	
	OMap( final String s, final MapType t )
	{
		name = s;
		type = t; 
	}
	
	public String toString() { return name; }
}
