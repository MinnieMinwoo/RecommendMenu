package com.example.recommendmenu.recipeDetail;

import com.example.recommendmenu.recipe.RecipeService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/recipe/detail")
@RequiredArgsConstructor
@Controller
public class RecipeDetailController {

  private final RecipeService recipeService;
  private final RecipeDetailService recipeDetailService;

  @GetMapping("/{id}")
  public RecipeDetail getRecipeDetail(Integer id) {
    String title = recipeService.getRecipe(id).getTitle();
    try {
      return recipeDetailService.getRecipeDetail(title);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
