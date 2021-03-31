package inverse;

import processing.core.*;

public class Segment {
  public PApplet papp;
  
  public PVector a, b;
  public float len;
  public float angle = 0;
  public float sw = 0;
  
  public Segment parent = null, child = null;
  
  public Segment(PApplet pa, float x, float y, float len_) {
  	papp = pa;
  	
  	a = new PVector(x, y);
  	len = len_;
  	calculateB();
  	sw = len/4;
  }
  
  public Segment(PApplet pa, Segment parent_, float len_) {
  	papp = pa;
  	
  	parent  = parent_;
  	a = parent.b.copy();
  	len = len_;
  	calculateB();
  	sw = len/4;
  }
  
  public void calculateB() {
  	float dx = len*PApplet.cos(angle);
  	float dy = len*PApplet.sin(angle);
  	b = new PVector(a.x+dx, a.y+dy);
  }
  
  public void update() {
  	calculateB();
  }
  
  public void follow() {
  	float tx = child.a.x;
  	float ty = child.a.y;
  	follow(tx, ty);
  }
  
  public void follow(float tx, float ty) {
  	PVector t = new PVector(tx, ty);
  	PVector dir = PVector.sub(t, a);
  	angle = dir.heading();
  	dir.setMag(len);
  	dir.mult(-1);
  	a = PVector.add(t, dir);
  }
  
  public void show() {
  	papp.push();
  	papp.stroke(255);
  	papp.strokeWeight(sw);
  	papp.line(a.x, a.y, b.x, b.y);
  	papp.pop();
  }
}
