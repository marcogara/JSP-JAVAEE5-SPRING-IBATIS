package com.garagna.uebungsprojekt.dao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.garagna.uebungsprojekt.types.Kunde;

public class KundeDAOImpl
	extends SqlMapClientDaoSupport implements KundeDAO
{
	@Override
	public void insert(Kunde kunde)
	{
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

	}

}
