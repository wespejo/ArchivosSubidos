package starter.page;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class GACMenuPrincipalUi extends PageObject {
    public static Target LNK_REGISTRAR_GARANTIAS = Target.the("Enlace para registrar garantias")
            .located(By.linkText("Registrar Garantias"));
    public static By ifrModal = By.id("ifrModal");
    public static Target SEL_TIP_GARANTIA = Target.the("Select de Tipo de Garantia")
            .located(By.id("ddlTipoGarantia"));
    public static Target BTN_IR = Target.the("Boton Ir")
            .located(By.id("btnIr"));


}
