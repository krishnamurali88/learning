package ex.ratelimiter.leakybucket;

import java.util.concurrent.atomic.AtomicLong;

public class TokenBucketAlgorithm implements RateLimiter {

  private final long capacity;
  private final long refillRate;
  private final AtomicLong tokens;
  private volatile long lastRefillTimestamp;

  public TokenBucketAlgorithm(long capacity, long refillRate) {
    this.capacity = capacity;
    this.refillRate = refillRate;
    this.tokens = new AtomicLong(capacity);
    this.lastRefillTimestamp = System.currentTimeMillis();
  }

  @Override
  public boolean tryAcquire() {
    refill();

    long currentTokens = tokens.get();
    if (currentTokens > 0) {
      return tokens.compareAndSet(currentTokens, currentTokens - 1);
    }
    return false;
  }

  private void refill() {
    long now = System.currentTimeMillis();
    long elapsedTime = now - lastRefillTimestamp;

    if (elapsedTime > 0) {
      long tokensToAdd = (elapsedTime * refillRate) / 1000;
      if (tokensToAdd > 0) {
        long newTokens = Math.min(tokens.get() + tokensToAdd, capacity);
        tokens.set(newTokens);
        lastRefillTimestamp = now;
      }
    }
  }

}
