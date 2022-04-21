package starter.stepdefinitions.mobiliariabienes;

import io.cucumber.java.es.Entonces;
import motoresdebusqueda.gac.page.mobiliariabienes.RegMobiliariaBienesUi;
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

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RegGACStepDefinitions {

    private Object IsNotEnabledMatcher;
    private long keyEventMask;
    private static WebDriver driver;

@Entonces("se genera nueva Garantia Mobiliaria Bienes")
public void se_genera_nueva_garantia_mobiliaria_bienes() throws InterruptedException {

    try {
        Sheet sheet = LoadXls.getSheet_MobiliariaSobreBienes(0, "Data-MobiliariaSobreBienes.xlsx");
        String cu;
        double tienda;
        double ndocu;
        String tdocumento;
        String rango;
        String moneda;
        double valrealizacion;
        double valcomercial;
        double valgravamen;
        String fecgravamen;
        String situacion;
        String etapa;
        String propietario;
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
        double importeasegtasacion;
        double porcentaje;
        //Información legal del Registro
        String notaria;
        double kardex;
        double partidaregistral;
        String descpartidaregistral;
        String oficinaregistral;
        String colorvehiculo;
        String serie;
        String motor;
        String placa;
        String modelovehiculo;
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
            ndocu = 0;
            tdocumento="";
            rango="";
            moneda ="";
            valrealizacion = 0;
            valcomercial = 0;
            valgravamen = 0;
            fecgravamen= "";
            situacion = "";
            etapa="";
            propietario="";
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
            importeasegtasacion= 0;
            porcentaje= 0;
            //Información legal del Registro
            notaria="";
            kardex=0;
            partidaregistral=0;
            descpartidaregistral="";
            oficinaregistral="";
            colorvehiculo="";
            serie="";
            motor="";
            placa="";
            modelovehiculo="";
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
                if (cellCount ==47) {
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
                        ndocu = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 2++-+-+++-+-+-+-+ndocu:"+ndocu);
/*                        int ndocuInt = (int)ndocu; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 5++-+-+++-+-+-+-+ndocu:"+ndocuInt);*/
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
                        System.out.println("-++++-+++-++++-Columna 9++-+-+++-+-+-+-+fecgravamen:"+ fecgravamen);
                        break;
                    case 10:
                        situacion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 10++-+-+++-+-+-+-+Situacion:"+situacion);
                        break;
                    case 11:
                        etapa = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 11++-+-+++-+-+-+-+Etapa:"+etapa);
                        break;
                    case 12:
                        propietario = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 12++-+-+++-+-+-+-+Propietario:"+propietario);
                        break;

                    //información de Seguro
                    case 13:
                        tipopoliza = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 13++-+-+++-+-+-+-+Tipo de Poliza:"+tipopoliza);
                        break;
                    case 14:
                        nropoliza =cell.getNumericCellValue();
                        int nropolizaInt = (int)nropoliza; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 14++-+-+++-+-+-+-+Nro de Poliza:"+nropolizaInt);
                        break;
                    case 15:
                        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy"); //SimpleDateFormat
                        fecvtopoliza = dateFormat2.format(cell.getDateCellValue());
                        System.out.println("-++++-+++-++++-Columna 15++-+-+++-+-+-+-+Fecha de Vencimiento de Poliza:"+fecvtopoliza);
                        break;
                    case 16:
                        nomciaseguro = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 16++-+-+++-+-+-+-+Nombre CIA Seguro:"+nomciaseguro);
                        break;
                    case 17:
                        importepolext = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 17++-+-+++-+-+-+-+Importe Segun Poliza Externa :"+importepolext);
                        break;

                    //Información Tasación
                    case 18:
                        perito = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 18++-+-+++-+-+-+-+Perito:"+perito);
                        break;
                    case 19:
                        SimpleDateFormat dateFormat3 = new SimpleDateFormat("dd/MM/yyyy"); //SimpleDateFormat
                        fectasacion = dateFormat3.format(cell.getDateCellValue());
                        System.out.println("-++++-+++-++++-Columna 19++-+-+++-+-+-+-+Fecha de Tasacion:"+fectasacion);
                        break;
                    case 20:
                        tipotasacion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 20++-+-+++-+-+-+-+Tipo de Tasacion:"+tipotasacion);
                        break;
                    case 21:
                        monedatasacion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 21++-+-+++-+-+-+-+Moneda de Tasacion:"+monedatasacion);
                        break;

                    case 22:
                        importeasegtasacion = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 22++-+-+++-+-+-+-+Importe Asegurable de Tasacion:"+importeasegtasacion);
                        break;
                    case 23:
                        porcentaje = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 23++-+-+++-+-+-+-+Porcentaje:"+porcentaje);
                        break;


                    //Información legal del Registro
                    case 24:
                        notaria = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 24++-+-+++-+-+-+-+Notaria:"+notaria);
                        break;
                    case 25:
                        kardex = cell.getNumericCellValue();
                        int kardexInt = (int)kardex; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 25++-+-+++-+-+-+-+Kardex:"+kardexInt);
                        break;
                    case 26:
                        partidaregistral = cell.getNumericCellValue();
                        int partidaregistralInt = (int)partidaregistral; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 26++-+-+++-+-+-+-+partida registral:"+partidaregistralInt);
                        break;
                    case 27:
                        descpartidaregistral = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 27++-+-+++-+-+-+-+descripcion partida registral:"+descpartidaregistral);
                        break;

                    case 28:
                        oficinaregistral = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 28++-+-+++-+-+-+-+oficina registral:"+oficinaregistral);
                        break;

                    //Información Vehicular
                    case 29:
                        colorvehiculo = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 29++-+-+++-+-+-+-+Color del Vehiculo:"+colorvehiculo);
                        break;
                    case 30:
                        serie = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 30++-+-+++-+-+-+-+Serie:"+serie);
                        break;
                    case 31:
                        motor = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 31++-+-+++-+-+-+-+Motor:"+motor);
                        break;
                    case 32:
                        placa = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 32++-+-+++-+-+-+-+Placa:"+placa);
                        break;
                    case 33:
                        modelovehiculo = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 33++-+-+++-+-+-+-+Modelo del Vehiculo:"+modelovehiculo);

                    //Ubigeo
                    case 34:
                        departamento = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 34++-+-+++-+-+-+-+departamento:"+departamento);
                        break;
                    case 35:
                        provincia = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 35++-+-+++-+-+-+-+provincia:"+provincia);
                        break;
                    case 36:
                        distrito = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 36++-+-+++-+-+-+-+distrito:"+distrito);
                        break;
                    case 37:
                        direccion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 37++-+-+++-+-+-+-+direccion:"+direccion);
                        break;

                    //TAB Deuda Garantía

                    case 38:
                        tcobertura = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 38++-+-+++-+-+-+-+tcobertura:"+tcobertura);
                        break;
                    case 39:
                        cudeudor = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 39++-+-+++-+-+-+-+cudeudor:"+cudeudor);
                        break;
                    case 40:
                        tlistado = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 40++-+-+++-+-+-+-+tlistado:"+tlistado);
                        break;
                    case 41:
                        nlineaope = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 41++-+-+++-+-+-+-+nlineaope:"+nlineaope);
                        break;
                    case 42:
                        monedacta = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 42++-+-+++-+-+-+-+Moneda de Cuenta:"+monedacta);
                        break;
                    case 43:
                        numoficinacta = cell.getNumericCellValue();
                        int numoficinactaInt = (int)numoficinacta; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 43++-+-+++-+-+-+-+Numero de Oficina / Tienda:"+numoficinactaInt);
                        break;
                    case 44:
                        numerocta = cell.getStringCellValue();
                        //int numeroctaInt = (int)numerocta; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 44++-+-+++-+-+-+-+Numero de Cuenta:" +numerocta);
                        break;
                    case 45:
                        descripcion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 45++-+-+++-+-+-+-+descripcion:"+descripcion);
                        break;
                    case 46:
                        comentario = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 46++-+-+++-+-+-+-+comentario:"+comentario);
                        break;

                }// Fin switch (Columna)
                }//{} Fin (rowCount ==15)
            }//{} FIN (Cell cell : row)

            //data.put(i, datosFila);
            //System.out.println("-------------------La fila actual es:"+i);

            //Catidad de columnas (sin garantía)
            int cellCount = row.getLastCellNum() - row.getFirstCellNum();
            System.out.println("-----****************-----SEGUIMOS EN LA fila que tiene:"+ cellCount + " Columnas con data");
            if(cellCount == 47){




                //TAB Datos Generales
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegMobiliariaBienesUi.TAB_DATOS_GENERALES, isEnabled()).forNoMoreThan(60).seconds(),
                        Click.on(RegMobiliariaBienesUi.TAB_DATOS_GENERALES),
                        WaitUntil.the(RegMobiliariaBienesUi.TXT_CU, isVisible()).forNoMoreThan(30).seconds()
                );
                //Thread.sleep(3000);

                //Inicio llenado campos
                //Código Unico - cu
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegMobiliariaBienesUi.TXT_CU, isEnabled()).forNoMoreThan(60).seconds(),
                        Enter.keyValues(Keys.HOME).into(RegMobiliariaBienesUi.TXT_CU),
                        Enter.theValue(cu).into(RegMobiliariaBienesUi.TXT_CU),
                        Enter.keyValues(Keys.END).into(RegMobiliariaBienesUi.TXT_CU),
                        Enter.keyValues(Keys.ENTER).into(RegMobiliariaBienesUi.TXT_CU)
                );

                //Espera a que mensaje "Cargando" no sea visible
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegMobiliariaBienesUi.Pop_Modal, isNotCurrentlyVisible()).forNoMoreThan(30).seconds()
                );
                //Graba mensaje cuando CU no existe
                String nombreracsoc;
                nombreracsoc = RegMobiliariaBienesUi.TXT_NOMBRERAZONSOC.resolveFor(theActorInTheSpotlight()).getValue();
                System.out.println("....El NOmbre o razón social es:"+nombreracsoc);

                if ((nombreracsoc == null) || (nombreracsoc.equals("")) ){
                    System.out.println("................................CU no existe!!!");
                    AlertAccept.Valida_CU_MobiliariaBienes(Fila, cellCount);
                    Fin = "Si";
                }

                if (Fin == "No")
                {
                    //Tienda - tienda
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegMobiliariaBienesUi.Pop_Modal,isNotCurrentlyVisible()).forNoMoreThan(30).seconds(),
                            Click.on(RegMobiliariaBienesUi.TXT_TIENDA),
                            Enter.keyValues(Keys.HOME).into(RegMobiliariaBienesUi.TXT_TIENDA),
                            Enter.keyValues(String.valueOf(tienda)).into(RegMobiliariaBienesUi.TXT_TIENDA)
                    );
                    RegMobiliariaBienesUi.TXT_TIENDA.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.ENTER);


                    //Número de Documento
                    int ndocuInt = (int)ndocu; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(ndocuInt)).into(RegMobiliariaBienesUi.TXT_NUDOCU)
                    );
                    //Thread.sleep(3000);


                    //Tipo de Documento  - tdocumento
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(tdocumento).from(RegMobiliariaBienesUi.CBO_TDOCU)
                            //WaitUntil.the(RegMobiliariaBienesUi.CBO_TDOCU,containsSelectOption(tdocumento)).forNoMoreThan(5).seconds()
                    );
                    Thread.sleep(3000);


                    //Rango
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegMobiliariaBienesUi.CBO_TDOCU,isNotSelected()).forNoMoreThan(6).seconds(),
                            SelectFromOptions.byVisibleText(rango).from(RegMobiliariaBienesUi.CBO_RANGO),
                            WaitUntil.the(RegMobiliariaBienesUi.CBO_RANGO,containsSelectOption(rango)).forNoMoreThan(6).seconds()
                    );
                    Thread.sleep(5000);



                    //Moneda Garantía
                    System.out.println(".-.-.-.-.-.-.-.-.-la moneda es:" +moneda);
/*                if(!moneda.equals("Soles")){
                    System.out.println("--------------------------------------------------Moneda dolares");
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegMobiliariaBienesUi.CBO_RANGO,isNotSelected()).forNoMoreThan(30).seconds(),
                            SelectFromOptions.byIndex(0).from(RegMobiliariaBienesUi.CBO_MONEDA)
                    );
                }
                Thread.sleep(5000);*/

                    if (moneda.equals("Soles")){
                        System.out.println("--------------------------------------------------Moneda Soles");
                        theActorInTheSpotlight().attemptsTo(
                                WaitUntil.the(RegMobiliariaBienesUi.CBO_RANGO,isNotSelected()).forNoMoreThan(30).seconds(),
                                SelectFromOptions.byIndex(1).from(RegMobiliariaBienesUi.CBO_MONEDA)
                        );
                    }
                    Thread.sleep(5000);


                    //Valor de Realización
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegMobiliariaBienesUi.CBO_MONEDA,isNotSelected()).forNoMoreThan(30).seconds(),
                            Enter.keyValues(String.valueOf(valrealizacion)).into(RegMobiliariaBienesUi.TXT_VALREALIZACION)
                    );
                    //Thread.sleep(3000);


                    //Valor Comercial
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegMobiliariaBienesUi.TXT_VALREALIZACION,isNotSelected()).forNoMoreThan(30).seconds(),
                            Enter.keyValues(String.valueOf(valcomercial)).into(RegMobiliariaBienesUi.TXT_VALCOMERCIAL)
                    );
                    //Thread.sleep(3000);


                    //Valor de Gravamen
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegMobiliariaBienesUi.TXT_VALCOMERCIAL,isNotSelected()).forNoMoreThan(30).seconds(),
                            Enter.keyValues(String.valueOf(valgravamen)).into(RegMobiliariaBienesUi.TXT_VALGRAVAMEN)
                    );
                    //Thread.sleep(3000);

/*                //Validacion de campos
                if (!RegMobiliariaBienesUi.TXT_VALREALIZACION.resolveFor(theActorInTheSpotlight()).containsValue(String.valueOf(valrealizacion)))
                {
                    System.out.println("Valor de realizacion no ingresado!!!");
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(valrealizacion)).into(RegMobiliariaBienesUi.TXT_VALREALIZACION)
                    );

                }
                if (!RegMobiliariaBienesUi.TXT_VALCOMERCIAL.resolveFor(theActorInTheSpotlight()).containsValue(String.valueOf(valcomercial)))
                {
                    System.out.println("Valor de comercial no ingresado!!!");
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(valcomercial)).into(RegMobiliariaBienesUi.TXT_VALCOMERCIAL)
                    );

                }
                if (RegMobiliariaBienesUi.TXT_VALGRAVAMEN =valgravamen)
                {
                    System.out.println("Valor de Gravamen no ingresado!!!");
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(valgravamen)).into(RegMobiliariaBienesUi.TXT_VALGRAVAMEN)
                    );
                }*/


                    //Fecha de Gravamen
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(fecgravamen).into(RegMobiliariaBienesUi.TXT_FECGRAVAMEN)
                    );
                    Thread.sleep(1000);

                    //Situación
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(situacion).from(RegMobiliariaBienesUi.CBO_SITUACION),
                            WaitUntil.the(RegMobiliariaBienesUi.CBO_SITUACION,containsSelectOption(situacion)).forNoMoreThan(5).seconds()
                    );

                    if (RegMobiliariaBienesUi.CBO_SITUACION.equals("EN TRAMITE"))
                    {
                        Thread.sleep(5000);
                    }


                    //Etapa
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(etapa).from(RegMobiliariaBienesUi.CBO_ETAPA),
                            WaitUntil.the(RegMobiliariaBienesUi.CBO_ETAPA,containsSelectOption(etapa)).forNoMoreThan(5).seconds()
                    );
                    Thread.sleep(3000);

                    //Propietario
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(propietario).into(RegMobiliariaBienesUi.TXT_PROPIETARIO)
                    );
                    //Thread.sleep(3000);


                    //Información de Seguro
                    //Tipo de Póliza
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(tipopoliza).from(RegMobiliariaBienesUi.CBO_TIPOLIZA)
                    );
                    Thread.sleep(3000);

                    //if ((!tipopoliza.equals("INTERBANK"))|| (!tipopoliza.equals("NO COBRAR")))
                    if (tipopoliza.contains("EXTERNA"))
                    {
                        System.out.println("-------------------------------Tipo de poliza:" + tipopoliza);
                        //Nro Poliza
                        int nropolizaInt = (int)nropoliza; // Convert Double to Integer
                        theActorInTheSpotlight().attemptsTo(
                                WaitUntil.the(RegMobiliariaBienesUi.TXT_NROPOLIZA,isEnabled()).forNoMoreThan(30).seconds(),
                                Enter.keyValues(String.valueOf(nropolizaInt)).into(RegMobiliariaBienesUi.TXT_NROPOLIZA)
                        );
                        Thread.sleep(3000);


                        //Fecha Vcto Poliza
                        theActorInTheSpotlight().attemptsTo(
                                Enter.theValue(fecvtopoliza).into(RegMobiliariaBienesUi.TXT_FECVTOPOLIZA)
                        );
                        Thread.sleep(1000);


                        //Nombre Cia Seguro
                        theActorInTheSpotlight().attemptsTo(
                                SelectFromOptions.byVisibleText(nomciaseguro).from(RegMobiliariaBienesUi.CBO_NOMCIASEGURO)
                                //WaitUntil.the(RegMobiliariaBienesUi.CBO_NOMCIASEGURO,containsSelectOption(nomciaseguro)).forNoMoreThan(6).seconds()
                        );
                        Thread.sleep(4000);

                        //Importe Según Póliza Externa
                        theActorInTheSpotlight().attemptsTo(
                                WaitUntil.the(RegMobiliariaBienesUi.CBO_NOMCIASEGURO,isNotSelected()).forNoMoreThan(30).seconds(),
                                Enter.keyValues(String.valueOf(importepolext)).into(RegMobiliariaBienesUi.TXT_IMPPOLEXT)
                        );
                        Thread.sleep(3000);
                    }// FIN ((!tipopoliza.equals("INTERBANK"))|| (!tipopoliza.equals("NO COBRAR")))


                    //Información Tasación
                    //Perito
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegMobiliariaBienesUi.TXT_IMPPOLEXT,isNotSelected()).forNoMoreThan(30).seconds(),
                            SelectFromOptions.byVisibleText(perito).from(RegMobiliariaBienesUi.CBO_PERITO)
                    );
                    Thread.sleep(3000);

                    //Fecha de Tasación
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegMobiliariaBienesUi.CBO_PERITO,isNotSelected()).forNoMoreThan(30).seconds(),
                            Enter.theValue(fectasacion).into(RegMobiliariaBienesUi.TXT_FECTASACION)
                    );
                    //Thread.sleep(3000);



                    //Tipo de Tasación
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(tipotasacion).from(RegMobiliariaBienesUi.CBO_TIPOTASACION),
                            WaitUntil.the(RegMobiliariaBienesUi.CBO_TIPOTASACION,containsSelectOption(tipotasacion)).forNoMoreThan(5).seconds()
                    );
                    Thread.sleep(1000);


                    //Moneda de Tasación
                    System.out.println(".-.-.-.-.-.-.-.-.-la moneda tasacion es:" +monedatasacion);
                /*if(!monedatasacion.equals("Soles")){
                    System.out.println("--------------------------------------------------Moneda tasacion dolares");
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegMobiliariaBienesUi.CBO_TIPOTASACION,isNotSelected()).forNoMoreThan(30).seconds(),
                            SelectFromOptions.byIndex(0).from(RegMobiliariaBienesUi.CBO_MONEDATASACION)
                    );
                }
                Thread.sleep(3000);*/

                    if (monedatasacion.equals("Soles")){
                        System.out.println("--------------------------------------------------Moneda Tasacion Soles");
                        theActorInTheSpotlight().attemptsTo(
                                SelectFromOptions.byIndex(1).from(RegMobiliariaBienesUi.CBO_MONEDATASACION)
                        );
                    }
                    Thread.sleep(1000);


                    //Importe Asegurable de Tasación
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegMobiliariaBienesUi.CBO_MONEDATASACION,isNotSelected()).forNoMoreThan(30).seconds(),
                            Enter.keyValues(String.valueOf(importeasegtasacion)).into(RegMobiliariaBienesUi.TXT_IMPORTEASEGTASACION)
                    );
                    Thread.sleep(1000);


                    //Porcentaje
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(porcentaje)).into(RegMobiliariaBienesUi.TXT_PORCENTAJE)
                    );



                    //Información legal del Registro
                    //Notaria
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(notaria).into(RegMobiliariaBienesUi.TXT_NOTARIA),
                            WaitUntil.the(RegMobiliariaBienesUi.TXT_NOTARIA,isNotSelected()).forNoMoreThan(5).seconds()
                    );
                    //Thread.sleep(3000);

                    //Kardex
                    int kardexInt = (int)kardex; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(kardexInt)).into(RegMobiliariaBienesUi.TXT_KARDEX),
                            WaitUntil.the(RegMobiliariaBienesUi.TXT_KARDEX,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    //Thread.sleep(3000);

                    //Partida Registral
                    int partidaregistralInt = (int)partidaregistral; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(partidaregistralInt)).into(RegMobiliariaBienesUi.TXT_PARTIDAREGISTRAL),
                            WaitUntil.the(RegMobiliariaBienesUi.TXT_PARTIDAREGISTRAL,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    //Thread.sleep(3000);


                    //Descripción Partida Registral
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(descpartidaregistral).into(RegMobiliariaBienesUi.TXT_DESCPARTIDAREGISTRAL),
                            WaitUntil.the(RegMobiliariaBienesUi.TXT_DESCPARTIDAREGISTRAL,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    //Thread.sleep(3000);


                    //Oficina Registral
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(oficinaregistral).from(RegMobiliariaBienesUi.CBO_OFICINAREGISTRAL)
                            //WaitUntil.the(RegMobiliariaBienesUi.CBO_OFICINAREGISTRAL,containsSelectOption(oficinaregistral)).forNoMoreThan(6).seconds()
                    );
                    Thread.sleep(6000);


                    //INFORMACION VEHICULAR
                    if (tdocumento.contains("VEHICULAR")) {

                        //Color del Vehículo
                        theActorInTheSpotlight().attemptsTo(
                                //WaitUntil.the(RegMobiliariaBienesUi.CBO_ZONAREGSITRAL,isCurrentlyVisible()).forNoMoreThan(30).seconds(),
                                //Click.on(RegMobiliariaBienesUi.TXT_COLORVEHICULO),
                                Enter.theValue(colorvehiculo).into(RegMobiliariaBienesUi.TXT_COLORVEHICULO)
                        );

                        //Serie
                        theActorInTheSpotlight().attemptsTo(
                                //Click.on(RegMobiliariaBienesUi.TXT_SERIE),
                                //Enter.keyValues(Keys.HOME).into(RegMobiliariaBienesUi.TXT_SERIE),
                                Enter.theValue(serie).into(RegMobiliariaBienesUi.TXT_SERIE)
                                //WaitUntil.the(RegMobiliariaBienesUi.TXT_SERIE,isNotSelected()).forNoMoreThan(5).seconds()
                        );


                        //Motor
                        theActorInTheSpotlight().attemptsTo(
                                //Click.on(RegMobiliariaBienesUi.TXT_MOTOR),
                                //Enter.keyValues(Keys.HOME).into(RegMobiliariaBienesUi.TXT_MOTOR),
                                Enter.theValue(motor).into(RegMobiliariaBienesUi.TXT_MOTOR)
                                //WaitUntil.the(RegMobiliariaBienesUi.TXT_MOTOR,isNotSelected()).forNoMoreThan(5).seconds()
                        );


                        //Placa
                        theActorInTheSpotlight().attemptsTo(
                                //Click.on(RegMobiliariaBienesUi.TXT_PLACA),
                                //Enter.keyValues(Keys.HOME).into(RegMobiliariaBienesUi.TXT_PLACA),
                                Enter.theValue(placa).into(RegMobiliariaBienesUi.TXT_PLACA)
                                //WaitUntil.the(RegMobiliariaBienesUi.TXT_PLACA,isNotSelected()).forNoMoreThan(5).seconds()
                        );


                        //Modelo el Vehiculo
                        theActorInTheSpotlight().attemptsTo(
                                //Click.on(RegMobiliariaBienesUi.TXT_MODELOVEHICULO),
                                //Enter.keyValues(Keys.HOME).into(RegMobiliariaBienesUi.TXT_MODELOVEHICULO),
                                Enter.theValue(modelovehiculo).into(RegMobiliariaBienesUi.TXT_MODELOVEHICULO)
                                //WaitUntil.the(RegMobiliariaBienesUi.TXT_MODELOVEHICULO,isNotSelected()).forNoMoreThan(5).seconds()
                        );
                    }



                    //Ubigeo
                    //Departamento
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegMobiliariaBienesUi.CBO_ZONAREGSITRAL,isCurrentlyVisible()).forNoMoreThan(30).seconds(),
                            SelectFromOptions.byVisibleText(departamento).from(RegMobiliariaBienesUi.CBO_DEPARTAMENTO),
                            WaitUntil.the(RegMobiliariaBienesUi.CBO_DEPARTAMENTO,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    Thread.sleep(6000);
                    //Provincia
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(provincia).from(RegMobiliariaBienesUi.CBO_PROVINCIA),
                            WaitUntil.the(RegMobiliariaBienesUi.CBO_PROVINCIA,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    Thread.sleep(7000);
                    //Distrito
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(distrito).from(RegMobiliariaBienesUi.CBO_DISTRITO),
                            WaitUntil.the(RegMobiliariaBienesUi.CBO_DISTRITO,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    Thread.sleep(6000);
                    //Dirección
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(direccion).into(RegMobiliariaBienesUi.TXT_DIRECCION)
                    );
                    Thread.sleep(3000);


                    //--------------------------------------------------------------------------------------------------
                    // TAB: Deuda Garantía
                    //--------------------------------------------------------------------------------------------------
                    Thread.sleep(3000);
                    theActorInTheSpotlight().attemptsTo(
                            Click.on(RegMobiliariaBienesUi.TABDEUDA)
                    );
                    Thread.sleep(5000);


                    if (tcobertura.endsWith("rica")) {
                        System.out.println("******************************************GENERICA****************************");
                        theActorInTheSpotlight().attemptsTo(
                                Click.on(RegMobiliariaBienesUi.LBLTIPOCOBERTURA),
                                Enter.keyValues(String.valueOf(Keys.DOWN)).into(RegMobiliariaBienesUi.LBLTIPOCOBERTURA),
                                Enter.keyValues(String.valueOf(Keys.TAB)).into(RegMobiliariaBienesUi.LBLTIPOCOBERTURA)
                                //SelectFromOptions.byValue("1").from(RegMobiliariaBienesUi.CBO_TIPOCOBERTURA)
                        );

                        //CommonClass.waitForAlert(BrowseTheWeb.as(theActorInTheSpotlight()).getDriver(),0);
                        ////getDriver().switchTo().alert().accept();
                        //theActorInTheSpotlight().attemptsTo(AlertAccept.toAccept());
                        //Thread.sleep(4000);
                        //AlertAccept.CobGen2();
                        //System.out.println("----POst Alert");


                    } //Fin (tcobertura.endsWith("rica"))
                    //Thread.sleep(6000);


/*
                if ((!RegMobiliariaBienesUi.TXT_CUDEUDOR.resolveFor(theActorInTheSpotlight()).hasFocus()))
                {
                    System.out.println("----TXT_CUDEUDOR sn foco");
                    AlertAccept.CobGen();
                }
                System.out.println("----Despues de if");
*/



                    //CU Deudor
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegMobiliariaBienesUi.TXT_CUDEUDOR,isEnabled()).forNoMoreThan(30).seconds(),
                            Enter.theValue(cudeudor).into(RegMobiliariaBienesUi.TXT_CUDEUDOR)
                    );
                    RegMobiliariaBienesUi.TXT_CUDEUDOR.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.ENTER);
                    WaitUntil.the(RegMobiliariaBienesUi.TXT_CUDEUDOR,isNotCurrentlyEnabled()).forNoMoreThan(30).seconds();
                    Thread.sleep(5000);


                    if (tcobertura.contains("Especifica")) {
                        if (tlistado.contains("Operaciones")) {
                            System.out.println("**************************OPERACIONES****************************");
                            theActorInTheSpotlight().attemptsTo(
                                    Click.on(RegMobiliariaBienesUi.RBT_TLISTADOOPE)
                            );
                            Thread.sleep(3000);

                            theActorInTheSpotlight().attemptsTo(
                                    WaitUntil.the(RegMobiliariaBienesUi.LBL_OPE,containsText("Nro Operacion")).forNoMoreThan(40).seconds()
                            );
                            Thread.sleep(3000);

                            //split divide la cadena en base a separador ";"
                            for (String numope: nlineaope.split(";")) {
                                //reemplaza espacios vacíos
                                numope = numope.replace(" ", "");

                                theActorInTheSpotlight().attemptsTo(
                                        WaitUntil.the(RegMobiliariaBienesUi.TXT_NROOPERACION, isEnabled()).forNoMoreThan(30).seconds(),
                                        Click.on(RegMobiliariaBienesUi.TXT_NROOPERACION),
                                        Enter.theValue(numope).into(RegMobiliariaBienesUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.HOME)).into(RegMobiliariaBienesUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.END)).into(RegMobiliariaBienesUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.TAB)).into(RegMobiliariaBienesUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.SPACE)).into(RegMobiliariaBienesUi.BTN_BUSCAROPE)
                                        //WaitUntil.the(RegMobiliariaBienesUi.TXT_NROOPERACION,containsText(nlineaope)).forNoMoreThan(30).seconds()
                                );
                                Thread.sleep(5000);


                                //Graba mensaje cuando operación no existe
                                theActorInTheSpotlight().attemptsTo(
                                        AlertAccept.OpeLinInvalid_MobiliariaBienes(Fila, cellCount)
                                );
                                Thread.sleep(6000);


                                //TXT_NROOPERACION contiene (muestra) nlineaope cuando no existe la operación, entonces termina sin GAC
                                if (RegMobiliariaBienesUi.TXT_NROOPERACION.resolveFor(theActorInTheSpotlight()).containsValue(nlineaope)) {
                                    System.out.println("ope no existe");
                                    Fin = "Si";
                                    System.out.println("-----------Fin ope no existe" + Fin);
                                }
                            }
                        } // Fin (tlistado.contains("Operaciones"))


                        else if (tlistado.contains("Lineas")){
                            System.out.println("******************************************LINEAS****************************");
                            theActorInTheSpotlight().attemptsTo(
                                    Click.on(RegMobiliariaBienesUi.RBT_TLISTADOLINEA)
                            );

                            //split divide la cadena en base a separador ";"
                            for (String numlin: nlineaope.split(";")) {
                                //reemplaza espacios vacíos
                                numlin = numlin.replace(" ", "");

                                theActorInTheSpotlight().attemptsTo(
                                        WaitUntil.the(RegMobiliariaBienesUi.TXT_NROOPERACION, isEnabled()).forNoMoreThan(30).seconds(),
                                        Click.on(RegMobiliariaBienesUi.TXT_NROOPERACION),
                                        Enter.theValue(numlin).into(RegMobiliariaBienesUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.HOME)).into(RegMobiliariaBienesUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.END)).into(RegMobiliariaBienesUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.TAB)).into(RegMobiliariaBienesUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.SPACE)).into(RegMobiliariaBienesUi.BTN_BUSCAROPE)
                                );
                                Thread.sleep(5000);

                                //Graba mensaje cuando línea no existe
                                theActorInTheSpotlight().attemptsTo(
                                        AlertAccept.OpeLinInvalid_MobiliariaBienes(Fila, cellCount)
                                );
                                Thread.sleep(6000);

                                //Lectura de Excel con último mensaje grabado (cuando linea no existe)
                                Cell grabado;
                                Sheet sheet2 = LoadXls.getSheet_MobiliariaSobreBienes(0, "Data-MobiliariaSobreBienes.xlsx");
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



                if (Fin == "No"){
                    //Datos de la Cuenta
                    //Moneda de la cuenta
                    if (monedacta.equals("Soles")){
                        System.out.println("--------------------------------------------------Moneda CTA Soles");
                        theActorInTheSpotlight().attemptsTo(
                                SelectFromOptions.byIndex(1).from(RegMobiliariaBienesUi.CBO_MONEDACTA)
                        );
                    }
                    Thread.sleep(3000);

                    //Oficina de cuenta
                    int numoficinactaInt = (int)numoficinacta; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(numoficinactaInt)).into(RegMobiliariaBienesUi.TXT_NUMOFICINACTA),
                            WaitUntil.the(RegMobiliariaBienesUi.TXT_NUMOFICINACTA,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    Thread.sleep(3000);

                    //Numero de cuenta
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(numerocta).into(RegMobiliariaBienesUi.TXT_NUMEROCTA),
                            Enter.keyValues(String.valueOf(Keys.HOME)).into(RegMobiliariaBienesUi.TXT_NUMEROCTA),
                            Enter.keyValues(String.valueOf(Keys.END)).into(RegMobiliariaBienesUi.TXT_NUMEROCTA),
                            Enter.keyValues(String.valueOf(Keys.ENTER)).into(RegMobiliariaBienesUi.TXT_NUMEROCTA)
                    );
                    Thread.sleep(6000);
                    //WaitUntil.the(RegMobiliariaBienesUi.Pop_Modal,isNotCurrentlyVisible()).forNoMoreThan(30).seconds(),



                    //Graba mensaje cuando cuenta no existe
                    theActorInTheSpotlight().attemptsTo(
                            //WaitUntil.the(RegMobiliariaBienesUi.LBL_CARGANDO_CTA,isNotCurrentlyVisible()).forNoMoreThan(30).seconds(),
                            AlertAccept.CtaInvalid_MobiliariaBienes(Fila,cellCount)
                    );
                    Thread.sleep(7000);


                    //Boton no visible cuando cuenta no existe
                    if (!RegMobiliariaBienesUi.BTN_NVACTA.resolveFor(theActorInTheSpotlight()).isVisible())
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
                            Click.on(RegMobiliariaBienesUi.TAB_DESCRIPCION)
                    );
                    Thread.sleep(3000);

                    //Descripción
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(descripcion).into(RegMobiliariaBienesUi.TXT_DESCRIPCION)
                    );

                    //Comentario
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(comentario).into(RegMobiliariaBienesUi.TXT_COMENTARIO)
                    );
                    Thread.sleep(1000);

                    //--------------------------------------------------------------------------------------------------
                    // REGISTRAR GARANTIA
                    //--------------------------------------------------------------------------------------------------
                    RegMobiliariaBienesUi.BTN_REGISTRAR.resolveFor(theActorInTheSpotlight()).click();
                    keyEventMask = FocusEvent.KEY_EVENT_MASK;
                    theActorInTheSpotlight().attemptsTo(
                            AlertAccept.Aceptar_MobiliariaBienes2(Fila,cellCount, Fila)
                    );


/*                    try{
                        String GAR;
                        GAR = RegMobiliariaBienesUi.TXT_NROGARANTIA.resolveFor(theActorInTheSpotlight()).getText();
                        System.out.println("*************************" + GAR);

                        String GAC;
                        GAC = GAR.substring(GAR.lastIndexOf(".")+1);
                        System.out.println("*************************" + GAC);
                        //System.out.println("-------------------------" +"|" + cu +"|"+ tienda+"|"+ tdocumento+"|"+ moneda+"|"+ fecvencimiento+"|"+ ndias+"|"+ ndocu+"|"+ porcentaje+"|"+ importe+"|"+ tcobertura+"|"+ cudeudor+"|"+ tlistado+"|"+ nlineaope+"|"+ descripcion+"|"+ comentario+"|"+GAC+"|");

                        if (GAR.contains("Se ha ingresado correctamente"))
                        {
                            System.out.println("-------Numero de Columna a insertar" + cellCount );
                            WriteXls.registro_MobiliariaBienes(Fila, cellCount, GAC);
                            RegMobiliariaBienesUi.BTN_VOLVER.resolveFor(theActorInTheSpotlight()).click();
                        }

                        new GACMenuPrincipalStepDefinitions().se_selecciona_garantias_mobiliaria_bienes();
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }*/
                    //Fin llenado campos

                    new GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_garantia_mobiliaria_bienes();
                }

                if (Fin == "Si") {
                    System.out.println("-----------Fin - ejecucion por errores");
                    new GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_garantia_mobiliaria_bienes();
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

