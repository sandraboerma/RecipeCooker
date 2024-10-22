package recipe;

public class OvenRecipe extends Recipe {
    protected int ovenTime;
    protected int ovenTemperature;
    protected boolean isSweet;

    public OvenRecipe(String name, String proteinCategory, int ovenTime, int ovenTemperature, boolean isSweet) {
        super(name, proteinCategory);
        this.ovenTime = ovenTime;
        this.ovenTemperature = ovenTemperature;
        this.isSweet = isSweet;
    }
}
