package com.logon.gest4all.repositories;

import com.logon.gest4all.entities.CollectivePerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectivePersonRepository extends JpaRepository<CollectivePerson, Long> {
}
