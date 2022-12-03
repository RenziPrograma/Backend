
package com.renziportfolio.PortFolioDeRenzi.Security.jwt;

import com.renziportfolio.PortFolioDeRenzi.Security.Entity.MainCustomer;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;



/**
 *
 * @author redac
 */
@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.experation}")
    private int expiration;

    public String generateToken(Authentication authentication) {
        MainCustomer mainCustomer = (MainCustomer) authentication.getPrincipal();
        return Jwts.builder().setSubject(mainCustomer.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+expiration*1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getCustomerNameFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Error, Token mal formado");
        } catch (UnsupportedJwtException e) {
            logger.error("Error, Token no soportado");
        } catch (ExpiredJwtException e) {
            logger.error("Error, el Token ha expirado");
        } catch (IllegalArgumentException e) {
            logger.error("Error, Token vacio, ingrese un Token valido ");
        } catch (SignatureException e) {
            logger.error("Error, firma no valida");
        }
        return false;
    }

}
