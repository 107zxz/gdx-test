package com.zxz.demoproj;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player {

    private static final float SPEED = 200;

    private Texture playerTexture;
    public Vector2 position;

    public Player() {
        playerTexture = new Texture(Gdx.files.internal("player.png"));

        position = new Vector2(150, 50);
    }

    public void update() {
        float delta = Gdx.graphics.getDeltaTime();

        float movement = 0;

        if (Gdx.input.isKeyPressed(Input.Keys.A))
            movement -= 1;
        
        if (Gdx.input.isKeyPressed(Input.Keys.D))
            movement += 1;
        
        position.x += movement * SPEED * delta;
    }

    public void draw(SpriteBatch batch) {
        batch.begin();

        batch.draw(playerTexture, position.x, position.y);

        batch.end();
    }
    public void dispose() {

    }
}
