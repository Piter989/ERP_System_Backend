package pl.piotr.skBackdend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piotr.skBackdend.dto.QuantityTypeDto;
import pl.piotr.skBackdend.entity.QuantityType;
import pl.piotr.skBackdend.repository.QuantityTypeRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class QuantityTypeController {

    private final QuantityTypeRepository QuantityTypeRepository;


    @PostMapping("/quantity_types")
    public QuantityType newQuantityType(@RequestBody QuantityType newQuantityType) {
        return QuantityTypeRepository.save(newQuantityType);

    }

    @GetMapping("/quantity_types")
    public List<QuantityTypeDto> listQuantityTypes (){

        return QuantityTypeRepository.findAll().stream().map(QuantityTypeDto::of).collect(Collectors.toList());
    }

    @DeleteMapping("/quantity_types")
    public ResponseEntity deleteQuantityTypes(@RequestBody Long idQuantityType){
        QuantityTypeRepository.deleteById(idQuantityType);
        return ResponseEntity.ok().build();
    }

}

