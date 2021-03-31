package forward;

import processing.core.*;

public class Segment {
	public PApplet papp;
	public PVector a, b;
	public float len;
	public float angle, selfAngle, t;
	
	public Segment parent;
	public Segment child;
	
  public Segment(PApplet pa, float x, float y, float len_, float angle_, float t_) {
  	papp = pa;
  	
  	a = new PVector(x, y);
  	len = len_;
  	angle = angle_;
  	calculateB();
  	parent = null;
  	t = t_;
  }
  
  public Segment(PApplet pa, Segment parent_, float len_, float angle_, float t_) {
  	papp = pa;
  	
  	parent = parent_;
  	a = parent.b.copy();
  	len = len_;
  	angle = angle_;
  	selfAngle = angle;
  	calculateB();
  	t = t_;
  }
  
  public void calculateB() {
  	float x = PApplet.cos(angle)*len;
  	float y = PApplet.sin(angle)*len;
  	b = new PVector(x+a.x, y+a.y);
  }
  
  public void wiggle() {
  	selfAngle  = PApplet.map(papp.noise(t), 0, 1, .4f, -.4f);
  	t += 0.03f;
  }
  
  public void update() {
  	angle = selfAngle;
  	if(parent!=null) {
  		a = parent.b.copy();
  		angle += parent.angle;
  	}
  	else {
  		angle += -PApplet.PI/2;
  	}
  	calculateB();
  }
  
  public void show() {
  	papp.push();
  	papp.stroke(255);
  	papp.strokeWeight(len/2);
  	papp.line(a.x, a.y, b.x, b.y);
  	papp.pop();
  }
}
