class TimeKeeper extends Thread {
    private long startTime;
    private long timeLimit;

    public TimeKeeper(long timeLimit) {
        this.timeLimit = timeLimit;
        this.startTime = System.currentTimeMillis();
    }

    public void run() {
        while (true) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            System.out.println("Elapsed time: " + elapsedTime / 1000 + " seconds");
            if (elapsedTime >= timeLimit) {
                System.out.println("Time's up!");
                System.exit(0);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
