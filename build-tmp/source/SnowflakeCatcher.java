import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

SnowFlake [] cluster;
public void setup()
{
  size(300,300);//your code here
  background(0);
  cluster = new SnowFlake[1000];
  for (int i = 0; i < cluster.length; i++){
    cluster[i] = new SnowFlake();
  }

}

public void draw()
{
  for(int i = 0; i < cluster.length; i++){
    cluster[i].erase();
    cluster[i].lookDown();
    cluster[i].move();
    cluster[i].wrap();
    cluster[i].show();
  }
  //your code here
}

public void mouseDragged()
{
  if(mouseButton == LEFT){
  noStroke();
  fill(230,250,100);
  ellipse(mouseX, mouseY, 10,10);
} else if(mouseButton == RIGHT){
  fill(0);
  ellipse(mouseX, mouseY, 10,10);
}
}


class SnowFlake
{
  int x, y;
  boolean isMoving;//class member variable declarations
  SnowFlake()
  {
    x = (int)(Math.random()*290);
    y = (int)(Math.random()*290);
    isMoving = true;
    //class member variable initializations
  }
  public void show()
  {
    noStroke();
    fill(255,255,255);
    ellipse( x, y,5,5);
    //your code here
  }
  public void lookDown()
  {
    if(0<y && y<300){
      if(get (x,y+5) != color(0)){
        isMoving = false;
      } else {
        isMoving = true;
      }
    }
    //your code here
  }
  public void erase()
  {
      
      fill(0);
      ellipse(x, y, 8, 8);
    
    
  }
  public void move()
  {
    if(isMoving == true){
      y++;
    }
  }
  public void wrap()
  {
    if(y >= 290){
      y = 0;
      x = (int)(Math.random()*300);
    }//your code here
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
