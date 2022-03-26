
import javafx.scene.shape.*;

public class Paddle extends Rectangle
{
	//global variables
	public final static int LENGTH = 80;
	public final static int HEIGHT = 10;
	public static double xPos = 0;
	public static double yPos = 0;
	public final int speed = LENGTH / 2;
	
	/* Eric Buchanan
	 * Paddle
	 * Description: constructs paddle object
	 * Parameters: double x, double y
	 * Returns nothing
	 */
	public Paddle(double x, double y) 
	{
		super(x, y, LENGTH, HEIGHT);
	}
	

}


