package starter.stepdefinitions.titulovalor;

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
    @Y("se selecciona tipo de garantía Titulo Valor")
    public void se_selecciona_tipo_de_garantía_Titulo_Valor() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(GACMenuPrincipalUi.LNK_REGISTRAR_GARANTIAS, isVisible())
                        .forNoMoreThan(15).seconds(),
                Click.on(GACMenuPrincipalUi.LNK_REGISTRAR_GARANTIAS)
        );
        theActorInTheSpotlight().attemptsTo(
                Switch.toFrame((WebElement) Serenity.getWebdriverManager().getCurrentDriver()
                        .findElement(GACMenuPrincipalUi.ifrModal)),
                SelectFromOptions.byIndex(16).from(GACMenuPrincipalUi.SEL_TIP_GARANTIA),
                WaitUntil.the(GACMenuPrincipalUi.BTN_IR, isVisible()).forNoMoreThan(30).seconds()
        );
        GACMenuPrincipalUi.BTN_IR.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.SPACE);
        Thread.sleep(5000);
    }
}
