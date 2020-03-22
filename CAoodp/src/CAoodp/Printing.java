package CAoodp;

import java.util.ArrayList;

public class Printing {
	
	CountryDAO db = new MySqlCountryDAO();
	
	public void displayCoutries() {
		ArrayList<Country> countries = db.getCountries();
		for(Country c: countries) {
			System.out.println(c);
		}
	}

	public void displayCountryByCode(String code) {
		Country c = db.getCountryByCode(code);
		System.out.println(c);
	}
	
	public void displayCountryByName(String name) {
		Country country = db.getCountryByName(name);
		System.out.println(country);
	}
	
	public void addNewCountry(Country country) {
		db.save(country);
		
	}
}
