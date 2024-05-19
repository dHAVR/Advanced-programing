package gameLogic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeControl {
    private ScheduledExecutorService scheduler;
    private Runnable onTimeout;

    public TimeControl(Runnable onTimeout) {
        this.onTimeout = onTimeout;
    }

    public void startTimer(int seconds) {
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdownNow();
        }
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(onTimeout, seconds, TimeUnit.SECONDS);
    }

    public void stopTimer() {
        if (scheduler != null) {
            scheduler.shutdownNow();
        }
    }
}
