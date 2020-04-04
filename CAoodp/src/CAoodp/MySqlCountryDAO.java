package CAoodp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class MySqlCountryDAO implements CountryDAO {

	Continent continent;

	@Override
	public ArrayList<Country.BuilderCountry> getCountries() {
		ArrayList<Country.BuilderCountry> countries = new ArrayList<Country.BuilderCountry>();
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
				} else if (continentString.equals("Antarctica")) {
					continent = Continent.ANTARCTICA;
				} else if (continentString.equals("Oceania")) {
					continent = Continent.OCEANIA;
				} else if (continentString.equals("South America")) {
					continent = Continent.SOUTH_AMERICA;
				}
				float surfaceArea = rs.getFloat(4);
				String headOfState = rs.getString(5);

				countries.add(new Country.BuilderCountry(code, name, continent, surfaceArea, headOfState));
			}
			db.closing();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countries;
	}

	@Override
	public Country.BuilderCountry getCountryByCode(String code) {
		Country.BuilderCountry c = null;
		String query = "SELECT * FROM country WHERE Code = '" + code + "'";

		DataSource db = new DataSource();
		ResultSet rs = db.select(query);
		try {
			if (rs.next()) {

				String name = rs.getString(2);
				String continentString = rs.getString(3);

				continent = getContinent(continentString);

				float surfaceArea = rs.getFloat(4);
				String headOfState = rs.getString(5);

				c = new Country.BuilderCountry(code, name, continent, surfaceArea, headOfState);

				return c;
			} else {
				System.out.println("Not found, please try again..");
			}
			db.closing();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Country.BuilderCountry getCountryByName(String name) {
		Country.BuilderCountry c = null;
		String query = "SELECT * FROM country WHERE Name = '" + name + "'";
		DataSource db = new DataSource();
		ResultSet rs = db.select(query);
		try {

			if (rs.next()) {

				String code = rs.getString(1);
				String continentString = rs.getString(3);

				continent = getContinent(continentString);

				float surfaceArea = rs.getFloat(4);
				String headOfState = rs.getString(5);

				c = new Country.BuilderCountry(code, name, continent, surfaceArea, headOfState);

				return c;
			} else {
				System.out.println("Name not found");
			}
			db.closing();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean save(Country.BuilderCountry country) {

		DataSource db = new DataSource();

		String code = country.build().getCode();
		String name = country.build().getName();
		String continent = country.build().getContinent().getName();
		float surfaceArea = country.build().getSurfaceArea();
		String headOfState = country.build().getHeadOfState();
		String query = "INSERT INTO country (Code, Name, Continent, SurfaceArea, HeadOfState) VALUES " + "('" + code
				+ "','" + name + "','" + continent + "','" + surfaceArea + "','" + headOfState + "')";
		boolean result = db.save(query);
		db.closing();
		return result;

	}

	public Continent getContinent(String c) {

		if (c.toLowerCase().equals("africa")) {
			continent = Continent.AFRICA;
		} else if (c.toLowerCase().equals("asia")) {
			continent = Continent.ASIA;
		} else if (c.toLowerCase().equals("europe")) {
			continent = Continent.EUROPE;
		} else if (c.toLowerCase().equals("north america")) {
			continent = Continent.NORTH_AMERICA;
		} else if (c.toLowerCase().equals("antarctica")) {
			continent = Continent.ANTARCTICA;
		} else if (c.toLowerCase().equals("oceania")) {
			continent = Continent.OCEANIA;
		} else if (c.toLowerCase().equals("south america")) {
			continent = Continent.SOUTH_AMERICA;
		}

		return continent;
	}


}
