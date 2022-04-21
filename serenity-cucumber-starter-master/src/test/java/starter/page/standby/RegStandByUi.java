package starter.page.standby;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class RegStandByUi extends PageObject {
    //TAB: Datos Generales
    public static Target TXT_CU = Target.the("TextBox de CU")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarCliente1_txtCUCliente"));

    public static Target Pop_Modal =Target.the("Popup Cargando")
            .located(By.id("ctl00_Image1"));

    public static Target TXT_NOMBRERAZONSOC = Target.the("Nombre o Razón Social")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarCliente1_txtNombreRazon"));

    public static Target TXT_TIENDA  = Target.the(  "TextBox de tienda")
            .located(By.xpath("//*[@id=\"ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarTienda1_txtCodOficina\"]"));

    public static Target CBO_TDOCU = Target.the( "Listado de Tipos de Documento")
            .located(By.xpath("//*[@id=\"ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_ddlTipoDocumento\"]"));

    public static Target CBO_RANGO = Target.the("Rango")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_ddlRango"));

    public static Target CBO_MONEDA = Target.the("Moneda de Garantía")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_ddlMoneda"));

    public static Target TXT_FECHA = Target.the("TextBox Fecha Vencimiento")
            .located(By.xpath("//*[@id=\"ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtFechaVencimiento\"]"));

    public static Target CBO_SITUACION = Target.the("Situacion")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_ddlSituacion"));

    public static Target TXT_NDIAS = Target.the("TextBox Número de Días")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtDias"));


    //Datos Específicos
    public static Target CHK_MODIBK = Target.the("Modelo IBK")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_chkModIBK"));

    public static Target TXT_PORCENTAJE = Target.the("Porcentaje")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtPorcentaje"));

    public static Target CBO_BANCO = Target.the("Banco")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_cboBancos"));

    public static Target CBO_LINEABANCO = Target.the("Líneas Asoc. Al Banco/Convenio")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_lbLineas"));

    public static Target TXT_LINEABANCO = Target.the("Número de Línea del Banco")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtNumLinea"));

    public static Target CHK_VBLEGAL = Target.the("VB Legal")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_chkVBLegal"));

    public static Target TXT_NUDOCU = Target.the( "TextBox Numero Documento")
            .located(By.xpath("//*[@id=\"ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtNumDoc\"]"));


    public static Target TXT_IMPORTE = Target.the("Importe")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtimporte"));

    public static Target BTN_REGISTRAR= Target.the("Botón de Registro")
            .located(By.id("ctl00_cphPrincipal_btnRegistrar"));
            //.located(By.xpath("//*[@id=\"ctl00_cphPrincipal_btnRegistrar\"]"));

    public static Target POP_REGISTRO = Target.the("Pop up registro_CartaFianza")
            .located(By.name("ctl00$cphPrincipal$btnRegistrar"));





    // TAB: Deuda Garantía
    public static Target TABDEUDA = Target.the("TAB Deuda Garantia")
            .located(By.xpath("//*[@id=\"__tab_ctl00_cphPrincipal_tabGarantias_tabDeuda\"]"));

    public static Target CBO_TIPOCOBERTURA = Target.the("Listado Tipo de Cobertura")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDeuda_UcDeudaGarantia1_cmbTipoCobertura"));
            //.located(By.xpath("//*[@id=\"ctl00_cphPrincipal_tabGarantias_tabDeuda_UcDeudaGarantia1_cmbTipoCobertura\"]"));

    public static Target TXT_CUDEUDOR = Target.the("CU de Deudor")
            .located(By.xpath("//*[@id=\"ctl00_cphPrincipal_tabGarantias_tabDeuda_UcDeudaGarantia1_UcBuscarClienteDeuda1_txtCUClienteDeudor\"]"));

    public static Target CHK_PENDIENTE = Target.the("Check Datos de Líneas u Operaciones PENDIENTES")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDeuda_UcDeudaGarantia1_chkPendiente"));

    public static Target CBO_TIPO_OPERACION = Target.the("Tipo de Operación")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDeuda_UcDeudaGarantia1_cmbTipoOperacion"));

    public static Target RBT_TLISTADOLINEA = Target.the("Radiobutton Tipo de Listado Operación")
            .located(By.xpath("//*[@id=\"ctl00_cphPrincipal_tabGarantias_tabDeuda_UcDeudaGarantia1_rblTipoListado_0\"]"));

    public static  Target RBT_TLISTADOOPE =Target.the("Radiobutton Tipo de Listado Operación")
            .located(By.xpath("//*[@id=\"ctl00_cphPrincipal_tabGarantias_tabDeuda_UcDeudaGarantia1_rblTipoListado_1\"]"));

    public static Target TXT_NROOPERACION = Target.the("Text box Número de operación")
            .located(By.xpath("//*[@id=\"ctl00_cphPrincipal_tabGarantias_tabDeuda_UcDeudaGarantia1_txtNroOperacion\"]"));

    public static  Target CBO_OPE = Target.the("Label N° Operacion")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDeuda_UcDeudaGarantia1_lblTitLineaOp"));

    public static Target BTN_BUSCAROPE = Target.the("Botón Buscar Operación")
            .located(By.xpath("//*[@id=\"ctl00_cphPrincipal_tabGarantias_tabDeuda_UcDeudaGarantia1_btnBuscarOperacion\"]"));

    public static Target GRI_LISTAOPE = Target.the("Lista de Créditos Líneas y Operaciones")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDeuda_UcDeudaGarantia1_gvListaClientesReg"));

    public static  Target Pop_Modal2 = Target.the("Popup carga de operación")
            .located(By.xpath("//*[@id=\"ctl00_Label1\"]"));

    public static  Target BTN_EXAMINAR = Target.the("examinar")
            .located(By.xpath("//*[@id=\"ctl00_cphPrincipal_tabGarantias_tabDescripcion_UcBuscarArchivosGar1_btnExaminar\"]"));


    //TAB: Descripción
    public static Target TAB_DESCRIPCION = Target.the("TAB descripción")
            .located(By.xpath("//*[@id=\"__tab_ctl00_cphPrincipal_tabGarantias_tabDescripcion\"]"));
    public  static  Target TXT_DESCRIPCION = Target.the("TextBox de Descripción")
            .located(By.xpath("//*[@id=\"ctl00_cphPrincipal_tabGarantias_tabDescripcion_txtDescripcion\"]"));
    public static Target TXT_COMENTARIO = Target.the("TextBox de Comentario")
            .located(By.xpath("//*[@id=\"ctl00_cphPrincipal_tabGarantias_tabDescripcion_txtComentario\"]"));


    // Registrar
    public static Target TXT_NROGARANTIA = Target.the( "nro garantia")
            .located(By.id("ctl00_cphPrincipal_lblMensaje"));

    public static Target TXT_CARGANDO = Target.the("Mensaje Cargando")
            .located(By.id("updateProgressDiv"));

    public static Target BTN_VOLVER = Target.the("Botón Volver")
            .located(By.id("ctl00_cphPrincipal_btnVolver"));
}
