import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    Ingredient ingredient;
    IngredientType ingredientType;
    private String name;
    private float price;
    private float expectedResultPrice;
    private String expectedResultName;

    public IngredientTypeTest(IngredientType ingredientType, String name, float price, float expectedResultPrice, String expectedResultName){
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
        this.expectedResultPrice = expectedResultPrice;
        this.expectedResultName = expectedResultName;
    }

    @Parameterized.Parameters( name = "{index}: {1}, {2}")
    public static Object[][] getPrice(){
        return new Object[][]{
                {FILLING, "Long ingredient name but free", 0.0f, 0.0f, "Long ingredient name but free"},
                {SAUCE, "", 12.05f, 12.05f, ""},
                {FILLING, "@@ specialCharacter#", Float.MIN_VALUE, Float.MIN_VALUE, "@@ specialCharacter#"},
                {SAUCE, null, Float.MAX_VALUE, Float.MAX_VALUE, null},
                {FILLING, "872347",  12.1205f, 12.2105f, "872347"}
        };
    }

//    @Test
//    public void getName(){
//        ingredient = new Ingredient(ingredientType, name, price);
//        assertEquals(expectedResult, ingredient.getType());
//    }

    @Before
    public void setUp(){
        ingredient = new Ingredient(ingredientType, name, price);;
    }
    @Test
    public void differentPrice(){
        float actualResult = ingredient.getPrice();
        assertEquals(expectedResultPrice, actualResult, 0);
    }

    @Test
    public void differentName(){
        String actualResult = ingredient.getName();
        assertEquals(expectedResultName, actualResult);
    }


}
