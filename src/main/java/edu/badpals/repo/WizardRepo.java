package edu.badpals.repo;
import jakarta.enterprise.context.ApplicationScoped;
import edu.badpals.Objects.Wizard;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class WizardRepo implements PanacheRepositoryBase<Wizard,String> { 
    
}