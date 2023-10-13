package com.garagna.uebungsprojekt.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.garagna.uebungsprojekt.types.Verlag;

public class VerlagDAOImpl
	extends SqlMapClientDaoSupport implements VerlagDAO
{
	@Override
	public Verlag select(Integer id)
	{
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public List<Verlag> selectAll()
	{
		List<Verlag> list = getSqlMapClientTemplate().queryForList("verlag.selectAll");
		return list;
	}
}
