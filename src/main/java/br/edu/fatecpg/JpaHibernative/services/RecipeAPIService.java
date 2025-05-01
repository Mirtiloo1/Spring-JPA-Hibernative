package br.edu.fatecpg.JpaHibernative.services;

import br.edu.fatecpg.JpaHibernative.model.Recipe;
import br.edu.fatecpg.JpaHibernative.model.RecipeDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RecipeAPIService {
    private static final String API_URL = "https://dummyjson.com/recipes/";
    private final RestTemplate restTemplate = new RestTemplate();

    public RecipeDTO getRecipeById(int id) {
        try {
            String url = API_URL + id;
            return restTemplate.getForObject(url, RecipeDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar receita com ID " + id, e);
        }
    }

    public static Recipe convertToEntity(RecipeDTO dto) {
        Recipe recipe = new Recipe();
        recipe.setId(dto.getId());
        recipe.setName(dto.getName());
        recipe.setIngredients(dto.getIngredients());
        recipe.setPrepTimeMinutes(dto.getPrepTimeMinutes());
        recipe.setCookTimeMinutes(dto.getCookTimeMinutes());
        recipe.setServings(dto.getServings());
        recipe.setDifficulty(dto.getDifficulty());
        return recipe;
    }


}
