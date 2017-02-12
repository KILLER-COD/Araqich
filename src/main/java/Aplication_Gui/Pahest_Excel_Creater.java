package Aplication_Gui;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * Created by CODE on 12.02.2017.
 */
public class Pahest_Excel_Creater {
    public Pahest_Excel_Creater(Shop_date data, ArrayList<Zakaz_data> pahest) {
        try {
            Workbook workbook = new HSSFWorkbook();
            Sheet sheet = workbook.createSheet("Pahest_Sheet");
            CellStyle my_style = workbook.createCellStyle();

            my_style.setBorderTop(BorderStyle.THIN);
            my_style.setBorderLeft(BorderStyle.THIN);
            my_style.setBorderRight(BorderStyle.THIN);
            my_style.setBorderBottom(BorderStyle.THIN);

            for (int i = 0; i < pahest.size(); i++) {
                CellStyle rowheadin = workbook.createCellStyle();
                Font region1 = workbook.createFont();
                region1.setBold(true);
                region1.setFontName("Arial");
                region1.setFontHeightInPoints((short) 11);
                rowheadin.setFont(region1);
            }

            String[] collNames = {"հ/հ","Ապրանքի անուն","Քանակ","Հատ/կգ","Գին","Ընդամենը" };

            int qanak = 2;
            Row row = sheet.createRow(qanak);
            for (int i = 0; i < 6 ; i++) {
                row.createCell(i).setCellValue(collNames[i]);
                row.getCell(i).setCellStyle(my_style);
            }

            int summ = 0;
            qanak = 3;
            for (int j = 0; j < pahest.size(); j++) {
                Row row1 = sheet.createRow(qanak);
                String[] strings = Excel_add_date(pahest,j);
                for (int i = 0; i < 6 ; i++) {
                    row1.createCell(i).setCellValue(String.valueOf(strings[i]));
                    row1.getCell(i).setCellStyle(my_style);
                }
                qanak++;
                summ += Integer.parseInt(strings[2]) * Integer.parseInt( strings[4]);

            }

            Row sheetRow = sheet.createRow(qanak);

            CellRangeAddress sheetRow1 = CellRangeAddress.valueOf("A" + (qanak + 1) + ":C" + (qanak + 1));

            sheet.addMergedRegion(sheetRow1);

            /*----------------------------*/
            Cell cell1 = sheetRow.createCell(0);
            for (int i = 0; i < 5; i++) {
                sheetRow.createCell(i).setCellStyle(my_style);
            }
            cell1.setCellValue("All Price");
            cell1.setCellStyle(my_style);


            Cell cell2 = sheetRow.createCell(5);
            cell2.setCellValue(summ);
            cell2.setCellStyle(my_style);


            for (int i = 0; i < 6; i++) {
                sheet.autoSizeColumn(i);
            }
            String Filename = data.getDay()+"_"+data.getMonth()+"_"+data.getYear();
            FileOutputStream br = new FileOutputStream(new File(System.getProperty("user.home") + "\\Desktop\\" + Filename  + "_new.xls"));
            workbook.write(br);
            System.out.println("Excel written Succesfully..");



        } catch (Exception e) {
            System.out.println("Sxal");
        }
    }

    public String[] Excel_add_date(ArrayList<Zakaz_data> zakaz,int num){
        String[]  strings = new String[7];
        strings[0] = zakaz.get(num).getId();
        strings[1] = zakaz.get(num).getGoods_name();
        strings[2] =zakaz.get(num).getCounts();
        strings[3] =zakaz.get(num).getSort();
        strings[4] =zakaz.get(num).getPrice();
        strings[5] = String.valueOf((Integer.parseInt(zakaz.get(num).getPrice()) * Integer.parseInt( zakaz.get(num).getCounts())));
        return strings;
    }
}
