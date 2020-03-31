package CAoodp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	Printing print = new Printing();
	Scanner selection = new Scanner(System.in);
	CountryDAO db = new MySqlCountryDAO();

	public void Options() {
		System.out.println("| MENU |");
		System.out.println();
		System.out.println("[1] List all countries");
		System.out.println("[2] Find a country by code");
		System.out.println("[3] Find a country by name");
		System.out.println("[4] Save new country");
		System.out.println("[5] Exit");
		System.out.println();
		System.out.print("Please make your choice from the options above: ");
		int option = selection.nextInt();

		try {
			switch (option) {
			case 1:
				print.displayCountries();
				Options();
				break;
			case 2:
				countryByCode();
				System.out.println();
				Options();
				break;
			case 3:
				countryByName();
				System.out.println();
				Options();
				break;
			case 4:
				newCountry();
				System.out.println();
				Options();
				break;
			case 5:
				System.out.println("Bye, bye....");
				System.exit(0);
				break;

			default:
				System.out.println("");
				System.out.println("No options match your input");
				System.out.println("Please, try again");
				Options();
			}
		} catch (InputMismatchException e) {
			System.out.println("Please, try again");
			selection.next();
			Options();
		}
		
	}
	
	public void countryByCode() {
		System.out.println();
		System.out.print("Please inform the country code you're looking for: ");
		String code = selection.next();
		print.displayCountryByCode(code);
	}
	
	public void countryByName() {
		System.out.println();
		System.out.println("Please inform the country name you're looking for: ");
		String name = selection.next();
		print.displayCountryByName(name);
	}
	
	public void newCountry() {
		System.out.println();
		System.out.println("-----ADDING A NEW COUNTRY-----");
		System.out.println("Code: ");
		String code = selection.next();
		
		System.out.println("Name: ");
		String name = selection.next();
		
		System.out.println("Continent: ");
		String c = selection.next();
		
		System.out.println("Surface Area: ");
		float surfaceArea = selection.nextFloat();
		
		System.out.println("Head of State: ");
		String headOfState = selection.next();
		
		Continent continent = null;
		
		continent = db.getContinent(c);
		
		Country newCountry = new Country(code, name, continent, surfaceArea, headOfState);
		db.save(newCountry);
		System.out.println("Saved!");
		
	}
}
