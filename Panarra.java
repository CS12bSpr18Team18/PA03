package pa03;


/**
 Made By Colin Panarra
 */

public class Panarra extends pa03.CircleShape {
    //creates two instance variables that change both color and position
    private int colorChange;
    private double positionChange;



    public Panarra(){
        super();
        //gives colorchange a value
        this.colorChange=5;

    }

    /**
     *Shows all the circles at the bottom
     * while the color is changing and then the radius variable causes them all to disappear and then show up with
     * changing radius sizes while moving upwards
     */
    public void update(double dt){

        colorChange+=1;
        this.color=  new java.awt.Color(colorChange,255-colorChange,colorChange, 255-colorChange);
        if(colorChange==255) { colorChange = 0; }

        positionChange +=1;

        if (positionChange ==100) {positionChange =0;}
        radius = colorChange/positionChange+80;

        this.y =500-5*positionChange;




        keepOnBoard();


    }




}
