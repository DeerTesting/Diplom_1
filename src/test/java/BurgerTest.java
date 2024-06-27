import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Ingredient ingredient;
    @Mock
    Bun bun;

    Burger burger;

    @Before
    public void setUp(){
        burger = new Burger();

    }

    @Test
    public void setBunTest(){
        burger.setBuns(bun);
        assertNotNull(burger.bun);
    }

    @Test
    public void addIngredientTest(){
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest(){
        for(int i = 0 ; i < 3 ; i++){ burger.ingredients.add(null);}
        burger.removeIngredient(1);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest(){
        burger.ingredients.add(ingredient);
        burger.ingredients.add(null);

        burger.moveIngredient(0,1);
        assertEquals(ingredient, burger.ingredients.get(1));
        assertNull(burger.ingredients.get(0));
    }

    @Test
    public void priceBunCallTest(){
        burger.bun = bun;
        burger.getPrice();
        Mockito.verify(bun, Mockito.times(1)).getPrice();
    }

    @Test
    public void priceIngredientCallTest(){
        burger.bun = bun;
        for(int i = 0 ; i < 3 ; i++){ burger.ingredients.add(ingredient);}
        burger.getPrice();
        Mockito.verify(ingredient, Mockito.times(3)).getPrice();
    }

    @Test
    public void getPriceBunIngredient(){
        burger.bun = bun;
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(10.00f);
        Mockito.when(ingredient.getPrice()).thenReturn(1.00f);

        float expectedResult = 22.00f;
        assertEquals(expectedResult, burger.getPrice(), 0);
    }

    @Test
    public void bunCallNameTest(){
        burger.bun = bun;
        burger.getReceipt();
        Mockito.verify(bun, Mockito.times(2)).getName();
    }

    @Test
    public void burgerCallIngrName(){
        burger.bun = bun;
        for(int i = 0 ; i < 3 ; i++){ burger.ingredients.add(ingredient);}

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        burger.getReceipt();

        Mockito.verify(ingredient, Mockito.times(3)).getName();
    }
    @Test
    public void burgerCallIngrType(){
        burger.bun = bun;
        for(int i = 0 ; i < 3 ; i++){ burger.ingredients.add(ingredient);}

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        burger.getReceipt();

        Mockito.verify(ingredient, Mockito.times(3)).getType();
    }
    @Test
    public void fullReceiptTest(){
        burger.bun = bun;
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("TastyIngredient");
        Mockito.when(bun.getPrice()).thenReturn(20.00f);
        Mockito.when(ingredient.getPrice()).thenReturn(1.00f);

        assertEquals("(==== null ====)" + System.lineSeparator() +
                "= sauce TastyIngredient =" + System.lineSeparator() +
                "= sauce TastyIngredient =" + System.lineSeparator() +
                "(==== null ====)" + System.lineSeparator() +
                System.lineSeparator() +
                "Price: 42,000000" + System.lineSeparator(), burger.getReceipt());
    }

}
