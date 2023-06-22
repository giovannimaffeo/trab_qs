package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.ChoosePizzaProcess;
import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the ChoosePizzaProcess entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ChoosePizzaProcessRepository extends JpaRepository<ChoosePizzaProcess, Long> {
    Optional<ChoosePizzaProcess> findByProcessInstanceId(Long processInstanceId);
}
