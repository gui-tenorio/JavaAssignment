package CAoodp;

import java.util.ArrayList;

public class Printing {
	
	CountryDAO db = new MySqlCountryDAO();
	
	public void displayCountries() {
		ArrayList<Country.BuilderCountry> countries = db.getCountries();
		for(Country.BuilderCountry c: countries) {
			System.out.println(c.build());
		}
	}

	public void displayCountryByCode(String code) {
		Country.BuilderCountry c = db.getCountryByCode(code);
		System.out.println(c.build());
	}
	
	public void displayCountryByName(String name) {
		Country.BuilderCountry country = db.getCountryByName(name);
		System.out.println(country.build());
	}
}
