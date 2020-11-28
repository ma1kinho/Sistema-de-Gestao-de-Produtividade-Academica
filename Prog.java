package applicaion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Collaborator;
import entities.DoctoralStudent;
import entities.GraduationStudent;
import entities.MasterStudent;
import entities.Researcher;
import entities.Teacher;

public class Prog {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		int escolha;
		
		do {
			System.out.println("O que voce pretende fazer?");
			System.out.println("[0] - Fechar o programa");
			System.out.println("[1] - Criar um projeto");
			//System.out.println("");
			
			escolha = sc.nextInt();
			
			switch(escolha) {
				case 1:
					System.out.print("Digite o titulo do projeto: ");
					sc.nextLine();
					String title = sc.nextLine();
					System.out.print("Data de inicio (DD/MM/YYYY): ");
					Date startDate = sdf.parse(sc.next());
					System.out.print("Data de termino (DD/MM/YYYY): ");
					Date endDate = sdf.parse(sc.next());
					sc.nextLine();
					System.out.print("Agencia financiadora: ");
					String financeAgency = sc.nextLine();
					System.out.print("Valor financiado: ");
					double financedAmount = sc.nextDouble();
					System.out.print("Objetivo do projeto: ");
					sc.nextLine();
					String objective = sc.nextLine();
					System.out.print("Descricao do projeto: ");
					String description = sc.nextLine();
					System.out.print("Quantos participantes o projeto tera inicialmente? ");
					int qntParticipants = sc.nextInt();
					sc.nextLine();
					List<Collaborator> participants = new ArrayList<>();
					
					for(int i=0; i<qntParticipants; i++) {
						System.out.println();
						System.out.println("Dados do participante numero #" + (i+1) + ":");
						System.out.print("Nome: ");
						String name = sc.nextLine();
						System.out.print("Email: ");
						String email = sc.nextLine();
						System.out.println("Cargo:");
						System.out.print("1 - aluno de graduação\n2 - aluno de mestrado\n"
										+ "3 - aluno de doutorado\n4 - professor\n5 - pesquisador\n=>");
						int  numCargo = sc.nextInt();
						sc.nextLine();
						Collaborator participant;
						
						if(numCargo == 1) {
							participant = new GraduationStudent(name, email, "aluno de graduação");
						} else if(numCargo == 2) {
							participant = new MasterStudent(name, email, "aluno de mestrado");
						} else if(numCargo == 3) {
							participant = new DoctoralStudent(name, email, "aluno de doutorado");
						} else if(numCargo == 4) {
							participant = new Teacher(name, email, "professor");
						} else {
							participant = new Researcher(name, email, "pesquisador");
						}
						
						participants.add(participant);
					}
					
					//Project project = new Project();
				break;
				
				default:
			}
			
		} while(escolha != 0);
			
		
		
		sc.close();
	}

}
