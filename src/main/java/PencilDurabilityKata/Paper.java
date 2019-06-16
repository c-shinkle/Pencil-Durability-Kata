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

  public void removeText(int start, int end) {
    for (int i = start; i<end; i++) {
      content.setCharAt(i, ' ');
    }
  }
}