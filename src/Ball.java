import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Ball extends Circle
{
	public int bricksChecked = 0;
	public static final int SIZE = 10;
	
	public static double xVel = 1; //value either 1 or -1
	public static double yVel = 1;
	public static int speed = 6;
	
	public Ball(double x, double y, Paddle paddle, Brick[][] bricks) {
		super(x, y, SIZE);
		reset();
		update(paddle, bricks);
	}
	
	private void reset() {
		
		//initial velocities 
		xVel = Game.sign(Math.random() * 2.0 - 1);
		yVel = -1;
	}
	
	public void update(Paddle paddle, Brick[][] bricks) 
	{
		setCenterX(getCenterX() + xVel * speed);
		setCenterY(getCenterY() + yVel * speed);
		checkIfWall(); 
		checkIfPaddle(paddle);
		checkIfBrick(bricks);
//		double speed = (xVel * Game.sign(xVel)) + (yVel * Game.sign(yVel));
		
	}
	
	public void checkIfWall() 
	{
		if((getCenterX()) - SIZE <= 0 || (SIZE + getCenterX() >= Game.WIDTH))
			{
				changeXDir();
			}
		
		if((getCenterY()) - SIZE <= 0 || (SIZE + getCenterY() >= Game.HEIGHT))
			{
				changeYDir();
			}
	}
	
	public void checkIfPaddle(Paddle paddle) 
	{
		if ((getCenterX() + SIZE) >= paddle.getX() && (getCenterX() - SIZE) <= (paddle.getX() + Paddle.LENGTH) && (getCenterY() + SIZE) >= paddle.getY()) 
		{
			bounceOffPaddle(paddle);
		}

	}
	
	public void bounceOffPaddle(Paddle paddle) 
	{
		double maxVel = 2;
//		double xPos = getCenterX();
//		double paddlePos = paddle.getX();
		double position = getCenterX() - paddle.getX();
		double vector = (position - (paddle.LENGTH / 2)) / (paddle.LENGTH / (maxVel * 2));
		xVel = vector;
		yVel = maxVel - vector;
		if(vector < 0) {
			yVel = maxVel + vector;
		}
		if(yVel > 0) {
			changeYDir();
		}
	}
	
	public void checkIfBrick(Brick[][] bricks) 
	{
		for(Brick[] brickRow : bricks){
			for(Brick brick : brickRow) {
				//top of brick
				if((getCenterY() + SIZE) >= brick.getY() && (getCenterY() + SIZE) <= (brick.getY() + (brick.HEIGHT / 2)) && 
						(getCenterX() >= brick.getX() && getCenterX() <= (brick.getX() + brick.WIDTH))) 
				{
					changeYDir();
					brick.Break();
				}
				//bottom of brick
				if((getCenterY() - SIZE) <= (brick.getY() + brick.HEIGHT) && (getCenterY() + SIZE) >= (brick.getY() + (brick.HEIGHT / 2)) && 
						(getCenterX() >= brick.getX() && getCenterX() <= (brick.getX() + brick.WIDTH))) 
				{
					changeYDir();
					brick.Break();
				}
				
				//left side of brick
				if((getCenterX() + SIZE) >= brick.getX() && (getCenterX() + SIZE) <= (brick.getX() + brick.WIDTH / 2) && 
						(getCenterY() >= brick.getY() && getCenterY() <= (brick.getY() + brick.HEIGHT))) 
				{
					changeXDir();
					brick.Break();
				}
				//right side of brick
				if((getCenterX() - SIZE) <= (brick.getX() + brick.WIDTH) && (getCenterX() - SIZE) >= (brick.getX() + brick.WIDTH / 2) && 
						(getCenterY() >= brick.getY() && getCenterY() <= (brick.getY() + brick.HEIGHT))) 
				{
					changeXDir();
					brick.Break();
				}
				bricksChecked ++;
			}
		}
	}
	
	
	public static void changeYDir() {
		yVel *= -1;
	}
	
	public static void changeXDir() {
		xVel *= -1;
	}

}