package com.example.recommendmenu.recipe;

import com.example.recommendmenu.error.DataNotFoundExecption;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RecipeService {

  private final RecipeRepository recipeRepository;

  public Recipe getRecipe(Integer id) {
    Optional<Recipe> recipe = recipeRepository.findById(id);
    if (recipe.isEmpty()) {
      throw new DataNotFoundExecption("recipe not found");
    }
    return recipe.get();
  }
}
