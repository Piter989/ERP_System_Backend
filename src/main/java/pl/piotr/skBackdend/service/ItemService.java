package pl.piotr.skBackdend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piotr.skBackdend.dto.ItemSaveDto;
import pl.piotr.skBackdend.entity.Item;
import pl.piotr.skBackdend.entity.QuantityType;
import pl.piotr.skBackdend.entity.Warehouse;
import pl.piotr.skBackdend.repository.ItemRepository;
import pl.piotr.skBackdend.repository.QuantityTypeRepository;
import pl.piotr.skBackdend.repository.WarehouseRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final WarehouseRepository warehouseRepository;
    private final QuantityTypeRepository quantityTypeRepository;

    public Item saveItem(ItemSaveDto dto){
        Optional<Warehouse> warehouseOptional = warehouseRepository.findById(dto.getIdWarehouse());
        Optional<QuantityType> quantityTypeOptional = quantityTypeRepository.findById(dto.getIdQuantityType());
        if(!warehouseOptional.isPresent() || !quantityTypeOptional.isPresent()){
            throw new RuntimeException("Incorrect identifiers: id warehouse" + dto.getIdWarehouse() + " idQuantityType " + dto.getIdQuantityType());
        }

        Warehouse warehouse = warehouseOptional.get();
        QuantityType quantityType = quantityTypeOptional.get();
        Item item = Item.of(dto);
        item.setQuantityType(quantityType);
        item.setWarehouse(warehouse);
        return itemRepository.save(item);


    }

}
