package com.example.recommendmenu.recipe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RecipeTests {

  private static RecipeRepository recipeRepository;

  @Autowired
  private void recipeRepository(RecipeRepository recipeRepository) {
    RecipeTests.recipeRepository = recipeRepository;
  }

  @Autowired
  private RecipeService recipeService;
  private static Integer recipeNum;

  @BeforeAll
  public static void beforeAll() {
    List<Recipe> recipes = recipeRepository.findAll();
    if (recipes.stream().noneMatch(recipe -> recipe.getTitle().equals("김치찌개"))) {
      Recipe recipe = new Recipe();
      recipe.setTitle("김치찌개");
      recipeRepository.save(recipe);
    } else {
      recipeNum = recipeRepository.findByTitle("김치찌개").getId();
    }
  }

  @Test
  void getRecipeDetailTest() {

    Recipe recipe = recipeService.getRecipe(recipeNum);
    assertEquals(recipe.getTitle(), "김치찌개");
  }

}
