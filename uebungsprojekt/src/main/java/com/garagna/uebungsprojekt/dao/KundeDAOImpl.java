package com.garagna.uebungsprojekt.dao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.garagna.uebungsprojekt.types.Kunde;

public class KundeDAOImpl
	extends SqlMapClientDaoSupport implements KundeDAO
{
	@Override
	public void insert(Kunde kunde)
	{
		getSqlMapClientTemplate().insert("kunde.insert", kunde);

		// throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public int delete(Integer nummer)
	{
		int rows = getSqlMapClientTemplate().delete("kunde.delete", nummer);

		// throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
		return rows;
	}
}
