package starter.util.alert;

import motoresdebusqueda.gac.page.cartafianza.RegCartaFianzaUi;
import motoresdebusqueda.gac.page.fianzasolidaria.RegFianzaSolidariaUi;
import motoresdebusqueda.gac.page.fideicomisogarantia.RegFideicomisoGarantiaUi;
import motoresdebusqueda.gac.page.hipotecabancapersona.RegHipotecasBancaPersonaUi;
import motoresdebusqueda.gac.page.mobiliariabienes.RegMobiliariaBienesUi;
import motoresdebusqueda.gac.page.mobiliariabienesbancapersona.RegMobiliariaBienesBancaPersonaUi;
import motoresdebusqueda.gac.page.mobiliariadinero.RegMobiliariaSobreDineroUi;
import motoresdebusqueda.gac.page.standby.RegStandByUi;
import motoresdebusqueda.gac.page.titulovalor.RegTituloValorUi;
import motoresdebusqueda.gac.util.CommonClass;
import motoresdebusqueda.gac.util.excel.WriteXls;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.DriverTask;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.LocalDate;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class AlertAccept {

    private static WebDriver driver;
    private static LocalDate wait;
    private static Object Actor;


    //---------------------------------------------------------------------------------------------
    //FIANZA SOLIDARIA
    //---------------------------------------------------------------------------------------------
    public static Performable Valida_CU_FianzaSolidaria(int Fila, int cellCount)  {
        String GAC;
        GAC = "NO EXISTE CLIENTE,VERIFIQUE CODIGO";
        try {
            //Graba cuando el cliente no existe
            WriteXls.registro_FianzaSolidaria(Fila, cellCount, GAC);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }


    public static Performable OpeLinInvalid_FianzaSolidaria(int Fila, int cellCount){
        return new DriverTask(driver -> {
            ExpectedConditions.alertIsPresent();
            try {
                //Ingresa aquí cuando No se encuentra la línea u operacion (alert)
                CommonClass.sleep(4);
                String textoDeAlert = driver.switchTo().alert().getText();
                System.out.println("*************************El texto del alert getText es: " + textoDeAlert);
                String GAC;
                GAC = textoDeAlert;
                if ((textoDeAlert.contains("No se encuentra la operacion Nro")) || (textoDeAlert.contains("No se encuentra la linea Nro"))){
                    System.out.println("************************* No se encuentra la operacion / Linea Nro.");
                    try {
                        WriteXls.registro_FianzaSolidaria(Fila, cellCount, GAC);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
                driver.switchTo().alert().accept();
                Thread.sleep(3000);

            } catch (NoAlertPresentException | InterruptedException e) {
                //Ingresa aquí cuando operación si existe
                System.out.println("------------No se muestra alert;");
            }
        });
    }



    public static Performable Aceptar_FianzaSolidaria(int fila, int cellCount, int Fila) {
        System.out.println("-+-++-+-+-+-+-+-+-+-+++-" + fila);
        System.out.println("++-+-+-+-+-+-----------------++++" + cellCount);

/*        SECUENCIA DE MENSAJES
          1.-Desea Ud. Registrar esta Garant
          2.- Se ha registrado correctamente la Garantía Nro.
          3.- Otras validaciones: Ingrese ...
          */

        return new DriverTask(driver -> {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.alertIsPresent());
            //CommonClass.sleep(2);
            String textoDeAlert0 = driver.switchTo().alert().getText();
            System.out.println("*************************El texto del alert es: " + textoDeAlert0);
            //Desea Ud. Registrar esta Garantía ?
            if (textoDeAlert0.contains("Desea Ud. Registrar esta Garant")) {
                //Acepta mensaje: Desea Ud. Registrar esta Garantía ?
                driver.switchTo().alert().accept();
                CommonClass.sleep(8);

                System.out.println("---------------Se genera Nueva Garantia");
                String GAR;
                GAR = RegTituloValorUi.TXT_NROGARANTIA.resolveFor(theActorInTheSpotlight()).getText();
                System.out.println("*************************" + GAR);

                String GAC2;
                GAC2 = GAR.substring(GAR.lastIndexOf("Nro ") + 4);
                System.out.println("*************************" + GAC2);

                System.out.println("-----------------------------------------Ingresa a Else IF: Se ha registrado correctamente la Garant");
                System.out.println("-------Numero de Columna a insertar" + cellCount);
                try {
                    WriteXls.registro_FianzaSolidaria(Fila, cellCount, GAC2);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                RegFianzaSolidariaUi.BTN_VOLVER.resolveFor(theActorInTheSpotlight()).click();

            }
//            Otras Validaciones
//            - Verificar Datos de la Cuenta
//            - La cuenta no pertenece al Deudor
            else {
                String GAC;
                GAC = textoDeAlert0;
                System.out.println("************************* Ingresa a otras validaciones");
                //Ingrese ...
                try {
                    WriteXls.registro_FianzaSolidaria(Fila, cellCount, GAC);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                driver.switchTo().alert().accept();
            }
        });
    }



    //---------------------------------------------------------------------------------------------
    //TITULO VALOR
    //---------------------------------------------------------------------------------------------
    public static Performable Valida_CU_TituloValor(int Fila, int cellCount)  {
        String GAC;
        GAC = "NO EXISTE CLIENTE,VERIFIQUE CODIGO";
        try {
            //Graba cuando el cliente no existe
            WriteXls.registro_TituloValor(Fila, cellCount, GAC);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }


    public static Performable OpeLinInvalid_TituloValor(int Fila, int cellCount){
        return new DriverTask(driver -> {
            ExpectedConditions.alertIsPresent();
            try {
                //Ingresa aquí cuando No se encuentra la línea u operacion (alert)
                CommonClass.sleep(4);
                String textoDeAlert = driver.switchTo().alert().getText();
                System.out.println("*************************El texto del alert getText es: " + textoDeAlert);
                String GAC;
                GAC = textoDeAlert;
                if ((textoDeAlert.contains("No se encuentra la operacion Nro")) || (textoDeAlert.contains("No se encuentra la linea Nro"))){
                    System.out.println("************************* No se encuentra la operacion / Linea Nro.");
                    try {
                        WriteXls.registro_TituloValor(Fila, cellCount, GAC);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
                driver.switchTo().alert().accept();
                Thread.sleep(3000);

            } catch (NoAlertPresentException | InterruptedException e) {
                //Ingresa aquí cuando operación si existe
                System.out.println("------------No se muestra alert;");
            }
        });
    }

    public static Performable Aceptar_TituloValor(int fila, int cellCount, int Fila) {
        System.out.println("-+-++-+-+-+-+-+-+-+-+++-" + fila);
        System.out.println("++-+-+-+-+-+-----------------++++" + cellCount);

/*        SECUENCIA DE MENSAJES
          1.-Desea Ud. Registrar la Garant
          2.- Se ha registrado correctamente la Garantía Nro.
          3.- Otras validaciones: Ingrese ...
          */

        return new DriverTask(driver -> {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.alertIsPresent());
            //CommonClass.sleep(2);
            String textoDeAlert0 = driver.switchTo().alert().getText();
            System.out.println("*************************El texto del alert es: " + textoDeAlert0);
            //Desea Ud. Registrar esta Garantía ?
            if (textoDeAlert0.contains("Desea Ud. Registrar la Garant")) {
                //Acepta mensaje: Desea Ud. Registrar esta Garantía
                driver.switchTo().alert().accept();
                CommonClass.sleep(8);

                System.out.println("---------------Se genera Nueva Garantia");
                String GAR;
                GAR = RegTituloValorUi.TXT_NROGARANTIA.resolveFor(theActorInTheSpotlight()).getText();
                System.out.println("*************************" + GAR);

                String GAC2;
                GAC2 = GAR.substring(GAR.lastIndexOf("Nro ") + 4);
                System.out.println("*************************" + GAC2);

                System.out.println("-----------------------------------------Ingresa a Else IF: Se ha registrado correctamente la Garant");
                System.out.println("-------Numero de Columna a insertar" + cellCount);
                try {
                    WriteXls.registro_TituloValor(Fila, cellCount, GAC2);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                RegTituloValorUi.BTN_VOLVER.resolveFor(theActorInTheSpotlight()).click();

            }
//            Otras Validaciones
//            - Verificar Datos de la Cuenta
//            - La cuenta no pertenece al Deudor
            else {
                String GAC;
                GAC = textoDeAlert0;
                System.out.println("************************* Ingresa a otras validaciones");
                //Ingrese ...
                try {
                    WriteXls.registro_TituloValor(Fila, cellCount, GAC);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                driver.switchTo().alert().accept();
            }
        });
    }



    //---------------------------------------------------------------------------------------------
    //FIDEICOMISO EN GARANTIA
    //---------------------------------------------------------------------------------------------
    public static Performable Valida_CU(int Fila, int cellCount)  {
        String GAC;
        GAC = "NO EXISTE CLIENTE,VERIFIQUE CODIGO";
        try {
            //Graba cuando el cliente no existe
            WriteXls.registro_FideicomisoGarantia(Fila, cellCount, GAC);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }


    public static Performable OpeLinInvalid_FideicomisoGarantia(int Fila, int cellCount){
        return new DriverTask(driver -> {
            ExpectedConditions.alertIsPresent();
            try {
                //Ingresa aquí cuando No se encuentra la operacion (alert)
                CommonClass.sleep(4);
                String textoDeAlert = driver.switchTo().alert().getText();
                System.out.println("*************************El texto del alert getText es: " + textoDeAlert);
                String GAC;
                GAC = textoDeAlert;
                if ((textoDeAlert.contains("No se encuentra la operacion Nro")) || (textoDeAlert.contains("No se encuentra la linea Nro"))){
                    System.out.println("************************* No se encuentra la operacion / Linea Nro.");
                    try {
                        WriteXls.registro_FideicomisoGarantia(Fila, cellCount, GAC);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
                driver.switchTo().alert().accept();
                Thread.sleep(3000);

            } catch (NoAlertPresentException | InterruptedException e) {
                //Ingresa aquí cuando operación si existe
                System.out.println("------------No se muestra alert;");
            }
        });
    }
/*
    public static Performable CtaInvalid_FideicomisoGarantia(int Fila, int cellCount){
        return new DriverTask(driver -> {
            ExpectedConditions.alertIsPresent();
            try {
                //Ingresa aquí cuando la cuenta es inválida (alert)
                CommonClass.sleep(4);
                String Alert_CtaFEG = driver.switchTo().alert().getText();
                System.out.println("*************************El texto del alert getText es: " + Alert_CtaFEG);
                String GAC;
                GAC = Alert_CtaFEG;
                if ((Alert_CtaFEG.contains(" La cuenta es inv")) ||(Alert_CtaFEG.contains("El CU Cliente de la cuenta"))){
                    System.out.println("************************* La cuenta es inv / no coincide con CU Cliente Deudor");
                    try {
                        WriteXls.registro_FideicomisoGarantia(Fila, cellCount, GAC);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
                driver.switchTo().alert().accept();
                Thread.sleep(3000);

            } catch (NoAlertPresentException | InterruptedException e) {
                //Ingresa aquí cuando la Cuenta existe
                System.out.println("la Cuenta existe");
            }
        });
    }*/



    public static Performable Aceptar_FideicomisoGarantia(int fila, int cellCount, int Fila) {
        System.out.println("-+-++-+-+-+-+-+-+-+-+++-" + fila);
        System.out.println("++-+-+-+-+-+-----------------++++" + cellCount);

/*        SECUENCIA DE MENSAJES
          1.-Desea Ud. Registrar esta Garantía
          2.- Se ha registrado correctamente la Garantía Nro.
          3.- Otras validaciones: Ingrese ...
          */

        return new DriverTask(driver -> {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.alertIsPresent());
            //CommonClass.sleep(2);
            String textoDeAlert0 = driver.switchTo().alert().getText();
            System.out.println("*************************El texto del alert es: " + textoDeAlert0);
            //Desea Ud. Registrar esta Garantía ?
            if (textoDeAlert0.contains("Desea Ud. Registrar esta Garant")) {
                //Acepta mensaje: Desea Ud. Registrar esta Garantía
                driver.switchTo().alert().accept();
                CommonClass.sleep(3);

                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(RegFianzaSolidariaUi.TXT_NROGARANTIA, isEnabled()).forNoMoreThan(30).seconds()
                );

                System.out.println("---------------Se genera Nueva Garantia");
                String GAR;
                GAR = RegFideicomisoGarantiaUi.TXT_NROGARANTIA.resolveFor(theActorInTheSpotlight()).getText();
                System.out.println("*************************" + GAR);

                String GAC2;
                GAC2 = GAR.substring(GAR.lastIndexOf("Nro ") + 4);
                System.out.println("*************************" + GAC2);

                System.out.println("-----------------------------------------Ingresa a Else IF: Se ha registrado correctamente la Garant");
                System.out.println("-------Numero de Columna a insertar" + cellCount);
                try {
                    WriteXls.registro_FideicomisoGarantia(Fila, cellCount, GAC2);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }

                RegFideicomisoGarantiaUi.BTN_VOLVER.resolveFor(theActorInTheSpotlight()).click();

            }
//            Otras Validaciones
//            - Verificar Datos de la Cuenta
//            - La cuenta no pertenece al Deudor
            else {
                String GAC;
                GAC = textoDeAlert0;
                System.out.println("************************* Ingresa a otras validaciones");
                //Ingrese ...
                try {
                    WriteXls.registro_FideicomisoGarantia(Fila, cellCount, GAC);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                driver.switchTo().alert().accept();
                //new motoresdebusqueda.gac.stepdefinitions.fideicomisogarantia.GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_garantía_Fideicomiso_en_Garantia();
            }
        });
    }




    //---------------------------------------------------------------------------------------------
    //CARTA FIANZA
    //---------------------------------------------------------------------------------------------
    public static Performable Valida_CU_CartaFianza(int Fila, int cellCount)  {
        String GAC;
        GAC = "NO EXISTE CLIENTE,VERIFIQUE CODIGO";
        try {
            //Graba cuando el cliente no existe
            WriteXls.registro_CartaFianza(Fila, cellCount, GAC);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }


    public static Performable OpeLinInvalid_CartaFianza(int Fila, int cellCount){
        return new DriverTask(driver -> {
            ExpectedConditions.alertIsPresent();
            try {
                //Ingresa aquí cuando No se encuentra la operacion (alert)
                CommonClass.sleep(4);
                String textoDeAlert = driver.switchTo().alert().getText();
                System.out.println("*************************El texto del alert getText es: " + textoDeAlert);
                String GAC;
                GAC = textoDeAlert;
                if ((textoDeAlert.contains("No se encuentra la operacion Nro")) || (textoDeAlert.contains("No se encuentra la linea Nro"))){
                    System.out.println("************************* No se encuentra la operacion / Linea Nro.");
                    try {
                        WriteXls.registro_CartaFianza(Fila, cellCount, GAC);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
                driver.switchTo().alert().accept();
                Thread.sleep(3000);

            } catch (NoAlertPresentException | InterruptedException e) {
                //Ingresa aquí cuando operación si existe
                System.out.println("------------No se muestra alert;");
            }
        });
    }


    public static Performable Aceptar_CartaFianza2(int fila, int cellCount, int Fila) {
        System.out.println("-+-++-+-+-+-+-+-+-+-+++-" + fila);
        System.out.println("++-+-+-+-+-+-----------------++++" + cellCount);

/*        SECUENCIA DE MENSAJES
          1.-Desea Ud. Registrar esta Garantía
          1.2.- El numero de Documento ya existe
          1.3.- El Banco no cuenta con saldo disponible. Si desea continuar con la operación favor de pulsar botón REGISTRAR.
          1.3.1.- El Banco no cuenta con saldo disponible. ¿Desea continuar?
          1.4.- Error Al Llamar A Método fValidarLineaClienteGAC En Web Service

          2.- Se ha registrado correctamente la Garantía Nro.
          3.- Otras validaciones: Ingrese ...
          */

        return new DriverTask(driver -> {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.alertIsPresent());
            //CommonClass.sleep(2);
            String textoDeAlert0 = driver.switchTo().alert().getText();
            System.out.println("*************************El texto del alert es: " + textoDeAlert0);
            //Desea Ud. Registrar esta Garantía ?
            if (textoDeAlert0.contains("Desea Ud. Registrar esta Garant")) {
                //Acepta mensaje: Desea Ud. Registrar esta Garantía
                driver.switchTo().alert().accept();
                //CommonClass.sleep(8);

                try {
                    WebDriverWait wait2 = new WebDriverWait(driver, 30);
                    wait2.until(ExpectedConditions.alertIsPresent());
                    CommonClass.sleep(4);
                    String textoDeAlert = driver.switchTo().alert().getText();
                    System.out.println("*************************El texto del alert es: " + textoDeAlert);
                    String GAC;
                    GAC = textoDeAlert;


                    if (textoDeAlert.contains("El numero de Documento ya existe")) {
                        System.out.println("************************* NUM REPETIDO");
                        WriteXls.registro_CartaFianza(Fila, cellCount, GAC);
                        //Acepta Mensaje: El numero de Documento ya existe
                        driver.switchTo().alert().accept();
                        CommonClass.sleep(8);
                    }
                    else if (textoDeAlert.contains("El Banco no cuenta con saldo disponible")) {
                        System.out.println("-----------------------------------------Ingresa a Else IF: Banco sin saldo");
                        System.out.println("-------Numero de Columna a insertar" + cellCount);
                        //Acepta Mensaje: El Banco no cuenta con saldo disponible. Si desea continuar con la operación favor de pulsar botón REGISTRAR.
                        driver.switchTo().alert().accept();
                        CommonClass.sleep(3);

                        if (RegCartaFianzaUi.BTN_REGISTRAR.resolveFor(theActorInTheSpotlight()).isVisible()) {
                            System.out.println("BTN_REGISTRAR VIsible");

                            //Se pulsa el botón REGISTRAR
                            RegCartaFianzaUi.BTN_REGISTRAR.resolveFor(theActorInTheSpotlight()).click();
                            //long keyEventMask_reg = FocusEvent.KEY_EVENT_MASK;

                            //Acepta Mensaje: El Banco no cuenta con saldo disponible. ¿Desea continuar?
                            driver.switchTo().alert().accept();
                            CommonClass.sleep(6);

                            String GAR;
                            GAR = RegCartaFianzaUi.TXT_NROGARANTIA.resolveFor(theActorInTheSpotlight()).getText();
                            System.out.println("*************************" + GAR);

                            String GAC2;
                            GAC2 = GAR.substring(GAR.lastIndexOf(". ") + 1);
                            System.out.println("*************************" + GAC2);

                            if (GAR.contains("Se ha registrado correctamente la Garant")) {
                                //Escribir en Excel
                                System.out.println("-----------------------------------------Ingresa a IF: Se ha registrado correctamente la Garant ");
                                System.out.println("-------Numero de Columna a insertar" + cellCount);
                                WriteXls.registro_CartaFianza(Fila, cellCount, GAC2);

                                RegCartaFianzaUi.BTN_VOLVER.resolveFor(theActorInTheSpotlight()).click();
                            }
                            //new GACMenuPrincipalStepDefinitions().se_ingresa_a_registrarGarantias();
                        }
                    }
                    //Error Al Llamar A Método fValidarLineaClienteGAC En Web Service
                    else if (textoDeAlert.contains("fValidarLineaClienteGAC ")) {
                        System.out.println("************************* fValidarLineaClienteGAC");
                        WriteXls.registro_CartaFianza(Fila, cellCount, GAC);
                        //Acepta Mensaje: Error Al Llamar A Método fValidarLineaClienteGAC En Web Service
                        driver.switchTo().alert().accept();
                        CommonClass.sleep(9);
                    }


                } catch (Exception e) {
                    System.out.println("---------------Se genera Garantia");

                    System.out.println("-----------------------------------------Ingresa a IF: Se ha registrado correctamente la Garant");
                    String GAR;
                    GAR = RegCartaFianzaUi.TXT_NROGARANTIA.resolveFor(theActorInTheSpotlight()).getText();
                    System.out.println("*************************" + GAR);

                    String GAC2;
                    GAC2 = GAR.substring(GAR.lastIndexOf(". ") + 1);
                    System.out.println("*************************" + GAC2);

                    System.out.println("-----------------------------------------Ingresa a Else IF: Se ha registrado correctamente la Garant");
                    System.out.println("-------Numero de Columna a insertar" + cellCount);
                    try {
                        WriteXls.registro_CartaFianza(Fila, cellCount, GAC2);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }

                    RegCartaFianzaUi.BTN_VOLVER.resolveFor(theActorInTheSpotlight()).click();
                    //new GACMenuPrincipalStepDefinitions().se_ingresa_a_registrarGarantias();

                }
            }
            //Otras Validaciones
            else {
                String GAC;
                GAC = textoDeAlert0;
                System.out.println("************************* Ingresa a otras validaciones");
                //Ingrese ...
                try {
                    WriteXls.registro_CartaFianza(Fila, cellCount, GAC);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                driver.switchTo().alert().accept();
                try {
                    new motoresdebusqueda.gac.stepdefinitions.cartafianza.GACMenuPrincipalStepDefinitions().se_selecciona_garantia_carta_fianza();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static Performable getTextError(int Fila, int cellCount){
        return new DriverTask(driver -> {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.alertIsPresent());
            CommonClass.sleep(4);
            String textoDeAlert = driver.switchTo().alert().getText();

            if(textoDeAlert!=null){ //cuando  No se encuentra la operacion
                System.out.println("*************************cuando  No se encuentra la operacion");
                String GAC;
                GAC= textoDeAlert;
                //System.out.println("La fila es: " + Fila +" La columna es: " + cellCount + " GAC / textoDeAlert: " + GAC);
                try {
                    WriteXls.registro_CartaFianza(Fila, cellCount, GAC);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }

        });
    }


    //---------------------------------------------------------------------------------------------
    //HIPOTECA COMERCIAL
    //---------------------------------------------------------------------------------------------
    public static Performable Valida_CU_Hipoteca(int Fila, int cellCount)  {
        String GAC;
        GAC = "NO EXISTE CLIENTE,VERIFIQUE CODIGO";
        try {
            //Graba cuando el cliente no existe
            WriteXls.registro_HipotecaComercial(Fila, cellCount, GAC);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static Performable OpeLinInvalid_HipotecaComercial(int Fila, int cellCount){
        return new DriverTask(driver -> {
            ExpectedConditions.alertIsPresent();
            try {
                //Ingresa aquí cuando No se encuentra la operacion (alert)
                CommonClass.sleep(4);
                String textoDeAlert = driver.switchTo().alert().getText();
                System.out.println("*************************El texto del alert getText es: " + textoDeAlert);
                String GAC;
                GAC = textoDeAlert;
                if ((textoDeAlert.contains("No se encuentra la operacion Nro")) || (textoDeAlert.contains("No se encuentra la linea Nro"))){
                    System.out.println("************************* No se encuentra la operacion / Linea Nro.");
                    try {
                        WriteXls.registro_HipotecaComercial(Fila, cellCount, GAC);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
                driver.switchTo().alert().accept();
                Thread.sleep(3000);

            } catch (NoAlertPresentException | InterruptedException e) {
                //Ingresa aquí cuando operación si existe
                System.out.println("------------No se muestra alert;");
            }
        });
    }

    public static Performable CtaInvalid_HipotecaComercial(int Fila, int cellCount){
        return new DriverTask(driver -> {
            ExpectedConditions.alertIsPresent();
            try {
                //Ingresa aquí cuando la cuenta es inválida (alert)
                CommonClass.sleep(4);
                String textoDeAlert = driver.switchTo().alert().getText();
                System.out.println("*************************El texto del alert getText es: " + textoDeAlert);
                String GAC;
                GAC = textoDeAlert;
                if ((textoDeAlert.contains("La cuenta es inv")) ||(textoDeAlert.contains("no coincide con CU Cliente Deudor"))){
                    System.out.println("************************* La cuenta es inv / no coincide con CU Cliente Deudor");
                    try {
                        WriteXls.registro_HipotecaComercial(Fila, cellCount, GAC);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
                driver.switchTo().alert().accept();
                Thread.sleep(3000);

            } catch (NoAlertPresentException | InterruptedException e) {
                //Ingresa aquí cuando la Cuenta existe
                System.out.println("------------No se muestra alert;");
            }
        });
    }

    public static Performable Aceptar_HipotecaComercial(int fila, int cellCount, int Fila) {
        System.out.println("-+-++-+-+-+-+-+-+-+-+++-" + fila);
        System.out.println("++-+-+-+-+-+-----------------++++" + cellCount);

        return new DriverTask(driver -> {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.alertIsPresent());
            CommonClass.sleep(2);
            driver.switchTo().alert().accept();
            CommonClass.sleep(8);

            try {
                WebDriverWait wait2 = new WebDriverWait(driver, 30);
                wait2.until(ExpectedConditions.alertIsPresent());
                CommonClass.sleep(4);
                String textoDeAlert = driver.switchTo().alert().getText();
                System.out.println("*************************El texto del alert es: " + textoDeAlert);
                String GAC;
                GAC = textoDeAlert;
                if (textoDeAlert.contains("El numero de Documento ya existe")) {
                    System.out.println("************************* NUM REPETIDO");
                    WriteXls.registro_HipotecaComercial(Fila, cellCount, GAC);
                }
                driver.switchTo().alert().accept();
                CommonClass.sleep(8);

            } catch (Exception e) {
                System.out.println("---------------Se genera Garantia");
                //System.out.println(e.getMessage());
            }
        });
    }

    //---------------------------------------------------------------------------------------------
    //GARANTIA MOBIIARIA SOBRE BIENES
    //---------------------------------------------------------------------------------------------
    public static Performable Valida_CU_MobiliariaBienes(int Fila, int cellCount)  {
        String GAC;
        GAC = "NO EXISTE CLIENTE,VERIFIQUE CODIGO";
        try {
            //Graba cuando el cliente no existe
            WriteXls.registro_HipotecaComercial(Fila, cellCount, GAC);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }
    public static Performable OpeLinInvalid_MobiliariaBienes(int Fila, int cellCount){
        return new DriverTask(driver -> {
            ExpectedConditions.alertIsPresent();
            try {
                //Ingresa aquí cuando No se encuentra la operacion (alert)
                CommonClass.sleep(4);
                String textoDeAlert = driver.switchTo().alert().getText();
                System.out.println("*************************El texto del alert getText es: " + textoDeAlert);
                String GAC;
                GAC = textoDeAlert;
                if ((textoDeAlert.contains("No se encuentra la operacion Nro")) || (textoDeAlert.contains("No se encuentra la linea Nro"))){
                    System.out.println("************************* No se encuentra la operacion / Linea Nro.");
                    try {
                        WriteXls.registro_MobiliariaBienes(Fila, cellCount, GAC);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }

                driver.switchTo().alert().accept();
                Thread.sleep(3000);

            } catch (NoAlertPresentException | InterruptedException e) {
                //Ingresa aquí cuando operación si existe
                System.out.println("------------No se muestra alert de Ope/Lin");
            }
        });
    }

    public static Performable CtaInvalid_MobiliariaBienes(int Fila, int cellCount){
        return new DriverTask(driver -> {
            ExpectedConditions.alertIsPresent();
            try {
                //Ingresa aquí cuando la cuenta es inválida (alert)
                CommonClass.sleep(4);
                String textoDeAlert = driver.switchTo().alert().getText();
                System.out.println("*************************El texto del alert getText es: " + textoDeAlert);
                String GAC;
                GAC = textoDeAlert;
                if ((textoDeAlert.contains("La cuenta es inv")) ||(textoDeAlert.contains("El CU Cliente de la cuenta"))){
                    System.out.println("************************* La cuenta es inv / no coincide con CU Cliente Deudor");
                    try {
                        WriteXls.registro_MobiliariaBienes(Fila, cellCount, GAC);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
                driver.switchTo().alert().accept();
                Thread.sleep(3000);

            } catch (NoAlertPresentException | InterruptedException e) {
                //Ingresa aquí cuando la Cuenta existe
                System.out.println("la Cuenta existe");
            }
        });
    }

    public static Performable Aceptar_MobiliariaBienes2(int fila, int cellCount, int Fila) {
        System.out.println("-+-++-+-+-+-+-+-+-+-+++-" + fila);
        System.out.println("++-+-+-+-+-+-----------------++++" + cellCount);

        return new DriverTask(driver -> {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.alertIsPresent());
            //CommonClass.sleep(2);
            String textoDeAlert1 = driver.switchTo().alert().getText();
            System.out.println("*************************El texto del alert es: " + textoDeAlert1);
            //Si validaciones son correctas:
            if (textoDeAlert1.contains("Desea Ud. Registrar la Garant")){
                driver.switchTo().alert().accept();
                System.out.println("Acepta despues de: Desea Ud. Registrar la Garant");
                //CommonClass.sleep(3);
                try {
                    System.out.println("Ingresa a Try despues de aceptar");
                    WebDriverWait wait2 = new WebDriverWait(driver, 15);
                    wait2.until(ExpectedConditions.alertIsPresent());
                    //CommonClass.sleep(10);
                    String textoDeAlert2 = driver.switchTo().alert().getText();
                    System.out.println("*************************GAC:" + textoDeAlert2);
                    String GAC;
                    GAC = textoDeAlert2;

/*                    if (textoDeAlert2.contains("El numero de Documento ya existe")) {
                        System.out.println("************************* NUM REPETIDO");
                        WriteXls.registro_MobiliariaBienes(Fila, cellCount, GAC);
                    }
                    else if (textoDeAlert2.contains("Ya Existe...Por Favor Verifique!")) {
                        System.out.println("************************* La Partida Registral XXXX Ya Existe...Por Favor Verifique");
                        WriteXls.registro_MobiliariaBienes(Fila, cellCount, GAC);
                    }
                    else {
                        System.out.println("************************* Nuevo mensaje de error"+GAC);
                        WriteXls.registro_MobiliariaBienes(Fila, cellCount, GAC);
                    }*/

                    System.out.println("************************* Nuevo mensaje de error"+GAC);
                    WriteXls.registro_MobiliariaBienes(Fila, cellCount, GAC);

                    driver.switchTo().alert().accept();
                    CommonClass.sleep(8);
                    //new starter.stepdefinitions.mobiliariabienes.GACMenuPrincipalStepDefinitions().se_selecciona_garantias_mobiliaria_bienes();

                } catch (Exception e) {
                    System.out.println("--------------- Catch Se genera Garantia");

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
                        try {
                            WriteXls.registro_MobiliariaBienes(Fila, cellCount, GAC);
                        } catch (IOException exception) {
                            exception.printStackTrace();
                        }
                        RegMobiliariaBienesUi.BTN_VOLVER.resolveFor(theActorInTheSpotlight()).click();
                    }
                    //System.out.println(e.getMessage());
                }
            }
            //Otras Validaciones
            else {
                String GAC;
                GAC = textoDeAlert1;
                System.out.println("************************* La Fecha de Tasación no puede ser mayor a la fecha actual");
                //GAC = "La Fecha de Tasación no puede ser mayor a la fecha actual";
                try {
                    WriteXls.registro_MobiliariaBienes(Fila, cellCount, GAC);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                driver.switchTo().alert().accept();
                try {
                    new motoresdebusqueda.gac.stepdefinitions.mobiliariabienes.GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_garantia_mobiliaria_bienes();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        });
    }



    //---------------------------------------------------------------------------------------------
    //GARANTIA HIPOTECA BANCA PERSONA
    //---------------------------------------------------------------------------------------------
    public static Performable Valida_CU_HipotecaBancaPersona(int Fila, int cellCount)  {
        String GAC;
        GAC = "NO EXISTE CLIENTE,VERIFIQUE CODIGO";
        try {
            //Graba cuando el cliente no existe
            WriteXls.registro_HipotecaBancaPersona(Fila, cellCount, GAC);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }
    public static Performable OpeLinInvalid_HipotecaBancaPersona(int Fila, int cellCount){
        return new DriverTask(driver -> {
            ExpectedConditions.alertIsPresent();
            try {
                //Ingresa aquí cuando No se encuentra la operacion (alert)
                CommonClass.sleep(4);
                String textoDeAlert = driver.switchTo().alert().getText();
                System.out.println("*************************El texto del alert getText es: " + textoDeAlert);
                String GAC;
                GAC = textoDeAlert;
                if ((textoDeAlert.contains("No se encuentra la operacion Nro")) || (textoDeAlert.contains("No se encuentra la linea Nro"))){
                    System.out.println("************************* No se encuentra la operacion / Linea Nro.");
                    try {
                        WriteXls.registro_HipotecaBancaPersona(Fila, cellCount, GAC);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }

                driver.switchTo().alert().accept();
                Thread.sleep(3000);

            } catch (NoAlertPresentException | InterruptedException e) {
                //Ingresa aquí cuando operación si existe
                System.out.println("------------No se muestra alert de Ope/Lin");
            }
        });
    }

    public static Performable CtaInvalid_HipotecaBancaPersona(int Fila, int cellCount){
        return new DriverTask(driver -> {
            ExpectedConditions.alertIsPresent();
            try {
                //Ingresa aquí cuando la cuenta es inválida (alert)
                CommonClass.sleep(4);
                String textoDeAlert = driver.switchTo().alert().getText();
                System.out.println("*************************El texto del alert getText es: " + textoDeAlert);
                String GAC;
                GAC = textoDeAlert;
                if ((textoDeAlert.contains("La cuenta es inv")) ||(textoDeAlert.contains("El CU Cliente de la cuenta"))){
                    System.out.println("************************* La cuenta es inv / no coincide con CU Cliente Deudor");
                    try {
                        WriteXls.registro_HipotecaBancaPersona(Fila, cellCount, GAC);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
                driver.switchTo().alert().accept();
                Thread.sleep(5000);

            } catch (NoAlertPresentException | InterruptedException e) {
                //Ingresa aquí cuando la Cuenta existe
                System.out.println("la Cuenta existe");
            }
        });
    }

    public static Performable Aceptar_HipotecaBancaPersona(int fila, int cellCount, int Fila) {
        System.out.println("-+-++-+-+-+-+-+-+-+-+++-" + fila);
        System.out.println("++-+-+-+-+-+-----------------++++" + cellCount);

        return new DriverTask(driver -> {
            WebDriverWait waitbase = new WebDriverWait(driver, 30);
            waitbase.until(ExpectedConditions.alertIsPresent());
            CommonClass.sleep(2);
            driver.switchTo().alert().accept();
            CommonClass.sleep(8);


            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.alertIsPresent());
            //CommonClass.sleep(2);
            String textoDeAlert1 = driver.switchTo().alert().getText();
            System.out.println("*************************El texto del alert es: " + textoDeAlert1);
            //Si validaciones son correctas:
            if (textoDeAlert1.contains("Desea Ud. Registrar la Garant")){
                driver.switchTo().alert().accept();
                System.out.println("Acepta despues de: Desea Ud. Registrar la Garant");
                //CommonClass.sleep(3);
                try {
                    System.out.println("Ingresa a Try despues de aceptar");
                    WebDriverWait wait2 = new WebDriverWait(driver, 15);
                    wait2.until(ExpectedConditions.alertIsPresent());
                    //CommonClass.sleep(10);
                    String textoDeAlert2 = driver.switchTo().alert().getText();
                    System.out.println("*************************GAC:" + textoDeAlert2);
                    String GAC;
                    GAC = textoDeAlert2;


                    System.out.println("************************* Nuevo mensaje de error"+GAC);
                    WriteXls.registro_HipotecaBancaPersona(Fila, cellCount, GAC);

                    driver.switchTo().alert().accept();
                    CommonClass.sleep(8);


                } catch (Exception e) {
                    System.out.println("--------------- Catch Se genera Garantia");

                    String GAR;
                    GAR = RegHipotecasBancaPersonaUi.TXT_NROGARANTIA.resolveFor(theActorInTheSpotlight()).getText();
                    System.out.println("*************************" + GAR);

                    String GAC;
                    GAC = GAR.substring(GAR.lastIndexOf(".")+16);
                    System.out.println("*************************" + GAC);


                    if (GAR.contains("Se ha ingresado correctamente"))
                    {
                        System.out.println("-------Numero de Columna a insertar" + cellCount );
                        try {
                            WriteXls.registro_HipotecaBancaPersona(Fila, cellCount, GAC);
                        } catch (IOException exception) {
                            exception.printStackTrace();
                        }
                        RegHipotecasBancaPersonaUi.BTN_VOLVER.resolveFor(theActorInTheSpotlight()).click();
                    }

                }
            }
            //Otras Validaciones
            else {
                String GAC;
                GAC = textoDeAlert1;
                System.out.println("************************* La Fecha de Tasación no puede ser mayor a la fecha actual");
                //GAC = "La Fecha de Tasación no puede ser mayor a la fecha actual";
                try {
                    WriteXls.registro_HipotecaBancaPersona(Fila, cellCount, GAC);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                driver.switchTo().alert().accept();
                try {
                    new motoresdebusqueda.gac.stepdefinitions.hipotecabancapersona.GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_Garantia_Hipoteca_Banca_Persona();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        });
    }

    //---------------------------------------------------------------------------------------------
    //GARANTIA MOBILIARIA SOBRE BIENES BANCA PERSONA
    //---------------------------------------------------------------------------------------------
    public static Performable Valida_CU_MobiliariaBienesBancaPersona(int Fila, int cellCount)  {
        String GAC;
        GAC = "NO EXISTE CLIENTE,VERIFIQUE CODIGO";
        try {
            //Graba cuando el cliente no existe
            WriteXls.registro_MobiliariaBienesBancaPersona(Fila, cellCount, GAC);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }
    public static Performable OpeLinInvalid_MobiliariaBienesBancaPersona(int Fila, int cellCount){
        return new DriverTask(driver -> {
            ExpectedConditions.alertIsPresent();
            try {
                //Ingresa aquí cuando No se encuentra la operacion (alert)
                CommonClass.sleep(4);
                String textoDeAlert = driver.switchTo().alert().getText();
                System.out.println("*************************El texto del alert getText es: " + textoDeAlert);
                String GAC;
                GAC = textoDeAlert;
                if ((textoDeAlert.contains("No se encuentra la operacion Nro")) || (textoDeAlert.contains("No se encuentra la linea Nro"))){
                    System.out.println("************************* No se encuentra la operacion / Linea Nro.");
                    try {
                        WriteXls.registro_MobiliariaBienesBancaPersona(Fila, cellCount, GAC);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }

                driver.switchTo().alert().accept();
                Thread.sleep(3000);

            } catch (NoAlertPresentException | InterruptedException e) {
                //Ingresa aquí cuando operación si existe
                System.out.println("------------No se muestra alert de Ope/Lin");
            }
        });
    }

    public static Performable CtaInvalid_MobiliariaBienesBancaPersona(int Fila, int cellCount) throws IOException {
        String GAC;
        GAC= " La cuenta es inválida";
        WriteXls.registro_MobiliariaBienesBancaPersona(Fila, cellCount, GAC);
        return null;
    }

    public static Performable Aceptar_MobiliariaBienesBancaPersona(int fila, int cellCount, int Fila) {
        System.out.println("-+-++-+-+-+-+-+-+-+-+++-" + fila);
        System.out.println("++-+-+-+-+-+-----------------++++" + cellCount);

        return new DriverTask(driver -> {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.alertIsPresent());
            CommonClass.sleep(2);
            String textoDeAlert1 = driver.switchTo().alert().getText();
            System.out.println("*************************El texto del alert es: " + textoDeAlert1);
            //Si validaciones son correctas:
            if (textoDeAlert1.contains("Desea Ud. Registrar  la Garant")){
                driver.switchTo().alert().accept();
                System.out.println("Acepta despues de: Desea Ud. Registrar la Garant");
                CommonClass.sleep(5);

               try {
                    System.out.println("Ruta1: Try Posible mensaje de error");
                    WebDriverWait wait2 = new WebDriverWait(driver, 15);
                    wait2.until(ExpectedConditions.alertIsPresent());
                    //CommonClass.sleep(10);
                    String textoDeAlert2 = driver.switchTo().alert().getText();
                    System.out.println("*************************GAC:" + textoDeAlert2);
                    String GAC;
                    GAC = textoDeAlert2;

                    System.out.println("************************* Nuevo mensaje de error"+GAC);
                    WriteXls.registro_MobiliariaBienesBancaPersona(Fila, cellCount, GAC);

                    driver.switchTo().alert().accept();
                    CommonClass.sleep(8);


                } catch (Exception e) {
                    System.out.println("--------------- Ruta2: Catch Se genera Garantia");

                    String GAR;
                    GAR = RegMobiliariaBienesBancaPersonaUi.TXT_NROGARANTIA.resolveFor(theActorInTheSpotlight()).getText();
                    System.out.println("*************************" + GAR);

                    String GAC;
                    GAC = GAR.substring(GAR.lastIndexOf(".")+1);
                    System.out.println("*************************" + GAC);


                    if (GAR.contains("Se ha ingresado correctamente"))
                    {
                        System.out.println("-------Numero de Columna a insertar" + cellCount );
                        try {
                            WriteXls.registro_MobiliariaBienesBancaPersona(Fila, cellCount, GAC);
                        } catch (IOException exception) {
                            exception.printStackTrace();
                        }
                        RegMobiliariaBienesBancaPersonaUi.BTN_VOLVER.resolveFor(theActorInTheSpotlight()).click();
                    }

                }
            }
            //Otras Validaciones - Ingresa aqui cuando algunos campos se encuentran vacíos
            //Ej. - Ingresar la Notaria
            //- Ingresar la Partida Registral
            else {
                String GAC;
                GAC = textoDeAlert1;
                System.out.println("************************* Ruta3: Campos vacíos o en blanco");

                try {
                    WriteXls.registro_MobiliariaBienesBancaPersona(Fila, cellCount, GAC);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                driver.switchTo().alert().accept();
                try {
                    new motoresdebusqueda.gac.stepdefinitions.mobiliariabienesbancapersona.GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_garantia_mobiliaria_bienes_banca_persona();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        });
    }



    //---------------------------------------------------------------------------------------------
    //GARANTIA MOBILIARIA SOBRE DINERO
    //---------------------------------------------------------------------------------------------
    public static Performable Valida_CU_Mobiliaria_Sobre_Dinero(int Fila, int cellCount)  {
        String GAC;
        GAC = "NO EXISTE CLIENTE,VERIFIQUE CODIGO";
        try {
            //Graba cuando el cliente no existe
            WriteXls.registro_MobiliariaSobreDinero(Fila, cellCount, GAC);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static Performable CtaInvalid_MobiliariaSobreDinero(int Fila, int cellCount){
        System.out.println("Ingresa a CtaInvalid_MobiliariaSobreDinero");
        String CtaInvalid;
        CtaInvalid = "La cuenta es inválida / Ya se encuentra registrada";
        try {
            //Graba cuando el cliente no existe
            WriteXls.registro_MobiliariaSobreDinero(Fila, cellCount, CtaInvalid);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static Performable OpeLinInvalid_MobiliariaSobreDinero(int Fila, int cellCount){
        return new DriverTask(driver -> {
            ExpectedConditions.alertIsPresent();
            try {
                //Ingresa aquí cuando No se encuentra la operacion (alert)
                CommonClass.sleep(4);
                String textoDeAlert = driver.switchTo().alert().getText();
                System.out.println("*************************El texto del alert getText es: " + textoDeAlert);
                String GAC;
                GAC = textoDeAlert;
                if ((textoDeAlert.contains("No se encuentra la operacion Nro")) || (textoDeAlert.contains("No se encuentra la linea Nro"))){
                    System.out.println("************************* No se encuentra la operacion / Linea Nro.");
                    try {
                        WriteXls.registro_MobiliariaSobreDinero(Fila, cellCount, GAC);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }

                driver.switchTo().alert().accept();
                Thread.sleep(3000);

            } catch (NoAlertPresentException | InterruptedException e) {
                //Ingresa aquí cuando operación si existe
                System.out.println("------------No se muestra alert de Ope/Lin");
            }
        });
    }



    public static Performable Aceptar_MobiliriaSobreDinero(int fila, int cellCount, int Fila) {
        System.out.println("-+-++-+-+-+-+-+-+-+-+++-" + fila);
        System.out.println("++-+-+-+-+-+-----------------++++" + cellCount);

        return new DriverTask(driver -> {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.alertIsPresent());
            //CommonClass.sleep(2);
            String textoDeAlert1 = driver.switchTo().alert().getText();
            System.out.println("*************************El texto del alert es: " + textoDeAlert1);
            //Si validaciones son correctas:
            if (textoDeAlert1.contains("Desea Ud. Registrar la Garant")){
                driver.switchTo().alert().accept();
                System.out.println("Acepta despues de: Desea Ud. Registrar la Garant");
                //CommonClass.sleep(3);
                try {
                    System.out.println("Ruta1: Try Posible mensaje de error");
                    WebDriverWait wait2 = new WebDriverWait(driver, 15);
                    wait2.until(ExpectedConditions.alertIsPresent());
                    //CommonClass.sleep(10);
                    String textoDeAlert2 = driver.switchTo().alert().getText();
                    System.out.println("*************************GAC:" + textoDeAlert2);
                    String GAC;
                    GAC = textoDeAlert2;


                    System.out.println("************************* Nuevo mensaje de error"+GAC);
                    WriteXls.registro_MobiliariaSobreDinero(Fila, cellCount, GAC);

                    driver.switchTo().alert().accept();
                    CommonClass.sleep(8);


                } catch (Exception e) {
                    System.out.println("--------------- Ruta2: Catch Se genera Garantia");

                    String GAR;
                    GAR = RegMobiliariaSobreDineroUi.TXT_NROGARANTIA.resolveFor(theActorInTheSpotlight()).getText();
                    System.out.println("*************************" + GAR);

                    String GAC;
                    //Cuenta N° dígitos a partir de inicio de palabra
                    GAC = GAR.substring(GAR.lastIndexOf("Nro")+4);
                    System.out.println("*************************" + GAC);


                    if (GAR.contains("Se ha registrado"))
                    {
                        System.out.println("-------Numero de Columna a insertar" + cellCount );
                        try {
                            WriteXls.registro_MobiliariaSobreDinero(Fila, cellCount, GAC);
                        } catch (IOException exception) {
                            exception.printStackTrace();
                        }
                        RegMobiliariaSobreDineroUi.BTN_VOLVER.resolveFor(theActorInTheSpotlight()).click();
                    }

                }
            }
            //Otras Validaciones
            else {
                String GAC;
                GAC = textoDeAlert1;
                System.out.println("************************* Ruta3: Campos vacíos o en blanco");
                //GAC = "La Fecha de Tasación no puede ser mayor a la fecha actual";
                try {
                    WriteXls.registro_MobiliariaSobreDinero(Fila, cellCount, GAC);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                driver.switchTo().alert().accept();
                try {
                    new motoresdebusqueda.gac.stepdefinitions.mobiliariadinero.GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_garantia_mobiliaria_sobre_dinero();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        });
    }



    //---------------------------------------------------------------------------------------------
    //STAND BY
    //---------------------------------------------------------------------------------------------
    public static Performable Valida_CU_StandBy(int Fila, int cellCount)  {
        String GAC;
        GAC = "NO EXISTE CLIENTE,VERIFIQUE CODIGO";
        try {
            //Graba cuando el cliente no existe
            WriteXls.registro_StandBy(Fila, cellCount, GAC);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static Performable Valida_Lin_Asoc_Bco(int Fila, int cellCount)  {
        String GAC;
        GAC = "No se encontraron Líneas Asociadas Al Banco/Convenio";
        try {
            //Graba cuando el cliente no existe
            WriteXls.registro_StandBy(Fila, cellCount, GAC);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }

/*    public static Performable AceptaPendiente(){
        System.out.println("AceptaPendiente");
        return new DriverTask(driver -> {
            System.out.println("AceptaPendiente_2");
            //driver.switchTo().defaultContent();
            WebDriverWait wait = new WebDriverWait(driver, 30);
            System.out.println("AceptaPendiente_3");
            wait.until(ExpectedConditions.alertIsPresent());
            CommonClass.sleep(1);
            driver.switchTo().alert().accept();
        });
    }*/
    public static Performable AceptaPendiente(){
        return new DriverTask(driver -> {
            ExpectedConditions.alertIsPresent();
            System.out.println("ingresa a alertIsPresent");
            try {
                System.out.println("Inresa a try");
                 driver.switchTo().alert().accept();
                Thread.sleep(3000);

            } catch (NoAlertPresentException | InterruptedException e) {
                //Ingresa aquí cuando operación si existe
                System.out.println("------------No ingresa a Try");
            }
        });
    }

    public static Performable OpeLinInvalid_StandBy(int Fila, int cellCount){
        return new DriverTask(driver -> {
            ExpectedConditions.alertIsPresent();
            try {
                //Ingresa aquí cuando No se encuentra la operacion (alert)
                CommonClass.sleep(4);
                String textoDeAlert = driver.switchTo().alert().getText();
                System.out.println("*************************El texto del alert getText es: " + textoDeAlert);
                String GAC;
                GAC = textoDeAlert;
                if ((textoDeAlert.contains("No se encuentra la operacion Nro")) || (textoDeAlert.contains("No se encuentra la linea Nro"))){
                    System.out.println("************************* No se encuentra la operacion / Linea Nro.");
                    try {
                        WriteXls.registro_StandBy(Fila, cellCount, GAC);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
                driver.switchTo().alert().accept();
                Thread.sleep(3000);

            } catch (NoAlertPresentException | InterruptedException e) {
                //Ingresa aquí cuando operación si existe
                System.out.println("------------No se muestra alert;");
            }
        });
    }


    public static Performable Aceptar_StandBy(int fila, int cellCount, int Fila) {
        System.out.println("-+-++-+-+-+-+-+-+-+-+++-" + fila);
        System.out.println("++-+-+-+-+-+-----------------++++" + cellCount);

/*        SECUENCIA DE MENSAJES
          1.-Desea Ud. Registrar esta Garantía
          1.2.- El numero de Documento ya existe
          1.3.- El Banco no cuenta con saldo disponible. Si desea continuar con la operación favor de pulsar botón REGISTRAR.
          1.3.1.- El Banco no cuenta con saldo disponible. ¿Desea continuar?
          1.4.- Error Al Llamar A Método fValidarLineaClienteGAC En Web Service

          2.- Se ha registrado correctamente la Garantía Nro.
          3.- Otras validaciones: Ingrese ...
          */

        return new DriverTask(driver -> {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.alertIsPresent());
            //CommonClass.sleep(2);
            String textoDeAlert0 = driver.switchTo().alert().getText();
            System.out.println("*************************El texto del alert es: " + textoDeAlert0);
            //Desea Ud. Registrar esta Garantía ?
            if (textoDeAlert0.contains("Desea Ud. Registrar esta Garant")) {
                //Acepta mensaje: Desea Ud. Registrar esta Garantía
                driver.switchTo().alert().accept();
                //CommonClass.sleep(8);

                try {
                    System.out.println("Ruta1: Try Posible mensaje de error");
                    WebDriverWait wait2 = new WebDriverWait(driver, 30);
                    wait2.until(ExpectedConditions.alertIsPresent());
                    CommonClass.sleep(4);
                    String textoDeAlert = driver.switchTo().alert().getText();
                    System.out.println("*************************El texto del alert es: " + textoDeAlert);
                    String GAC;
                    GAC = textoDeAlert;


                    if (textoDeAlert.contains("El numero de Documento ya existe")) {
                        System.out.println("*************************Ruta 1.2.- El numero de Documento ya existe");
                        WriteXls.registro_StandBy(Fila, cellCount, GAC);
                        //Acepta Mensaje: El numero de Documento ya existe
                        driver.switchTo().alert().accept();
                        CommonClass.sleep(8);
                    }
                    else if (textoDeAlert.contains("El Banco no cuenta con saldo disponible")) {
                        System.out.println("-----------------------------------------Ruta 1.3.- El Banco no cuenta con saldo disponible");
                        System.out.println("-------Numero de Columna a insertar" + cellCount);
                        //Acepta Mensaje: El Banco no cuenta con saldo disponible. Si desea continuar con la operación favor de pulsar botón REGISTRAR.
                        driver.switchTo().alert().accept();
                        CommonClass.sleep(3);

                        if (RegStandByUi.BTN_REGISTRAR.resolveFor(theActorInTheSpotlight()).isVisible()) {
                            System.out.println("BTN_REGISTRAR VIsible");

                            //Se pulsa el botón REGISTRAR
                            RegStandByUi.BTN_REGISTRAR.resolveFor(theActorInTheSpotlight()).click();
                            //long keyEventMask_reg = FocusEvent.KEY_EVENT_MASK;

                            //Acepta Mensaje: El Banco no cuenta con saldo disponible. ¿Desea continuar?
                            System.out.println("Ruta 1.3.1.- El Banco no cuenta con saldo disponible. ¿Desea continuar?");
                            driver.switchTo().alert().accept();
                            CommonClass.sleep(6);

                            String GAR;
                            GAR = RegStandByUi.TXT_NROGARANTIA.resolveFor(theActorInTheSpotlight()).getText();
                            System.out.println("*************************" + GAR);

                            String GAC2;
                            GAC2 = GAR.substring(GAR.lastIndexOf(". ") + 1);
                            System.out.println("*************************" + GAC2);

                            if (GAR.contains("Se ha registrado correctamente la Garant")) {
                                //Escribir en Excel
                                System.out.println("-----------------------------------------Ingresa a IF: Se ha registrado correctamente la Garant ");
                                System.out.println("-------Numero de Columna a insertar" + cellCount);
                                WriteXls.registro_StandBy(Fila, cellCount, GAC2);

                                RegStandByUi.BTN_VOLVER.resolveFor(theActorInTheSpotlight()).click();
                            }
                            //new GACMenuPrincipalStepDefinitions().se_ingresa_a_registrarGarantias();
                        }
                    }
                    //Error Al Llamar A Método fValidarLineaClienteGAC En Web Service
                    else if (textoDeAlert.contains("fValidarLineaClienteGAC ")) {
                        System.out.println("************************* Ruta 1.4.- Error Al Llamar A Método fValidarLineaClienteGAC En Web Service");
                        WriteXls.registro_StandBy(Fila, cellCount, GAC);
                        //Acepta Mensaje: Error Al Llamar A Método fValidarLineaClienteGAC En Web Service
                        driver.switchTo().alert().accept();
                        CommonClass.sleep(9);
                    }


                } catch (Exception e) {
                    System.out.println("---------------Se genera Garantia");

                    System.out.println("-----------------------------------------Ruta 2.- Se ha registrado correctamente la Garantía Nro.");
                    String GAR;
                    GAR = RegStandByUi.TXT_NROGARANTIA.resolveFor(theActorInTheSpotlight()).getText();
                    System.out.println("*************************" + GAR);


                    String GAC2;
                    //Cuenta N° dígitos a partir de inicio de palabra
                    GAC2 = GAR.substring(GAR.lastIndexOf("- ") + 1);
                    System.out.println("*************************" + GAC2);
                    System.out.println("-------Numero de Columna a insertar" + cellCount);
                    try {
                        WriteXls.registro_StandBy(Fila, cellCount, GAC2);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }

                    RegStandByUi.BTN_VOLVER.resolveFor(theActorInTheSpotlight()).click();
                    //new GACMenuPrincipalStepDefinitions().se_ingresa_a_registrarGarantias();

                }
            }
            //Otras Validaciones
            else {
                String GAC;
                GAC = textoDeAlert0;
                System.out.println("************************* Ruta 3.- Otras validaciones: Ingrese");
                //Ingrese ...
                try {
                    WriteXls.registro_StandBy(Fila, cellCount, GAC);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                driver.switchTo().alert().accept();
                try {
                    new motoresdebusqueda.gac.stepdefinitions.standby.GACMenuPrincipalStepDefinitions().se_selecciona_tipo_de_Garantia_Stand_By();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

//Fin


    //OTROS por validar - cobertura Generica
    public static Performable CobEspecifica(){
        System.out.println("CobEspecifica_1");
        return new DriverTask(driver -> {
            System.out.println("CobEspecifica_2");
            //driver.switchTo().defaultContent();
            WebDriverWait wait = new WebDriverWait(driver, 30);
            System.out.println("CobEspecifica_3");
            wait.until(ExpectedConditions.alertIsPresent());
            CommonClass.sleep(1);
            driver.switchTo().alert().accept();
        });
    }

    public static Performable toAccept(){
        return new DriverTask(driver -> {
            driver.switchTo().alert().accept();
        });
    }
    public static Performable CobGen2(){
        return new DriverTask(driver -> {
            //driver.switchTo().defaultContent();
            System.out.println("Ingresa a alert");
            ExpectedConditions.alertIsPresent();
            try {
                CommonClass.sleep(3);
                System.out.println("si alert");
                driver.switchTo().alert().accept();

            } catch (NoAlertPresentException e) {
                System.out.println("No alert");
                e.printStackTrace();
            }
           /* ExpectedConditions.alertIsPresent();
            try {
                //Thread.sleep(1000);
                CommonClass.sleep(3);
                System.out.println("------------Try alert;");
                driver.switchTo().alert().accept();
                Thread.sleep(3);
            } catch (NoAlertPresentException | InterruptedException e) {
                //Ingresa aquí cuando operación si existe
                System.out.println("------------No se muestra alert;");
            }*/

        });
    }

    public static Performable CobGen3(){
        return new DriverTask(driver -> {

            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.alertIsPresent());
            try {
                //Thread.sleep(1000);
                CommonClass.sleep(4);
                System.out.println("------------try;");
                driver.switchTo().alert().accept();
            } catch (NoAlertPresentException e) {
                //Ingresa aquí cuando operación si existe
                System.out.println("------------No se muestra alert;");
            }

            driver.switchTo().alert().accept();
            //driver.findElement(By.id("Value")).sendKeys(Keys.ENTER);
            //driver.switchTo().parentFrame().switchTo().alert().accept();
            CommonClass.sleep(4);
        });
    }

    public static Performable CobGen4(){
        return new DriverTask(driver -> {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleContains("Mensaje de la p"));
            CommonClass.sleep(2);
            driver.switchTo().alert().accept();
            CommonClass.sleep(8);
        });
    }
}
    //Otros
/*    public static Performable accept() {
        return new DriverTask(AlertAccept::accept);
    }*/

/*    private static void accept(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.alertIsPresent());
        CommonClass.sleep(2);
        driver.switchTo().alert().accept();
        CommonClass.sleep(8);

        try {
            WebDriverWait wait2 = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.alertIsPresent());
            CommonClass.sleep(4);
            String textoDeAlert = driver.switchTo().alert().getText();
            System.out.println("*************************El texto del alert es: " + textoDeAlert);
            if (textoDeAlert.contains("El numero de Documento ya existe")){
                System.out.println("************************* NUM REPETIDO");
            }
            driver.switchTo().alert().accept();
            CommonClass.sleep(8);

        }catch (Exception e){
            System.out.println("---------------Se genera Garantia");
            //System.out.println(e.getMessage());
        }
    }*/




/*    public static Performable getText(){
        return new DriverTask(driver -> {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.alertIsPresent());
            CommonClass.sleep(4);
            String textoDeAlert = driver.switchTo().alert().getText();
            System.out.println("*************************El texto del alert getText es: " + textoDeAlert);
        });
    }*/









//Otras opciones de Alert
//1.- Primer método
/*                    try {
                        System.out.println("Ingresa Try primer metodo");
                        WebDriverWait wait = new WebDriverWait(driver,3);
                        if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
                            System.out.println("alert was not present");
                        } else {
                            System.out.println("alert was present");
                        }
                    } catch (Exception e) {
                        //e.printStackTrace();
                        System.out.println("PRIMER METODO e.printStackTrace(); ");
                        theActorInTheSpotlight().attemptsTo(
                                AlertAccept.OpeLinInvalid_CartaFianza(Fila,cellCount)
                        );
                    }*/

//2.- Usando alert class directamente
/*                        try
                        {
                            System.out.println("Ingresa Try");
                        }
                        catch (NoAlertPresentException ne)
                        {
                            System.out.println("Ingresa Catch");
                            ne.printStackTrace();
                        }*/


//3.- Usando getWindowHanles()
    /*
                   Set<String> wids=driver.getWindowHandles();
                    if (wids.size()>1){
                        System.out.println("Window display");
                        driver.switchTo().window("Mensaje de la página web");
                        try {
                            System.out.println("Ingresa Try tercer metodo");
                           *//* WebElement elementOnPopup=driver.findElement(By.id("test"));
                            if (elementOnPopup.isDisplayed()){
                                elementOnPopup.click();
                            }*//*
                        }
                        catch (NoSuchElementException ne){
                        System.out.println("Window display pero no se puede dar clic en yes / not");
                        }
                        }
                    else
                        {
                        System.out.println("No Window display");
                        }
*/

//4.- Usando presenceOfAlert
/*                        boolean presenceOfAlert = false;
                        WebDriverWait wait = new WebDriverWait(driver, 30);
                        try
                        {
                            wait.until(ExpectedConditions.alertIsPresent());
                            presenceOfAlert = true;
                            System.out.println("Alert preente" + presenceOfAlert);
                        }
                        //catch (TimeoutException e)
                        catch (Exception e)
                        {
                            presenceOfAlert = false;
                            System.out.println("Alert NO preente" + presenceOfAlert);
                        }*/
