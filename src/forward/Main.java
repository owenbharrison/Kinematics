package forward;

import processing.core.*;
import java.util.ArrayList;

public class Main extends PApplet{
	public ArrayList<Tentacle> tentacles;
	
  public static void main(String[] args) {
  	PApplet.main(new String[] {"kinematics.Main"});
  }
  
  public void settings() {
  	size(600, 400);
  }
  
  public void setup() {
  	tentacles = new ArrayList<Tentacle>();
  	for(int x=0;x<width;x+=15) {
  		tentacles.add(new Tentacle(this, x, height, 30, 0, random(1000), 25));
  	}
  }

  public void draw() {
  	background(0);
  	for(Tentacle t:tentacles) {
  		t.updateAndShow();
  	}
  }
}
