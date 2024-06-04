package edu.badpals.repo;

import jakarta.enterprise.context.ApplicationScoped;
import edu.badpals.Objects.MagicalItem;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class ItemRepo implements PanacheRepositoryBase<MagicalItem,String> {
    
}