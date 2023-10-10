package com.garagna.uebungsprojekt.web;

import java.util.List;

import com.garagna.uebungsprojekt.transaction.TransactionBuecherliste;
import com.garagna.uebungsprojekt.types.Buch;
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

	public void buttonListe_action()
	{
		List<Buch> list = this.transactionBuecherliste.buecherlisteLaden();
		// List<Option> items = new LinkedList<Option>(); from beispiel anrede class nothing to do here only as sample

		// for (Anrede anrede : list)
		// {
		// String anzeige = anrede.getSprache().getIso() + sp + anrede.getBrief();
		// items.add(new Option(anrede.getId(), anzeige));
		// }
		this.listboxBuecher.setItems(list);
	}

}

// void wenn ich bleibe auf der Seite und String wenn ich navigieren auf neuer Seite -->  navigation.xml von syAbo anpassen
/**
 * step to add new functionality in the app to do all the other operations (to read from the database) here we need the booklist
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
 * DAO interface in dao package declaring inside the operations i want to allow my DAO object
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
 * insert the sql statement in buch.xml and check the implementation in you DAOImpl class
 *
 * implement the functionality in TransactionBuecherliste with a reference of a BuchDao object
 *
 * after creating the function: public List<Buch> buecherlisteLaden()
 *
 * you can call it from this page like it was done in Registrieren.java zb.
 *
 *
 * in managed-beans.xml the bean corrisponding the operation you want to have need to have the implementation fro the class its transaction class like so :
 *
 * <managed-bean>
 * <managed-bean-name>Registrieren</managed-bean-name>
 * <managed-bean-class>com.garagna.uebungsprojekt.web.Registrieren</managed-bean-class>
 * <managed-bean-scope>request</managed-bean-scope>
 * <managed-property>
 * <property-name>transactionRegistrieren</property-name>
 * <value>#{transactionRegistrieren}</value>
 * </managed-property>
 * </managed-bean>
 *
 *
 * in this case :
 *
 *
 * <managed-bean>
 * <managed-bean-name>Buecherliste</managed-bean-name>
 * <managed-bean-class>com.garagna.uebungsprojekt.web.Buecherliste</managed-bean-class>
 * <managed-bean-scope>request</managed-bean-scope>
 * <managed-property>
 * <property-name>transactionBuecherliste</property-name>
 * <value>#{transactionBuecherliste}</value>
 * </managed-property>
 * </managed-bean>
 *
 * add in buch.xml
 *
 * <resultMap id="result" class="Buch" >
 * <result column="id" property="id" jdbcType="INTEGER" />
 * <result column="titel" property="bezeichnung" jdbcType="VARCHAR" />
 * <result column="autor" property="betrefftextid" jdbcType="VARCHAR" />
 * <result column="genre" property="haupttextid" jdbcType="VARCHAR" />
 * <result column="erscheinungsjahr" property="art" jdbcType="INTEGER" />
 * <result column="verlag_id" property="id" jdbcType="INTEGER" />
 * <result column="isbn" property="reserviert" jdbcType="VARCHAR" />
 * </resultMap>
 *
 *
 * make sure your class in this case buch has all variable accessible with the same name as the result map
 */
