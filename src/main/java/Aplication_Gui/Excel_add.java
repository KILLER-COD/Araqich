package Aplication_Gui;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.*;
import java.util.ArrayList;

public class Excel_add {
    private static ArrayList<Zakaz_data> zakaz = Zakaz_data_read.getZakaz_data();

    public Excel_add() {
    }

    public void esim(Shop_date shop_date) {
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

            String Filename = "src/" + shop_date.getName() + "_text_test.txt";

            try {
                BufferedReader br = new BufferedReader(new FileReader(Filename));
                String str;

                while ((str = br.readLine()) != null) {
                    Zakaz_data_read.getZakaz_data().add(Zakaz_data_read.Zakaz_data_Parser(str.split(",")));
                }
            } catch (Exception e1) {
                System.out.println(e1);
            }


            Row row1 = sheet.createRow(0);
            row1.createCell(0).setCellValue("ամիս, ամսաթիվ");
            row1.createCell(1).setCellValue("    ");
            row1.createCell(2).setCellValue("    ");

            CellRangeAddress range1 = CellRangeAddress.valueOf("D1:E1");
            sheet.addMergedRegion(range1);

            row1.createCell(3).setCellValue(shop_date.getName());
            row1.createCell(5).setCellValue("     ");

            Row row2 = sheet.createRow(1);
                 row2.createCell(0).setCellValue(shop_date.getDay() + "/" + shop_date.getMonth() + "/" + shop_date.getYear());
                 row2.createCell(6).setCellValue(shop_date.getDay() + "/" + shop_date.getMonth() + "/" + shop_date.getYear());

            Row row3 = sheet.createRow(2);
            row3.createCell(0).setCellValue("Անվանում");
            row3.createCell(1).setCellValue("Քան.");
            row3.createCell(2).setCellValue("Հատ / կգ");
            row3.createCell(3).setCellValue("Գին");
            row3.createCell(4).setCellValue("Գումար");

            row3.createCell(6).setCellValue("Անվանում");
            row3.createCell(7).setCellValue("Քան.");
            row3.createCell(8).setCellValue("Հատ / կգ");
            row3.createCell(9).setCellValue("Գին");
            row3.createCell(10).setCellValue("Գումար");

            row1.createCell(6).setCellValue("ամիս, ամսաթիվ");
            row1.createCell(7).setCellValue("    ");
            row1.createCell(8).setCellValue("    ");
            CellRangeAddress region2 = CellRangeAddress.valueOf("J1:K1");
            sheet.addMergedRegion(region2);
            row1.createCell(9).setCellValue(shop_date.getName());

            int summ = 0;
            int r = 3;

            Cell cell1;
            Cell cell2;
            Cell cell3;
            Cell CellAllSum1;
            for (int row = 0; row < zakaz.size(); row++) {
                Row row4 = sheet.createRow(r);

                    Cell cell = row4.createCell(0);
                    cell.setCellValue(String.valueOf(((Zakaz_data) zakaz.get(row)).getGoods_name()));
                    cell.setCellStyle(my_style);

                cell1 = row4.createCell(1);
                cell1.setCellValue( Integer.parseInt(((Zakaz_data) zakaz.get(row)).getCounts()));
                cell1.setCellStyle(my_style);

                    cell2 = row4.createCell(2);
                    cell2.setCellValue(((Zakaz_data) zakaz.get(row)).getSort());
                    cell2.setCellStyle(my_style);

                cell3 = row4.createCell(3);
                cell3.setCellValue( Integer.parseInt(((Zakaz_data) zakaz.get(row)).getPrice()));
                cell3.setCellStyle(my_style);

                    CellAllSum1 = row4.createCell(4);
                    CellAllSum1.setCellValue( (Integer.parseInt(((Zakaz_data) zakaz.get(row)).getPrice()) * Integer.parseInt(((Zakaz_data) zakaz.get(row)).getCounts())));
                    CellAllSum1.setCellStyle(my_style);

                Cell cell4 = row4.createCell(6);
                cell4.setCellValue(String.valueOf(((Zakaz_data) zakaz.get(row)).getGoods_name()));
                cell4.setCellStyle(my_style);

                    Cell cell5 = row4.createCell(7);
                    cell5.setCellValue( Integer.parseInt(((Zakaz_data) zakaz.get(row)).getCounts()));
                    cell5.setCellStyle(my_style);

                Cell cell6 = row4.createCell(8);
                cell6.setCellValue(((Zakaz_data) zakaz.get(row)).getSort());
                cell6.setCellStyle(my_style);

                    Cell cell7 = row4.createCell(9);
                    cell7.setCellValue( Integer.parseInt(((Zakaz_data) zakaz.get(row)).getPrice()));
                    cell7.setCellStyle(my_style);

                Cell CellAllSum2 = row4.createCell(10);
                CellAllSum2.setCellValue( (Integer.parseInt(((Zakaz_data) zakaz.get(row)).getPrice()) * Integer.parseInt(((Zakaz_data) zakaz.get(row)).getCounts())));
                CellAllSum2.setCellStyle(my_style);

                summ += Integer.parseInt(((Zakaz_data) zakaz.get(row)).getPrice()) * Integer.parseInt(((Zakaz_data) zakaz.get(row)).getCounts());
                r++;
            }

            System.out.println(r);
            Row sheetRow = sheet.createRow(r);

            CellRangeAddress sheetRow1 = CellRangeAddress.valueOf("A" + (r + 1) + ":D" + (r + 1));
            CellRangeAddress sheetRow2 = CellRangeAddress.valueOf("G" + (r + 1) + ":J" + (r + 1));

            sheet.addMergedRegion(sheetRow1);
            sheet.addMergedRegion(sheetRow2);

            /*----------------------------*/
            cell1 = sheetRow.createCell(0);
            cell1.setCellValue("All Price");
            cell1.setCellStyle(my_style);

            cell2 = sheetRow.createCell(4);
            cell2.setCellValue(summ);
            cell2.setCellStyle(my_style);
            /*----------------------------*/

            /*----------------------------*/
            cell3 = sheetRow.createCell(6);
            cell3.setCellValue("All Price");
            cell3.setCellStyle(my_style);

            CellAllSum1 = sheetRow.createCell(10);
            CellAllSum1.setCellValue( summ);
            CellAllSum1.setCellStyle(my_style);
           /*----------------------------*/

            for (int i = 0; i < zakaz.size(); i++) {
                sheet.autoSizeColumn(i);
            }

            FileOutputStream br = new FileOutputStream(new File("src/" + shop_date.getName() + "_new.xls"));
            workbook.write(br);
            System.out.println("Excel written Succesfully..");
        } catch (IOException var35) {
            var35.printStackTrace();
        }

    }
}
