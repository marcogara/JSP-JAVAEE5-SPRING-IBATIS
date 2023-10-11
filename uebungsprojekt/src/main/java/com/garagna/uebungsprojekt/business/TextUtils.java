package com.garagna.uebungsprojekt.business;

public class TextUtils
{
	public static String rpad(String text, int laenge, String fillIn)
	{
		/**
		 * Die Funktion ergaenzt text rechts mit dem uebergebenen String fillin so oft, wie die Differenz aus der Laenge von text und der uebergebenen laenge ist, und haengt das
		 * Resultat an den quasi-inout-Parameter inout. Ziel ist, text z. B. mit Leerzeichen auf feste Spaltenbreite zu bringen. Eigentlich nur sinnvoll, wenn fillin = &nbsp;.
		 * Neuerdings geht es in Verbindung mit CSS auch mit geschuetzten Leerzeichen und mit einer Einschraenkung - bei einzeiligen Selectfeldern werden die Leerzeichen in der
		 * ausgewaehlten Zeile trotzdem komprimiert. normalen Leerzeichen.
		 */
		String text2 = text;
		if (text2 == null)
		{
			text2 = "";
		}
		if (text2.length() >= laenge)
		{
			return text2.substring(0, laenge);
		}
		StringBuffer output = new StringBuffer(text2);
		for (int i = text2.length(); i < laenge; ++i)
		{
			output.append(fillIn);
		}
		return output.toString();
	}
}
