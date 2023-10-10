package com.garagna.uebungsprojekt.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.garagna.uebungsprojekt.types.Buch;

public class BuchDAOImpl
	extends SqlMapClientDaoSupport implements BuchDAO
{
	@Override
	public List<Buch> selectAll()
	{
		List<Buch> list = getSqlMapClientTemplate().queryForList("buch.selectAll");
		return list;
	}

}
