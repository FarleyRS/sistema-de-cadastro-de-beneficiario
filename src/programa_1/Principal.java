package programa_1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Principal {
	
	static Beneficiario[] bnc = new Beneficiario[100];
	static int cont=0;//
	static Scanner ler = new Scanner(System.in);

	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		addBnc();
		imprime();

	}
	public static void addBnc() throws IOException {
		
			int p=0;
			while(p==0) {
				if(cont!=bnc.length) {
					System.out.print("Insira nome beneficiairio? ");
					String k = ler.next();
				
					//verifica se o usuario que continuar
					String r ="XXX";
					String t ="xxx";
					if(k.equals(r) || k.equals(t)) {
						break;
					}
			
					System.out.println("Insira a idade?");
					int d = ler.nextInt();
					
					System.out.println("Insira a quantidade de dependentes: ");
					int qD = ler.nextInt();
					
					//Valor do plano de Saúde
					System.out.println("Insira o Valor do plano: ");
					double s = ler.nextDouble();
					
					//inserindo dados dos dependentes
					int b=0;
					String[] nDp = new String[qD];
					int[] iDp =new int[qD];
					
					while(b!=qD) {//Enquanto b for diferente da quantidade de dependentes
						
						System.out.println("Nome dependente "+(b+1)+": ");
						nDp[b]= ler.next();
						System.out.println("Idade: ");
						iDp[b] = ler.nextInt();
						b++;
		
					}
					
					//adiciona na class Beneficiario
					bnc[cont] = new Beneficiario(k,d,qD,s,nDp,iDp);
					cont++;
				}
				else {
					System.out.println("==================================");
					System.out.println("Não existe mais espaço na memoria.");
					break;
				}
					
			}
		
	}
	public static void imprime() throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter("arquivo1.txt"));
		int i,j;
		for(i=0;i<cont;i++) {
			out.print(bnc[i].getNomeBnc()+","+bnc[i].getIdadeBnc()+","+bnc[i].getQuantDp()+","+bnc[i].getValorPlan());
			for(j=0;j<bnc[i].getQuantDp();j++) {
				out.print(","+bnc[i].getNomeDp()[j]+","+bnc[i].getIdadeDp()[j]);
			}
			
			out.println();
		}
		out.close();
		java.awt.Desktop.getDesktop().open( new File( "arquivo1.txt" ) );
	}
}

