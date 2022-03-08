package com.revature.boot.repos;

import com.revature.boot.models.Boot;
import com.revature.boot.models.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BootRepository extends CrudRepository<Boot, String> {

    @Query("from Boot b where b.owner = ?1")
    List<Boot> getBootsByOwner(Customer owner);

}
