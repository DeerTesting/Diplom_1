import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    @Test
    public void nameTest(){
        assertEquals(FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test
    public void priceTest(){
        assertEquals(SAUCE, IngredientType.valueOf("SAUCE"));
    }

}
