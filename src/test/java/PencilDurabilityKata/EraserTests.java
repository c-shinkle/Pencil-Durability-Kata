package PencilDurabilityKata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;

public class EraserTests {

  @Test
  public void whenPencilIsConstructedItsEraserHasDurabilitySet() {
    Pencil pencil = new Pencil(1, 2, 3);
    
    assertEquals(3, pencil.getEraser().getDurability());
  }

  @Test
  public void whenEraserErasesItsDurabilityDecreases() {
    Eraser eraser = new Eraser(5);
    Paper paper = EasyMock.createMock(Paper.class);
    EasyMock.expect(paper.getContent()).andReturn("text");
    paper.removeText(0, 4);
    EasyMock.expectLastCall();
    EasyMock.replay(paper);

    eraser.erase(paper, "text");
    assertEquals(1, eraser.getDurability());
  }
}