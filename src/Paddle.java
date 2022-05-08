
import javafx.scene.shape.*;

public class Paddle extends Rectangle
{
	
	public final static int LENGTH = 120;
	public final static int HEIGHT = 10;
	public static double xPos = 0;
	public static double yPos = 0;
	public final int speed = LENGTH / 2;
	
	public Paddle(double x, double y) 
	{
		super(x, y, LENGTH, HEIGHT);
	}
	
	

}


