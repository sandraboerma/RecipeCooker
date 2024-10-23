package recipe;

public class OvenRecipe extends Recipe {
    protected int ovenTimeInMinutes;
    protected int ovenTemperatureInCelcius;
    protected boolean isSweet;

    public OvenRecipe(String name, String proteinCategory, int ovenTimeInMinutes, int ovenTemperatureInCelcius, boolean isSweet) {
        super(name, proteinCategory);
        this.ovenTimeInMinutes = ovenTimeInMinutes;
        this.ovenTemperatureInCelcius = ovenTemperatureInCelcius;
        this.isSweet = isSweet;
    }
}
