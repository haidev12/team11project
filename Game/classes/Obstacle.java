import java.util.Random;

/**
 * @author  Katie Tieu
 * This class is to be used by the Game class.
 * The methods in this class will be used to generate obstacles which the player character must avoid.
 */

public class Obstacle {
  private int obstacle_x_value = 0;
  private int obstacle_y_value = 0;
  private int distanceFromPlayer = 0;
  private Location obstacleLocation = new Location(obstacle_x_value, obstacle_y_value);

  public Obstacle(int x, int y) {
    obstacle_x_value = x;
    obstacle_y_value = y;
  }

  /**
   * This method checks generates the x-coordinate for a new obstacle.
   * The distance from the player is random, but it will always be 1-2 spaces in front of them.
   *
   * @param player_x_value the user's x-coordinate which is used to check if the player has
   * passed the last obstacle and determine the location of the next obstacle
   */
  public void generateTopX(int player_x_value) {
    distanceFromPlayer = new Random().nextInt(2) + 1;
    obstacle_x_value = player_x_value + distanceFromPlayer;
    obstacleLocation.setX(obstacle_x_value);
  }

  /**
   * This method generates the y-coordinate for a new obstacle.
   * This coordinate will either be 0 or 1.
   *
   * @param player_x_value the user's x-coordinate which is used to check if the player has
   * passed the last obstacle
   */
  public void generateTopY() {
    obstacle_y_value = new Random().nextInt(2);
    obstacleLocation.setY(obstacle_y_value);
  }

  /**
   * This method generates the x-coordinate for a second obstacle.
   * This x-coordinate will always be the same as that of the first obstacle.
   *
   * @param other the other (top) obstacle from which the x-coordinate is taken.
   */
  public void generateBottomX(Obstacle other) {
    obstacle_x_value = other.obstacle_x_value;
    obstacleLocation.setX(obstacle_x_value);
  }

  /**
   * This method generates the y-coordinate for a second obstacle.
   * This y-coordinate will always be one higher than that of the first obstacle
   * so as to stack them on top of each other.
   *
   * @param other the other (top) obstacle from which the y-coordinate is taken
   * and added to.
   */
  public void generateBottomY(Obstacle other) {
    obstacle_y_value = other.obstacle_y_value + 1;
    obstacleLocation.setY(obstacle_y_value);
  }

  public Obstacle getObstacle() {
    return new Obstacle(obstacle_x_value, obstacle_y_value);
  }

  /**
   * @return the x-coordinate of the obstacle.
   */
  public int getLocationX(){
    return obstacleLocation.getXCoord();
  }
  /**
   * @return the y-coordinate of the obstacle.
   */
  public int getLocationY(){
    return obstacleLocation.getYCoord();
  }
}