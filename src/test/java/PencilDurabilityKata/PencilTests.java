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

    EasyMock.expect(paper.getContent()).andReturn("She sells sea shells");
    EasyMock.replay(paper);

    
    assertEquals("She sells sea shells", paper.getContent());
  }
}