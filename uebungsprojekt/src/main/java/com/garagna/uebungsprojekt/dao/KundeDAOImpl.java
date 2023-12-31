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
	}

	@Override
	public int delete(Integer nummer)
	{
		int rows = getSqlMapClientTemplate().delete("kunde.delete", nummer);
		return rows;
	}

	@Override
	public Integer getNextAvailableId()

	{
		Integer nummer = (Integer) getSqlMapClientTemplate().queryForObject("kunde.getNextAvailableId");
		return nummer;
	}

	@Override
	public Kunde select(Integer id)
	{
		Kunde kunde = (Kunde) getSqlMapClientTemplate().queryForObject(
			"kunde.select", id);
		return kunde;
	}
}
