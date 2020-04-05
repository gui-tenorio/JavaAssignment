package CAoodp;

public class Country extends CountryFactory{
	
	protected Country(BuilderCountry builder) {
		super(builder);
	
	}

	// toString method
		@Override
		public String toString() {
			return "Country CODE: " + code + ", NAME: " + name + ", CONTINENT: " + continent + ", SURFACE AREA: "
					+ surfaceArea + ", HEAD OF STATE: " + headOfState + "";
		}
}