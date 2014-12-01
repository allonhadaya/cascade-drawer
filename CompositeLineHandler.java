public class CompositeLineHandler implements LineHandler {

  private final LineHandler[] lineHandlers;

  public CompositeLineHandler(LineHandler... lineHandlers) {
    this.lineHandlers = lineHandlers;
  }

  public void line(int c, int x1, int y1, int x2, int y2) {
    for (LineHandler lineHandler : lineHandlers) {
      lineHandler.line(c, x1, y1, x2, y2);
    }
  }
}

