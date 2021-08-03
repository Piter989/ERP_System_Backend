package pl.piotr.skBackdend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piotr.skBackdend.dto.OperatorAuthenticationResultDto;
import pl.piotr.skBackdend.dto.OperatorCredentialsDto;
import pl.piotr.skBackdend.entity.Operator;
import pl.piotr.skBackdend.repository.OperatorRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class OperatorController {

    private final OperatorRepository operatorRepository;


    @PostMapping("/operator")
    public Operator newOperator(@RequestBody Operator newOperator) {
        return operatorRepository.save(newOperator);

    }

    @GetMapping("/operator")
    public List<Operator> OperatorItems (){
        return operatorRepository.findAll();
    }

    @DeleteMapping("/operator")
    public ResponseEntity deleteItem(@RequestBody Long idOperator){
        operatorRepository.deleteById(idOperator);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/verify_operator_credentials")
    public OperatorAuthenticationResultDto verifyOperatorCredentials(@RequestBody OperatorCredentialsDto operatorCredentialsDto){
        Optional <Operator> operatorOptional = operatorRepository.findByLogin(operatorCredentialsDto.getLogin());

        if(!operatorOptional.isPresent()){
            return  OperatorAuthenticationResultDto.createUnauthenticated();

        }
        Operator operator = operatorOptional.get();

        if (!operator.getPassword().equals(operatorCredentialsDto.getPassword())){
            return  OperatorAuthenticationResultDto.createUnauthenticated();

        }else {
            return OperatorAuthenticationResultDto.of(operator);
        }



    }
}
