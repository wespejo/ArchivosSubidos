package starter.page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;


@DefaultUrl("http://intranetib/sda")
public class SDALoginPageUi extends PageObject {

     public static Target TXT_USER = Target.the( "TextBox de usuario")
    .located(By.id("inpuser"));
    public static Target TXT_PASS = Target.the("TextBox de contraseña")
    .located(By.id("inp_clave"));
    public static Target CMB_AMBIENTE = Target.the("Combo box de ambiente")
            .located(By.name("selambiente"));
    public static Target BTN_ACEPTAR = Target.the("Botón de Aceptar_CartaFianza")
            .located(By.id("Aceptar"));
    public static Target LBL_ERROR_LOGIN = Target.the("Mensaje login fallido")
            .located(By.xpath("//p[text()='Usuario o Contraseña de Red incorrectos, intentar nuevamente']"));
}
