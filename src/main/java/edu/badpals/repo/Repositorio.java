package edu.badpals.repo;
import java.util.Optional;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import edu.badpals.Objects.MagicalItem;
import edu.badpals.Objects.Order;
import edu.badpals.Objects.Person;
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
    @Transactional
    public Optional<Order> placeOrder(String wizard_name, String item_name) {
        Optional<Wizard> wizard = this.loadWizard(wizard_name);
        Optional<MagicalItem> item = this.loadItem(item_name);
        if (wizard.isPresent() && item.isPresent() && ! wizard.get().getPerson().equals(Person.MUDBLOOD)) {
            Order order = new Order(wizard.get(), item.get());
            this.repoOrder.persist(order);
            return Optional.of(order);
        } else {
            return Optional.empty();
        }
    }
    @Transactional
    public void createItem(String name, int quality, String type) {
        MagicalItem item = new MagicalItem(name, quality, type);
        this.ItemRepo.persist(item);
    }
    @Transactional
    public void createItems(List<MagicalItem> items) {
        this.ItemRepo.persist(items);
    }
    @Transactional
        public void deleteItem(MagicalItem item){
                Optional<MagicalItem> itemToDelete = loadItem(item);
                if (itemToDelete.isPresent()){
                        this.ItemRepo.delete(itemToDelete.get());
                }
        }

}

    
    
