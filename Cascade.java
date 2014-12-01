import java.util.Deque;
import java.util.ArrayDeque;
import java.awt.Point;

/**
 * A series of trails of different sizes and colors.
 */
public class Cascade {

  /**
   * Adapter type for handling draw calls.
   */
  public interface Handler {
    public void handle(int c, int x1, int y1, int x2, int y2);
  }

  private final Handler handler;
  private final Trail trail;
  private final Cascade continuation;
  private final Deque<Point> points;

  public Cascade(Handler handler, Trail... trails) {
    Cascade tail = null;
    for (int i = trails.length - 1; i >= 1; i--) {
      tail = new Cascade(handler, trails[i], tail);
    }
    this.handler = handler;
    this.trail = trails[0];
    this.continuation = tail;
    this.points = new ArrayDeque(this.trail.size);
  }

  private Cascade(Handler handler, Trail trail, Cascade continuation) {
    this.handler = handler;
    this.trail = trail;
    this.continuation = continuation;
    this.points = new ArrayDeque(trail.size);
  }

  public void add(int x, int y) {

    // shuffle in
    Point oldFirst = points.peekFirst();
    Point newFirst = new Point(x, y);
    points.addFirst(newFirst);
    
    // draw
    if (oldFirst != null) {
      handler.handle(
        trail.c,
        oldFirst.x, oldFirst.y,
        newFirst.x, newFirst.y);
    }
    
    // shuffle out
    if (isFull()) {
      Point old = points.removeLast();
      if (hasContinuation()) {
        continuation.add(old.x, old.y);
      }
    }
  }

  private boolean isFull() {
    return points.size() == trail.size;
  }

  private boolean hasContinuation() {
    return continuation != null;
  }
}

