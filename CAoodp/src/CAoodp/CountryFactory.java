package CAoodp;

// factory abstract + builder pattern class
public abstract class CountryFactory {

	protected String code;
	protected String name;
	protected Continent continent;
	protected float surfaceArea;
	protected String headOfState;

	protected CountryFactory(BuilderCountry builder) {

		this.code = builder.code;
		this.name = builder.name;
		this.continent = builder.continent;
		this.surfaceArea = builder.surfaceArea;
		this.headOfState = builder.headOfState;
	}

	// getters and setters
	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public Continent getContinent() {
		return continent;
	}

	public float getSurfaceArea() {
		return surfaceArea;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	// toString method
	@Override
	public String toString() {
		return "Country CODE: " + code + ", NAME: " + name + ", CONTINENT: " + continent + ", SURFACE AREA: "
				+ surfaceArea + ", HEAD OF STATE: " + headOfState + "";

	}

	public static class BuilderCountry {

		private String code;
		private String name;
		private Continent continent;
		private float surfaceArea;
		private String headOfState;

		public BuilderCountry(String code, String name, Continent continent, float surfaceArea, String headOfState) {
			this.code = code;
			this.name = name;
			this.continent = continent;
			this.surfaceArea = surfaceArea;
			this.headOfState = headOfState;
		}

		public BuilderCountry setCode(String code) {
			this.code = code;
			return this;
		}

		public BuilderCountry setName(String name) {
			this.name = name;
			return this;
		}

		public BuilderCountry setContinent(Continent continent) {
			this.continent = continent;
			return this;
		}

		public BuilderCountry setSurfaceArea(float surfaceArea) {
			this.surfaceArea = surfaceArea;
			return this;
		}

		public BuilderCountry setHeadOfState(String headOfState) {
			this.headOfState = headOfState;
			return this;
		}

		public CountryFactory build() {
			return new Country(this);
		}
	}

}
