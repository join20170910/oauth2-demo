package com.ws.react.repository;

import com.ws.react.entity.Customer;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName CustomerRepository
 * @Deacription TODO
 * @Author apple
 * @Date 2020/8/29 17:15
 * @Version 1.0
 **/
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findByAddress (String address);

    Customer findByFirstNameAndAddress(String firstName,String address);

    @Query("select c from Customer c where c.firstName = :firstName and c.address= :address")
    Customer withFirstNameAndAddressQuery(@Param("firstName") String firstName,@Param("address")String address);

    List<Customer> withAddressNamedQuery(String address);
}
