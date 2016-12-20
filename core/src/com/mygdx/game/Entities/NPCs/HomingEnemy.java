package com.mygdx.game.Entities.NPCs;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Levels.Level;


public class HomingEnemy extends NPC {

    private static final float BASE_TIME_BETWEEN_SHOTS = 3f;
    private static final float BASE_HEALTH = 100;

    private float timeBetweenShots;
    private float fireTimer;
    private Entity target;

    public HomingEnemy(float x, float y, Level level, Entity target) {
        super(x, y, level);
        this.target = target;
    }

    protected void init() {
        sprite = level.game.sprites.drone_orange;
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
            level.addEntity(new com.mygdx.game.Entities.Projectiles.HomingProjectile(x, y - radius, level, new Vector2(x - target.x, y - target.y).nor(), this, target));
            fireTimer -= timeBetweenShots;
        }
    }

}
