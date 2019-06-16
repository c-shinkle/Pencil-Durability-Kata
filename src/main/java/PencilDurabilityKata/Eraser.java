package PencilDurabilityKata;

public class Eraser {
  private int durability;

  public Eraser() {
    durability = 3;
  }

  public Eraser(int theDurability) {
    durability = theDurability;
  }

  public void erase(Paper paper, String text) {
    String content = paper.getContent();
    int start = content.lastIndexOf(text);
    int end = start + text.length();
    if (start >= 0)
      paper.removeText(start, end);
  }

  public int getDurability() {
    return durability;
  }
}