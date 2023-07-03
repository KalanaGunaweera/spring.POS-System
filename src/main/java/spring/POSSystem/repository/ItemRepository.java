package spring.POSSystem.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import spring.POSSystem.entity.Item;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepository extends JpaRepository<Item,Integer> {
    List<Item> findAllByItemNameIs(String itemName);

    Page<Item> findAllByActiveStateEquals(int activeState, Pageable pageable);

    int countAllByActiveStateEquals(int activeState);
}
