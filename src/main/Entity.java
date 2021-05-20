package main;

import processing.core.PApplet;
import processing.core.PVector;

public class Entity {

    private final PApplet P;

    private PVector position;
    private PVector velocity;

    public Entity(PApplet p) {
        this(p, new PVector(0, 0), new PVector(0, 0));
    }

    public Entity(PApplet p, PVector position, PVector velocity) {
        P = p;
        this.position = position;
        this.velocity = velocity;
    }

    public void randomizePosition(PVector topLeftCorner, PVector bottomRightCorner) {
        position = new PVector(
          P.random(topLeftCorner.x, bottomRightCorner.x),
          P.random(topLeftCorner.y, bottomRightCorner.y)
        );
    }

    public void move() {
        position.add(velocity);
    }

    public void draw() {
        P.fill(255);
        P.circle(position.x, position.y, 25);
    }
}
