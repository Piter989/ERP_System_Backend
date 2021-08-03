package pl.piotr.skBackdend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piotr.skBackdend.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
