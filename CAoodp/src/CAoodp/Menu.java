package CAoodp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	Scanner selection = new Scanner(System.in);
	
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
				break;
			case 2:
				break;
                case 3:
                    break;
			case 4:
				break;
                case 5:
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
}
