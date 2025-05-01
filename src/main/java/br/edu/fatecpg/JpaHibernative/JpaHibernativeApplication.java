package br.edu.fatecpg.JpaHibernative;

import br.edu.fatecpg.JpaHibernative.model.Recipe;
import br.edu.fatecpg.JpaHibernative.services.RecipeAPIService;
import br.edu.fatecpg.JpaHibernative.model.RecipeDTO;
import br.edu.fatecpg.JpaHibernative.repository.RecipeRepository;
import br.edu.fatecpg.JpaHibernative.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class JpaHibernativeApplication implements ApplicationRunner {

	@Autowired
	private RecipeRepository repository;

	@Autowired
	private RecipeAPIService apiService;

	@Autowired
	public RecipeService recipeService;

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernativeApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n=== MENU ===");
			System.out.println("1 - Buscar receita por ID");
			System.out.println("2 - Ver receitas salvas");
			System.out.println("0 - Sair");
			System.out.print("Escolha uma opção: ");
			int opcao = scanner.nextInt();

			switch (opcao) {
				case 1:
					System.out.print("Digite o ID da receita: ");
					int id = scanner.nextInt();

					try {
						RecipeDTO dto = apiService.getRecipeById(id);
						System.out.println("\nReceita encontrada:");
						System.out.println(dto);

						System.out.print("Deseja salvar no banco? (s/n): ");
						String salvar = scanner.next();

						if (salvar.equalsIgnoreCase("s")) {
							Recipe recipe = convertToEntity(dto);
							repository.save(recipe);
							System.out.println("Receita salva com sucesso.");
						}

					} catch (Exception e) {
						System.out.println("Erro ao buscar receita: " + e.getMessage());
					}
					break;

				case 2:
					List<Recipe> receitas = recipeService.listarReceitas();
					if (receitas.isEmpty()) {
						System.out.println("Nenhuma receita salva.");
					} else {
						System.out.println("\nReceitas salvas no banco:");
						receitas.forEach(System.out::println);
					}
					break;

				case 0:
					System.out.println("Encerrando...");
					System.exit(0);
					break;

				default:
					System.out.println("Opção inválida.");
			}
		}
	}
	private Recipe convertToEntity(RecipeDTO dto) {
		return RecipeAPIService.convertToEntity(dto);
	}
}