package forward;

import processing.core.*;

public class Tentacle{
	public PApplet papp;
	
  public Segment main;
	
  public Tentacle(PApplet pa, float x, float y, float sl, float r, float st, float sz) {
  	papp = pa;
  	
  	float t = st;
  	float len = sl;
  	main = new Segment(papp, x, y, sl, r, t);
  	Segment current = main;
    for(int i=0;i<sz-1;i++) {
    	t += 0.1f;
    	len *= 0.9f;
    	Segment next = new Segment(papp, current, len, 0, t);
    	current.child = next;
    	current = next;
    }
  }
  
  public void updateAndShow() {
  	Segment next = main;
  	while(next!=null) {
  		next.wiggle();
  		next.update();
  		next.show();
  		next = next.child;
  	}
  }
}
