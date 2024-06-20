package config;

public enum ColorRGB {
    RED ("rgb(237, 23, 7)");

    private final String color;

    ColorRGB(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
