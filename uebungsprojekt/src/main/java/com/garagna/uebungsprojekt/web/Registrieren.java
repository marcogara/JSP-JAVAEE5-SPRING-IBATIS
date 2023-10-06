package com.garagna.uebungsprojekt.web;

import com.garagna.uebungsprojekt.types.Kunde;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.TextField;

public class Registrieren extends AbstractPageBean
{
	private TextField textFieldBenutzernvoraname = new TextField();

	private TextField textFieldBenutzernnachname = new TextField();

	private TextField textFieldGuthaben = new TextField();

	private String testMessage = "test";           // Für Meldungen und oder testing

	public String getTestMessage()
	{
		return testMessage;
	}

	public void setTestMessage(String testMessage)
	{
		this.testMessage = testMessage;
	}

	public TextField getTextFieldBenutzernvoraname()
	{
		return textFieldBenutzernvoraname;
	}

	public void setTextFieldBenutzernvoraname(TextField tf)
	{
		this.textFieldBenutzernvoraname = tf;
	}

	public TextField getTextFieldBenutzernnachname()
	{
		return textFieldBenutzernnachname;
	}

	public void setTextFieldBenutzernnachname(TextField tf)
	{
		this.textFieldBenutzernnachname = tf;
	}

	public TextField getTextFieldGuthaben()
	{
		return textFieldGuthaben;
	}

	public void setTextFieldGuthaben(TextField tf)
	{
		this.textFieldGuthaben = tf;
	}

	public void buttonBestaetigung_action()
	{
		Kunde kunde = new Kunde();
		//	 kunde.setNummer(nummer); es soll den id nummer von den datenbank abgefragt werden

		kunde.setVorname(this.textFieldBenutzernvoraname.getValue().toString());		 // soll von ein inputTextFeld kommen
		kunde.setName(this.textFieldBenutzernnachname.getValue().toString());	 // ???????? zu Überrprufen, ich glaube ist nicht so gemacht in syAbo sondern mit Proprieties ??

		// Parse the Guthaben value from the TextField to a double
		try
		{
			String guthabenStr = textFieldGuthaben.getValue().toString();
			double guthaben = Double.parseDouble(guthabenStr);
			kunde.setGuthaben(guthaben);
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}

		// Implement any validation logic here
		// SQL mit Kundendaten abfragen und ID abrufen
		// If validation passes, add the Kunde to the list of registered customers when we have the we can have an HashMap!
		// um diese Funktionalität weitere zu Erstellen
		Kunde.addRegisteredCustomers(kunde);

		// Redirect to a success page or perform other actions as needed
		// refresh page and display kundendaten registration with kundennummer and confirmation. after that kunde can go to Ausleihen page for instance....
		this.testMessage = "registration_success";
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
