package recipe;

public class StoveRecipe extends Recipe{
    protected String stoveHeatStrength;

    public StoveRecipe(String name, String proteinCategory, String stoveHeatStrength) {
        super(name, proteinCategory);
        this.stoveHeatStrength = stoveHeatStrength;
    }




}
