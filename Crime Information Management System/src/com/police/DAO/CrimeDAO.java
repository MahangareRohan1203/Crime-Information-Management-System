package com.police.DAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.police.DTO.CrimeDTO;
import com.police.DTO.CrimeStationDTO;
import com.police.DTO.CrimeTypeDTO;

public interface CrimeDAO {

	public void ADDCrime(CrimeDTO cr) throws SQLException;

	public void UpdateCrime(CrimeDTO cr) throws SQLException;

	void RemoveCrime(CrimeDTO cr) throws SQLException;

	ArrayList<CrimeDTO> SACrimes() throws SQLException;

	ArrayList<CrimeStationDTO> viewCrByDRange(LocalDate sd, LocalDate ed) throws SQLException;

	ArrayList<CrimeTypeDTO> SACrimeByType(LocalDate sd, LocalDate ed) throws SQLException;

	ArrayList<CrimeDTO> SearchByDesc(String desc) throws SQLException;

}
