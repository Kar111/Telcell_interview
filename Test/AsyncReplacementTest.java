import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AsyncReplacementTest {

    private AsyncReplacement asyncReplacement;

    @Test
    public void shouldReplaceCorrectly() {

        //setup
        asyncReplacement = new AsyncReplacement();
        String[] source = {"an", "array", "of", "five", "strings"};
        String[] expected = {"%n", "%rr%y", "of", "five", "strings"};

        //when
        String[] destination = asyncReplacement.asyncArrayCopyWithReplacement(source);

        //then0
        assertEquals(destination.length, expected.length);

        //than1.with-a cases
        assertEquals(destination[0], expected[0]);
        assertEquals(destination[1], expected[1]);

        //than2.no-a cases
        assertEquals(destination[2], expected[2]);
        assertEquals(destination[3], expected[3]);
        assertEquals(destination[4], expected[4]);
    }

    @Test
    public void shouldDoNothingForEmptyCase() {

        //setup
        asyncReplacement = new AsyncReplacement();
        String[] source = {};
        String[] expected = {};

        //when
        String[] destination = asyncReplacement.asyncArrayCopyWithReplacement(source);

        //then
        assertEquals(destination.length, expected.length);
    }

}