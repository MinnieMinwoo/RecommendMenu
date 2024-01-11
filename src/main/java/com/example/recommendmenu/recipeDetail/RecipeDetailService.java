package com.example.recommendmenu.recipeDetail;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class RecipeDetailService {

  private static final String recipeDomain = "https://www.10000recipe.com";

  public RecipeDetail getRecipeDetail(String title) throws IOException {
    Document searchResult = Jsoup.connect(String.format("%s/recipe/list.html?q=%s", recipeDomain, title)).get();
    Elements searchLists = searchResult.select(".common_sp_link");
    String recipeDetailRoot = searchLists.getFirst().select("a").attr("href"); // /detail/123

    Document detailResult = Jsoup.connect(String.format("%s%s", recipeDomain, recipeDetailRoot)).get();

    ArrayList<String> ingredients = new ArrayList<>();
    Elements recipeIngredients = detailResult.select("#divConfirmedMaterialArea ul li");
    recipeIngredients.forEach(recipe -> {
      String ingredient = recipe.select("a").getFirst().text();
      String amount = recipe.select(".ingre_unit").getFirst().text();
      ingredients.add(String.format("%s%s", ingredient, amount));
    });

    ArrayList<String> steps = new ArrayList<>();
    Elements recipeSteps = detailResult.select(".view_step").getFirst().select(".view_step_cont");
    recipeSteps.forEach(step -> {
      String text = step.select("div").getFirst().text();
      steps.add(text);
    });

    return RecipeDetail.builder().
        title(title).
        reference(String.format("%s%s", recipeDomain, recipeDetailRoot)).
        ingredients(ingredients).
        step(steps).
        build();
  }
}
