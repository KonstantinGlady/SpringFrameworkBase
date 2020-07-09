package ru.gik.spring.hiber.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.gik.spring.hiber.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCostLessThan(int i);

    List<Product> findByCostGreaterThan(int i);

    @Query("select p from Product p where p.cost < :digMax and p.cost> :digMin")
    List<Product> greaterAndLessThan(@Param("digMax") int digMax, @Param("digMin") int digMin);
}
