package PencilDurabilityKata;

public class Pencil {
  private int pointDurability;

  public Pencil() {
    this(100);
  }

  public Pencil(int thePointDurability) {
    pointDurability = thePointDurability;
  }

  public void write(Paper paper, String text) {
    int upper = 0;
    int lower = 0;
    for (int i=0; i<text.length(); i++) {
      char c = text.charAt(i);
      if (Character.isUpperCase(c)) 
        upper++;
      if (Character.isLowerCase(c))
        lower++;

      if (pointDurability - upper*2 - lower == 0) {
        paper.addText(text.substring(0, i+1));
        pointDurability = 0;
        return;
      }
    }
    pointDurability -= upper*2 + lower;
    paper.addText(text);
  }

  public int getPointDurability() {
    return pointDurability;
  }
}