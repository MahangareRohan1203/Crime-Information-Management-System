package com.police.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.police.DTO.CrimeDTO;

public class CrimeDAOImpl implements CrimeDAO {

	// ======================= ADD CRIME DATA IN DATABASE ==========================
	@Override
	public void ADDCrime(CrimeDTO cr) throws SQLException {

		try {
			Connection cn = DBUtil.establishDBConnection();
			String querry = "INSERT INTO Crime (type, description, ps_area, cr_date, name_of_victim) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement ps = cn.prepareStatement(querry);
			ps.setString(1, cr.getType());
			ps.setString(2, cr.getDescription());
			ps.setString(3, cr.getPs_area());
			ps.setDate(4, Date.valueOf(cr.getDate()));
			ps.setString(5, cr.getVictim());

			ps.executeUpdate();
			DBUtil.closeConnection(cn);
		} catch (SQLException x) {
			throw new SQLException(x);
		}
	}

	// =========================== UPDATE CRIME DATA IN DATABASE =====================================
	@Override
	public void UpdateCrime(CrimeDTO cr) throws SQLException {

		try {
			Connection cn = DBUtil.establishDBConnection();
			String querry = "UPDATE Crime SET type = ? , description = ? , ps_area = ? , cr_date = ? , name_of_victim = ? WHERE crime_id = ?";
			PreparedStatement ps = cn.prepareStatement(querry);
			ps.setString(1, cr.getType());
			ps.setString(2, cr.getDescription());
			ps.setString(3, cr.getPs_area());
			ps.setDate(4, Date.valueOf(cr.getDate()));
			ps.setString(5, cr.getVictim());
			ps.setInt(6, cr.getCrime_id());

			ps.executeUpdate();
			DBUtil.closeConnection(cn);
		} catch (SQLException x) {
			throw new SQLException(x);
		}
	}

}
