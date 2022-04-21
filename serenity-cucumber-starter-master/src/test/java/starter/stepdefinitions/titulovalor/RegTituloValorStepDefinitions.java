package starter.stepdefinitions.titulovalor;

import io.cucumber.java.es.Entonces;
import motoresdebusqueda.gac.page.titulovalor.RegTituloValorUi;
import motoresdebusqueda.gac.util.alert.AlertAccept;
import motoresdebusqueda.gac.util.excel.LoadXls;
import motoresdebusqueda.gac.util.excel.WriteXls;
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

public class RegTituloValorStepDefinitions {

    private Object IsNotEnabledMatcher;
    private long keyEventMask;
    private static WebDriver driver;

@Entonces("se genera nueva Garantia Titulo Valor")
public void se_genera_nueva_Garantia_Titulo_Valor() throws InterruptedException {

    try {
        Sheet sheet = LoadXls.getSheet_TituloValor(0, "Data-TituloValor.xlsx");
        //TAB: Datos de la Garantía
        String cu;
        double tienda;
        String coddocumento;
        String tdocumento;
        String situacion;
        double ndias;
        double nvalorado;
        String monedacta;
        double numoficinacta;
        String numerocta;


        //TAB: DEUDA GARANTIA
        String tcobertura;
        String cudeudor;
        String tlistado;
        String nlineaope;

        //TAB: DESCRIPCION
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
            //TAB: Datos de la Garantía
            cu="";
            tienda=0;
            coddocumento="";
            tdocumento="";
            situacion="";
            ndias = 0;
            nvalorado=0;
            monedacta="";
            numoficinacta=0;
            numerocta="";


            //TAB: DEUDA GARANTIA
            tcobertura ="";
            cudeudor ="";
            tlistado ="";
            nlineaope="";

            //TAB: DESCRIPCION
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
                if (cellCount ==16) {
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
                        coddocumento = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 2++-+-+++-+-+-+-+coddocumento:"+coddocumento);
                        break;
                    case 3:
                        tdocumento = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 3++-+-+++-+-+-+-+tdocumento:"+tdocumento);
                        break;
                    case 4:
                        situacion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 4++-+-+++-+-+-+-+situacion:"+situacion);
                        break;
                    case 5:
                        ndias = cell.getNumericCellValue();
                        int ndiasInt = (int)ndias; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 5++-+-+++-+-+-+-+ndias:"+ndiasInt);
                        break;
                    case 6:
                        nvalorado = cell.getNumericCellValue();
                        int nvaloradoInt = (int)nvalorado; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 6++-+-+++-+-+-+-+numero valorado:"+nvaloradoInt);
                        break;
                    case 7:
                        monedacta = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 7++-+-+++-+-+-+-+Moneda de Cuenta:"+monedacta);
                        break;
                    case 8:
                        numoficinacta = cell.getNumericCellValue();
                        int numoficinactaInt = (int)numoficinacta; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 8++-+-+++-+-+-+-+Numero de Oficina / Tienda:"+numoficinactaInt);
                        break;
                    case 9:
                        numerocta = cell.getStringCellValue();
                        //int numeroctaInt = (int)numerocta; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 9++-+-+++-+-+-+-+Numero de Cuenta:" +numerocta);
                        break;

                    //TAB Deuda Garantía
                    case 10:
                        tcobertura = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 10++-+-+++-+-+-+-+tcobertura:"+tcobertura);
                        break;
                    case 11:
                        cudeudor = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 11++-+-+++-+-+-+-+cudeudor:"+cudeudor);
                        break;
                    case 12:
                        tlistado = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 12++-+-+++-+-+-+-+tlistado:"+tlistado);
                        break;
                    case 13:
                        nlineaope = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 13++-+-+++-+-+-+-+nlineaope:"+nlineaope);
                        break;

                    case 14:
                        descripcion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 14++-+-+++-+-+-+-+descripcion:"+descripcion);
                        break;
                    case 15:
                        comentario = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 15++-+-+++-+-+-+-+comentario:"+comentario);
                        break;

                }// Fin switch (Columna)
                }//{} Fin (rowCount ==15)
            }//{} FIN (Cell cell : row)


            //Catidad de columnas (sin garantía)
            int cellCount = row.getLastCellNum() - row.getFirstCellNum();
            System.out.println("-----****************-----SEGUIMOS EN LA fila que tiene:"+ cellCount + " Columnas con data");
            if(cellCount == 16) {


                //TAB Datos Generales
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegTituloValorUi.TAB_DATOS_GENERALES, isEnabled()).forNoMoreThan(60).seconds(),
                        Click.on(RegTituloValorUi.TAB_DATOS_GENERALES),
                        WaitUntil.the(RegTituloValorUi.TXT_CU, isVisible()).forNoMoreThan(30).seconds()
                );
                //Thread.sleep(3000);

                //Inicio llenado campos
                //Código Unico - cu
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegTituloValorUi.TXT_CU, isEnabled()).forNoMoreThan(60).seconds(),
                        Enter.keyValues(Keys.HOME).into(RegTituloValorUi.TXT_CU),
                        Enter.theValue(cu).into(RegTituloValorUi.TXT_CU),
                        Enter.keyValues(Keys.END).into(RegTituloValorUi.TXT_CU),
                        Enter.keyValues(Keys.ENTER).into(RegTituloValorUi.TXT_CU)
                );


                //Espera a que mensaje "Cargando" no sea visible
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegTituloValorUi.Pop_Modal, isNotCurrentlyVisible()).forNoMoreThan(30).seconds()
                );
                //Graba mensaje cuando CU no existe
                String nombreracsoc;
                nombreracsoc = RegTituloValorUi.TXT_NOMBRERAZONSOC.resolveFor(theActorInTheSpotlight()).getValue();
                System.out.println("....El NOmbre o razón social es:"+nombreracsoc);

                if ((nombreracsoc == null) || (nombreracsoc.equals("")) ){
                    System.out.println("................................CU no existe!!!");
                    AlertAccept.Valida_CU_TituloValor(Fila, cellCount);
                    Fin = "Si";
                }

                if (Fin == "No")
                {

                //Tienda - tienda
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegTituloValorUi.Pop_Modal, isNotCurrentlyVisible()).forNoMoreThan(30).seconds(),
                        Click.on(RegTituloValorUi.TXT_TIENDA),
                        Enter.keyValues(Keys.HOME).into(RegTituloValorUi.TXT_TIENDA),
                        Enter.keyValues(String.valueOf(tienda)).into(RegTituloValorUi.TXT_TIENDA)
                );
                RegTituloValorUi.TXT_TIENDA.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.ENTER);

                //Código de Documento  - coddocumento
                if (coddocumento.equals("CERTIFICADO DEPOSITO NO NEGO")){
                    System.out.println("Codigo documento: CERTIFICADO DEPOSITO NO NEGO");
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(coddocumento).from(RegTituloValorUi.CBO_CODDOCU)
                    );
                    Thread.sleep(3000);
                }



                //Tipo de Documento  - tdocumento
                    //Se carga por defecto CERTIFICADO BANCARIO Y tipo de documento CB-INTERBANK
                    // Ingresa cuando es distinto CERTIFICADO BANCARIO y CB_INTERBANK
                if ( (coddocumento.equals("CERTIFICADO BANCARIO")) && (!tdocumento.equals("CB-INTERBANK")) ){
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(tdocumento).from(RegTituloValorUi.CBO_TDOCU)
                    );
                    Thread.sleep(3000);
                }



                //Situación
                if (situacion.equals("NO CONFORME")) {
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(situacion).from(RegTituloValorUi.CBO_SITUACION),
                            WaitUntil.the(RegTituloValorUi.CBO_SITUACION, containsSelectOption(situacion)).forNoMoreThan(5).seconds()
                    );
                    Thread.sleep(3000);
                }


                //Número de Días
                int ndiasInt = (int) ndias; // Convert Double to Integer
                theActorInTheSpotlight().attemptsTo(
                        Enter.keyValues(String.valueOf(ndiasInt)).into(RegTituloValorUi.TXT_NUDIASAPRIORI)
                );
                Thread.sleep(1000);


                //Número de Valorado
                int nvaloradoInt = (int) nvalorado; // Convert Double to Integer
                theActorInTheSpotlight().attemptsTo(
                        Enter.keyValues(String.valueOf(nvaloradoInt)).into(RegTituloValorUi.TXT_NUMVALORADO)
                );
                    Thread.sleep(1000);

                //Sección Datos de la cuenta
                //Moneda de la cuenta
                if (monedacta.equals("Soles")) {
                    System.out.println("--------------------------------------------------Moneda CTA Soles");
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byIndex(1).from(RegTituloValorUi.CBO_MONEDA_CTA)
                    );
                }
                Thread.sleep(3000);

                //Oficina de cuenta
                int numoficinactaInt = (int) numoficinacta; // Convert Double to Integer
                theActorInTheSpotlight().attemptsTo(
                        Enter.keyValues(String.valueOf(numoficinactaInt)).into(RegTituloValorUi.TXT_NUMOFICINACTA),
                        WaitUntil.the(RegTituloValorUi.TXT_NUMOFICINACTA, isNotSelected()).forNoMoreThan(30).seconds()
                );
                Thread.sleep(3000);

                //Numero de cuenta
                    theActorInTheSpotlight().attemptsTo(
                        Enter.theValue(numerocta).into(RegTituloValorUi.TXT_NUMEROCTA),
                        Enter.keyValues(String.valueOf(Keys.HOME)).into(RegTituloValorUi.TXT_NUMEROCTA),
                        Enter.keyValues(String.valueOf(Keys.END)).into(RegTituloValorUi.TXT_NUMEROCTA),
                        Enter.keyValues(String.valueOf(Keys.ENTER)).into(RegTituloValorUi.TXT_NUMEROCTA)
                );
                Thread.sleep(3000);


               //Graba mensaje cuando cuenta no existe
/*               theActorInTheSpotlight().attemptsTo(
                        AlertAccept.CtaInvalid_TituloValor(Fila, cellCount)
                );
                Thread.sleep(7000);*/

                    //Código de Documento  - coddocumento
                    if (coddocumento.equals("CERTIFICADO DEPOSITO NO NEGO")){
                        System.out.println("Codigo documento: CERTIFICADO DEPOSITO NO NEGO");
                        Thread.sleep(2000);
                    }

                //Boton no visible cuando cuenta no existe
                if (!RegTituloValorUi.BTN_NVACTA.resolveFor(theActorInTheSpotlight()).isVisible()) {
                    System.out.println("cta no existe");
                    String GAC="";
                    GAC = "La cuenta es inválida / ya se encuentra registrada";
                    WriteXls.registro_TituloValor(Fila, cellCount, GAC);

                    Fin = "Si";
                    System.out.println("-----------Fin x cta no existe: " + Fin);
                }




                if (Fin == "No") {

                    //--------------------------------------------------------------------------------------------------
                    // TAB: Deuda Garantía
                    //--------------------------------------------------------------------------------------------------
                    Thread.sleep(3000);
                    theActorInTheSpotlight().attemptsTo(
                            Click.on(RegTituloValorUi.TABDEUDA)
                    );
                    Thread.sleep(5000);


                    if (tcobertura.endsWith("rica")) {
                        System.out.println("******************************************GENERICA****************************");
                        theActorInTheSpotlight().attemptsTo(
                                Click.on(RegTituloValorUi.LBLTIPOCOBERTURA),
                                Enter.keyValues(String.valueOf(Keys.DOWN)).into(RegTituloValorUi.LBLTIPOCOBERTURA),
                                Enter.keyValues(String.valueOf(Keys.RETURN)).into(RegTituloValorUi.LBLTIPOCOBERTURA)

                                //Enter.keyValues(String.valueOf(MouseEvent.BUTTON1)).into(AlertAccept.)
                                //RegTituloValorUi.CBO_TIPOCOBERTURA.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.RETURN)
                        );


                    } //Fin (tcobertura.endsWith("rica"))


                    //Thread.sleep(6000);


                    //CU Deudor
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegTituloValorUi.TXT_CUDEUDOR, isEnabled()).forNoMoreThan(30).seconds(),
                            Enter.theValue(cudeudor).into(RegTituloValorUi.TXT_CUDEUDOR)
                    );
                    RegTituloValorUi.TXT_CUDEUDOR.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.ENTER);
                    WaitUntil.the(RegTituloValorUi.TXT_CUDEUDOR, isNotCurrentlyEnabled()).forNoMoreThan(30).seconds();
                    Thread.sleep(5000);


                    if (tcobertura.contains("Especifica")) {
                        if (tlistado.contains("Operaciones")) {
                            System.out.println("**************************OPERACIONES****************************");
                            theActorInTheSpotlight().attemptsTo(
                                    Click.on(RegTituloValorUi.RBT_TLISTADOOPE)
                            );
                            Thread.sleep(3000);

                            theActorInTheSpotlight().attemptsTo(
                                    WaitUntil.the(RegTituloValorUi.LBL_OPE, containsText("Nro Operacion")).forNoMoreThan(40).seconds()
                            );
                            Thread.sleep(3000);


                            //split divide la cadena en base a separador ";"
                            for (String numope: nlineaope.split(";")) {
                                //reemplaza espacios vacíos
                                numope = numope.replace(" ","");

                           theActorInTheSpotlight().attemptsTo(
                                    WaitUntil.the(RegTituloValorUi.TXT_NROOPERACION, isEnabled()).forNoMoreThan(30).seconds(),
                                    Click.on(RegTituloValorUi.TXT_NROOPERACION),
                                    Enter.theValue(numope).into(RegTituloValorUi.TXT_NROOPERACION),
                                    Enter.keyValues(String.valueOf(Keys.HOME)).into(RegTituloValorUi.TXT_NROOPERACION),
                                    Enter.keyValues(String.valueOf(Keys.END)).into(RegTituloValorUi.TXT_NROOPERACION),
                                    Enter.keyValues(String.valueOf(Keys.TAB)).into(RegTituloValorUi.TXT_NROOPERACION),
                                    Enter.keyValues(String.valueOf(Keys.SPACE)).into(RegTituloValorUi.BTN_BUSCAROPE)
                                    //WaitUntil.the(RegTituloValorUi.TXT_NROOPERACION,containsText(nlineaope)).forNoMoreThan(30).seconds()
                            );

                                //Graba mensaje cuando operación no existe
                                theActorInTheSpotlight().attemptsTo(
                                        AlertAccept.OpeLinInvalid_TituloValor(Fila, cellCount)
                                );

                                //TXT_NROOPERACION contiene (muestra) numope cuando no existe la operación, entonces termina sin GAC
                                if (RegTituloValorUi.TXT_NROOPERACION.resolveFor(theActorInTheSpotlight()).containsValue(numope)) {
                                    System.out.println("ope no existe");
                                    Fin = "Si";
                                    System.out.println("-----------Fin ope no existe" + Fin);
                                }
                                System.out.println(numope.replace(" ",""));
                            }


                        } // Fin (tlistado.contains("Operaciones"))


                        else if (tlistado.contains("Lineas")) {
                            System.out.println("******************************************LINEAS****************************");
                            theActorInTheSpotlight().attemptsTo(
                                    Click.on(RegTituloValorUi.RBT_TLISTADOLINEA)
                            );

                            //split divide la cadena en base a separador ";"
                            for (String numlin: nlineaope.split(";")) {
                                //reemplaza espacios vacíos
                                numlin = numlin.replace(" ", "");

                                theActorInTheSpotlight().attemptsTo(
                                        WaitUntil.the(RegTituloValorUi.TXT_NROOPERACION, isEnabled()).forNoMoreThan(30).seconds(),
                                        Click.on(RegTituloValorUi.TXT_NROOPERACION),
                                        Enter.theValue(numlin).into(RegTituloValorUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.HOME)).into(RegTituloValorUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.END)).into(RegTituloValorUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.TAB)).into(RegTituloValorUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.SPACE)).into(RegTituloValorUi.BTN_BUSCAROPE)
                                );
                                //Thread.sleep(5000);

                                //Graba mensaje cuando línea no existe
                                theActorInTheSpotlight().attemptsTo(
                                        AlertAccept.OpeLinInvalid_TituloValor(Fila, cellCount)
                                );
                                //Thread.sleep(6000);

                                //Lectura de Excel con último mensaje grabado (cuando linea no existe)
                                //Se hace esto por que cuando la línea no existe igual se borra del campo TXT_NROOPERACION (opuesto a comportamiento de operaciones)
                                Cell grabado;
                                Sheet sheet2 = LoadXls.getSheet_TituloValor(0, "Data-TituloValor.xlsx");
                                grabado = sheet2.getRow(Fila).getCell(cellCount);
                                System.out.println("mensaje:" + grabado);

                                if (grabado != null) { //cuando contiene mensaje grabado (línea no existe)
                                    System.out.println("Lines no existe");
                                    Fin = "Si";
                                    System.out.println("-----------Fin - Línea no existe" + Fin);
                                }
                                System.out.println(numlin.replace(" ",""));
                            }
                            Thread.sleep(2000);
                            System.out.println("Fin de FOR nlineaope ");
                        } // Fin (tlistado.contains("Lineas"))

                    } // Fin (tcobertura.contains("Especifica"))
                    Thread.sleep(3000);
                }
            }


                if (Fin == "No")
                {

                    //--------------------------------------------------------------------------------------------------
                    // TAB: Deuda Garantía
                    //--------------------------------------------------------------------------------------------------
                    theActorInTheSpotlight().attemptsTo(
                            Click.on(RegTituloValorUi.TAB_DESCRIPCION)
                    );
                    Thread.sleep(3000);

                    //Descripción
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(descripcion).into(RegTituloValorUi.TXT_DESCRIPCION)
                    );

                    //Comentario
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(comentario).into(RegTituloValorUi.TXT_COMENTARIO)
                    );
                    Thread.sleep(1000);





                    //--------------------------------------------------------------------------------------------------
                    // REGISTRAR GARANTIA
                    //--------------------------------------------------------------------------------------------------
                    RegTituloValorUi.BTN_REGISTRAR.resolveFor(theActorInTheSpotlight()).click();
                    keyEventMask = FocusEvent.KEY_EVENT_MASK;
                    theActorInTheSpotlight().attemptsTo(
                            AlertAccept.Aceptar_TituloValor(Fila,cellCount, Fila)
                    );
                    Thread.sleep(2000);

                    //Fin llenado campos
                    new motoresdebusqueda.gac.stepdefinitions.titulovalor.GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_garantía_Titulo_Valor();
                }

                if (Fin == "Si") {
                    System.out.println("-----------Fin - ejecucion por errores");
                    new GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_garantía_Titulo_Valor();
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

