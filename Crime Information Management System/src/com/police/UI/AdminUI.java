package com.police.UI;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.police.DAO.Cr_Criminal_DAO;
import com.police.DAO.Cr_Criminal_DAOImpl;
import com.police.DAO.CrimeDAO;
import com.police.DAO.CrimeDAOImpl;
import com.police.DAO.CriminalDAO;
import com.police.DAO.CriminalDAOImpl;
import com.police.DTO.CrimeDTO;
import com.police.DTO.CrimeDTOImpl;
import com.police.DTO.CriminalDTO;
import com.police.DTO.CriminalDTOImpl;
import com.police.exceptions.SomethingWentWrong;

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
		} else {
			System.out.println("Invalid Credentials");
			AdminLogin(sc);
		}
	}

	static void adminMethods(Scanner sc) {
		System.out.println("+--------------------------------+" + "\n" + "| Welcome Admin !                |" + "\n"
				+ "| Choose Any option from below.  |" + "\n" + "| 1. Add Crime Details           |" + "\n"
				+ "| 2. Update Crime Details        |" + "\n" + "| 3. Add Criminal Details        |" + "\n"
				+ "| 4. Update Criminal Details     |" + "\n" + "| 5. Assign Criminals to Crime   |" + "\n"
				+ "| 6. Remove Criminals from Crime |" + "\n" + "| 7. Delete Particular Crime     |" + "\n"
				+ "| 8. Delete Particular  Criminal |" + "\n" + "| 9. Logout & Exit               |" + "\n"
				+ "+--------------------------------+");

		int choice = 0;
		try {
			choice = sc.nextInt();
			if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6 && choice != 7
					&& choice != 8 && choice != 9 && choice != 10 && choice != 11) {
				System.out.println("Please choose a number from below options");
				adminMethods(sc);
			} else
				adminChoice(choice, sc);
		} catch (InputMismatchException e) {

			System.out.println("Input type should be number");
			sc.nextLine();
			adminMethods(sc);
		}
	}

	static void adminChoice(int choice, Scanner sc) {

		switch (choice) {
		case 1: {
			AddCrime(sc);
			adminMethods(sc);
		}
			break;
		case 2: {
			UpdateCrime(sc);
			adminMethods(sc);
		}
			break;
		case 3: {
			AddCriminal(sc);
			adminMethods(sc);
		}
			break;
		case 4: {
			UpdateCriminal(sc);
			adminMethods(sc);
		}
			break;
		case 5: {
			ACrimiToCr(sc);
			adminMethods(sc);
		}
			break;
		case 6: {
			RemoveCriminals(sc);
			adminMethods(sc);
		}
			break;
		case 7: {
			DeleteCrime(sc);
			adminMethods(sc);
		}
			break;
		case 8: {
			DeleteCriminal(sc);
			adminMethods(sc);
		}
			break;
		case 9: {
			System.out.println("Thank you ! Visit again");
			// System.exit(0);
		}
		break;
		case 10:{
			ShowAllCrimes();
			adminMethods(sc);
		}
		break;
		case 11:{
			ShowAllCriminals();
			adminMethods(sc);
		}
		break;
		}
	}

	// ========================= ADD CRIME DETAILS ==========================
	static void AddCrime(Scanner sc) {
		try {
			System.out.println("Enter a type of Crime e.g.Robbery, Theft, Homicide etc.");
			String type = sc.next();

			sc.nextLine();
			System.out.println("Enter a Description of Crime: ");
			String description = sc.nextLine();

			System.out.println("Enter a police station area: ");
			String ps_area = sc.nextLine();

			System.out.println("Enter a date of crime YYYY-MM-DD Format: ");
			LocalDate date = LocalDate.parse(sc.next());

			sc.nextLine();
			System.out.println("Enter a Name of victim: ");
			String victim = sc.nextLine();

			CrimeDTO crd = new CrimeDTOImpl(0, type, description, ps_area, date, victim);

			CrimeDAO cdo = new CrimeDAOImpl();
			cdo.ADDCrime(crd);

			System.out.println("Crime Details Added Successfully. ");
			// System.out.println(type+" "+description+" "+ps_area+ " "+date+" "+victim);
		} catch (InputMismatchException | DateTimeParseException e) {
			
			System.out.println("Please Enter right information.");
		} catch (SQLException X) {
			System.out.println("Something Went Wrong. ");
		}
	}

	// ================== UPDATE CRIME DETAILS  ===============================================
	static void UpdateCrime(Scanner sc) {
		try {
			System.out.println("Enter a Crime Id: ");
			int id = sc.nextInt();

			System.out.println("Enter a type of e.g.Robbery, Theft, Homicide etc.");
			String type = sc.next();

			sc.nextLine();
			System.out.println("Enter a Description of Crime: ");
			String description = sc.nextLine();

			System.out.println("Enter a police station area: ");
			String ps_area = sc.nextLine();

			System.out.println("Enter a date of crime YYYY-MM-DD Format: ");
			LocalDate date = LocalDate.parse(sc.next());

			sc.nextLine();
			System.out.println("Enter a Name of victim: ");
			String victim = sc.nextLine();

			CrimeDTO crd = new CrimeDTOImpl(id, type, description, ps_area, date, victim);

			CrimeDAO cdo = new CrimeDAOImpl();
			cdo.UpdateCrime(crd);

			System.out.println("Crime Details Updated Successfully. ");
			// System.out.println(type+" "+description+" "+ps_area+ " "+date+" "+victim);
		} catch (InputMismatchException | DateTimeParseException e) {
			System.out.println("Please Enter right information.");
		} catch (SQLException X) {
			System.out.println("Something Went Wrong. ");
		}
	}

	// =================== ADD CRIMINAL DETAILS ===============
	static void AddCriminal(Scanner sc) {
		try {
			sc.nextLine();
			System.out.println("Enter a Name of Criminal: ");
			String name = sc.nextLine();

			System.out.println("Enter a DOB Of Criminal YYYY-MM-DD Format: ");
			LocalDate dob = LocalDate.parse(sc.next());

			sc.nextLine();
			System.out.println("Enter a Gender of Criminal: ");
			String gender = sc.nextLine();

			System.out.println("Enter a Identification Mark of Criminal: ");
			String identify_mark = sc.nextLine();

			System.out.println("Enter First Arrest Date of Criminal YYYY-MM-DD Format: ");
			LocalDate fa_date = LocalDate.parse(sc.next());

			sc.nextLine();
			System.out.println("Enter a police station area: ");
			String ps_area = sc.nextLine();

			CriminalDTO crd = new CriminalDTOImpl(0, name, dob, gender, identify_mark, fa_date, ps_area);

			CriminalDAO cdo = new CriminalDAOImpl();

			cdo.AddCriminal(crd);
			System.out.println("Criminal Details added Successfully. ");

		} catch (InputMismatchException | DateTimeParseException e) {
			System.out.println("Enter a valid Information ");
		} catch (SQLException X) {
			System.out.println("Something Went Wrong. ");
		}
	}

	// ====================== UPDATE CRIMINAL DETAILS  =======================
	static void UpdateCriminal(Scanner sc) {
		try {
			System.out.println("Enter a Criminal Id: ");
			int id = sc.nextInt();
			
			sc.nextLine();
			System.out.println("Enter a Name of Criminal: ");
			String name = sc.nextLine();

			System.out.println("Enter a DOB Of Criminal YYYY-MM-DD Format: ");
			LocalDate dob = LocalDate.parse(sc.next());

			sc.nextLine();
			System.out.println("Enter a Gender of Criminal: ");
			String gender = sc.nextLine();

			System.out.println("Enter a Identification Mark of Criminal: ");
			String identify_mark = sc.nextLine();

			System.out.println("Enter First Arrest Date of Criminal YYYY-MM-DD Format: ");
			LocalDate fa_date = LocalDate.parse(sc.next());

			sc.nextLine();
			System.out.println("Enter a police station area: ");
			String ps_area = sc.nextLine();

			CriminalDTO crd = new CriminalDTOImpl(id, name, dob, gender, identify_mark, fa_date, ps_area);

			CriminalDAO cdo = new CriminalDAOImpl();

			cdo.UpdateCriminal(crd);
			System.out.println("Criminal Details Updated Successfully. ");

		} catch (InputMismatchException | DateTimeParseException e) {
			System.out.println("Enter a valid Information ");
		} catch (SQLException X) {
			System.out.println("Something Went Wrong. ");
		}
	}

	// ============================ ASSIGN CRIMINALS TO CRIME  ================================
	static void ACrimiToCr(Scanner sc) {
		try {
			System.out.println("Enter a Crime Id: ");
			int cr_id = sc.nextInt();
			
			System.out.println("Enter a Criminal Id: ");
			int criminal_id = sc.nextInt();
			
			Cr_Criminal_DAO cdo = new Cr_Criminal_DAOImpl();
			
			cdo.AssignCriminal(cr_id, criminal_id);
			System.out.println("Criminal Assigned to crime Successfully. ");
			
		}catch(InputMismatchException x) {
			System.out.println("Enter a valid Information ");
		}catch(SomethingWentWrong | SQLException x) {
			System.out.println("Something Went Wrong. ");
		}
		
	}

	// ============================ REMOVE CRIMINALS FROM CRIME =========================================
	static void RemoveCriminals(Scanner sc) {
		try {
			System.out.println("Enter a Crime Id: ");
			int cr_id = sc.nextInt();
			
			System.out.println("Enter a Criminal Id: ");
			int criminal_id = sc.nextInt();
			
			Cr_Criminal_DAO cdo = new Cr_Criminal_DAOImpl();
			
			cdo.DeleteCrCriminal(cr_id, criminal_id);
			System.out.println("Criminal is removed from Crime Successfully. ");
			
		}catch(InputMismatchException x) {
			System.out.println("Enter a valid Information ");
		}catch( SQLException x) {
			System.out.println("Something Went Wrong. ");
		}
	}

	// ============================= DELETE PARTICULAR CRIME  ===================================
	static void DeleteCrime(Scanner sc) {
		try {
			
			System.out.println("Enter a Crime Id: ");
			int cr_id = sc.nextInt();

			CrimeDTO crd = new CrimeDTOImpl(cr_id, null, null, null, null, null);

			CrimeDAO cdo = new CrimeDAOImpl();
			cdo.RemoveCrime(crd);

			System.out.println("Crime Details Removed Successfully. ");
			// System.out.println(type+" "+description+" "+ps_area+ " "+date+" "+victim);
		} catch (InputMismatchException e) {
			System.out.println("Enter a valid Information ");
		} catch (SQLException X) {
			System.out.println("Something went wrong ");
		}
	}

	// ============================== DELETE PARTICULAR CRIMINAL  ================================
	static void DeleteCriminal(Scanner sc) {
		try {
			
			System.out.println("Enter a Criminal Id: ");
			int criminal_id = sc.nextInt();


			CriminalDTO crd = new CriminalDTOImpl(criminal_id, null, null, null, null, null, null);

			CriminalDAO cdo = new CriminalDAOImpl();

			cdo.DeleteCriminal(crd);
			System.out.println("Criminal Details Deleted Successfully. ");

		} catch (InputMismatchException e) {
			System.out.println("Ener a valid Information ");
		} catch (SQLException X) {
			System.out.println("Something went wrong ");
		}
	}
	
	//=========================== SHOW ALL CRIMES ========================================
	static void ShowAllCrimes() {
		
		CrimeDAO cdo = new CrimeDAOImpl();

		ArrayList<CrimeDTO> list = new ArrayList<>();
		try {
			list = cdo.SACrimes();
			list.stream().forEach(a -> {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("-----------------------------------------------------");
				System.out.println("Crime Id : "+a.getCrime_id());
				System.out.println("Type: "+a.getType());
				System.out.println("Description: "+a.getDescription());
				System.out.println("Police Station area: "+a.getPs_area());
				System.out.println("Date of Crime: "+a.getDate());
				System.out.println("Victim of Crime: "+a.getVictim());
				System.out.println();
			});
			System.out.println("================================================================");
		} catch (SQLException e) {
			System.out.println("Something went wrong");
		}
	}
	
	//=================== SHOW ALL CRIMINALS =========================================
	static void ShowAllCriminals() {
		
		CriminalDAO cdo = new CriminalDAOImpl();

		ArrayList<CriminalDTO> list = new ArrayList<>();
		try {
			list = cdo.SACriminals();
			list.stream().forEach(a -> {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//criminal_id | name          | dob        | gender | identifying_mark   | first_arrest_date | arrested_from_ps_area 
				System.out.println("-----------------------------------------------------");
				System.out.println("Criminal Id : "+a.getCriminal_id());
				System.out.println("Name: "+a.getName());
				System.out.println("DOB: "+a.getDob());
				System.out.println("Gender: "+a.getGender());
				System.out.println("Identification Mark is:  "+a.getIdentify_mark());
				System.out.println("First arrest Date is: "+a.getFa_date());
				System.out.println("Arrested from Police Station Area: "+a.getPs_area());
				System.out.println();
			});
			System.out.println("================================================================");
		} catch (SQLException e) {
			System.out.println("Something went wrong");
		}
	}

}
