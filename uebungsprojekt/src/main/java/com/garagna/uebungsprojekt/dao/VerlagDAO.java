package com.garagna.uebungsprojekt.dao;

import java.util.List;

import com.garagna.uebungsprojekt.types.Verlag;

public interface VerlagDAO
{
	Verlag select(Integer id);

	List<Verlag> selectAll();
}
