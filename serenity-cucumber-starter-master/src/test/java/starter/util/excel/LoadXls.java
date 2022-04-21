package starter.util.excel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class LoadXls
{
    public static Sheet getSheet_CartaFianza(int index, String FileName)
    {
        try
        {
            String path = "D:\\IBK\\GAC AUTOMATION\\Data\\".concat(FileName);
            FileInputStream file = new FileInputStream(new File(path));
            Workbook workbook = new XSSFWorkbook(file);

            return workbook.getSheetAt(index);

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static Sheet getSheet_HipotecaComercial(int index,  String FileName)
    {
        try
        {
            String path = "D:\\IBK\\GAC AUTOMATION\\Data\\".concat(FileName);
            FileInputStream file = new FileInputStream(new File(path));
            Workbook workbook = new XSSFWorkbook(file);

            return workbook.getSheetAt(index);

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static Sheet getSheet_MobiliariaSobreBienes(int index,  String FileName)
    {
        try
        {
            String path = "D:\\IBK\\GAC AUTOMATION\\Data\\".concat(FileName);
            FileInputStream file = new FileInputStream(new File(path));
            Workbook workbook = new XSSFWorkbook(file);

            return workbook.getSheetAt(index);

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static Sheet getSheet_FideicomisoGarantia(int index,  String FileName)
    {
        try
        {
            String path = "D:\\IBK\\GAC AUTOMATION\\Data\\".concat(FileName);
            FileInputStream file = new FileInputStream(new File(path));
            Workbook workbook = new XSSFWorkbook(file);

            return workbook.getSheetAt(index);

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static Sheet getSheet_TituloValor(int index,  String FileName)
    {
        try
        {
            String path = "D:\\IBK\\GAC AUTOMATION\\Data\\".concat(FileName);
            FileInputStream file = new FileInputStream(new File(path));
            Workbook workbook = new XSSFWorkbook(file);

            return workbook.getSheetAt(index);

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Sheet getSheet_FianzaSolidaria(int index,  String FileName)
    {
        try
        {
            String path = "D:\\IBK\\GAC AUTOMATION\\Data\\".concat(FileName);
            FileInputStream file = new FileInputStream(new File(path));
            Workbook workbook = new XSSFWorkbook(file);

            return workbook.getSheetAt(index);

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Sheet getSheet_HipotecaBancaPersona(int index,  String FileName)
    {
        try
        {
            String path = "D:\\IBK\\GAC AUTOMATION\\Data\\".concat(FileName);
            FileInputStream file = new FileInputStream(new File(path));
            Workbook workbook = new XSSFWorkbook(file);

            return workbook.getSheetAt(index);

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Sheet getSheet_MobiliariaBienesBancaPersona(int index,  String FileName)
    {
        try
        {
            String path = "D:\\IBK\\GAC AUTOMATION\\Data\\".concat(FileName);
            FileInputStream file = new FileInputStream(new File(path));
            Workbook workbook = new XSSFWorkbook(file);

            return workbook.getSheetAt(index);

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Sheet getSheet_MobiliariaSobreDinero(int index,  String FileName)
    {
        try
        {
            String path = "D:\\IBK\\GAC AUTOMATION\\Data\\".concat(FileName);
            FileInputStream file = new FileInputStream(new File(path));
            Workbook workbook = new XSSFWorkbook(file);

            return workbook.getSheetAt(index);

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Sheet getSheet_StandBy(int index,  String FileName)
    {
        try
        {
            String path = "D:\\IBK\\GAC AUTOMATION\\Data\\".concat(FileName);
            FileInputStream file = new FileInputStream(new File(path));
            Workbook workbook = new XSSFWorkbook(file);

            return workbook.getSheetAt(index);

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
