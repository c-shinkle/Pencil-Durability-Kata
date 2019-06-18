package PencilDurabilityKata;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PaperTests {

  @Test
  public void whenConstructingABlankPaperItsContentsReturnBlank() {
    Paper paper = new Paper();
    assertEquals("", paper.getContent());
  }

  @Test
  public void whenConstructingAPaperWithTextItsContentsReturnText() {
    Paper paper = new Paper("She sells sea shells");
    assertEquals("She sells sea shells", paper.getContent());
  }

  @Test
  public void whenAddingTextToPaperItAppendsToContent() {
    Paper paper = new Paper("Pied Piper picked");
    paper.addText(" a pack of peppers", 17);
    assertEquals("Pied Piper picked a pack of peppers", paper.getContent());
  }

  @Test
  public void whenPencilWritesTextItAddsTextToPaper() {
    Paper paper = new Paper();
    Pencil pencil = new Pencil();
    pencil.write(paper, "This is text.");
    
    assertEquals("This is text.", paper.getContent());
  }

  @Test
  public void whenPencilRunsOutOfPointsItStopsWriting() {
    Paper paper = new Paper();
    Pencil pencil = new Pencil(3);

    pencil.write(paper, "text");
    assertEquals("tex ", paper.getContent());
  }

  @Test
  public void whenPencilHasNoPointsItWritesNothing() {
    Paper paper = new Paper();
    Pencil pencil = new Pencil(0);

    pencil.write(paper, "text");
    assertEquals("    ", paper.getContent());
  }

  @Test
  public void whenEraserErasesAWordPaperLosesWord() {
    Paper paper = new Paper("She sells sea shells");
    Eraser eraser = new Eraser();

    eraser.erase(paper, "shells");
    assertEquals("She sells sea       ", paper.getContent());
  }

  @Test
  public void whenEraserErasesAWordTwicePaperLosesBothWords() {
    Paper paper = new Paper("Woodchuck could chuck wood");
    Eraser eraser = new Eraser();

    eraser.erase(paper, "chuck");
    eraser.erase(paper, "chuck");
    assertEquals("Wood      could       wood", paper.getContent());
  }

  @Test
  public void whenEraserRunsOutOfDurabilityItStopsRemovingText() {
    Paper paper = new Paper("Buffalo Bill");
    Eraser eraser = new Eraser(3);

    eraser.erase(paper, "Bill");
    assertEquals("Buffalo B   ", paper.getContent());
  }

  @Test
  public void whenPencilEditsTextItAddsTextToWhiteSpace() {
    Paper paper = new Paper("An       a day keeps the doctor away");
    Pencil pencil = new Pencil();

    pencil.write(paper, "onion", 3);
    assertEquals("An onion a day keeps the doctor away", paper.getContent());
  }

  @Test
  public void whenPencilEditsTextItAddsAtSymbolsToPreexistingChars() {
    Paper paper = new Paper("An       a day keeps the doctor away");
    Pencil pencil = new Pencil();

    pencil.write(paper, "artichoke", 3);
    assertEquals("An artich@k@ay keeps the doctor away", paper.getContent());
  }

  @Test
  public void whenPencilRunsOutOfDurabilityWhileEdittingItStopsWriting() {
    Paper paper = new Paper("An       a day keeps the doctor away");
    Pencil pencil = new Pencil(8);

    pencil.write(paper, "artichoke", 3);
    assertEquals("An artich@kday keeps the doctor away", paper.getContent());
  }
}