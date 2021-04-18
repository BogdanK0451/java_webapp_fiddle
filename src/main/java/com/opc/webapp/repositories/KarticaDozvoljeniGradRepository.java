package com.opc.webapp.repositories;

import java.util.*;

import com.opc.webapp.model.Kartica;
import com.opc.webapp.model.Grad;
import com.opc.webapp.model.KarticaDozvoljeniGrad;
import org.springframework.data.repository.CrudRepository;

public interface KarticaDozvoljeniGradRepository extends CrudRepository<KarticaDozvoljeniGrad, Integer> {
    List<KarticaDozvoljeniGrad> findByKarticaAndGrad(Kartica id1,Grad id2);
}
