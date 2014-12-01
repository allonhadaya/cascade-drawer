import processing.core.PApplet;

/**
 * Adapter type for drawing colored lines reflected over the y axis.
 */
public class MirroredLineHandler implements LineHandler {

  private final PApplet applet;

  public MirroredLineHandler(PApplet applet) {
    this.applet = applet;
  }
  
  public void line(int c, int x1, int y1, int x2, int y2) {
    applet.pushStyle();
    applet.stroke(c);
    applet.line(applet.width - x1, y1, applet.width - x2, y2);
    applet.popStyle();
  }
}
