package com.police.UI;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.police.DAO.CrimeDAO;
import com.police.DAO.CrimeDAOImpl;
import com.police.DAO.CriminalDAO;
import com.police.DAO.CriminalDAOImpl;
import com.police.DTO.CrimeDTO;
import com.police.DTO.CrimeStationDTO;
import com.police.DTO.CrimeTypeDTO;
import com.police.DTO.CriminalDTO;

public class CitizenUI {
	static void citizenMethods(Scanner sc) {
		System.out.println(
				   "+---------------------------------------------------------------------------------------+" + "\n"
				 + "|  Choose Any option from below                                                         |" + "\n"
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
			citizenMethods(sc);
		}
		break;
		case 2 : {
			viewCrimeByDesc(sc);
			citizenMethods(sc);
		}
		break;
		case 3 : {
			searchByName(sc);
			citizenMethods(sc);
		}
		break;
		case 4 : {
			searchByDesc(sc);
			citizenMethods(sc);
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
	
		System.out.println("Enter a Start Date: ");
		LocalDate sd = LocalDate.parse(sc.next());
		
		System.out.println("Enter a Last Date: ");
		LocalDate ed = LocalDate.parse(sc.next());
		
		CrimeDAO cdo = new CrimeDAOImpl();
		
		ArrayList<CrimeStationDTO> list = new ArrayList<>();
		try {
			list = cdo.viewCrByDRange(sd, ed);
			System.out.println("============================================================");
			System.out.println();
			list.stream().forEach(a ->{
				System.out.println("Police Station Name: "+a.getP_station()+"\n"+ "No. of crimes = "+a.getCount());
				System.out.println("---------------------------------");
			});
			System.out.println();
			System.out.println("=============================================================");
			
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("Something went wrong");
		}
		
	}
	
	// ======== TOTAL CRIME FOR EACH CRIME TYPE FOR DATE RANGE ============================
	static void viewCrimeByDesc(Scanner sc) {
		
		System.out.println("Enter a Start Date: ");
		LocalDate sd = LocalDate.parse(sc.next());
		
		System.out.println("Enter a Last Date: ");
		LocalDate ed = LocalDate.parse(sc.next());
		
		CrimeDAO cdo = new CrimeDAOImpl();
		
		ArrayList<CrimeTypeDTO> list = new ArrayList<>();
		try {
			list = cdo.SACrimeByType(sd, ed);
			System.out.println("============================================================");
			System.out.println();
			list.stream().forEach(a ->{
				System.out.println("Crime Type : "+a.getType()+"\n"+ "No. of crimes = "+a.getNo_of_crime());
				System.out.println("---------------------------------");
			});
			System.out.println();
			System.out.println("=============================================================");
			
		} catch (SQLException e) {
			System.out.println("Something went wrong");
		}
	}
	
	//============ SEARCH FOR CRIMINAL BY NAME ============================================
	static void searchByName(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter a name of Criminal");
		String name = sc.nextLine();
		
		ArrayList<CriminalDTO> list = null;
		CriminalDAO crdao = new CriminalDAOImpl();
		try {
			list = crdao.SearchByName(name);
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
		}catch(SQLException e) {
			System.out.println("Something went wrong. ");
			
		}
	}
	
	//=============== SEARCH FOR CRIMINAL BY DESCRIPTION =================================
	static void searchByDesc(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter Description of Criminal");
		String desc = sc.nextLine();
		
		ArrayList<CrimeDTO> list = new ArrayList<>();
		CrimeDAO crdao = new CrimeDAOImpl();
		try {
			list = crdao.SearchByDesc(desc);
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
		}catch(SQLException e) {
			System.out.println("Something went wrong ");
			
		} 
	}
}
