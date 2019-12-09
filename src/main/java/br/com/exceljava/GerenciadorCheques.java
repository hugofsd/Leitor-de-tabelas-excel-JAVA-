package br.com.exceljava;
import java.util.List;

import lombok.Cleanup;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
// aaaaa

public class GerenciadorCheques {
	
	private Workbook workbook;

	public List<Cheque> criar() throws IOException {
		
		List<Cheque> cheques = new ArrayList<>(); 
		
		//Recuperando o arquivo
	@Cleanup FileInputStream file = new FileInputStream("olhovivo.xls");

		workbook = new HSSFWorkbook (file);
		//setando a aba
		Sheet sheet = workbook.getSheetAt(0);
	// setando as linhas
		List<Row> rows = (List<Row>) toList(sheet.iterator());
		
		//remove os cabecalho
		rows.remove(0);
		
		rows.forEach(row ->{
			//Seteando as celulas
			List<Cell> cells = (List<Cell>) toList(row.cellIterator());
			
			Cheque cheque = Cheque.builder()
					
					//Atribuiu os valores para classe chaque
					.cnpj(cells.get(3).getStringCellValue())
					.valorTotal(new BigDecimal(cells.get(10).getNumericCellValue()).setScale(2,BigDecimal.ROUND_HALF_EVEN))
					.totalFaturado(new Integer((int) cells.get(11).getNumericCellValue()))
					
					
					
					
					.build();
			cheques.add(cheque);
			
			
			 
		});
	
		
		return cheques;
	}
	
	public List<?> toList(Iterator<?> iterator){
		return IteratorUtils.toList(iterator);
		
	}
	
	public void imprimir(List<Cheque> cheques) {
		cheques.forEach(System.out::println);
	}

}
