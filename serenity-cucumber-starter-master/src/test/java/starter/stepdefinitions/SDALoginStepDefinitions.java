package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import motoresdebusqueda.gac.page.SDALoginPageUi;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SDALoginStepDefinitions {

    @Before
    public void establecerEscenario(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que {string} ingresa a la pagina  de SDA")
    public void que_actor_ingresa_a_la_pagina_de_sda(String actor) {
        // Write code here that turns the phrase above into concrete actions
        //TheActorCalled(actor).attemptsTo(OpenBrowserOn().the(SDALoginPageUi.class));
        theActorCalled(actor).attemptsTo(Open.browserOn().the(SDALoginPageUi.class));
    }


    @Cuando("ingresa las credenciales correctos")
    public void ingresa_las_credenciales_correctos() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().attemptsTo(
                Enter.theValue("xt7655").into(SDALoginPageUi.TXT_USER),
                Enter.theValue("Febrero2022$$").into(SDALoginPageUi.TXT_PASS),
                //SelectFromOptions.byIndex(2).from(SDALoginPageUi.CMB_AMBIENTE)
                SelectFromOptions.byVisibleText("Pruebas").from(SDALoginPageUi.CMB_AMBIENTE)
        );
        SDALoginPageUi.BTN_ACEPTAR.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.RETURN);
        Thread.sleep(3000);
    }


/*   @Entonces("Se Genera N° de Garantia")
    public void Se_Genera_NRO_Garantia() {
        System.out.println("*************************Login + Garantia");


    }*/



    }
