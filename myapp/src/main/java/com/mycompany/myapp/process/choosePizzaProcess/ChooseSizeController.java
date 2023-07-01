package com.mycompany.myapp.process.choosePizzaProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/choose-pizza-process/choose-size")
public class ChooseSizeController {

    private final Logger log = LoggerFactory.getLogger(ChooseSizeController.class);

    private final ChooseSizeService chooseSizeService;

    public ChooseSizeController(ChooseSizeService chooseSizeService) {
        this.chooseSizeService = chooseSizeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChooseSizeContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        ChooseSizeContextDTO chooseSizeContext = chooseSizeService.loadContext(id);
        return ResponseEntity.ok(chooseSizeContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<ChooseSizeContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        ChooseSizeContextDTO chooseSizeContext = chooseSizeService.claim(id);
        return ResponseEntity.ok(chooseSizeContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody ChooseSizeContextDTO chooseSizeContext) {
        log.debug("REST request to complete ChoosePizzaProcess.ChooseSize {}", chooseSizeContext.getTaskInstance().getId());
        chooseSizeService.complete(chooseSizeContext);
        return ResponseEntity.noContent().build();
    }
}
