package com.police.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.police.DTO.CriminalDTO;

public interface CriminalDAO {

	public void AddCriminal(CriminalDTO cr) throws SQLException;
	
	public void UpdateCriminal(CriminalDTO cr) throws SQLException;

	public void DeleteCriminal(CriminalDTO cr) throws SQLException;
	
	ArrayList<CriminalDTO> SACriminals() throws SQLException;

	ArrayList<CriminalDTO> SearchByName(String name) throws SQLException;
}
