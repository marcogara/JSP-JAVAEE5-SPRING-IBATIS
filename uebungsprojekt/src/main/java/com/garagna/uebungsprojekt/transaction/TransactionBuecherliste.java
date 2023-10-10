package com.garagna.uebungsprojekt.transaction;

import java.util.List;

import com.garagna.uebungsprojekt.dao.BuchDAO;
import com.garagna.uebungsprojekt.types.Buch;

public class TransactionBuecherliste
{

	private BuchDAO buchDAO;

	public void setBuchDAO(BuchDAO buchDAO)
	{
		this.buchDAO = buchDAO;
	}

	public List<Buch> buecherlisteLaden()
	{
		List<Buch> list = this.buchDAO.selectAll();
		return list;
	}
}
