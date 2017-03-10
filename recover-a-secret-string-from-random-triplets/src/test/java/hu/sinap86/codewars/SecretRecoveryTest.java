package hu.sinap86.codewars;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Sinka László
 */
public class SecretRecoveryTest {

    private SecretDetective detective;

    @Before
    public void setup() {
        detective = new SecretDetective();
    }

    @Test
    public void secret1() {
        char[][] triplets = {
                { 't', 'u', 'p' },
                { 'w', 'h', 'i' },
                { 't', 's', 'u' },
                { 'a', 't', 's' },
                { 'h', 'a', 'p' },
                { 't', 'i', 's' },
                { 'w', 'h', 's' }
        };
        assertEquals("whatisup", detective.recoverSecret(triplets));
    }

    @Test
    public void secret2() {
        char[][]
                triplets = {
                { 't', 's', 'f' },
                { 'a', 's', 'u' },
                { 'm', 'a', 'f' },
                { 'a', 'i', 'n' },
                { 's', 'u', 'n' },
                { 'm', 'f', 'u' },
                { 'a', 't', 'h' },
                { 't', 'h', 'i' },
                { 'h', 'i', 'f' },
                { 'm', 'h', 'f' },
                { 'a', 'u', 'n' },
                { 'm', 'a', 't' },
                { 'f', 'u', 'n' },
                { 'h', 's', 'n' },
                { 'a', 'i', 's' },
                { 'm', 's', 'n' },
                { 'm', 's', 'u' }
        };
        assertEquals("mathisfun", detective.recoverSecret(triplets));
    }

    @Test
    public void secret3() {
        char[][]
                triplets = {
                { 'g', 'a', 's' },
                { 'o', 'g', 's' },
                { 'c', 'n', 't' },
                { 'c', 'o', 'n' },
                { 'a', 't', 's' },
                { 'g', 'r', 't' },
                { 'r', 't', 's' },
                { 'c', 'r', 'a' },
                { 'g', 'a', 't' },
                { 'n', 'g', 's' },
                { 'o', 'a', 's' }
        };
        assertEquals("congrats", detective.recoverSecret(triplets));
    }

    @Test
    public void secret4() {
        char[][]
                triplets = {
                { 'l', 'e', 'd' },
                { 'o', 'e', 'd' },
                { 'o', 'l', 'e' },
                { 'o', 'v', 'e' },
                { 's', 'o', 'l' },
                { 's', 'e', 'd' },
                { 's', 'l', 'e' },
                { 'v', 'e', 'd' },
                { 'o', 'l', 'v' },
                { 'l', 'v', 'd' }
        };
        assertEquals("solved", detective.recoverSecret(triplets));
    }

}