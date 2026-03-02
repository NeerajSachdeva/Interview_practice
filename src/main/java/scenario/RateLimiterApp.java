package scenario;

import java.util.*;

public class RateLimiterApp {

    public static void main(String[] args) throws Exception {

        RateLimiter limiter = new RateLimiter(3, 5000);

        for (int i = 1; i <= 5; i++) {
            System.out.println("Request " + i + " allowed: " + limiter.allowRequest("user1"));
            Thread.sleep(1000);
        }
    }
}

class RateLimiter {

    private Map<String, Deque<Long>> map = new HashMap<>();
    private int limit;
    private long window;

    public RateLimiter(int limit, long window) {
        this.limit = limit;
        this.window = window;
    }

    public synchronized boolean allowRequest(String user) {

        long now = System.currentTimeMillis();

        map.putIfAbsent(user, new ArrayDeque<>());
        Deque<Long> q = map.get(user);

        while (!q.isEmpty() && now - q.peekFirst() >= window)
            q.pollFirst();

        if (q.size() >= limit)
            return false;

        q.addLast(now);
        return true;
    }
}