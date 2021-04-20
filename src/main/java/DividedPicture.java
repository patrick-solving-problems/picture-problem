import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class DividedPicture extends Picture {

    private final Picture topLeft;

    private final Picture topRight;

    private final Picture botLeft;

    private final Picture botRight;

    public DividedPicture(Picture topLeft, Picture topRight, Picture botLeft, Picture botRight) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.botLeft = botLeft;
        this.botRight = botRight;
    }

    public Picture getTopLeft() {
        return topLeft;
    }

    public Picture getTopRight() {
        return topRight;
    }

    public Picture getBotLeft() {
        return botLeft;
    }

    public Picture getBotRight() {
        return botRight;
    }

}
