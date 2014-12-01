/**
 * A configuration type used to indicate trails in a cascade
 *
 * @see Cascade
 */
class Trail {

  public final int size;
  public final int c;

  /**
   * Indicate a terminal trail color
   *
   * @param c the color used for the terminal trail
   */
  public Trail(int c) {
    this(2, c);
  }

  /**
   * Indicate a trail of a certain length
   *
   * @param size the size, in point changes, of this trail
   * @param c    the color used for this trail
   */
  public Trail(int size, int c) {
    this.size = size;
    this.c = c;
  }
}

