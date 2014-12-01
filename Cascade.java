import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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
    this(handler, new ArrayDeque(Arrays.asList(trails)));
  }
  
  private Cascade(Handler handler, Deque<Trail> trails) {
    this.handler = handler;
    this.trail = trails.removeFirst();
    this.points = new ArrayDeque(this.trail.size);
    this.continuation = trails.isEmpty() ? null : new Cascade(handler, trails);
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
        // recurse
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

