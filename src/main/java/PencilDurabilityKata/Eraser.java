package PencilDurabilityKata;

public class Eraser {
  private int durability;

  public Eraser() {
    durability = 10;
  }

  public Eraser(int theDurability) {
    durability = theDurability;
  }

  public void erase(Paper paper, String text) {
    String content = paper.getContent();
    int start = content.lastIndexOf(text);
    int end = start + text.length();
    if (start >= 0) {
      if (text.length() > durability) {
        start += text.length() - durability;
      }
  
      paper.removeText(start, end);
      durability = Math.max(0, durability - text.length());
    }
  }

  public int getDurability() {
    return durability;
  }
}