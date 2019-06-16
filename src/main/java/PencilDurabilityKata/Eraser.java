package PencilDurabilityKata;

public class Eraser {

  public void erase(Paper paper, String text) {
    String content = paper.getContent();
    int start = content.lastIndexOf(text);
    int end = start + text.length();
    if (start >= 0)
      paper.removeText(start, end);
  }
}