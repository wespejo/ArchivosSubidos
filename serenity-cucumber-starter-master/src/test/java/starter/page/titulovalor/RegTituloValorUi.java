package starter.page.titulovalor;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class RegTituloValorUi extends PageObject {
    //TAB: Datos Generales
    public static Target TAB_DATOS_GENERALES = Target.the("TAB DATOS GENERALES")
            .located(By.id("__tab_ctl00_cphPrincipal_tabGarantias_tabDatosGarantias"));

    //Datos de la Garantía
    public static Target TXT_CU = Target.the("TextBox de CU")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarCliente1_txtCUCliente"));

    public static Target Pop_Modal =Target.the("Popup Cargando CU titular")
            .located(By.id("ctl00_Image1"));

    public static Target TXT_NOMBRERAZONSOC = Target.the("Nombre / Razón Social")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarCliente1_txtNombreRazon"));

    public static Target TXT_TIENDA  = Target.the(  "TextBox de tienda")
            .located(By.xpath("//*[@id=\"ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarTienda1_txtCodOficina\"]"));

    public static Target CBO_CODDOCU = Target.the("Códifo de documento")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_ddlCodigoDocumento"));

    public static Target CBO_TDOCU = Target.the( "Listado de Tipos de Documento")
            .located(By.xpath("//*[@id=\"ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_ddlTipoDocumento\"]"));

    public  static Target CBO_SITUACION = Target.the("Situación")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_ddlSituacion"));

    public static Target TXT_NUDIASAPRIORI = Target.the( "TextBox Numero de días Apriori")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtDiasConstitucion"));

    public static Target TXT_NUMVALORADO = Target.the("Número de Valorado")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtNROVALORADO"));


    //Datos de la Cuenta
    public  static Target CBO_MONEDA_CTA = Target.the("Moneda de la cuenta")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarCuenta1_ddlMonedaCta"));

    public static Target TXT_NUMOFICINACTA = Target.the("Numero de oficina / tienda")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarCuenta1_txtNroOficinaCta"));

    public static Target TXT_NUMEROCTA = Target.the("Numero de cuenta")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarCuenta1_txtNumeroCta"));

    public static Target LBL_MONTO = Target.the("Monto de Cuenta")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarCuenta1_lblSaldoContable"));

    public static Target LBL_OFICINA = Target.the("Oficina de Cuenta")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarCuenta1_lblOfCta"));

    public static Target LBL_TIPOPRODUCTO = Target.the("Tipo de Producto")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarCuenta1_lblTipoProducto"));

    public static Target BTN_NVACTA = Target.the("Ingresar Nueva cuenta")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarCuenta1_btnReiniciarCuenta"));





    // TAB: Deuda Garantía
    public static Target TABDEUDA = Target.the("TAB Deuda Garantia")
            .located(By.id("__tab_ctl00_cphPrincipal_tabGarantias_tabDeuda"));

    public static Target LBLTIPOCOBERTURA = Target.the("Listado Tipo de Cobertura")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDeuda_UcDeudaGarantia1_cmbTipoCobertura"));


    public static Target TXT_CUDEUDOR = Target.the("CU de Deudor")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDeuda_UcDeudaGarantia1_UcBuscarClienteDeuda1_txtCUClienteDeudor"));

    public static Target RBT_TLISTADOLINEA = Target.the("Radiobutton Tipo de Listado Linea")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDeuda_UcDeudaGarantia1_rblTipoListado_0"));

    public static  Target RBT_TLISTADOOPE =Target.the("Radiobutton Tipo de Listado Operación")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDeuda_UcDeudaGarantia1_rblTipoListado_1"));

    public static Target TXT_NROOPERACION = Target.the("Text box Número de operación")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDeuda_UcDeudaGarantia1_txtNroOperacion"));

    public static  Target LBL_OPE = Target.the("Label N° Operacion")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDeuda_UcDeudaGarantia1_lblTitLineaOp"));

    public static Target BTN_BUSCAROPE = Target.the("Botón Buscar Operación")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDeuda_UcDeudaGarantia1_btnBuscarOperacion"));



    //TAB: Descripción
    public static Target TAB_DESCRIPCION = Target.the("TAB descripción")
            .located(By.xpath("//*[@id=\"__tab_ctl00_cphPrincipal_tabGarantias_tabDescripcion\"]"));
    public  static  Target TXT_DESCRIPCION = Target.the("TextBox de Descripción")
            .located(By.xpath("//*[@id=\"ctl00_cphPrincipal_tabGarantias_tabDescripcion_txtDescripcion\"]"));
    public static Target TXT_COMENTARIO = Target.the("TextBox de Comentario")
            .located(By.xpath("//*[@id=\"ctl00_cphPrincipal_tabGarantias_tabDescripcion_txtComentario\"]"));



    // Registrar
    public static Target BTN_REGISTRAR= Target.the("Botón de Registro")
            .located(By.id("ctl00_cphPrincipal_btnRegistrar"));

    public static Target TXT_NROGARANTIA = Target.the( "nro garantia")
            .located(By.id("ctl00_cphPrincipal_lblMensaje"));

    public static Target BTN_VOLVER = Target.the("Botón Volver")
            .located(By.id("ctl00_cphPrincipal_btnVolver"));



}
