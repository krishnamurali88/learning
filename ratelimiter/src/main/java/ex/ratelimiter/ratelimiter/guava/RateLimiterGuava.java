package ex.ratelimiter.ratelimiter.guava;

import com.google.common.util.concurrent.RateLimiter;

/**
 * This is an in memory rate limiter.
 */
public class RateLimiterGuava {
  public static void main(String[] args) {
    RateLimiter rateLimiter = RateLimiter.create(5.0);

    for (int i = 0; i < 10; i++) {
      rateLimiter.acquire();
      System.out.println("Request processed at " + System.currentTimeMillis());
    }
  }
}
