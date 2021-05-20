package main;

import processing.core.PApplet;

public class Hitbox {

    private final PApplet P;
    private final Entity ENTITY;

    public Hitbox(PApplet p, Entity entity) {
        P = p;
        ENTITY = entity;
    }
}
