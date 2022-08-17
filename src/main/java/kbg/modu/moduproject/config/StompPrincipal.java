package kbg.modu.moduproject.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.Principal;



public class StompPrincipal implements Principal {
    String name;
    public StompPrincipal(String name){

        this.name=name;
    }
    @Override
    public String getName() {
        return name;
    }

}
