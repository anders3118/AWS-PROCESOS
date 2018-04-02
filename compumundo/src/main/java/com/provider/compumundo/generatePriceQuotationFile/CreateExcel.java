/**
 * 
 */
package com.provider.compumundo.generatePriceQuotationFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.provider.compumundo.model.PriceQuote;
import com.provider.compumundo.model.PriceQuoteItem;

/**
 * @author Macaipe
 *
 */
public class CreateExcel {
	
	private static final String FILE_NAME = "src/main/resources/CotizacionCompuMundo.xlsx";
	public static String clientEmail;
	
	public void generatePriceQuote(PriceQuote priceQuote) {
		
		double totalWithoutDiscount = 0;
		int discount = 8;
		double discountD = 0.08;
		double totalWithDiscount = 0;

		 try {
			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			XSSFWorkbook  workbook = new XSSFWorkbook(excelFile);
			XSSFSheet datatypeSheet = workbook.getSheet("COTIZACION");
			XSSFCellStyle style = workbook.createCellStyle();
			XSSFCellStyle style2 = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			style2.setBorderBottom(CellStyle.BORDER_THIN);
			XSSFRow existingRow = null;
			XSSFCell cell = null;
			
			existingRow = datatypeSheet.getRow(2);
			cell = existingRow.createCell(6);
			cell.setCellValue(priceQuote.getPriceQuouteId());
			cell.setCellStyle(style);

			existingRow = datatypeSheet.getRow(3);
			cell = existingRow.createCell(6);
			cell.setCellValue(priceQuote.getPriceQuoteDate());
			cell.setCellStyle(style);

			existingRow = datatypeSheet.getRow(7);
			cell = existingRow.createCell(1);
			cell.setCellValue(priceQuote.getCompanyAddress());
			cell = existingRow.createCell(6);
			cell.setCellValue(priceQuote.getClientName());
			cell.setCellStyle(style);
			
			existingRow = datatypeSheet.getRow(8);
			cell = existingRow.createCell(1);
			cell.setCellValue(priceQuote.getCompanyCity());
			cell.setCellStyle(style);
			cell = existingRow.createCell(6);
			cell.setCellValue(priceQuote.getClientEmail());
			cell.setCellStyle(style);
			clientEmail = priceQuote.getClientEmail();
			
			existingRow = datatypeSheet.getRow(9);
			cell = existingRow.createCell(1);
			cell.setCellValue(priceQuote.getCompanyMobile());
			cell.setCellStyle(style);
			
			existingRow = datatypeSheet.getRow(10);
			cell = existingRow.createCell(1);
			cell.setCellValue(priceQuote.getCompanyEmail());			
			cell.setCellStyle(style);
			
			existingRow = datatypeSheet.getRow(13);
			cell = existingRow.getCell(0);
			cell.setCellValue(priceQuote.getAsesorName());			
			cell = existingRow.getCell(5);
			cell.setCellValue(priceQuote.getPriceQuotePaymentMethod().toUpperCase());
			cell = existingRow.getCell(7);
			cell.setCellValue(priceQuote.getPriceQuoteValidDate());
			
			int i =16;
				for(PriceQuoteItem priceQuoteIterator : priceQuote.getPriceQuoteItem()) {

					existingRow = datatypeSheet.getRow(i);
					cell = existingRow.getCell(0);
					cell.setCellValue(priceQuoteIterator.getItemQuantity());
					cell = existingRow.getCell(2);
					cell.setCellValue(priceQuoteIterator.getItemDescription());
					cell = existingRow.getCell(5);
					cell.setCellValue(priceQuoteIterator.getItemUnityPrice());
					cell = existingRow.getCell(7);
					cell.setCellValue(priceQuoteIterator.getItemTotal());
					totalWithoutDiscount += priceQuoteIterator.getItemTotal();
					i++;
				}
				
				for(int j=i; i<31;i++) {
					existingRow = datatypeSheet.getRow(j);
					cell = existingRow.getCell(0);
					cell.setCellValue("");
					cell = existingRow.getCell(2);
					cell.setCellValue("");
					cell = existingRow.getCell(5);
					cell.setCellValue("");
					cell = existingRow.getCell(7);
					cell.setCellValue("");
				}

			existingRow = datatypeSheet.getRow(35);
			cell = existingRow.getCell(3);
			cell.setCellValue(priceQuote.getAsesorName());
			cell.setCellStyle(style2);
			
			existingRow = datatypeSheet.getRow(31);
			cell = existingRow.getCell(7);
			cell.setCellValue(totalWithoutDiscount);
			
			existingRow = datatypeSheet.getRow(32);
			cell = existingRow.getCell(7);
			cell.setCellValue(discount);
			
			existingRow = datatypeSheet.getRow(33);
			cell = existingRow.getCell(7);
			totalWithDiscount = totalWithoutDiscount - totalWithoutDiscount*discountD;
			cell.setCellValue(totalWithDiscount);	
						
			excelFile.close();
			FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
			workbook.write(outputStream);
			outputStream.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
