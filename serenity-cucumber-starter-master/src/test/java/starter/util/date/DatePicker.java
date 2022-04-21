package starter.util.date;

import motoresdebusqueda.gac.page.fianzasolidaria.RegFianzaSolidariaUi;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Performable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DatePicker {
    public static Performable Fecha_Dec_Pat(String fecdeclaracion) throws InterruptedException {
        String emonth = fecdeclaracion.split("/")[1];
        String edate = fecdeclaracion.split("/")[0];
        String eyear = fecdeclaracion.split("/")[2];

        //formato de fecha (día) igual a celendario
        switch (edate){
            case "01":
                edate = "1";
                break;
            case "02":
                edate = "2";
                break;
            case "03":
                edate = "3";
                break;
            case "04":
                edate = "4";
                break;
            case "05":
                edate = "5";
                break;
            case "06":
                edate = "6";
                break;
            case "07":
                edate = "7";
                break;
            case "08":
                edate = "8";
                break;
            case "09":
                edate = "9";
                break;
        }

         switch (emonth){
             case "01":
                 emonth = "January";
                 break;
             case "02":
                 emonth = "February";
                 break;
             case "03":
                 emonth = "March";
                 break;
             case "04":
                 emonth = "April";
                 break;
             case "05":
                 emonth = "May";
                 break;
             case "06":
                 emonth = "June";
                 break;
             case "07":
                 emonth = "July";
                 break;
             case "08":
                 emonth = "August";
                 break;
             case "09":
                 emonth = "Septembre";
                 break;
             case "10":
                 emonth = "October";
                 break;
             case "11":
                 emonth = "November";
                 break;
             case "12":
                 emonth = "December";
                 break;
         }

        System.out.println("edate: " +edate);
        System.out.println("emonth: "+emonth);
        System.out.println("eyear: " +eyear);

        //Fecha mostrada cuando se selecciona calendario -- se obtiene mes y año de calendario
        String cmonth_total;
        cmonth_total = Serenity.getWebdriverManager().getCurrentDriver().findElement(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_ceFecDecPatrimonial_title")).getText().trim();
        System.out.println("año - mes total: "+cmonth_total);
        //partimos en mes y año
        String cmonth = cmonth_total.split(",")[0].trim();
        String cyear = cmonth_total.split(",")[1].trim();
        System.out.println("cmonth:" +cmonth);
        System.out.println("cyear:" +cyear);

        //Selecciona mes y año igual a lo esperado
        while  ( (!cmonth.contains(emonth)) || (!cyear.contains(eyear)) ) {
           RegFianzaSolidariaUi.BTN_NEXT_FECDECPAT.resolveFor(theActorInTheSpotlight()).click();
           cmonth_total = Serenity.getWebdriverManager().getCurrentDriver().findElement(By.id("ctl00_cphPrincipal_tabGarantias_tabDatosGarantias_ceFecDecPatrimonial_title")).getText().trim();
            cmonth = cmonth_total.split(",")[0].trim();
            cyear = cmonth_total.split(",")[1].trim();
            System.out.println("año - mes_tot2:"+cmonth_total);
            System.out.println("cmonth:" +cmonth);
            System.out.println("cyear:" +cyear);
        }
        //Permite que se muestre mes correcto
        Thread.sleep(2000);

        //Selecciona día igual a lo esperado
        List<WebElement> dates = Serenity.getWebdriverManager().getCurrentDriver().findElements(By.xpath("//div[@class='ajax__calendar_day']"));

        for (WebElement e:dates){
            System.out.println("dates:"+e);
            if (e.getText().trim().equals(edate)) {
            //if (e.getText().trim().contentEquals(edate)) {
                System.out.println("Ingresa a IF");
                System.out.println("e2:"+e);
                System.out.println("edate2:"+edate);
                e.click();
                break;
            }
        }
        Thread.sleep(3000);
        return null;
    }

}
