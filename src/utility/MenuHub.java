package utility;

import java.util.TreeMap;

public class MenuHub {

    private static final TreeMap<Integer, String> mainMenu = new TreeMap<>();
    private static final TreeMap<Integer, String> createRecipeMenu = new TreeMap<>();
    //private static final TreeMap<Integer, String> modifyRecipeMenu = new TreeMap<>();


    public static TreeMap mainMenu(){
        mainMenu.put(1, "Create Recipe.");
        mainMenu.put(2, "View Recipe");
        //mainMenu.put(3, "Modify Recipe");
        mainMenu.put(3, "Delete Recipe");
        mainMenu.put(4, "Exit");
        return mainMenu;
    }

    public static TreeMap createRecipeMenu(){
        createRecipeMenu.put(1, "Add ingredient");
        createRecipeMenu.put(2, "Add instructions");
        createRecipeMenu.put(3, "Assign category");
        createRecipeMenu.put(4, "Preview recipe");
        createRecipeMenu.put(5, "Save recipe");
        createRecipeMenu.put(6, "Discard recipe");
        return createRecipeMenu;
    }

}
