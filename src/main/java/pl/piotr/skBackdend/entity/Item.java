package pl.piotr.skBackdend.entity;

import lombok.Data;
import pl.piotr.skBackdend.dto.ItemSaveDto;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;

    @Column

    private  String name;


    @Column
    private  Double quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idQuantityType")
    private QuantityType quantityType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idWarehouse")
    private Warehouse warehouse;

    public static Item of(ItemSaveDto dto) {
        Item item = new Item();
        item.setName(dto.getName());
        item.setQuantity(dto.getQuantity());
        return item;
    }
}
