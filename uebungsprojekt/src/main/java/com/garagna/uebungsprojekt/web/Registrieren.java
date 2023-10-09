package com.garagna.uebungsprojekt.web;

import com.garagna.uebungsprojekt.types.Kunde;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.TextField;

public class Registrieren extends AbstractPageBean
{
	private TextField textFieldBenutzernvoraname = new TextField();

	public TextField getTextFieldBenutzernvoraname()
	{
		return textFieldBenutzernvoraname;
	}

	public void setTextFieldBenutzernvoraname(TextField tf)
	{
		this.textFieldBenutzernvoraname = tf;
	}

	private TextField textFieldBenutzernnachname = new TextField();

	public TextField getTextFieldBenutzernnachname()
	{
		return textFieldBenutzernnachname;
	}

	public void setTextFieldBenutzernnachname(TextField tf)
	{
		this.textFieldBenutzernnachname = tf;
	}

	private TextField textFieldGuthaben = new TextField();

	public TextField getTextFieldGuthaben()
	{
		return textFieldGuthaben;
	}

	public void setTextFieldGuthaben(TextField tf)
	{
		this.textFieldGuthaben = tf;
	}

	private String errorMessage = "test";           // Für Meldungen und oder testing

	public String getErrorMessage()
	{
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;  // logger für Meldungen
	}

	@Override
	public void prerender()
	{
		// Für RadioButton Eventuell ->  if (! isPostBack()){...}
	}

	public void buttonBestaetigung_action() // ist String als Rückgabewert korrekt?
	{
		Kunde kunde = new Kunde();
		//	 kunde.setNummer(nummer); es soll den id nummer von den datenbank abgefragt werden

		kunde.setVorname(this.textFieldBenutzernvoraname.getValue().toString());		 // soll von ein inputTextFeld kommen
		kunde.setName(this.textFieldBenutzernnachname.getValue().toString());	 // ???????? zu Überrprufen, ich glaube ist nicht so gemacht in syAbo sondern mit Proprieties ??

		// Parse the Guthaben value from the TextField to an Integer
		try
		{
			String guthabenStr = textFieldGuthaben.getValue().toString();
			int guthaben = Integer.parseInt(guthabenStr);                 // mit converter in JSP arbeiten javax faces
			kunde.setGuthaben(guthaben);
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}

		// transaction Aufruf
		// Implement any validation logic here
		// SQL mit Kundendaten abfragen und ID abrufen
		// Redirect to a success page or perform other actions as needed
		// refresh page and display kundendaten registration with kundennummer and confirmation. after that kunde can go to Ausleihen page for instance....
		this.errorMessage = "registration_success";   // ??

	}

	public String buttonHome_action()
	{
		// Registrieren reg = (Registrieren) getBean("Registrieren");
		return "go_welcome";
	}

	// void wenn ich bleibe auf der Seite und String wenn ich navigieren auf neuer Seite -->  navigation.xml von syAbo anpassen
}
