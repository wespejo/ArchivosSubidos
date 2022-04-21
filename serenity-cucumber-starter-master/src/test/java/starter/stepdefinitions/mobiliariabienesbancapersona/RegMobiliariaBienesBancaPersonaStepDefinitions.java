package starter.stepdefinitions.mobiliariabienesbancapersona;

import io.cucumber.java.es.Entonces;
import motoresdebusqueda.gac.page.mobiliariabienes.RegMobiliariaBienesUi;
import motoresdebusqueda.gac.page.mobiliariabienesbancapersona.RegMobiliariaBienesBancaPersonaUi;
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

public class RegMobiliariaBienesBancaPersonaStepDefinitions {

    private Object IsNotEnabledMatcher;
    private long keyEventMask;
    private static WebDriver driver;

@Entonces("se genera nueva Garantia Mobiliaria Bienes Banca Persona")
public void se_genera_nueva_Garantia_Mobiliaria_Bienes_Banca_Persona() throws InterruptedException {

    try {
        Sheet sheet = LoadXls.getSheet_MobiliariaBienesBancaPersona(0, "Data-MobiliariaSobreBienesBancaPersona.xlsx");
        String cu;
        double tienda;
        double ndocu;
        String cdocumento;
        String tdocumento;
        String rango;
        String moneda;
        double valrealizacion;
        double valcomercial;
        double valgravamen;
        String fecgravamen;
        String fecrecepcionfile;
        String fecpreinscripcion;
        String situacion;
        String etapa;
        double ncredito;
        //Información de Seguro
        String nomciaseguro;
        double nropoliza;
        String fecvtopoliza;
        double importepolext;
        //Información Tasación
        String tipotasacion;
        String fectasacion;
        String perito;
        String sittasacion;
        String monedatasacion;
        double importeasegtasacion;
        double porcentajeinventario;


        //Información legal del Registro
        String notaria;
        double kardex;
        String partidaregistral;
        String descpartidaregistral;
        String oficinaregistral;

        //Información Vehicular
        String colorvehiculo;
        String serie;
        String motor;
        String placa;
        String modelovehiculo;
        String propietario;

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
            cdocumento="";
            tdocumento="";
            rango="";
            moneda ="";
            valrealizacion = 0;
            valcomercial = 0;
            valgravamen = 0;
            fecgravamen= "";
            fecrecepcionfile="";
            fecpreinscripcion="";
            situacion = "";
            etapa="";
            ncredito=0;
            //Información de Seguro
            nomciaseguro= "";
            nropoliza = 0;
            fecvtopoliza= "";
            importepolext = 0;
            //Información Tasación
            tipotasacion="";
            fectasacion="";
            perito="";
            sittasacion="";
            monedatasacion="";
            importeasegtasacion= 0;
            porcentajeinventario= 0;


            //Información legal del Registro
            notaria="";
            kardex=0;
            partidaregistral="";
            descpartidaregistral="";
            oficinaregistral="";

            //Información Vehicular
            colorvehiculo="";
            serie="";
            motor="";
            placa="";
            modelovehiculo="";
            propietario="";


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
                if (cellCount ==51) {
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
                        int ndocuInt = (int)ndocu; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 2++-+-+++-+-+-+-+ndocu:"+ndocuInt);
                        break;
                    case 3:
                        cdocumento = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 3++-+-+++-+-+-+-+cdocumento:"+cdocumento);
                        break;
                    case 4:
                        tdocumento = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 4++-+-+++-+-+-+-+tdocumento:"+tdocumento);
                        break;
                    case 5:
                        rango = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 5++-+-+++-+-+-+-+rango:"+rango);
                        break;
                    case 6:
                        moneda = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 6++-+-+++-+-+-+-+moneda:"+moneda);
                        break;
                    case 7:
                        valrealizacion = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 7++-+-+++-+-+-+-+valor de realizacion:"+valrealizacion);
                        break;
                    case 8:
                        valcomercial = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 8++-+-+++-+-+-+-+valor comercial:"+valcomercial);
                        break;
                    case 9:
                        valgravamen = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 9++-+-+++-+-+-+-+valor de gravamen:"+valgravamen);
                        break;
                    case 10:
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //SimpleDateFormat
                        fecgravamen = dateFormat.format(cell.getDateCellValue());
                        System.out.println("-++++-+++-++++-Columna 10++-+-+++-+-+-+-+fecgravamen:"+ fecgravamen);
                        break;
                    case 11:
                        SimpleDateFormat dateConst = new SimpleDateFormat("dd/MM/yyyy"); //SimpleDateFormat
                        fecrecepcionfile = dateConst.format(cell.getDateCellValue());
                        System.out.println("-++++-+++-++++-Columna 11++-+-+++-+-+-+-+fecrecepcionfile:"+ fecrecepcionfile);
                        break;
                    case 12:
                        SimpleDateFormat datePre = new SimpleDateFormat("dd/MM/yyyy"); //SimpleDateFormat
                        fecpreinscripcion = datePre.format(cell.getDateCellValue());
                        System.out.println("-++++-+++-++++-Columna 12++-+-+++-+-+-+-+fecpreinscripcion:"+ fecpreinscripcion);
                        break;
                    case 13:
                        situacion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 13++-+-+++-+-+-+-+Situacion:"+situacion);
                        break;
                    case 14:
                        etapa = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 14++-+-+++-+-+-+-+Etapa:"+etapa);
                        break;
                    case 15:
                        ncredito = cell.getNumericCellValue();
                        int ncreditoInt = (int)ncredito; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 15++-+-+++-+-+-+-+ncredito:"+ncreditoInt);
                        break;

                    //información de Seguro
                    case 16:
                        nomciaseguro = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 16++-+-+++-+-+-+-+Nombre CIA Seguro:"+nomciaseguro);
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
                        importepolext = cell.getNumericCellValue();
                        int importepolextInt = (int)importepolext; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 19++-+-+++-+-+-+-+Importe Segun Poliza Externa :"+importepolextInt);
                        break;

                    //Información Tasación
                    case 20:
                        tipotasacion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 20++-+-+++-+-+-+-+tipotasacion:"+tipotasacion);
                        break;
                    case 21:
                        SimpleDateFormat dateTasa = new SimpleDateFormat("dd/MM/yyyy"); //SimpleDateFormat
                        fectasacion = dateTasa.format(cell.getDateCellValue());
                        System.out.println("-++++-+++-++++-Columna 21++-+-+++-+-+-+-+Fecha de Tasacion:"+fectasacion);
                        break;
                    case 22:
                        perito = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 22++-+-+++-+-+-+-+Perito:"+perito);
                        break;

                    case 23:
                        sittasacion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 23++-+-+++-+-+-+-+Situacion de Tasacion:"+sittasacion);
                        break;
                    case 24:
                        monedatasacion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 24++-+-+++-+-+-+-+Moneda de Tasacion:"+monedatasacion);
                        break;
                    case 25:
                        importeasegtasacion = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 25++-+-+++-+-+-+-+Importe Asegurable de Tasacion:"+importeasegtasacion);
                        break;
                    case 26:
                        porcentajeinventario = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 26++-+-+++-+-+-+-+Porcentaje de Inventario:"+porcentajeinventario);
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
                        partidaregistral = cell.getStringCellValue();
                        //int partidaregistralInt = (int)partidaregistral; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 29++-+-+++-+-+-+-+partida registral:"+partidaregistral);
                        break;
                    case 30:
                        descpartidaregistral = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 30++-+-+++-+-+-+-+descripcion partida registral:"+descpartidaregistral);
                        break;
                    case 31:
                        oficinaregistral = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 31++-+-+++-+-+-+-+oficina registral:"+oficinaregistral);
                        break;

                    //Información Vehicular
                    case 32:
                        colorvehiculo = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 32++-+-+++-+-+-+-+Color del Vehiculo:"+colorvehiculo);
                        break;
                    case 33:
                        serie = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 33++-+-+++-+-+-+-+Serie:"+serie);
                        break;
                    case 34:
                        motor = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 34++-+-+++-+-+-+-+Motor:"+motor);
                        break;
                    case 35:
                        placa = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 35++-+-+++-+-+-+-+Placa:"+placa);
                        break;
                    case 36:
                        modelovehiculo = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 36++-+-+++-+-+-+-+Modelo del Vehiculo:"+modelovehiculo);
                        break;
                    case 37:
                        propietario = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 37++-+-+++-+-+-+-+Propietario:"+propietario);
                        break;
                        //Ubigeo
                    case 38:
                        departamento = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 38++-+-+++-+-+-+-+departamento:"+departamento);
                        break;
                    case 39:
                        provincia = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 39++-+-+++-+-+-+-+provincia:"+provincia);
                        break;
                    case 40:
                        distrito = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 40++-+-+++-+-+-+-+distrito:"+distrito);
                        break;
                    case 41:
                        direccion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 41++-+-+++-+-+-+-+direccion:"+direccion);
                        break;

                    //TAB Deuda Garantía

                    case 42:
                        tcobertura = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 42++-+-+++-+-+-+-+tcobertura:"+tcobertura);
                        break;
                    case 43:
                        cudeudor = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 43++-+-+++-+-+-+-+cudeudor:"+cudeudor);
                        break;
                    case 44:
                        tlistado = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 44++-+-+++-+-+-+-+tlistado:"+tlistado);
                        break;
                    case 45:
                        nlineaope = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 45++-+-+++-+-+-+-+nlineaope:"+nlineaope);
                        break;
                    case 46:
                        monedacta = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 46++-+-+++-+-+-+-+Moneda de Cuenta:"+monedacta);
                        break;
                    case 47:
                        numoficinacta = cell.getNumericCellValue();
                        int numoficinactaInt = (int)numoficinacta; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 47++-+-+++-+-+-+-+Numero de Oficina / Tienda:"+numoficinactaInt);
                        break;
                    case 48:
                        numerocta = cell.getStringCellValue();
                        //int numeroctaInt = (int)numerocta; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 48++-+-+++-+-+-+-+Numero de Cuenta:" +numerocta);
                        break;
                    case 49:
                        descripcion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 49++-+-+++-+-+-+-+descripcion:"+descripcion);
                        break;
                    case 50:
                        comentario = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 50++-+-+++-+-+-+-+comentario:"+comentario);
                        break;

                }// Fin switch (Columna)
                }//{} Fin (rowCount ==15)
            }//{} FIN (Cell cell : row)


            //Catidad de columnas (sin garantía)
            int cellCount = row.getLastCellNum() - row.getFirstCellNum();
            System.out.println("-----****************-----SEGUIMOS EN LA fila que tiene:"+ cellCount + " Columnas con data");
            if(cellCount == 51){




                //TAB Datos Generales
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.TAB_DATOS_GENERALES, isEnabled()).forNoMoreThan(60).seconds(),
                        Click.on(RegMobiliariaBienesBancaPersonaUi.TAB_DATOS_GENERALES),
                        WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.TXT_CU, isVisible()).forNoMoreThan(30).seconds()
                );


                //Inicio llenado campos
                //Código Unico - cu
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.TXT_CU, isEnabled()).forNoMoreThan(60).seconds(),
                        Enter.keyValues(Keys.HOME).into(RegMobiliariaBienesBancaPersonaUi.TXT_CU),
                        Enter.theValue(cu).into(RegMobiliariaBienesBancaPersonaUi.TXT_CU),
                        Enter.keyValues(Keys.END).into(RegMobiliariaBienesBancaPersonaUi.TXT_CU),
                        Enter.keyValues(Keys.ENTER).into(RegMobiliariaBienesBancaPersonaUi.TXT_CU)
                );

                //Espera a que mensaje "Cargando" no sea visible
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.Pop_Modal, isNotCurrentlyVisible()).forNoMoreThan(30).seconds()
                );
                //Graba mensaje cuando CU no existe
                String nombreracsoc;
                nombreracsoc = RegMobiliariaBienesBancaPersonaUi.TXT_NOMBRERAZONSOC.resolveFor(theActorInTheSpotlight()).getValue();
                System.out.println("....El NOmbre o razón social es:"+nombreracsoc);

                if ((nombreracsoc == null) || (nombreracsoc.equals("")) ){
                    System.out.println("................................CU no existe!!!");
                    AlertAccept.Valida_CU_MobiliariaBienesBancaPersona(Fila, cellCount);
                    Fin = "Si";
                }

                if (Fin == "No")
                {
                    //Tienda - tienda
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.Pop_Modal,isNotCurrentlyVisible()).forNoMoreThan(30).seconds(),
                            Click.on(RegMobiliariaBienesBancaPersonaUi.TXT_TIENDA),
                            Enter.keyValues(Keys.HOME).into(RegMobiliariaBienesBancaPersonaUi.TXT_TIENDA),
                            Enter.keyValues(String.valueOf(tienda)).into(RegMobiliariaBienesBancaPersonaUi.TXT_TIENDA)
                    );
                    RegMobiliariaBienesBancaPersonaUi.TXT_TIENDA.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.ENTER);

                    //Número de Documento
                    int ndocuInt = (int)ndocu; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(ndocuInt)).into(RegMobiliariaBienesBancaPersonaUi.TXT_NUDOCU)
                    );
                    //Thread.sleep(3000);

                    //Código de Documento  - cdocumento
                    theActorInTheSpotlight().attemptsTo(
                        SelectFromOptions.byVisibleText(cdocumento).from(RegMobiliariaBienesBancaPersonaUi.CBO_CDOCU),
                        WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.CBO_CDOCU,containsSelectOption(cdocumento)).forNoMoreThan(6).seconds()
                    );


                    //Tipo de Documento - tdocumento
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(tdocumento).from(RegMobiliariaBienesBancaPersonaUi.CBO_TDOCU),
                            WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.CBO_TDOCU,containsSelectOption(tdocumento)).forNoMoreThan(6).seconds()

                    );


                    //Rango
                    if (!rango.equals("RANGO 1")) {
                        theActorInTheSpotlight().attemptsTo(
                                SelectFromOptions.byVisibleText(rango).from(RegMobiliariaBienesBancaPersonaUi.CBO_RANGO),
                                WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.CBO_RANGO, containsSelectOption(rango)).forNoMoreThan(6).seconds()
                        );
                    }



                    //Moneda Garantía
                    System.out.println(".-.-.-.-.-.-.-.-.-la moneda es:" +moneda);
                    if (moneda.equals("Soles")){
                        System.out.println("--------------------------------------------------Moneda Soles");
                        theActorInTheSpotlight().attemptsTo(
                                //WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.CBO_CLASE,isNotSelected()).forNoMoreThan(6).seconds(),
                                SelectFromOptions.byIndex(1).from(RegMobiliariaBienesBancaPersonaUi.CBO_MONEDA)
                        );
                    }
                    Thread.sleep(5000);


                    //Valor de Realización
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.CBO_MONEDA,isNotSelected()).forNoMoreThan(30).seconds(),
                            Enter.keyValues(String.valueOf(valrealizacion)).into(RegMobiliariaBienesBancaPersonaUi.TXT_VALREALIZACION)
                    );


                    //Valor Comercial
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.TXT_VALREALIZACION,isNotSelected()).forNoMoreThan(30).seconds(),
                            Enter.keyValues(String.valueOf(valcomercial)).into(RegMobiliariaBienesBancaPersonaUi.TXT_VALCOMERCIAL)
                    );


                    //Valor de Gravamen
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.TXT_VALCOMERCIAL,isNotSelected()).forNoMoreThan(30).seconds(),
                            Enter.keyValues(String.valueOf(valgravamen)).into(RegMobiliariaBienesBancaPersonaUi.TXT_VALGRAVAMEN)
                    );



                    //Fecha de Gravamen
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(fecgravamen).into(RegMobiliariaBienesBancaPersonaUi.TXT_FECGRAVAMEN)
                    );



                    //Fecha Recepción File
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(fecrecepcionfile).into(RegMobiliariaBienesBancaPersonaUi.TXT_FECRECFILE)
                    );


                    //Fecha Pre Inscripción
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(fecpreinscripcion).into(RegMobiliariaBienesBancaPersonaUi.TXT_FECPREINSCRIPCION)
                    );




                    //Situación
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(situacion).from(RegMobiliariaBienesBancaPersonaUi.CBO_SITUACION),
                            WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.CBO_SITUACION,containsSelectOption(situacion)).forNoMoreThan(5).seconds()
                    );



                    //Etapa
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(etapa).from(RegMobiliariaBienesBancaPersonaUi.CBO_ETAPA),
                            WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.CBO_ETAPA,containsSelectOption(etapa)).forNoMoreThan(7).seconds()
                    );


                    //Número de Crédito
                    int ncreditoInt = (int)ncredito; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(ncreditoInt)).into(RegMobiliariaBienesBancaPersonaUi.TXT_NROCREDITO)
                    );



                    //Información de Seguro

                    //Nombre Cia Seguro
                    theActorInTheSpotlight().attemptsTo(
                            //Click.on(RegMobiliariaBienesBancaPersonaUi.CBO_NOMCIASEGURO),
                            SelectFromOptions.byVisibleText(nomciaseguro).from(RegMobiliariaBienesBancaPersonaUi.CBO_NOMCIASEGURO)
                            //WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.CBO_NOMCIASEGURO,containsSelectOption(nomciaseguro)).forNoMoreThan(6).seconds()
                    );
                    Thread.sleep(2000);

                    //Nro Poliza
                    int nropolizaInt = (int)nropoliza; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            //WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.TXT_NROPOLIZA,isEnabled()).forNoMoreThan(30).seconds(),
                            Enter.keyValues(String.valueOf(nropolizaInt)).into(RegMobiliariaBienesBancaPersonaUi.TXT_NROPOLIZA)
                    );
                    Thread.sleep(3000);


                    //Fecha Vcto Poliza
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(fecvtopoliza).into(RegMobiliariaBienesBancaPersonaUi.TXT_FECVTOPOLIZA)
                    );
                    Thread.sleep(1000);


                    //Importe Según Póliza Externa
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.TXT_FECVTOPOLIZA,isNotSelected()).forNoMoreThan(30).seconds(),
                            //Click.on(RegMobiliariaBienesBancaPersonaUi.TXT_IMPPOLEXT),
                            //Enter.keyValues(String.valueOf(Keys.HOME)).into(RegMobiliariaBienesBancaPersonaUi.TXT_IMPPOLEXT),
                            Enter.keyValues(String.valueOf(importepolext)).into(RegMobiliariaBienesBancaPersonaUi.TXT_IMPPOLEXT)
                    );
                    Thread.sleep(3000);



                    //Información Tasación

                    //Tipo de Tasación
                    theActorInTheSpotlight().attemptsTo(
                            //WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.CBO_TIPOTASACION,isNotSelected()).forNoMoreThan(30).seconds(),
                            SelectFromOptions.byVisibleText(tipotasacion).from(RegMobiliariaBienesBancaPersonaUi.CBO_TIPOTASACION),
                    WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.CBO_TIPOTASACION,containsSelectOption(tipotasacion)).forNoMoreThan(5).seconds()
                    );

                    //Fecha de Tasación
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.CBO_TIPOTASACION,isNotSelected()).forNoMoreThan(30).seconds(),
                            Enter.theValue(fectasacion).into(RegMobiliariaBienesBancaPersonaUi.TXT_FECTASACION)
                    );



                    //Perito
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.TXT_IMPPOLEXT,isNotSelected()).forNoMoreThan(30).seconds(),
                            SelectFromOptions.byVisibleText(perito).from(RegMobiliariaBienesBancaPersonaUi.CBO_PERITO)
                    );
                    Thread.sleep(3000);


                    //Situacion
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(sittasacion).from(RegMobiliariaBienesBancaPersonaUi.CBO_SITUACIONTASACION),
                            WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.CBO_SITUACIONTASACION, containsSelectOption(sittasacion)).forNoMoreThan(5).seconds()
                    );

                    //Moneda de Tasación
                    System.out.println(".-.-.-.-.-.-.-.-.-la moneda tasacion es:" +monedatasacion);
                    if (monedatasacion.equals("Soles")){
                        System.out.println("--------------------------------------------------Moneda Tasacion Soles");
                        theActorInTheSpotlight().attemptsTo(
                                SelectFromOptions.byIndex(1).from(RegMobiliariaBienesBancaPersonaUi.CBO_MONEDATASACION)
                        );
                    }
                    Thread.sleep(1000);


                    //Importe Asegurable Según Tasación
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(importeasegtasacion)).into(RegMobiliariaBienesBancaPersonaUi.TXT_IMPORTEASEGTASACION)
                    );

                    //Porcentaje de Inventario
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(porcentajeinventario)).into(RegMobiliariaBienesBancaPersonaUi.TXT_PORCENTAJE)
                    );



                    //Información legal del Registro
                    //Notaria
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(notaria).into(RegMobiliariaBienesBancaPersonaUi.TXT_NOTARIA),
                            WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.TXT_NOTARIA,isNotSelected()).forNoMoreThan(5).seconds()
                    );


                    //Kardex
                    int kardexInt = (int)kardex; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(kardexInt)).into(RegMobiliariaBienesBancaPersonaUi.TXT_KARDEX),
                            WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.TXT_KARDEX,isNotSelected()).forNoMoreThan(30).seconds()
                    );


                    //Partida Registral
                    //int partidaregistralInt = (int)partidaregistral; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(partidaregistral)).into(RegMobiliariaBienesBancaPersonaUi.TXT_PARTIDAREGISTRAL),
                            WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.TXT_PARTIDAREGISTRAL,isNotSelected()).forNoMoreThan(30).seconds()
                    );



                    //Descripción Partida Registral
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(descpartidaregistral).into(RegMobiliariaBienesBancaPersonaUi.TXT_DESCPARTIDAREGISTRAL),
                            WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.CBO_ZONAREGSITRAL,isVisible()).forNoMoreThan(30).seconds()
                    );


                    //Oficina Registral
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(oficinaregistral).from(RegMobiliariaBienesBancaPersonaUi.CBO_OFICINAREGISTRAL)
                    );
                    Thread.sleep(7000);


                    //INFORMACION VEHICULAR (CRED VEHICULAR / BPE - VEHICULAR)
                    //BPE - MAQUINARIA

                    if ((tdocumento.contains("CRED VEHICULAR")) || (tdocumento.contains("BPE - VEHICULAR")) ){
                        System.out.println("Ingresa a CRED VEHICULAR / BPE - VEHICULAR");

                        //Color del Vehículo
                        theActorInTheSpotlight().attemptsTo(
                                Enter.theValue(colorvehiculo).into(RegMobiliariaBienesUi.TXT_COLORVEHICULO)
                        );

                        //Serie
                        theActorInTheSpotlight().attemptsTo(
                                Enter.theValue(serie).into(RegMobiliariaBienesUi.TXT_SERIE)
                        );


                        //Motor
                        theActorInTheSpotlight().attemptsTo(
                                Enter.theValue(motor).into(RegMobiliariaBienesUi.TXT_MOTOR)
                        );


                        //Placa
                        theActorInTheSpotlight().attemptsTo(
                                Enter.theValue(placa).into(RegMobiliariaBienesUi.TXT_PLACA)
                        );


                        //Modelo el Vehiculo
                        theActorInTheSpotlight().attemptsTo(
                                Enter.theValue(modelovehiculo).into(RegMobiliariaBienesUi.TXT_MODELOVEHICULO)
                        );


                        //Propietario
                        theActorInTheSpotlight().attemptsTo(
                                Enter.theValue(propietario).into(RegMobiliariaBienesBancaPersonaUi.TXT_PROPIETARIO)
                        );
                    }




                    //Ubigeo
                    //Departamento
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(departamento).from(RegMobiliariaBienesBancaPersonaUi.CBO_DEPARTAMENTO),
                            WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.CBO_DEPARTAMENTO,containsSelectOption(departamento)).forNoMoreThan(7).seconds()
                    );
                    //Thread.sleep(8000);
                    //Provincia
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(provincia).from(RegMobiliariaBienesBancaPersonaUi.CBO_PROVINCIA),
                            WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.CBO_PROVINCIA,containsSelectOption(provincia)).forNoMoreThan(7).seconds()
                    );
                    //Thread.sleep(8000);
                    //Distrito
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(distrito).from(RegMobiliariaBienesBancaPersonaUi.CBO_DISTRITO)
                    );
                    Thread.sleep(3000);

                    //Dirección
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(direccion).into(RegMobiliariaBienesBancaPersonaUi.TXT_DIRECCION)
                    );
                    Thread.sleep(3000);


                    //--------------------------------------------------------------------------------------------------
                    // TAB: Deuda Garantía
                    //--------------------------------------------------------------------------------------------------
                    Thread.sleep(3000);
                    theActorInTheSpotlight().attemptsTo(
                            Click.on(RegMobiliariaBienesBancaPersonaUi.TABDEUDA)
                    );
                    Thread.sleep(5000);


                    if (tcobertura.endsWith("rica")) {
                        System.out.println("******************************************GENERICA****************************");
                        theActorInTheSpotlight().attemptsTo(
                                Click.on(RegMobiliariaBienesBancaPersonaUi.LBLTIPOCOBERTURA),
                                Enter.keyValues(String.valueOf(Keys.DOWN)).into(RegMobiliariaBienesBancaPersonaUi.LBLTIPOCOBERTURA),
                                Enter.keyValues(String.valueOf(Keys.TAB)).into(RegMobiliariaBienesBancaPersonaUi.LBLTIPOCOBERTURA)
                        );

                    } //Fin (tcobertura.endsWith("rica"))
                    //Thread.sleep(6000);



                    //CU Deudor
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.TXT_CUDEUDOR,isEnabled()).forNoMoreThan(30).seconds(),
                            Enter.theValue(cudeudor).into(RegMobiliariaBienesBancaPersonaUi.TXT_CUDEUDOR)
                    );
                    RegMobiliariaBienesBancaPersonaUi.TXT_CUDEUDOR.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.ENTER);
                    WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.TXT_CUDEUDOR,isNotCurrentlyEnabled()).forNoMoreThan(30).seconds();
                    Thread.sleep(5000);


                    if (tcobertura.contains("Especifica")) {
                        if (tlistado.contains("Operaciones")) {
                            System.out.println("**************************OPERACIONES****************************");
                            theActorInTheSpotlight().attemptsTo(
                                    Click.on(RegMobiliariaBienesBancaPersonaUi.RBT_TLISTADOOPE)
                            );
                            Thread.sleep(3000);

                            theActorInTheSpotlight().attemptsTo(
                                    WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.LBL_OPE,containsText("Nro Operacion")).forNoMoreThan(40).seconds()
                            );
                            Thread.sleep(3000);

                            //split divide la cadena en base a separador ";"
                            for (String numope: nlineaope.split(";")) {
                                //reemplaza espacios vacíos
                                numope = numope.replace(" ", "");

                                theActorInTheSpotlight().attemptsTo(
                                        WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.TXT_NROOPERACION, isEnabled()).forNoMoreThan(30).seconds(),
                                        Click.on(RegMobiliariaBienesBancaPersonaUi.TXT_NROOPERACION),
                                        Enter.theValue(numope).into(RegMobiliariaBienesBancaPersonaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.HOME)).into(RegMobiliariaBienesBancaPersonaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.END)).into(RegMobiliariaBienesBancaPersonaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.TAB)).into(RegMobiliariaBienesBancaPersonaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.SPACE)).into(RegMobiliariaBienesBancaPersonaUi.BTN_BUSCAROPE)
                                );
                                Thread.sleep(5000);


                                //Graba mensaje cuando operación no existe
                                theActorInTheSpotlight().attemptsTo(
                                        AlertAccept.OpeLinInvalid_MobiliariaBienesBancaPersona(Fila, cellCount)
                                );
                                Thread.sleep(6000);


                                //TXT_NROOPERACION contiene (muestra) nlineaope cuando no existe la operación, entonces termina sin GAC
                                if (RegMobiliariaBienesBancaPersonaUi.TXT_NROOPERACION.resolveFor(theActorInTheSpotlight()).containsValue(nlineaope)) {
                                    System.out.println("ope no existe");
                                    Fin = "Si";
                                    System.out.println("-----------Fin ope no existe" + Fin);
                                }
                            }
                        } // Fin (tlistado.contains("Operaciones"))


                        else if (tlistado.contains("Lineas")){
                            System.out.println("******************************************LINEAS****************************");
                            theActorInTheSpotlight().attemptsTo(
                                    Click.on(RegMobiliariaBienesBancaPersonaUi.RBT_TLISTADOLINEA)
                            );

                            //split divide la cadena en base a separador ";"
                            for (String numlin: nlineaope.split(";")) {
                                //reemplaza espacios vacíos
                                numlin = numlin.replace(" ", "");

                                theActorInTheSpotlight().attemptsTo(
                                        WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.TXT_NROOPERACION, isEnabled()).forNoMoreThan(30).seconds(),
                                        Click.on(RegMobiliariaBienesBancaPersonaUi.TXT_NROOPERACION),
                                        Enter.theValue(numlin).into(RegMobiliariaBienesBancaPersonaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.HOME)).into(RegMobiliariaBienesBancaPersonaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.END)).into(RegMobiliariaBienesBancaPersonaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.TAB)).into(RegMobiliariaBienesBancaPersonaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.SPACE)).into(RegMobiliariaBienesBancaPersonaUi.BTN_BUSCAROPE)
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
                    Thread.sleep(3000);
                }



                if (Fin == "No"){
                    //Datos de la Cuenta
                    //Moneda de la cuenta
                    if (monedacta.equals("Soles")){
                        System.out.println("--------------------------------------------------Moneda CTA Soles");
                        theActorInTheSpotlight().attemptsTo(
                                SelectFromOptions.byIndex(1).from(RegMobiliariaBienesBancaPersonaUi.CBO_MONEDACTA)
                        );
                    }
                    Thread.sleep(3000);

                    //Oficina de cuenta
                    int numoficinactaInt = (int)numoficinacta; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(numoficinactaInt)).into(RegMobiliariaBienesBancaPersonaUi.TXT_NUMOFICINACTA),
                            WaitUntil.the(RegMobiliariaBienesBancaPersonaUi.TXT_NUMOFICINACTA,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    Thread.sleep(3000);

                    //Numero de cuenta
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(numerocta).into(RegMobiliariaBienesBancaPersonaUi.TXT_NUMEROCTA),
                            Enter.keyValues(String.valueOf(Keys.HOME)).into(RegMobiliariaBienesBancaPersonaUi.TXT_NUMEROCTA),
                            Enter.keyValues(String.valueOf(Keys.END)).into(RegMobiliariaBienesBancaPersonaUi.TXT_NUMEROCTA),
                            Enter.keyValues(String.valueOf(Keys.ENTER)).into(RegMobiliariaBienesBancaPersonaUi.TXT_NUMEROCTA)
                    );
                    Thread.sleep(5000);



                    //Graba mensaje cuando cuenta no existe
                    //Boton no visible cuando cuenta no existe
                    if (!RegMobiliariaBienesBancaPersonaUi.BTN_NVACTA.resolveFor(theActorInTheSpotlight()).isCurrentlyVisible())
                    {
                        System.out.println("Cta Cte no existe");
                        //Graba mensaje cuando cuenta no existe
                        AlertAccept.CtaInvalid_MobiliariaBienesBancaPersona(Fila, cellCount);
                        Fin = "Si";
                        System.out.println("-----------Fin x cta no existe: "+ Fin);
                    }
                    else {
                        System.out.println("Cta Cte Si Existe");

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
                            Click.on(RegMobiliariaBienesBancaPersonaUi.TAB_DESCRIPCION)
                    );
                    Thread.sleep(3000);

                    //Descripción
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(descripcion).into(RegMobiliariaBienesBancaPersonaUi.TXT_DESCRIPCION)
                    );

                    //Comentario
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(comentario).into(RegMobiliariaBienesBancaPersonaUi.TXT_COMENTARIO)
                    );
                    Thread.sleep(1000);

                    //--------------------------------------------------------------------------------------------------
                    // REGISTRAR GARANTIA
                    //--------------------------------------------------------------------------------------------------
                    RegMobiliariaBienesBancaPersonaUi.BTN_REGISTRAR.resolveFor(theActorInTheSpotlight()).click();
                    keyEventMask = FocusEvent.KEY_EVENT_MASK;
                    theActorInTheSpotlight().attemptsTo(
                            AlertAccept.Aceptar_MobiliariaBienesBancaPersona(Fila,cellCount, Fila)
                    );

                    //Fin llenado campos
                    new GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_garantia_mobiliaria_bienes_banca_persona();
                }

                if (Fin == "Si") {
                    System.out.println("-----------Fin - ejecucion por errores");
                    new GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_garantia_mobiliaria_bienes_banca_persona();
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

