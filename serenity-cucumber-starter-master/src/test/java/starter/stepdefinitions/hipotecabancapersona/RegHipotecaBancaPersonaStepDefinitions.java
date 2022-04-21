package starter.stepdefinitions.hipotecabancapersona;

import io.cucumber.java.es.Entonces;
import motoresdebusqueda.gac.page.hipotecabancapersona.RegHipotecasBancaPersonaUi;
import motoresdebusqueda.gac.stepdefinitions.mobiliariabienes.GACMenuPrincipalStepDefinitions;
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

public class RegHipotecaBancaPersonaStepDefinitions {

    private Object IsNotEnabledMatcher;
    private long keyEventMask;
    private static WebDriver driver;

@Entonces("se genera nueva Garantia Hipoteca Banca Persona")
public void se_genera_nueva_Garantia_Hipoteca_Banca_Persona() throws InterruptedException {

    try {
        Sheet sheet = LoadXls.getSheet_HipotecaBancaPersona(0, "Data-HipotecaBancaPersona.xlsx");
        String cu;
        double tienda;
        String cdocumento;
        double ndocu;
        String rango;
        String clase;
        String moneda;
        double valrealizacion;
        double valcomercial;
        double valgravamen;
        String fecgravamen;
        String fecconstitucion;
        String situacion;
        String etapa;
        double ncredito;
        //Información de Seguro
        String nomciaseguro;
        double nropoliza;
        String fecvtopoliza;
        double importepolext;
        //Información Tasación
        String perito;
        String fectasacion;
        String tipotasacion;
        String sittasacion;
        String monedatasacion;
        double valconstruccion;
        double areaconstruida;
        double importeasegtasacion;
        double valterreno;
        double areaterreno;
        String uso;
        String edificacion;
        String materialconstruccion;
        double nsotanos;
        double npisos;
        String propietario;
        double anioconstruccion;
        String ubicacion;
        //Información legal del Registro
        String notaria;
        double kardex;
        String partidaregistral;
        String descpartidaregistral;
        String asiento;
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
            ndocu=0;
            rango="";
            clase="";
            moneda ="";
            valrealizacion = 0;
            valcomercial = 0;
            valgravamen = 0;
            fecgravamen= "";
            fecconstitucion="";
            situacion = "";
            etapa="";
            ncredito=0;
            //Información de Seguro
            nomciaseguro= "";
            nropoliza = 0;
            fecvtopoliza= "";
            importepolext = 0;
            //Información Tasación
            perito="";
            fectasacion="";
            tipotasacion="";
            sittasacion="";
            monedatasacion="";
            valconstruccion=0;
            areaconstruida=0;
            importeasegtasacion= 0;
            valterreno=0;
            areaterreno=0;
            uso="";
            edificacion="";
            materialconstruccion="";
            nsotanos=0;
            npisos=0;
            propietario="";
            anioconstruccion=0;
            ubicacion="";
            //Información legal del Registro
            notaria="";
            kardex=0;
            partidaregistral="";
            descpartidaregistral="";
            asiento="";
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
                if (cellCount ==56) {
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
                        ndocu = cell.getNumericCellValue();
                        int ndocuInt = (int)ndocu; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 3++-+-+++-+-+-+-+ndocu:"+ndocuInt);
                        break;
                    case 4:
                        rango = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 4++-+-+++-+-+-+-+rango:"+rango);
                        break;
                    case 5:
                        clase = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 5++-+-+++-+-+-+-+clase:"+clase);
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
                        fecconstitucion = dateConst.format(cell.getDateCellValue());
                        System.out.println("-++++-+++-++++-Columna 11++-+-+++-+-+-+-+fecconstitucion:"+ fecconstitucion);
                        break;
                    case 12:
                        situacion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 12++-+-+++-+-+-+-+Situacion:"+situacion);
                        break;
                    case 13:
                        etapa = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 13++-+-+++-+-+-+-+Etapa:"+etapa);
                        break;
                    case 14:
                        ncredito = cell.getNumericCellValue();
                        int ncreditoInt = (int)ncredito; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 14++-+-+++-+-+-+-+ncredito:"+ncreditoInt);
                        break;

                    //información de Seguro
                    case 15:
                        nomciaseguro = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 15++-+-+++-+-+-+-+Nombre CIA Seguro:"+nomciaseguro);
                        break;
                    case 16:
                        nropoliza =cell.getNumericCellValue();
                        int nropolizaInt = (int)nropoliza; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 16++-+-+++-+-+-+-+Nro de Poliza:"+nropolizaInt);
                        break;
                    case 17:
                        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy"); //SimpleDateFormat
                        fecvtopoliza = dateFormat2.format(cell.getDateCellValue());
                        System.out.println("-++++-+++-++++-Columna 17++-+-+++-+-+-+-+Fecha de Vencimiento de Poliza:"+fecvtopoliza);
                        break;
                    case 18:
                        importepolext = cell.getNumericCellValue();
                        int importepolextInt = (int)importepolext; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 18++-+-+++-+-+-+-+Importe Segun Poliza Externa :"+importepolextInt);
                        break;

                    //Información Tasación
                    case 19:
                        perito = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 19++-+-+++-+-+-+-+Perito:"+perito);
                        break;
                    case 20:
                        SimpleDateFormat dateFormat3 = new SimpleDateFormat("dd/MM/yyyy"); //SimpleDateFormat
                        fectasacion = dateFormat3.format(cell.getDateCellValue());
                        System.out.println("-++++-+++-++++-Columna 20++-+-+++-+-+-+-+Fecha de Tasacion:"+fectasacion);
                        break;
                    case 21:
                        tipotasacion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 21++-+-+++-+-+-+-+Tipo de Tasacion:"+tipotasacion);
                        break;
                    case 22:
                        sittasacion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 22++-+-+++-+-+-+-+Situacion de Tasacion:"+sittasacion);
                        break;
                    case 23:
                        monedatasacion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 23++-+-+++-+-+-+-+Moneda de Tasacion:"+monedatasacion);
                        break;
                    case 24:
                        valconstruccion = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 24++-+-+++-+-+-+-+Valor de Construccion :"+valconstruccion);
                        break;
                    case 25:
                        areaconstruida = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 25++-+-+++-+-+-+-+Area Construida:"+areaconstruida);
                        break;
                    case 26:
                        importeasegtasacion = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 26++-+-+++-+-+-+-+Importe Asegurable de Tasacion:"+importeasegtasacion);
                        break;
                    case 27:
                        valterreno = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 27++-+-+++-+-+-+-+Valor del Terreno:"+valterreno);
                        break;
                    case 28:
                        areaterreno = cell.getNumericCellValue();
                        System.out.println("-++++-+++-++++-Columna 28++-+-+++-+-+-+-+Area de Terreno:"+areaterreno);
                        break;
                    case 29:
                        uso = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 29++-+-+++-+-+-+-+Uso:"+uso);
                        break;
                    case 30:
                        edificacion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 30++-+-+++-+-+-+-+Edificacion:"+edificacion);
                        break;
                    case 31:
                        materialconstruccion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 31++-+-+++-+-+-+-+Material de Construccion:"+materialconstruccion);
                        break;
                    case 32:
                        nsotanos = cell.getNumericCellValue();
                        int nsotanostInt = (int)nsotanos; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 32++-+-+++-+-+-+-+Numero de Sotanos :"+nsotanostInt);
                        break;
                    case 33:
                        npisos = cell.getNumericCellValue();
                        int npisostInt = (int)npisos; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 33++-+-+++-+-+-+-+Numero de Pisos :"+npisostInt);
                        break;
                    case 34:
                        propietario = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 34++-+-+++-+-+-+-+Propietario:"+propietario);
                        break;
                    case 35:
                        anioconstruccion = cell.getNumericCellValue();
                        int anioconstruccionInt = (int)anioconstruccion; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 35++-+-+++-+-+-+-+Año de Construccion :"+anioconstruccionInt);
                        break;
                    case 36:
                        ubicacion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 36++-+-+++-+-+-+-+Ubicacion:"+ubicacion);
                        break;

                    //Información legal del Registro
                    case 37:
                        notaria = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 37++-+-+++-+-+-+-+Notaria:"+notaria);
                        break;
                    case 38:
                        kardex = cell.getNumericCellValue();
                        int kardexInt = (int)kardex; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 38++-+-+++-+-+-+-+Kardex:"+kardexInt);
                        break;
                    case 39:
                        partidaregistral = cell.getStringCellValue();
                        //int partidaregistralInt = (int)partidaregistral; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 39++-+-+++-+-+-+-+partida registral:"+partidaregistral);
                        break;
                    case 40:
                        descpartidaregistral = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 40++-+-+++-+-+-+-+descripcion partida registral:"+descpartidaregistral);
                        break;
                    case 41:
                        asiento = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 41++-+-+++-+-+-+-+Asiento:"+asiento);
                        break;
                    case 42:
                        oficinaregistral = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 42++-+-+++-+-+-+-+oficina registral:"+oficinaregistral);
                        break;

                    //Ubigeo
                    case 43:
                        departamento = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 43++-+-+++-+-+-+-+departamento:"+departamento);
                        break;
                    case 44:
                        provincia = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 44++-+-+++-+-+-+-+provincia:"+provincia);
                        break;
                    case 45:
                        distrito = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 45++-+-+++-+-+-+-+distrito:"+distrito);
                        break;
                    case 46:
                        direccion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 46++-+-+++-+-+-+-+direccion:"+direccion);
                        break;

                    //TAB Deuda Garantía

                    case 47:
                        tcobertura = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 47++-+-+++-+-+-+-+tcobertura:"+tcobertura);
                        break;
                    case 48:
                        cudeudor = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 48++-+-+++-+-+-+-+cudeudor:"+cudeudor);
                        break;
                    case 49:
                        tlistado = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 49++-+-+++-+-+-+-+tlistado:"+tlistado);
                        break;
                    case 50:
                        nlineaope = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 50++-+-+++-+-+-+-+nlineaope:"+nlineaope);
                        break;
                    case 51:
                        monedacta = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 51++-+-+++-+-+-+-+Moneda de Cuenta:"+monedacta);
                        break;
                    case 52:
                        numoficinacta = cell.getNumericCellValue();
                        int numoficinactaInt = (int)numoficinacta; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 52++-+-+++-+-+-+-+Numero de Oficina / Tienda:"+numoficinactaInt);
                        break;
                    case 53:
                        numerocta = cell.getStringCellValue();
                        //int numeroctaInt = (int)numerocta; // Convert Double to Integer
                        System.out.println("-++++-+++-++++-Columna 53++-+-+++-+-+-+-+Numero de Cuenta:" +numerocta);
                        break;
                    case 54:
                        descripcion = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 54++-+-+++-+-+-+-+descripcion:"+descripcion);
                        break;
                    case 55:
                        comentario = cell.getStringCellValue();
                        System.out.println("-++++-+++-++++-Columna 55++-+-+++-+-+-+-+comentario:"+comentario);
                        break;

                }// Fin switch (Columna)
                }//{} Fin (rowCount ==15)
            }//{} FIN (Cell cell : row)

            //data.put(i, datosFila);
            //System.out.println("-------------------La fila actual es:"+i);

            //Catidad de columnas (sin garantía)
            int cellCount = row.getLastCellNum() - row.getFirstCellNum();
            System.out.println("-----****************-----SEGUIMOS EN LA fila que tiene:"+ cellCount + " Columnas con data");
            if(cellCount == 56){




                //TAB Datos Generales
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegHipotecasBancaPersonaUi.TAB_DATOS_GENERALES, isEnabled()).forNoMoreThan(60).seconds(),
                        Click.on(RegHipotecasBancaPersonaUi.TAB_DATOS_GENERALES),
                        WaitUntil.the(RegHipotecasBancaPersonaUi.TXT_CU, isVisible()).forNoMoreThan(30).seconds()
                );
                //Thread.sleep(3000);

                //Inicio llenado campos
                //Código Unico - cu
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegHipotecasBancaPersonaUi.TXT_CU, isEnabled()).forNoMoreThan(60).seconds(),
                        Enter.keyValues(Keys.HOME).into(RegHipotecasBancaPersonaUi.TXT_CU),
                        Enter.theValue(cu).into(RegHipotecasBancaPersonaUi.TXT_CU),
                        Enter.keyValues(Keys.END).into(RegHipotecasBancaPersonaUi.TXT_CU),
                        Enter.keyValues(Keys.ENTER).into(RegHipotecasBancaPersonaUi.TXT_CU)
                );

                //Espera a que mensaje "Cargando" no sea visible
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegHipotecasBancaPersonaUi.Pop_Modal, isNotCurrentlyVisible()).forNoMoreThan(30).seconds()
                );
                //Graba mensaje cuando CU no existe
                String nombreracsoc;
                nombreracsoc = RegHipotecasBancaPersonaUi.TXT_NOMBRERAZONSOC.resolveFor(theActorInTheSpotlight()).getValue();
                System.out.println("....El NOmbre o razón social es:"+nombreracsoc);

                if ((nombreracsoc == null) || (nombreracsoc.equals("")) ){
                    System.out.println("................................CU no existe!!!");
                    AlertAccept.Valida_CU_HipotecaBancaPersona(Fila, cellCount);
                    Fin = "Si";
                }

                if (Fin == "No")
                {
                    //Tienda - tienda
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegHipotecasBancaPersonaUi.Pop_Modal,isNotCurrentlyVisible()).forNoMoreThan(30).seconds(),
                            Click.on(RegHipotecasBancaPersonaUi.TXT_TIENDA),
                            Enter.keyValues(Keys.HOME).into(RegHipotecasBancaPersonaUi.TXT_TIENDA),
                            Enter.keyValues(String.valueOf(tienda)).into(RegHipotecasBancaPersonaUi.TXT_TIENDA)
                    );
                    RegHipotecasBancaPersonaUi.TXT_TIENDA.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.ENTER);

                    //Código de Documento  - cdocumento
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(cdocumento).from(RegHipotecasBancaPersonaUi.CBO_CDOCU)
                            //WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_CDOCU,isNotSelected()).forNoMoreThan(5).seconds()
                    );

/*                    if((cdocumento.equals("HIPOTECAS INTERSEGUROS"))||cdocumento.equals("HIPOTECARIOS - BONOS 1E EMISION")){
                        Thread.sleep(5000);
                        System.out.println("HIPOTECAS INTERSEGUROS  / HIPOTECARIOS - BONOS 1E EMISION" );
                    }
                    else{
                        WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_TDOCU,containsSelectOption(cdocumento)).forNoMoreThan(30).seconds();
                        System.out.println("Codigo de Documento = Tipo de Documento");
                    }*/
                    Thread.sleep(6000);


                    //Número de Documento
                    int ndocuInt = (int)ndocu; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(ndocuInt)).into(RegHipotecasBancaPersonaUi.TXT_NUDOCU)
                    );
                    Thread.sleep(3000);


                    //Rango
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(rango).from(RegHipotecasBancaPersonaUi.CBO_RANGO),
                            WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_RANGO,containsSelectOption(rango)).forNoMoreThan(6).seconds()
                    );
                    //Thread.sleep(5000);

                    if (rango.equals("RANGO 1")){
                        System.out.println("Rango 1 - puede seleccionar entre dos valores (PREFERIDA - SIN GARANTIA)");
                        //Rango2 selecciona por defecto "No preferida", se hace esto para evitar error
                        //Clase
                        theActorInTheSpotlight().attemptsTo(
                                SelectFromOptions.byVisibleText(clase).from(RegHipotecasBancaPersonaUi.CBO_CLASE),
                                WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_CLASE,containsSelectOption(clase)).forNoMoreThan(6).seconds()
                        );
                    }



                    //Moneda Garantía
                    System.out.println(".-.-.-.-.-.-.-.-.-la moneda es:" +moneda);
                    if (moneda.equals("Soles")){
                        System.out.println("--------------------------------------------------Moneda Soles");
                        theActorInTheSpotlight().attemptsTo(
                                WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_CLASE,isNotSelected()).forNoMoreThan(6).seconds(),
                                SelectFromOptions.byIndex(1).from(RegHipotecasBancaPersonaUi.CBO_MONEDA)
                        );
                    }
                    Thread.sleep(5000);


                    //Valor de Realización
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_MONEDA,isNotSelected()).forNoMoreThan(30).seconds(),
                            Enter.keyValues(String.valueOf(valrealizacion)).into(RegHipotecasBancaPersonaUi.TXT_VALREALIZACION)
                    );
                    //Thread.sleep(3000);


                    //Valor Comercial
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegHipotecasBancaPersonaUi.TXT_VALREALIZACION,isNotSelected()).forNoMoreThan(30).seconds(),
                            Enter.keyValues(String.valueOf(valcomercial)).into(RegHipotecasBancaPersonaUi.TXT_VALCOMERCIAL)
                    );
                    //Thread.sleep(3000);


                    //Valor de Gravamen
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegHipotecasBancaPersonaUi.TXT_VALCOMERCIAL,isNotSelected()).forNoMoreThan(30).seconds(),
                            Enter.keyValues(String.valueOf(valgravamen)).into(RegHipotecasBancaPersonaUi.TXT_VALGRAVAMEN)
                    );
                    //Thread.sleep(3000);



                    //Situación
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(situacion).from(RegHipotecasBancaPersonaUi.CBO_SITUACION),
                            WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_SITUACION,containsSelectOption(situacion)).forNoMoreThan(5).seconds()
                    );

                    if (situacion.equals("CONFORME")){
                        Thread.sleep(6000);
                    }

                    //Etapa
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(etapa).from(RegHipotecasBancaPersonaUi.CBO_ETAPA),
                            WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_ETAPA,containsSelectOption(etapa)).forNoMoreThan(7).seconds()
                    );
                    Thread.sleep(1000);

                    //Número de Crédito
                    int ncreditoInt = (int)ncredito; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(ncreditoInt)).into(RegHipotecasBancaPersonaUi.TXT_NUMCREDITO)
                    );
                    Thread.sleep(2000);

                    //Fecha de Gravamen
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(fecgravamen).into(RegHipotecasBancaPersonaUi.TXT_FECGRAVAMEN)
                    );
                    Thread.sleep(1000);



                    //if ((situacion.equals("CONFORME")) && (etapa.equals("Formalizado o Inscrito en RR PP")))
                    if (etapa.equals("Formalizado o Inscrito en RR PP"))
                    {
                        System.out.println("Ingresa a IF de Situación CONFORME");
                        //Fecha de Constitución
                        theActorInTheSpotlight().attemptsTo(
                                Enter.theValue(fecconstitucion).into(RegHipotecasBancaPersonaUi.TXT_FECCONSTITUCION)
                        );
                        Thread.sleep(1000);

                    }




                    //Información de Seguro

                    //Nombre Cia Seguro
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(nomciaseguro).from(RegHipotecasBancaPersonaUi.CBO_NOMCIASEGURO)
                            //WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_NOMCIASEGURO,containsSelectOption(nomciaseguro)).forNoMoreThan(6).seconds()
                    );
                    Thread.sleep(5000);

                    //Nro Poliza
                    int nropolizaInt = (int)nropoliza; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegHipotecasBancaPersonaUi.TXT_NROPOLIZA,isEnabled()).forNoMoreThan(30).seconds(),
                            Enter.keyValues(String.valueOf(nropolizaInt)).into(RegHipotecasBancaPersonaUi.TXT_NROPOLIZA)
                    );
                    Thread.sleep(3000);


                    //Fecha Vcto Poliza
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(fecvtopoliza).into(RegHipotecasBancaPersonaUi.TXT_FECVTOPOLIZA)
                    );
                    Thread.sleep(1000);


                    //Importe Según Póliza Externa
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_NOMCIASEGURO,isNotSelected()).forNoMoreThan(30).seconds(),
                            Enter.keyValues(String.valueOf(importepolext)).into(RegHipotecasBancaPersonaUi.TXT_IMPPOLEXT)
                    );
                    Thread.sleep(3000);




                    //Información Tasación
                    //Perito
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegHipotecasBancaPersonaUi.TXT_IMPPOLEXT,isNotSelected()).forNoMoreThan(30).seconds(),
                            SelectFromOptions.byVisibleText(perito).from(RegHipotecasBancaPersonaUi.CBO_PERITO)
                    );
                    Thread.sleep(3000);


                    //Fecha de Tasación
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_PERITO,isNotSelected()).forNoMoreThan(30).seconds(),
                            Enter.theValue(fectasacion).into(RegHipotecasBancaPersonaUi.TXT_FECTASACION)
                    );
                    //Thread.sleep(3000);



                    //Tipo de Tasación
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(tipotasacion).from(RegHipotecasBancaPersonaUi.CBO_TIPOTASACION),
                            WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_TIPOTASACION,containsSelectOption(tipotasacion)).forNoMoreThan(5).seconds()
                    );
                    Thread.sleep(1000);


                    //Situacion
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(sittasacion).from(RegHipotecasBancaPersonaUi.CBO_SITUACIONTASACION),
                            WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_SITUACIONTASACION, containsSelectOption(sittasacion)).forNoMoreThan(5).seconds()
                    );

                    //Moneda de Tasación
                    System.out.println(".-.-.-.-.-.-.-.-.-la moneda tasacion es:" +monedatasacion);
                /*if(!monedatasacion.equals("Soles")){
                    System.out.println("--------------------------------------------------Moneda tasacion dolares");
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_TIPOTASACION,isNotSelected()).forNoMoreThan(30).seconds(),
                            SelectFromOptions.byIndex(0).from(RegHipotecasBancaPersonaUi.CBO_MONEDATASACION)
                    );
                }
                Thread.sleep(3000);*/

                    if (monedatasacion.equals("Soles")){
                        System.out.println("--------------------------------------------------Moneda Tasacion Soles");
                        theActorInTheSpotlight().attemptsTo(
                                SelectFromOptions.byIndex(1).from(RegHipotecasBancaPersonaUi.CBO_MONEDATASACION)
                        );
                    }
                    Thread.sleep(1000);


                    //Valor de Construcción
                    theActorInTheSpotlight().attemptsTo(
                        Enter.keyValues(String.valueOf(valconstruccion)).into(RegHipotecasBancaPersonaUi.TXT_VALORCONSTRUCCION)
                    );
                    //Thread.sleep(3000);


                    //Area Construida
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegHipotecasBancaPersonaUi.TXT_VALORCONSTRUCCION,isNotSelected()).forNoMoreThan(30).seconds(),
                            Enter.keyValues(String.valueOf(areaconstruida)).into(RegHipotecasBancaPersonaUi.TXT_AREACONSTRUIDA)
                    );


                    //Importe Asegurable de Tasación
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegHipotecasBancaPersonaUi.TXT_AREACONSTRUIDA,isNotSelected()).forNoMoreThan(30).seconds(),
                            Enter.keyValues(String.valueOf(importeasegtasacion)).into(RegHipotecasBancaPersonaUi.TXT_IMPORTEASEGTASACION)
                    );


                    //Valor Terreno
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegHipotecasBancaPersonaUi.TXT_IMPORTEASEGTASACION,isNotSelected()).forNoMoreThan(30).seconds(),
                            Enter.keyValues(String.valueOf(valterreno)).into(RegHipotecasBancaPersonaUi.TXT_VALORTERRENO)
                    );

                    //Area Terreno
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegHipotecasBancaPersonaUi.TXT_VALORTERRENO,isNotSelected()).forNoMoreThan(30).seconds(),
                            Enter.keyValues(String.valueOf(areaterreno)).into(RegHipotecasBancaPersonaUi.TXT_AREATERRENO)
                    );


                    //Uso
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(uso).from(RegHipotecasBancaPersonaUi.CBO_USO),
                            WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_USO, containsSelectOption(uso)).forNoMoreThan(5).seconds()
                    );


                    //Edificación
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(edificacion).from(RegHipotecasBancaPersonaUi.CBO_EDIFICACION),
                            WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_EDIFICACION, containsSelectOption(edificacion)).forNoMoreThan(5).seconds()
                    );


                    //Material de Construcción
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(materialconstruccion).from(RegHipotecasBancaPersonaUi.CBO_MATERIALCONST),
                            WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_MATERIALCONST, containsSelectOption(materialconstruccion)).forNoMoreThan(5).seconds()
                    );


                    //Nro de Sotanos
                    int nsotanosInt = (int) nsotanos; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            keyValues(String.valueOf(nsotanosInt)).into(RegHipotecasBancaPersonaUi.TXT_NROSOTANOS)
                    );


                    //Nro de Pisos
                    int npisosInt = (int) npisos; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            keyValues(String.valueOf(npisosInt)).into(RegHipotecasBancaPersonaUi.TXT_NROPISOS)
                    );


                    //Propietario
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(propietario).into(RegHipotecasBancaPersonaUi.TXT_PROPIETARIO)
                    );


                    //Año de Construcción
                    int anioconstruccionInt = (int) anioconstruccion; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            keyValues(String.valueOf(anioconstruccionInt)).into(RegHipotecasBancaPersonaUi.TXT_ANIOCONST)
                    );


                    //Ubicación
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(ubicacion).from(RegHipotecasBancaPersonaUi.CBO_UBICACION),
                            WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_UBICACION, containsSelectOption(ubicacion)).forNoMoreThan(5).seconds()
                    );




                    //Información legal del Registro
                    //Notaria
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(notaria).into(RegHipotecasBancaPersonaUi.TXT_NOTARIA),
                            WaitUntil.the(RegHipotecasBancaPersonaUi.TXT_NOTARIA,isNotSelected()).forNoMoreThan(5).seconds()
                    );
                    //Thread.sleep(3000);

                    //Kardex
                    int kardexInt = (int)kardex; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(kardexInt)).into(RegHipotecasBancaPersonaUi.TXT_KARDEX),
                            WaitUntil.the(RegHipotecasBancaPersonaUi.TXT_KARDEX,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    //Thread.sleep(3000);

                    //Partida Registral
                    //int partidaregistralInt = (int)partidaregistral; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(partidaregistral)).into(RegHipotecasBancaPersonaUi.TXT_PARTIDAREGISTRAL),
                            WaitUntil.the(RegHipotecasBancaPersonaUi.TXT_PARTIDAREGISTRAL,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    //Thread.sleep(3000);


                    //Descripción Partida Registral
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(descpartidaregistral).into(RegHipotecasBancaPersonaUi.TXT_DESCPARTIDAREGISTRAL),
                            WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_ZONAREGSITRAL,isVisible()).forNoMoreThan(30).seconds()
                    );
                    //Thread.sleep(3000);


                    //Asiento
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(asiento)).into(RegHipotecasBancaPersonaUi.TXT_ASIENTO),
                            WaitUntil.the(RegHipotecasBancaPersonaUi.TXT_ASIENTO,isNotSelected()).forNoMoreThan(30).seconds()
                    );


                    //Oficina Registral
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(oficinaregistral).from(RegHipotecasBancaPersonaUi.CBO_OFICINAREGISTRAL)
                            //WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_OFICINAREGISTRAL,containsSelectOption(oficinaregistral)).forNoMoreThan(9).seconds()
                    );
                    Thread.sleep(7000);



                    //Ubigeo
                    //Departamento
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byVisibleText(departamento).from(RegHipotecasBancaPersonaUi.CBO_DEPARTAMENTO),
                            WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_DEPARTAMENTO,containsSelectOption(departamento)).forNoMoreThan(7).seconds()
                    );
                    //Thread.sleep(8000);
                    //Provincia
                    theActorInTheSpotlight().attemptsTo(
                            //WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_DEPARTAMENTO,isCurrentlyVisible()).forNoMoreThan(15).seconds(),
                            SelectFromOptions.byVisibleText(provincia).from(RegHipotecasBancaPersonaUi.CBO_PROVINCIA),
                            WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_PROVINCIA,containsSelectOption(provincia)).forNoMoreThan(7).seconds()
                    );
                    //Thread.sleep(8000);
                    //Distrito
                    theActorInTheSpotlight().attemptsTo(
                            //WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_PROVINCIA,isCurrentlyVisible()).forNoMoreThan(15).seconds(),
                            SelectFromOptions.byVisibleText(distrito).from(RegHipotecasBancaPersonaUi.CBO_DISTRITO)
                            //WaitUntil.the(RegHipotecasBancaPersonaUi.CBO_DISTRITO,containsSelectOption(distrito)).forNoMoreThan(8).seconds()
                    );
                    Thread.sleep(5000);

                    //Dirección
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(direccion).into(RegHipotecasBancaPersonaUi.TXT_DIRECCION)
                    );
                    Thread.sleep(3000);


                    //--------------------------------------------------------------------------------------------------
                    // TAB: Deuda Garantía
                    //--------------------------------------------------------------------------------------------------
                    Thread.sleep(3000);
                    theActorInTheSpotlight().attemptsTo(
                            Click.on(RegHipotecasBancaPersonaUi.TABDEUDA)
                    );
                    Thread.sleep(5000);


                    if (tcobertura.endsWith("rica")) {
                        System.out.println("******************************************GENERICA****************************");
                        theActorInTheSpotlight().attemptsTo(
                                Click.on(RegHipotecasBancaPersonaUi.LBLTIPOCOBERTURA),
                                Enter.keyValues(String.valueOf(Keys.DOWN)).into(RegHipotecasBancaPersonaUi.LBLTIPOCOBERTURA),
                                Enter.keyValues(String.valueOf(Keys.TAB)).into(RegHipotecasBancaPersonaUi.LBLTIPOCOBERTURA)
                                //SelectFromOptions.byValue("1").from(RegHipotecasBancaPersonaUi.CBO_TIPOCOBERTURA)
                        );

                        //CommonClass.waitForAlert(BrowseTheWeb.as(theActorInTheSpotlight()).getDriver(),0);
                        ////getDriver().switchTo().alert().accept();
                        //theActorInTheSpotlight().attemptsTo(AlertAccept.toAccept());
                        //Thread.sleep(4000);
                        //AlertAccept.CobGen2();
                        //System.out.println("----POst Alert");


                    } //Fin (tcobertura.endsWith("rica"))
                    //Thread.sleep(6000);




                    //CU Deudor
                    theActorInTheSpotlight().attemptsTo(
                            WaitUntil.the(RegHipotecasBancaPersonaUi.TXT_CUDEUDOR,isEnabled()).forNoMoreThan(30).seconds(),
                            Enter.theValue(cudeudor).into(RegHipotecasBancaPersonaUi.TXT_CUDEUDOR)
                    );
                    RegHipotecasBancaPersonaUi.TXT_CUDEUDOR.resolveFor(theActorInTheSpotlight()).sendKeys(Keys.ENTER);
                    WaitUntil.the(RegHipotecasBancaPersonaUi.TXT_CUDEUDOR,isNotCurrentlyEnabled()).forNoMoreThan(30).seconds();
                    Thread.sleep(5000);


                    if (tcobertura.contains("Especifica")) {
                        if (tlistado.contains("Operaciones")) {
                            System.out.println("**************************OPERACIONES****************************");
                            theActorInTheSpotlight().attemptsTo(
                                    Click.on(RegHipotecasBancaPersonaUi.RBT_TLISTADOOPE)
                            );
                            Thread.sleep(3000);

                            theActorInTheSpotlight().attemptsTo(
                                    WaitUntil.the(RegHipotecasBancaPersonaUi.LBL_OPE,containsText("Nro Operacion")).forNoMoreThan(40).seconds()
                            );
                            Thread.sleep(3000);

                            //split divide la cadena en base a separador ";"
                            for (String numope: nlineaope.split(";")) {
                                //reemplaza espacios vacíos
                                numope = numope.replace(" ", "");

                                theActorInTheSpotlight().attemptsTo(
                                        WaitUntil.the(RegHipotecasBancaPersonaUi.TXT_NROOPERACION, isEnabled()).forNoMoreThan(30).seconds(),
                                        Click.on(RegHipotecasBancaPersonaUi.TXT_NROOPERACION),
                                        Enter.theValue(numope).into(RegHipotecasBancaPersonaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.HOME)).into(RegHipotecasBancaPersonaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.END)).into(RegHipotecasBancaPersonaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.TAB)).into(RegHipotecasBancaPersonaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.SPACE)).into(RegHipotecasBancaPersonaUi.BTN_BUSCAROPE)
                                        //WaitUntil.the(RegHipotecasBancaPersonaUi.TXT_NROOPERACION,containsText(nlineaope)).forNoMoreThan(30).seconds()
                                );
                                Thread.sleep(5000);


                                //Graba mensaje cuando operación no existe
                                theActorInTheSpotlight().attemptsTo(
                                        AlertAccept.OpeLinInvalid_HipotecaBancaPersona(Fila, cellCount)
                                );
                                Thread.sleep(6000);


                                //TXT_NROOPERACION contiene (muestra) nlineaope cuando no existe la operación, entonces termina sin GAC
                                if (RegHipotecasBancaPersonaUi.TXT_NROOPERACION.resolveFor(theActorInTheSpotlight()).containsValue(nlineaope)) {
                                    System.out.println("ope no existe");
                                    Fin = "Si";
                                    System.out.println("-----------Fin ope no existe" + Fin);
                                }
                            }
                        } // Fin (tlistado.contains("Operaciones"))


                        else if (tlistado.contains("Lineas")){
                            System.out.println("******************************************LINEAS****************************");
                            theActorInTheSpotlight().attemptsTo(
                                    Click.on(RegHipotecasBancaPersonaUi.RBT_TLISTADOLINEA)
                            );

                            //split divide la cadena en base a separador ";"
                            for (String numlin: nlineaope.split(";")) {
                                //reemplaza espacios vacíos
                                numlin = numlin.replace(" ", "");

                                theActorInTheSpotlight().attemptsTo(
                                        WaitUntil.the(RegHipotecasBancaPersonaUi.TXT_NROOPERACION, isEnabled()).forNoMoreThan(30).seconds(),
                                        Click.on(RegHipotecasBancaPersonaUi.TXT_NROOPERACION),
                                        Enter.theValue(numlin).into(RegHipotecasBancaPersonaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.HOME)).into(RegHipotecasBancaPersonaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.END)).into(RegHipotecasBancaPersonaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.TAB)).into(RegHipotecasBancaPersonaUi.TXT_NROOPERACION),
                                        Enter.keyValues(String.valueOf(Keys.SPACE)).into(RegHipotecasBancaPersonaUi.BTN_BUSCAROPE)
                                );
                                Thread.sleep(5000);

                                //Graba mensaje cuando línea no existe
                                theActorInTheSpotlight().attemptsTo(
                                        AlertAccept.OpeLinInvalid_HipotecaBancaPersona(Fila, cellCount)
                                );
                                Thread.sleep(6000);

                                //Lectura de Excel con último mensaje grabado (cuando linea no existe)
                                Cell grabado;
                                Sheet sheet2 = LoadXls.getSheet_HipotecaBancaPersona(0, "Data-HipotecaBancaPersona.xlsx");
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
                                SelectFromOptions.byIndex(1).from(RegHipotecasBancaPersonaUi.CBO_MONEDACTA)
                        );
                    }
                    Thread.sleep(3000);

                    //Oficina de cuenta
                    int numoficinactaInt = (int)numoficinacta; // Convert Double to Integer
                    theActorInTheSpotlight().attemptsTo(
                            Enter.keyValues(String.valueOf(numoficinactaInt)).into(RegHipotecasBancaPersonaUi.TXT_NUMOFICINACTA),
                            WaitUntil.the(RegHipotecasBancaPersonaUi.TXT_NUMOFICINACTA,isNotSelected()).forNoMoreThan(30).seconds()
                    );
                    Thread.sleep(3000);

                    //Numero de cuenta
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(numerocta).into(RegHipotecasBancaPersonaUi.TXT_NUMEROCTA),
                            Enter.keyValues(String.valueOf(Keys.HOME)).into(RegHipotecasBancaPersonaUi.TXT_NUMEROCTA),
                            Enter.keyValues(String.valueOf(Keys.END)).into(RegHipotecasBancaPersonaUi.TXT_NUMEROCTA),
                            Enter.keyValues(String.valueOf(Keys.ENTER)).into(RegHipotecasBancaPersonaUi.TXT_NUMEROCTA)
                    );
                    Thread.sleep(6000);
                    //WaitUntil.the(RegHipotecasBancaPersonaUi.Pop_Modal,isNotCurrentlyVisible()).forNoMoreThan(30).seconds(),



                    //Graba mensaje cuando cuenta no existe
                    theActorInTheSpotlight().attemptsTo(
                            //WaitUntil.the(RegHipotecasBancaPersonaUi.LBL_CARGANDO_CTA,isNotCurrentlyVisible()).forNoMoreThan(30).seconds(),
                            AlertAccept.CtaInvalid_HipotecaBancaPersona(Fila,cellCount)
                    );
                    Thread.sleep(8000);


                    //Boton no visible cuando cuenta no existe
                    if (!RegHipotecasBancaPersonaUi.BTN_NVACTA.resolveFor(theActorInTheSpotlight()).isVisible())
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
                            Click.on(RegHipotecasBancaPersonaUi.TAB_DESCRIPCION)
                    );
                    Thread.sleep(3000);

                    //Descripción
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(descripcion).into(RegHipotecasBancaPersonaUi.TXT_DESCRIPCION)
                    );

                    //Comentario
                    theActorInTheSpotlight().attemptsTo(
                            Enter.theValue(comentario).into(RegHipotecasBancaPersonaUi.TXT_COMENTARIO)
                    );
                    Thread.sleep(1000);

                    //--------------------------------------------------------------------------------------------------
                    // REGISTRAR GARANTIA
                    //--------------------------------------------------------------------------------------------------
                    RegHipotecasBancaPersonaUi.BTN_REGISTRAR.resolveFor(theActorInTheSpotlight()).click();
                    keyEventMask = FocusEvent.KEY_EVENT_MASK;
                    theActorInTheSpotlight().attemptsTo(
                            AlertAccept.Aceptar_HipotecaBancaPersona(Fila,cellCount, Fila)
                    );

                    //Fin llenado campos
                    new motoresdebusqueda.gac.stepdefinitions.hipotecabancapersona.GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_Garantia_Hipoteca_Banca_Persona();
                }

                if (Fin == "Si") {
                    System.out.println("-----------Fin - ejecucion por errores");
                    new motoresdebusqueda.gac.stepdefinitions.hipotecabancapersona.GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_Garantia_Hipoteca_Banca_Persona();
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

