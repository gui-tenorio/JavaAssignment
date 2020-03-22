package CAoodp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySqlCountryDAO implements CountryDAO {

	Continent continent;

	@Override
	public ArrayList<Country> getCountries() {
		ArrayList<Country> countries = new ArrayList<Country>();
		String query = "SELECT * FROM country";

		DataSource db = new DataSource();

		ResultSet rs = db.select(query);

		try {
			while (rs.next()) {
				String code = rs.getString(1);
				String name = rs.getString(2);
				String continentString = rs.getString(3);
				if (continentString.equals("Africa")) {
					continent = Continent.AFRICA;
				} else if (continentString.equals("Asia")) {
					continent = Continent.ASIA;
				} else if (continentString.equals("Europe")) {
					continent = Continent.EUROPE;
				} else if (continentString.equals("North America")) {
					continent = Continent.NORTH_AMERICA;
				} else if (continentString.equals("Antartica")) {
					continent = Continent.ANTARTICA;
				} else if (continentString.equals("Oceania")) {
					continent = Continent.OCEANIA;
				} else if (continentString.equals("South America")) {
					continent = Continent.SOUTH_AMERICA;
				}
				float surfaceArea = rs.getFloat(4);
				String headOfState = rs.getString(5);

				countries.add(new Country(code, name, continent, surfaceArea, headOfState));
			}
			db.closing();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countries;
	}

	@Override
	public Country getCountryByCode(String code) {
		Country c = null;
		String query = "SELECT * FROM country WHERE Code = '" + code + "'";

		DataSource db = new DataSource();
		ResultSet rs = db.select(query);
		try {
			rs.next();
			String name = rs.getString(2);
			String continentString = rs.getString(3);
			if (continentString.equals("Africa")) {
				continent = Continent.AFRICA;
			} else if (continentString.equals("Asia")) {
				continent = Continent.ASIA;
			} else if (continentString.equals("Europe")) {
				continent = Continent.EUROPE;
			} else if (continentString.equals("North America")) {
				continent = Continent.NORTH_AMERICA;
			} else if (continentString.equals("Antartica")) {
				continent = Continent.ANTARTICA;
			} else if (continentString.equals("Oceania")) {
				continent = Continent.OCEANIA;
			} else if (continentString.equals("South America")) {
				continent = Continent.SOUTH_AMERICA;
			}
			float surfaceArea = rs.getFloat(4);
			String headOfState = rs.getString(5);

			c = new Country(code, name, continent, surfaceArea, headOfState);
			db.closing();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Country getCountryByName(String name) {
		Country c = null;
		String query = "SELECT * FROM country WHERE Name = '" + name + "'";
		DataSource db = new DataSource();
		ResultSet rs = db.select(query);
		try {
			rs.next();
			String code = rs.getString(1);
			String continentString = rs.getString(3);
			if (continentString.equals("Africa")) {
				continent = Continent.AFRICA;
			} else if (continentString.equals("Asia")) {
				continent = Continent.ASIA;
			} else if (continentString.equals("Europe")) {
				continent = Continent.EUROPE;
			} else if (continentString.equals("North America")) {
				continent = Continent.NORTH_AMERICA;
			} else if (continentString.equals("Antartica")) {
				continent = Continent.ANTARTICA;
			} else if (continentString.equals("Oceania")) {
				continent = Continent.OCEANIA;
			} else if (continentString.equals("South America")) {
				continent = Continent.SOUTH_AMERICA;
			}
			float surfaceArea = rs.getFloat(4);
			String headOfState = rs.getString(5);

			c = new Country(code, name, continent, surfaceArea, headOfState);
			db.closing();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public boolean save(Country country) {

		DataSource db = new DataSource();
		Continent c = null;
		String code = country.getCode();
		String name = country.getName();
		Continent continent = country.getContinent();
		float surfaceArea = country.getSurfaceArea();
		String headOfState = country.getHeadOfState();
		String query = "INSERT INTO country (Code, Name, Continent, SurfaceArea, HeadOfState) VALUES " + "('" + code
				+ "','" + name + "','" + continent + "','" + surfaceArea + "','" + headOfState + "')";
		boolean result = db.save(query);
		db.closing();
		return result;

	}

}
