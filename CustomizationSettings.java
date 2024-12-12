import java.awt.*;

public class CustomizationSettings {
    private static CustomizationSettings instance;

    private Color backgroundColor = Color.WHITE;
    private Color buttonColor = Color.LIGHT_GRAY;
    private Color textColor = Color.BLACK;
    private Font customFont = new Font("Arial", Font.PLAIN, 14);

    private CustomizationSettings() {
    }

    public static CustomizationSettings getInstance() {
        if (instance == null) {
            instance = new CustomizationSettings();
        }
        return instance;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    }

    public Color getButtonColor() {
        return buttonColor;
    }

    public void setButtonColor(Color color) {
        this.buttonColor = color;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color color) {
        this.textColor = color;
    }

    public Font getCustomFont() {
        return customFont;
    }

    public void setCustomFont(Font font) {
        this.customFont = font;
    }
}
