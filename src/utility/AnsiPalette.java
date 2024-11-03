package utility;

public enum AnsiPalette {
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    ORANGE("\u001B[38;5;208m");

    private final String code;

    AnsiPalette(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
