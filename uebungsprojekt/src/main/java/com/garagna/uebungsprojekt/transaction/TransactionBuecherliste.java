package com.garagna.uebungsprojekt.transaction;

import java.util.List;

import com.garagna.uebungsprojekt.dao.BuchDAO;
import com.garagna.uebungsprojekt.dao.VerlagDAO;

import com.garagna.uebungsprojekt.types.Verlag;
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

	private VerlagDAO verlagDAO;

	public void setVerlagDAO(VerlagDAO verlagDAO)
	{
		this.verlagDAO = verlagDAO;
	}

	public List<Verlag> verlagLaden()
	{
		List<Verlag> list = this.verlagDAO.selectAll();
		return list;
	}

}
