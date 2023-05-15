package com.zxz.demoproj;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

public class FollowCam extends OrthographicCamera {
    
    private Player followingPlayer;
    private Vector2 offset;
    
    public FollowCam(Player player, int width, int height) {
        super(width, height);

        // setToOrtho(false, width, height);

        followingPlayer = player;
        offset = new Vector2(50, 150);
    }

    @Override
    public void update() {

        if (followingPlayer != null) {
            position.set(
                followingPlayer.position.x + offset.x,
                followingPlayer.position.y + offset.y,
                0
            );
        }

        super.update();
    }
}
