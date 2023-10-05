package com.garagna.uebungsprojekt.web;

import javax.faces.FacesException;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.TextField;

public class Welcome extends AbstractPageBean
{
	@Override
	public void prerender()
	{
		// Für RadioBotton Eventuell ->  if (! isPostBack()){...}
	}

	public String buttonRegistrieren_action()
	{

		return "";	 // navigation.xml von syAbo anpassen
	}

	public String buttonBuecherliste_action()
	{

		return "";   // navigation.xml von syAbo anpassen
	}

	public String buttonAusleihen_action()
	{

		return "";   // navigation.xml von syAbo anpassen
	}

	// void wenn ich bleibe auf der Seite und String wenn ich navigieren auf neuer Seite -->  navigation.xml von syAbo anpassen
}
