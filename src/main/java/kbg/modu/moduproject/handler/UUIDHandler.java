package kbg.modu.moduproject.handler;

import kbg.modu.moduproject.config.StompPrincipal;
import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.repo.ProfessorCommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Map;
import java.util.UUID;



public class UUIDHandler extends DefaultHandshakeHandler {

    @Override
    public Principal determineUser(ServerHttpRequest request,
                                      WebSocketHandler wsHandler,
                                      Map<String, Object> attributes) {

        return new StompPrincipal(UUID.randomUUID().toString());
    }

}
