package br.com.serasa.exerciciossb.desafio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/calc")
public class CalcController {
    @GetMapping(path = "/sum/{firstNumber}/{secondNumber}")
    public String sum(@PathVariable("firstNumber") int firstNumber,
                         @PathVariable("secondNumber") int secondNumber) {
        return "The SUM result is " + ( firstNumber + secondNumber );
    }

    @GetMapping(path = "/sub/{firstNumber}/{secondNumber}")
    public String sub(@PathVariable("firstNumber") int firstNumber,
                      @PathVariable("secondNumber") int secondNumber) {
        return "The SUB result is " + ( firstNumber - secondNumber );
    }

    @GetMapping(path = "/mult/{firstNumber}/{secondNumber}")
    public String mult(@PathVariable("firstNumber") int firstNumber,
                      @PathVariable("secondNumber") int secondNumber) {
        return "The MULTIPLICATION result is " + ( firstNumber * secondNumber );
    }

    @GetMapping(path = "/div/{firstNumber}/{secondNumber}")
    public String div(@PathVariable("firstNumber") int firstNumber,
                      @PathVariable("secondNumber") int secondNumber) {
        return "The DIVISION result is " + ( firstNumber / secondNumber );
    }

    @GetMapping(path = "/pow/{firstNumber}/{secondNumber}")
    public String power(@PathVariable("firstNumber") int firstNumber,
                      @PathVariable("secondNumber") int secondNumber) {
        return "The POWER result is " + Math.pow( firstNumber, secondNumber );
    }
}
