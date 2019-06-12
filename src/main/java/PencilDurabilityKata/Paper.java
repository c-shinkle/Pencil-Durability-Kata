package PencilDurabilityKata;

public class Paper {
  private String content;

  public Paper() {
    this("");
  }

  public Paper(String startingContent) {
    content = startingContent;
  }

  public String getContent() {
    return content;
  }
}