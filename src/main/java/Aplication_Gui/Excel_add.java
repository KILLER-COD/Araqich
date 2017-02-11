package Aplication_Gui;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.*;
import java.util.ArrayList;

public class Excel_add {
   // private static ArrayList<Zakaz_data> zakaz = Zakaz_data_read.getZakaz_data();

    public Excel_add() {
    }

    public void Excel_zakaz(Shop_date shop_date,ArrayList<Zakaz_data> zakaz) {
        try {
            Workbook workbook = new HSSFWorkbook();
            Sheet sheet = workbook.createSheet("Sample sheet");
            CellStyle my_style = workbook.createCellStyle();

            my_style.setBorderTop(BorderStyle.THIN);
            my_style.setBorderLeft(BorderStyle.THIN);
            my_style.setBorderRight(BorderStyle.THIN);
            my_style.setBorderBottom(BorderStyle.THIN);

            for (int i = 0; i < zakaz.size(); i++) {
                CellStyle rowheadin = workbook.createCellStyle();
                Font region1 = workbook.createFont();
                region1.setBold(true);
                region1.setFontName("Arial");
                region1.setFontHeightInPoints((short) 11);
                rowheadin.setFont(region1);
            }

            Row row1 = sheet.createRow(0);
            String[] collNames = {"ամիս, ամսաթիվ","     ","     "};

            for (int i = 0, j = 6; i < 3 && j < 9; i++, j++) {
                row1.createCell(i).setCellValue(collNames[i]);
                row1.getCell(i).setCellStyle(my_style);
                row1.createCell(j).setCellValue(collNames[i]);
                row1.getCell(j).setCellStyle(my_style);
            }

            CellRangeAddress range1 = CellRangeAddress.valueOf("D1:E1");
            sheet.addMergedRegion(range1);

            row1.createCell(3).setCellValue(shop_date.getName());
            row1.getCell(3).setCellStyle(my_style);
            row1.createCell(4).setCellStyle(my_style);
            row1.createCell(5).setCellValue("     ");

            Row row2 = sheet.createRow(1);
            row2.createCell(0).setCellValue(shop_date.getDay() + "/" + shop_date.getMonth() + "/" + shop_date.getYear());
            row2.createCell(6).setCellValue(shop_date.getDay() + "/" + shop_date.getMonth() + "/" + shop_date.getYear());
            row2.getCell(0).setCellStyle(my_style);
            row2.getCell(6).setCellStyle(my_style);


            Row row3 = sheet.createRow(2);
            String[] collNames2 = {"Անվանում", "Քան.", "Հատ / կգ", "Գին", "Գումար", "",};


            for (int i = 0, j = 6; i < 5 && j < 11; i++, j++) {
                row3.createCell(i).setCellValue(collNames2[i]);
                row3.createCell(j).setCellValue(collNames2[i]);
                row3.getCell(i).setCellStyle(my_style);
                row3.getCell(j).setCellStyle(my_style);
            }
            CellRangeAddress region2 = CellRangeAddress.valueOf("J1:K1");
            sheet.addMergedRegion(region2);
            row1.createCell(9).setCellValue(shop_date.getName());
            row1.getCell(9).setCellStyle(my_style);
            row1.createCell(10).setCellStyle(my_style);

            int summ = 0;
            int r = 3;

            for (int row = 0; row < zakaz.size(); row++) {
                Row row4 = sheet.createRow(r);
                String[] strings = Excel_add_date(zakaz,row);
                for (int i = 0, j = 6; i < 5 && j < 11; i++, j++) {
                    row4.createCell(i).setCellValue(String.valueOf(strings[i]));
                    row4.getCell(i).setCellStyle(my_style);
                    row4.createCell(j).setCellValue(String.valueOf(strings[i]));
                    row4.getCell(j).setCellStyle(my_style);
                }

                summ += Integer.parseInt(strings[1]) * Integer.parseInt( strings[3]);
                r++;
            }

            Row sheetRow = sheet.createRow(r);

            CellRangeAddress sheetRow1 = CellRangeAddress.valueOf("A" + (r + 1) + ":D" + (r + 1));
            CellRangeAddress sheetRow2 = CellRangeAddress.valueOf("G" + (r + 1) + ":J" + (r + 1));

            sheet.addMergedRegion(sheetRow1);
            sheet.addMergedRegion(sheetRow2);

            /*----------------------------*/
            Cell cell1 = sheetRow.createCell(0);
            for (int i = 0; i < 4; i++) {
                sheetRow.createCell(i).setCellStyle(my_style);
            }
            cell1.setCellValue("All Price");
            cell1.setCellStyle(my_style);


            Cell cell2 = sheetRow.createCell(4);
            cell2.setCellValue(summ);
            cell2.setCellStyle(my_style);
            /*----------------------------*/

            /*----------------------------*/
            Cell cell3 = sheetRow.createCell(6);
            for (int i = 6; i < 10; i++) {
                sheetRow.createCell(i).setCellStyle(my_style);
            }
            cell3.setCellValue("All Price");
            cell3.setCellStyle(my_style);


            Cell CellAllSum1 = sheetRow.createCell(10);
            CellAllSum1.setCellValue(summ);
            CellAllSum1.setCellStyle(my_style);
           /*----------------------------*/

            for (int i = 0; i < 11; i++) {
                sheet.autoSizeColumn(i);
            }

            FileOutputStream br = new FileOutputStream(new File(System.getProperty("user.home") + "\\Desktop\\" + shop_date.getName() + "_new.xls"));
            workbook.write(br);
            System.out.println("Excel written Succesfully..");
        } catch (IOException var35) {
            var35.printStackTrace();
        }

    }

    public String[] Excel_add_date(ArrayList<Zakaz_data> zakaz,int num){
            String[]  strings = new String[6];
            strings[0] = zakaz.get(num).getGoods_name();
            strings[1] =zakaz.get(num).getCounts();
            strings[2] =zakaz.get(num).getSort();
            strings[3] =zakaz.get(num).getPrice();
            strings[4] = String.valueOf((Integer.parseInt(zakaz.get(num).getPrice()) * Integer.parseInt( zakaz.get(num).getCounts())));
        return strings;
    }

}
