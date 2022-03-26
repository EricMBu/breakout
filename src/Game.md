## Class Game

#### public class Game

### Description:
Runs the game objects through the event loop

### Method Summary:

**_All Methods_**

|Modifier and Type  | Method and Description |
|-------------------|------------------------|
| void				| **start**(Stage primaryStage)<br> Builds objects, runs event loop|
| void				| **update**(Event e)<br> Runs update for ball|
| static int		| **sign**(Double d)<br> Generates random integer for ball starting direction|
| void				| **handleKeyInput**(KeyCode code, Group root)<br> Reads input data from keyboard to move paddle|
| void				| **finish**()<br> Ends program|



### Method Detail:

|**_All Methods_**          |
|---------------------------|
|                           |
| ****                 		|
| **start**					|
| public void start(Stage primaryStage) throws Exception<br><br>  * Builds objects, runs event loop<br><br> _Parameters:_<br> primaryStage - tree that stores objects <br><br>_Returns:_<br> n/a  |
| **update**                 |
| public void update(Event e)<br><br>  * Runs update for ball<br><br> _Parameters:_<br> e - event loop <br><br>_Returns:_<br> n/a  |
| **sign**   |
| public static int sign(double d)<br><br>  * Generates random integer for ball starting direction<br><br> _Parameters:_<br> d - random double received from Ball <br><br>_Returns:_<br> integer indicating direction change  |
| **handleKeyInput**   |
| private void handleKeyInput(KeyCode code, Group root)<br><br>  * Reads input data from keyboard to move paddle<br><br> _Parameters:_<br> code - code for specific key <br> root - constructed objects<br><br>_Returns:_<br> n/a  |
| **finish**					|
| public void finish()<br><br>  * Ends program<br><br> _Parameters:_<br> n/a <br><br>_Returns:_<br> n/a  |





