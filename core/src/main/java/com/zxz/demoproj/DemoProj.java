package com.zxz.demoproj;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.graphics.Texture;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class DemoProj extends ApplicationAdapter {
    private Viewport viewport;
    private FollowCam cam;

    private SpriteBatch batch;

    private Player player;

    private Texture pSpr;

    @Override
    public void create() {

        pSpr = new Texture(Gdx.files.internal("player.png"));

        player = new Player(pSpr);

        cam = new FollowCam(player, 640, 480);

        cam.setToOrtho(false, 640, 480);
        viewport = new FitViewport(640, 480, cam);

        batch = new SpriteBatch();

        // Set clear col
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
    }

    @Override
    public void render() {

        update();

        // Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        // Disable this when you use transparancy
        batch.disableBlending();

        batch.begin();
        player.draw(batch);
        batch.end();
    }

    public void update() {
        player.update();
        cam.update();

    }

    @Override
    public void dispose() {
        batch.dispose();
        pSpr.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        cam.update();
    }
}
