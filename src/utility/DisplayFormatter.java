package utility;

import recipe.Recipe;

import java.util.TreeMap;

public class DisplayFormatter {

    private final StringBuilder stringToBuild;
    private final int cliDisplayWidth;

    public DisplayFormatter(StringBuilder stringToBuild, int cliDisplayWidth) {
        this.stringToBuild = stringToBuild;
        this.cliDisplayWidth = cliDisplayWidth;
    }

    public static String formatMenu(TreeMap<Integer, String> menu) {
        StringBuilder menuString = new StringBuilder();
        for (Integer key : menu.keySet()) {
            menuString.append(key)
                    .append(": ")
                    .append(menu.get(key))
                    .append("\n");
        }
        return menuString.toString();
    }
}
