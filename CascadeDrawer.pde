Cascade cascade;

void setup() {
  
  cascade = new Cascade(
  // drawing behavior
  new LineHandler() {
    @Override
    public void draw(int c, int x1, int y1, int x2, int y2) {
      println("Drawing a line from (" + x1 + ", " + y1 + ") to (" + x2 + ", " + y2 + ") in the color, " + c + ".");
      pushStyle();
      stroke(c);
      line(x1, y1, x2, y2);
      line(width - x1, y1, width - x2, y2);
      popStyle();
    }
  },
  // red for 20
  new Trail(20, color(255, 69, 0)),
  // red-brown for 15
  new Trail(15, color(139, 0, 0)),
  // blue for 30
  new Trail(30, color(0, 0, 255)),
  // end in black
  new Trail(color(0)));

  size(480, 600);
  background(255);
}

void draw() {
  if (pmouseX != mouseX || pmouseY != mouseY) {
    cascade.add(mouseX, mouseY);
  }
}

