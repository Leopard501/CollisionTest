package main;

import processing.core.PApplet;
import processing.core.PVector;

import java.awt.*;

public class Main extends PApplet {

    private static final Color BACKGROUND_COLOR = new Color(0, 10, 30);
    private static final PVector BOARD_SIZE = new PVector(800, 800);
    private static final boolean FULLSCREEN = true;

    private static float matrixScale;
    private static float matrixOffset;

    public static void main(String[] args) {
        PApplet.main("main.Main", args);
    }

    @Override
    public void settings() {
        size((int) BOARD_SIZE.x, (int) BOARD_SIZE.y);
        if (FULLSCREEN) {
            fullScreen();
            noSmooth();
        }
    }

    @Override
    public void setup() {
        matrixScale = height / BOARD_SIZE.y;
        matrixOffset = (width - (BOARD_SIZE.x * matrixScale)) / 2;
    }

    @Override
    public void draw() {
        background(BACKGROUND_COLOR.getRGB());

        pushFullscreen();

        popFullscreen();
    }

    private void pushFullscreen() {
        pushMatrix();
        translate(matrixOffset, 0);
        scale(matrixScale);
    }

    private void popFullscreen() {
        popMatrix();
        drawBlackBars();
    }

    private void drawBlackBars() {
        fill(0);
        noStroke();
        rect(0, 0, matrixOffset, height);
        rect(width - matrixOffset, 0, matrixOffset, height);
    }
}
