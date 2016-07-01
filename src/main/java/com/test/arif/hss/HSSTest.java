package com.test.arif.hss;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HSSTest {
    public static void main(String[] args) {
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet");
            HSSFRow rowhead = sheet.createRow((short) 0);
            rowhead.createCell(0).setCellValue("Event ID");
            rowhead.createCell(1).setCellValue("Event Name");
            rowhead.createCell(2).setCellValue("Event Time");
            rowhead.createCell(3).setCellValue("Event Venue");
            rowhead.createCell(4).setCellValue("Company Name");
            rowhead.createCell(5).setCellValue("Total Amount");
            rowhead.createCell(6).setCellValue("Received Amount");
            rowhead.createCell(7).setCellValue("Payment Date");
            rowhead.createCell(8).setCellValue("Cheque/DD No.");
            rowhead.createCell(9).setCellValue("Event TDS");
            rowhead.createCell(10).setCellValue("Balance Amount");


            FileOutputStream fileOut;
            fileOut = new FileOutputStream("/Users/arifacar/Desktop/Samplmgjkm.xls");

            ArrayList eventIdPdf = new ArrayList();
            eventIdPdf.add("1");
            eventIdPdf.add("2");
            eventIdPdf.add("3");

            ArrayList eventNamePdf = new ArrayList();
            eventNamePdf.add("A");
            eventNamePdf.add("B");
            eventNamePdf.add("C");

            Map<String, ArrayList> sessionMapGeneral = new HashMap();
            sessionMapGeneral.put("eventIdPdf", eventIdPdf);
            sessionMapGeneral.put("eventNamePdf", eventNamePdf);

            System.out.println(sessionMapGeneral.get("eventIdPdf").toString());
            System.out.println(sessionMapGeneral.get("eventNamePdf").toString());


            for (Map.Entry<String, ArrayList> entry : sessionMapGeneral.entrySet()) {
                System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
            }


//            int nextRow = 1;
//            while (entries.hasNext()) {
//                Map.Entry thisEntry = (Map.Entry) entries.next();
//
//                HSSFRow r = sheet.getRow(nextRow);
//                if (r == null) {
//                    r = sheet.createRow(nextRow);
//                }
//
//                HSSFCell c = r.getCell(1, Row.CREATE_NULL_AS_BLANK);
//                c.setCellValue(rs.getString(1));
//
//                HSSFCell c2 = r.getCell(2, Row.CREATE_NULL_AS_BLANK);
//                c2.setCellValue(rs.getString(2));
//
//                nextRow++;
//
//            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
