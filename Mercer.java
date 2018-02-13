package pa03;


/**
 * RadiusChangingCircles are yellow circles which move at a constant velocity
 * on the board and bounce off the edges, but whose radius grows and shrinks.
*/
public class Mercer extends CircleShape{

  private int circleLighting = 1;
  private double vr=2.0;

	/**
	 * create a radius changing circle and set the color to yellow
	 */
  public Mercer(){
    super();
		this.color = new java.awt.Color(255,255,255,100); // transparent blue
  }

	/**
	 * update the circle as usual, but also change the radius. If it gets too big,
	 * then start it shrinking, if it gets too small then start it growing.
	 */
  public void update(double dt){
    // change the properties of the CircleShape after dt seconds have elapsed.

		this.circleLighting *= dt;
    if (dt > 100){
      dt = 1;
    }
    this.color=  new java.awt.Color(circleLighting - 100,circleLighting - 10,circleLighting, 255-circleLighting);

    this.radius += dt*vr;

    if  (this.radius <15) this.vr *= -1;
    else if (this.radius > 60) this.vr *= -2;

    
		super.update(dt);



  }




}
