package edu.badpals.repo;
import java.util.Optional;
import java.util.List;

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

    public List<MagicalItem> loadItems(String name) {
        return this.ItemRepo.find("name", name).list();
    }

    public Optional<MagicalItem> loadItem(MagicalItem item) {
        return this.loadItems(item.getName()).stream()
        .filter(i -> i.getName().equals(item.getName()) 
        && i.getQuality() == item.getQuality() 
        && i.getType().equals(item.getType()))
        .findFirst();
    }

    
}