package starter.stepdefinitions.hipotecas;

import io.cucumber.java.es.Entonces;
import motoresdebusqueda.gac.page.hipotecas.RegHipotecasUi;
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
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

//

public class RegCfStepDefinitions {

    private Object IsNotEnabledMatcher;
    private long keyEventMask;
    private static WebDriver driver;

@Entonces("se genera nueva Garantia Hipotecas")
public void se_genera_nueva_Garantia_Hipotecas() throws InterruptedException {

    try {
        Sheet sheet = LoadXls.getSheet_HipotecaComercial(0, "Data-Hipotecas.xlsx");
        String cu;
        double tienda;
        String tdocumento;
        String rango;
        double ndocu;
        String moneda;
        double valrealizacion;
        double valcomercial;
        double valgravamen;
        String fecgravamen;
        String situacion;
        String etapa;
        //Información de Seguro
        String tipopoliza;
        double nropoliza;
        String fecvtopoliza;
        String nomciaseguro;
        double importepolext;
        //Información Tasación
        String perito;
        String fectasacion;
        String tipotasacion;
        String monedatasacion;
        double valorconstruccion;
        double areaconstruida;
        double importeasegtasacion;
        double valorterreno;
        double areaterreno;
        String uso;
        //Información legal del Registro
        String notaria;
        double kardex;
        double partidaregistral;
        String descpartidaregistral;
        double asiento;
        String oficinaregistral;
        //Ubigeo
        String departamento;
        String provincia;
        String distrito;
        String direccion;


        //DEUDA GARANTIA
        String tcobertura;
        String cudeudor;
        String tlistado;
        String nlineaope;
        String monedacta;
        double numoficinacta;
        String numerocta;
        String descripcion;
        double comentario;
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
            tdocumento="";
            rango="";
            ndocu = 0;
            moneda ="";
            valrealizacion = 0;
            valcomercial = 0;
            valgravamen = 0;
            fecgravamen= "";
            situacion = "";
            etapa="";
            //Información de Seguro
            tipopoliza= "";
            nropoliza = 0;
            fecvtopoliza= "";
            nomciaseguro= "";
            importepolext = 0;
            perito="";
            fectasacion="";
            tipotasacion="";
            monedatasacion="";
            valorconstruccion= 0;
            areaconstruida= 0;
            importeasegtasacion= 0;
            valorterreno= 0;
            areaterreno= 0;
            uso="";
            //Información legal del Registro
            notaria="";
            kardex=0;
            partidaregistral=0;
            descpartidaregistral="";
            asiento=0;
            oficinaregistral="";
            //Ubigeo
            departamento="";
            provincia="";
            distrito="";
            direccion="";

            //DEUDA GARANTIA
            tcobertura ="";
            cudeudor ="";
            tlistado ="";
            nlineaope="";
            monedacta="";
            numoficinacta=0;
            numerocta="";
            descripcion ="";
            comentario= 0;
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
                if (cellCount ==46) {
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
                        rango = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 3++-+-+++-+-+-+-+rango:"+rango);
                        break;
                    case 4:
                        ndocu = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 4++-+-+++-+-+-+-+ndocu:"+ndocu);
/*                        int ndocuInt = (int)ndocu; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 5++-+-+++-+-+-+-+ndocu:"+ndocuInt);*/
                        break;
                    case 5:
                        moneda = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 5++-+-+++-+-+-+-+moneda:"+moneda);
                        break;
                    case 6:
                        valrealizacion = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 6++-+-+++-+-+-+-+valor de realizacion:"+valrealizacion);
                        break;
                    case 7:
                        valcomercial = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 7++-+-+++-+-+-+-+valor comercial:"+valcomercial);
                        break;
                    case 8:
                        valgravamen = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 8++-+-+++-+-+-+-+valor de gravamen:"+valgravamen);
                        break;
                    case 9:
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //SimpleDateFormat
                        fecgravamen = dateFormat.format(cell.getDateCellValue());
                        System.out.println("-++++-+++-++++-Columna 9++-+-+++-+-+-+-+fecvencimiento:"+ fecgravamen);
                        break;
                    case 10:
                        situacion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 10++-+-+++-+-+-+-+Situacion:"+situacion);
                        break;
                    case 11:
                        etapa = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 11++-+-+++-+-+-+-+Etapa:"+etapa);
                        break;

                    //información de Seguro
                    case 12:
                        tipopoliza = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 12++-+-+++-+-+-+-+Tipo de Poliza:"+tipopoliza);
                        break;
                    case 13:
                        nropoliza =cell.getNumericCellValue();
                        int nropolizaInt = (int)nropoliza; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 13++-+-+++-+-+-+-+Nro de Poliza:"+nropolizaInt);
                        break;
                    case 14:
                        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy"); //SimpleDateFormat
                        fecvtopoliza = dateFormat2.format(cell.getDateCellValue());
                        System.out.println("-++++-+++-++++-Columna 14++-+-+++-+-+-+-+Fecha de Vencimiento de Poliza:"+fecvtopoliza);
                        break;
                    case 15:
                        nomciaseguro = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 15++-+-+++-+-+-+-+Nombre CIA Seguro:"+nomciaseguro);
                        break;
                    case 16:
                        importepolext = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 16++-+-+++-+-+-+-+Importe Segun Poliza Externa :"+importepolext);
                        break;

                    //Información Tasación
                    case 17:
                        perito = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 17++-+-+++-+-+-+-+Perito:"+perito);
                        break;
                    case 18:
                        SimpleDateFormat dateFormat3 = new SimpleDateFormat("dd/MM/yyyy"); //SimpleDateFormat
                        fectasacion = dateFormat3.format(cell.getDateCellValue());
                        System.out.println("-++++-+++-++++-Columna 18++-+-+++-+-+-+-+Fecha de Tasacion:"+fectasacion);
                        break;
                    case 19:
                        tipotasacion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 19++-+-+++-+-+-+-+Tipo de Tasacion:"+tipotasacion);
                        break;
                    case 20:
                        monedatasacion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 21++-+-+++-+-+-+-+Moneda de Tasacion:"+monedatasacion);
                        break;

                    case 21:
                        valorconstruccion = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 21++-+-+++-+-+-+-+Valor de Contruccion:"+valorconstruccion);
                        break;
                   case 22:
                        areaconstruida = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 22++-+-+++-+-+-+-+Area Construida:"+areaconstruida);
                        break;
                   case 23:
                        importeasegtasacion = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 23++-+-+++-+-+-+-+Importe Asegurable de Tasacion:"+importeasegtasacion);
                        break;
                    case 24:
                        valorterreno = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 24++-+-+++-+-+-+-+Valor del Terreno:"+valorterreno);
                        break;
                    case 25:
                        areaterreno = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 25++-+-+++-+-+-+-+Area del Terreno:"+areaterreno);
                        break;
                    case 26:
                        uso = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 26++-+-+++-+-+-+-+Uso:"+uso);
                        break;

                    //Información legal del Registro
                    case 27:
                        notaria = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 27++-+-+++-+-+-+-+Notaria:"+notaria);
                        break;
                    case 28:
                        kardex = cell.getNumericCellValue();
                        int kardexInt = (int)kardex; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 28++-+-+++-+-+-+-+Kardex:"+kardexInt);
                        break;
                    case 29:
                        partidaregistral = cell.getNumericCellValue();
                        int partidaregistralInt = (int)partidaregistral; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 29++-+-+++-+-+-+-+partida registral:"+partidaregistralInt);
                        break;
                    case 30:
                        descpartidaregistral = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 30++-+-+++-+-+-+-+descripcion partida registral:"+descpartidaregistral);
                        break;
                    case 31:
                        asiento = cell.getNumericCellValue();
                        int asientoInt = (int)asiento; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 31++-+-+++-+-+-+-+asiento:"+asientoInt);
                        break;
                    case 32:
                        oficinaregistral = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 32++-+-+++-+-+-+-+oficina registral:"+oficinaregistral);
                        break;

                    //Ubigeo
                    case 33:
                        departamento = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 33++-+-+++-+-+-+-+departamento:"+departamento);
                        break;
                    case 34:
                        provincia = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 34++-+-+++-+-+-+-+provincia:"+provincia);
                        break;
                    case 35:
                        distrito = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 35++-+-+++-+-+-+-+distrito:"+distrito);
                        break;
                    case 36:
                        direccion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 36++-+-+++-+-+-+-+direccion:"+direccion);
                        break;

                    //TAB Deuda Garantía

                    case 37:
                        tcobertura = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 37++-+-+++-+-+-+-+tcobertura:"+tcobertura);
                        break;
                    case 38:
                        cudeudor = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 38++-+-+++-+-+-+-+cudeudor:"+cudeudor);
                        break;
                    case 39:
                        tlistado = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 39++-+-+++-+-+-+-+tlistado:"+tlistado);
                        break;
                    case 40:
                        nlineaope = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 40++-+-+++-+-+-+-+nlineaope:"+nlineaope);
                        break;
                    case 41:
                        monedacta = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 41++-+-+++-+-+-+-+Moneda de Cuenta:"+monedacta);
                        break;
                    case 42:
                        numoficinacta = cell.getNumericCellValue();
                        int numoficinactaInt = (int)numoficinacta; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 42++-+-+++-+-+-+-+Numero de Oficina / Tienda:"+numoficinactaInt);
                        break;
                    case 43:
                        numerocta = cell.getStringCellValue();
                        //int numeroctaInt = (int)numerocta; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 43++-+-+++-+-+-+-+Numero de Cuenta:" +numerocta);
                        break;
                    case 44:
                        descripcion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 44++-+-+++-+-+-+-+descripcion:"+descripcion);
                        break;
                    case 45:
                        comentario = cell.getNumericCellValue();
                        int comentarioInt = (int)comentario; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 45++-+-+++-+-+-+-+comentario:"+comentarioInt);
                        break;

                }// Fin switch (Columna)
                }//{} Fin (rowCount ==15)
            }//{} FIN (Cell cell : row)

            //data.put(i, datosFila);
            //System.out.println("-------------------La fila actual es:"+i);

            //Catidad de columnas (sin garantía)
            int cellCount = row.getLastCellNum() - row.getFirstCellNum();
            System.out.println("-----****************-----SEGUIMOS EN LA fila que tiene:"+ cellCount + " Columnas con data");
            if(cellCount == 46){



                //TAB Datos Generales
                //Inicio llenado campos
                //Código Unico - cu
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegHipotecasUi.TXT_CU, isEnabled()).forNoMoreThan(60).seconds(),
                        Enter.keyValues(Keys.HOME).into(RegHipotecasUi.TXT_CU),
                        Enter.theValue(cu).into(RegHipotecasUi.TXT_CU),
                        Enter.keyValues(Keys.END).into(RegHipotecasUi.TXT_CU),
                        Enter.keyValues(Keys.ENTER).into(RegHipotecasUi.TXT_CU)
                );

                //Espera a que mensaje "Cargando" no sea visible
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegHipotecasUi.Pop_Modal, isNotCurrentlyVisible()).forNoMoreThan(30).seconds()
                );
                //Graba mensaje cuando CU no existe
                String nombreracsoc;
                nombreracsoc = RegHipotecasUi.TXT_NOMBRERAZONSOC.resolveFor(theActorInTheSpotlight()).getValue();
                System.out.println("....El NOmbre o razón social es:"+nombreracsoc);

                if ((nombreracsoc == null) || (nombreracsoc.equals("")) ){
                    System.out.println("................................CU no existe!!!");
                    AlertAccept.Valida_CU_Hipoteca(Fila, cellCount);
                    Fin = "Si";
                }

                if (Fin == "No")
                {
                    //Tienda - tienda
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegHipotecasUi.Pop_Modal,isNotCurrentlyVisible()).forNoMoreThan(20).seconds(),
                            Click.on(RegHipotecasUi.TXT_TIENDA),
                            Enter.keyValues(Keys.HOME).into(RegHipotecasUi.TXT_TIENDA),
                            Enter.keyValues(String.valueOf(tienda)).into(RegHipotecasUi.TXT_TIENDA)
                    );
                    RegHipotecasUi.TXT_TIENDA.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.ENTER);


                    //Tipo de Documento  - tdocumento
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegHipotecasUi.TXT_TIENDA,isNotSelected()).forNoMoreThan(30).seconds(),
                            SelectFromOptions.byVisibleText(tdocumento).from(RegHipotecasUi.CBO_TDOCU)
                    );
                    Thread.sleep(3000);


                    //Rango
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(rango).from(RegHipotecasUi.CBO_RANGO),
                            WaitUntil.the(RegHipotecasUi.CBO_RANGO,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    Thread.sleep(5000);

                    if ((!RegHipotecasUi.CBO_RANGO.resolveFor(theActorInTheSpotlight()).hasFocus()))
                    {
                        System.out.println("{-{-{-{-{--{-{-{-{-{-{-{-CBO_RANGO SIN FOCO");
                    }



                    //Número de Documento
                    int ndocuInt = (int)ndocu; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(ndocuInt)).into(RegHipotecasUi.TXT_NUDOCU)
                    );
                    Thread.sleep(5000);

                    //Moneda Garantía
                    System.out.println(".-.-.-.-.-.-.-.-.-la moneda es:" +moneda);
/*                if(!moneda.equals("Soles")){
                    System.out.println("--------------------------------------------------Moneda dolares");
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegHipotecasUi.TXT_NUDOCU,isNotSelected()).forNoMoreThan(30).seconds(),
                            SelectFromOptions.byIndex(0).from(RegHipotecasUi.CBO_MONEDA)
                    );
                }
                Thread.sleep(5000);*/

                    if (moneda.equals("Soles")){
                        System.out.println("--------------------------------------------------Moneda Soles");
                        theActorInTheSpotlight().attemptsTo(
                                WaitUntil.the(RegHipotecasUi.TXT_NUDOCU,isNotSelected()).forNoMoreThan(30).seconds(),
                                SelectFromOptions.byIndex(1).from(RegHipotecasUi.CBO_MONEDA)
                        );
                    }
                    Thread.sleep(5000);


                    //Valor de Realización
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(valrealizacion)).into(RegHipotecasUi.TXT_VALREALIZACION)
                    );
                    Thread.sleep(3000);

                    //Valor Comercial
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(valcomercial)).into(RegHipotecasUi.TXT_VALCOMERCIAL)
                    );
                    Thread.sleep(3000);

                    //Valor de Realización
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(valgravamen)).into(RegHipotecasUi.TXT_VALGRAVAMEN)
                    );
                    Thread.sleep(3000);

                    //Fecha de Gravamen
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegHipotecasUi.TXT_VALGRAVAMEN,isNotSelected()).forNoMoreThan(30).seconds(),
                            Enter.theValue(fecgravamen).into(RegHipotecasUi.TXT_FECGRAVAMEN)
                    );
                    Thread.sleep(3000);

                    //Situación
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(situacion).from(RegHipotecasUi.CBO_SITUACION)
                    );
                    Thread.sleep(3000);

                    //Etapa
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(etapa).from(RegHipotecasUi.CBO_ETAPA)
                    );
                    Thread.sleep(3000);


                    //Información de Seguro
                    //Tipo de Póliza
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(tipopoliza).from(RegHipotecasUi.CBO_TIPOLIZA),
                            WaitUntil.the(RegHipotecasUi.CBO_TIPOLIZA,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    Thread.sleep(3000);

                    //if ((!tipopoliza.equals("INTERBANK"))|| (!tipopoliza.equals("NO COBRAR")))
                    if (tipopoliza.contains("EXTERNA"))
                    {
                        System.out.println("-------------------------------Tipo de poliza:" + tipopoliza);
                        //Nro Poliza
                        int nropolizaInt = (int)nropoliza; // Convert Double to Integer
                        theActorInTheSpotlight().attemptsTo(
                                WaitUntil.the(RegHipotecasUi.TXT_NROPOLIZA,isEnabled()).forNoMoreThan(30).seconds(),
                                Enter.keyValues(String.valueOf(nropolizaInt)).into(RegHipotecasUi.TXT_NROPOLIZA)
                        );
                        Thread.sleep(3000);


                        //Fecha Vcto Poliza
                        theActorInTheSpotlight().attemptsTo(
                                //WaitUntil.the(RegHipotecasUi.TXT_VALGRAVAMEN,isNotSelected()).forNoMoreThan(30).seconds(),
                                Enter.theValue(fecvtopoliza).into(RegHipotecasUi.TXT_FECVTOPOLIZA)
                        );
                        Thread.sleep(3000);


                        //Nombre Cia Seguro
                        theActorInTheSpotlight().attemptsTo(
                                SelectFromOptions.byVisibleText(nomciaseguro).from(RegHipotecasUi.CBO_NOMCIASEGURO)
                        );
                        Thread.sleep(5000);

                        //Importe Según Póliza Externa
                        theActorInTheSpotlight().attemptsTo(
                                WaitUntil.the(RegHipotecasUi.CBO_NOMCIASEGURO,isNotSelected()).forNoMoreThan(30).seconds(),
                                Enter.keyValues(String.valueOf(importepolext)).into(RegHipotecasUi.TXT_IMPPOLEXT)
                        );
                        Thread.sleep(3000);
                    }// FIN ((!tipopoliza.equals("INTERBANK"))|| (!tipopoliza.equals("NO COBRAR")))


                    //Información Tasación
                    //Perito
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegHipotecasUi.TXT_IMPPOLEXT,isNotSelected()).forNoMoreThan(30).seconds(),
                            SelectFromOptions.byVisibleText(perito).from(RegHipotecasUi.CBO_PERITO)
                    );
                    Thread.sleep(3000);

                    //Fecha de Tasación
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegHipotecasUi.CBO_PERITO,isNotSelected()).forNoMoreThan(30).seconds(),
                            Enter.theValue(fectasacion).into(RegHipotecasUi.TXT_FECTASACION)
                    );
                    Thread.sleep(3000);



                    //Tipo de Tasación
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(tipotasacion).from(RegHipotecasUi.CBO_TIPOTASACION)
                    );
                    Thread.sleep(3000);


                    //Moneda de Tasación
                    System.out.println(".-.-.-.-.-.-.-.-.-la moneda tasacion es:" +monedatasacion);
                /*if(!monedatasacion.equals("Soles")){
                    System.out.println("--------------------------------------------------Moneda tasacion dolares");
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegHipotecasUi.CBO_TIPOTASACION,isNotSelected()).forNoMoreThan(30).seconds(),
                            SelectFromOptions.byIndex(0).from(RegHipotecasUi.CBO_MONEDATASACION)
                    );
                }
                Thread.sleep(3000);*/

                    if (monedatasacion.equals("Soles")){
                        System.out.println("--------------------------------------------------Moneda Tasacion Soles");
                        theActorInTheSpotlight().attemptsTo(
                                WaitUntil.the(RegHipotecasUi.CBO_TIPOTASACION,isNotSelected()).forNoMoreThan(30).seconds(),
                                SelectFromOptions.byIndex(1).from(RegHipotecasUi.CBO_MONEDATASACION)
                        );
                    }
                    Thread.sleep(3000);

                    if (!tdocumento.contains("TERRENO")) {

                        //Valor de Construcción
                        theActorInTheSpotlight().attemptsTo(
                                Enter.keyValues(String.valueOf(valorconstruccion)).into(RegHipotecasUi.TXT_VALORCONSTRUCCION)
                        );

                        //Area Construida
                        theActorInTheSpotlight().attemptsTo(
                                Enter.keyValues(String.valueOf(areaconstruida)).into(RegHipotecasUi.TXT_AREACONSTRUIDA)
                        );

                        //Importe Asegurable de Tasación
                        theActorInTheSpotlight().attemptsTo(
                                Enter.keyValues(String.valueOf(importeasegtasacion)).into(RegHipotecasUi.TXT_IMPORTEASEGTASACION)
                        );
                    }

                    //Valor del Terreno
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(valorterreno)).into(RegHipotecasUi.TXT_VALORTERRENO)
                    );

                    //Area del Terreno
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(areaterreno)).into(RegHipotecasUi.TXT_AREATERRENO)
                    );

                    //Uso del Terreno
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(uso).from(RegHipotecasUi.CBO_USO),
                            WaitUntil.the(RegHipotecasUi.CBO_USO,isNotSelected()).forNoMoreThan(30).seconds()
                    );


                    //Información legal del Registro
                    //Notaria
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(notaria).into(RegHipotecasUi.TXT_NOTARIA),
                            WaitUntil.the(RegHipotecasUi.TXT_NOTARIA,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    Thread.sleep(3000);

                    //Kardex
                    int kardexInt = (int)kardex; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(kardexInt)).into(RegHipotecasUi.TXT_KARDEX),
                            WaitUntil.the(RegHipotecasUi.TXT_KARDEX,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    Thread.sleep(3000);

                    //Partida Registral
                    int partidaregistralInt = (int)partidaregistral; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(partidaregistralInt)).into(RegHipotecasUi.TXT_PARTIDAREGISTRAL),
                            WaitUntil.the(RegHipotecasUi.TXT_PARTIDAREGISTRAL,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    Thread.sleep(3000);


                    //Descripción Partida Registral
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(descpartidaregistral).into(RegHipotecasUi.TXT_DESCPARTIDAREGISTRAL),
                            WaitUntil.the(RegHipotecasUi.TXT_DESCPARTIDAREGISTRAL,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    Thread.sleep(3000);

                    //Asiento
                    int asientoInt = (int)asiento; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(asientoInt)).into(RegHipotecasUi.TXT_ASIENTO),
                            WaitUntil.the(RegHipotecasUi.TXT_ASIENTO,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    Thread.sleep(3000);

                    //Oficina Registral
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(oficinaregistral).from(RegHipotecasUi.CBO_OFICINAREGISTRAL),
                            WaitUntil.the(RegHipotecasUi.CBO_OFICINAREGISTRAL,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    Thread.sleep(6000);


                    //Ubigeo
                    //Departamento
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegHipotecasUi.CBO_ZONAREGSITRAL,isCurrentlyVisible()).forNoMoreThan(30).seconds(),
                            SelectFromOptions.byVisibleText(departamento).from(RegHipotecasUi.CBO_DEPARTAMENTO),
                            WaitUntil.the(RegHipotecasUi.CBO_DEPARTAMENTO,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    Thread.sleep(5000);
                    //Provincia
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(provincia).from(RegHipotecasUi.CBO_PROVINCIA),
                            WaitUntil.the(RegHipotecasUi.CBO_PROVINCIA,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    Thread.sleep(5000);
                    //Distrito
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(distrito).from(RegHipotecasUi.CBO_DISTRITO),
                            WaitUntil.the(RegHipotecasUi.CBO_DISTRITO,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    Thread.sleep(5000);
                    //Dirección
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(direccion).into(RegHipotecasUi.TXT_DIRECCION),
                            WaitUntil.the(RegHipotecasUi.TXT_DIRECCION,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    Thread.sleep(3000);



                    //--------------------------------------------------------------------------------------------------
                    // TAB: Deuda Garantía
                    //--------------------------------------------------------------------------------------------------
                    Thread.sleep(3000);
                    theActorInTheSpotlight().attemptsTo(
                            Click.on(RegHipotecasUi.TABDEUDA)
                    );
                    Thread.sleep(5000);


                    if (tcobertura.endsWith("rica")) {
                        System.out.println("******************************************GENERICA****************************");
                        theActorInTheSpotlight().attemptsTo(
                                Click.on(RegHipotecasUi.LBLTIPOCOBERTURA),
                                Enter.keyValues(Keys.DOWN).into(RegHipotecasUi.LBLTIPOCOBERTURA),
                                Enter.keyValues(Keys.TAB).into(RegHipotecasUi.LBLTIPOCOBERTURA),
                                AlertAccept.CobGen2()
                        );

                    } //Fin (tcobertura.endsWith("rica"))
                    Thread.sleep(5000);




                    //CU Deudor
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegHipotecasUi.TXT_CUDEUDOR,isEnabled()).forNoMoreThan(30).seconds(),
                            Enter.theValue(cudeudor).into(RegHipotecasUi.TXT_CUDEUDOR)
                    );
                    RegHipotecasUi.TXT_CUDEUDOR.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.ENTER);
                    WaitUntil.the(RegHipotecasUi.TXT_CUDEUDOR,isNotCurrentlyEnabled()).forNoMoreThan(30).seconds();
                    Thread.sleep(5000);



                    if (tcobertura.contains("Especifica")) {
                        if (tlistado.contains("Operaciones")) {
                            System.out.println("**************************OPERACIONES****************************");
                            theActorInTheSpotlight().attemptsTo(
                                    Click.on(RegHipotecasUi.RBT_TLISTADOOPE)
                            );
                            Thread.sleep(3000);

                            theActorInTheSpotlight().attemptsTo(
                                    WaitUntil.the(RegHipotecasUi.LBL_OPE,containsText("Nro Operacion")).forNoMoreThan(40).seconds()
                            );
                            Thread.sleep(3000);

                            //split divide la cadena en base a separador ";"
                            for (String numope: nlineaope.split(";")) {
                                //reemplaza espacios vacíos
                                numope = numope.replace(" ", "");

                                theActorInTheSpotlight().attemptsTo(
                                        WaitUntil.the(RegHipotecasUi.TXT_NROOPERACION, isEnabled()).forNoMoreThan(30).seconds(),
                                        Click.on(RegHipotecasUi.TXT_NROOPERACION),
                                        Enter.theValue(numope).into(RegHipotecasUi.TXT_NROOPERACION),
                                        Enter.keyValues(Keys.HOME).into(RegHipotecasUi.TXT_NROOPERACION),
                                        Enter.keyValues(Keys.END).into(RegHipotecasUi.TXT_NROOPERACION),
                                        Enter.keyValues(Keys.TAB).into(RegHipotecasUi.TXT_NROOPERACION),
                                        Enter.keyValues(Keys.SPACE).into(RegHipotecasUi.BTN_BUSCAROPE)
                                        //WaitUntil.the(RegHipotecasUi.TXT_NROOPERACION,containsText(nlineaope)).forNoMoreThan(30).seconds()
                                );
                                Thread.sleep(5000);


                                //Graba mensaje cuando operación no existe
                                theActorInTheSpotlight().attemptsTo(
                                        AlertAccept.OpeLinInvalid_HipotecaComercial(Fila, cellCount)
                                );
                                Thread.sleep(6000);


                                //TXT_NROOPERACION contiene (muestra) nlineaope cuando no existe la operación, entonces termina sin GAC
                                if (RegHipotecasUi.TXT_NROOPERACION.resolveFor(theActorInTheSpotlight()).containsValue(nlineaope)) {
                                    System.out.println("ope no existe");
                                    Fin = "Si";
                                    System.out.println("-----------Fin ope no existe" + Fin);
                                }
                            }
                        } // Fin (tlistado.contains("Operaciones"))


                        else if (tlistado.contains("Lineas")){
                            System.out.println("******************************************LINEAS****************************");
                            theActorInTheSpotlight().attemptsTo(
                                    Click.on(RegHipotecasUi.RBT_TLISTADOLINEA)
                            );

                            //split divide la cadena en base a separador ";"
                            for (String numlin: nlineaope.split(";")) {
                                //reemplaza espacios vacíos
                                numlin = numlin.replace(" ", "");

                                theActorInTheSpotlight().attemptsTo(
                                        WaitUntil.the(RegHipotecasUi.TXT_NROOPERACION, isEnabled()).forNoMoreThan(30).seconds(),
                                        Click.on(RegHipotecasUi.TXT_NROOPERACION),
                                        Enter.theValue(numlin).into(RegHipotecasUi.TXT_NROOPERACION),
                                        Enter.keyValues(Keys.HOME).into(RegHipotecasUi.TXT_NROOPERACION),
                                        Enter.keyValues(Keys.END).into(RegHipotecasUi.TXT_NROOPERACION),
                                        Enter.keyValues(Keys.TAB).into(RegHipotecasUi.TXT_NROOPERACION),
                                        Enter.keyValues(Keys.SPACE).into(RegHipotecasUi.BTN_BUSCAROPE)
                                );
                                Thread.sleep(5000);

                                //Graba mensaje cuando operación no existe
                                theActorInTheSpotlight().attemptsTo(
                                        AlertAccept.OpeLinInvalid_HipotecaComercial(Fila, cellCount)
                                );
                                Thread.sleep(6000);

                                //Lectura de Excel con último mensaje grabado (cuando linea no existe)
                                Cell grabado;
                                Sheet sheet2 = LoadXls.getSheet_HipotecaComercial(0, "Data-Hipotecas.xlsx");
                                grabado = sheet2.getRow(Fila).getCell(cellCount);
                                System.out.println("mensaje:" + grabado);

                                if (grabado != null) {
                                    System.out.println("Lines no existe");
                                    Fin = "Si";
                                    System.out.println("-----------Fin - Línea no existe" + Fin);
                                }
                            }

                        } // Fin (tlistado.contains("Lineas"))
                    } // Fin (tcobertura.contains("Especifica"))
                    Thread.sleep(3000);
                }


                if (Fin == "No"){
                    //Datos de la Cuenta
                    //Moneda de la cuenta
                    if (monedacta.equals("Soles")){
                        System.out.println("--------------------------------------------------Moneda CTA Soles");
                        theActorInTheSpotlight().attemptsTo(
                                SelectFromOptions.byIndex(1).from(RegHipotecasUi.CBO_MONEDACTA)
                        );
                    }
                    Thread.sleep(3000);

                    //Oficina de cuenta
                    int numoficinactaInt = (int)numoficinacta; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(numoficinactaInt)).into(RegHipotecasUi.TXT_NUMOFICINACTA),
                            WaitUntil.the(RegHipotecasUi.TXT_NUMOFICINACTA,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    Thread.sleep(3000);

                    //Numero de cuenta
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(numerocta).into(RegHipotecasUi.TXT_NUMEROCTA),
                            Enter.keyValues(Keys.HOME).into(RegHipotecasUi.TXT_NUMEROCTA),
                            Enter.keyValues(Keys.END).into(RegHipotecasUi.TXT_NUMEROCTA),
                            Enter.keyValues(Keys.ENTER).into(RegHipotecasUi.TXT_NUMEROCTA)
                    );
                    Thread.sleep(6000);

                    //Graba mensaje cuando cuenta no existe
                    theActorInTheSpotlight().attemptsTo(
                            AlertAccept.CtaInvalid_HipotecaComercial(Fila,cellCount)
                    );
                    Thread.sleep(6000);

                    //Boton no visible cuando cuenta no existe
                    if (!RegHipotecasUi.BTN_NVACTA.resolveFor(theActorInTheSpotlight()).isVisible())
                    {
                        System.out.println("cta no existe");
                        Fin = "Si";
                        System.out.println("-----------Fin x cta no existe: "+ Fin);
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
                            Click.on(RegHipotecasUi.TAB_DESCRIPCION)
                    );
                    Thread.sleep(3000);

                    //Descripción
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(descripcion).into(RegHipotecasUi.TXT_DESCRIPCION)
                    );

                    //Comentario
                    int comentarioInt = (int)comentario; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(comentarioInt)).into(RegHipotecasUi.TXT_COMENTARIO)
                            //Enter.theValue(comentario).into(RegCartaFianzaUi.TXT_COMENTARIO)
                    );
                    Thread.sleep(5000);

                    //--------------------------------------------------------------------------------------------------
                    // REGISTRAR GARANTIA
                    //--------------------------------------------------------------------------------------------------
                    RegHipotecasUi.BTN_REGISTRAR.resolveFor(theActorInTheSpotlight()).click();
                    keyEventMask = FocusEvent.KEY_EVENT_MASK;
                    theActorInTheSpotlight().attemptsTo(
                            AlertAccept.Aceptar_HipotecaComercial(Fila,cellCount, Fila)
                            //AlertAccept.accept()
                    );

                    try{
                        String GAR;
                        GAR = RegHipotecasUi.TXT_NROGARANTIA.resolveFor(theActorInTheSpotlight()).getText();
                        System.out.println("*************************" + GAR);

                        String GAC;
                        GAC = GAR.substring(GAR.lastIndexOf(". ")+1);
                        System.out.println("*************************" + GAC);
                        //System.out.println("-------------------------" +"|" + cu +"|"+ tienda+"|"+ tdocumento+"|"+ moneda+"|"+ fecvencimiento+"|"+ ndias+"|"+ ndocu+"|"+ porcentaje+"|"+ importe+"|"+ tcobertura+"|"+ cudeudor+"|"+ tlistado+"|"+ nlineaope+"|"+ descripcion+"|"+ comentario+"|"+GAC+"|");

                        if (GAR.contains("Se ha ingresado correctamente"))
                        {
                            //Escribir en Excel
                            //Sheet sheet = LoadXls.getSheet_CartaFianza(0,"Data-Carta_Fianza.xlsx");
                            System.out.println("-------Numero de Columna a insertar" + cellCount );
                            WriteXls.registro_HipotecaComercial(Fila, cellCount, GAC);


                            RegHipotecasUi.BTN_VOLVER.resolveFor(theActorInTheSpotlight()).click();
                        }
                        new GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_garantia_hipotecas();
                    /*else
                    {
                        System.out.println("Ingresa a catch cuando: El numero de Documento ya existe ");
                        GAC="El numero de Documento ya existe";
                        WriteXls.registro_HipotecaComercial(Fila, cellCount, GAC);
                        Thread.sleep(5000);
                        new GACMenuPrincipalStepDefinitions().se_ingresa_a_registrarGarantias();
                    }*/
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    //Fin llenado campos


                }

                if (Fin == "Si") {
                    System.out.println("-----------Fin - ejecucion por errores");
                    new GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_garantia_hipotecas();
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

