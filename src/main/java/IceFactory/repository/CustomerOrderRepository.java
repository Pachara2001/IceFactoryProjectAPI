package IceFactory.repository;


import IceFactory.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerOrderRepository extends
        JpaRepository<CustomerOrder, UUID> {
}
