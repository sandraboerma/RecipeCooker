package recipe;

public class PanRecipe extends Recipe{
    protected String panSize;
    protected String stoveStrength;

    public PanRecipe(String name, String proteinCategory, String panSize, String stoveStrength) {
        super(name, proteinCategory);
        this.panSize = panSize;
        this.stoveStrength = stoveStrength;
    }
}
