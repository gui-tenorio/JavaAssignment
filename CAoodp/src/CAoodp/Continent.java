package CAoodp;

public enum Continent {
	
	ASIA("Asia"),
	EUROPE("Europe"),
	NORTH_AMERICA("North America"),
	AFRICA("Africa"),
	OCEANIA("Oceania"),
	ANTARTICA("Antartica"),
	SOUTH_AMERICA("South America");
	
	private final String name;
	
	Continent(String name){
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

}
