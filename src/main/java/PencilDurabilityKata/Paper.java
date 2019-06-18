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

  public void addText(String text, int start) {
    int end = start+text.length();
    String prevText = content.substring(start, Math.min(end, content.length()));
    StringBuilder edittedText = new StringBuilder();
    int index;

    for (index = 0; index<prevText.length(); index++) {
      char prevCh = prevText.charAt(index);
      char newCh = text.charAt(index);
      if (prevCh == ' ' ) {
        edittedText.append(newCh);
      } else if (newCh == ' ') {
        edittedText.append(prevCh);
      } else {
        edittedText.append('@');
      }
    }

    while (index<text.length()) {
      edittedText.append(text.charAt(index++));
    }

    content.replace(start, end, edittedText.toString());
  }

  public void removeText(int start, int end) {
    for (int i = start; i<end; i++) {
      content.setCharAt(i, ' ');
    }
  }
}