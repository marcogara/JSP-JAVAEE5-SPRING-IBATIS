package com.garagna.uebungsprojekt.web;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.garagna.uebungsprojekt.transaction.TransactionBuecherliste;
import com.garagna.uebungsprojekt.business.TextUtils;
import com.garagna.uebungsprojekt.types.Buch;
import com.garagna.uebungsprojekt.types.Verlag;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.Listbox;
import com.sun.rave.web.ui.model.Option;

public class Buecherliste extends AbstractPageBean
{
	//The string you've defined, "\u00A0", represents a non-breaking space character. A non-breaking space is a type of space character that prevents line breaks or word wraps in text. It's often used to ensure that two words or characters are not separated at the end of a line, especially in situations where you don't want them to be split across lines. It has a visual representation similar to a regular space, but it has different behavior in text layout.
	private final String SP = "\u00A0";

	private TransactionBuecherliste transactionBuecherliste;

	public void setTransactionBuecherliste(TransactionBuecherliste transactionBuecherliste)
	{
		this.transactionBuecherliste = transactionBuecherliste;
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

	private Listbox listboxVerlag;

	public Listbox getListboxVerlag()
	{
		return listboxVerlag;
	}

	public void setListboxVerlag(Listbox listboxVerlag)
	{
		this.listboxVerlag = listboxVerlag;
	}

	private Listbox listboxID = new Listbox();

	public Listbox getListboxID()
	{
		return listboxID;
	}

	public void setListboxID(Listbox l)
	{
		this.listboxID = l;
	}

	@Override
	public void prerender()
	{
		// prerender sorgt dafür, dass die Daten am Anfang der Seite angezeigt werden.

		buchlisteErzeugen();

		// Für RadioButton Eventuell ->  if (! isPostBack()){...}
	}

	// void wenn ich bleibe auf der Seite und String wenn ich navigieren auf neuer Seite -->  navigation.xml von syAbo anpassen
	public String buttonHome_action()
	{
		// Registrieren reg = (Registrieren) getBean("Registrieren");
		return "go_welcome";
	}

	public void buttonVerlag()
	{
		// Registrieren reg = (Registrieren) getBean("Registrieren");
		verlag_action();
	}

	// void wenn ich bleibe auf der Seite und String wenn ich navigieren auf neuer Seite -->  navigation.xml von syAbo anpassen
	public void buchlisteErzeugen()
	{
		Map<Integer, Buch> buchMap = this.transactionBuecherliste.buecherlisteLaden();
		List<Option> items = new LinkedList<Option>();
		String sp = this.SP;

		for (Buch buch : buchMap.values())
		{
			String id = TextUtils.rpad(String.valueOf(buch.getId()), 5, sp);
			String titel = TextUtils.rpad(buch.getTitel(), 49, sp);
			String autor = TextUtils.rpad(buch.getAutor(), 37, sp);
			String genre = TextUtils.rpad(buch.getGenre(), 17, sp);
			String year = TextUtils.rpad(buch.getErscheinungsjahr(), 11, sp);
			String velagName = TextUtils.rpad(buch.getVerlag().getName(), 59, sp);
			String isbn = TextUtils.rpad(buch.getIsbn(), 20, sp);

			String anzeige = id + sp + titel + sp + autor + sp + genre + sp + year + sp + velagName + sp + isbn;

			items.add(new Option(buch.getId(), anzeige));
		}
		this.listboxBuecher.setItems(items);
	}

	public void verlag_action()
	{
		List<Verlag> list = this.transactionBuecherliste.verlagLaden();

		List<Option> items = new LinkedList<Option>();
		String sp = this.SP;

		for (Verlag verlag : list)
		{
			String id = TextUtils.rpad(String.valueOf(verlag.getId()), 8, sp);
			String name = TextUtils.rpad(verlag.getName(), 59, sp);
			String sitz = TextUtils.rpad(verlag.getSitz(), 27, sp);
			String year = TextUtils.rpad(String.valueOf(verlag.getGruendungsjahr()), 10, sp);

			String anzeige = id + sp + name + sp + sitz + sp + year;

			items.add(new Option(verlag.getId(), anzeige));
		}
		this.listboxVerlag.setItems(items);
	}
}

/**
 * Schritt zum Hinzufügen neuer Funktionen in der App, um alle anderen Vorgänge auszuführen (zum Lesen aus der Datenbank). Hier benötigen wir die Bücherliste
 *
 * Fügen Sie das UI-Element hinzu, das Sie in diesem Fall listBox benötige
 *
 * Entsprechende Seitenklasse. Ich füge die Variable mit Getter und Setter und Datenbindung zur GUI hinzu, also:
 *
 * <ui:listbox binding="#{Buecherliste.listboxBuecher}............/>
 *
 * Transaction Klass erstellen transaction........ Klass in transaction package TransactionBuecherliste zb. Hier
 *
 * Fügen Sie in dieser Klasse den Verweis auf die Transaktionsklasse hinzu
 *
 * private TransactionBuecherliste transactionBuecherliste;
 *
 * public void setTransactionBuch(TransactionBuecherliste tb) { this.transactionBuecherliste = tb; }
 *
 * transaktion.xml muss für diesen Fall die richtige Bean (Trasnsaction-Klasse) haben, etwa so:
 *
 * <bean id="transactionBuecherliste" class="com.garagna.uebungsprojekt.transaction.TransactionBuecherliste">
 * <property name="buchDAO" ref="buchDAO"/>
 * </bean>
 *
 * DAO-Interface im Dao-Paket, die innerhalb der Vorgänge deklariert, die ich für mein DAO-Objekt zulassen möchte
 *
 * DAOImpl class Diese Klasse muss "extends SqlMapClientDaoSupport implements BuchDAO" in Diesem Fall
 *
 * bean hinzufügen in ibatisdao.xml
 *
 * Die Faces-Config-Datei muss vorhanden sein
 *
 * sqlmap-config.xml muss die 2 Elemente enthalten:
 *
 * muss die Entität haben, wie im Beispiel unten gezeigt
 *
 * <typeAlias alias="Buch" type="com.myname.uebungsprojekt.types.Buch"/>
 * <typeAlias alias="Kunde" type="com.myname.uebungsprojekt.types.Kunde"/>
 *
 * <sqlMap resource="com/myname/uebungsprojekt/sqlmap/buch.xml"/>
 * <sqlMap resource="com/myname/uebungsprojekt/sqlmap/kunde.xml"/>
 *
 *
 * Fügen Sie die SQL-Anweisung in buch.xml ein und überprüfen Sie die Implementierung in Ihrer DAOImpl-Klasse
 *
 * Implementieren Sie die Funktionalität in TransactionBuecherliste mit einer Referenz eines BuchDao-Objekts
 *
 * nach dem Erstellen der Funktion: public List<Buch> buecherlisteLaden()
 *
 * Sie können es von dieser Seite aus aufrufen, wie es in getan wurde Registrieren.java zb.
 *
 * In der Datei „managed-beans.xml“ muss die Bean, die der Operation entspricht, die Sie haben möchten, die Implementierung der Klasse ihrer Transaktionsklasse wie folgt haben:
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
 * in diesem Fall :
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
 * hinzufügen in buch.xml
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
 * Stellen Sie in diesem Fall sicher, dass in Ihrer Klasse alle Variablen mit demselben Namen wie die Ergebniskarte zugänglich sind
 *
 * siehe: buch.xml
 *
 * beispiel für liste zum ui übertragen public void buttonListe_action()
 *
 *
 *
 */
