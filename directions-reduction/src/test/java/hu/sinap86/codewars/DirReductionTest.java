package hu.sinap86.codewars;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * @author Sinka László
 */
public class DirReductionTest {

    @Test
    public void testSimpleDirReduc() throws Exception {
        assertArrayEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
                          new String[]{ "WEST" },
                          DirReduction.dirReduc(new String[]{ "NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST" }));

        assertArrayEquals("\"NORTH\", \"WEST\", \"SOUTH\", \"EAST\"",
                          new String[]{ "NORTH", "WEST", "SOUTH", "EAST" },
                          DirReduction.dirReduc(new String[]{ "NORTH", "WEST", "SOUTH", "EAST" }));
    }
}
