package recipe;

public class StoveRecipe extends Recipe{
    protected String panSize;
    protected String stoveStrength;

    public StoveRecipe(String name, String proteinCategory, String panSize, String stoveStrength) {
        super(name, proteinCategory);
        this.panSize = panSize;
        this.stoveStrength = stoveStrength;
    }




}
