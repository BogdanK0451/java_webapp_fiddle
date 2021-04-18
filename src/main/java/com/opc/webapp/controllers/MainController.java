package com.opc.webapp.controllers;
import java.util.*;

import com.opc.webapp.repositories.KarticaRepository;
import com.opc.webapp.viewmodel.Kupac_Grad_Kartica;
import com.opc.webapp.repositories.GradRepository;
import com.opc.webapp.repositories.KupacRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final GradRepository gradRepository;
    private final KupacRepository kupacRepository;
    private final KarticaRepository karticaRepository;
    static Integer brojKartica=0;

    public MainController(GradRepository gradRepository, KupacRepository kupacRepository, KarticaRepository karticaRepository) {
        this.gradRepository = gradRepository;
        this.kupacRepository = kupacRepository;
        this.karticaRepository = karticaRepository;
    }

    @RequestMapping("/")
    public String getData(@RequestParam(value ="type", required=false) String type,Model model){

        if(type==null)
        {

        }
        else{
            var gradovi = gradRepository.findAll();
            var kupci = kupacRepository.findAll();
            var kartice = karticaRepository.findAll();
            List<Kupac_Grad_Kartica> kupciGradoviKartice = new ArrayList<Kupac_Grad_Kartica>();

            kupci.forEach((kupac) -> {
                gradovi.forEach((grad) -> {
                    if (kupac.getGrad().getId().equals(grad.getId()))
                        kupciGradoviKartice.add(new Kupac_Grad_Kartica(kupac.getId(), kupac.getNaziv(), grad.getNaziv(), kupac.isAktivan()));
                });
                kartice.forEach((kartica)->{
                    if(kartica.getKupac().getId().equals(kupac.getId()))
                        brojKartica++;
                });
                kupciGradoviKartice.get(kupciGradoviKartice.size()-1).setBrojKartica(brojKartica);
                brojKartica=0;
            });
            model.addAttribute("data", kupciGradoviKartice);
        }
        return "data";
    }

}

