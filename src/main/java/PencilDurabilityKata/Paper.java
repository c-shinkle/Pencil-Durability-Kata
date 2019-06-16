package PencilDurabilityKata;

public class Paper {
  private StringBuilder content;

  public Paper() {
    this("");
  }

  public Paper(String startingContent) {
    content = new StringBuilder(startingContent);
  }

  public String getContent() {
    return content.toString();
  }

  public void addText(String text) {
    content.append(text);
  }

  public void removeText(String text) {
    int start = content.lastIndexOf(text);
    if (start >= 0) {
      int end = start + text.length();
      for (int i = start; i<end; i++) {
        content.setCharAt(i, ' ');
      }
    }
  }
}