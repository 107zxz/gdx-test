package com.zxz.demoproj;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class DemoProj extends ApplicationAdapter {
    private Viewport viewport;
    private FollowCam cam;

    private SpriteBatch batch;

    private Player player;

    @Override
    public void create() {
        player = new Player();

        cam = new FollowCam(player, 640, 480);

        cam.setToOrtho(false, 640, 480);
        viewport = new FitViewport(640, 480, cam);

        batch = new SpriteBatch();

    }

    @Override
    public void render() {

        update();

        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        cam.update();

        player.draw(batch);
    }

    public void update() {
        player.update();
    }

    @Override
    public void dispose() {
        batch.dispose();
        player.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        cam.update();
    }
}
