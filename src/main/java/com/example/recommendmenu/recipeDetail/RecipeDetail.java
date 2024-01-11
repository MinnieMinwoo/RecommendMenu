package com.example.recommendmenu.recipeDetail;

import java.util.ArrayList;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class RecipeDetail {

  private String title;
  private String reference;
  private ArrayList<String> ingredients;
  private ArrayList<String> step;
}
