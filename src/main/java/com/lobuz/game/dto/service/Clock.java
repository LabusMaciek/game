package com.lobuz.game.dto.service;

import com.lobuz.game.controller.game.GameController;

public class Clock implements Runnable {

    private final GameController controller;

    public Clock(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {

        try {
            for (int i = 60; i >= 0; i--) {
                Thread.sleep(1000);
            }
            controller.next();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
