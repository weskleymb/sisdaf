package br.gov.rn.pm.sisdaf.controller;

import br.gov.rn.pm.sisdaf.model.Opm;
import br.gov.rn.pm.sisdaf.service.OpmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/opms")
public class OpmController {

    @Autowired
    private OpmService service;

    @GetMapping
    public String buscaTodos(Model model) {
        model.addAttribute("opm", new Opm());
        model.addAttribute("opms", service.buscaTodos());
        return "opms/index";
    }

    @PostMapping
    public String salva(Opm opm) {
        service.salva(opm);
        return "redirect:/opms";
    }

    @GetMapping("/{id}/remove")
    public String remove(@PathVariable("id") Long id) {
        service.removePorId(id);
        return "redirect:/opms";
    }

    @GetMapping("/{id}/edita")
    public String edita(@PathVariable("id") Long id, Model model) {
        model.addAttribute("opm", service.buscaPorId(id));
        model.addAttribute("opms", service.buscaTodos());
        return "opms/index";
    }

}
