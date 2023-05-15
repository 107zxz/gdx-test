package com.zxz.demoproj;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;


/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class DemoProj extends Game {
   

    public SpriteBatch batch;

    @Override
    public void create() {
        Assets.load_assets();
        batch = new SpriteBatch();

        // Graphics init
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);

        setScreen(new WalkScreen(this));
    }

    @Override
    public void dispose() {
        batch.dispose();
        Assets.dispose_assets();
    }
}
