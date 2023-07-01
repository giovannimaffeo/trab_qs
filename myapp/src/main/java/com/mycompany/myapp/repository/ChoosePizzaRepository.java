package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.ChoosePizza;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the ChoosePizza entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ChoosePizzaRepository extends JpaRepository<ChoosePizza, Long> {}
