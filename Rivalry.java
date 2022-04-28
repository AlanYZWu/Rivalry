/*
 * Name: Alan Wu
 * Pennkey: wualan
 * Rictation: 208
 * 
 * Execution: java Rivalry
 * 
 * Animates two contestants moving towards a finish line and when one reaches the 
 * finish line, prints that that contestant won
 * 
 */

public class Rivalry {    
    public static void main(String[] args) {
        boolean rivalOneWins = false;       // Has contestant 1 won the race?
        boolean rivalTwoWins = false;  // Has contestant 2 won the race?

        /* the width of 1 pixel in window coordinate
         * use this variable when you get to the movement portion of the program 
         */
        double ONE_PIXEL = 1.0 / 512;   

        // Random values used to decide who moves
        double randomLakers;
        double randomNets;

        // Starting position of contestants
        double xLakers = 0.2; 
        double yLakers = 0.65;
        double xNets = 0.2;
        double yNets = 0.35;

        // enable animation to 10 frames/second
        // TODO - you may change the frame rate to be any speed you like
        PennDraw.enableAnimation(10);
        
        //the loop in which he race takes place
        while (!rivalOneWins && !rivalTwoWins) {
            
            // Clears the drawing
            PennDraw.clear();
            
            // Draws the starting line
            if (xLakers <= 0.4 || xNets <= 0.4) {
                PennDraw.text(0.3, 0.97, "Start");
                PennDraw.line(0.3, 0.95, 0.3, 0.75);
                PennDraw.line(0.3, 0.55, 0.3, 0.45);
                PennDraw.line(0.3, 0.25, 0.3, 0);
            } else {
                PennDraw.text(0.3, 0.97, "Start");
                PennDraw.line(0.3, 0.95, 0.3, 0);
            }
            
            
            // Draws the finish line
            if (xLakers >= 0.7 || xNets >= 0.7) {
                PennDraw.text(0.8, 0.97, "Finish");
                PennDraw.line(0.8, 0.95, 0.8, 0.75);
                PennDraw.line(0.8, 0.55, 0.8, 0.45);
                PennDraw.line(0.8, 0.25, 0.8, 0);
            } else {
                PennDraw.text(0.8, 0.97, "Finish");
                PennDraw.line(0.8, 0.95, 0.8, 0);
            }
            
            //Draws the two contestants
            PennDraw.picture(xLakers, yLakers, "Lakers.png", 100, 100); 
            PennDraw.picture(xNets, yNets, "Nets.png", 100, 100);
            
            // Changes the random value
            randomLakers = Math.random();
            randomNets = Math.random();
            
            // Determine which contestants move
            if (randomLakers <= 0.46) {
                xLakers += ONE_PIXEL;
            } 
            
            if (randomNets <= 0.54) {
                xNets += ONE_PIXEL;
            }
            
            // Checks if either contestant has won
            if (xNets >= 0.8) {
                rivalTwoWins = true;
            } else if (xLakers >= 0.8) {
                rivalOneWins = true;
            }
  
            // show this frame and go on to the next one
            PennDraw.advance(); 
        }
       
        // the race is over so turn off animation
        PennDraw.disableAnimation(); 
        
        // Displays the winning message
        if (rivalTwoWins) {
            PennDraw.text(0.5, 0.5, "Nets Win!");
        } else {
            PennDraw.text(0.5, 0.5, "Lakers Win!");
        }
    }
}