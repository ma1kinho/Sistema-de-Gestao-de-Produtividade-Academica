package applicaion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.AcademicProduction;
import entities.Collaborator;
import entities.DoctoralStudent;
import entities.GraduationStudent;
import entities.MasterStudent;
import entities.Project;
import entities.Publication;
import entities.Researcher;
import entities.Teacher;
import entities.enums.ProjectStatus;

public class Prog {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		List<Project> listProjects = new ArrayList<>();

		int option;

		do {
			System.out.println("O que voce pretende fazer?");
			System.out.println("[0] - Fechar o programa");
			System.out.println("[1] - Elaborar um projeto");
			System.out.println("[2] - Iniciar um projeto");
			System.out.println("[3] - Concluir um projeto");
			System.out.println("[4] - Criar uma publicacao");
			System.out.println("[5] - Criar uma observacao");
			System.out.print("=> ");

			option = sc.nextInt();
			sc.nextLine();

			switch (option) {
			case 1:
				System.out.print("Digite o titulo do projeto: ");
				//sc.nextLine();
				String titleProject = sc.nextLine();
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
				int qntTeachers = 0;

				Project project = new Project(titleProject, startDate, endDate, financeAgency, financedAmount,
						objective, description);

				for (int i = 0; i < qntParticipants; i++) {
					System.out.println();
					System.out.println("Dados do participante numero #" + (i + 1) + ":");
					System.out.print("Nome: ");
					String name = sc.nextLine();
					System.out.print("Email: ");
					String email = sc.nextLine();
					System.out.println("Qual o cargo de " + name + " no projeto?");
					System.out.print("1 - aluno de graduação\n2 - aluno de mestrado\n"
							+ "3 - aluno de doutorado\n4 - professor\n5 - pesquisador\n=> ");
					int numCargo = sc.nextInt();
					sc.nextLine();
					Collaborator participant;

					if (numCargo == 1) {
						participant = new GraduationStudent(name, email, "aluno de graduação");
					} else if (numCargo == 2) {
						participant = new MasterStudent(name, email, "aluno de mestrado");
					} else if (numCargo == 3) {
						participant = new DoctoralStudent(name, email, "aluno de doutorado");
					} else if (numCargo == 4) {
						participant = new Teacher(name, email, "professor");
						qntTeachers += 1;
					} else {
						participant = new Researcher(name, email, "pesquisador");
					}

					project.addParticipant(participant);

					if (i == qntParticipants - 1 && qntTeachers == 0) {
						System.out.println();
						System.out.println(
								"Um projeto de pesquisa deve ter pelo menos um professor como participante!!!");
						System.out.println("Adicione um professor.");
						qntParticipants += 1;
					}
				}
				listProjects.add(project);

				break;

			case 2:
				System.out.print("Digite o titulo do projeto a ser iniciado: ");
				//sc.nextLine();
				titleProject = sc.nextLine();
				Project projectAux = SearchProject(listProjects, titleProject);

				while (projectAux == null) {
					System.out.println("O projeto nao existe! Tente novamente!");
					System.out.print("Digite o nome do projeto a ser iniciado: ");
					titleProject = sc.nextLine();
					projectAux = SearchProject(listProjects, titleProject);
				}

				if (VerificProject(projectAux)) {
					System.out.print("Alterar o status do projeto para 'Em andamento' (s/n)? ");
					char choiceStatus = sc.next().charAt(0);

					if (choiceStatus == 's') {
						projectAux.setStatus(ProjectStatus.IN_PROGRESS);
					}
				} else {
					System.out.println("Um projeto so pode ser iniciado apenas se constarem"
							+ " todas as informações básicas a respeito do projeto cadastradas.\n");
				}

				break;

			case 3:
				break;

			case 4:
				System.out.print("Digite o titulo da publicacao: ");
				String title = sc.nextLine();
				System.out.print("Nome da conferencia onde foi publicada: ");
				String conferenceName = sc.nextLine();
				System.out.print("Ano de publicacao: ");
				int yearOfPublication = sc.nextInt();
				
				List<AcademicProduction> nonAssociatedPublications = new ArrayList<>();
				AcademicProduction publication = new Publication(title, conferenceName, yearOfPublication);
				
				System.out.print("Quantos autores a publicacao tem? ");
				int qntAuthors = sc.nextInt();			
				sc.nextLine();
				System.out.println("Nomes dos autores:");
				for(int i=0; i<qntAuthors; i++) {
					System.out.println("Autor #" + (i + 1) + ": ");
					System.out.print("Nome: ");
					String name = sc.nextLine();
					
					Collaborator collaboratorAux = SearchCollaborator(listProjects, name);
					
					if(collaboratorAux != null) {
						System.out.println("Autor encontrado com sucesso!");
					} else {
						System.out.println("Autor nao foi encontrado!");
					}
					publication.addAuthor(collaboratorAux);
				}
						
				System.out.print("A publicacao possui algum projeto de pesquisa associado (s/n)? ");
				char choice = sc.next().charAt(0);

				if (choice == 's') {
					System.out.print("Qual o titulo do projeto associado? ");
					sc.nextLine();
					titleProject = sc.nextLine();
					projectAux = SearchProject(listProjects, titleProject);
					
					while (projectAux == null) {
						System.out.println("O projeto nao existe!\n");
						System.out.print("Digite o titulo do projeto associado: ");
						titleProject = sc.nextLine();
						projectAux = SearchProject(listProjects, titleProject);
					}
							
					if (projectAux.getStatus() != ProjectStatus.IN_PROGRESS) {
						System.out.println("\nUma publicação só poderá ser associada a um projeto"
								+ "quando o status do projeto estiver 'Em andamento'\n");
					} else {
						projectAux.addAcademicProduction(publication);
					}
				} else {
					nonAssociatedPublications.add(publication);
				}

				break;
				
			case 5:
				

			default:
			}

		} while (option != 0);

		sc.close();
	}

	public static boolean VerificProject(Project project) {
		if (project.getTitle() != null && project.getStartDate() != null && project.getEndDate() != null
				&& project.getFinanceAgency() != null && project.getFinancedAmount() != null
				&& project.getObjective() != null && project.getDescription() != null
				&& project.getParticipants() != null) {
			return true;
		} else {
			return false;
		}
	}

	public static Project SearchProject(List<Project> listProjects, String title) {

		for (Project p : listProjects) {
			if (title.equals(p.getTitle())) {
				return p;
			}
		}
		return null;
	}
	
	public static Collaborator SearchCollaborator(List<Project> listProjects, String name) {
		for (Project p : listProjects) {
			for (Collaborator c : p.getParticipants()) {
				if(name.equals(c.getName())) {
					return c;
				}
			}
		}
		return null;
	}
}
