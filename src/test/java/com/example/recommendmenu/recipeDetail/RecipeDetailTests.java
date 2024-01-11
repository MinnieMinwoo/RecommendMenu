package com.example.recommendmenu.recipeDetail;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.recommendmenu.recipe.Recipe;
import com.example.recommendmenu.recipe.RecipeRepository;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RecipeDetailTests {

  @Autowired
  private static RecipeRepository recipeRepository;

  @Autowired
  private RecipeDetailService recipeDetailService;

  @BeforeAll
  public static void beforeEach() {
    List<Recipe> recipes = recipeRepository.findAll();
    if (recipes.stream().noneMatch(recipe -> recipe.getTitle().equals("김치찌개"))) {
      Recipe recipe = new Recipe();
      recipe.setTitle("김치찌개");
      recipeRepository.save(recipe);
    }
  }
  
  @Test
  void getRecipeDetailTest() throws IOException {

    RecipeDetail recipeDetail = this.recipeDetailService.getRecipeDetail("김치찌개");
    assertEquals(recipeDetail.getTitle(), "김치찌개");
    assertEquals(recipeDetail.getIngredients().size(), 11);
    assertEquals(recipeDetail.getStep().size(), 8);
  }

}
