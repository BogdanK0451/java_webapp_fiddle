package com.opc.webapp.controllers;
import java.util.*;

import com.opc.webapp.model.KarticaDozvoljeniGrad;
import com.opc.webapp.model.Kupac;


import com.opc.webapp.viewmodel.RezPretrage;

import com.opc.webapp.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private final GradRepository gradRepository;
    private final KupacRepository kupacRepository;
    private final KarticaRepository karticaRepository;
    private final KarticaDozvoljeniGradRepository karticaDozvoljeniGradRepository;
    static Integer brojKartica=0;
    //Set for ignoring duplicates
    static TreeSet<String> listaGradova= new TreeSet<String>();
    Iterable<KarticaDozvoljeniGrad> valuesToInsert;

    public MainController(GradRepository gradRepository, KupacRepository kupacRepository, KarticaRepository karticaRepository, KarticaDozvoljeniGradRepository karticaDozvoljeniGradRepository) {
        this.gradRepository = gradRepository;
        this.kupacRepository = kupacRepository;
        this.karticaRepository = karticaRepository;
        this.karticaDozvoljeniGradRepository = karticaDozvoljeniGradRepository;
    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String getData(@RequestParam(value ="type", required=false) String type,Model model){

        if(!(type==null))
        model.addAttribute("data", queryingLogic(true));
        return "data";
    }

    @RequestMapping(value="/", method= RequestMethod.POST)
    public String postData(Model model) {
        var kupci = kupacRepository.findAll();
        var gradovi = gradRepository.findAll();
        var kartice = karticaRepository.findAll();
        var dozvoljeniGradovi = karticaDozvoljeniGradRepository.findAll();

        kartice.forEach((kartica)->{
            kupci.forEach((kupac)-> {
                if(kartica.getKupac().getId().equals(kupac.getId()))
                    //if the row doesn't exist in the table, add it
                    if((karticaDozvoljeniGradRepository.findByKarticaAndGrad(kartica,kupac.getGrad())).size()==0)
                       karticaDozvoljeniGradRepository.save(new KarticaDozvoljeniGrad(kartica,kupac.getGrad()));

            });
        });

        model.addAttribute("data", queryingLogic(false));
        return "data";
    }

    private List<RezPretrage> queryingLogic(boolean isAllKupciSelected){

        Iterable<Kupac> kupci;

        if(isAllKupciSelected)
            kupci = kupacRepository.findAll();
        else
            kupci = kupacRepository.findByAktivanTrue();
        var gradovi = gradRepository.findAll();
        var kartice = karticaRepository.findAll();
        var dozvoljeniGradovi = karticaDozvoljeniGradRepository.findAll();
        List<RezPretrage> rezPretrage = new ArrayList<RezPretrage>();

        kupci.forEach((kupac) -> {

            gradovi.forEach((grad) -> {
                if (kupac.getGrad().getId().equals(grad.getId()))
                    rezPretrage.add(new RezPretrage(kupac.getId(), kupac.getNaziv(), grad.getNaziv(), kupac.isAktivan()));
            });

            //refactor
            kartice.forEach((kartica)->{
                if(kartica.getKupac().getId().equals(kupac.getId())) {
                    dozvoljeniGradovi.forEach((el)->{
                        if(kartica.getId().equals(el.getKartica().getId()))
                            listaGradova.add(el.getGrad().getNaziv());
                    });
                    brojKartica++;
                }

            });
            //need to emulate passing by value, hence we create a new TreeSet
            rezPretrage.get(rezPretrage.size()-1).setDozvoljeniGradovi(new TreeSet<String>(listaGradova));
            listaGradova.clear();
            rezPretrage.get( rezPretrage.size()-1).setBrojKartica(brojKartica);
            brojKartica=0;

        });
        return rezPretrage;
    }

}

