package com.mycompany.myapp.process.choosePizzaProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/choose-pizza-process/choose-type-1")
public class ChooseType1Controller {

    private final Logger log = LoggerFactory.getLogger(ChooseType1Controller.class);

    private final ChooseType1Service chooseType1Service;

    public ChooseType1Controller(ChooseType1Service chooseType1Service) {
        this.chooseType1Service = chooseType1Service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChooseType1ContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        ChooseType1ContextDTO chooseType1Context = chooseType1Service.loadContext(id);
        return ResponseEntity.ok(chooseType1Context);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<ChooseType1ContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        ChooseType1ContextDTO chooseType1Context = chooseType1Service.claim(id);
        return ResponseEntity.ok(chooseType1Context);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody ChooseType1ContextDTO chooseType1Context) {
        log.debug("REST request to complete ChoosePizzaProcess.ChooseType1 {}", chooseType1Context.getTaskInstance().getId());
        chooseType1Service.complete(chooseType1Context);
        return ResponseEntity.noContent().build();
    }
}
