package utility;

import java.util.TreeMap;

public class MenuHub {

    private static final TreeMap<Integer, String> mainMenu = new TreeMap<>();
    private static final TreeMap<Integer, String> createRecipe = new TreeMap<>();
    //private static final TreeMap<Integer, String> modifyRecipeMenu = new TreeMap<>();

    static {
        initializeMain();
        initializeCreateRecipe();
    }


    public static void initializeMain(){
        mainMenu.put(1, "Create Recipe");
        mainMenu.put(2, "View Recipe");
        //mainMenu.put(3, "Modify Recipe");
        mainMenu.put(3, "Delete Recipe");
        mainMenu.put(4, "Exit");
    }

    public static void initializeCreateRecipe(){
        createRecipe.put(1, "Add ingredient");
        createRecipe.put(2, "Add instructions");
        createRecipe.put(3, "Assign category");
        createRecipe.put(4, "Preview recipe");
        createRecipe.put(5, "Save recipe");
        createRecipe.put(6, "Discard recipe");
    }

    public static TreeMap<Integer, String> getMainMenu(){
        return mainMenu;
    }

    public static TreeMap<Integer, String> getCreateRecipe(){
        return createRecipe;
    }

//@TODO: Fix toString Override for TreeMap

}
