package recipe;

public class Ingredient {
    protected String name;
    protected String unit;
    protected double quantity;

    public Ingredient(String name, String unit, double quantity) {
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return name + " " + quantity + " " + unit;
    }
}
