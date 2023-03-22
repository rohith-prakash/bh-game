package org.example.dice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyDiceTest {
    @Test
    public void testGeneratedValues(){
        Dice dice = new DummyDice();
        List expectedValues = Arrays.asList(2,2,1, 4,4,2, 4,4,2, 2,2,1, 4,4,2, 4,4,2, 2,2,1,2);
        for(var val:expectedValues){
            int v = (int)val;
            int nextVal = dice.getNum();
            assertEquals(v,nextVal);
        }

    }
}
