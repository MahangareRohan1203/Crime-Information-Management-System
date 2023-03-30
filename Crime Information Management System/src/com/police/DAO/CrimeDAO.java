package com.police.DAO;

import java.sql.SQLException;

import com.police.DTO.CrimeDTO;

public interface CrimeDAO {

	public void ADDCrime(CrimeDTO cr) throws SQLException;

	public void UpdateCrime(CrimeDTO cr) throws SQLException;

}
