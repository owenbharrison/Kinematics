package inverse;

import processing.core.*;

public class Main extends PApplet{
	public Segment tentacle;
	
  public static void main(String[] args) {
  	PApplet.main(new String[] {"inverse.Main"});
  }
  
  public void settings() {
  	size(600, 400);
  }
  
  public void setup() {
  	float len = 10;
  	Segment current = new Segment(this, 300, 200, len);
  	
  	for(int i=0;i<20;i++) {
  		Segment next = new Segment(this, current, len);
  		current.child = next;
  		current = next;
  	}
  	tentacle = current;
  }

  public void draw() {
  	background(170);
  	tentacle.follow(mouseX, mouseY);
  	tentacle.update();
  	tentacle.show();
  	Segment next = tentacle.parent;
  	while(next!=null) {
  		next.follow();
  		next.update();
  		next.show();
  		next = next.parent;
  	}
  }
}
