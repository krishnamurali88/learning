package ex.ratelimiter.ratelimiter.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import redis.clients.jedis.Jedis;

import java.io.IOException;

@Component
public class RateLimitingFilter extends OncePerRequestFilter {

  private static final int MAX_REQUESTS_PER_MINUTE = 5;
  private static final String REDIS_HOST = "localhost";
  private static final int REDIS_PORT = 6379;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    String clientIp = request.getRemoteAddr(); // Identify client by IP
    String key = "rate_limit:" + clientIp;

    try (Jedis jedis = new Jedis(REDIS_HOST, REDIS_PORT)) {

      String requestCount = jedis.get(key);

      if (requestCount == null) {
        // First request, set count to 1 and set expiration for 1 minute
        jedis.setex(key, 60, "1");
      } else {
        int currentCount = Integer.parseInt(requestCount);

        if (currentCount < MAX_REQUESTS_PER_MINUTE) {
          // Increment the request count
          jedis.incr(key);
        } else {
          // Limit exceeded, send 429 Too Many Requests response
          response.setStatus(429);
          response.getWriter().write("Rate limit exceeded. Try again later.");
          return;
        }
      }
    }

    filterChain.doFilter(request, response); // Continue the request

  }
}
