package com.garagna.uebungsprojekt.web;

import com.garagna.uebungsprojekt.types.Kunde;
import com.sun.rave.web.ui.appbase.AbstractPageBean;

public class Registrieren extends AbstractPageBean
{

	public String buttonRegister_action()
	{
		// Create a new Kunde instance and populate its properties
		Kunde kunde = new Kunde();
		//  kunde.setNummer(nummer); es sool den id nummer von den datenbank zurückgeben......
		kunde.setVorname("Bob");		 // soll von ein inputTextFeld kommen
		kunde.setName("Erste");			 // soll von ein inputTextFeld kommen
		kunde.setGuthaben(20);	     // soll von ein inputTextFeld kommen

		// Implement any validation logic here
		// SQL mit Kundendaten abfragen und ID abrufen
		// If validation passes, add the Kunde to the list of registered customers when we have the we can have an HashMap!
		// um diese Funktionalität weitere zu Erstellen
		Kunde.addRegisteredCustomers(kunde);

		// Redirect to a success page or perform other actions as needed
		// refresh page and display kundendaten registration with kundennummer and confirmation. after that kunde can go to Ausleihen page for instance....
		return "registration_success";
	}

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
