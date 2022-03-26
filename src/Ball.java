import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Ball extends Circle
{
	//ball size
	public static final int SIZE = 10;
	//direction and speed of moving ball
	public static int xVel = 1; //value either 1 or -1
	public static int yVel = 1;
	public static int speed = 5;
	
	private Game game;
	
	/* Eric Buchanan
	 * Ball
	 * Description: constructs ball object
	 * Parameters: double x, double y, Paddle paddle, Game thisGame
	 * Returns nothing
	 */
	public Ball(double x, double y, Paddle paddle, Game thisGame) {
		super(x, y, SIZE);
		//references game
		game = thisGame;
		reset();
		//references paddle
		update(paddle);
	}
	
	/* Eric Buchanan
	 * reset
	 * Description: resets paddle position
	 * Parameters: none
	 * Returns nothing
	 */
	private void reset() {
		
		//initial velocities 
		xVel = Game.sign(Math.random() * 2.0 - 1);
		yVel = Game.sign(Math.random() * 2.0 - 1);
	}
	
	/* Eric Buchanan
	 * update
	 * Description: updates paddle position
	 * Parameters: Paddle paddle
	 * Returns nothing
	 */
	public void update(Paddle paddle) 
	{
		//paddle and wall collision influences included in update
		setCenterX(getCenterX() + xVel * speed);
		setCenterY(getCenterY() + yVel * speed);
		checkIfWall(); 
		checkIfPaddle(paddle);
		
	}
	
	/* Eric Buchanan
	 * checkIfWall
	 * Description: detects if ball hits wall
	 * Parameters: none
	 * Returns nothing
	 */
	public void checkIfWall() 
	{
		//vertical walls
		if((getCenterX()) - SIZE <= 0 || (SIZE + getCenterX() >= Game.WIDTH))
			{
				changeXDir();
			}
		//ceiling
		if((getCenterY()) - SIZE <= 0)
			{
				changeYDir();
			}
		//floor
		if(SIZE + getCenterY() >= Game.HEIGHT) 
		{
			//do not bounce- end game
			game.finish();
		}
	}
	
	/* Eric Buchanan
	 * checkIfPaddle
	 * Description: detects if ball hits paddle
	 * Parameters: Paddle paddle
	 * Returns nothing
	 */
	public void checkIfPaddle(Paddle paddle) 
	{
		//top of paddle
		if ((getCenterX() - SIZE) >= paddle.getX() && (getCenterX() + SIZE) <= (paddle.getX() + Paddle.LENGTH) && (getCenterY() + SIZE) == paddle.getY()) 
		{
			changeYDir();
		}

	}
	
	
	/* Eric Buchanan
	 * changeYDir
	 * Description: changes Y direction of ball
	 * Parameters: none
	 * Returns nothing
	 */
	public static void changeYDir() {
		yVel *= -1;
	}
	
	/* Eric Buchanan
	 * changeXDir
	 * Description: changes X direction of ball
	 * Parameters: none
	 * Returns nothing
	 */
	public static void changeXDir() {
		xVel *= -1;
	}


}
