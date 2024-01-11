package com.example.recommendmenu.recipe;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/recipe")
@RequiredArgsConstructor
@Controller
public class RecipeController {

  private final RecipeService recipeService;

  @GetMapping("/{id}")
  public String getRecipe(Integer id) {
    Recipe recipe = this.recipeService.getRecipe(id);
    String recipeTitle = recipe.getTitle();

    return "몰루";
  }
}
