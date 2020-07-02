package com.example.appointmentapi.filter;

import com.example.appointmentapi.security.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws IOException, ServletException {
        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        if (authentication == null) {
            chain.doFilter(request, response);
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(JwtProperties.TOKEN_HEADER);
        if (!StringUtils.isEmpty(token) && token.startsWith(JwtProperties.TOKEN_PREFIX)) {
            byte[] signingKey = JwtProperties.JWT_SECRET.getBytes();

            Jws<Claims> parsedToken = Jwts.parser()
                    .setSigningKey(signingKey)
                    .parseClaimsJws(token.replace("Bearer ", ""));
            String username = parsedToken
                    .getBody()
                    .getSubject();
            Set<SimpleGrantedAuthority> roles = ((List<?>) parsedToken.getBody()
                    .get("role")).stream()
                    .map(authority -> new SimpleGrantedAuthority((String) authority))
                    .collect(Collectors.toSet());
            if (!StringUtils.isEmpty(username)) {
                return new UsernamePasswordAuthenticationToken(username, null, roles);
            }
        }
        return null;
    }
}
