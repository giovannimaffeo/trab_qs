package com.mycompany.myapp.process.choosePizzaProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/choose-pizza-process/choose-type-2")
public class ChooseType2Controller {

    private final Logger log = LoggerFactory.getLogger(ChooseType2Controller.class);

    private final ChooseType2Service chooseType2Service;

    public ChooseType2Controller(ChooseType2Service chooseType2Service) {
        this.chooseType2Service = chooseType2Service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChooseType2ContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        ChooseType2ContextDTO chooseType2Context = chooseType2Service.loadContext(id);
        return ResponseEntity.ok(chooseType2Context);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<ChooseType2ContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        ChooseType2ContextDTO chooseType2Context = chooseType2Service.claim(id);
        return ResponseEntity.ok(chooseType2Context);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody ChooseType2ContextDTO chooseType2Context) {
        log.debug("REST request to complete ChoosePizzaProcess.ChooseType2 {}", chooseType2Context.getTaskInstance().getId());
        chooseType2Service.complete(chooseType2Context);
        return ResponseEntity.noContent().build();
    }
}
