package com.garagna.uebungsprojekt.dao;

import java.util.List;

import com.garagna.uebungsprojekt.types.Buch;

public interface BuchDAO
{
	List<Buch> selectAll();
}
