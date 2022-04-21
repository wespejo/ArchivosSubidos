package starter.stepdefinitions.standby;

import io.cucumber.java.es.Entonces;
import motoresdebusqueda.gac.page.standby.RegStandByUi;
import motoresdebusqueda.gac.stepdefinitions.cartafianza.GACMenuPrincipalStepDefinitions;
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
import static net.serenitybdd.screenplay.actions.Enter.theValue;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

//

public class RegStandByStepDefinitions {

    private Object IsNotEnabledMatcher;
    private long keyEventMask;


    @Entonces("se genera nueva Garantia Stand By")
    public void se_genera_nueva_garantia_stand_by() {

        try {
            Sheet sheet = LoadXls.getSheet_StandBy(0, "Data-Stand_By.xlsx");
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
            String comentario;
            String Fin;

            String rango;
            String situacion;
            String modeloibk;
            String vblegal;
            String banco;
            String lineabanco;
            String pendiente;
            String toperacion;


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
                comentario = "";
                Fin = "No";


                rango = "";
                situacion = "";
                modeloibk = "";
                vblegal = "";
                banco = "";
                lineabanco = "";
                pendiente = "";
                toperacion = "";
                //data.put(i, new ArrayList<>());
                for (Cell cell : row) {
                    System.out.print(" | ");

                    Fila = cell.getRowIndex();
                    Columna = cell.getColumnIndex();

                    //Catidad de columnas (sin garantía)
                    int cellCount = row.getLastCellNum() - row.getFirstCellNum();
                    System.out.println("--------------------------------La fila tiene:" + cellCount + " Columnas con data");

                    System.out.println("Fila:" + Fila);
                    if (cellCount == 23) {
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
                                banco= cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 11++-+-+++-+-+-+-+banco:" + banco);
                                break;
                            case 11:
                                lineabanco= cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 12++-+-+++-+-+-+-+lineabanco:" + lineabanco);
                                break;
                            case 12:
                                ndocu = cell.getNumericCellValue();
                                int ndocuInt = (int)ndocu; // Convert Double to Integer
                                System.out.println("-++++-+++-++++-Columna 13++-+-+++-+-+-+-+ndocu:"+ndocuInt);
                                break;
                            case 13:
                                porcentaje = cell.getNumericCellValue();
                                int porcentajeInt = (int)porcentaje; // Convert Double to Integer*/
                                System.out.println("-++++-+++-++++-Columna 14++-+-+++-+-+-+-+porcentaje:"+porcentajeInt);
                                break;
                            case 14:
                                importe = cell.getNumericCellValue();
                                System.out.println("-++++-+++-++++-Columna 15++-+-+++-+-+-+-+importe:" + importe);
                                break;

                            case 15:
                                tcobertura = cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 9++-+-+++-+-+-+-+tcobertura:" + tcobertura);
                                break;
                            case 16:
                                cudeudor = cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 10++-+-+++-+-+-+-+cudeudor:" + cudeudor);
                                break;
                            case 17:
                                pendiente= cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 18++-+-+++-+-+-+-+pendiente:" + pendiente);
                                break;
                            case 18:
                                toperacion = cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 19++-+-+++-+-+-+-+toperacion:" + toperacion);
                                break;
                            case 19:
                                tlistado = cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 20++-+-+++-+-+-+-+tlistado:" + tlistado);
                                break;
                            case 20:
                                nlineaope = cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 21++-+-+++-+-+-+-+nlineaope:" + nlineaope);
                                break;
                            case 21:
                                descripcion = cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 22++-+-+++-+-+-+-+descripcion:" + descripcion);
                                break;
                            case 22:
                                comentario = cell.getStringCellValue();
                                System.out.println("-++++-+++-++++-Columna 23++-+-+++-+-+-+-+comentario:" + comentario);
                                break;
                        }// Fin switch (Columna)
                    }//{} Fin (rowCount ==15)
                }//{} FIN (Cell cell : row)

                //data.put(i, datosFila);
                //System.out.println("-------------------La fila actual es:"+i);

                //Catidad de columnas (sin garantía)
                int cellCount = row.getLastCellNum() - row.getFirstCellNum();
                System.out.println("-----****************-----SEGUIMOS EN LA fila que tiene:" + cellCount + " Columnas con data");
                if (cellCount == 23) {
                    //Inicio llenado campos
                    //Código Unico - cu
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegStandByUi.TXT_CU, isEnabled()).forNoMoreThan(60).seconds(),
                            keyValues(Keys.HOME).into(RegStandByUi.TXT_CU),
                            Enter.theValue(cu).into(RegStandByUi.TXT_CU),
                            keyValues(Keys.END).into(RegStandByUi.TXT_CU),
                            keyValues(Keys.ENTER).into(RegStandByUi.TXT_CU)
                    );


                    //Espera a que mensaje "Cargando" no sea visible
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegStandByUi.Pop_Modal, isNotCurrentlyVisible()).forNoMoreThan(30).seconds()
                    );


                    //Graba mensaje cuando CU no existe
                    String nombreracsoc;
                    nombreracsoc = RegStandByUi.TXT_NOMBRERAZONSOC.resolveFor(theActorInTheSpotlight()).getValue();
                    System.out.println("....El NOmbre o razón social es:" + nombreracsoc);

                    if ((nombreracsoc == null) || (nombreracsoc.equals(""))) {
                        System.out.println("................................CU no existe!!!");
                        AlertAccept.Valida_CU_StandBy(Fila, cellCount);
                        Fin = "Si";
                    }

                    if (Fin == "No") {
                        //Tienda - tienda
                        theActorInTheSpotlight().attemptsTo(
                                WaitUntil.the(RegStandByUi.Pop_Modal, isNotCurrentlyVisible()).forNoMoreThan(20).seconds(),
                                Click.on(RegStandByUi.TXT_TIENDA),
                                keyValues(Keys.HOME).into(RegStandByUi.TXT_TIENDA),
                                keyValues(String.valueOf(tienda)).into(RegStandByUi.TXT_TIENDA)
                        );
                        RegStandByUi.TXT_TIENDA.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.ENTER);
                        theActorInTheSpotlight().attemptsTo(
                                WaitUntil.the(RegStandByUi.TXT_TIENDA, isNotSelected()).forNoMoreThan(30).seconds()
                        );

                        //Tipo de Documento  - default SBY-INTERBANK
                        if (!tdocumento.contains("SBY-INTERBANK")) {
                            theActorInTheSpotlight().attemptsTo(
                                    SelectFromOptions.byVisibleText(tdocumento).from(RegStandByUi.CBO_TDOCU)
                            );
                            Thread.sleep(1000);
                        }
                        System.out.println("pasó tipo documento");


                        //Rango - Default RANGO 1
                        if (!rango.contains("RANGO 1")) {
                            theActorInTheSpotlight().attemptsTo(
                                    SelectFromOptions.byVisibleText(rango).from(RegStandByUi.CBO_RANGO),
                                    WaitUntil.the(RegStandByUi.CBO_BANCO, isNotSelected()).forNoMoreThan(30).seconds()
                            );
                            Thread.sleep(2000);
                        }
                        System.out.println("paso Rango");

                        //Moneda -  default Dolar
                        if (moneda.equals("Soles")) {
                            System.out.println("--------------------------------------------------Moneda Soles");
                            theActorInTheSpotlight().attemptsTo(
                                    //WaitUntil.the(RegStandByUi.CBO_RANGO, isNotSelected()).forNoMoreThan(30).seconds(),
                                    SelectFromOptions.byVisibleText("Soles").from(RegStandByUi.CBO_MONEDA)
                            );
                        }

                        System.out.println("pasó moneda");


                        //Fecha de Vencimiento
                        theActorInTheSpotlight().attemptsTo(
                                WaitUntil.the(RegStandByUi.CBO_TDOCU, isNotSelected()).forNoMoreThan(30).seconds(),
                                Enter.theValue(fecvencimiento).into(RegStandByUi.TXT_FECHA)
                        );
                        System.out.println("pasó fecha de vencimiento");

                        //Situación - default CONFORME
                        if (situacion.contains("NO CONFORME")) {
                            theActorInTheSpotlight().attemptsTo(
                                    SelectFromOptions.byVisibleText(situacion).from(RegStandByUi.CBO_SITUACION)
                            );
                        }
                        System.out.println("pasó situación");


                        //Número de días
                        int ndiasInt = (int) ndias; // Convert Double to Integer
                        theActorInTheSpotlight().attemptsTo(
                                keyValues(String.valueOf(ndiasInt)).into(RegStandByUi.TXT_NDIAS)
                        );
                        Thread.sleep(1000);
                        System.out.println("pasó Num Días");


                        //Datos Específicos
                        //Modelo IBK
                        if (modeloibk.equals("Si")) {
                            System.out.println("modelo ibk ... con check");
                            theActorInTheSpotlight().attemptsTo(
                                    Click.on(RegStandByUi.CHK_MODIBK)
                            );
                        }
                        System.out.println("PASÓ modelo IBK");

                        //Porcentaje
                        int porcentajeInt = (int) porcentaje; // Convert Double to Integer
                        theActorInTheSpotlight().attemptsTo(
                                keyValues(String.valueOf(porcentajeInt)).into(RegStandByUi.TXT_PORCENTAJE)
                        );
                        System.out.println("Pasó %");





                        //Banco
                        theActorInTheSpotlight().attemptsTo(
                                SelectFromOptions.byVisibleText(banco).from(RegStandByUi.CBO_BANCO)
                                //WaitUntil.the(RegStandByUi.CBO_LINEABANCO,containsText(lineabanco)).forNoMoreThan(29).seconds()
                                //Código precedente sirve cuando línea existe, cuando no existe se colocó tiempo "constante" de 26 segundos (ambos casos: existe  - no existe)
                        );
                        Thread.sleep(45000);//Línea Banco se muestra en 24 segundos aproximadamente
                        System.out.println("pasó banco:" + banco);



                        System.out.println("valor de variable ingresada:" + lineabanco);
                        String Lin_Text;  //Captura valor mostrado en el campo Línea asociada
                        Lin_Text = RegStandByUi.CBO_LINEABANCO.resolveFor(theActorInTheSpotlight()).getText();
                        System.out.println("Valor del combo línea banco:" + Lin_Text);

                        //Ingresa cuando existe Líneas Asoc. Al Banco
                          if (lineabanco.equals(Lin_Text)) {
                            System.out.println("Línea de banco existe");


                            theActorInTheSpotlight().attemptsTo(
                                    WaitUntil.the(RegStandByUi.CBO_LINEABANCO, isClickable()).forNoMoreThan(20).seconds(),
                                    SelectFromOptions.byVisibleText(lineabanco).from(RegStandByUi.CBO_LINEABANCO)
                            );

                            theActorInTheSpotlight().attemptsTo(
                                    WaitUntil.the(RegStandByUi.TXT_LINEABANCO, hasValue(lineabanco)).forNoMoreThan(10).seconds()
                            );
                            System.out.println("pasó línea de banco");

                        } else {
                              //Ingresa aqui cuando:
                              //1.- El banco no tiene líneas creadas
                              //2.- Línea ingresa (con error) es distinta a línea mostrada
                            System.out.println("ingresa aqui cuando línea banco no existe");
                            AlertAccept.Valida_Lin_Asoc_Bco(Fila, cellCount);
                            Fin = "Si";
                            Thread.sleep(3000);

                        }

                        if (Fin == "No") {
                        // VB Legal
                        if (vblegal.equals("Si")) {
                            System.out.println("Vb Legal ...con check");
                            theActorInTheSpotlight().attemptsTo(
                                    Click.on(RegStandByUi.CHK_VBLEGAL)
                            );
                        }

                        //Número de Documento
                        int ndocuInt = (int) ndocu; // Convert Double to Integer
                        theActorInTheSpotlight().attemptsTo(
                                keyValues(String.valueOf(ndocuInt)).into(RegStandByUi.TXT_NUDOCU)
                        );


                        //Importe
                        theActorInTheSpotlight().attemptsTo(
                                keyValues(String.valueOf(importe)).into(RegStandByUi.TXT_IMPORTE)
                        );



                        //--------------------------------------------------------------------------------------------------
                        // TAB: Deuda Garantía
                        //--------------------------------------------------------------------------------------------------
                        theActorInTheSpotlight().attemptsTo(
                                Click.on(RegStandByUi.TABDEUDA)
                        );
                        Thread.sleep(5000);


                        if (tcobertura.endsWith("rica")) {
                            // else if (tcobertura.contains("Sabana o Generica")){
                            System.out.println("******************************************GENERICA****************************");


                        } //Fin (tcobertura.endsWith("rica"))
                        //Thread.sleep(3000);

                        //CU deudor
                        theActorInTheSpotlight().attemptsTo(
                                WaitUntil.the(RegStandByUi.TXT_CUDEUDOR, isEnabled()).forNoMoreThan(30).seconds(),
                                Enter.theValue(cudeudor).into(RegStandByUi.TXT_CUDEUDOR)
                        );
                        RegStandByUi.TXT_CUDEUDOR.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.ENTER);
                        WaitUntil.the(RegStandByUi.TXT_CUDEUDOR, isNotCurrentlyEnabled()).forNoMoreThan(30).seconds();
                        Thread.sleep(5000);


/*                            //Cod prueba Pendiente
                            if (pendiente.equals("Si")) {
                                System.out.println("Pendiente... con check");
                                theActorInTheSpotlight().attemptsTo(
                                        Click.on(RegStandByUi.CHK_PENDIENTE)
                                        //keyValues(Keys.SPACE).into(RegStandByUi.CHK_PENDIENTE)
                                );

                                Thread.sleep(5000);
                                System.out.println("Pasó check Pendiente");

                                AlertAccept.AceptaPendiente();



                               theActorInTheSpotlight().attemptsTo(
                                        SelectFromOptions.byVisibleText(toperacion).from(RegStandByUi.CBO_TIPO_OPERACION)
                                );

                            }
                            else {
                                //Fin cod prueba pendiente*/

                                if (tcobertura.contains("Especifica")) {
                                    if (tlistado.contains("Operaciones")) {
                                        System.out.println("**************************OPERACIONES****************************");
                                        theActorInTheSpotlight().attemptsTo(
                                                Click.on(RegStandByUi.RBT_TLISTADOOPE)
                                        );
                                        Thread.sleep(3000);

                                        theActorInTheSpotlight().attemptsTo(
                                                WaitUntil.the(RegStandByUi.CBO_OPE, containsText("Nro Operacion")).forNoMoreThan(30).seconds()
                                        );

                                        //split divide la cadena en base a separador ";"
                                        for (String numope : nlineaope.split(";")) {
                                            //reemplaza espacios vacíos
                                            numope = numope.replace(" ", "");

                                            theActorInTheSpotlight().attemptsTo(
                                                    WaitUntil.the(RegStandByUi.TXT_NROOPERACION, isEnabled()).forNoMoreThan(30).seconds(),
                                                    Click.on(RegStandByUi.TXT_NROOPERACION),
                                                    Enter.theValue(numope).into(RegStandByUi.TXT_NROOPERACION),
                                                    keyValues(Keys.HOME).into(RegStandByUi.TXT_NROOPERACION),
                                                    keyValues(Keys.END).into(RegStandByUi.TXT_NROOPERACION),
                                                    keyValues(Keys.TAB).into(RegStandByUi.TXT_NROOPERACION),
                                                    keyValues(Keys.SPACE).into(RegStandByUi.BTN_BUSCAROPE)
                                            );
                                            Thread.sleep(5000);

                                            //Graba mensaje cuando operación no existe
                                            theActorInTheSpotlight().attemptsTo(
                                                    AlertAccept.OpeLinInvalid_StandBy(Fila, cellCount)
                                            );
                                            Thread.sleep(6000);


                                            //TXT_NROOPERACION contiene (muestra) nlineaope cuando no existe la operación, entonces termina sin GAC
                                            if (RegStandByUi.TXT_NROOPERACION.resolveFor(theActorInTheSpotlight()).containsValue(nlineaope)) {
                                                System.out.println("ope no existe");
                                                Fin = "Si";
                                                System.out.println("-----------Fin ope no existe" + Fin);
                                            }

                                        }

                                    } // Fin (tlistado.contains("Operaciones"))

                                    else if (tlistado.contains("Lineas")) {
                                        System.out.println("******************************************LINEAS****************************");
                                        theActorInTheSpotlight().attemptsTo(
                                                Click.on(RegStandByUi.RBT_TLISTADOLINEA)
                                        );

                                        //split divide la cadena en base a separador ";"
                                        for (String numlin : nlineaope.split(";")) {
                                            //reemplaza espacios vacíos
                                            numlin = numlin.replace(" ", "");

                                            theActorInTheSpotlight().attemptsTo(
                                                    WaitUntil.the(RegStandByUi.TXT_NROOPERACION, isEnabled()).forNoMoreThan(20).seconds(),
                                                    Click.on(RegStandByUi.TXT_NROOPERACION),
                                                    Enter.theValue(numlin).into(RegStandByUi.TXT_NROOPERACION)
                                            );
                                            RegStandByUi.BTN_BUSCAROPE.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.SPACE);
                                            // WaitUntil.the(RegStandByUi.BTN_BUSCAROPE,isNotCurrentlyEnabled()).forNoMoreThan(30).seconds();


                                            //Graba mensaje cuando línea no existe
                                            theActorInTheSpotlight().attemptsTo(
                                                    AlertAccept.OpeLinInvalid_StandBy(Fila, cellCount)
                                            );
                                            //Thread.sleep(6000);

                                            //Lectura de Excel con último mensaje grabado (cuando linea no existe)
                                            //Se hace esto por que cuando la línea no existe igual se borra del campo TXT_NROOPERACION (opuesto a comportamiento de operaciones)
                                            Cell grabado;
                                            Sheet sheet2 = LoadXls.getSheet_StandBy(0, "Data-Stand_By.xlsx");
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


                           // }//Fin Pendiente sin Check

                    if (Fin == "No") {

                        //--------------------------------------------------------------------------------------------------
                        // TAB: Deuda Garantía
                        //--------------------------------------------------------------------------------------------------
                        theActorInTheSpotlight().attemptsTo(
                                Click.on(RegStandByUi.TAB_DESCRIPCION)
                        );
                        Thread.sleep(3000);

                        //Descripción
                        theActorInTheSpotlight().attemptsTo(
                                Enter.theValue(descripcion).into(RegStandByUi.TXT_DESCRIPCION)
                        );

                        //Comentario
                        theActorInTheSpotlight().attemptsTo(
                                //keyValues(String.valueOf(comentarioInt)).into(RegStandByUi.TXT_COMENTARIO)
                                Enter.theValue(comentario).into(RegStandByUi.TXT_COMENTARIO)
                        );
                        Thread.sleep(5000);


                        //--------------------------------------------------------------------------------------------------
                        // REGISTRAR GARANTIA
                        //--------------------------------------------------------------------------------------------------
                        RegStandByUi.BTN_REGISTRAR.resolveFor(theActorInTheSpotlight()).click();
                        keyEventMask = FocusEvent.KEY_EVENT_MASK;
                        theActorInTheSpotlight().attemptsTo(
                                AlertAccept.Aceptar_StandBy(Fila, cellCount, Fila)
                        );
                        new motoresdebusqueda.gac.stepdefinitions.standby.GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_Garantia_Stand_By();

                        //Fin llenado campos
                    }
                    }
}
                    if (Fin == "Si") {
                        System.out.println("-----------Fin - ejecucion por errores");
                        new motoresdebusqueda.gac.stepdefinitions.standby.GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_Garantia_Stand_By();
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


