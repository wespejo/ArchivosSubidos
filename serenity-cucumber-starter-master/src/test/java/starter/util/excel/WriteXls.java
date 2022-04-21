package starter.util.excel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteXls {
    public static void registro_FianzaSolidaria(int Fila, int cellCount, String GAC) throws IOException {
        String path = "D:\\IBK\\GAC AUTOMATION\\Data\\Data-FianzaSolidaria.xlsx";
        FileInputStream file = new FileInputStream(new File(path));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        sheet.getRow(Fila).createCell(cellCount).setCellValue(GAC);
        System.out.println("+++++++++++++++++++Writing Excel Fianza Solidaria");

        FileOutputStream output = new FileOutputStream(path);
        workbook.write(output);
        workbook.close();
    }
    public static void registro_TituloValor(int Fila, int cellCount, String GAC) throws IOException {
        String path = "D:\\IBK\\GAC AUTOMATION\\Data\\Data-TituloValor.xlsx";
        FileInputStream file = new FileInputStream(new File(path));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        sheet.getRow(Fila).createCell(cellCount).setCellValue(GAC);
        System.out.println("+++++++++++++++++++Writing Excel Titulo Valor");

        FileOutputStream output = new FileOutputStream(path);
        workbook.write(output);
        workbook.close();
    }
    public static void registro_FideicomisoGarantia(int Fila, int cellCount, String GAC) throws IOException {
        String path = "D:\\IBK\\GAC AUTOMATION\\Data\\Data-FideicomisoGarantia.xlsx";
        FileInputStream file = new FileInputStream(new File(path));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        sheet.getRow(Fila).createCell(cellCount).setCellValue(GAC);
        System.out.println("+++++++++++++++++++Writing Excel Fideicomiso Garantia");

        FileOutputStream output = new FileOutputStream(path);
        workbook.write(output);
        workbook.close();
    }


    public static void registro_CartaFianza(int Fila, int cellCount, String GAC) throws IOException {
        String path = "D:\\IBK\\GAC AUTOMATION\\Data\\Data-Carta_Fianza.xlsx";
        FileInputStream file = new FileInputStream(new File(path));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        sheet.getRow(Fila).createCell(cellCount).setCellValue(GAC);
        System.out.println("+++++++++++++++++++Writing Excel Carta Fianza");

        FileOutputStream output = new FileOutputStream(path);
        workbook.write(output);
        workbook.close();
    }
    public static void registro_HipotecaComercial(int Fila, int cellCount, String GAC) throws IOException {
        String path = "D:\\IBK\\GAC AUTOMATION\\Data\\Data-Hipotecas.xlsx";
        FileInputStream file = new FileInputStream(new File(path));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        sheet.getRow(Fila).createCell(cellCount).setCellValue(GAC);
        System.out.println("+++++++++++++++++++Writing Excel Hipoteca Comercial");

        FileOutputStream output = new FileOutputStream(path);
        workbook.write(output);
        workbook.close();

    }

    public static void registro_MobiliariaBienes(int Fila, int cellCount, String GAC) throws IOException {
        String path = "D:\\IBK\\GAC AUTOMATION\\Data\\Data-MobiliariaSobreBienes.xlsx";
        FileInputStream file = new FileInputStream(new File(path));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        sheet.getRow(Fila).createCell(cellCount).setCellValue(GAC);
        System.out.println("+++++++++++++++++++Writing Excel Mobiliaria Sobre Bienes");

        FileOutputStream output = new FileOutputStream(path);
        workbook.write(output);
        workbook.close();

    }

    public static void registro_HipotecaBancaPersona(int Fila, int cellCount, String GAC) throws IOException {
        String path = "D:\\IBK\\GAC AUTOMATION\\Data\\Data-HipotecaBancaPersona.xlsx";
        FileInputStream file = new FileInputStream(new File(path));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        sheet.getRow(Fila).createCell(cellCount).setCellValue(GAC);
        System.out.println("+++++++++++++++++++Writing Excel Hipoteca Banca Persona");

        FileOutputStream output = new FileOutputStream(path);
        workbook.write(output);
        workbook.close();

    }

    public static void registro_MobiliariaBienesBancaPersona(int Fila, int cellCount, String GAC) throws IOException {
        String path = "D:\\IBK\\GAC AUTOMATION\\Data\\Data-MobiliariaSobreBienesBancaPersona.xlsx";
        FileInputStream file = new FileInputStream(new File(path));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        sheet.getRow(Fila).createCell(cellCount).setCellValue(GAC);
        System.out.println("+++++++++++++++++++Writing Excel Mobiliaria Bienes Banca Persona");

        FileOutputStream output = new FileOutputStream(path);
        workbook.write(output);
        workbook.close();

    }


    public static void registro_MobiliariaSobreDinero(int Fila, int cellCount, String GAC) throws IOException {
        String path = "D:\\IBK\\GAC AUTOMATION\\Data\\Data-MobiliariaSobreDinero.xlsx";
        FileInputStream file = new FileInputStream(new File(path));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        sheet.getRow(Fila).createCell(cellCount).setCellValue(GAC);
        System.out.println("+++++++++++++++++++Writing Excel Mobiliaria Sobre Dinero");

        FileOutputStream output = new FileOutputStream(path);
        workbook.write(output);
        workbook.close();

    }

    public static void registro_StandBy(int Fila, int cellCount, String GAC) throws IOException {
        String path = "D:\\IBK\\GAC AUTOMATION\\Data\\Data-Stand_By.xlsx";
        FileInputStream file = new FileInputStream(new File(path));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        sheet.getRow(Fila).createCell(cellCount).setCellValue(GAC);
        System.out.println("+++++++++++++++++++Writing Excel Stand By");

        FileOutputStream output = new FileOutputStream(path);
        workbook.write(output);
        workbook.close();
    }

}
