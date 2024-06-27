import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientGetTypeTest {

    Ingredient ingredient;

    @Before
    public void setUp(){
        ingredient = new Ingredient(IngredientType.SAUCE, "some_name", 10.0f);
    }

    @Test
    public void getTypeTest(){
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
