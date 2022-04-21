package starter.stepdefinitions.cartafianza;

import io.cucumber.java.es.Entonces;
import motoresdebusqueda.gac.page.cartafianza.RegCartaFianzaUi;
import motoresdebusqueda.gac.util.alert.AlertAccept;
import motoresdebusqueda.gac.util.excel.LoadXls;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.Keys;

import java.awt.event.FocusEvent;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actions.Enter.keyValues;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

//

public class RegCfStepDefinitions {

    private Object IsNotEnabledMatcher;
    private long keyEventMask;

    /*
        @Y("se registra Carta Fianza con CU Titular{string} y con tienda {string} y con tipo documento {string} y con moneda {string} y con fecha de vencimiento {string} y con numero de dias {string} y con numero documento {string} y con porcentaje {string} y con importe {string} y con Tipo de Cobertura {string} y con CU deudor {string} y con tipo de Listado {string} y con Numero Linea operacion {string} y con descripcion{string} y con comentario{string}")
        public void seRegistraCartaFianzaConCUTitularYConTiendaYConTipoDocumentoYConMonedaYConFechaDeVencimientoYConNumeroDeDiasYConNumeroDocumentoYConPorcentajeYConImporteYConTipoDeCoberturaYConCUDeudorYConOperacionYConDescripcionYConComentario(String cu, String tienda, String tdocumento, String moneda, String fecvencimiento, String ndias, String ndocu, String porcentaje, String importe, String tcobertura, String cudeudor, String tlistado, String nlineaope, String descripcion, String comentario) throws InterruptedException {
    */
    @Entonces("se genera nueva Garantia Carta Fianza")
    public void segeneranuevaGarantiaCartaFianza() {

        try {
            Sheet sheet = LoadXls.getSheet_CartaFianza(0, "Data-Carta_Fianza.xlsx");
            String cu;
            double tienda;
            String tdocumento;
            String fecvencimiento;
            double ndias;
            double ndocu;
            double porcentaje;
            double importe;
            String moneda;
            String tcobertura;
            String cudeudor;
            String tlistado;
            String nlineaope;
            String descripcion;
            double comentario;
            String Fin;

            String rango;       //CFI-IB-COMERCIAL
            String situacion;   //CFI-IB-COMERCIAL
            String modeloibk;   //CFI-IB-COMERCIAL
            String vblegal;     //CFI-IB-COMERCIAL
            String catbanco;    //CFI-IB-COMERCIAL
            String banco;       //CFI-IB-COMERCIAL
            String lineabanco;    //CFI-IB-COMERCIAL


            Map<Integer, List<String>> data = new HashMap<>();
            //List<String> datosFila;
            //int i = 0;
            int Fila = 0;
            int Columna = 0;

            for (Row row : sheet) {
                // datosFila = new ArrayList<>();
                cu = "";
                tienda = 0;
                tdocumento = "";
                fecvencimiento = "";
                ndias = 0;
                ndocu = 0;
                porcentaje = 0;
                importe = 0;
                moneda = "";
                tcobertura = "";
                cudeudor = "";
                tlistado = "";
                nlineaope = "";
                descripcion = "";
                comentario = 0;
                Fin = "No";


                rango = "";       //CFI-IB-COMERCIAL
                situacion = "";  //CFI-IB-COMERCIAL
                modeloibk = "";   //CFI-IB-COMERCIAL
                vblegal = "";     //CFI-IB-COMERCIAL
                catbanco = "";    //CFI-IB-COMERCIAL
                banco = "";       //CFI-IB-COMERCIAL
                lineabanco = "";    //CFI-IB-COMERCIAL
                //data.put(i, new ArrayList<>());
                for (Cell cell : row) {
                    System.out.print(" | ");

                    Fila = cell.getRowIndex();
                    Columna = cell.getColumnIndex();

                    //Catidad de columnas (sin garantía)
                    int cellCount = row.getLastCellNum() - row.getFirstCellNum();
                    System.out.println("--------------------------------La fila tiene:" + cellCount + " Columnas con data");

                    System.out.println("Fila:" + Fila);
                    if (cellCount == 22) {
                        //System.out.println("Fila:" + Fila);
                        switch (Columna) {
                            case 0:
                                cu = cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 0++-+-+++-+-+-+-+CU:" + cu);
                                break;
                            case 1:
                                tienda = cell.getNumericCellValue();
                                int tiendaInt = (int) tienda; // Convert Double to Integer
                                System.out.println("-++++-+++-++++-Columna 1++-+-+++-+-+-+-+Tienda:" + tiendaInt);
                                break;
                            case 2:
                                tdocumento = cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 2++-+-+++-+-+-+-+tdocumento:" + tdocumento);
                                break;
                            case 3:
                                rango = cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 3++-+-+++-+-+-+-+rango:" + rango);
                                break;
                            case 4:
                                moneda = cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 4++-+-+++-+-+-+-+moneda:" + moneda);
                                break;
                            case 5:
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //SimpleDateFormat
                                fecvencimiento = dateFormat.format(cell.getDateCellValue());
                                System.out.println("-++++-+++-++++-Columna 5++-+-+++-+-+-+-+fecvencimiento:" + fecvencimiento);
                                break;
                            case 6:
                                situacion = cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 6++-+-+++-+-+-+-+situacion:" + situacion);
                                break;
                            case 7:
                                ndias = cell.getNumericCellValue();
                                int ndiasInt = (int)ndias; // Convert Double to Integer
                                System.out.println("-++++-+++-++++-Columna 7++-+-+++-+-+-+-+ndias:"+ndiasInt);
                                break;
                            case 8:
                                 modeloibk= cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 8++-+-+++-+-+-+-+modeloibk:" + modeloibk);
                                break;
                            case 9:
                                vblegal= cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 9++-+-+++-+-+-+-+vblegal:" + vblegal);
                                break;
                            case 10:
                                catbanco= cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 10++-+-+++-+-+-+-+catbanco:" + catbanco);
                                break;
                            case 11:
                                banco= cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 11++-+-+++-+-+-+-+banco:" + banco);
                                break;
                            case 12:
                                lineabanco= cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 12++-+-+++-+-+-+-+lineabanco:" + lineabanco);
                                break;
                            case 13:
                                ndocu = cell.getNumericCellValue();
                                int ndocuInt = (int)ndocu; // Convert Double to Integer
                                System.out.println("-++++-+++-++++-Columna 13++-+-+++-+-+-+-+ndocu:"+ndocuInt);
                                break;
                            case 14:
                                porcentaje = cell.getNumericCellValue();
                                int porcentajeInt = (int)porcentaje; // Convert Double to Integer*/
                                System.out.println("-++++-+++-++++-Columna 14++-+-+++-+-+-+-+porcentaje:"+porcentajeInt);
                                break;
                            case 15:
                                importe = cell.getNumericCellValue();
                                System.out.println("-++++-+++-++++-Columna 15++-+-+++-+-+-+-+importe:" + importe);
                                break;

                            case 16:
                                tcobertura = cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 9++-+-+++-+-+-+-+tcobertura:" + tcobertura);
                                break;
                            case 17:
                                cudeudor = cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 10++-+-+++-+-+-+-+cudeudor:" + cudeudor);
                                break;
                            case 18:
                                tlistado = cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 11++-+-+++-+-+-+-+tlistado:" + tlistado);
                                break;
                            case 19:
                                nlineaope = cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 12++-+-+++-+-+-+-+nlineaope:" + nlineaope);
                                break;
                            case 20:
                                descripcion = cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 13++-+-+++-+-+-+-+descripcion:" + descripcion);
                                break;
                            case 21:
                                comentario = cell.getNumericCellValue();
                                int comentarioInt = (int) comentario; // Convert Double to Integer
                                System.out.println("-++++-+++-++++-Columna 14++-+-+++-+-+-+-+comentario:" + comentarioInt);
                                break;
                        }// Fin switch (Columna)
                    }//{} Fin (rowCount ==15)
                }//{} FIN (Cell cell : row)

                //data.put(i, datosFila);
                //System.out.println("-------------------La fila actual es:"+i);

                //Catidad de columnas (sin garantía)
                int cellCount = row.getLastCellNum() - row.getFirstCellNum();
                System.out.println("-----****************-----SEGUIMOS EN LA fila que tiene:" + cellCount + " Columnas con data");
                if (cellCount == 22) {
                    //Inicio llenado campos
                    //Código Unico - cu
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegCartaFianzaUi.TXT_CU, isEnabled()).forNoMoreThan(60).seconds(),
                            keyValues(Keys.HOME).into(RegCartaFianzaUi.TXT_CU),
                            Enter.theValue(cu).into(RegCartaFianzaUi.TXT_CU),
                            keyValues(Keys.END).into(RegCartaFianzaUi.TXT_CU),
                            keyValues(Keys.ENTER).into(RegCartaFianzaUi.TXT_CU)
                    );


                    //Espera a que mensaje "Cargando" no sea visible
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegCartaFianzaUi.Pop_Modal, isNotCurrentlyVisible()).forNoMoreThan(30).seconds()
                    );
                    //Graba mensaje cuando CU no existe
                    String nombreracsoc;
                    nombreracsoc = RegCartaFianzaUi.TXT_NOMBRERAZONSOC.resolveFor(theActorInTheSpotlight()).getValue();
                    System.out.println("....El NOmbre o razón social es:"+nombreracsoc);

                    if ((nombreracsoc == null) || (nombreracsoc.equals("")) ){
                        System.out.println("................................CU no existe!!!");
                        AlertAccept.Valida_CU_CartaFianza(Fila, cellCount);
                        Fin = "Si";
                    }

                    if (Fin == "No")
                    {
                        //Tienda - tienda
                        theActorInTheSpotlight().attemptsTo(
                                WaitUntil.the(RegCartaFianzaUi.Pop_Modal, isNotCurrentlyVisible()).forNoMoreThan(20).seconds(),
                                Click.on(RegCartaFianzaUi.TXT_TIENDA),
                                keyValues(Keys.HOME).into(RegCartaFianzaUi.TXT_TIENDA),
                                keyValues(String.valueOf(tienda)).into(RegCartaFianzaUi.TXT_TIENDA)
                        );
                        RegCartaFianzaUi.TXT_TIENDA.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.ENTER);
                        theActorInTheSpotlight().attemptsTo(
                                WaitUntil.the(RegCartaFianzaUi.TXT_TIENDA, isNotSelected()).forNoMoreThan(30).seconds()
                        );

                        //Tipo de Documento  - tdocumento
                        theActorInTheSpotlight().attemptsTo(
                                SelectFromOptions.byVisibleText(tdocumento).from(RegCartaFianzaUi.LBL_TDOCU)
                        );
                        Thread.sleep(5000);

                        if (tdocumento.equals("FONDO CRECER")) {
                            if (!moneda.equals("Soles")) {
                                System.out.println("--------------------------------------------------Moneda dolares");
                                theActorInTheSpotlight().attemptsTo(
                                        WaitUntil.the(RegCartaFianzaUi.LBL_TDOCU, isNotSelected()).forNoMoreThan(30).seconds(),
                                        SelectFromOptions.byIndex(0).from(RegCartaFianzaUi.LBL_MONEDA)
                                );
                            }
                            Thread.sleep(5000);
                        }

                        if ((tdocumento.equals("CFI-IB-COMERCIAL"))||(tdocumento.equals("CFI - IB HIPOTECARIO"))||(tdocumento.equals("CFI-BANCO DEL TRABAJO"))||(tdocumento.equals("CFI-BCO.LATINO"))||(tdocumento.equals("CFI-MI VIVIENDA")))
                        {
                            //Rango
                            theActorInTheSpotlight().attemptsTo(
                                    SelectFromOptions.byVisibleText(rango).from(RegCartaFianzaUi.CBO_RANGO)
                                    //WaitUntil.the(RegCartaFianzaUi.CBO_BANCO, isNotSelected()).forNoMoreThan(30).seconds()
                            );
                            Thread.sleep(3000);

                            //Moneda
                            if (moneda.equals("Soles")) {
                                System.out.println("--------------------------------------------------Moneda Soles");
                                theActorInTheSpotlight().attemptsTo(
                                        WaitUntil.the(RegCartaFianzaUi.LBL_TDOCU, isNotSelected()).forNoMoreThan(30).seconds(),
                                        SelectFromOptions.byIndex(1).from(RegCartaFianzaUi.LBL_MONEDA)
                                );
                            }
                            Thread.sleep(5000);
                        }

                        //Fecha de Vencimiento
                        theActorInTheSpotlight().attemptsTo(
                                WaitUntil.the(RegCartaFianzaUi.LBL_TDOCU, isNotSelected()).forNoMoreThan(30).seconds(),
                                Enter.theValue(fecvencimiento).into(RegCartaFianzaUi.TXT_FECHA)
                        );

                        //Situación
                        theActorInTheSpotlight().attemptsTo(
                                SelectFromOptions.byVisibleText(situacion).from(RegCartaFianzaUi.CBO_SITUACION)
                        );
                        Thread.sleep(3000);


                        //Número de días
                        int ndiasInt = (int) ndias; // Convert Double to Integer
                        theActorInTheSpotlight().attemptsTo(
                                //Enter.keyValues(String.valueOf(ndias)).into(RegCartaFianzaUi.TXT_NDIAS),
                                keyValues(String.valueOf(ndiasInt)).into(RegCartaFianzaUi.TXT_NDIAS)
                        );

                        //Modelo IBK - VB Legal - Categoria del Banco	- Banco
                        if ((tdocumento.equals("CFI-IB-COMERCIAL"))||(tdocumento.equals("CFI - IB HIPOTECARIO"))||(tdocumento.equals("CFI-BANCO DEL TRABAJO"))||(tdocumento.equals("CFI-BCO.LATINO"))||(tdocumento.equals("CFI-MI VIVIENDA")))
                        {
                            System.out.println("-----Ingresa a CFI-IB-COMERCIAL");

                            //Modelo IBK
                            if (modeloibk.equals("Si"))
                            {
                                System.out.println("modelo ibk ... con check");
                                theActorInTheSpotlight().attemptsTo(
                                        Click.on(RegCartaFianzaUi.CHK_MODIBK)
                                );
                            }

                            // VB Legal
                            if (vblegal.equals("Si"))
                            {
                                System.out.println("Vb Legal ...con check");
                                theActorInTheSpotlight().attemptsTo(
                                        Click.on(RegCartaFianzaUi.CHK_VBLEGAL)
                                );
                            }

                            //Categoria del Banco
                            theActorInTheSpotlight().attemptsTo(
                                    SelectFromOptions.byVisibleText(catbanco).from(RegCartaFianzaUi.CBO_CATBANCO),
                                    WaitUntil.the(RegCartaFianzaUi.CBO_CATBANCO, isNotSelected()).forNoMoreThan(30).seconds()
                            );

                            //Banco
                            theActorInTheSpotlight().attemptsTo(
                                    SelectFromOptions.byVisibleText(banco).from(RegCartaFianzaUi.CBO_BANCO),
                                    WaitUntil.the(RegCartaFianzaUi.CBO_BANCO, isNotSelected()).forNoMoreThan(30).seconds()
                            );
                            Thread.sleep(5000);

                            theActorInTheSpotlight().attemptsTo(
                                    WaitUntil.the(RegCartaFianzaUi.LBL_LINEABANCO, isClickable()).forNoMoreThan(20).seconds(),
                                    SelectFromOptions.byVisibleText(lineabanco).from(RegCartaFianzaUi.LBL_LINEABANCO)
                            );

                            theActorInTheSpotlight().attemptsTo(
                                    WaitUntil.the(RegCartaFianzaUi.TXT_LINEABANCO, hasValue(lineabanco)).forNoMoreThan(10).seconds()
                            );

                        }

                        //Número de Documento
                        int ndocuInt = (int) ndocu; // Convert Double to Integer
                        theActorInTheSpotlight().attemptsTo(
                                keyValues(String.valueOf(ndocuInt)).into(RegCartaFianzaUi.TXT_NUDOCU)
                        );


                        //Porcentaje
                        int porcentajeInt = (int) porcentaje; // Convert Double to Integer
                        theActorInTheSpotlight().attemptsTo(
                                keyValues(String.valueOf(porcentajeInt)).into(RegCartaFianzaUi.TXT_PORCENTAJE)
                        );

                        //Importe
                        theActorInTheSpotlight().attemptsTo(
                                keyValues(String.valueOf(importe)).into(RegCartaFianzaUi.TXT_IMPORTE)
                        );

                    }


                    if (Fin == "No") {

                        //--------------------------------------------------------------------------------------------------
                        // TAB: Deuda Garantía
                        //--------------------------------------------------------------------------------------------------
                        theActorInTheSpotlight().attemptsTo(
                                Click.on(RegCartaFianzaUi.TABDEUDA)
                        );
                        Thread.sleep(5000);


                        if (tcobertura.endsWith("rica")) {
                            // else if (tcobertura.contains("Sabana o Generica")){
                            System.out.println("******************************************GENERICA****************************");

                            theActorInTheSpotlight().attemptsTo(
                                    //SelectFromOptions.byIndex(1).from(RegCartaFianzaUi.CBO_TIPOCOBERTURA),
                                    SelectFromOptions.byVisibleText("Sabana o Generica").from(RegCartaFianzaUi.LBLTIPOCOBERTURA)
                            );


                            Thread.sleep(4000);
                            //WaitUntil.the(RegCartaFianzaUi.CBO_TIPOCOBERTURA, containsText(tcobertura)).forNoMoreThan(30).seconds();

                        } //Fin (tcobertura.endsWith("rica"))
                        //Thread.sleep(3000);

                        //CU deudor
                        theActorInTheSpotlight().attemptsTo(
                                WaitUntil.the(RegCartaFianzaUi.TXT_CUDEUDOR, isEnabled()).forNoMoreThan(30).seconds(),
                                Enter.theValue(cudeudor).into(RegCartaFianzaUi.TXT_CUDEUDOR)
                        );
                        RegCartaFianzaUi.TXT_CUDEUDOR.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.ENTER);
                        WaitUntil.the(RegCartaFianzaUi.TXT_CUDEUDOR, isNotCurrentlyEnabled()).forNoMoreThan(30).seconds();
                        Thread.sleep(5000);


                        if (tcobertura.contains("Especifica")) {
                            if (tlistado.contains("Operaciones")) {
                                System.out.println("**************************OPERACIONES****************************");
                                theActorInTheSpotlight().attemptsTo(
                                        Click.on(RegCartaFianzaUi.RBT_TLISTADOOPE)
                                );
                                Thread.sleep(3000);

                                theActorInTheSpotlight().attemptsTo(
                                        WaitUntil.the(RegCartaFianzaUi.LBL_OPE, containsText("Nro Operacion")).forNoMoreThan(30).seconds()
                                );

                                //split divide la cadena en base a separador ";"
                                for (String numope: nlineaope.split(";")) {
                                    //reemplaza espacios vacíos
                                    numope = numope.replace(" ", "");

                                    theActorInTheSpotlight().attemptsTo(
                                            WaitUntil.the(RegCartaFianzaUi.TXT_NROOPERACION, isEnabled()).forNoMoreThan(30).seconds(),
                                            Click.on(RegCartaFianzaUi.TXT_NROOPERACION),
                                            Enter.theValue(numope).into(RegCartaFianzaUi.TXT_NROOPERACION),
                                            keyValues(Keys.HOME).into(RegCartaFianzaUi.TXT_NROOPERACION),
                                            keyValues(Keys.END).into(RegCartaFianzaUi.TXT_NROOPERACION),
                                            keyValues(Keys.TAB).into(RegCartaFianzaUi.TXT_NROOPERACION),
                                            keyValues(Keys.SPACE).into(RegCartaFianzaUi.BTN_BUSCAROPE)
                                    );
                                    Thread.sleep(5000);

                                    //Graba mensaje cuando operación no existe
                                    theActorInTheSpotlight().attemptsTo(
                                            AlertAccept.OpeLinInvalid_CartaFianza(Fila, cellCount)
                                    );
                                    Thread.sleep(6000);


                                    //TXT_NROOPERACION contiene (muestra) nlineaope cuando no existe la operación, entonces termina sin GAC
                                    if (RegCartaFianzaUi.TXT_NROOPERACION.resolveFor(theActorInTheSpotlight()).containsValue(nlineaope)) {
                                        System.out.println("ope no existe");
                                        Fin = "Si";
                                        System.out.println("-----------Fin ope no existe" + Fin);
                                    }

                                }

                            } // Fin (tlistado.contains("Operaciones"))

                            else if (tlistado.contains("Lineas")) {
                                System.out.println("******************************************LINEAS****************************");
                                theActorInTheSpotlight().attemptsTo(
                                        Click.on(RegCartaFianzaUi.RBT_TLISTADOLINEA)
                                );

                                //split divide la cadena en base a separador ";"
                                for (String numlin: nlineaope.split(";")) {
                                    //reemplaza espacios vacíos
                                    numlin = numlin.replace(" ", "");

                                    theActorInTheSpotlight().attemptsTo(
                                            WaitUntil.the(RegCartaFianzaUi.TXT_NROOPERACION, isEnabled()).forNoMoreThan(20).seconds(),
                                            Click.on(RegCartaFianzaUi.TXT_NROOPERACION),
                                            Enter.theValue(numlin).into(RegCartaFianzaUi.TXT_NROOPERACION)
                                    );
                                    RegCartaFianzaUi.BTN_BUSCAROPE.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.SPACE);
                                    // WaitUntil.the(RegCartaFianzaUi.BTN_BUSCAROPE,isNotCurrentlyEnabled()).forNoMoreThan(30).seconds();


                                    //Graba mensaje cuando línea no existe
                                    theActorInTheSpotlight().attemptsTo(
                                            AlertAccept.OpeLinInvalid_CartaFianza(Fila, cellCount)
                                    );
                                    //Thread.sleep(6000);

                                    //Lectura de Excel con último mensaje grabado (cuando linea no existe)
                                    //Se hace esto por que cuando la línea no existe igual se borra del campo TXT_NROOPERACION (opuesto a comportamiento de operaciones)
                                    Cell grabado;
                                    Sheet sheet2 = LoadXls.getSheet_CartaFianza(0, "Data-Carta_Fianza.xlsx");
                                    grabado = sheet2.getRow(Fila).getCell(cellCount);
                                    System.out.println("mensaje:" + grabado);

                                    if (grabado != null) { //cuando contiene mensaje grabado (línea no existe)
                                        System.out.println("Lines no existe");
                                        Fin = "Si";
                                        System.out.println("-----------Fin - Línea no existe" + Fin);
                                    }
                                }

                            } // Fin (tlistado.contains("Lineas"))
                        } // Fin (tcobertura.contains("Especifica"))
                        Thread.sleep(3000);

                    }

                    if (Fin == "No") {

                        //--------------------------------------------------------------------------------------------------
                        // TAB: Deuda Garantía
                        //--------------------------------------------------------------------------------------------------
                        theActorInTheSpotlight().attemptsTo(
                                Click.on(RegCartaFianzaUi.TAB_DESCRIPCION)
                        );
                        Thread.sleep(3000);

                        //Descripción
                        theActorInTheSpotlight().attemptsTo(
                                Enter.theValue(descripcion).into(RegCartaFianzaUi.TXT_DESCRIPCION)
                        );

                        //Comentario
                        int comentarioInt = (int) comentario; // Convert Double to Integer
                        theActorInTheSpotlight().attemptsTo(
                                keyValues(String.valueOf(comentarioInt)).into(RegCartaFianzaUi.TXT_COMENTARIO)
                                //Enter.theValue(comentario).into(RegCartaFianzaUi.TXT_COMENTARIO)
                        );
                        Thread.sleep(5000);


                        //--------------------------------------------------------------------------------------------------
                        // REGISTRAR GARANTIA
                        //--------------------------------------------------------------------------------------------------
                        RegCartaFianzaUi.BTN_REGISTRAR.resolveFor(theActorInTheSpotlight()).click();
                        keyEventMask = FocusEvent.KEY_EVENT_MASK;
                        theActorInTheSpotlight().attemptsTo(
                                AlertAccept.Aceptar_CartaFianza2(Fila, cellCount, Fila)
                        );
                        new GACMenuPrincipalStepDefinitions().se_selecciona_garantia_carta_fianza();

                        //Fin llenado campos

                    }

                    if (Fin == "Si") {
                        System.out.println("-----------Fin - ejecucion por errores");
                        new GACMenuPrincipalStepDefinitions().se_selecciona_garantia_carta_fianza();
                    }

                }// Fin (rowCount == 15)

                System.out.println(" | ");
                //i++;
            }// Fin (Row row : sheet)

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}


