package starter.page.fianzasolidaria;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class RegFianzaSolidariaUi extends PageObject {
    //TAB: Datos Generales
    public static Target TAB_DATOS_GENERALES = Target.the("TAB DATOS GENERALES")
            .located(By.id("__tab_ctl00_cphPrincipal_tabGarantias_tabDatosGarantias"));

    //Datos de la Garantía
    public static Target TXT_CU = Target.the("TextBox de CU")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarCliente1_txtCUCliente"));
            //.located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarCliente1_txtCUCliente"));

    public static Target Pop_Modal =Target.the("Popup Cargando CU titular")
            .located(By.id("ctl00_Image1"));

    public static Target TXT_TIENDA  = Target.the(  "TextBox de tienda")
            .located(By.xpath("//*[@id=\"ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarTienda1_txtCodOficina\"]"));

    public static Target TXT_NOMBRERAZONSOC = Target.the("Razón Social de CU")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarCliente1_txtNombreRazon"));

    public static Target CBO_TDOCU = Target.the( "Listado de Tipos de Documento")
            .located(By.xpath("//*[@id=\"ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_ddlTipoDocumento\"]"));

    public static Target CBO_MONEDA = Target.the("Moneda de Garantía")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_ddlMoneda"));

    public  static Target CBO_SITUACION = Target.the("Situación")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_ddlSituacion"));

    public static  Target TXT_NRODIAS = Target.the("Número de Días")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtDiasConstitucion"));

    public static Target TXT_MONTO = Target.the("Monto")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtImporte"));

    public static Target TXT_KARDEX = Target.the("Kárdex")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtKardex"));

    public static Target TXT_NOTARIA = Target.the("Notaría")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtNotaria"));

    public static  Target TXT_FICHAPARTIDAREG = Target.the("Ficha / Partida Registral")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtFichaPartida"));

    public static Target CBO_TIPOCONTRATO = Target.the("Tipo Contrato")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_ddlTipoContrato"));

    public static Target TXT_ASIENTO =Target.the("Asiento")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtAsiento"));

    public static Target TXT_FECHADECPAT = Target.the("TextBox Fecha Declaración Patrimonial")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtFecDecPatrimonial"));

    public static Target CAL_FECDECPATRIMONIAL = Target.the("Calendario Fecha Declaración Patrimonial")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_imbFecDecPatrimonial"));

    public static Target BTN_NEXT_FECDECPAT = Target.the("Botón Next de Calendario Fecha Declaración Patrimonial")
            .located(By.xpath("/html[1]/body[1]/form[1]/div[3]/table[1]/tbody[1]/tr[2]/td[3]/table[2]/tbody[1]/tr[3]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[1]/div[1]/div[2]/fieldset[1]/table[2]/tbody[1]/tr[3]/td[4]/div[1]/div[1]/div[1]/div[2]/div[1]"));
        //.located(By.xpath("//div[@id='ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_ceFecDecPatrimonial_nextArrow']"));
        //.located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_ceFecDecPatrimonial_nextArrow"));

    public static Target BTN_PREV_FECDECPAT = Target.the("Botón Prev de Calendario Fecha Declaración Patrimonial")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_ceFecDecPatrimonial_prevArrow"));

    public static Target BTN_DAY_CALENDAR = Target.the("Día del calendario")
            .located(By.xpath("//div[@class='ajax__calendar_day']"));

    public static Target TXT_DECPATRIMONIAL = Target.the("Declaración Patrimonial")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtDeclaricionPatrimonial"));

    public static Target CBO_TIPOPLAZA = Target.the("Tipo de Plaza")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_DddlTipoPlaza"));

    public static Target TXT_COVENANTS = Target.the("Covenants")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtCovenants"));

    public static Target TXT_NUMCREDITO = Target.the("Número de Crédito")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_NUMEROCREDITO"));

    //Fiadores
    public static Target TXT_CUFIADOR = Target.the("Código Unico Fiador")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarFiadores1_txtCUFiadores"));

    public static Target TXT_NOMBRERAZSOCFIADOR = Target.the("Nombre y/o Razón Social Fiador")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarFiadores1_txtRazonSocialFiador"));

    public static Target BTN_BUSCAR = Target.the("Botón Buscar")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarFiadores1_btnBuscarClienteFiador"));

    public static Target BTN_AGREGAR = Target.the("Botón Agregar Fiador")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarFiadores1_btnAgregarFiador"));



    public static Target BTN_REGISTRAR= Target.the("Botón de Registro")
            .located(By.id("ctl00_cphPrincipal_btnRegistrar"));

    public static Target BTN_REGRESAR=Target.the("Botón Regresar")
            .located(By.id("ctl00_cphPrincipal_btnCancelar"));

    public static Target POP_REGISTRO = Target.the("Pop up registro_Fianza Solidaria")
            .located(By.name("ctl00$cphPrincipal$btnRegistrar"));



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

    public static Target GRI_LISTAOPE = Target.the("Lista de Créditos Líneas y Operaciones")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDeuda_UcDeudaGarantia1_GSeleccion"));
        //.located(By.id("ctl00_cphPrincipal_tabGarantias_tabDeuda_UcDeudaGarantia1_gvListaClientesReg"));


    public static  Target Pop_Modal2 = Target.the("Popup carga de operación")
            .located(By.xpath("//*[@id=\"ctl00_Label1\"]"));

    public static  Target BTN_EXAMINAR = Target.the("examinar")
            .located(By.xpath("//*[@id=\"ctl00_cphPrincipal_tabGarantias_tabDescripcion_UcBuscarArchivosGar1_btnExaminar\"]"));

    public static Target BTN_COBGENERICA = Target.the("Botón aceptar cobertura generica")
            .located(By.id("pbtnObtnerTipoCober"));


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
