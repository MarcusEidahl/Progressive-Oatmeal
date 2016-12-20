package com.mygdx.game.Entities.Projectiles;


import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Levels.Level;

public class SplinterProjectile extends Projectile {

    private static final float BASE_SPEED = 75;
    private static final float BASE_DAMAGE = 50;
    private static final float BASE_HEALTH = 10;
    private static final float BASE_RANGE = 800;
    private static final float BASE_EXPLOSION_DISTANCE = 300;
    private static final int EXPLOSION_DISTANCE_VARIANCE = 100;

    private float explosionDistance;


    public SplinterProjectile(float x, float y, Level level, Vector2 direction, Entity shooter) {
        super(x, y, level, direction, shooter);
    }

    protected void init() {
        sprite = level.game.sprites.bomb_yellow_lrg;
        radius = 12;
        health = BASE_HEALTH;
        damage = BASE_DAMAGE;
        speed = BASE_SPEED;
        range = BASE_RANGE;
        explosionDistance = BASE_EXPLOSION_DISTANCE + level.game.rand.nextInt(EXPLOSION_DISTANCE_VARIANCE);
    }

    public void update(float delta) {
        super.update(delta);
        if(distanceTraveled > explosionDistance) {
            remove();
            level.addEntity(new SplinterFragment(x, y, level, new Vector2(.5f, .5f).nor(), shooter));
            level.addEntity(new SplinterFragment(x, y, level, new Vector2(-.5f, .5f).nor(), shooter));
            level.addEntity(new SplinterFragment(x, y, level, new Vector2(.5f, -.5f).nor(), shooter));
            level.addEntity(new SplinterFragment(x, y, level, new Vector2(-.5f, -.5f).nor(), shooter));
        }
    }
}
