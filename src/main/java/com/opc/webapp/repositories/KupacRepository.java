package com.opc.webapp.repositories;


import java.util.List;
import com.opc.webapp.model.Kupac;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface KupacRepository extends CrudRepository<Kupac, Integer> {
    //note, class field has to not be capitalized......
    List<Kupac> findByAktivanTrue();
}
