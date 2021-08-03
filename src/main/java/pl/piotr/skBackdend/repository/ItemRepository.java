package pl.piotr.skBackdend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piotr.skBackdend.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
