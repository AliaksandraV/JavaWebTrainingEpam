package by.training.composite.service.parser;

import by.training.composite.entity.Component;
import by.training.composite.entity.Symbol;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SymbolParserServiceTest {

    private SymbolParserService service = new SymbolParserService();

    /**
     *
     * @return
     */
    @DataProvider(name = "symbolparser")
    public Object[][] symbolparser(){
        return new Object[][]{
                { "в", new Symbol('в')}
        };

    }

    @Test (description = "Negative scenario for Get Matrix Size",
            dataProvider = "symbolparser")
    public void testParse(final String symbol, final Symbol expected) {
        Component actual = service.parse(symbol);
        assertEquals(actual, expected);
    }
}