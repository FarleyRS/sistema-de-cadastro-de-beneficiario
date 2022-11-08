package programa_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import java.util.Arrays;

public class Principal_2 {
	
	static Beneficiario2[] bnc = new Beneficiario2[100];
	static int cont=0;//
	static Scanner ler = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//recebe os dados do arquivo.txt
		recebe();
		
		//Menu de interação
		int opcao = 1;
		/*while (opcao != 0) {
			opcao = menu();
			switch (opcao) {
			case 1:
				addBnc();
				break;
			case 2:
				remover();
				break;
			case 0:
				idadesAcima();
				maiorMenorIdade();
				relatorio();
				imprime();
				return;
			}
		}*/
		addBnc();
	
	}
	
	static int menu() {
		System.out.print(
				"Menu:\n" + "1: Adicionar Beneficiário\n"
						  + "2: Remover Beneficiário\n"
						  + "0: Encerrar\n"
						  + "=>");
		String resp = ler.next();
		return Integer.parseInt(resp);
	}
	public static void remover() {
		int i,j;
	System.out.println("========================== ");
		for(i=0;i<cont;i++) {
			if(bnc[i]!=null) {
				System.out.print(bnc[i].getNomeBnc()+","+bnc[i].getIdadeBnc()+","+bnc[i].getQuantDp()+","+bnc[i].getValorPlan());
				for(j=0;j<bnc[i].getQuantDp();j++) {
					System.out.print(","+bnc[i].getNomeDp()[j]+","+bnc[i].getIdadeDp()[j]);
				}
				
				System.out.println();
			}
			
		}
		System.out.println();
		String nome;
		System.out.println("'xxx' para cancelar.");
		System.out.print("Insira o nome do beneficiário: ");
		nome = ler.next();
		
		String r ="XXX";
		String t ="xxx";
		if(nome.equals(r) || nome.equals(t)) {
			return;
		}
		
		for(i=0;i<cont;i++) {
			if(bnc[i]!=null) {
				if(nome.equals(bnc[i].getNomeBnc().toLowerCase())||nome.equals(bnc[i].getNomeBnc())) {
					bnc[i] = null;
				}
			}
		}
		System.out.println("========================== ");
		for(i=0;i<cont;i++) {
			if(bnc[i]!=null) {
				System.out.print(bnc[i].getNomeBnc()+","+bnc[i].getIdadeBnc()+","+bnc[i].getQuantDp()+","+bnc[i].getValorPlan());
				for(j=0;j<bnc[i].getQuantDp();j++) {
					System.out.print(","+bnc[i].getNomeDp()[j]+","+bnc[i].getIdadeDp()[j]);
				}
				
				System.out.println();
			}
			
		}
	}
	public static void recebe() {
		File arq = new File("arquivo1.txt");
		if(arq.exists()) {
			try {
				Scanner in = new Scanner(arq);
		
				
				while (in.hasNext()) {
					//le a linha de dados
					String l = in.nextLine();
					//separa os dados do beneficiario
					String[] p = l.split(",");
					
					String k = p[0];
					int d = Integer.parseInt(p[1]);
					int qD = Integer.parseInt(p[2]);
					double s = Double.parseDouble(p[3]);
					
					//recebendo dados dos dependentes
					int b=0;
					String[] nDp = new String[qD];
					int[] iDp =new int[qD];
					
					while(b!=qD) {//enquanto b for diferente da quantidade de dependentes
						nDp[b]= p[(4+(b+b))];
						iDp[b] = Integer.parseInt(p[(5+(b+b))]);
						b++;
					}
					
					//Adicionando na class Beneficiario_2
					bnc[cont] = new Beneficiario2(k,d,qD,s,nDp,iDp);
					cont++;
					 
			 }	 
		}	//caso o arquivo na seja encontrado
			catch (FileNotFoundException e) {
				System.out.println("Arqruivo não encontrado.");
			}
		}
		else
			System.out.println("Arqruivo não encontrado.");
	}
	public static void imprime() throws IOException {
		//Atualiza os planos de saúde mesmo que não tenha alteração 
		atualisarPlan();
		PrintWriter out = new PrintWriter(new FileWriter("arquivo1.txt"));
		int i,j;
		for(i=0;i<cont;i++) {
			if(bnc[i]!=null) {
				out.print(bnc[i].getNomeBnc()+","+bnc[i].getIdadeBnc()+","+bnc[i].getQuantDp()+","+bnc[i].getValorPlan());
				for(j=0;j<bnc[i].getQuantDp();j++) {
					out.print(","+bnc[i].getNomeDp()[j]+","+bnc[i].getIdadeDp()[j]);
				}
				
				out.println();
			}
		}
		out.close();
		java.awt.Desktop.getDesktop().open( new File( "arquivo1.txt" ) );
	}
	public static void addBnc() throws IOException {
		
		//verifica se o vetor conte espaço
		for(int i = 0; i < bnc.length; i++){
			  if(bnc[i] == null){//se tiver continua
				  int p=0;
					while(p==0) {
						
						
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
						bnc[cont] = new Beneficiario2(k,d,qD,s,nDp,iDp);
						cont++;
						
					}
			  }
		}
		
	}
	public static void maiorMenorIdade() {
		System.out.println("=====Maior e menor medias de idades=====\n");
		int i,j;
		float[] med = new float[cont];
		float[] med2 = new float[cont];
		float[] resp = new float[cont];
		for(i=0;i<cont;i++) {
			for(j=0;j<bnc[i].getQuantDp();j++) {
				med[i]+=bnc[i].getIdadeDp()[j];
				med2[i]+=bnc[i].getIdadeDp()[j];
			}
			med[i]+=bnc[i].getIdadeBnc();
			
		}
		
		for(i=0;i<cont;i++) {
			if(bnc[i]!=null) {
				resp[i] = med[i]/(bnc[i].getQuantDp()+1);// o 1 representa o beneficiario
			}
		}
		
		
		float max=0;
		
		for(i=0;i<cont;i++) {
			if(max<resp[i]) {
				max=resp[i];
			}
		}
		
		float min=max;
		
		for(i=0;i<cont;i++) {
			if(min>resp[i]) {
				min=resp[i];
			}
		}
		for(i=0;i<cont;i++) {
			if(max*(bnc[i].getQuantDp()+1)-med2[i]==bnc[i].getIdadeBnc()) {
				System.out.println("O plano do "+bnc[i].getNomeBnc()+" obteve a maior média: "+max);
			}
		}
		for(i=0;i<cont;i++) {
			if(min*(bnc[i].getQuantDp()+1)-med2[i]==bnc[i].getIdadeBnc()) {
				System.out.println("O plano do "+bnc[i].getNomeBnc()+" obteve a menor média: "+min);
			}
		}		
		System.out.println();
		
	}
	public static void atualisarPlan() {
		System.out.println("=====Acréscimo de 5% nos Planos de Saúde =====\n");
		int i;
		double acres = 0;
		for(i=0;i<cont;i++) {
			if(bnc[i]!=null) {
				acres = ((bnc[i].getValorPlan()*5)/100);
				bnc[i].valorPlan += acres;
				System.out.println("Foram acrescentados: "+acres+" de juros.");
			}
		}  
	}
	public static void idadesAcima() {
		System.out.println("=====Idades acima de 40 anos=====\n");
		int i,j;
		for(i=0;i<cont;i++) {
			if(bnc[i]!=null) {
				if(bnc[i].getIdadeBnc()>40) {
					System.out.println("Beneficiario: "+bnc[i].getNomeBnc()+" Idade:"+bnc[i].getIdadeBnc());
					for(j=0;j<bnc[i].getQuantDp();j++) {
						if(bnc[i].getIdadeDp()[j]>40) {
							System.out.println("Dependente: "+bnc[i].getNomeDp()[j]+" Idade:"+bnc[i].getIdadeDp()[j]);
						}
					}
				}
			}
			
			System.out.println();
		}
	}
	public static void relatorio() throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter("arquivo2.txt"));
		out.print("Nome dos Beneficiários em ordem crescente");
		out.println();
		int i;
		String[] nome = new String[cont];
		for(i=0;i<cont;i++) {
			if(bnc[i]!=null) {
				nome[i] = bnc[i].getNomeBnc();
			}
		}
		
		Arrays.sort(nome);
		for(i=0;i<cont;i++) {
			for(int j=0;j<cont;j++) {
				if(nome[i].equals(bnc[j].getNomeBnc())) {
					out.printf(bnc[j].getNomeBnc()+","+bnc[j].getIdadeBnc()+","+bnc[j].getQuantDp()+",%.2f",bnc[j].getValorPlan());
					for(int g=0;g<bnc[j].getQuantDp();g++) {
						out.print(","+bnc[j].getNomeDp()[g]+","+bnc[j].getIdadeDp()[g]);
					}
					out.println();
				}
			}
			
		}
		out.println();
		out.close();
		java.awt.Desktop.getDesktop().open( new File( "arquivo2.txt" ) );
		
	}
	
}