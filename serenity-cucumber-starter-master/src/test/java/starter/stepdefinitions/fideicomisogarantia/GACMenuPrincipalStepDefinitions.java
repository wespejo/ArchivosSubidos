package starter.stepdefinitions.fideicomisogarantia;

import io.cucumber.java.es.Y;
import motoresdebusqueda.gac.page.GACMenuPrincipalUi;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GACMenuPrincipalStepDefinitions {
    @Y("se selecciona tipo de garantía Fideicomiso en Garantia")
    public void se_selecciona_tipo_de_garantía_Fideicomiso_en_Garantia() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(GACMenuPrincipalUi.LNK_REGISTRAR_GARANTIAS, isVisible())
                        .forNoMoreThan(15).seconds(),
                Click.on(GACMenuPrincipalUi.LNK_REGISTRAR_GARANTIAS)
        );
        theActorInTheSpotlight().attemptsTo(
                Switch.toFrame((WebElement) Serenity.getWebdriverManager().getCurrentDriver()
                        .findElement(GACMenuPrincipalUi.ifrModal)),
                //byIndex(10) Selecciona la opción Fideicomiso en Garantía 2.0
                SelectFromOptions.byIndex(11).from(GACMenuPrincipalUi.SEL_TIP_GARANTIA),
                WaitUntil.the(GACMenuPrincipalUi.BTN_IR, isVisible()).forNoMoreThan(30).seconds()
        );
        GACMenuPrincipalUi.BTN_IR.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.SPACE);
        Thread.sleep(5000);
    }
}
