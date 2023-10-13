<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
		<ui:page id="page1">
            <ui:html id="html1">
                <ui:head id="head1" title="Buecherliste"><ui:link id="link1" url="/resources/stylesheet.css"/></ui:head>
				<ui:body id="body1" style="background-color: grey;">
					<ui:form id="form1">
						<ui:label for="textFieldBrief" id="labelBrief" text=""/>
						<h:outputLabel for="listboxTitel" value="ID" style="font-size: 24px; padding: 4px; text-align:left;"/>
						<h:outputLabel for="listboxTitel" value="TITEL" style="font-size: 24px; padding: 4px 10px 30px; margin-right: 290px; text-align:center;"/>
						<h:outputLabel for="listboxTitel" value="AUTOR" style="font-size: 24px; padding: 10px 20px 30px; margin-right: 160px; text-align:center;"/>
						<h:outputLabel for="listboxTitel" value="GENRE" style="font-size: 24px; padding: 10px 20px 30px; margin-right: 20px; text-align:center;"/>
						<h:outputLabel for="listboxTitel" value="JAHR" style="font-size: 24px; padding: 20px 10px 10px; margin-right: 8px; text-align:center;"/>
						<h:outputLabel for="listboxTitel" value="VERLAG" style="font-size: 24px; padding: 10px; margin-right: 330px; text-align:center;"/>
						<h:outputLabel for="listboxTitel" value="ISBN" style="font-size: 24px; padding: 10px 20px 30px; margin-right: 10px; text-align:center;"/>
						<ui:panelLayout id="layoutPanelInput" panelLayout="flow" style="text-align: center; margin-bottom: 50px;">
							<h:panelGrid columnClasses="gridlabelfrei,griddata" columns="5" id="gridPanelLogin">
								<ui:listbox binding="#{Buecherliste.listboxBuecher}" converter="javax.faces.Integer" id="listboxTitel" rows="20" style="width: 1600px; font-family: monospace; font-size: 14px"  styleClass="black-listbox"/>
							</h:panelGrid>
						</ui:panelLayout>
						<ui:panelLayout id="layoutPanelButtonsAuswahl" panelLayout="flow" style="text-align: center; margin-bottom: 50px;">
							<ui:button action="#{Buecherliste.buttonHome_action}" id="buttonHome" text="Back Home" style="font-size: 18px; padding: 10px 20px 30px 30px; margin-right: 10px;  margin-bottom: 50px;"/>
							<ui:button action="#{Buecherliste.buttonVerlag}" id="buttonVerlag" text="Verlag zeigen" style="font-size: 18px; padding: 10px 20px 30px 30px; margin-right: 10px;  margin-bottom: 50px;"/>
						</ui:panelLayout>
						<h:outputLabel for="listboxTitel1" value="ID" style="font-size: 24px; padding: 40px 10px 40px ;margin-right: 10px; text-align:left;"/>
						<h:outputLabel for="listboxTitel1" value="VERLAG" style="font-size: 24px; padding: 10px; margin-right: 342px; text-align:center;"/>
						<h:outputLabel for="listboxTitel1" value="SITZ" style="font-size: 24px; padding: 4px 10px 30px; margin-right: 100px; text-align:center;"/>
						<h:outputLabel for="listboxTitel1" value="GRÜNDUNGSJAHR" style="font-size: 24px; padding: 20px 10px 10px; margin-right: 8px; text-align:center;"/>
						<ui:panelLayout id="layoutPanelInput1" panelLayout="flow" style="text-align:">
							<h:panelGrid columnClasses="gridlabelfrei,griddata" columns="5" id="gridPanelLogin1">
								<ui:listbox binding ="#{Buecherliste.listboxVerlag}" converter="javax.faces.Integer" id="listboxTitel1" rows="20" style="width: 1400px; font-family: monospace; font-size: 14px" styleClass="black-listbox"/>
							</h:panelGrid>
						</ui:panelLayout>
					</ui:form>
				</ui:body>
			</ui:html>
		</ui:page>
	</f:view>
</jsp:root>