package com.garagna.uebungsprojekt.web;

import com.sun.rave.web.ui.appbase.AbstractPageBean;

public class Welcome extends AbstractPageBean      // https://docs.oracle.com/cd/E17824_01/dsc_docs/docs/jscreator/apis/jsfcl/com/sun/jsfcl/app/AbstractPageBean.html
{
	@Override
	public void prerender()
	{
		// Für RadioButton Eventuell ->  if (! isPostBack()){...}
	}

	public String buttonRegistrieren_action()
	{

		// Registrieren reg = (Registrieren) getBean("Registrieren");
		return "go_registrieren";
	}

	public String buttonBuecherliste_action()
	{
		return "go_buecherliste";   // navigation.xml von syAbo anpassen
	}

	public String buttonAusleihen_action()
	{

		return "go_ausleihen";   // navigation.xml von syAbo anpassen
	}

	// void wenn ich bleibe auf der Seite und String wenn ich navigieren auf neuer Seite -->  navigation.xml von syAbo anpassen
	/**
	 * step to add a new page :
	 *
	 * 1) JAVA file: java file need a method to return a String like above "public String buttonAusleihen_action()"
	 *
	 * 2) JSP PAGE: the corrisponding jsp file needs a element bind with the method like in this exemple :
	 * <ui:button action="#{Welcome.buttonAusleihen_action}" id="buttonAusleihen" text="Buch ausleihen"/>
	 *
	 * 3) navigation.xml needs to have the connection registered like so
	 *
	 * <navigation-rule>
	 * <from-view-id>/Welcome.jsp</from-view-id>
	 * <navigation-case>
	 * <from-outcome>go_registrieren</from-outcome>
	 * <to-view-id>/Registrieren.jsp</to-view-id>
	 * </navigation-case>
	 * </navigation-rule>
	 *
	 * 4) the new page needs a Bean in managed-beans.xml
	 *
	 * <managed-bean>
	 * <managed-bean-name>Registrieren</managed-bean-name>
	 * <managed-bean-class>com.garagna.uebungsprojekt.web.Registrieren</managed-bean-class>
	 * <managed-bean-scope>request</managed-bean-scope>
	 * </managed-bean>
	 *
	 */
	/**
	 *
	 * for the other functionalities we need a dao packege under the root packege insede we can start model our first class in this case we started with KundeDAO.java as interface
	 *
	 * and the implementation needs to be in a class called KundeDAOImpl.java
	 *
	 *
	 *
	 */
}
