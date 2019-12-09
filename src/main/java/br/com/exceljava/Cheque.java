package br.com.exceljava;


import java.math.BigDecimal;

import javax.sound.sampled.DataLine.Info;

import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class Cheque {


		private String cnpj;
		private BigDecimal valorTotal;
		private Integer totalFaturado;
		
	
		
		}
		
		
	
 

