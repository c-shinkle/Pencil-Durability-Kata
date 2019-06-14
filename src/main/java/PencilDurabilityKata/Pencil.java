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
    //I need to count capital and lower case letters
    int upper = 0;
    int lower = 0;
    int lastIndexWithPoints = -1;
    for (int i=0; i<text.length(); i++) {
      char c = text.charAt(i);
      if (Character.isUpperCase(c)) 
        upper++;
      if (Character.isLowerCase(c))
        lower++;

      if (pointDurability - upper*2 - lower == 0) {
        lastIndexWithPoints = i;
      }
    }
    pointDurability = Math.max(0, pointDurability - upper*2 - lower);

    if (lastIndexWithPoints < 0) {
      paper.addText(text);
    } else {
      paper.addText(text.substring(0, lastIndexWithPoints+1));
    }
  }

  public int getPointDurability() {
    return pointDurability;
  }
}