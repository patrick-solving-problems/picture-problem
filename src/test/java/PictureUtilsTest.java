import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

class PictureUtilsTest {

    @Test
    public void shouldCombineEasy() throws Exception {
        // prepare
        Picture p1 = new DividedPicture(
                new OneColorPicture(Color.WHITE),
                new OneColorPicture(Color.WHITE),
                new OneColorPicture(Color.WHITE),
                new OneColorPicture(Color.BLACK)
        );
        Picture p2 = new DividedPicture(
                new OneColorPicture(Color.BLACK),
                new OneColorPicture(Color.BLACK),
                new OneColorPicture(Color.WHITE),
                new OneColorPicture(Color.WHITE)
        );

        // act
        Picture result = PictureUtils.combine(p1, p2);

        // assert
        Assertions.assertEquals(
                result,
                new DividedPicture(
                        new OneColorPicture(Color.BLACK),
                        new OneColorPicture(Color.BLACK),
                        new OneColorPicture(Color.WHITE),
                        new OneColorPicture(Color.BLACK)
                ));
    }

    @Test
    public void shouldCombineHard() throws Exception {
        // prepare
        Picture p1 = new DividedPicture(
                new OneColorPicture(Color.WHITE),
                new OneColorPicture(Color.WHITE),
                new OneColorPicture(Color.WHITE),
                new DividedPicture(
                        new OneColorPicture(Color.WHITE),
                        new OneColorPicture(Color.WHITE),
                        new OneColorPicture(Color.WHITE),
                        new OneColorPicture(Color.BLACK)
                )
        );
        Picture p2 = new DividedPicture(
                new OneColorPicture(Color.BLACK),
                new OneColorPicture(Color.BLACK),
                new OneColorPicture(Color.WHITE),
                new OneColorPicture(Color.WHITE)
        );

        // act
        Picture result = PictureUtils.combine(p1, p2);

        // assert
        Assertions.assertEquals(
                result,
                new DividedPicture(
                        new OneColorPicture(Color.BLACK),
                        new OneColorPicture(Color.BLACK),
                        new OneColorPicture(Color.WHITE),
                        new DividedPicture(
                                new OneColorPicture(Color.WHITE),
                                new OneColorPicture(Color.WHITE),
                                new OneColorPicture(Color.WHITE),
                                new OneColorPicture(Color.BLACK)
                        )
                ));
    }

    @Test
    public void shouldCreateAndCombineHeavyObjects() throws Exception {
        Picture p1 = PictureUtils.createRandomPic(17);
        Picture p2 = PictureUtils.createRandomPic(17);

        Stopwatch sw1 = Stopwatch.createStarted();
        Picture result1 = PictureUtils.combine(p1, p2);
        long elapsed1 = sw1.stop().elapsed(TimeUnit.MILLISECONDS);
        System.out.println(elapsed1 + " ms");



    }

}