package starter.stepdefinitions.Fianzasolidaria;

import io.cucumber.java.es.Entonces;
import motoresdebusqueda.gac.page.fianzasolidaria.RegFianzaSolidariaUi;
import motoresdebusqueda.gac.util.alert.AlertAccept;
import motoresdebusqueda.gac.util.date.DatePicker;
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
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RegFianzaSolidariaStepDefinitions {

    private Object IsNotEnabledMatcher;
    private long keyEventMask;
    private static WebDriver driver;

@Entonces("se genera nueva Garantia Fianza Solidaria")
public void se_genera_nueva_Garantia_Fianza_Solidaria() throws InterruptedException {

    try {
        Sheet sheet = LoadXls.getSheet_FianzaSolidaria(0, "Data-FianzaSolidaria.xlsx");
        //TAB: Datos de la Garantía
        String cu;
        double tienda;
        String moneda;
        String tdocumento;
        String situacion;
        double ndias;
        double monto;
        double kardex;
        String notaria;
        double partidaregistral;
        String tipocontrato;
        String asiento;
        String fecdeclaracion;
        double decpatrimonial;
        String tipoplaza;
        String covenants;
        String numcredito;
        String cufiador;


        //TAB: DEUDA GARANTIA
        String tcobertura;
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
            tdocumento="";
            moneda="";
            situacion="";
            ndias = 0;
            monto=0;
            kardex=0;
            notaria="";
            partidaregistral=0;
            tipocontrato="";
            asiento="";
            fecdeclaracion="";
            decpatrimonial=0;
            tipoplaza="";
            covenants="";
            numcredito="";
            cufiador="";


            //TAB: DEUDA GARANTIA
            tcobertura ="";
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
                if (cellCount ==23) {
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
                        tdocumento = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 2++-+-+++-+-+-+-+tdocumento:"+tdocumento);
                        break;
                    case 3:
                        moneda = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 3++-+-+++-+-+-+-+Moneda:"+moneda);
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
                        monto = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 6++-+-+++-+-+-+-+monto:"+monto);
                        break;
                    case 7:
                        kardex = cell.getNumericCellValue();
                        int kardexInt = (int)kardex; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 7++-+-+++-+-+-+-+Kardex:"+kardexInt);
                        break;
                    case 8:
                        notaria = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 8++-+-+++-+-+-+-+Notaria:"+notaria);
                        break;
                    case 9:
                        partidaregistral = cell.getNumericCellValue();
                        int partidaregistralInt = (int)partidaregistral; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 9++-+-+++-+-+-+-+partida registral:"+partidaregistralInt);
                        break;
                    case 10:
                        tipocontrato= cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 10++-+-+++-+-+-+-+Tipo de Contrato:"+tipocontrato);
                        break;
                    case 11:
                        asiento = cell.getStringCellValue();
                        //int numeroctaInt = (int)numerocta; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 11++-+-+++-+-+-+-+Asiento:" +asiento);
                        break;
                    case 12:
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //SimpleDateFormat
                        fecdeclaracion = dateFormat.format(cell.getDateCellValue());
                        System.out.println("-++++-+++-++++-Columna 12++-+-+++-+-+-+-+Fecha Declaracion:"+ fecdeclaracion);
                        break;
                    case 13:
                        decpatrimonial = cell.getNumericCellValue();
                        int decpatrimonialInt = (int)decpatrimonial; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 13++-+-+++-+-+-+-+Declaracion Patrimonial:"+decpatrimonialInt);
                        break;
                    case 14:
                        tipoplaza = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 14++-+-+++-+-+-+-+Tipo de Plaza:" +tipoplaza);
                        break;
                    case 15:
                        covenants = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 15++-+-+++-+-+-+-+Covenants:" +covenants);
                        break;
                    case 16:
                        numcredito = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 16++-+-+++-+-+-+-+Numero de Credito:" +numcredito);
                        break;
                    case 17:
                        cufiador = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 17++-+-+++-+-+-+-+CU Fiador:" +cufiador);
                        break;

                    //TAB Deuda Garantía
                    case 18:
                        tcobertura = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 18++-+-+++-+-+-+-+tcobertura:"+tcobertura);
                        break;
                    case 19:
                        tlistado = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 19++-+-+++-+-+-+-+tlistado:"+tlistado);
                        break;
                    case 20:
                        nlineaope = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 20++-+-+++-+-+-+-+nlineaope:"+nlineaope);
                        break;

                    case 21:
                        descripcion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 21++-+-+++-+-+-+-+descripcion:"+descripcion);
                        break;
                    case 22:
                        comentario = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 22++-+-+++-+-+-+-+comentario:"+comentario);
                        break;

                }// Fin switch (Columna)
                }//{} Fin (rowCount ==15)
            }//{} FIN (Cell cell : row)


            //Catidad de columnas (sin garantía)
            int cellCount = row.getLastCellNum() - row.getFirstCellNum();
            System.out.println("-----****************-----SEGUIMOS EN LA fila que tiene:"+ cellCount + " Columnas con data");
            if(cellCount == 23) {


                //TAB Datos Generales
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegFianzaSolidariaUi.TAB_DATOS_GENERALES, isEnabled()).forNoMoreThan(60).seconds(),
                        Click.on(RegFianzaSolidariaUi.TAB_DATOS_GENERALES),
                        WaitUntil.the(RegFianzaSolidariaUi.TXT_CU, isVisible()).forNoMoreThan(30).seconds()
                );
                //Thread.sleep(3000);

                //Inicio llenado campos
                //Código Unico - cu
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegFianzaSolidariaUi.TXT_CU, isEnabled()).forNoMoreThan(60).seconds(),
                        Enter.keyValues(Keys.HOME).into(RegFianzaSolidariaUi.TXT_CU),
                        Enter.theValue(cu).into(RegFianzaSolidariaUi.TXT_CU),
                        Enter.keyValues(Keys.END).into(RegFianzaSolidariaUi.TXT_CU),
                        Enter.keyValues(Keys.ENTER).into(RegFianzaSolidariaUi.TXT_CU)
                );


                //Espera a que mensaje "Cargando" no sea visible
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegFianzaSolidariaUi.Pop_Modal, isNotCurrentlyVisible()).forNoMoreThan(30).seconds()
                );
                //Graba mensaje cuando CU no existe
                String nombreracsoc;
                nombreracsoc = RegFianzaSolidariaUi.TXT_NOMBRERAZONSOC.resolveFor(theActorInTheSpotlight()).getValue();
                System.out.println("....El NOmbre o razón social es:"+nombreracsoc);

                if ((nombreracsoc == null) || (nombreracsoc.equals("")) ){
                    System.out.println("................................CU no existe!!!");
                    AlertAccept.Valida_CU_FianzaSolidaria(Fila, cellCount);
                    Fin = "Si";
                }

                if (Fin == "No")
                {

                //Tienda - tienda
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegFianzaSolidariaUi.Pop_Modal, isNotCurrentlyVisible()).forNoMoreThan(30).seconds(),
                        //Edge Version
                        /*Click.on(RegFianzaSolidariaUi.TXT_TIENDA),
                        Enter.keyValues(Keys.HOME).into(RegFianzaSolidariaUi.TXT_TIENDA),*/
                        Enter.keyValues(String.valueOf(tienda)).into(RegFianzaSolidariaUi.TXT_TIENDA)
                );
                RegFianzaSolidariaUi.TXT_TIENDA.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.ENTER);



                //Tipo de Documento  - tdocumento
                    //Carga por defecto: CON DEPOSITO
                if (tdocumento.equals("CONTRATO DE FIANZA SOLIDARIA")) {
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(tdocumento).from(RegFianzaSolidariaUi.CBO_TDOCU)
                    );
                    Thread.sleep(1000);
                }

                //Moneda
                    //por defecto carga moneda: dolar
                if (moneda.equals("Soles")){
                    System.out.println("--------------------------------------------------Moneda Soles");
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegFianzaSolidariaUi.CBO_TDOCU,isNotSelected()).forNoMoreThan(30).seconds(),
                            SelectFromOptions.byIndex(1).from(RegFianzaSolidariaUi.CBO_MONEDA)
                    );
                }
                Thread.sleep(5000);


                //Situación
                if (situacion.equals("NO CONFORME")) {
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(situacion).from(RegFianzaSolidariaUi.CBO_SITUACION),
                            WaitUntil.the(RegFianzaSolidariaUi.CBO_SITUACION, containsSelectOption(situacion)).forNoMoreThan(5).seconds()
                    );
                    Thread.sleep(3000);
                }


                //Número de Días
                int ndiasInt = (int) ndias; // Convert Double to Integer
                theActorInTheSpotlight().attemptsTo(
                        Enter.keyValues(String.valueOf(ndiasInt)).into(RegFianzaSolidariaUi.TXT_NRODIAS)
                );
                Thread.sleep(1000);


                //Monto
                theActorInTheSpotlight().attemptsTo(
                        Enter.keyValues(String.valueOf(monto)).into(RegFianzaSolidariaUi.TXT_MONTO)
                );


                if (tdocumento.equals("CONTRATO DE FIANZA SOLIDARIA")) {
                    //Kardex
                    int kardexInt = (int)kardex; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(kardexInt)).into(RegFianzaSolidariaUi.TXT_KARDEX),
                            WaitUntil.the(RegFianzaSolidariaUi.TXT_KARDEX,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    //Thread.sleep(3000);

                    //Notaria
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(notaria).into(RegFianzaSolidariaUi.TXT_NOTARIA),
                            WaitUntil.the(RegFianzaSolidariaUi.TXT_NOTARIA,isNotSelected()).forNoMoreThan(5).seconds()
                    );
                    //Thread.sleep(3000);
                }


                //Ficha / Partida registral
                int partidaregistralInt = (int) partidaregistral; // Convert Double to Integer
                theActorInTheSpotlight().attemptsTo(
                        Enter.keyValues(String.valueOf(partidaregistralInt)).into(RegFianzaSolidariaUi.TXT_FICHAPARTIDAREG)
                );
                //  Thread.sleep(1000);



                //Tipo Contrato
                if (!tipocontrato.equals("Contrato de Otorgamiento")) {
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(tipocontrato).from(RegFianzaSolidariaUi.CBO_TIPOCONTRATO)
                    );
                    Thread.sleep(3000);
                }



                //Asiento
                theActorInTheSpotlight().attemptsTo(
                        Enter.theValue(asiento).into(RegFianzaSolidariaUi.TXT_ASIENTO)
                );


                //Fecha Declaración Patrimonial
                    //Se elimina slash "/" del formato de fecha
                    String fec = fecdeclaracion.replace("/", "");
                    System.out.println("fecha nuevo formato :" + fec);

/*                    //13032022
                    String dia = fec.substring(0, 2);
                    String mes = fec.substring(2, 4);
                    String anno= fec.substring(fec.length()-4);
*/

                theActorInTheSpotlight().attemptsTo(
                        //Edge version
                      /*  Click.on(RegFianzaSolidariaUi.TXT_FECHADECPAT),
                        Enter.keyValues(String.valueOf(Keys.HOME)).into(RegFianzaSolidariaUi.TXT_FECHADECPAT),*/
                        //Enter.keyValues(fec).into(RegFianzaSolidariaUi.TXT_FECHADECPAT)
                        Click.on(RegFianzaSolidariaUi.CAL_FECDECPATRIMONIAL)
                );
                Thread.sleep(2000);

                theActorInTheSpotlight().attemptsTo(
                              DatePicker.Fecha_Dec_Pat(fecdeclaracion)
                );
                Thread.sleep(2000);



                //Declaración Patrimonial
                int decpatrimonialInt = (int) decpatrimonial; // Convert Double to Integer
                theActorInTheSpotlight().attemptsTo(
                        Enter.keyValues(String.valueOf(decpatrimonialInt)).into(RegFianzaSolidariaUi.TXT_DECPATRIMONIAL)
                );


                //Tipo de Plaza
                theActorInTheSpotlight().attemptsTo(
                        SelectFromOptions.byVisibleText(tipoplaza).from(RegFianzaSolidariaUi.CBO_TIPOPLAZA)
                );
                Thread.sleep(3000);


                //Covenants
                theActorInTheSpotlight().attemptsTo(
                        Enter.theValue(covenants).into(RegFianzaSolidariaUi.TXT_COVENANTS)
                );


                //Número de Crédito
                theActorInTheSpotlight().attemptsTo(
                        Enter.theValue(numcredito).into(RegFianzaSolidariaUi.TXT_NUMCREDITO)
                );


                //Código Unico de Fiador
                    //split divide la cadena en base a separador ";"
                for (String cadena: cufiador.split(";")) {
                    //reemplaza espacios vacíos
                    cadena = cadena.replace(" ","");

                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(cadena).into(RegFianzaSolidariaUi.TXT_CUFIADOR),
                            Enter.keyValues(Keys.ENTER).into(RegFianzaSolidariaUi.TXT_CUFIADOR)
                    );
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegFianzaSolidariaUi.Pop_Modal, isNotCurrentlyVisible()).forNoMoreThan(30).seconds()
                    );

                    //Graba mensaje cuando CU Fiador no existe
                    String fiador;
                    fiador = RegFianzaSolidariaUi.TXT_NOMBRERAZSOCFIADOR.resolveFor(theActorInTheSpotlight()).getValue();
                    System.out.println("....El NOmbre o razón social del fiador es:"+fiador);

                    if ((fiador == null) || (fiador.equals("")) ){
                        System.out.println("................................Fiador no existe!!!");
                        AlertAccept.Valida_CU_FianzaSolidaria(Fila, cellCount);
                        Fin = "Si";
                    }
                    else{
                        System.out.println("................................Fiador Si Existe!!!");
                        theActorInTheSpotlight().attemptsTo(
                                Click.on(RegFianzaSolidariaUi.BTN_AGREGAR)
                        );

                    }
                    Thread.sleep(5000);

                    System.out.println(cadena.replace(" ",""));
                }




                if (Fin == "No") {

                    //--------------------------------------------------------------------------------------------------
                    // TAB: Deuda Garantía
                    //--------------------------------------------------------------------------------------------------
                    Thread.sleep(3000);
                    theActorInTheSpotlight().attemptsTo(
                            Click.on(RegFianzaSolidariaUi.TABDEUDA)
                    );
                    Thread.sleep(5000);


                    if (tcobertura.endsWith("rica")) {
                        System.out.println("******************************************GENERICA****************************");
                        theActorInTheSpotlight().attemptsTo(
                                Click.on(RegFianzaSolidariaUi.LBLTIPOCOBERTURA),
                                Enter.keyValues(String.valueOf(Keys.DOWN)).into(RegFianzaSolidariaUi.LBLTIPOCOBERTURA),
                                Enter.keyValues(String.valueOf(Keys.TAB)).into(RegFianzaSolidariaUi.LBLTIPOCOBERTURA)
                        );


                    } //Fin (tcobertura.endsWith("rica"))



                    if (tcobertura.contains("Especifica")) {
                        if (tlistado.contains("Operaciones")) {
                            System.out.println("**************************OPERACIONES****************************");
                            theActorInTheSpotlight().attemptsTo(
                                    Click.on(RegFianzaSolidariaUi.RBT_TLISTADOOPE)
                            );
                            Thread.sleep(3000);

                            theActorInTheSpotlight().attemptsTo(
                                    WaitUntil.the(RegFianzaSolidariaUi.LBL_OPE, containsText("Nro Operacion")).forNoMoreThan(40).seconds()
                            );
                            Thread.sleep(3000);


                            //split divide la cadena en base a separador ";"
                            for (String numope: nlineaope.split(";")) {
                                //reemplaza espacios vacíos
                                numope = numope.replace(" ","");

                                theActorInTheSpotlight().attemptsTo(
                                        WaitUntil.the(RegFianzaSolidariaUi.TXT_NROOPERACION, isEnabled()).forNoMoreThan(30).seconds(),
                                        Click.on(RegFianzaSolidariaUi.TXT_NROOPERACION),
                                        Enter.theValue(numope).into(RegFianzaSolidariaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.HOME)).into(RegFianzaSolidariaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.END)).into(RegFianzaSolidariaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.TAB)).into(RegFianzaSolidariaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.SPACE)).into(RegFianzaSolidariaUi.BTN_BUSCAROPE)
                                );

                                //Graba mensaje cuando operación no existe
                                theActorInTheSpotlight().attemptsTo(
                                        AlertAccept.OpeLinInvalid_FianzaSolidaria(Fila, cellCount)
                                );

                                //TXT_NROOPERACION contiene (muestra) numope cuando no existe la operación, entonces termina sin GAC
                                if (RegFianzaSolidariaUi.TXT_NROOPERACION.resolveFor(theActorInTheSpotlight()).containsValue(numope)) {
                                    System.out.println("ope no existe");
                                    Fin = "Si";
                                    System.out.println("-----------Fin ope no existe: " + Fin);
                                }

                                System.out.println(numope.replace(" ",""));
                            }

                        } // Fin (tlistado.contains("Operaciones"))


                        else if (tlistado.contains("Lineas")) {
                            System.out.println("******************************************LINEAS****************************");
                           theActorInTheSpotlight().attemptsTo(
                                    Click.on(RegFianzaSolidariaUi.RBT_TLISTADOLINEA)
                            );

                            //split divide la cadena en base a separador ";"
                            for (String numlin: nlineaope.split(";")) {
                                //reemplaza espacios vacíos
                                numlin = numlin.replace(" ","");

                                theActorInTheSpotlight().attemptsTo(
                                        WaitUntil.the(RegFianzaSolidariaUi.TXT_NROOPERACION, isEnabled()).forNoMoreThan(30).seconds(),
                                        Click.on(RegFianzaSolidariaUi.TXT_NROOPERACION),
                                        Enter.theValue(numlin).into(RegFianzaSolidariaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.HOME)).into(RegFianzaSolidariaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.END)).into(RegFianzaSolidariaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.TAB)).into(RegFianzaSolidariaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.SPACE)).into(RegFianzaSolidariaUi.BTN_BUSCAROPE)
                                );

                                //Graba mensaje cuando operación no existe
                                theActorInTheSpotlight().attemptsTo(
                                        AlertAccept.OpeLinInvalid_FianzaSolidaria(Fila, cellCount)
                                );

                                //Lectura de Excel con último mensaje grabado (cuando linea no existe)
                                //Se hace esto por que cuando la línea no existe igual se borra del campo TXT_NROOPERACION (opuesto a comportamiento de operaciones)
                                Cell grabado;
                                Sheet sheet2 = LoadXls.getSheet_FianzaSolidaria(0, "Data-FianzaSolidaria.xlsx");
                                grabado = sheet2.getRow(Fila).getCell(cellCount);
                                System.out.println("mensaje:" + grabado);

                                if (grabado != null) { //cuando contiene mensaje grabado (línea no existe)
                                    System.out.println("Lines no existe");
                                    Fin = "Si";
                                    System.out.println("-----------Fin - Línea no existe" + Fin);
                                }

                                System.out.println(numlin.replace(" ",""));
                            }


                        } // Fin (tlistado.contains("Lineas"))
                    } // Fin (tcobertura.contains("Especifica"))
                    Thread.sleep(3000);
                }
            }


                if (Fin == "No")
                {

                    //--------------------------------------------------------------------------------------------------
                    // TAB: Descripción
                    //--------------------------------------------------------------------------------------------------
                    theActorInTheSpotlight().attemptsTo(
                            Click.on(RegFianzaSolidariaUi.TAB_DESCRIPCION)
                    );
                    Thread.sleep(3000);

                    //Descripción
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(descripcion).into(RegFianzaSolidariaUi.TXT_DESCRIPCION)
                    );

                    //Comentario
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(comentario).into(RegFianzaSolidariaUi.TXT_COMENTARIO)
                    );
                    Thread.sleep(1000);





                    //--------------------------------------------------------------------------------------------------
                    // REGISTRAR GARANTIA
                    //--------------------------------------------------------------------------------------------------
                    RegFianzaSolidariaUi.BTN_REGISTRAR.resolveFor(theActorInTheSpotlight()).click();
                    keyEventMask = FocusEvent.KEY_EVENT_MASK;
                    theActorInTheSpotlight().attemptsTo(
                            AlertAccept.Aceptar_FianzaSolidaria(Fila,cellCount, Fila)
                    );
                    Thread.sleep(2000);

                    //Fin llenado campos
                    new motoresdebusqueda.gac.stepdefinitions.Fianzasolidaria.GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_garantía_Fianza_Solidaria();

                }

                if (Fin == "Si") {
                    System.out.println("-----------Fin - ejecucion por errores");
                    new GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_garantía_Fianza_Solidaria();
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

