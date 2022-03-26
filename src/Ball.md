## Class Ball

#### public class Ball

### Description:
Reusable object method that generates a ball 

### Method Summary:

**_All Methods_**

|Modifier and Type  | Method and Description |
|-------------------|------------------------|
| ball				| **ball**(double x, double y, Paddle paddle)<br> Constructor for ball|
| void				| **reset**()<br> Resets the position of the ball to starting position|
| void				| **update**(Paddle paddle)<br> Updates the position of the ball each frame|
| void				| **checkIfWall**()<br> Detects if ball has hit sides of game scene|
| void				| **checkIfPaddle**(Paddle paddle)<br> Detects if ball has collided with paddle|
| void				| **changeYDir**()<br> Changes Y direction of the ball|
| void				| **changeXDir**()<br> Changes X direction of the ball|


### Method Detail:

|**_All Methods_**          |
|---------------------------|
|                           |
| ****                 		|
| **ball**					|
| public Ball(double x, double y, Paddle paddle)<br><br>  * Constructor for ball<br><br> _Parameters:_<br> x - x position for ball to be drawn<br> y - y position for ball to be drawn<br> paddle - paddle reference for ball to interact with paddle<br> game - reference of game to end program <br><br>_Returns:_<br> n/a  |
| **reset**                 |
| private void reset()<br><br>  * Resets the position of the ball to starting position<br><br> _Parameters:_<br> n/a <br><br>_Returns:_<br> n/a  |
| **update**   |
| public void update(Paddle paddle)<br><br>  * Updates the position of the ball each frame<br><br> _Parameters:_<br> paddle - reference to paddle <br><br>_Returns:_<br> n/a  |
| **checkIfWall**   |
|public void checkIfWall()<br><br>  * Detects if ball has hit sides of game scene<br><br> _Parameters:_<br> n/a <br><br>_Returns:_<br> n/a  |
| **checkIfPaddle**  |
| public void checkIfPaddle(Paddle paddle)<br><br>  * Detects if ball has collided with paddle<br><br> _Parameters:_<br> paddle - paddle to reference for collision<br><br>_Returns:_<br> n/a  |
| **changeYDir** |
| public static void changeYDir()<br><br> * Changes Y direction of the ball<br><br>_Parameters:_<br> n/a <br><br>_Returns:_<br> n/a  |
| **changeXDir** |
| public static void changeXDir()<br><br> * Changes X direction of the ball<br><br>_Parameters:_<br> n/a <br><br>_Returns:_<br> n/a  |





