package service;

import java.util.ArrayList;
import java.util.TreeMap;

public class MenuHub {

    private static final ArrayList<String> startUpGreetings = new ArrayList<>();
    private static final TreeMap<Integer, String> mainMenu = new TreeMap<>();
    private static final TreeMap<Integer, String> createRecipe = new TreeMap<>();
    //private static final TreeMap<Integer, String> modifyRecipeMenu = new TreeMap<>();

    static {
        initializeMain();
        initializeCreateRecipe();
    }

    private static void initializeMain(){
        mainMenu.put(1, "Create Recipe");
        mainMenu.put(2, "View Recipe");
        //mainMenu.put(3, "Modify Recipe");
        mainMenu.put(3, "Delete Recipe");
        mainMenu.put(4, "Exit");
    }

    private static void initializeCreateRecipe(){
        createRecipe.put(1, "Add ingredient");
        createRecipe.put(2, "Add instructions");
        createRecipe.put(3, "Assign category");
        createRecipe.put(4, "Preview recipe");
        createRecipe.put(5, "Save recipe");
        createRecipe.put(6, "Discard current creation");
    }

    private static TreeMap<Integer, String> getMainMenu(){
        return mainMenu;
    }

    private static TreeMap<Integer, String> getCreateRecipe(){
        return createRecipe;
    }

    private static String formatMenu(TreeMap<Integer, String> menu){
        StringBuilder menuString = new StringBuilder();
        for(Integer key : menu.keySet()){
            menuString.append(key)
                    .append(": ")
                    .append(menu.get(key))
                    .append("\n");
        }
        return menuString.toString();
    }

    public static String getFormattedMainMenu(){
        return formatMenu(getMainMenu()) + "\nLet's start this visit with > ";
    }

    public static String getFormattedCreateRecipe() {
        return "\nAwesome, then let's cook up some recipe! What would you like to do first?\n\n" +
                formatMenu(getCreateRecipe()) + "\nI would like to: ";
    }


}
