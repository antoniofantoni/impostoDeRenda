/*
		 * Regras:
		 
		 * 1) Salário mensal: abaixo de 3000, livre de imposto; 3000 ate 5000 exclusive,
		 * imposto de 10%; 5000 pra cima, imposto de 20%;
		  
		 * 2) teve renda com prestação de serviços, imposto de 15%;
		 
		 * 3) teve ganha capital(Imóveis, ações), imposto de 20%;
		 
		 * 4) A pessoa pode abater até 30% do seu imposto bruto devido gastos com
		  médicos e educação, mas se seus gastos médicos e educacionais forem abaixo
		  desses 30%, apenas os gastos médicos e educacionais podem ser abatidos
		  
 */


package b_Estrutura_Condicional;

import java.util.Locale;
import java.util.Scanner;

public class imposto_de_renda {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		

		// variaveis
		double impostoSalMensal = 0;
		double impostoPrestServ = 0;
		double impostoGanhoCapital = 0;
		double impostoEducEMedicos = 0;
		double rendaAnual = 0;
		double rendaMensal = 0;
		double abatimento = 0;

		// entradas

		System.out.print("Renda anual com salário: ");
		rendaAnual = sc.nextDouble();
		rendaMensal = rendaAnual / 12;

		System.out.print("Renda anual com prestação de serviços: ");
		double rendaAnualComPrestacaoDeServicos = sc.nextDouble();

		System.out.print("Renda anual com ganho de capital: ");
		double rendaAnualComGanhoCapital = sc.nextDouble();

		System.out.print("Gastos com médicos: ");
		double gastosComMedicos = sc.nextDouble();

		System.out.print("Gastos educacionais: ");
		double gastosEducacionais = sc.nextDouble();

		// condicional para calcular imposto sobre Salário
		if (rendaMensal < 3000) {
			impostoSalMensal = 0;
		} else if (rendaMensal >= 3000 && rendaMensal < 5000) {
			impostoSalMensal = rendaMensal * 0.1;
		} else {
			impostoSalMensal = rendaMensal * 0.2;
		}
		double impostoSobreSal = impostoSalMensal * 12;// imposto sobre salário

		// condicional para calcular imposto sobre prestação de serviços

		if (rendaAnualComPrestacaoDeServicos > 0) {
			impostoPrestServ = rendaAnualComPrestacaoDeServicos * 0.15;
		}

		// condicional para calcular imposto sobre ganho de capital
		if (rendaAnualComGanhoCapital > 0) {
			impostoGanhoCapital = rendaAnualComGanhoCapital * 0.2;
		}

		// condicional para abatimentos
		double impostoBruto = (impostoSalMensal * 12 + impostoPrestServ + impostoGanhoCapital);
		double maximoDedutivel =(impostoBruto * 0.3);
		double gastosDedutiveis = (gastosComMedicos + gastosEducacionais);
		if (gastosDedutiveis >= impostoBruto * 0.3) {
			abatimento = impostoBruto * 0.3;
		} else {
			abatimento = gastosDedutiveis;
		}
		
		// RESULTADOS - OUTPUTS

		System.out.println("");
		
		System.out.println("RELATÓRIO DE IMPOSTO DE RENDA");
		System.out.println("");
		
		System.out.println("CONSOLIDADO DE RENDA:");
		System.out.printf("Imposto sobre salário: %.2f%n", impostoSobreSal);
		System.out.printf("Imposto sobre serviços: %.2f%n", impostoPrestServ);
		System.out.printf("Imposto sobre ganho de capital: %.2f%n", impostoGanhoCapital);
		
		System.out.println("");
		
		System.out.println("DEDUÇOES:");
		System.out.printf("Máximo dedutível: %.2f%n", maximoDedutivel);
		System.out.printf("Gastos dedutíveis: %.2f%n", gastosDedutiveis);
		
		System.out.println("");
		
		System.out.println("RESUMO:");
		System.out.printf("Imposto bruto total: %.2f%n", impostoBruto);
		System.out.printf("Abatimento: %.2f%n", abatimento);
		System.out.printf("Imposto devido: %.2f%n", impostoBruto-abatimento);

		sc.close();
	}
}
