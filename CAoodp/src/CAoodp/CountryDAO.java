package CAoodp;

import java.util.ArrayList;

public interface CountryDAO {

	public ArrayList<Country> getCountries();
	public Country getCountryByCode(String code);
	public Country getCountryByName(String name);
	public boolean save(Country country);
	public Continent getContinent(String c);
}
