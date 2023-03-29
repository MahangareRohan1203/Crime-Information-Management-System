package com.police.UI;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminUI {
	public static void AdminLogin(Scanner sc) {
		System.out.println();
		System.out.println("Enter your Username: ");
		String username = sc.next();
		
		System.out.println("Enter your Password: ");
		String password = sc.next();

		if (username.equals("admin") && password.equals("admin")) {
			System.out.println("Login Successful.....");
			adminMethods(sc);
		}
		else {
			System.out.println("Invalid Credentias");
			AdminLogin(sc);
		}
	}
	
	static void adminMethods(Scanner sc) {
		System.out.println("+--------------------------------+" + "\n"
						 + "| Welcome Admin !                |" + "\n"
						 + "| Choose Any option from below.  |" + "\n"
						 + "| 1. Add Crime Details           |" + "\n"
						 + "| 2. Update Crime Details        |" + "\n"
						 + "| 3. Add Criminal Details        |" + "\n"
						 + "| 4. Update Criminal Details     |" + "\n"
						 + "| 5. Assign Criminals to Crime   |" + "\n"
						 + "| 6. Remove Criminals from Crime |" + "\n"
						 + "| 7. Delete Particular Crime     |" + "\n"
						 + "| 8. Delete Particular  Criminal |" + "\n"
						 + "| 9. Logout & Exit               |" + "\n"
						 + "+--------------------------------+" );

		int choice = 0;
		try {
			choice = sc.nextInt();
			if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5
					&& choice != 6 && choice != 7 && choice != 8 && choice != 9) {
				System.out.println("Please choose a number from below options");
				adminMethods(sc);
			}
			else adminChoice(choice,sc);
		}
		catch (InputMismatchException e) {
			
			System.out.println("Input type should be number");
			sc.nextLine();
			adminMethods(sc);
		}
	}
	
	
	static void adminChoice(int choice, Scanner sc) {

			switch(choice) {
				case 1 : {
					AddCrime(sc);
				}
				break;
				case 2 : {
					UpdateCrime(sc);
				}
				break;
				case 3 : {
					AddCriminal(sc);
				}
				break;
				case 4 : {
					UpdateCriminal(sc);
				}
				break;	
				case 5 : {
					ACrimiToCr();
				}
				break;
				case 6 : {
					RemoveCriminals(sc);
				}
				break;
				case 7 : {
					DeleteCrime(sc);
				}
				break;
				case 8 : {
					DeleteCriminal(sc);
				}
				break;					
				case 9 : {
					System.out.println("Thank you ! Visit again");
					//System.exit(0);
				}
			}
	}
	
	//=========================  ADD CRIME DETAILS ==========================
	static void AddCrime(Scanner sc) {
		try {
		System.out.println("Enter a type of e.g.Robbery, Theft, Homicide etc.");
		String type = sc.next();
		
		System.out.println("Enter a Description of Crime: ");
		String description =sc.next();
		
		sc.nextLine();
		System.out.println("Enter a police station area: ");
		String ps_area = sc.next();
		
		sc.nextLine();
		System.out.println("Enter a date of crime: ");
		LocalDate date = LocalDate.parse(sc.next());
		
		sc.nextLine();
		System.out.println("Enter a Name of victim: ");
		String victim = sc.next();
		
		System.out.println(type+" "+description+" "+ps_area+ " "+date+" "+victim);
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}
	}
	
	//================== UPDATE CRIME DETAILS ===============================================
	static void UpdateCrime(Scanner sc) {
		
	}
	
	//===================  ADD CRIMINAL DETAILS =============================================
	static void AddCriminal(Scanner sc) {
		
	}
	
	//====================== UPDATE CRIMINAL DETAILS ==========================================
	static void UpdateCriminal(Scanner sc) {
		
	}
	
	//============================ ASSIGN CRIMINALS TO CRIME ================================
	static void ACrimiToCr() {
		
	}
	
	//============================ REMOVE CRIMINALS =========================================
	static void RemoveCriminals(Scanner sc) {
		
	}
	
	//============================= DELETE PARTICULAR CRIME ===================================
	static void DeleteCrime(Scanner sc) {
		
	}
	
	//============================== DELETE PARTICULAR CRIMINAL ================================
	static void DeleteCriminal(Scanner sc) {
		
	}
	
}








