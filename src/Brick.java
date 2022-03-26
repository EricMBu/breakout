import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.*;
import java.awt.Color;
import java.awt.Graphics;

public class Brick extends Rectangle{
	
	public static final double WIDTH = Game.WIDTH / 10;
	public static final double HEIGHT = WIDTH / 2;
	
	public Brick(double x, double y)
	{
		super(x, y, WIDTH, HEIGHT);
	}

}
