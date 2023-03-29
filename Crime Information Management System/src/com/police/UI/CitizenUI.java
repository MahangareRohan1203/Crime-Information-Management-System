package com.police.UI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CitizenUI {
	static void citizenMethods(Scanner sc) {
		System.out.println(
				   "+---------------------------------------------------------------------------------------+" + "\n"
				 + "| Welcome Citizen ! Choose Any option from below                                        |" + "\n"
				 + "| 1. View Total Crime for Each Police Station By Date Range                             |" + "\n"
				 + "| 2. View Total Crime for Each Crime Type By Date Range                                 |" + "\n"
				 + "| 3. Search Criminal By Name                                                            |" + "\n"
				 + "| 4. Search Criminal By Description                                                     |" + "\n"
				 + "| 5. Assign Request                                                                     |" + "\n"
				 + "| 6. Logout & Exit                                                                      |" + "\n"
				 + "+---------------------------------------------------------------------------------------+" );

int choice = 0;
try {
	choice = sc.nextInt();
	if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5
			&& choice != 6 ) {
		System.out.println("Please choose a number from below options");
		sc.nextLine();
		citizenMethods(sc);
	}
	else citizenChoice(choice,sc);
}
catch (InputMismatchException e) {
	
	System.out.println("Input type should be number");
	sc.nextLine();
	citizenMethods(sc);
}
	}
	//==================== OPTIONS AVAILABLE TO CITIZENS ============================
	static void citizenChoice(int choice, Scanner sc) {
		switch(choice) {
		case 1 : {
			viewCrimeByStation(sc);
		}
		break;
		case 2 : {
			viewCrimeByDesc(sc);
		}
		break;
		case 3 : {
			searchByName(sc);
		}
		break;
		case 4 : {
			searchByDesc(sc);
		}
		break;	
		case 5 : {
			//================= PENDING HERE EXTRA METHOD ==================
		}
		break;				
		case 6 : {
			System.out.println("Thank you ! Visit again");
			//System.exit(0);
		}
	}
	}
	
	//========= TOTAL CRIME FOR EACH POLICE STATION AREA FOR DATE RANGE  =================
	static void viewCrimeByStation(Scanner sc) {
		
	}
	
	// ======== TOTAL CRIME FOR EACH CRIME TYPE FOR DATE RANGE ============================
	static void viewCrimeByDesc(Scanner sc) {
		
	}
	
	//============ SEARCH FOR CRIMINAL BY NAME ============================================
	static void searchByName(Scanner sc) {
		
	}
	
	//=============== SEARCH FOR CRIMINAL FOR DESCRIPTION =================================
	static void searchByDesc(Scanner sc) {
		
	}
}
