package org.UID.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontControlador {

    @GetMapping("/")//Ruta Raiz
    public String index(){
        return "index";
    }
}
