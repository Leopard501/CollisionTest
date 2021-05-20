package main.hitboxes;

import main.Entity;
import main.utilities.Constants;
import processing.core.PApplet;
import processing.core.PVector;

public class Hitbox {

    private final PApplet P;
    private final Entity ENTITY;
    private final PVector SIZE;
    private final int TYPE;

    public Hitbox(PApplet p, Entity entity, PVector size, int type) {
        P = p;
        ENTITY = entity;
        SIZE = size;
        TYPE = type;
    }

    public void checkCollision() {
        boolean colliding = false;
        if (colliding) {
            if (TYPE == Constants.PHYSICAL) physicalCollision();
            if (TYPE == Constants.TRIGGER) triggerCollision();
        }
    }

    private void physicalCollision() {
        System.out.println("Physical collision!");
    }

    private void triggerCollision() {
        System.out.println("Trigger collision!");
    }
}
