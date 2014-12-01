import processing.core.PApplet;

/**
 * Adapter type for drawing colored lines.
 */
public class DrawingLineHandler implements LineHandler {

  private final PApplet applet;

  public DrawingLineHandler(PApplet applet) {
    this.applet = applet;
  }
  
  public void line(int c, int x1, int y1, int x2, int y2) {
    applet.pushStyle();
    applet.stroke(c);
    applet.line(x1, y1, x2, y2);
    applet.popStyle();
  }
}
