SnowFlake [] cluster;
void setup()
{
  size(300,300);//your code here
  background(0);
  cluster = new SnowFlake[100];
  for (int i = 0; i < cluster.length; i++){
    cluster[i] = new SnowFlake();
  }

}

void draw()
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

void mouseDragged()
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
  void show()
  {
    noStroke();
    fill(255,255,255);
    ellipse( x, y,5,5);
    //your code here
  }
  void lookDown()
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
  void erase()
  {
      
      fill(0);
      ellipse(x, y, 8, 8);
    
    
  }
  void move()
  {
    if(isMoving == true){
      y++;
    }
  }
  void wrap()
  {
    if(y >= 290){
      y = 0;
      x = (int)(Math.random()*300);
    }//your code here
  }
}


