package CAoodp;

public enum Continent {
	
	// continents names
	ASIA ("Asia"),
	EUROPE ("Europe"),
	NORTH_AMERICA ("North America"),
	AFRICA ("Africa"),
	OCEANIA ("Oceania"),
	ANTARCTICA ("Antarctica"),
	SOUTH_AMERICA ("South America");
	
	private final String name;
	
	
	Continent(String name){
		this.name = name;
	}
	
	//method that returns continent string
	public String getName() {
		return this.name;
	}

}
