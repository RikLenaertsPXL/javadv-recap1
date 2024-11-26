package be.pxl.dice.controller;

import be.pxl.dice.domain.DiceDTO;
import be.pxl.dice.service.DiceSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diceset")
public class DiceSetController {

    private final DiceSetService diceSetService;

    @Autowired
    public DiceSetController(DiceSetService diceSetService) {
        this.diceSetService = diceSetService;
    }

    @PostMapping
    public ResponseEntity<String> createDiceSet(@RequestBody DiceDTO diceDTO) {
        try {
            diceSetService.createDiceSet(diceDTO.getMaxNumber(), diceDTO.getNumberOfDice());
            return ResponseEntity.status(201).build();
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public String getDiceSet() {
        return diceSetService.getDiceSet();
    }

    @PostMapping("/{roll}")
    public  ResponseEntity<String> rollDice(@RequestParam(defaultValue = "-1") int dice) {
        if (dice == -1) {
            return new ResponseEntity<>(diceSetService.rollAllDice(), HttpStatus.OK);
        } else {
            try {
                return new ResponseEntity<>(diceSetService.rollSingleDie(dice), HttpStatus.OK);
            } catch (IllegalArgumentException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }
    }

    @GetMapping("/{highest-sum}")
    public int highestSum() {
        return diceSetService.getHighestSum();
    }
}
