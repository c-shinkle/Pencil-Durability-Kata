package PencilDurabilityKata;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PaperTests {

  @Test
  public void whenConstructingABlankPaperItsContentsReturnBlank() {
    Paper paper = new Paper();
    assertEquals("", paper.getContent());
  }
}