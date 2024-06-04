package edu.badpals.repo;
import jakarta.enterprise.context.ApplicationScoped;

import edu.badpals.Objects.Order;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class OrderRepo implements PanacheRepositoryBase<Order,String> {
    
}