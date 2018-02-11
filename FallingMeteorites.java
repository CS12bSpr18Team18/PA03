package pa03;

/**
By Ruiyang Hu


*/

public class FallingMeteorites extends CircleShape{

  //Count total time
  private double t=0;

  private int changeinR=0;
  private int changeinGB=0;
  private double radiusBurn=0;

/**
Create a falling meteorite, which color appears to be gray at first
*/
    public FallingMeteorites(){
    this.x=(int)(450*Math.random());
    this.y=(int)(75*Math.random());
    this.radius=20+20*(Math.random());
    this.vy=5+(int)(10*Math.random());
    this.vx=0;
    this.t=0;
    this.color=new java.awt.Color(105+this.changeinR,105-this.changeinGB,105-this.changeinGB);
  }




  public void update(double dt){
    //Slow down the update rate.
    this.t+=dt;


    //Falling speed calculated by a formula
    this.y=0.5*(9.8*this.t+this.vy)*this.t;

    //Simulate color changes of the meteorite when its velocity increases.
    this.changeinR=(int)((this.t*9.8+this.vy)*0.6);
    if(this.changeinR>125){
      this.changeinR=125;
    }
    this.changeinGB=(int)((this.t*9.8+this.vy)*0.8);
    if(this.changeinGB>105){
      this.changeinGB=105;
    }

    //Simulate burning down of a metorite in atmosphere.
    if(this.radius<=5){
      this.radius=5;
    }else{
      this.radius-=dt;
    }

    this.color=new java.awt.Color(105+this.changeinR,105-this.changeinGB,105-this.changeinGB);


    this.keepOnBoard();
  }

/**
  The meteorite will vanish when it is going to touch the left or the bottom.
*/
  public void keepOnBoard(){
    if (this.y > CircleShape.boardHeight-this.radius) {
      // Reset its postion and speed
      this.y = (int)(75*Math.random());
      this.vy=0;
      this.t=0;
      this.changeinR=0;
      this.changeinGB=0;
      this.radius=20+20*(Math.random());
    }
  }

}
