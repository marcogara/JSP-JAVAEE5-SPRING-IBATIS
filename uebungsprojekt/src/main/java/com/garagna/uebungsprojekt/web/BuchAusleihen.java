package com.garagna.uebungsprojekt.web;

import com.sun.rave.web.ui.appbase.AbstractPageBean;

public class BuchAusleihen extends AbstractPageBean
{
	/**
	 * private Form form = new Form();
	 *
	 * public Form getForm() { return this.form; }
	 *
	 * public void setForm(Form f) { this.form = f; }
	 *
	 * private TextField textFieldBenutzernummer = new TextField();
	 *
	 * public void setTextFieldBenutzernummer(TextField textFieldBenutzernummer) { this.textFieldBenutzernummer = textFieldBenutzernummer; }
	 *
	 * public TextField getTextFieldBenutzernummer() { return textFieldBenutzernummer; }
	 *
	 * private TextField textFieldBenutzernvorname = new TextField();
	 *
	 * public TextField getTextFieldBenutzernvorname() { return textFieldBenutzernvorname; }
	 *
	 * public void setTextFieldBenutzernvorname(TextField tf) { this.textFieldBenutzernvorname = tf; }
	 *
	 * private TextField textFieldBenutzernnachname = new TextField();
	 *
	 * public TextField getTextFieldBenutzernnachname() { return textFieldBenutzernnachname; }
	 *
	 * public void setTextFieldBenutzernnachname(TextField tf) { this.textFieldBenutzernnachname = tf; }
	 *
	 * private TextField textFieldGuthaben = new TextField();
	 *
	 * public TextField getTextFieldGuthaben() { return textFieldGuthaben; }
	 *
	 * public void setTextFieldGuthaben(TextField tf) { this.textFieldGuthaben = tf; }
	 *
	 * *
	 */

	private String errorMessage = " ";           // Für Meldungen und oder testing

	public String getErrorMessage()
	{
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;  //  Meldungen für User
	}

	@Override
	public void prerender()
	{
		// Für RadioButton Eventuell ->  if (! isPostBack()){...}

		// kundennummer fragen und autofüllen ? next available id.
		// this.textFieldBenutzernummer.setText(this.transactionRegistrieren.loadNextAvailableId());
	}

	public String buttonHome_action()
	{
		// Registrieren reg = (Registrieren) getBean("Registrieren");
		return "go_welcome";
	}

}
