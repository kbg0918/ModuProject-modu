package kbg.modu.moduproject.config;


import kbg.modu.moduproject.handler.EchoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketConfig  implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(EchoHandler(),"/alarm")
                .addInterceptors(new HttpSessionHandshakeInterceptor()).withSockJS();
    }

    @Bean
    public WebSocketHandler EchoHandler(){
        return new EchoHandler();
    }
}
