package com.opc.webapp.databaseinit;

import com.opc.webapp.model.Grad;
import com.opc.webapp.model.Kartica;
import com.opc.webapp.model.KarticaDozvoljeniGrad;
import com.opc.webapp.model.Kupac;
import com.opc.webapp.repositories.GradRepository;
import com.opc.webapp.repositories.KarticaDozvoljeniGradRepository;
import com.opc.webapp.repositories.KarticaRepository;
import com.opc.webapp.repositories.KupacRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInit implements CommandLineRunner {

    private final GradRepository gradRepository;
    private final KarticaRepository karticaRepository;
    private final KarticaDozvoljeniGradRepository karticaDozvoljeniGradRepository;
    private final KupacRepository kupacRepository;

    public DataInit(GradRepository gradRepository, KarticaRepository karticaRepository,
                    KarticaDozvoljeniGradRepository karticaDozvoljeniGradRepository, KupacRepository kupacRepository) {
        this.gradRepository = gradRepository;
        this.karticaRepository = karticaRepository;
        this.karticaDozvoljeniGradRepository = karticaDozvoljeniGradRepository;
        this.kupacRepository = kupacRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        System.out.println("Started data init");
        List<Grad> gradovi = new ArrayList(){{
            add(new Grad("Beograd"));
            add(new Grad("Niš"));
            add(new Grad("Paraćin"));
            add(new Grad ("Novi Sad"));
            add(new Grad ("Vršac"));
            add(new Grad ("Užice"));
            add(new Grad ("Bor"));
            }};
        List<Kupac> kupci = new ArrayList(){{
            add(new Kupac("OPC",gradovi.get(0),true));
            add(new Kupac("NIS",gradovi.get(3),true));
            add(new Kupac("Pionir",gradovi.get(2),true));
            add(new Kupac("Elektronika",gradovi.get(1),false));
            add(new Kupac("Hemofarm",gradovi.get(5),true));
            add(new Kupac("Galenika",gradovi.get(0),true));
            add(new Kupac("RTB Bor",gradovi.get(6),false));
        }};
        List<Kartica> kartice = new ArrayList(){{
            add(new Kartica(1,kupci.get(0)));
            add(new Kartica(2,kupci.get(0)));
            add(new Kartica(3,kupci.get(0)));
            add(new Kartica(4,kupci.get(0)));
            add(new Kartica(5,kupci.get(0)));
            add(new Kartica(6,kupci.get(1)));
            add(new Kartica(7,kupci.get(1)));
            add(new Kartica(8,kupci.get(2)));
            add(new Kartica(9,kupci.get(4)));
            add(new Kartica(10,kupci.get(4)));
        }};
        List<KarticaDozvoljeniGrad> karticeDozvoljeniGradovi = new ArrayList(){{
            add(new KarticaDozvoljeniGrad(kartice.get(0),gradovi.get(0)));
            add(new KarticaDozvoljeniGrad(kartice.get(0),gradovi.get(6)));
            add(new KarticaDozvoljeniGrad(kartice.get(1),gradovi.get(4)));
            add(new KarticaDozvoljeniGrad(kartice.get(2),gradovi.get(2)));
            add(new KarticaDozvoljeniGrad(kartice.get(3),gradovi.get(3)));
            add(new KarticaDozvoljeniGrad(kartice.get(3),gradovi.get(5)));
            add(new KarticaDozvoljeniGrad(kartice.get(4),gradovi.get(0)));
            add(new KarticaDozvoljeniGrad(kartice.get(5),gradovi.get(3)));
            add(new KarticaDozvoljeniGrad(kartice.get(6),gradovi.get(5)));
            add(new KarticaDozvoljeniGrad(kartice.get(6),gradovi.get(6)));
            add(new KarticaDozvoljeniGrad(kartice.get(8),gradovi.get(0)));
            add(new KarticaDozvoljeniGrad(kartice.get(9),gradovi.get(2)));
        }};

        gradRepository.saveAll(gradovi);
        kupacRepository.saveAll((kupci));
        karticaRepository.saveAll((kartice));
        karticaDozvoljeniGradRepository.saveAll(karticeDozvoljeniGradovi);
        System.out.println("Number of cities "+ gradRepository.count());
        System.out.println("Number of buyers "+ kupacRepository.count());
        System.out.println("Number of cards "+ karticaRepository.count());
        System.out.println("Number of entries "+ karticaDozvoljeniGradRepository.count());




    }
}
