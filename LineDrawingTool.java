/*
 * Name: Alan Wu
 * Pennkey: wualan
 * Recitation: 208
 * 
 * Execution: java LineDrawingTool
 * 
 * Draws a line starting from the previous line (or center if there is no previous
 * line) to the position of the mouse cursor. If the line ends at the top half of
 * the screen it will be red. Otherwise it will be black.
 * 
 */
public class LineDrawingTool {
    public static void main(String[] args) {
        // Defines variable representing the starting coordinates of each new line
        double xValue = 0.5;
        double yValue = 0.5;
        
        // Sets the pen radius to 0.01
        PennDraw.setPenRadius(0.01);

        // Turns on animation
        PennDraw.enableAnimation(30);

        // A constant loop that draws lines as the mouse is pressed
        while (true) {
            // Initializes a boolean to recognizes if the mouse is being pressed
            boolean click = PennDraw.mousePressed();

            // If mouse is being pressed, draws a line with various specifications
            if (click) {
                // Sets the pen color based on y coordinate of mouse
                if (PennDraw.mouseY() >= 0.5) {
                    PennDraw.setPenColor(PennDraw.RED);
                } else {
                    PennDraw.setPenColor(PennDraw.BLACK);
                }
                
                /* Draws the line starting at the end of the previous line, 
                 * Ending at the mouse coordinates
                 */
                PennDraw.line(xValue, yValue, PennDraw.mouseX(), PennDraw.mouseY());
                
                // Sets coordinates of the new starting point
                xValue = PennDraw.mouseX();
                yValue = PennDraw.mouseY();
            }

            // Advance the frame after everything has been drawn for this loop
            PennDraw.advance();
        }
    }
}
