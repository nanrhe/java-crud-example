package org.UID.Controladores;

import org.UID.Entidades.MovimientoDinero;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FrontControlador {
    @GetMapping("/")   //Ruta Raiz
    public String index(){return "index";}

    @GetMapping("/inicio")   //Ruta home
    public String inicio(){return "inicio";}


}
