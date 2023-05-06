package com.zxz.demoproj;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class DemoProj extends Game {
    private Viewport viewport;
    private OrthographicCamera cam;

    private SpriteBatch batch;
    private BitmapFont font;

    private Player player;

    @Override
    public void create() {
        cam = new OrthographicCamera(640, 480);
        cam.setToOrtho(false, 640, 480);
        viewport = new FitViewport(640, 480, cam);

        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(1, 0, 0, 1);
        font.getData().setScale(2);

        player = new Player();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        cam.update();

        player.draw();

        Vector3 inputPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        cam.unproject(inputPos);


        batch.begin();
        font.draw(batch, "Deez", inputPos.x, inputPos.y);
        batch.end();

        super.render();
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
