package com.example.demo.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.Product;

public class ExcelHelper {

	// check file excel or not
	public static boolean checkExcelFormat(MultipartFile file) {
		boolean isExcel = false;
		String contentType = file.getContentType();
		// content type for xls file
		if (contentType.equals("application/vdn.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		} else {
			return isExcel;
		}
	}

	// converts Excel to list of products
	public static List<Product> convertExcelToList(InputStream is) {
		List<Product> prodList = new ArrayList<>();
		try {
			XSSFWorkbook work = new XSSFWorkbook(is); // get this class from pom.xml org.pom.poi dependency
			XSSFSheet sheet = work.getSheet("data"); // data is name of sheet present in workbook

			int rowNum = 0;
			Iterator<Row> iterator = sheet.iterator();
			while (iterator.hasNext()) {
				Row row = iterator.next();

				if (rowNum == 0) {
					rowNum++; // means at header part of excel (row 1)
					continue;
				}
				Iterator<Cell> cells = row.iterator();
				int cid = 0;
				Product p = new Product();

				while (cells.hasNext()) {
					Cell cell = cells.next(); // go inside every cell of a row
					switch (cid) {
					case 0: // row cell 1
						p.setProductId((int) cell.getNumericCellValue());
						break;
					case 1:
						p.setProductName(cell.getStringCellValue());
						break;
					case 2:
						p.setProductDesc(cell.getStringCellValue());
						break;

					case 3:
						p.setPrice(cell.getNumericCellValue());
						
					default:
						break;
					}
					cid++;
				}
			prodList.add(p);
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return prodList;
	}

}
