package IceFactory.repository;


import IceFactory.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends
        JpaRepository<Staff,String> {
}
