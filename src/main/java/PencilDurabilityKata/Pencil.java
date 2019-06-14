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
    paper.addText(text);
    //I need to count capital and lower case letters
    int upper = 0;
    int lower = 0;
    for (int i=0; i<text.length(); i++) {
      char c = text.charAt(i);
      if (Character.isUpperCase(c)) 
        upper++;
      if (Character.isLowerCase(c))
        lower++;
    }
    pointDurability -= upper*2 + lower;
  }

  public int getPointDurability() {
    return pointDurability;
  }
}