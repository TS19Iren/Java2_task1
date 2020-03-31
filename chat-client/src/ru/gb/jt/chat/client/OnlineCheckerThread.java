package ru.gb.jt.chat.client;

import ru.gb.jt.network.SocketThread;

import java.util.Calendar;

public class OnlineCheckerThread extends Thread {

    private volatile Calendar lastActiveTime;
    private static final int TIME_TO_LOGOUT_IN_MS = 2 * 60 * 1000;
    private SocketThread socketThread;
    private volatile boolean isRunning = false;

    public OnlineCheckerThread(SocketThread socketThread) {
        this.socketThread = socketThread;
        this.lastActiveTime = Calendar.getInstance();
        start();
    }

    @Override
    public void run() {
        this.isRunning = true;
        while (this.isRunning) {
            try {
                Thread.sleep(100);
                long deltaTime = Calendar.getInstance().getTimeInMillis() - getLastActiveTime().getTimeInMillis();
                if (deltaTime >= TIME_TO_LOGOUT_IN_MS) {
                    socketThread.close();
                    this.isRunning = false;
                    break;
                }
            } catch (InterruptedException e) {
                this.isRunning = false;
                e.printStackTrace();
                if (this.isAlive())
                    this.interrupt();
            }
        }
    }

    public synchronized Calendar getLastActiveTime() {
        return lastActiveTime;
    }

    public synchronized void setLastActiveTime(Calendar lastActiveTime) {
        this.lastActiveTime = lastActiveTime;
    }

    public synchronized void setRunning(boolean running) {
        isRunning = running;
    }
}
