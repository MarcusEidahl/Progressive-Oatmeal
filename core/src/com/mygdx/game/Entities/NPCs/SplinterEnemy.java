package com.mygdx.game.Entities.NPCs;


import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Entities.Projectiles.SplinterProjectile;
import com.mygdx.game.Levels.Level;

public class SplinterEnemy extends NPC {

    private static final float BASE_TIME_BETWEEN_SHOTS = 3f;
    private static final float BASE_HEALTH = 100;

    private float timeBetweenShots;
    private float fireTimer;

    public SplinterEnemy(float x, float y, Level level) {
        super(x, y, level);
    }

    protected void init() {
        sprite = level.game.sprites.drone_green;
        sprite.flip(false, true);
        radius = 13;
        isEnemy = true;
        health = BASE_HEALTH;
        timeBetweenShots = BASE_TIME_BETWEEN_SHOTS;
        fireTimer = timeBetweenShots;
    }

    public void update(float delta) {
        if(health <= 0) remove();
        else {
            shoot();
            fireTimer += delta;
        }
    }

    private void shoot() {
        if(fireTimer >= timeBetweenShots) {
            level.addEntity(new SplinterProjectile(x, y - radius, level, new Vector2(0, 1), this));
            fireTimer -= timeBetweenShots;
        }
    }

}

