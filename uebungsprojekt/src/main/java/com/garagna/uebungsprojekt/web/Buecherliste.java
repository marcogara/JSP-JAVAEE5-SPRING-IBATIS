package com.garagna.uebungsprojekt.web;

import com.sun.rave.web.ui.appbase.AbstractPageBean;

public class Buecherliste extends AbstractPageBean
{
	@Override
	public void prerender()
	{
		// Für RadioButton Eventuell ->  if (! isPostBack()){...}
	}

	public String buttonHome_action()
	{
		// Registrieren reg = (Registrieren) getBean("Registrieren");
		return "go_welcome";
	}

	// void wenn ich bleibe auf der Seite und String wenn ich navigieren auf neuer Seite -->  navigation.xml von syAbo anpassen
}
