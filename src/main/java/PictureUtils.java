public class PictureUtils {

    public static Picture combine(Picture p1, Picture p2) throws Exception {
        if (p1 instanceof OneColorPicture && p2 instanceof OneColorPicture) {
            Color c1 = ((OneColorPicture) p1).getColor();
            Color c2 = ((OneColorPicture) p2).getColor();
            if (c1 == Color.WHITE && c2 == Color.WHITE) {
                return new OneColorPicture(Color.WHITE);
            } else {
                return new OneColorPicture(Color.BLACK);
            }
        }
        if (p1 instanceof DividedPicture && p2 instanceof DividedPicture) {
            return new DividedPicture(
                    combine(((DividedPicture) p1).getTopLeft(), ((DividedPicture) p2).getTopLeft()),
                    combine(((DividedPicture) p1).getTopRight(), ((DividedPicture) p2).getTopRight()),
                    combine(((DividedPicture) p1).getBotLeft(), ((DividedPicture) p2).getBotLeft()),
                    combine(((DividedPicture) p1).getBotRight(), ((DividedPicture) p2).getBotRight())
            );
        }
        if (p1 instanceof DividedPicture && p2 instanceof OneColorPicture) {
            if (((OneColorPicture) p2).getColor() == Color.BLACK) {
                return new OneColorPicture(Color.BLACK);
            } else {
                return p1;
            }
        }
        if (p1 instanceof OneColorPicture && p2 instanceof DividedPicture) {
            if (((OneColorPicture) p1).getColor() == Color.BLACK) {
                return new OneColorPicture(Color.BLACK);
            } else {
                return p2;
            }
        }

        throw new Exception("something is missing here...");
    }

    public static Picture createRandomPic(int maxDepth) {
        if (maxDepth == 0) {
            if (Math.random() > 0.5) {
                return new OneColorPicture(Color.BLACK);
            } else {
                return new OneColorPicture(Color.WHITE);
            }
        } else {
            if (Math.random() > 0.4) {
                return new DividedPicture(
                        createRandomPic(maxDepth - 1),
                        createRandomPic(maxDepth - 1),
                        createRandomPic(maxDepth - 1),
                        createRandomPic(maxDepth - 1)
                );
            } else {
                if (Math.random() > 0.5) {
                    return new OneColorPicture(Color.BLACK);
                } else {
                    return new OneColorPicture(Color.WHITE);
                }
            }
        }
    }

}
