import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.*;
import java.awt.Color;
import java.awt.Graphics;

public class Brick extends Rectangle{
	
	public static final double WIDTH = 150;
	public static final double HEIGHT = 60;
	
	public Brick(double x, double y)
	{
		super(x, y, WIDTH, HEIGHT);
	}
	
	public void Break() 
	{
		this.setX(10000); 
		this.setY(10000);
		Game.breakBrick();
	}
}
