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
    EasyMock.expect(paper.getContent()).andReturn("");
  }

  @Test
  public void whenPencilWritesOnBlankPaperItWritesTextOntoPaper() {
    Pencil pencil = new Pencil();

    paper.addText("She sells sea shells", 0);
    EasyMock.expectLastCall();
    EasyMock.replay(paper);

    pencil.write(paper, "She sells sea shells");
  }

  @Test
  public void whenPencilIsConstructedItHasAPointDurability() {
    Pencil pencil = new Pencil(4);
    assertEquals(4, pencil.getPointDurability());
  }

  @Test
  public void whenPencilWrites4LetterLowercaseWordItLoses4Points() {
    Pencil pencil = new Pencil(4);

    paper.addText("text", 0);
    EasyMock.expectLastCall();
    EasyMock.replay(paper);

    pencil.write(paper, "text");
    assertEquals(0, pencil.getPointDurability());
  }

  @Test
  public void whenPencilWrites4LetterCapitalizedWordItLosses5Points() {
    Pencil pencil = new Pencil(5);

    paper.addText("Text", 0);
    EasyMock.expectLastCall();
    EasyMock.replay(paper);

    pencil.write(paper, "Text");
    assertEquals(0, pencil.getPointDurability());
  }

  @Test
  public void whenPencilWritesMutlipleWordsItLoosesPointsForAllWords() {
    Pencil pencil = new Pencil(20);

    paper.addText("She sells sea shells", 0);
    EasyMock.expectLastCall();
    EasyMock.replay(paper);

    pencil.write(paper, "She sells sea shells");
    assertEquals(2, pencil.getPointDurability());
  }

  @Test
  public void whenPencilRunsOutOfPointsItStopsAt0() {
    Pencil pencil = new Pencil(4);

    paper.addText("Tex ", 0);
    EasyMock.expectLastCall();
    EasyMock.replay(paper);

    pencil.write(paper, "Text");
    assertEquals(0, pencil.getPointDurability());
  }

  @Test
  public void whenDullPencilIsSharpenedItRegainsDurability() {
    Pencil pencil = new Pencil(4);

    paper.addText("text", 0);
    EasyMock.expectLastCall();
    EasyMock.replay(paper);

    pencil.write(paper, "text");
    pencil.sharpen();

    assertEquals(4, pencil.getPointDurability());
  }

  @Test
  public void whenPencilIsSharpenedItsLengthIsReduced() {
    Pencil pencil = new Pencil(4, 10);

    paper.addText("text", 0);
    EasyMock.expectLastCall();
    EasyMock.replay(paper);

    pencil.write(paper, "text");
    pencil.sharpen();
    assertEquals(9, pencil.getLength());
  }

  @Test
  public void whenPencilHasNoMoreLengthItCannotBeSharpened() {
    Pencil pencil = new Pencil(4, 1);

    paper.addText("text", 0);
    EasyMock.expectLastCall();
    EasyMock.replay(paper);
    
    pencil.sharpen();
    pencil.write(paper, "text");
    pencil.sharpen();
    
    assertEquals(0, pencil.getLength());
    assertEquals(0, pencil.getPointDurability());
  }
}