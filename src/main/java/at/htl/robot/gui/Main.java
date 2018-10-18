package at.htl.robot.gui;

import at.htl.robot.model.Robot;
import processing.core.PApplet;


public class Main extends PApplet {

    // Hier die Member-Attribute eintragen
    int marginLeft = 50;
    int marginRight = 50;
    int marginTop = 50;
    int marginBottom = 50;
    int boxHeight;
    int boxWidth;
    Robot myRobot = new Robot();


    public static void main(String[] args) {
        PApplet.main("at.htl.robot.gui.Main", args);
    }

    public void settings() {
        size(800, 800);
        boxWidth = (width - marginLeft - marginRight) / 10;
        boxHeight = (height - marginTop - marginBottom) / 10;

        myRobot.setX(3);
        myRobot.setY(2);
    }

    public void setup() {
        background(g.backgroundColor);
    }

    /**
     * Diese Methode wird iterativ durchlaufen (wie loop() beim Arduino)
     */
    public void draw() {

        deleteAll();

        // draw horizontal lines
        for (int i = 0; i <= 10; i++) {
            line(marginLeft, marginTop + i * boxHeight, width - marginRight, marginTop + i * boxHeight);
        }

        //draw vertical lines
        for (int i = 0; i <= 10; i++) {
            line(marginLeft + i * boxWidth, marginTop, marginLeft + i * boxWidth, height - marginBottom);
        }

        drawRobot(myRobot);
    }

    /**
     * Erstellen Sie eine eigene Methode, mittels der der Roboter am Bildschirm gezeichnet wird
     * Die Angabe zu Position des Roboters am Spielfeld erhalten Sie aus dem Roboter-Objekt, welches
     * als Parameter übergeben wird.
     *
     * @param robot Objekt des zu zeichnenden Roboters
     */
    public void drawRobot(Robot robot) {
        int centerX = marginLeft + robot.getX() * boxWidth - boxWidth/2;
        int centerY = marginTop + robot.getY() * boxHeight - boxHeight/2;
        ellipse(centerX, centerY, boxWidth * 0.8f, boxHeight * 0.8f);

    }

    /**
     * Erstellen Sie eine eigene Methode zum Löschen des Bildschirms
     */
    public void deleteAll() {
        background(209);
    }

    /**
     * In dieser Methode reagieren Sie auf die Tasten
     */
    public void keyPressed() {
        println("pressed " + key + " " + keyCode);

        if (key == 'f' || key == 'F') {
            myRobot.stepForward();
        } else if (key == 'l' || key == 'L') {
            myRobot.rotateLeft();
        }
    }

//    public void keyTyped() {
//        println("typed " + key + " " + keyCode);
//    }
//
//    public void keyReleased() {
//        println("released " + key + " " + keyCode);
//    }

}
