package pl.piotr.skBackdend.dto;

import lombok.Data;
import pl.piotr.skBackdend.entity.Warehouse;

@Data
public class WarehouseDto {

    private Long idWarehouse;
    private String name;

    public static WarehouseDto of(Warehouse warehouse){
        WarehouseDto dto = new WarehouseDto();
        dto.setIdWarehouse(warehouse.getIdWarehouse());
        dto.setName(warehouse.getName());
        return dto;

    }




}
