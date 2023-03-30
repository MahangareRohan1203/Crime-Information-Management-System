package com.police.DAO;

import java.sql.SQLException;

import com.police.DTO.CriminalDTO;

public interface CriminalDAO {

	public void AddCriminal(CriminalDTO cr) throws SQLException;
	
	public void UpdateCriminal(CriminalDTO cr) throws SQLException;
}
