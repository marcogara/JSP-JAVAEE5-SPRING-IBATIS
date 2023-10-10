package com.garagna.uebungsprojekt.web;

import com.garagna.uebungsprojekt.transaction.TransactionBuecherliste;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.Listbox;

public class Buecherliste extends AbstractPageBean
{
	private TransactionBuecherliste transactionBuecherliste;

	public void setTransactionBuch(TransactionBuecherliste tb)
	{
		this.transactionBuecherliste = tb;
	}

	private Listbox listboxBuecher = new Listbox();

	public Listbox getListboxBuecher()
	{
		return listboxBuecher;
	}

	public void setListboxBuecher(Listbox l)
	{
		this.listboxBuecher = l;
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
	/**
	 * step to add a new functionality in the app to do all the other operation (to read from the database) here we need the booklist
	 *
	 * add the ui element i need in this case listBox
	 *
	 * relative page class i add the varable with getter adn setter and data binding to the gui so : <ui:listbox binding="#{Buecherliste.listboxBuecher}............/>
	 *
	 *
	 * Transaction class create transaction........ class in transaction package TransactionBuecherliste zb. here
	 *
	 * add in this class the reference to the transaction class
	 *
	 * private TransactionBuecherliste transactionBuecherliste;
	 *
	 * public void setTransactionBuch(TransactionBuecherliste tb) { this.transactionBuecherliste = tb; }
	 *
	 *
	 * transaction.xml needs to have the correct bean (Trasnsaction class) like so for this case:
	 *
	 * <bean id="transactionBuecherliste" class="com.garagna.uebungsprojekt.transaction.TransactionBuecherliste">
	 * <property name="buchDAO" ref="buchDAO"/>
	 * </bean>
	 *
	 *
	 * DAO interface in dao package declaring inside the operation i want to allow my DAO object
	 *
	 * DAOImpl class this class has to extends SqlMapClientDaoSupport implements BuchDAO in this case
	 *
	 * add bean in ibatisdao.xml
	 *
	 * faces-config file has to be present
	 *
	 * sqlmap-config.xml need to contain the 2 element :
	 *
	 * needs to have the entity as exemple below show
	 *
	 * <typeAlias alias="Buch" type="com.garagna.uebungsprojekt.types.Buch"/>
	 * <typeAlias alias="Kunde" type="com.garagna.uebungsprojekt.types.Kunde"/>
	 *
	 * <sqlMap resource="com/garagna/uebungsprojekt/sqlmap/buch.xml"/>
	 * <sqlMap resource="com/garagna/uebungsprojekt/sqlmap/kunde.xml"/>
	 *
	 *
	 */
}
