package recipe;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Recipe {

    private String name;
    private LinkedList<Ingredient> ingredients = new LinkedList<>();
    private ArrayList<String> instructions = new ArrayList<>();

}
