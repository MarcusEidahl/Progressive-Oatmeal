package com.mygdx.game.Entities.Projectiles;


import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Levels.Level;

public class SplinterFragment extends Projectile {

    private static final float BASE_SPEED = 300;
    private static final float BASE_DAMAGE = 50;
    private static final float BASE_HEALTH = 10;
    private static final float BASE_RANGE = 800;


    public SplinterFragment(float x, float y, Level level, Vector2 direction, Entity shooter) {
        super(x, y, level, direction, shooter);
    }

    protected void init() {
        sprite = level.game.sprites.bomb_purple_sml;
        radius = 7;
        health = BASE_HEALTH;
        damage = BASE_DAMAGE;
        speed = BASE_SPEED;
        range = BASE_RANGE;
    }

}
