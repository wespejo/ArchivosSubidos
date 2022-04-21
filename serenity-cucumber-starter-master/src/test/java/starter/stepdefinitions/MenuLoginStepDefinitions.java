package starter.stepdefinitions;

import io.cucumber.java.es.Y;
import motoresdebusqueda.gac.page.MenuLoginUi;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class MenuLoginStepDefinitions {

    @Y("se ingresa al aplicativo Gac")
    public void se_ingresa_al_aplicativo_gac() {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().attemptsTo(Click.on(MenuLoginUi.LNK_GARANTIAS));
    }

}
