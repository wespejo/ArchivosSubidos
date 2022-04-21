package starter.stepdefinitions.fideicomisogarantia;

import io.cucumber.java.es.Entonces;
import motoresdebusqueda.gac.page.fideicomisogarantia.RegFideicomisoGarantiaUi;
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
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actions.Enter.keyValues;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RegFEGStepDefinitions {

    private Object IsNotEnabledMatcher;
    private long keyEventMask;
    private static WebDriver driver;

@Entonces("se genera nueva Garantia Fideicomiso en Garantia")
public void se_genera_nueva_Garantia_Fideicomiso_en_Garantia() throws InterruptedException {

    try {
        Sheet sheet = LoadXls.getSheet_FideicomisoGarantia(0, "Data-FideicomisoGarantia.xlsx");
        //TAB: Datos de la Garantía
        String cu;
        double tienda;
        String tdocumento;
        String situacion;
        double ndias;
        String monedacta;
        double numoficinacta;
        String numerocta;
        String ctagarantia;
        String moneda;
        double monto;
        String bienes;

        //Información Tasación
        String perito;
        String fectasacion;
        String monedatasacion;
        double importeasegtasacion;

        //Información de Seguro
        String tipopoliza;
        double nropoliza;
        String fecvtopoliza;
        String nomciaseguro;
        double importepolext;

        //Información legal del Registro
        String notaria;
        double kardex;
        double partidaregistral;
        String descpartidaregistral;
        String asiento;
        String oficinaregistral;

        //Ubigeo
        String departamento;
        String provincia;
        String distrito;
        String direccion;

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
            tdocumento="";
            situacion="";
            ndias = 0;
            monedacta="";
            numoficinacta=0;
            numerocta="";
            ctagarantia="";
            moneda ="";
            monto = 0;
            bienes="";

            //Información de Tasación
            perito="";
            fectasacion="";
            monedatasacion="";
            importeasegtasacion= 0;

            //Información de Seguro
            tipopoliza= "";
            nropoliza = 0;
            fecvtopoliza= "";
            nomciaseguro= "";
            importepolext = 0;

            //Información legal del Registro
            notaria="";
            kardex=0;
            partidaregistral=0;
            descpartidaregistral="";
            asiento="";
            oficinaregistral="";
            //Ubigeo
            departamento="";
            provincia="";
            distrito="";
            direccion="";

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
                if (cellCount ==37) {
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
                        situacion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 3++-+-+++-+-+-+-+situacion:"+situacion);
                        break;
                    case 4:
                        ndias = cell.getNumericCellValue();
                        int ndiasInt = (int)ndias; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 4++-+-+++-+-+-+-+ndias:"+ndiasInt);
                        break;
                    case 5:
                        monedacta = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 5++-+-+++-+-+-+-+Moneda de Cuenta:"+monedacta);
                        break;
                    case 6:
                        numoficinacta = cell.getNumericCellValue();
                        int numoficinactaInt = (int)numoficinacta; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 6++-+-+++-+-+-+-+Numero de Oficina / Tienda:"+numoficinactaInt);
                        break;
                    case 7:
                        numerocta = cell.getStringCellValue();
                        //int numeroctaInt = (int)numerocta; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 7++-+-+++-+-+-+-+Numero de Cuenta:" +numerocta);
                        break;
                    case 8:
                        ctagarantia = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 8++-+-+++-+-+-+-+Cuenta Garantia:"+ctagarantia);
                        break;
                    case 9:
                        moneda = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 9++-+-+++-+-+-+-+Moneda:"+moneda);
                        break;
                    case 10:
                        monto = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 10++-+-+++-+-+-+-+Monto:"+monto);
                        break;
                    case 11:
                        bienes = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 11++-+-+++-+-+-+-+Bienes:"+bienes);
                        break;
                    //Información Tasación
                    case 12:
                        perito = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 12++-+-+++-+-+-+-+Perito:"+perito);
                        break;
                    case 13:
                        SimpleDateFormat dateFormat3 = new SimpleDateFormat("dd/MM/yyyy"); //SimpleDateFormat
                        fectasacion = dateFormat3.format(cell.getDateCellValue());
                        System.out.println("-++++-+++-++++-Columna 13++-+-+++-+-+-+-+Fecha de Tasacion:"+fectasacion);
                        break;
                    case 14:
                        monedatasacion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 14++-+-+++-+-+-+-+Moneda de Tasacion:"+monedatasacion);
                        break;
                    case 15:
                        importeasegtasacion = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 15++-+-+++-+-+-+-+Importe Asegurable de Tasacion:"+importeasegtasacion);
                        break;

                    //información de Seguro
                    case 16:
                        tipopoliza = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 16++-+-+++-+-+-+-+Tipo de Poliza:"+tipopoliza);
                        break;
                    case 17:
                        nropoliza =cell.getNumericCellValue();
                        int nropolizaInt = (int)nropoliza; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 17++-+-+++-+-+-+-+Nro de Poliza:"+nropolizaInt);
                        break;
                    case 18:
                        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy"); //SimpleDateFormat
                        fecvtopoliza = dateFormat2.format(cell.getDateCellValue());
                        System.out.println("-++++-+++-++++-Columna 18++-+-+++-+-+-+-+Fecha de Vencimiento de Poliza:"+fecvtopoliza);
                        break;
                    case 19:
                        nomciaseguro = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 19++-+-+++-+-+-+-+Nombre CIA Seguro:"+nomciaseguro);
                        break;
                    case 20:
                        importepolext = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 20++-+-+++-+-+-+-+Importe Segun Poliza Externa :"+importepolext);
                        break;

                    //Información legal del Registro
                    case 21:
                        notaria = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 21++-+-+++-+-+-+-+Notaria:"+notaria);
                        break;
                    case 22:
                        kardex = cell.getNumericCellValue();
                        int kardexInt = (int)kardex; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 22++-+-+++-+-+-+-+Kardex:"+kardexInt);
                        break;
                    case 23:
                        partidaregistral = cell.getNumericCellValue();
                        int partidaregistralInt = (int)partidaregistral; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 23++-+-+++-+-+-+-+partida registral:"+partidaregistralInt);
                        break;
                    case 24:
                        descpartidaregistral = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 24++-+-+++-+-+-+-+descripcion partida registral:"+descpartidaregistral);
                        break;
                    case 25:
                        asiento = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 25++-+-+++-+-+-+-+asiento:"+asiento);
                        break;

                    case 26:
                        oficinaregistral = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 26++-+-+++-+-+-+-+oficina registral:"+oficinaregistral);
                        break;


                    //Ubigeo
                    case 27:
                        departamento = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 27++-+-+++-+-+-+-+departamento:"+departamento);
                        break;
                    case 28:
                        provincia = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 28++-+-+++-+-+-+-+provincia:"+provincia);
                        break;
                    case 29:
                        distrito = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 29++-+-+++-+-+-+-+distrito:"+distrito);
                        break;
                    case 30:
                        direccion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 30++-+-+++-+-+-+-+direccion:"+direccion);
                        break;

                    //TAB Deuda Garantía

                    case 31:
                        tcobertura = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 31++-+-+++-+-+-+-+tcobertura:"+tcobertura);
                        break;
                    case 32:
                        cudeudor = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 32++-+-+++-+-+-+-+cudeudor:"+cudeudor);
                        break;
                    case 33:
                        tlistado = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 33++-+-+++-+-+-+-+tlistado:"+tlistado);
                        break;
                    case 34:
                        nlineaope = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 34++-+-+++-+-+-+-+nlineaope:"+nlineaope);
                        break;

                    case 35:
                        descripcion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 35++-+-+++-+-+-+-+descripcion:"+descripcion);
                        break;
                    case 36:
                        comentario = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 36++-+-+++-+-+-+-+comentario:"+comentario);
                        break;

                }// Fin switch (Columna)
                }//{} Fin (rowCount ==15)
            }//{} FIN (Cell cell : row)


            //Catidad de columnas (sin garantía)
            int cellCount = row.getLastCellNum() - row.getFirstCellNum();
            System.out.println("-----****************-----SEGUIMOS EN LA fila que tiene:"+ cellCount + " Columnas con data");
            if(cellCount == 37) {


                //TAB Datos Generales
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegFideicomisoGarantiaUi.TAB_DATOS_GENERALES, isEnabled()).forNoMoreThan(60).seconds(),
                        Click.on(RegFideicomisoGarantiaUi.TAB_DATOS_GENERALES),
                        WaitUntil.the(RegFideicomisoGarantiaUi.TXT_CU, isVisible()).forNoMoreThan(30).seconds()
                );
                //Thread.sleep(3000);

                //Inicio llenado campos
                //Código Unico - cu
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegFideicomisoGarantiaUi.TXT_CU, isEnabled()).forNoMoreThan(60).seconds(),
                        Enter.keyValues(Keys.HOME).into(RegFideicomisoGarantiaUi.TXT_CU),
                        Enter.theValue(cu).into(RegFideicomisoGarantiaUi.TXT_CU),
                        Enter.keyValues(Keys.END).into(RegFideicomisoGarantiaUi.TXT_CU),
                        Enter.keyValues(Keys.ENTER).into(RegFideicomisoGarantiaUi.TXT_CU)
                );


                //Espera a que mensaje "Cargando" no sea visible
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegFideicomisoGarantiaUi.Pop_Modal, isNotCurrentlyVisible()).forNoMoreThan(30).seconds()
                );
                //Graba mensaje cuando CU no existe
                String nombreracsoc;
                nombreracsoc = RegFideicomisoGarantiaUi.TXT_NOMBRERAZONSOC.resolveFor(theActorInTheSpotlight()).getValue();
                System.out.println("....El NOmbre o razón social es:"+nombreracsoc);

                if ((nombreracsoc == null) || (nombreracsoc.equals("")) ){
                    System.out.println("................................CU no existe!!!");
                    AlertAccept.Valida_CU(Fila, cellCount);
                    Fin = "Si";
                }

                if (Fin == "No")
                {

                //Tienda - tienda
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegFideicomisoGarantiaUi.Pop_Modal, isNotCurrentlyVisible()).forNoMoreThan(30).seconds(),
                        Click.on(RegFideicomisoGarantiaUi.TXT_TIENDA),
                        Enter.keyValues(Keys.HOME).into(RegFideicomisoGarantiaUi.TXT_TIENDA),
                        Enter.keyValues(String.valueOf(tienda)).into(RegFideicomisoGarantiaUi.TXT_TIENDA)
                );
                RegFideicomisoGarantiaUi.TXT_TIENDA.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.ENTER);


                //Tipo de Documento  - tdocumento
                theActorInTheSpotlight().attemptsTo(
                        SelectFromOptions.byVisibleText(tdocumento).from(RegFideicomisoGarantiaUi.CBO_TDOCU)
                        //WaitUntil.the(RegFideicomisoGarantiaUi.CBO_TDOCU,containsSelectOption(tdocumento)).forNoMoreThan(5).seconds()
                );
                Thread.sleep(3000);


                //Situación
                if ((situacion.equals("EN TRAMITE")) || (situacion.equals("NO CONFORME"))) {
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(situacion).from(RegFideicomisoGarantiaUi.CBO_SITUACION),
                            WaitUntil.the(RegFideicomisoGarantiaUi.CBO_SITUACION, containsSelectOption(situacion)).forNoMoreThan(5).seconds()
                    );
                    Thread.sleep(3000);
                }


                //Número de Días
                int ndiasInt = (int) ndias; // Convert Double to Integer
                theActorInTheSpotlight().attemptsTo(
                        Enter.keyValues(String.valueOf(ndiasInt)).into(RegFideicomisoGarantiaUi.TXT_NUDIASAPRIORI)
                );
                //Thread.sleep(3000);




                //Sección Datos de la cuenta



                //Moneda Garantía
                System.out.println(".-.-.-.-.-.-.-.-.-la moneda es:" + moneda);

                if (moneda.equals("Soles")) {
                    System.out.println("--------------------------------------------------Moneda Soles");
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText("Soles").from(RegFideicomisoGarantiaUi.CBO_MONEDA)
                    );
                }
                Thread.sleep(5000);


                //Monto
                theActorInTheSpotlight().attemptsTo(
                        //WaitUntil.the(RegFideicomisoGarantiaUi.CBO_MONEDA,isNotSelected()).forNoMoreThan(30).seconds(),
                        Click.on(RegFideicomisoGarantiaUi.TXT_MONTO),

                        //primera opcion
                        Enter.keyValues(Keys.HOME).into(RegFideicomisoGarantiaUi.TXT_MONTO),
                        keyValues(Keys.DELETE).into(RegFideicomisoGarantiaUi.TXT_MONTO),
                        keyValues(Keys.DELETE).into(RegFideicomisoGarantiaUi.TXT_MONTO),
                        keyValues(Keys.DELETE).into(RegFideicomisoGarantiaUi.TXT_MONTO),
                        keyValues(Keys.DELETE).into(RegFideicomisoGarantiaUi.TXT_MONTO),
                        Enter.keyValues(String.valueOf(monto)).into(RegFideicomisoGarantiaUi.TXT_MONTO)
                );
                //Thread.sleep(3000);

                    
                if (!tdocumento.contains("FIDEICOMISO FLUJO")) {
                    //Bienes
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegFideicomisoGarantiaUi.TXT_MONTO, isNotSelected()).forNoMoreThan(30).seconds(),
                            Enter.theValue(bienes).into(RegFideicomisoGarantiaUi.TXT_BIENES)
                    );
                    //Thread.sleep(3000);


                    //Información Tasación
                    //Perito
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegFideicomisoGarantiaUi.TXT_BIENES, isNotSelected()).forNoMoreThan(30).seconds(),
                            SelectFromOptions.byVisibleText(perito).from(RegFideicomisoGarantiaUi.CBO_PERITO)
                    );
                    Thread.sleep(3000);

                    //Fecha de Tasación
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegFideicomisoGarantiaUi.CBO_PERITO, isNotSelected()).forNoMoreThan(30).seconds(),
                            Enter.theValue(fectasacion).into(RegFideicomisoGarantiaUi.TXT_FECTASACION)
                    );
                    //Thread.sleep(3000);


                    //Moneda de Tasación
                    System.out.println(".-.-.-.-.-.-.-.-.-la moneda tasacion es:" + monedatasacion);
                    if (monedatasacion.equals("Soles")) {
                        System.out.println("--------------------------------------------------Moneda Tasacion Soles");
                        theActorInTheSpotlight().attemptsTo(
                                SelectFromOptions.byIndex(1).from(RegFideicomisoGarantiaUi.CBO_MONEDATASACION)
                        );
                    }
                    Thread.sleep(1000);


                    //Importe Asegurable de Tasación
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegFideicomisoGarantiaUi.CBO_MONEDATASACION, isNotSelected()).forNoMoreThan(30).seconds(),
                            Enter.keyValues(String.valueOf(importeasegtasacion)).into(RegFideicomisoGarantiaUi.TXT_IMPORTEASEGTASACION)
                    );
                    Thread.sleep(1000);


                    //Información de Seguro
                    //Tipo de Póliza
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(tipopoliza).from(RegFideicomisoGarantiaUi.CBO_TIPOLIZA)
                    );
                    Thread.sleep(3000);

                    //if ((!tipopoliza.equals("INTERBANK"))|| (!tipopoliza.equals("NO COBRAR")))
                    if (tipopoliza.contains("EXTERNA")) {
                        System.out.println("-------------------------------Tipo de poliza:" + tipopoliza);
                        //Nro Poliza
                        int nropolizaInt = (int) nropoliza; // Convert Double to Integer
                        theActorInTheSpotlight().attemptsTo(
                                WaitUntil.the(RegFideicomisoGarantiaUi.TXT_NROPOLIZA, isEnabled()).forNoMoreThan(30).seconds(),
                                Enter.keyValues(String.valueOf(nropolizaInt)).into(RegFideicomisoGarantiaUi.TXT_NROPOLIZA)
                        );
                        Thread.sleep(3000);


                        //Fecha Vcto Poliza
                        theActorInTheSpotlight().attemptsTo(
                                Enter.theValue(fecvtopoliza).into(RegFideicomisoGarantiaUi.TXT_FECVTOPOLIZA)
                        );
                        Thread.sleep(1000);


                        //Nombre Cia Seguro
                        theActorInTheSpotlight().attemptsTo(
                                SelectFromOptions.byVisibleText(nomciaseguro).from(RegFideicomisoGarantiaUi.CBO_NOMCIASEGURO)
                                //WaitUntil.the(RegFideicomisoGarantiaUi.CBO_NOMCIASEGURO,containsSelectOption(nomciaseguro)).forNoMoreThan(6).seconds()
                        );
                        Thread.sleep(4000);

                        //Importe Según Póliza Externa
                        theActorInTheSpotlight().attemptsTo(
                                WaitUntil.the(RegFideicomisoGarantiaUi.CBO_NOMCIASEGURO, isNotSelected()).forNoMoreThan(30).seconds(),
                                Enter.keyValues(String.valueOf(importepolext)).into(RegFideicomisoGarantiaUi.TXT_IMPPOLEXT)
                        );
                        Thread.sleep(3000);
                    }// FIN ((!tipopoliza.equals("INTERBANK"))|| (!tipopoliza.equals("NO COBRAR")))


                    //Información legal del Registro
                    //Notaria
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(notaria).into(RegFideicomisoGarantiaUi.TXT_NOTARIA),
                            WaitUntil.the(RegFideicomisoGarantiaUi.TXT_NOTARIA, isNotSelected()).forNoMoreThan(5).seconds()
                    );
                    //Thread.sleep(3000);

                    //Kardex
                    int kardexInt = (int) kardex; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(kardexInt)).into(RegFideicomisoGarantiaUi.TXT_KARDEX),
                            WaitUntil.the(RegFideicomisoGarantiaUi.TXT_KARDEX, isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    //Thread.sleep(3000);

                    //Partida Registral
                    int partidaregistralInt = (int) partidaregistral; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(partidaregistralInt)).into(RegFideicomisoGarantiaUi.TXT_PARTIDAREGISTRAL),
                            WaitUntil.the(RegFideicomisoGarantiaUi.TXT_PARTIDAREGISTRAL, isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    //Thread.sleep(3000);


                    //Descripción Partida Registral
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(descpartidaregistral).into(RegFideicomisoGarantiaUi.TXT_DESCPARTIDAREGISTRAL),
                            WaitUntil.the(RegFideicomisoGarantiaUi.TXT_DESCPARTIDAREGISTRAL, isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    //Thread.sleep(3000);


                    //Asiento
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(asiento).into(RegFideicomisoGarantiaUi.TXT_ASIENTO),
                            WaitUntil.the(RegFideicomisoGarantiaUi.TXT_ASIENTO, isNotSelected()).forNoMoreThan(30).seconds()
                    );


                    //Oficina Registral
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(oficinaregistral).from(RegFideicomisoGarantiaUi.CBO_OFICINAREGISTRAL)
                            //WaitUntil.the(RegFideicomisoGarantiaUi.CBO_OFICINAREGISTRAL,containsSelectOption(oficinaregistral)).forNoMoreThan(6).seconds()
                    );
                    Thread.sleep(6000);


                    //Ubigeo
                    //Departamento
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegFideicomisoGarantiaUi.CBO_ZONAREGSITRAL, isCurrentlyVisible()).forNoMoreThan(30).seconds(),
                            SelectFromOptions.byVisibleText(departamento).from(RegFideicomisoGarantiaUi.CBO_DEPARTAMENTO),
                            WaitUntil.the(RegFideicomisoGarantiaUi.CBO_DEPARTAMENTO, isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    Thread.sleep(6000);
                    //Provincia
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(provincia).from(RegFideicomisoGarantiaUi.CBO_PROVINCIA),
                            WaitUntil.the(RegFideicomisoGarantiaUi.CBO_PROVINCIA, isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    Thread.sleep(7000);
                    //Distrito
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(distrito).from(RegFideicomisoGarantiaUi.CBO_DISTRITO),
                            WaitUntil.the(RegFideicomisoGarantiaUi.CBO_DISTRITO, isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    Thread.sleep(6000);
                    //Dirección
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(direccion).into(RegFideicomisoGarantiaUi.TXT_DIRECCION)
                    );
                    //Thread.sleep(3000);
                }

                //--------------------------------------------------------------------------------------------------
                // TAB: Deuda Garantía
                //--------------------------------------------------------------------------------------------------
                Thread.sleep(3000);
                theActorInTheSpotlight().attemptsTo(
                        Click.on(RegFideicomisoGarantiaUi.TABDEUDA)
                );
                Thread.sleep(5000);


                if (tcobertura.endsWith("rica")) {
                    System.out.println("******************************************GENERICA****************************");
                    theActorInTheSpotlight().attemptsTo(
                            Click.on(RegFideicomisoGarantiaUi.LBLTIPOCOBERTURA),
                            Enter.keyValues(String.valueOf(Keys.DOWN)).into(RegFideicomisoGarantiaUi.LBLTIPOCOBERTURA),
                            Enter.keyValues(String.valueOf(Keys.TAB)).into(RegFideicomisoGarantiaUi.LBLTIPOCOBERTURA)
                            //SelectFromOptions.byValue("1").from(RegFideicomisoGarantiaUi.CBO_TIPOCOBERTURA)
                    );


                } //Fin (tcobertura.endsWith("rica"))
                //Thread.sleep(6000);


                //CU Deudor
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegFideicomisoGarantiaUi.TXT_CUDEUDOR, isEnabled()).forNoMoreThan(30).seconds(),
                        Enter.theValue(cudeudor).into(RegFideicomisoGarantiaUi.TXT_CUDEUDOR)
                );
                RegFideicomisoGarantiaUi.TXT_CUDEUDOR.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.ENTER);
                WaitUntil.the(RegFideicomisoGarantiaUi.TXT_CUDEUDOR, isNotCurrentlyEnabled()).forNoMoreThan(30).seconds();
                Thread.sleep(5000);


                if (tcobertura.contains("Especifica")) {
                    if (tlistado.contains("Operaciones")) {
                        System.out.println("**************************OPERACIONES****************************");
                        theActorInTheSpotlight().attemptsTo(
                                Click.on(RegFideicomisoGarantiaUi.RBT_TLISTADOOPE)
                        );
                        Thread.sleep(3000);

                        theActorInTheSpotlight().attemptsTo(
                                WaitUntil.the(RegFideicomisoGarantiaUi.LBL_OPE, containsText("Nro Operacion")).forNoMoreThan(40).seconds()
                        );
                        Thread.sleep(3000);

                        //split divide la cadena en base a separador ";"
                        for (String numope: nlineaope.split(";")) {
                            //reemplaza espacios vacíos
                            numope = numope.replace(" ", "");

                            theActorInTheSpotlight().attemptsTo(
                                    WaitUntil.the(RegFideicomisoGarantiaUi.TXT_NROOPERACION, isEnabled()).forNoMoreThan(30).seconds(),
                                    Click.on(RegFideicomisoGarantiaUi.TXT_NROOPERACION),
                                    Enter.theValue(numope).into(RegFideicomisoGarantiaUi.TXT_NROOPERACION),
                                    Enter.keyValues(String.valueOf(Keys.HOME)).into(RegFideicomisoGarantiaUi.TXT_NROOPERACION),
                                    Enter.keyValues(String.valueOf(Keys.END)).into(RegFideicomisoGarantiaUi.TXT_NROOPERACION),
                                    Enter.keyValues(String.valueOf(Keys.TAB)).into(RegFideicomisoGarantiaUi.TXT_NROOPERACION),
                                    Enter.keyValues(String.valueOf(Keys.SPACE)).into(RegFideicomisoGarantiaUi.BTN_BUSCAROPE)
                                    //WaitUntil.the(RegFideicomisoGarantiaUi.TXT_NROOPERACION,containsText(nlineaope)).forNoMoreThan(30).seconds()
                            );


                            //Graba mensaje cuando operación no existe
                            theActorInTheSpotlight().attemptsTo(
                                    AlertAccept.OpeLinInvalid_FideicomisoGarantia(Fila, cellCount)
                            );
                            //Thread.sleep(6000);


                            //TXT_NROOPERACION contiene (muestra) nlineaope cuando no existe la operación, entonces termina sin GAC
                            if (RegFideicomisoGarantiaUi.TXT_NROOPERACION.resolveFor(theActorInTheSpotlight()).containsValue(nlineaope)) {
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
                                Click.on(RegFideicomisoGarantiaUi.RBT_TLISTADOLINEA)
                        );

                    //split divide la cadena en base a separador ";"
                    for (String numlin: nlineaope.split(";")) {
                        //reemplaza espacios vacíos
                        numlin = numlin.replace(" ", "");

                        theActorInTheSpotlight().attemptsTo(
                                WaitUntil.the(RegFideicomisoGarantiaUi.TXT_NROOPERACION, isEnabled()).forNoMoreThan(30).seconds(),
                                Click.on(RegFideicomisoGarantiaUi.TXT_NROOPERACION),
                                Enter.theValue(numlin).into(RegFideicomisoGarantiaUi.TXT_NROOPERACION),
                                Enter.keyValues(String.valueOf(Keys.HOME)).into(RegFideicomisoGarantiaUi.TXT_NROOPERACION),
                                Enter.keyValues(String.valueOf(Keys.END)).into(RegFideicomisoGarantiaUi.TXT_NROOPERACION),
                                Enter.keyValues(String.valueOf(Keys.TAB)).into(RegFideicomisoGarantiaUi.TXT_NROOPERACION),
                                Enter.keyValues(String.valueOf(Keys.SPACE)).into(RegFideicomisoGarantiaUi.BTN_BUSCAROPE)
                        );
                        //Thread.sleep(5000);

                        //Graba mensaje cuando línea no existe
                        theActorInTheSpotlight().attemptsTo(
                                AlertAccept.OpeLinInvalid_FideicomisoGarantia(Fila, cellCount)
                        );
                        //Thread.sleep(6000);

                        //Lectura de Excel con último mensaje grabado (cuando linea no existe)
                        //Se hace esto por que cuando la línea no existe igual se borra del campo TXT_NROOPERACION (opuesto a comportamiento de operaciones)
                        Cell grabado;
                        Sheet sheet2 = LoadXls.getSheet_FideicomisoGarantia(0, "Data-FideicomisoGarantia.xlsx");
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

                if (Fin == "No")
                {
                    //

                    //

                    //--------------------------------------------------------------------------------------------------
                    // TAB: Deuda Garantía
                    //--------------------------------------------------------------------------------------------------
                    theActorInTheSpotlight().attemptsTo(
                            Click.on(RegFideicomisoGarantiaUi.TAB_DESCRIPCION)
                    );
                    Thread.sleep(3000);

                    //Descripción
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(descripcion).into(RegFideicomisoGarantiaUi.TXT_DESCRIPCION)
                    );

                    //Comentario
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(comentario).into(RegFideicomisoGarantiaUi.TXT_COMENTARIO)
                    );
                    Thread.sleep(1000);



                    //Ingresa aquí cuando se tienen datos de la cuenta
                    if ((tdocumento.contains("FIDEICOMISO FLUJO")) && (numoficinacta >0) && (!numerocta.isEmpty())){

                        //TAB Datos Generales
                        theActorInTheSpotlight().attemptsTo(
                                Click.on(RegFideicomisoGarantiaUi.TAB_DATOS_GENERALES)
                        );

                        //Datos de la Cuenta
                        //Moneda de la cuenta
                        if (monedacta.equals("Soles")) {
                            System.out.println("--------------------------------------------------Moneda CTA Soles");
                            theActorInTheSpotlight().attemptsTo(
                                    SelectFromOptions.byIndex(1).from(RegFideicomisoGarantiaUi.CBO_MONEDA_CTA)
                            );
                        }
                        Thread.sleep(3000);

                        //Oficina de cuenta
                        int numoficinactaInt = (int) numoficinacta; // Convert Double to Integer
                        theActorInTheSpotlight().attemptsTo(
                                Enter.keyValues(String.valueOf(numoficinactaInt)).into(RegFideicomisoGarantiaUi.TXT_NUMOFICINACTA),
                                WaitUntil.the(RegFideicomisoGarantiaUi.TXT_NUMOFICINACTA, isNotSelected()).forNoMoreThan(30).seconds()
                        );
                        Thread.sleep(3000);

                        //Numero de cuenta
                        theActorInTheSpotlight().attemptsTo(
                                Enter.theValue(numerocta).into(RegFideicomisoGarantiaUi.TXT_NUMEROCTA),
                                Enter.keyValues(String.valueOf(Keys.HOME)).into(RegFideicomisoGarantiaUi.TXT_NUMEROCTA),
                                Enter.keyValues(String.valueOf(Keys.END)).into(RegFideicomisoGarantiaUi.TXT_NUMEROCTA),
                                Enter.keyValues(String.valueOf(Keys.ENTER)).into(RegFideicomisoGarantiaUi.TXT_NUMEROCTA)
                        );



                        //Graba mensaje cuando cuenta no existe
/*                    theActorInTheSpotlight().attemptsTo(
                            AlertAccept.CtaInvalid_FideicomisoGarantia(Fila, cellCount)
                    );
                    Thread.sleep(7000);

                    //Boton no visible cuando cuenta no existe
                    if (!RegFideicomisoGarantiaUi.BTN_NVACTA.resolveFor(theActorInTheSpotlight()).isVisible()) {
                        System.out.println("cta no existe");
                        Fin = "Si";
                        System.out.println("-----------Fin x cta no existe: " + Fin);
                    }*/


                        // Cuenta Garantía
                        if (ctagarantia.equals("Si")) {
                            System.out.println("Cuenta Garantía ...con check");
                            theActorInTheSpotlight().attemptsTo(
                                    Click.on(RegFideicomisoGarantiaUi.CHK_CTAGARANTIA)
                            );
                        }
                    }



                    //--------------------------------------------------------------------------------------------------
                    // REGISTRAR GARANTIA
                    //--------------------------------------------------------------------------------------------------
                    RegFideicomisoGarantiaUi.BTN_REGISTRAR.resolveFor(theActorInTheSpotlight()).click();
                    keyEventMask = FocusEvent.KEY_EVENT_MASK;
                    theActorInTheSpotlight().attemptsTo(
                            AlertAccept.Aceptar_FideicomisoGarantia(Fila,cellCount, Fila)
                    );
                    Thread.sleep(2000);

                    //Fin llenado campos
                    new motoresdebusqueda.gac.stepdefinitions.fideicomisogarantia.GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_garantía_Fideicomiso_en_Garantia();
                }

                if (Fin == "Si") {
                    System.out.println("-----------Fin - ejecucion por errores");
                    new motoresdebusqueda.gac.stepdefinitions.fideicomisogarantia.GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_garantía_Fideicomiso_en_Garantia();
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

