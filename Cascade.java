import java.util.Deque;
import java.util.ArrayDeque;
import java.awt.Point;

/**
 * A series of trails of different sizes and colors.
 */
public class Cascade {

  private final LineHandler lineHandler;
  private final Trail trail;
  private final Cascade continuation;
  private final Deque<Point> points;
  
  public Cascade(LineHandler lineHandler, Trail... trails) {
    Cascade tail = null;
    for (int i = trails.length - 1; i >= 1; i--) {
      tail = new Cascade(lineHandler, trails[i], tail);
    }
    this.lineHandler = lineHandler;
    this.trail = trails[0];
    this.continuation = tail;
    this.points = new ArrayDeque(this.trail.size);
  }

  private Cascade(LineHandler lineHandler, Trail trail, Cascade continuation) {
    this.lineHandler = lineHandler;
    this.trail = trail;
    this.continuation = continuation;
    this.points = new ArrayDeque(trail.size);
  }

  private boolean hasContinuation() {
    return continuation != null;
  }

  private boolean isFull() {
    return points.size() == trail.size;
  }

  public void add(int x, int y) {

    Point head = points.peekFirst();
    points.addFirst(new Point(x, y));
    if (head != null) {
      lineHandler.draw(trail.c, x, y, head.x, head.y);
    }
    
    if (hasContinuation() && isFull()) {
      Point out = points.removeLast();
      continuation.add(out.x, out.y);
    }
  }
}

