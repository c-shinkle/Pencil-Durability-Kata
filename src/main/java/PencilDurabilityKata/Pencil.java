package PencilDurabilityKata;

public class Pencil {
  private int pointDurability;

  private final int maxDurability;

  public Pencil() {
    this(100);
  }

  public Pencil(int thePointDurability) {
    maxDurability = pointDurability = thePointDurability;
  }

  public void write(Paper paper, String text) {
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
        paper.addText(sb.toString());
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
    paper.addText(text);
  }

  public int getPointDurability() {
    return pointDurability;
  }

  public void sharpen() {
    pointDurability = maxDurability;
  }
}