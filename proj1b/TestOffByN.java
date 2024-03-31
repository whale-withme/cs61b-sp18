import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestOffByN {
    static CharacterComparator offbyn = new OffByN(3);
    
    @Test
    public void TestOffbyN(){
        assertTrue(offbyn.equalChars('a', 'd'));
        assertFalse(offbyn.equalChars('0', 'a'));
        assertFalse(offbyn.equalChars('1', '0'));
    }
}
