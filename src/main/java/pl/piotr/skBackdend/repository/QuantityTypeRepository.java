package pl.piotr.skBackdend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piotr.skBackdend.entity.QuantityType;

public interface QuantityTypeRepository extends JpaRepository<QuantityType,Long> {

}
