package org.UID.Controladores;

import org.UID.Entidades.Empleado;
import org.UID.Servicios.ServicioEmpleado;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ControladorEmpleado {


    ServicioEmpleado servicesE;

    public ControladorEmpleado(ServicioEmpleado servicesE) {
        this.servicesE = servicesE;
    }

    /*@GetMapping("/empleado")
    public List<Empleado> ListaEmpleado() {
        return this.servicesE.getListaEmpleado();
    }*/


//    @GetMapping("/empleado/{id}")
//    public Empleado verEmpleado(@PathVariable Long id) {
//        return this.servicesE.getVerEmpleado(id);
//    }
    @PostMapping("/empleado")
    public RedirectView createEmpleado(@ModelAttribute Empleado empleado, Model model){
        model.addAttribute(empleado);
        this.servicesE.createEmpleado(empleado);
        return new RedirectView("/empleado");
    }

    @PutMapping("/empleado/{id}")
    public RedirectView actualizarEmpleado(@PathVariable Long id, Empleado actEmpleado){
    this.servicesE.actEmpleado(id, actEmpleado);
    return  new RedirectView("/empleado");
    }

    @DeleteMapping("/empleado/{id}")
    public RedirectView eliminarEmpleado(@PathVariable(value = "id") Long id){
        this.servicesE.eliminarE(id);
        return new RedirectView("/empleado");
    }
}