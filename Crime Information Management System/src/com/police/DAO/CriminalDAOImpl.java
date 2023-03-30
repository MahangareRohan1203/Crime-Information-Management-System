package com.police.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.police.DTO.CriminalDTO;

public class CriminalDAOImpl implements CriminalDAO {

	@Override
	public void AddCriminal(CriminalDTO cr) throws SQLException {

		try {
			Connection cn = DBUtil.establishDBConnection();
			String querry = "INSERT INTO Criminal (name, dob, gender, identifying_mark, first_arrest_date, arrested_from_ps_area) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = cn.prepareStatement(querry);
			ps.setString(1, cr.getName());
			ps.setDate(2, Date.valueOf(cr.getDob()));
			ps.setString(3, cr.getGender());
			ps.setString(4, cr.getIdentify_mark());
			ps.setDate(5, Date.valueOf(cr.getFa_date()));
			ps.setString(6, cr.getPs_area());

			ps.executeUpdate();
			DBUtil.closeConnection(cn);
		} catch (SQLException x) {
			throw new SQLException(x);
		}
	}

	@Override
	public void UpdateCriminal(CriminalDTO cr) throws SQLException {
		try {
			Connection cn = DBUtil.establishDBConnection();
			// criminal_id | name               | dob        | gender | identifying_mark   | first_arrest_date | arrested_from_ps_area
			String querry = "UPDATE Criminal SET name = ? , dob = ? , gender = ? , identifying_mark = ? , first_arrest_date = ?, arrested_from_ps_area = ?  WHERE criminal_id = ?";
			//String querry = "INSERT INTO Criminal (name, dob, gender, identifying_mark, first_arrest_date, arrested_from_ps_area) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = cn.prepareStatement(querry);
			ps.setString(1, cr.getName());
			ps.setDate(2, Date.valueOf(cr.getDob()));
			ps.setString(3, cr.getGender());
			ps.setString(4, cr.getIdentify_mark());
			ps.setDate(5, Date.valueOf(cr.getFa_date()));
			ps.setString(6, cr.getPs_area());
			ps.setInt(7, cr.getCriminal_id());
			
			ps.executeUpdate();
			DBUtil.closeConnection(cn);
		} catch (SQLException x) {
			throw new SQLException(x);
		}
	}

}
