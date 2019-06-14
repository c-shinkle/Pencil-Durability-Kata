package PencilDurabilityKata;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;

public class PencilTests {

  private Paper paper;

  @Before
  public void setup() {
    paper = EasyMock.createMock(Paper.class);
  }

  @Test
  public void whenPencilWritesOnBlankPaperItWritesTextOntoPaper() {
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

    pencil.write(paper, "text");
    EasyMock.expectLastCall();

    EasyMock.replay(paper);
    assertEquals(0, pencil.getPointDurability());
  }

  @Test
  public void whenPencilWrites4LetterCapitalizedWordItLosses5Points() {
    Pencil pencil = new Pencil(5);

    pencil.write(paper, "Text");
    EasyMock.expectLastCall();

    EasyMock.replay(paper);
    assertEquals(0, pencil.getPointDurability());
  }

  @Test
  public void whenPencilWritesMutlipleWordsItLoosesPointsForAllWords() {
    Pencil pencil = new Pencil(20);

    pencil.write(paper, "She sells sea shells");
    EasyMock.expectLastCall();

    EasyMock.replay(paper);
    assertEquals(2, pencil.getPointDurability());
  }

  @Test
  public void whenPencilRunsOutOfPointsItStopsAt0() {
    Pencil pencil = new Pencil(4);

    pencil.write(paper, "Text");
    EasyMock.expectLastCall();

    EasyMock.replay(paper);
    assertEquals(0, pencil.getPointDurability());
  }

  @Test
  public void whenDullPencilIsSharpenedItRegainsDurability() {
    Pencil pencil = new Pencil(4);

    pencil.write(paper, "text");
    EasyMock.expectLastCall();

    EasyMock.replay(paper);

    pencil.sharpen();

    assertEquals(4, pencil.getPointDurability());
  }

  @Test
  public void whenPencilIsSharpenedItsLengthIsReduced() {
    Pencil pencil = new Pencil(4, 10);

    pencil.write(paper, "text");
    EasyMock.expectLastCall();
    EasyMock.replay(paper);

    pencil.sharpen();
    assertEquals(9, pencil.getLength());
  }

  @Test
  public void whenPencilHasNoMoreLengthItCannotBeSharpened() {
    Pencil pencil = new Pencil(4, 1);

    pencil.sharpen();
    pencil.write(paper, "text");
    EasyMock.expectLastCall();
    EasyMock.replay(paper);
    pencil.sharpen();
    
    assertEquals(0, pencil.getLength());
    assertEquals(0, pencil.getPointDurability());
  }
}