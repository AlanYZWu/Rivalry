/*
 * Name: Alan Wu
 * Pennkey: wualan
 * Recitation: 208
 * 
 * Execution: java LetterViewer
 * 
 * Draws the most recently pressed key on the canvas
 */

public class LetterViewer {
    public static void main(String[] args) {
        
        // Defining variables used later
        boolean press; // Has a key been pressed?
        char key; // Stores which key has been pressed
        String letter = ""; // Stores value of key press and used for printing
        
        // Sets the font size to 64
        PennDraw.setFontSize(64);

        // Turns on animation
        PennDraw.enableAnimation(30);

        // Constant loop that checks for key presses and then prints them
        while (true) {
            
            // Checks that a key has been pressed
            press = PennDraw.hasNextKeyTyped();
            
            // If a key is pressed, stores the pressed value as as string
            if (press) {
                key = PennDraw.nextKeyTyped();
                letter = "" + key;
            }

            // Clears canvas and then draws the most recently pressed character
            PennDraw.clear();
            PennDraw.text(0.5, 0.5, letter);

            // Advances the frame after everything has been drawn for this loop
            PennDraw.advance();
        }
    }
}