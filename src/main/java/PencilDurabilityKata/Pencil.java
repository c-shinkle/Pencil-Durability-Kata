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
    pointDurability -= text.length();
  }

  public int getPointDurability() {
    return pointDurability;
  }
}