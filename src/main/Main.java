package main;

import processing.core.PApplet;
import processing.core.PVector;

import java.awt.*;
import java.util.ArrayList;

public class Main extends PApplet {

    private static final Color BACKGROUND_COLOR = new Color(0, 10, 30);
    private static final PVector BOARD_SIZE = new PVector(800, 800);
    private static final boolean FULLSCREEN = true;

    private static float matrixScale;
    private static float matrixOffset;

    public static ArrayList<Entity> entities;

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

        entities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Entity entity = new Entity(this);
            entities.add(entity);
            PVector buffer = new PVector(BOARD_SIZE.x / 10, BOARD_SIZE.y / 10);
            entity.randomizePosition(
              new PVector(buffer.x, buffer.y),
              new PVector(BOARD_SIZE.x - buffer.x, BOARD_SIZE.y - buffer.y)
            );
        }
    }

    @Override
    public void draw() {
        background(BACKGROUND_COLOR.getRGB());

        pushFullscreen();

        for (int i = entities.size() - 1; i >= 0; i--) {
            Entity entity = entities.get(i);
            entity.draw();
            entity.move();
        }

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
