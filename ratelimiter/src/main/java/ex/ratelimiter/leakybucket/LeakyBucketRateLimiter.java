package ex.ratelimiter.leakybucket;

import java.util.concurrent.atomic.AtomicLong;

public class LeakyBucketRateLimiter implements RateLimiter {

  // The maximum capacity of the bucket
  private final int capacity;

  // Time Unit for messuring the leak rate
  private final long windowUnit = 1000;

  // Current level of water
  private final AtomicLong waterLevel = new AtomicLong(0);

  // Timestamp of the last leak calculation, used to determine how much water we
  // have during the time window
  private volatile long lastLeakTimeStamp;

  public LeakyBucketRateLimiter(int capacity) {
    this.capacity = capacity;
    this.lastLeakTimeStamp = System.currentTimeMillis();
  }

  /**
   * Try acquiring the lock for rate limiter.
   * Returns true if we can aquire, if not false
   */
  @Override
  public boolean tryAcquire() {

    // Get the current time
    long currentTimeMillis = System.currentTimeMillis();

    // check how much water leaked in the last duration
    long leakedAmount = ((currentTimeMillis - this.lastLeakTimeStamp) / windowUnit) * capacity;

    // if leaked adjust the bucket
    if (leakedAmount > 0) {
      waterLevel.addAndGet(-leakedAmount);
      this.lastLeakTimeStamp = currentTimeMillis;
    }

    if (waterLevel.get() < 0) {
      waterLevel.set(0);
    }

    // if the bucket is not full increment
    if (waterLevel.get() < capacity) {
      waterLevel.getAndIncrement();
      return true;
    }

    return false;
  }

}
