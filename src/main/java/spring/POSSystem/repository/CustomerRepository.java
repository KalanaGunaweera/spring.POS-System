package spring.POSSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import spring.POSSystem.entity.Customer;
@Repository
@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
