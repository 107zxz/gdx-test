package com.zxz.demoproj;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class FollowCam extends OrthographicCamera {
    
    private Player followingPlayer;
    
    public FollowCam(Player player, int width, int height) {
        super(width, height);

        followingPlayer = player;
    }

    @Override
    public void update() {
        // position.x = followingPlayer.position.x;

        // position.set(followingPlayer.position, 0);

        super.update();


    }
}
