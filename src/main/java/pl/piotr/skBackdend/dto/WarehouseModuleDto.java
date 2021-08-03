package pl.piotr.skBackdend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.piotr.skBackdend.entity.Warehouse;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseModuleDto {

    private WarehouseDto selectedWarehouse;
    private List<WarehouseDto> warehouseDtoList;
    private List<ItemDto> itemDtoList;

}
