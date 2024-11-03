package recipe;

public enum DietaryPreference {
    VEGETARIAN, GLUTEN_FREE, ANY_DIET;

    @Override
    public String toString() {
        return switch (this) {
            case VEGETARIAN -> "Vegetarian";
            case GLUTEN_FREE -> "Gluten-Free";
            case ANY_DIET -> "Any Diet";
        };
    }
}
