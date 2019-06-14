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
  public void whenPencilWrites4LetterLowercaseWordItLoses4Points() {
    Pencil pencil = new Pencil(4);
    Paper paper = EasyMock.createMock(Paper.class);

    pencil.write(paper, "text");
    EasyMock.expectLastCall();

    assertEquals(0, pencil.getPointDurability());
  }

  @Test
  public void whenPencilWrites4LetterCapitalizedWordItLosses5Points() {
    Pencil pencil = new Pencil(5);
    Paper paper = EasyMock.createMock(Paper.class);

    pencil.write(paper, "Text");
    EasyMock.expectLastCall();

    assertEquals(0, pencil.getPointDurability());
  }

  @Test
  public void whenPencilWritesMutlipleWordsItLoosesPointsForAllWords() {
    Pencil pencil = new Pencil(20);
    Paper paper = EasyMock.createMock(Paper.class);

    pencil.write(paper, "She sells sea shells");
    EasyMock.expectLastCall();

    assertEquals(2, pencil.getPointDurability());
  }
}