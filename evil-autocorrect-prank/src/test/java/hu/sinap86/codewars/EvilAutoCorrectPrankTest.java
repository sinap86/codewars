package hu.sinap86.codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Sinka László
 */
public class EvilAutoCorrectPrankTest {
    @Test
    public void testApply() {
        String[] inputs = new String[]{
                "u",
                "you",
                "Youuuuu",
                "youtube",
                "bayou",
                "I miss you!",
                "You u youville utube you youyouyou uuu raiyou united youuuu u you"
        };

        String[] outputs = new String[]{
                "your sister",
                "your sister",
                "your sister",
                "youtube",
                "bayou",
                "I miss your sister!",
                "your sister your sister youville utube your sister youyouyou uuu raiyou united your sister your sister your sister"
        };

        for (int i = 0; i < inputs.length; i++) {
            assertEquals(String.format("Wrong result for \"%s\":", inputs[i]), outputs[i], EvilAutoCorrectPrank.autoCorrect(inputs[i]));
        }
    }
}
