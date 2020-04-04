package CAoodp;

import java.util.ArrayList;

public interface CountryDAO {

	public ArrayList<Country.BuilderCountry> getCountries();
	public Country.BuilderCountry getCountryByCode(String code);
	public Country.BuilderCountry getCountryByName(String name);
	public boolean save(Country.BuilderCountry country);
	public Continent getContinent(String c);
}
