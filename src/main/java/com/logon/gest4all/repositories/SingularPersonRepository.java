package com.logon.gest4all.repositories;

import com.logon.gest4all.entities.SingularPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingularPersonRepository extends JpaRepository<SingularPerson, Long> {
}
