package com.police.DAO;

import java.sql.SQLException;

import com.police.exceptions.SomethingWentWrong;

public interface Cr_Criminal_DAO {

	public void AssignCriminal(int cr_id,int criminal_id) throws SomethingWentWrong, SQLException ;

	void DeleteCrCriminal(int cr_id, int criminal_id) throws SQLException;

}
