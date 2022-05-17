import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;

public class Game extends Application {

	public static boolean running = true;
	public final static double HEIGHT = 1000;
	public final static double WIDTH = 1200;
	public static double ballX = WIDTH / 2;
	public static double ballY = HEIGHT - 150;
	public static double paddleX = WIDTH / 2;
	public static double paddleY = HEIGHT - 10;
	private Timeline animation;

	public static final int FRAMES_PER_SECOND = 60;
	public static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;

	private int rows = 7;
	private int collumns = 7;
	private int brickCount = rows * collumns;
	
	private boolean paused = false;
	private boolean ended = false;
	private boolean movingLeft = false;
	private boolean movingRight = false;
	
	private Text lblScore = new Text("score:");
	private Ball ball;
	private Paddle paddle;
	private Scene scene;
	private Brick[][] bricks;
	private static int bricksLeft = 0;
	
	private int frames = 0;

	@Override
	public void start(Stage primaryStage) throws Exception 
	{

		paddle = new Paddle(paddleX, paddleY);
		// brick array
		bricks = new Brick[collumns][rows];
		for (int i = 0; i < collumns; i++) 
		{
			for (int j = 0; j < rows; j++) 
			{
				bricks[i][j] = new Brick(155 * j + 50, 65 * i + 120);
				bricks[i][j].setFill(Color.rgb(235, 103, 52));
				bricksLeft++;
			}
		}

		ball = new Ball(ballX, ballY, paddle, bricks);

		Group root = new Group();
		root.getChildren().addAll(ball, paddle);

		for (Brick[] brickRow : bricks) 
		{
			for (Brick brick : brickRow) 
			{
				root.getChildren().add(brick);
			}
		}

		scene = new Scene(root, WIDTH, HEIGHT);
		primaryStage.setTitle("Breakout");
		primaryStage.setScene(scene);
		primaryStage.show();

		movingRight = false;
		movingLeft = false;
		scene.setOnKeyPressed(e -> handleKeyInput(e.getCode(), root));
		scene.setOnKeyReleased(event -> handleKeyRelease(event.getCode(), root));
		double amountOfTicks = 60.0;
		double ms = 1000 / amountOfTicks;
		KeyFrame frame = new KeyFrame(Duration.millis(ms), this::update);
		animation = new Timeline(amountOfTicks, frame);
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();

	}

	public void update(Event e) 
	{
		if(!paused) 
		{
			if(movingLeft && paddle.getX() > 0) 
			{
				paddle.setX(paddle.getX() - paddle.speed);
			}
			else if(movingRight && paddle.getX() + paddle.LENGTH < WIDTH) 
			{
				paddle.setX(paddle.getX() + paddle.speed);
			}
			ball.update(paddle, bricks);
			if(ball.getCenterY() + ball.SIZE >= HEIGHT || bricksLeft == 0) 
			{
				finish();
			}
			frames ++;
		}
		
	}
	
	public static void breakBrick() 
	{
		bricksLeft--;
	}
	
	public static int sign(double d) 
	{
		if (d <= 0)
			return -1;
		return 1;
	}

	private void handleKeyInput(KeyCode code, Group root) {
		if (code == KeyCode.RIGHT) {
			movingRight = true;
		} else if (code == KeyCode.LEFT) {
			movingLeft = true;
		} 
		if(code == KeyCode.ESCAPE) {
			paused = !paused;
		}
//		if(code == KeyCode.R && ended) 
//		{
//			start();
//		}
	}
	
	private void handleKeyRelease(KeyCode code, Group root) {
		if (code == KeyCode.RIGHT) {
			movingRight = false;
		} else if (code == KeyCode.LEFT) {
			movingLeft = false;
		}
	}

	public void finish() {
		animation.stop();
		ended = true;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
