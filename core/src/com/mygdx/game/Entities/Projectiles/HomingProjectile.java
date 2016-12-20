package com.mygdx.game.Entities.Projectiles;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Levels.Level;


public class HomingProjectile extends Projectile {

    private static final float BASE_SPEED = 125;
    private static final float BASE_DAMAGE = 100;
    private static final float BASE_HEALTH = 10;
    private static final float BASE_TIME_LIMIT = 5;
    private static final float BASE_RANGE = 800;

    private float lifetime;
    private float timelimit;
    private Entity target;

    public HomingProjectile(float x, float y, Level level, Vector2 direction, Entity shooter, Entity target) {
        super(x, y, level, direction, shooter);
        this.target = target;
    }

    protected void init() {
        sprite = level.game.sprites.bomb_purple_lrg;
        radius = 12;
        health = BASE_HEALTH;
        damage = BASE_DAMAGE;
        speed = BASE_SPEED;
        timelimit = BASE_TIME_LIMIT;
        range = BASE_RANGE;
        lifetime = 0;
    }

    public void update(float delta) {
        lifetime += delta;
        direction.x = x - target.x;
        direction.y = y - target.y;
        direction.nor();
        if(health <= 0 || lifetime > timelimit) remove();
        else {
            y -= speed * delta * direction.y;
            x -= speed * delta * direction.x;
            distanceTraveled += speed * delta;
        }
    }


}
