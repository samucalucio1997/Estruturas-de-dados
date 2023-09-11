package FIFO;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class FilaTest {
    
    
    private Fila fila = new Fila<Integer>(3, -1);

    @Test
    public void testShowElements() {

    }

    @Test
    public void testDeQueue() {

    }

    @Test
    public void testEnQueue() {
       Assertions.assertNotNull(fila.enQueue(new Object()));
    }

    @Test
    public void testFirst() {

    }

    @Test
    public void testIsEmpty() {

    }

    @Test
    public void testSize() {

    }
}
