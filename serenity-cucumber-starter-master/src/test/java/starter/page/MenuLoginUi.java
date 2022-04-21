package starter.page;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class MenuLoginUi extends PageObject {
    public static Target LNK_GARANTIAS = Target.the("Enlace a Garantias y Custodia")
            .located(By.partialLinkText("as y custodia"));
}
