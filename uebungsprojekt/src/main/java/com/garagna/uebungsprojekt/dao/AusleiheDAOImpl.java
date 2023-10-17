package com.garagna.uebungsprojekt.dao;

import com.garagna.uebungsprojekt.types.Ausleihe;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class AusleiheDAOImpl
	extends SqlMapClientDaoSupport implements AusleiheDAO
{
	@Override
	public void insert(Ausleihe ausleihe)
	{
		getSqlMapClientTemplate().insert("ausleihe.insert", ausleihe);
	}
}
