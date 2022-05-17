
import javafx.scene.shape.*;

public class Paddle extends Rectangle
{
	
	public final static int LENGTH = 160;
	public final static int HEIGHT = 10;
	public static double xPos = 0;
	public static double yPos = 0;
	public final int speed = 15;
	
	public Paddle(double x, double y) 
	{
		super(x, y, LENGTH, HEIGHT);
	}
	
	

}


