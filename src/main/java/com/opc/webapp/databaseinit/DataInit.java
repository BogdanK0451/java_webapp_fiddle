package com.opc.webapp.databaseinit;

import com.opc.webapp.model.Grad;
import com.opc.webapp.repositories.GradRepository;
import com.opc.webapp.repositories.KarticaDozvoljeniGradRepository;
import com.opc.webapp.repositories.KarticaRepository;
import com.opc.webapp.repositories.KupacRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

    }
}
