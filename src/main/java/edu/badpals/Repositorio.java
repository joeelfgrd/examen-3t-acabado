package edu.badpals;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;




@ApplicationScoped
public class Repositorio extends PanacheEntityBase{

    @PersistenceContext
    EntityManager em;

    
    public Optional<Wizard> loadWizard(String name) {
        Wizard wizard = em.find(Wizard.class, name);
        return Optional.ofNullable(wizard);
    }

    public Optional<MagicalItem> loadItem(String name) {
        MagicalItem item = MagicalItem.find("name", name).firstResult();
        return Optional.ofNullable(item);
    }
    public Optional<MagicalItem> loadItem(MagicalItem magicalItem) {
        List<MagicalItem> items = MagicalItem.list("name = ?1 and quality = ?2 and tipo = ?3", 
                                                   magicalItem.getName(), 
                                                   magicalItem.getQuality(), 
                                                   magicalItem.getType());
        return items.isEmpty() ? Optional.empty() : Optional.of(items.get(0));
    }
    public List<MagicalItem> loadItems(String name) {
        return MagicalItem.list("name", name);
    }

    @Transactional
    public Optional<Order> placeOrder(String wizardName, String itemName) {
        Optional<Wizard> wizardOpt = loadWizard(wizardName);
        if (wizardOpt.isEmpty() || wizardOpt.get().isMudblood()) {
            return Optional.empty();
        }

        Optional<MagicalItem> itemOpt = loadItem(itemName);
        if (itemOpt.isEmpty()) {
            return Optional.empty();
        }

        Order order = new Order();
        order.setWizard(wizardOpt.get());
        order.setItem(itemOpt.get());

        em.persist(order);

        return Optional.of(order);
    }
   

    public void createItem(String name, int quality, String tipo) {
        MagicalItem item = new MagicalItem();
        item.setName(name);
        item.setQuality(quality);
        item.setType(tipo);
        em.persist(item);
    }
    public void createItems(List<MagicalItem> items) {
        for (MagicalItem item : items) {
            MagicalItem newItem = new MagicalItem();
            newItem.setName(item.getName());
            newItem.setQuality(item.getQuality());
            newItem.setType(item.getType());
            em.persist(newItem);
        }
    }
    public void deleteItem(MagicalItem item) {
        MagicalItem managedItem = em.merge(item);
        em.remove(managedItem);
    }

    
    
}