package starter.page.mobiliariabienes;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class RegMobiliariaBienesUi extends PageObject {
    //TAB: Datos Generales
    public static Target TAB_DATOS_GENERALES = Target.the("TAB DATOS GENERALES")
            .located(By.id("__tab_ctl00_cphPrincipal_tabGarantias_tabDatosGarantias"));

    //Datos de la Garantía
    public static Target TXT_CU = Target.the("TextBox de CU")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarCliente1_txtCUCliente"));
            //.located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarCliente1_txtCUCliente"));

    public static Target TXT_NOMBRERAZONSOC = Target.the("Nombre o Razón Social")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarCliente1_txtNombreRazon"));

    public static Target Pop_Modal =Target.the("Popup Cargando CU titular")
            .located(By.id("ctl00_Image1"));

    public static Target TXT_TIENDA  = Target.the(  "TextBox de tienda")
            .located(By.xpath("//*[@id=\"ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_UcBuscarTienda1_txtCodOficina\"]"));

    public static Target CBO_TDOCU = Target.the( "Listado de Tipos de Documento")
            .located(By.xpath("//*[@id=\"ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_ddlTipoDocumento\"]"));

    public static Target CBO_RANGO = Target.the("Rango")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_ddlRango"));

    public static Target TXT_NUDOCU = Target.the( "TextBox Numero Documento")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtNroPrenda"));

    public static Target CBO_MONEDA = Target.the("Moneda de Garantía")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_ddlMoneda"));

    public static  Target TXT_VALREALIZACION = Target.the("Valor de Realización")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtValorRealizacion"));

    public static Target TXT_VALCOMERCIAL = Target.the("Valor comercial")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtValorComercial"));

    public static Target TXT_VALGRAVAMEN =Target.the("Valor de Gravamen")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtValorGravamen"));

    public static Target TXT_FECGRAVAMEN = Target.the("TextBox Fecha Vencimiento")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtFecGravamen"));

    public  static Target CBO_SITUACION = Target.the("Situación")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_ddlSituacion"));

    public static Target CBO_ETAPA = Target.the("Etapa")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_ddlEtapa"));

    public static Target TXT_PROPIETARIO = Target.the("Propietario")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtPropietario"));

    //Información de Seguro
    public static Target CBO_TIPOLIZA = Target.the("Tipo de Póliza")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_cboCIASeguro"));

    public static  Target TXT_NROPOLIZA = Target.the("Número de Póliza")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtNroPoliza"));

    public static Target TXT_FECVTOPOLIZA = Target.the("Fecha de Vencimiento de Póliza")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtFecVctoPoliza"));

    public static Target CBO_NOMCIASEGURO = Target.the("Nombre CIA Seguro")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_cboCIASeguroPol"));

    public static Target TXT_IMPPOLEXT = Target.the("Importe Según Póliza Externa")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtImportePolizaExterna"));

    //Información Tasación
    public static Target CBO_PERITO = Target.the("Perito")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_cboPerito"));

    public static Target TXT_FECTASACION = Target.the("Fecha de Tasación")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtFecTasacion"));

    public static Target CBO_TIPOTASACION = Target.the("Tipo de Tasación")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_cboTipoTasacion"));

    public static Target CBO_SITUACIONTASACION = Target.the("Situación de Tasación")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_cboSituacionTasacion"));

    public static Target CBO_MONEDATASACION = Target.the("Moneda de Tasación")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_cboMonedaTasacion"));

    public static Target TXT_IMPORTEASEGTASACION = Target.the("Importe Asegurable de Tasación")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtImporteasegurableTasacion"));

    public static Target TXT_PORCENTAJE = Target.the("Porcentaje")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtPorcentaje"));




    //Información legal del Registro
    public static Target TXT_NOTARIA = Target.the("Notaría")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtNotaria"));

    public static Target TXT_KARDEX = Target.the("Kárdex")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtKardex"));

    public static  Target TXT_PARTIDAREGISTRAL =Target.the("Partida Registral")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtPartidaRegustral"));

    public static Target TXT_DESCPARTIDAREGISTRAL = Target.the("Descripción Partida Registral")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtDesPartidaRegistral"));

    public static Target CBO_OFICINAREGISTRAL = Target.the("Oficina registral")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_ddlOficinaRegistral"));
    public static Target CBO_ZONAREGSITRAL = Target.the("Zona Registral")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_ddlSubSede"));


    //INFORMACIÓN REGISTRAL
    public static Target TXT_COLORVEHICULO=Target.the("Color del Vehículo")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtColorVehiculo"));

    public static Target TXT_SERIE = Target.the("Serie")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtSerie"));

    public static Target TXT_MOTOR = Target.the("Motor")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtMotor"));

    public static Target TXT_PLACA = Target.the("Placa")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtPlaca"));

    public static Target TXT_MODELOVEHICULO = Target.the("Modelo del Vehiculo")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtModeloVehiculo"));


    //UBIGEO
    public static Target CBO_DEPARTAMENTO =Target.the("Departamento")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_cboDepartamento"));

    public static Target CBO_PROVINCIA = Target.the("Provincia")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_cboProvincia"));

    public static Target CBO_DISTRITO = Target.the("Distrito")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_cboDistrito"));

    public static Target TXT_DIRECCION = Target.the("Dirección")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_txtDireccion"));



    public static Target BTN_REGISTRAR= Target.the("Botón de Registro")
            .located(By.id("ctl00_cphPrincipal_btnRegistrar"));
            //.located(By.xpath("//*[@id=\"ctl00_cphPrincipal_btnRegistrar\"]"));

    public static Target BTN_REGRESAR=Target.the("Botón Regresar")
            .located(By.id("ctl00_cphPrincipal_btnCancelar"));

    public static Target POP_REGISTRO = Target.the("Pop up registro_CartaFianza")
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

       public static Target CBO_MONEDACTA = Target.the("Moneda de cuenta")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDeuda_UcBuscarCuenta1_ddlMonedaCta"));

    public static Target TXT_NUMOFICINACTA = Target.the("Numero de oficina / tienda")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDeuda_UcBuscarCuenta1_txtNroOficinaCta"));

    public static Target TXT_NUMEROCTA = Target.the("Numero de cuenta")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDeuda_UcBuscarCuenta1_txtNumeroCta"));

    public static Target BTN_NVACTA = Target.the("Ingresar Nueva cuenta")
            .located(By.id("ctl00_cphPrincipal_tabGarantias_tabDeuda_UcBuscarCuenta1_btnReiniciarCuenta"));

    public static Target LBL_CARGANDO_CTA = Target.the("Popup Cargando - Cuenta")
            .located(By.id("ctl00_Label1"));

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
