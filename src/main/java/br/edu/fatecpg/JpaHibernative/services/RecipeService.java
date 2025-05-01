package br.edu.fatecpg.JpaHibernative.services;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.edu.fatecpg.JpaHibernative.repository.RecipeRepository;
import br.edu.fatecpg.JpaHibernative.model.Recipe;
import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository repository;

    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<Recipe> listarReceitas() {
        List<Recipe> receitas = repository.findAll();

        for (Recipe recipe : receitas) {
            Hibernate.initialize(recipe.getIngredients());
        }

        return receitas;
    }
}
