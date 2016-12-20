package com.mygdx.game.Entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Levels.Level;


public abstract class Entity {

    public boolean isRemoved;
    public float health;
    public float x;
    public float y;
    public float radius;
    public Level level;
    public Sprite sprite;
    public boolean isEnemy;

    //This must be implemented to intialize values such as the sprite, radius, health, etc
    protected abstract void init();

    //This is the method that runs every frame. Logic to control each entity goes here
    public abstract void update(float delta);

    protected Entity(float x, float y, Level level) {
        this.x = x;
        this.y = y;
        this.level = level;
        isRemoved = false;
        init();
    }

    //Call this to flag any entity for removal
    public void remove() {
        isRemoved = true;
    }

}
