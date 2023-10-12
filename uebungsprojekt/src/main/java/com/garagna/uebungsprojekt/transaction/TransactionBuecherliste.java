package com.garagna.uebungsprojekt.transaction;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

	private VerlagDAO verlagDAO;

	public void setVerlagDAO(VerlagDAO verlagDAO)
	{
		this.verlagDAO = verlagDAO;
	}

	public Map<Integer, Buch> buecherlisteLaden()
	{
		List<Verlag> verlagList = this.verlagDAO.selectAll();
		Map<Integer, Verlag> verlagMap = new LinkedHashMap<>();
		for (Verlag verlag : verlagList)
		{
			verlagMap.put(verlag.getId(), verlag);
		}

		List<Buch> buchList = this.buchDAO.selectAll();
		Map<Integer, Buch> buchMap = new LinkedHashMap<>();
		for (Buch buch : buchList)
		{
			Verlag verlag = buch.getVerlag();
			verlag = verlagMap.get(verlag.getId());
			buch.setVerlag(verlag);
			buchMap.put(buch.getId(), buch);
		}
		return buchMap;
	}

	public List<Verlag> verlagLaden()
	{
		List<Verlag> list = this.verlagDAO.selectAll();
		return list;
	}

}
