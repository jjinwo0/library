package jinwoo.library.jwt.config;

import jinwoo.library.jwt.util.JwtUtil;
import jinwoo.library.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter { //토큰이 있는지 매번 요청마다 인증

    private final MemberService memberService;

    @Value("${jwt.secret}")
    private final String secretKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        log.info("authorization: {}", authorization);

        //token없을 시 || Bearer 안달려 있을 시 Block
        if (authorization == null || !(authorization.startsWith("Bearer "))) {
            log.error("authorization이 없습니다.");
            filterChain.doFilter(request, response);
            return;
        }

        //Token 꺼내기
        String token = authorization.split(" ")[1]; //Bearer 분리

        //Token Expired 되었는지 여부 확인
        if(JwtUtil.isExpired(token, secretKey)){
            log.error("token이 만료되었습니다.");
            filterChain.doFilter(request, response);
            return;
        }


        //Token에서 username 추출
        String username = JwtUtil.getUsername(token, secretKey);
        log.info("username: {}", username);

        //권한 부여
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, null, List.of(new SimpleGrantedAuthority("MEMBER")));

        //Detail 추가
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); //request detail 추가
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
