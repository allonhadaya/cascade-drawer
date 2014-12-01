import processing.core.PApplet;

/**
 * Adapter type for printing line info.
 */
public class TextLineHandler implements LineHandler {

  private final PApplet applet;

  public TextLineHandler(PApplet applet) {
    this.applet = applet;
  }
  
  public void line(int c, int x1, int y1, int x2, int y2) {
    applet.println(
    "Drawing a line from (" +
    x1 + ", " + y1 +
    ") to (" +
    x2 + ", " + y2 +
    ") in the color, " +
    c +
    ".");
  }
}
