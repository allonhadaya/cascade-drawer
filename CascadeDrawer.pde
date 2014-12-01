Cascade cascade;

void setup() {

  cascade = new Cascade(
  new CompositeLineHandler(new DrawingLineHandler(this), new MirroredLineHandler(this), new TextLineHandler(this)), 
  new Trail(20, color(255, 69, 0)), 
  new Trail(15, color(139, 0, 0)),
  new Trail(30, color(0, 0, 255)),
  new Trail(1, color(0)));

  size(480, 600);
  background(255);
}

void draw() {
  if (pmouseX != mouseX || pmouseY != mouseY) {
    cascade.add(mouseX, mouseY);
  }
}

