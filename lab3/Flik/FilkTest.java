import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class FilkTest {
    
    @Test
    public void samenumberTest(){
        int a = 4, b = 4, c = 5;
        assertEquals(a, b);
        assertNotEquals(a, c);
    }
}
