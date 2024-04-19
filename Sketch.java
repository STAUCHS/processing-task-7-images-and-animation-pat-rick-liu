import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

public class Sketch extends PApplet {

  // Declare images
  PImage imgLebron;
  PImage imgSun;

  Random myRandom = new Random();
  int intRandomX = myRandom.nextInt(100, 600);
  int intRandomY = myRandom.nextInt(100, 400);

  // X and y coordinates
  float fltSunX = intRandomX;
  float fltSunY = intRandomY;

  float fltCircleX = (100);
  float fltCircleY = (100);

  // Speed variables
  float fltSpeedX = 3;
  float fltSpeedY = 3;

  float fltCircleSpeedX = 3;

  public void settings() {
    size(750, 500);
  }

  public void setup() {
    // Background
    surface.setResizable(true);
    imgLebron = loadImage("lebronsunshinecover-1.png");

    imgSun = loadImage("sunshine.png");
  }

  public void draw() {
    // Scaling images
    imgLebron.resize(width, height);
    imgSun.resize(width / 8 + (int) fltSpeedX, height / 8 + (int) fltSpeedY);
    image(imgLebron, 0, 0);
    image(imgSun, fltSunX, fltSunY);

    fltSunX += fltSpeedX;
    fltSunY += fltSpeedY;

    // Keep sun inside walls
    if (fltSunX > width - imgSun.width || fltSunX < 0) {
      fltSpeedX *= -1.05;
    }
    if (fltSunY > height - imgSun.height || fltSunY < 0) {
      fltSpeedY *= -1.05;
    }

    //Circle color and path
    noStroke();
    int intRed = myRandom.nextInt(255);
    int intGreen = myRandom.nextInt(255);
    int intBlue = myRandom.nextInt(255);
    fill(intRed, intGreen, intBlue);
    ellipse(fltCircleX, fltCircleY, width / 8, height / 8);

    fltCircleX += fltCircleSpeedX;
    fltCircleY = (float) Math.sin(fltCircleX / width * 2 * PI) * 90 + height / 2;

    // Keep circle inside walls

    if (fltCircleX > width * 15 / 16 || fltCircleX < width / 16) {
      fltCircleSpeedX *= -1;
    }

  }
}