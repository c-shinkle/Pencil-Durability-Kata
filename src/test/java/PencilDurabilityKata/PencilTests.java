package PencilDurabilityKata;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;

public class PencilTests {

  @Test
  public void whenPencilWritesOnBlankPaperItWritesTextOntoPaper() {
    Paper paper = EasyMock.createMock(Paper.class);

    Pencil pencil = new Pencil();
    pencil.write(paper, "She sells sea shells");
    EasyMock.expectLastCall();

    EasyMock.replay(paper);
  }

  @Test
  public void whenPencilIsConstructedItHasAPointDurability() {
    Pencil pencil = new Pencil(4);
    assertEquals(4, pencil.getPointDurability());
  }

  @Test
  public void whenPencilWrites4LetterLowercaseWordItloses4Points() {
    Pencil pencil = new Pencil(4);
    Paper paper = EasyMock.createMock(Paper.class);

    pencil.write(paper, "text");
    EasyMock.expectLastCall();

    assertEquals(0, pencil.getPointDurability());
  }
}