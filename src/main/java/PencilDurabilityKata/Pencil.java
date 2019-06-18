package PencilDurabilityKata;

public class Pencil {
  private int pointDurability, length;

  private final int maxDurability;

  private Eraser eraser;

  public Pencil() {
    this(100, 5, 3);
  }

  public Pencil(int thePointDurability) {
    this(thePointDurability, 5, 3);
  }

  public Pencil(int thePointDurability, int theLength) {
    this(thePointDurability, theLength, 3);
  }

  public Pencil(int thePointDurability, int theLength, int eraserDurability) {
    maxDurability = pointDurability = thePointDurability;
    length = theLength;
    eraser = new Eraser(eraserDurability);
  }

  public void write(Paper paper, String text) {
    write(paper, text, paper.getContent().length());
  }

  public void write(Paper paper, String text, int startIndex) {
    int upper = 0;
    int lower = 0;
    for (int i=0; i<text.length(); i++) {
      if (pointDurability - upper*2 - lower == 0) {
        StringBuilder sb = new StringBuilder(text.substring(0, i));
        for (; i<text.length(); i++) {
          char c = text.charAt(i);
          if (Character.isWhitespace(c))
            sb.append(c);
          else
            sb.append(' ');
        }
        paper.addText(sb.toString(), startIndex);
        pointDurability = 0;
        return;
      }

      char c = text.charAt(i);
      if (Character.isUpperCase(c)) 
        upper++;
      if (Character.isLowerCase(c))
        lower++;
    }
    pointDurability -= upper*2 + lower;
    paper.addText(text, startIndex);
  }

  public int getPointDurability() {
    return pointDurability;
  }

  public void sharpen() {
    if (length > 0) {
      pointDurability = maxDurability;
      length--;
    }
  }

  public int getLength() {
    return length;
  }

  public Eraser getEraser() {
    return eraser;
  }
}