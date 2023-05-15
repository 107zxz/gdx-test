package com.zxz.demoproj;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Input;

public class WalkScreen extends ScreenAdapter {
    private final DemoProj game;

    private Player player;

    private Sprite door;

    private Viewport viewport;
    private FollowCam cam;

    private Matrix4 hudMatrix;

    public WalkScreen(final DemoProj game) {
        this.game = game;

        player = new Player(Assets.PLAYER_TEXTURE);

        door = new Sprite(Assets.DOOR_TEXTURE);
        door.setPosition(250, 50);
        cam = new FollowCam(player, 640, 480);

        viewport = new FitViewport(640, 480, cam);
        hudMatrix = cam.combined.cpy();
        hudMatrix.setToOrtho2D(0, 0, 640, 480);

        // Set clear color
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
    }

    @Override
    public void show() {
        
    }

    @Override
    public void render(float delta) {

        update();

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.setProjectionMatrix(cam.combined);

        game.batch.begin();
        door.draw(game.batch);
        player.draw(game.batch);
        game.batch.end();


        game.batch.setProjectionMatrix(hudMatrix);
        game.batch.begin();
        Assets.GAME_FONT.draw(game.batch, "Hello, World!", 150, 150);
        game.batch.end();
    }

    public void update() {

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }

        player.update();
        cam.update();

    }



    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        cam.update();
        // hudMatrix.setToOrtho2D(0, 0, width, height);
    }
}
