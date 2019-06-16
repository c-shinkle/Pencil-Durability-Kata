package PencilDurabilityKata;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EraserTests {

  @Test
  public void whenPencilIsConstructedItsEraserHasDurabilitySet() {
    Pencil pencil = new Pencil(1, 2, 3);
    
    assertEquals(3, pencil.getEraser().getDurability());
  }
}