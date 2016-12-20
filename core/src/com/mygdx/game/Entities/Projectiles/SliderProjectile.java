package com.mygdx.game.Entities.Projectiles;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Levels.Level;


public class SliderProjectile extends Projectile {

    private static final float BASE_SPEED = 100;
    private static final float BASE_DAMAGE = 50;
    private static final float BASE_HEALTH = 10;
    private static final float BASE_RANGE = 800;


    public SliderProjectile(float x, float y, Level level, Vector2 direction, Entity shooter) {
        super(x, y, level, direction, shooter);
    }

    protected void init() {
        sprite = level.game.sprites.bomb_red_lrg;
        radius = 12;
        health = BASE_HEALTH;
        damage = BASE_DAMAGE;
        speed = BASE_SPEED;
        range = BASE_RANGE;
    }
}




