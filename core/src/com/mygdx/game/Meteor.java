package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import static com.badlogic.gdx.math.MathUtils.random;

/**
 * Created by manlai on 10/12/2017.
 */

public class Meteor
{

    private Vector2 position;
    private Vector2 velocity;
    private ExtendViewport viewport;

    public Meteor(ExtendViewport viewport)
    {
        this.viewport = viewport;
        init();
    }

    public void updateMeteorPosition(float delta)
    {
        velocity.y += Constants.METEOR_ACCELERATION * delta;
        position.y += velocity.y * delta;
    }

    private void init()
    {
        position = new Vector2(random.nextFloat() * (viewport.getWorldWidth() - 2 * 0.2f) + 0.2f,
                                viewport.getWorldHeight() + 0.3F);
        velocity = new Vector2();
    }

    protected void renderMeteors(ShapeRenderer renderer)
    {
        renderer.set(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.RED);
        renderer.circle(position.x, position.y, Constants.METEOR_RADIUS, 16);
    }

    // this function returns true if a meteor is below the screen, then we delete that meteor to save memory
    public boolean isBelowScreen()
    {
        boolean returnValue = false;

        if(this.position.y < -Constants.METEOR_RADIUS)
            returnValue = true;

        return returnValue;
    }

    public Vector2 getPosition()
    {
        return position;
    }

}
