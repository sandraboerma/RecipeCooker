package service;

import utility.DisplayFormatter;

import java.util.TreeMap;

public class MenuHub {

    private static final TreeMap<Integer, String> mainMenu = new TreeMap<>();
    private static final TreeMap<Integer, String> createRecipeMenu = new TreeMap<>();
    //private static final TreeMap<Integer, String> modifyRecipeMenu = new TreeMap<>();

    static {
        initializeMain();
        initializeCreateRecipeMenu();
    }

    private static void initializeMain(){
        mainMenu.put(1, "Create Recipe");
        mainMenu.put(2, "View Recipe");
        //mainMenu.put(3, "Modify Recipe");
        mainMenu.put(3, "Delete Recipe");
        mainMenu.put(4, "Exit");
    }

    private static void initializeCreateRecipeMenu(){
        createRecipeMenu.put(1, "Add ingredient");
        createRecipeMenu.put(2, "Add instructions");
        createRecipeMenu.put(3, "Assign category");
        createRecipeMenu.put(4, "Preview recipe");
        createRecipeMenu.put(5, "Save recipe");
        createRecipeMenu.put(6, "Discard current creation");
    }

    private static TreeMap<Integer, String> getMainMenu(){
        return mainMenu;
    }

    private static TreeMap<Integer, String> getCreateRecipeMenu(){
        return createRecipeMenu;
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
        return DisplayFormatter.getFormattedMenu(getMainMenu()) + "\nLet's start this visit with > ";
    }

    public static String getFormattedCreateRecipeMenu() {
        return "\nAwesome, then let's cook up some recipe! What would you like to do first?\n\n" +
                DisplayFormatter.getFormattedMenu(getCreateRecipeMenu()) + "\nI would like to: ";
    }


}
