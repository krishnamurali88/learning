package ex.ratelimiter.leakybucket;

public interface RateLimiter {
  boolean tryAcquire();
}
