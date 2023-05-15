package com.zxz.demoproj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public final class Assets {

    static Texture PLAYER_TEXTURE;
    static Texture DOOR_TEXTURE;
    static BitmapFont GAME_FONT;

    private Assets() {

    }

    public static void load_assets() {
        PLAYER_TEXTURE = new Texture(Gdx.files.internal("bartender.png"));
        DOOR_TEXTURE = new Texture(Gdx.files.internal("door.png"));
        GAME_FONT = new BitmapFont();
    }

    public static void dispose_assets() {
        PLAYER_TEXTURE.dispose();
        DOOR_TEXTURE.dispose();
        GAME_FONT.dispose();
    }
}
