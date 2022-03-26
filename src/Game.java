import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

public class Game extends Application {
	
	//initializing global variables
	public final static double HEIGHT = 800;
	public final static double WIDTH = 1200;
	public static double ballX = WIDTH / 2;
	public static double ballY = HEIGHT / 2;
	public static double paddleX = WIDTH / 2;
	public static double paddleY = HEIGHT - 55;
	//animation timeline
	private Timeline animation;
	
	//animation data
	public static final int FRAMES_PER_SECOND = 60;
	public static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	
	//gets object classes
	private Ball ball;
	private Paddle paddle;
	private Scene scene;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//constructs new paddle and ball
		paddle = new Paddle(paddleX, paddleY);
		ball = new Ball(ballX, ballY, paddle, this);
		//stores everything in a group (tree data set)
		Group root = new Group();
		root.getChildren().addAll(ball, paddle);
		//set scene
		scene = new Scene(root, WIDTH, HEIGHT);
	    primaryStage.setTitle("Breakout");
	    primaryStage.setScene(scene); 
	    primaryStage.show();
	    //key input receiver
	    scene.setOnKeyPressed(e -> handleKeyInput(e.getCode(), root));
	    //event loop for animation
		double amountOfTicks = 30.0;
		double ms = 1000 / amountOfTicks;
		KeyFrame frame = new KeyFrame(Duration.millis(ms), this::update);
		animation = new Timeline(amountOfTicks, frame);
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
		
		
	}
	
	/* Eric Buchanan
	 * update
	 * Description: updates ball
	 * Parameters: Event e
	 * Returns nothing
	 */
	public void update(Event e) 
	{
		ball.update(paddle);
	}
	
	/* Eric Buchanan
	 * sign
	 * Description: creates random direction for ball
	 * Parameters: double d
	 * Returns integer value indicating direction
	 */
	public static int sign(double d) {
		//multiplies whatever is sent by -1
		if (d <= 0) 
			return -1;
		return 1;
	}
	
	
	/* Eric Buchanan
	 * handleKeyInpute
	 * Description: interprets key input to move paddle
	 * Parameters: KeyCode code, Group root
	 * Returns nothing
	 */
	private void handleKeyInput(KeyCode code, Group root) 
	{
		//key listener for left and right
		if (code == KeyCode.RIGHT) 
		{
			paddle.setX(paddle.getX() + paddle.speed);
		} 
		else if (code == KeyCode.LEFT) 
		{
			paddle.setX(paddle.getX() - paddle.speed);
		}
	}
	
	/* Eric Buchanan
	 * finish
	 * Description: ends program
	 * Parameters: none
	 * Returns nothing
	 */
	public void finish() 
	{
		//ends program
		animation.stop();
	}
	//launches program
	public static void main(String[] args) {
		launch(args);
	}

}
