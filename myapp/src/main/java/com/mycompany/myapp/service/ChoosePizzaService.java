package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.ChoosePizza;
import com.mycompany.myapp.repository.ChoosePizzaRepository;
import com.mycompany.myapp.service.dto.ChoosePizzaDTO;
import com.mycompany.myapp.service.mapper.ChoosePizzaMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link ChoosePizza}.
 */
@Service
@Transactional
public class ChoosePizzaService {

    private final Logger log = LoggerFactory.getLogger(ChoosePizzaService.class);

    private final ChoosePizzaRepository choosePizzaRepository;

    private final ChoosePizzaMapper choosePizzaMapper;

    public ChoosePizzaService(ChoosePizzaRepository choosePizzaRepository, ChoosePizzaMapper choosePizzaMapper) {
        this.choosePizzaRepository = choosePizzaRepository;
        this.choosePizzaMapper = choosePizzaMapper;
    }

    /**
     * Save a choosePizza.
     *
     * @param choosePizzaDTO the entity to save.
     * @return the persisted entity.
     */
    public ChoosePizzaDTO save(ChoosePizzaDTO choosePizzaDTO) {
        log.debug("Request to save ChoosePizza : {}", choosePizzaDTO);
        ChoosePizza choosePizza = choosePizzaMapper.toEntity(choosePizzaDTO);
        choosePizza = choosePizzaRepository.save(choosePizza);
        return choosePizzaMapper.toDto(choosePizza);
    }

    /**
     * Partially update a choosePizza.
     *
     * @param choosePizzaDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<ChoosePizzaDTO> partialUpdate(ChoosePizzaDTO choosePizzaDTO) {
        log.debug("Request to partially update ChoosePizza : {}", choosePizzaDTO);

        return choosePizzaRepository
            .findById(choosePizzaDTO.getId())
            .map(
                existingChoosePizza -> {
                    choosePizzaMapper.partialUpdate(existingChoosePizza, choosePizzaDTO);
                    return existingChoosePizza;
                }
            )
            .map(choosePizzaRepository::save)
            .map(choosePizzaMapper::toDto);
    }

    /**
     * Get all the choosePizzas.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<ChoosePizzaDTO> findAll() {
        log.debug("Request to get all ChoosePizzas");
        return choosePizzaRepository.findAll().stream().map(choosePizzaMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one choosePizza by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ChoosePizzaDTO> findOne(Long id) {
        log.debug("Request to get ChoosePizza : {}", id);
        return choosePizzaRepository.findById(id).map(choosePizzaMapper::toDto);
    }

    /**
     * Delete the choosePizza by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ChoosePizza : {}", id);
        choosePizzaRepository.deleteById(id);
    }
}
