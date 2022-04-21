package starter.stepdefinitions.mobiliariadinero;

import io.cucumber.java.es.Entonces;
import motoresdebusqueda.gac.page.mobiliariadinero.RegMobiliariaSobreDineroUi;
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
import org.openqa.selenium.WebDriver;

import java.awt.event.FocusEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RegMobiliariaSobreDineroStepDefinitions {


    private Object IsNotEnabledMatcher;
    private long keyEventMask;
    private static WebDriver driver;


    @Entonces("se genera nueva Garantia Mobiliaria Sobre Dinero")
public void se_genera_nueva_Garantia_Mobiliaria_Sobre_Dinero() {

    try {
        Sheet sheet = LoadXls.getSheet_MobiliariaSobreDinero(0, "Data-MobiliariaSobreDinero.xlsx");
        String cu;
        double tienda;
        String cdocumento;
        String tdocumento;
        String rango;
        String etapa;
        String clase;
        double ndias;
        String situacion;

        //Datos de la Cuenta
        String monedacta;
        double numoficinacta;
        String numerocta;


        //DEUDA GARANTIA
        String tcobertura;
        String cudeudor;
        String tlistado;
        String nlineaope;
        String descripcion;
        String comentario;
        String Fin; //Fin de ejecución (Fin = "Si" cuando hay errores, Fin = "No" cuando no hay errores)

        Map<Integer, List<String>> data = new HashMap<>();
        //List<String> datosFila;
        //int i = 0;
        int Fila = 0;
        int Columna = 0;

        for (Row row : sheet) {
           // datosFila = new ArrayList<>();
            cu="";
            tienda=0;
            cdocumento="";
            tdocumento="";
            rango="";
            etapa="";
            clase="";
            ndias=0;
            situacion = "";


            //Datos de la Cuenta
            monedacta="";
            numoficinacta=0;
            numerocta="";


            //DEUDA GARANTIA
            tcobertura ="";
            cudeudor ="";
            tlistado ="";
            nlineaope="";
            descripcion ="";
            comentario ="";
            Fin = "No";
            //data.put(i, new ArrayList<>());
            for (Cell cell : row) {
                System.out.print(" | ");

                Fila = cell.getRowIndex();
                Columna = cell.getColumnIndex();

                //Cantidad de columnas (sin garantía)
                int cellCount = row.getLastCellNum() - row.getFirstCellNum();
                System.out.println("--------------------------------La fila tiene:"+ cellCount + " Columnas con data");

                System.out.println("Fila:" + Fila);
                if (cellCount ==18) {
                    //System.out.println("Fila:" + Fila);
                switch (Columna){
                    case 0:
                        cu = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 0++-+-+++-+-+-+-+CU:"+cu);
                        break;
                    case 1:
                        tienda = cell.getNumericCellValue();
                        int tiendaInt = (int)tienda; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 1++-+-+++-+-+-+-+Tienda:"+tiendaInt);
                        break;

                    case 2:
                        cdocumento = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 2++-+-+++-+-+-+-+cdocumento:"+cdocumento);
                        break;
                    case 3:
                        tdocumento = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 3++-+-+++-+-+-+-+tdocumento:"+tdocumento);
                        break;
                    case 4:
                        rango = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 4++-+-+++-+-+-+-+rango:"+rango);
                        break;
                    case 5:
                        etapa = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 5++-+-+++-+-+-+-+etapa:"+etapa);
                        break;
                    case 6:
                        clase = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 6++-+-+++-+-+-+-+clase:"+clase);
                        break;
                    case 7:
                        ndias = cell.getNumericCellValue();
                        int ndiasInt = (int)ndias; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 7++-+-+++-+-+-+-+ndias:"+ndiasInt);
                        break;
                    case 8:
                        situacion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 8++-+-+++-+-+-+-+Situacion:"+situacion);
                        break;


                    //Datos de la Cuenta
                    case 9:
                        monedacta = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 9++-+-+++-+-+-+-+Moneda de Cuenta:"+monedacta);
                        break;
                    case 10:
                        numoficinacta = cell.getNumericCellValue();
                        int numoficinactaInt = (int)numoficinacta; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 10++-+-+++-+-+-+-+Numero de Oficina / Tienda:"+numoficinactaInt);
                        break;
                    case 11:
                        numerocta = cell.getStringCellValue();
                        //int numeroctaInt = (int)numerocta; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 11++-+-+++-+-+-+-+Numero de Cuenta:" +numerocta);
                        break;


                    //TAB Deuda Garantía

                    case 12:
                        tcobertura = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 12++-+-+++-+-+-+-+tcobertura:"+tcobertura);
                        break;
                    case 13:
                        cudeudor = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 13++-+-+++-+-+-+-+cudeudor:"+cudeudor);
                        break;
                    case 14:
                        tlistado = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 14++-+-+++-+-+-+-+tlistado:"+tlistado);
                        break;
                    case 15:
                        nlineaope = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 15++-+-+++-+-+-+-+nlineaope:"+nlineaope);
                        break;
                    case 16:
                        descripcion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 16++-+-+++-+-+-+-+descripcion:"+descripcion);
                        break;
                    case 17:
                        comentario = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 17++-+-+++-+-+-+-+comentario:"+comentario);
                        break;

                }// Fin switch (Columna)
                }//{} Fin (rowCount ==15)
            }//{} FIN (Cell cell : row)


            //Cantidad de columnas (sin garantía)
            int cellCount = row.getLastCellNum() - row.getFirstCellNum();
            System.out.println("-----****************-----SEGUIMOS EN LA fila que tiene:"+ cellCount + " Columnas con data");
            if(cellCount == 18) {


                //--------------------------------------------------------------------------------------------------
                // TAB: Deuda Garantía
                //--------------------------------------------------------------------------------------------------
                Thread.sleep(3000);
                theActorInTheSpotlight().attemptsTo(
                        Click.on(RegMobiliariaSobreDineroUi.TABDEUDA)
                );
                Thread.sleep(5000);
                if (tcobertura.endsWith("rica")) {
                    System.out.println("******************************************GENERICA****************************");
                } //Fin (tcobertura.endsWith("rica"))
                //Thread.sleep(6000);

                else{
                    System.out.println("******************************************ESPECÍFICA****************************");
/*                    theActorInTheSpotlight().attemptsTo(
                            Click.on(RegMobiliariaSobreDineroUi.CBO_TIPOCOBERTURA),
                            Enter.keyValues(String.valueOf(Keys.UP)).into(RegMobiliariaSobreDineroUi.CBO_TIPOCOBERTURA),
                            //TAB -  SPACE - BACK_SPACE - RETURN
                            Enter.keyValues(String.valueOf(Keys.RETURN)).into(RegMobiliariaSobreDineroUi.CBO_TIPOCOBERTURA)
                            //AlertAccept.CobEspecifica()
                    );*/


                    theActorInTheSpotlight().attemptsTo(
                           //SelectFromOptions.byVisibleText(tcobertura).from(RegMobiliariaSobreDineroUi.CBO_TIPOCOBERTURA)
                            //Enter.keyValues(String.valueOf(Keys.UP)).into(RegMobiliariaSobreDineroUi.CBO_TIPOCOBERTURA),
                            //Enter.keyValues(String.valueOf(Keys.ENTER)).into(RegMobiliariaSobreDineroUi.CBO_TIPOCOBERTURA),
                            Click.on(RegMobiliariaSobreDineroUi.CBO_TIPOCOBERTURA)
                            //Enter.keyValues(String.valueOf(Keys.UP)).into(RegMobiliariaSobreDineroUi.CBO_TIPOCOBERTURA)
                            //WaitUntil.the(RegMobiliariaSobreDineroUi.CBO_TIPOCOBERTURA, isCurrentlyVisible()).forNoMoreThan(15).seconds(),
                            //Enter.keyValues(String.valueOf(Keys.TAB)).into(RegMobiliariaSobreDineroUi.CBO_TIPOCOBERTURA)

                            //CommonClass.waitForAlert(BrowseTheWeb.with(driver).asActor(Actor.named(actor)), 30)
                            //CommonClass.waitForAlert(BrowseTheWeb.with(driver).getDriver(), 30)
                   );
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegMobiliariaSobreDineroUi.CBO_TIPOCOBERTURA, isCurrentlyVisible()).forNoMoreThan(15).seconds(),
                            SelectFromOptions.byVisibleText("Especifica").from(RegMobiliariaSobreDineroUi.CBO_TIPOCOBERTURA)
                            //WaitUntil.the(RegMobiliariaSobreDineroUi.CBO_TIPOCOBERTURA, isCurrentlyVisible()).forNoMoreThan(15).seconds(),

                            //AlertAccept.toAccept()

                            //Enter.keyValues(String.valueOf(Keys.TAB)).into(RegMobiliariaSobreDineroUi.CBO_TIPOCOBERTURA),
                    );
                    Thread.sleep(5000);
                    //Actor actor = null;
                    //CommonClass.waitForAlert(BrowseTheWeb.as(actor).getDriver(), 50);

/*                    Enter.keyValues(Keys.ARROW_RIGHT).into("Aceptar");
                    Thread.sleep(3000);
                    Enter.keyValues(Keys.ARROW_LEFT).into("Aceptar");
                    Thread.sleep(3000);*/
                    //theActorInTheSpotlight().attemptsTo(
                    //        AlertAccept.toAccept()
                    //);
                    }



                //TAB Datos Generales
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegMobiliariaSobreDineroUi.TAB_DATOS_GENERALES, isEnabled()).forNoMoreThan(60).seconds(),
                        Click.on(RegMobiliariaSobreDineroUi.TAB_DATOS_GENERALES),
                        WaitUntil.the(RegMobiliariaSobreDineroUi.TXT_CU, isVisible()).forNoMoreThan(30).seconds()
                );


                //Inicio llenado campos
                //Código Unico - cu
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegMobiliariaSobreDineroUi.TXT_CU, isEnabled()).forNoMoreThan(60).seconds(),
                        Enter.keyValues(Keys.HOME).into(RegMobiliariaSobreDineroUi.TXT_CU),
                        Enter.theValue(cu).into(RegMobiliariaSobreDineroUi.TXT_CU),
                        Enter.keyValues(Keys.END).into(RegMobiliariaSobreDineroUi.TXT_CU),
                        Enter.keyValues(Keys.ENTER).into(RegMobiliariaSobreDineroUi.TXT_CU)
                );

                //Espera a que mensaje "Cargando" no sea visible
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegMobiliariaSobreDineroUi.Pop_Modal, isNotCurrentlyVisible()).forNoMoreThan(30).seconds()
                );
                //Graba mensaje cuando CU no existe
                String nombreracsoc;
                nombreracsoc = RegMobiliariaSobreDineroUi.TXT_NOMBRERAZONSOC.resolveFor(theActorInTheSpotlight()).getValue();
                System.out.println("....El NOmbre o razón social es:" + nombreracsoc);

                if ((nombreracsoc == null) || (nombreracsoc.equals(""))) {
                    System.out.println("................................CU no existe!!!");
                    AlertAccept.Valida_CU_Mobiliaria_Sobre_Dinero(Fila, cellCount);
                    Fin = "Si";
                }

                if (Fin == "No") {
                    //Tienda - tienda
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegMobiliariaSobreDineroUi.Pop_Modal, isNotCurrentlyVisible()).forNoMoreThan(30).seconds(),
                            Click.on(RegMobiliariaSobreDineroUi.TXT_TIENDA),
                            Enter.keyValues(Keys.HOME).into(RegMobiliariaSobreDineroUi.TXT_TIENDA),
                            Enter.keyValues(String.valueOf(tienda)).into(RegMobiliariaSobreDineroUi.TXT_TIENDA)
                    );
                    RegMobiliariaSobreDineroUi.TXT_TIENDA.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.ENTER);


                    //Código de Documento  - cdocumento
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(cdocumento).from(RegMobiliariaSobreDineroUi.CBO_CDOCU),
                            WaitUntil.the(RegMobiliariaSobreDineroUi.CBO_CDOCU, containsSelectOption(cdocumento)).forNoMoreThan(6).seconds()
                    );


                    //Tipo de Documento - tdocumento
                    if (!cdocumento.contains("AHORROS")) {
                        theActorInTheSpotlight().attemptsTo(
                                SelectFromOptions.byVisibleText(tdocumento).from(RegMobiliariaSobreDineroUi.CBO_TDOCU),
                                WaitUntil.the(RegMobiliariaSobreDineroUi.CBO_TDOCU, containsSelectOption(tdocumento)).forNoMoreThan(6).seconds()
                        );
                    }


                    //Rango
                    if (!rango.contains("RANGO 3")) {
                        theActorInTheSpotlight().attemptsTo(
                                SelectFromOptions.byVisibleText(rango).from(RegMobiliariaSobreDineroUi.CBO_RANGO)
                        );
                    }


                    //Etapa
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(etapa).from(RegMobiliariaSobreDineroUi.CBO_ETAPA)
                    );
                    Thread.sleep(3000);


                    //Clase
                    if (!clase.contains("AUTOLIQUIDABLE")) {
                        theActorInTheSpotlight().attemptsTo(
                                SelectFromOptions.byVisibleText(clase).from(RegMobiliariaSobreDineroUi.CBO_CLASE)
                        );
                    }


                    //Número de Días
                    int ndiasInt = (int) ndias; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(ndiasInt)).into(RegMobiliariaSobreDineroUi.TXT_NRODIAS)
                    );


                    //Situación
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(situacion).from(RegMobiliariaSobreDineroUi.CBO_SITUACION),
                            WaitUntil.the(RegMobiliariaSobreDineroUi.CBO_SITUACION, containsSelectOption(situacion)).forNoMoreThan(5).seconds()
                    );


                    //Datos de la Cuenta
                    //Moneda de la cuenta
                    if (monedacta.equals("Soles")) {
                        System.out.println("--------------------------------------------------Moneda CTA Soles");
                        theActorInTheSpotlight().attemptsTo(
                                SelectFromOptions.byIndex(1).from(RegMobiliariaSobreDineroUi.CBO_MONEDACTA)
                        );
                    }
                    Thread.sleep(3000);

                    //Oficina de cuenta
                    int numoficinactaInt = (int) numoficinacta; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(numoficinactaInt)).into(RegMobiliariaSobreDineroUi.TXT_NUMOFICINACTA),
                            WaitUntil.the(RegMobiliariaSobreDineroUi.TXT_NUMOFICINACTA, isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    Thread.sleep(3000);

                    //Numero de cuenta
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(numerocta).into(RegMobiliariaSobreDineroUi.TXT_NUMEROCTA),
                            Enter.keyValues(String.valueOf(Keys.HOME)).into(RegMobiliariaSobreDineroUi.TXT_NUMEROCTA),
                            Enter.keyValues(String.valueOf(Keys.END)).into(RegMobiliariaSobreDineroUi.TXT_NUMEROCTA),
                            Enter.keyValues(String.valueOf(Keys.ENTER)).into(RegMobiliariaSobreDineroUi.TXT_NUMEROCTA)
                    );
//                    Thread.sleep(5000);


                    //Graba mensaje cuando cuenta no existe
                    //Boton no visible cuando cuenta no existe
                    if (!RegMobiliariaSobreDineroUi.BTN_NVACTA.resolveFor(theActorInTheSpotlight()).isCurrentlyVisible()) {
                        System.out.println("Cta Cte no existe");
                        //Graba mensaje cuando cuenta no existe
                        AlertAccept.CtaInvalid_MobiliariaSobreDinero(Fila, cellCount);
                        Fin = "Si";
                        System.out.println("-----------Fin x cta no existe: " + Fin);
                    } else {
                        System.out.println("Cta Cte Si Existe");

                    }

                    if (Fin == "No")
                    {
                    //--------------------------------------------------------------------------------------------------
                    // TAB: Deuda Garantía
                    //--------------------------------------------------------------------------------------------------
                    Thread.sleep(3000);
                    theActorInTheSpotlight().attemptsTo(
                            Click.on(RegMobiliariaSobreDineroUi.TABDEUDA)
                    );
                    Thread.sleep(5000);


                    if (tcobertura.endsWith("rica")) {
                        System.out.println("******************************************GENERICA****************************");
                    } //Fin (tcobertura.endsWith("rica"))
                    //Thread.sleep(6000);

                    else{
                        System.out.println("******************************************ESPECÍFICA****************************");
                        theActorInTheSpotlight().attemptsTo(
                                SelectFromOptions.byVisibleText("Especifica").from(RegMobiliariaSobreDineroUi.CBO_TIPOCOBERTURA)
                        );
                        Thread.sleep(2000);
                        Enter.keyValues(Keys.ARROW_RIGHT).into("Aceptar");
                        Thread.sleep(3000);
                        Enter.keyValues(Keys.ARROW_LEFT).into("Aceptar");
                        Thread.sleep(3000);
                        //Enter.keyValues(String.valueOf(Keys.HOME)).into(RegMobiliariaSobreDineroUi.TXT_NUMEROCTA),

/*                        if (tcobertura.contains("Especifica")) {
                            if (tlistado.contains("Operaciones")) {
                                System.out.println("**************************OPERACIONES****************************");
                                theActorInTheSpotlight().attemptsTo(
                                        Click.on(RegMobiliariaSobreDineroUi.RBT_TLISTADOOPE)
                                );
                                Thread.sleep(3000);

                                theActorInTheSpotlight().attemptsTo(
                                        WaitUntil.the(RegMobiliariaSobreDineroUi.CBO_OPE, containsText("Nro Operacion")).forNoMoreThan(40).seconds()
                                );
                                Thread.sleep(3000);

                                //split divide la cadena en base a separador ";"
                                for (String numope : nlineaope.split(";")) {
                                    //reemplaza espacios vacíos
                                    numope = numope.replace(" ", "");

                                    theActorInTheSpotlight().attemptsTo(
                                            WaitUntil.the(RegMobiliariaSobreDineroUi.TXT_NROOPERACION, isEnabled()).forNoMoreThan(30).seconds(),
                                            Click.on(RegMobiliariaSobreDineroUi.TXT_NROOPERACION),
                                            Enter.theValue(numope).into(RegMobiliariaSobreDineroUi.TXT_NROOPERACION),
                                            Enter.keyValues(String.valueOf(Keys.HOME)).into(RegMobiliariaSobreDineroUi.TXT_NROOPERACION),
                                            Enter.keyValues(String.valueOf(Keys.END)).into(RegMobiliariaSobreDineroUi.TXT_NROOPERACION),
                                            Enter.keyValues(String.valueOf(Keys.TAB)).into(RegMobiliariaSobreDineroUi.TXT_NROOPERACION),
                                            Enter.keyValues(String.valueOf(Keys.SPACE)).into(RegMobiliariaSobreDineroUi.BTN_BUSCAROPE)
                                    );
                                    Thread.sleep(5000);


                                    //Graba mensaje cuando operación no existe
                                    theActorInTheSpotlight().attemptsTo(
                                            AlertAccept.OpeLinInvalid_MobiliariaBienesBancaPersona(Fila, cellCount)
                                    );
                                    Thread.sleep(6000);


                                    //TXT_NROOPERACION contiene (muestra) nlineaope cuando no existe la operación, entonces termina sin GAC
                                    if (RegMobiliariaSobreDineroUi.TXT_NROOPERACION.resolveFor(theActorInTheSpotlight()).containsValue(nlineaope)) {
                                        System.out.println("ope no existe");
                                        Fin = "Si";
                                        System.out.println("-----------Fin ope no existe" + Fin);
                                    }
                                }
                            } // Fin (tlistado.contains("Operaciones"))


                            else if (tlistado.contains("Lineas")) {
                                System.out.println("******************************************LINEAS****************************");
                                theActorInTheSpotlight().attemptsTo(
                                        Click.on(RegMobiliariaSobreDineroUi.RBT_TLISTADOLINEA)
                                );

                                //split divide la cadena en base a separador ";"
                                for (String numlin : nlineaope.split(";")) {
                                    //reemplaza espacios vacíos
                                    numlin = numlin.replace(" ", "");

                                    theActorInTheSpotlight().attemptsTo(
                                            WaitUntil.the(RegMobiliariaSobreDineroUi.TXT_NROOPERACION, isEnabled()).forNoMoreThan(30).seconds(),
                                            Click.on(RegMobiliariaSobreDineroUi.TXT_NROOPERACION),
                                            Enter.theValue(numlin).into(RegMobiliariaSobreDineroUi.TXT_NROOPERACION),
                                            Enter.keyValues(String.valueOf(Keys.HOME)).into(RegMobiliariaSobreDineroUi.TXT_NROOPERACION),
                                            Enter.keyValues(String.valueOf(Keys.END)).into(RegMobiliariaSobreDineroUi.TXT_NROOPERACION),
                                            Enter.keyValues(String.valueOf(Keys.TAB)).into(RegMobiliariaSobreDineroUi.TXT_NROOPERACION),
                                            Enter.keyValues(String.valueOf(Keys.SPACE)).into(RegMobiliariaSobreDineroUi.BTN_BUSCAROPE)
                                    );
                                    Thread.sleep(5000);

                                    //Graba mensaje cuando línea no existe
                                    theActorInTheSpotlight().attemptsTo(
                                            AlertAccept.OpeLinInvalid_MobiliariaBienesBancaPersona(Fila, cellCount)
                                    );
                                    Thread.sleep(6000);

                                    //Lectura de Excel con último mensaje grabado (cuando linea no existe)
                                    Cell grabado;
                                    Sheet sheet2 = LoadXls.getSheet_MobiliariaBienesBancaPersona(0, "Data-MobiliariaSobreBienesBancaPersona.xlsx");
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
                        Thread.sleep(3000);*/

                    }
                    //CU Deudor
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegMobiliariaSobreDineroUi.TXT_CUDEUDOR, isEnabled()).forNoMoreThan(30).seconds(),
                            Enter.theValue(cudeudor).into(RegMobiliariaSobreDineroUi.TXT_CUDEUDOR)
                    );
                    RegMobiliariaSobreDineroUi.TXT_CUDEUDOR.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.ENTER);
                    WaitUntil.the(RegMobiliariaSobreDineroUi.TXT_CUDEUDOR, isNotCurrentlyEnabled()).forNoMoreThan(30).seconds();
                    Thread.sleep(5000);


                }
            }




                if (Fin == "No")
                {
                    //

                    //

                    //--------------------------------------------------------------------------------------------------
                    // TAB: Deuda Garantía
                    //--------------------------------------------------------------------------------------------------
                    theActorInTheSpotlight().attemptsTo(
                            Click.on(RegMobiliariaSobreDineroUi.TAB_DESCRIPCION)
                    );
                    Thread.sleep(3000);

                    //Descripción
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(descripcion).into(RegMobiliariaSobreDineroUi.TXT_DESCRIPCION)
                    );

                    //Comentario
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(comentario).into(RegMobiliariaSobreDineroUi.TXT_COMENTARIO)
                    );
                    Thread.sleep(1000);

                    //--------------------------------------------------------------------------------------------------
                    // REGISTRAR GARANTIA
                    //--------------------------------------------------------------------------------------------------
                    RegMobiliariaSobreDineroUi.BTN_REGISTRAR.resolveFor(theActorInTheSpotlight()).click();
                    keyEventMask = FocusEvent.KEY_EVENT_MASK;
                    theActorInTheSpotlight().attemptsTo(
                            AlertAccept.Aceptar_MobiliriaSobreDinero(Fila,cellCount, Fila)
                    );

                    //Fin llenado campos
                    new motoresdebusqueda.gac.stepdefinitions.mobiliariadinero.GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_garantia_mobiliaria_sobre_dinero();
                }

                if (Fin == "Si") {
                    System.out.println("-----------Fin - ejecucion por errores");
                    new GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_garantia_mobiliaria_sobre_dinero();
                }


            }// Fin (rowCount == 15)

            System.out.println(" | ");
            //i++;
        }// Fin (Row row : sheet)

    }catch (Exception e){
        System.out.println(e.getMessage());
    }


    }
}

