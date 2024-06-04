package edu.badpals.repo;
import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import edu.badpals.Objects.MagicalItem;

import edu.badpals.Objects.Wizard;


@ApplicationScoped
public class Repositorio {

    @Inject
    WizardRepo WizardRepo;

    @Inject
    ItemRepo ItemRepo;

    @Inject
    OrderRepo repoOrder;

    public Optional<Wizard> loadWizard(String name) {
        return Optional.ofNullable(this.WizardRepo.findById(name));
    }

    public Optional<MagicalItem> loadItem(String name) {
        return this.ItemRepo.find("name", name).firstResultOptional();
    }

    

    
}