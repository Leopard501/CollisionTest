package main;

import processing.core.PApplet;
import processing.core.PVector;

public class Hitbox {

    private final PApplet P;
    private final Entity ENTITY;
    private final PVector SIZE;

    public Hitbox(PApplet p, Entity entity, PVector size) {
        P = p;
        ENTITY = entity;
        SIZE = size;
    }
}
