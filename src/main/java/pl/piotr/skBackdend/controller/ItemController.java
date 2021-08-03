package pl.piotr.skBackdend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piotr.skBackdend.dto.ItemDto;
import pl.piotr.skBackdend.dto.ItemEditViewDto;
import pl.piotr.skBackdend.dto.ItemSaveDto;
import pl.piotr.skBackdend.entity.Item;
import pl.piotr.skBackdend.repository.ItemRepository;
import pl.piotr.skBackdend.repository.QuantityTypeRepository;
import pl.piotr.skBackdend.service.ItemService;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;
    private final QuantityTypeRepository quantityTypeRepository;

    @PostMapping("/items")
    public ItemDto newItem(@RequestBody ItemSaveDto dto) {
        if (dto.getIdItem() == null) {
            return ItemDto.of(itemService.saveItem(dto));
        } else {
            Item item = itemRepository.findById(dto.getIdItem()).get();
            item.setName(dto.getName());
            item.setQuantity(dto.getQuantity());
            item.setQuantityType(quantityTypeRepository.findById(dto.getIdQuantityType()).get());
            return ItemDto.of(itemRepository.save(item));
        }
    }

    @GetMapping("/items")
    public List<ItemDto> listItems (){

        return itemRepository.findAll()
                .stream()
                .map(ItemDto::of)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/items/{idItem}")
    public ResponseEntity deleteItem(@PathVariable Long idItem){
        itemRepository.deleteById(idItem);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/item_edit_data/{idItem}")
        public ItemEditViewDto getItemEditDto(@PathVariable Long idItem){
        Item item = itemRepository.findById(idItem).get();
        ItemEditViewDto dto = ItemEditViewDto.of(item, quantityTypeRepository.findAll());
        return dto;
    }

    @GetMapping("/items/{idItem}")
    public ItemDto getItem(@PathVariable Long idItem) throws InterruptedException {
        Optional<Item> optionalItem = itemRepository.findById(idItem);

        return  ItemDto.of(optionalItem.get());
    }
}
