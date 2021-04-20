import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class OneColorPicture extends Picture {

    private Color color;

    public OneColorPicture(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
