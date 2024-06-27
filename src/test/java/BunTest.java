import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.apache.commons.lang3.RandomStringUtils;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunPriceTest {

    Bun bun;
    private String name;
    private float price;
    private float expectedResultPrice;
    private String expectedResultName;

    public BunPriceTest(String name, float price, float expectedResultPrice, String expectedResultName){
        this.name = name;
        this.price = price;
        this.expectedResultPrice = expectedResultPrice;
        this.expectedResultName = expectedResultName;
    }

    @Parameterized.Parameters( name = "{index}: {1}, {0}")
    public static Object[][] getPrice(){
        return new Object[][]{
                {"String with space and long", 0.0f, 0.0f, "String with space and long"},
                {"", 12.05f, 12.05f, ""},
                {"!specialCharacter", Float.MIN_VALUE, Float.MIN_VALUE, "!specialCharacter"},
                {null, Float.MAX_VALUE, Float.MAX_VALUE, null},
                {"13579",  12.1205f, 12.1205f, "13579"}
        };
    }

    @Before
    public void setUp(){
        bun = new Bun(name, price);
    }

    @Test
    public void differentPrice(){
        float actualResult = bun.getPrice();
        assertEquals(expectedResultPrice, actualResult, 4);
    }

    @Test
    public void differentName(){
        String actualResult = bun.getName();
        assertEquals(expectedResultName, actualResult);
    }
}
