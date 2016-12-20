package com.mygdx.game.Entities.NPCs;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Entities.Projectiles.Projectile;
import com.mygdx.game.Entities.Projectiles.SliderProjectile;
import com.mygdx.game.Entities.Projectiles.SplinterProjectile;
import com.mygdx.game.Levels.Level;


public class SliderEnemy extends NPC {

    private static final float BASE_TIME_BETWEEN_SHOTS = 2f;
    private static final float BASE_SPEED = 50;
    private static final float BASE_HEALTH = 100;

    private float timeBetweenShots;
    private float fireTimer;
    private float speed;
    private int direction;

    public SliderEnemy(float x, float y, Level level, int initDirection) {
        super(x, y, level);
        direction = initDirection;
    }

    protected void init() {
        sprite = level.game.sprites.drone_orange;
        sprite.flip(false, true);
        radius = 13;
        isEnemy = true;
        health = BASE_HEALTH;
        speed = BASE_SPEED;
        timeBetweenShots = BASE_TIME_BETWEEN_SHOTS;
        fireTimer = timeBetweenShots;
    }

    public void update(float delta) {
        if(health <= 0) remove();
        else {
            x += speed * delta * direction;
            if(x > Level.WIDTH - radius || x < radius) direction *= -1;
            shoot();
            fireTimer += delta;
        }
    }

    private void shoot() {
        if(fireTimer >= timeBetweenShots) {
            level.addEntity(new SliderProjectile(x, y - radius, level, new Vector2(0, 1), this));
            fireTimer -= timeBetweenShots;
        }
    }

}
