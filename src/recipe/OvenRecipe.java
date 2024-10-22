package recipe;

public class OvenRecipe extends Recipe {
    protected int ovenTimeMinutes;
    protected int ovenTemperature;
    protected boolean isSweet;

    public OvenRecipe(String name, String proteinCategory, int ovenTimeMinutes, int ovenTemperature, boolean isSweet) {
        super(name, proteinCategory);
        this.ovenTimeMinutes = ovenTimeMinutes;
        this.ovenTemperature = ovenTemperature;
        this.isSweet = isSweet;
    }
}
