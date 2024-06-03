package edu.badpals;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
    
@Table(name = "t_orders")
public class Order extends PanacheEntityBase {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ord_id")
    public long id;
    @ManyToOne
    @JoinColumn(name = "ord_wizard")
    public Wizard wizard;
    @ManyToOne
    @JoinColumn(name = "ord_item")
    public MagicalItem item;
    public Order() {}
    public Order(Wizard wizard, MagicalItem item){
        this.wizard = wizard;
        this.item = item;
    }

    public long getId(){
        return id; }
    public Wizard getWizard(){
        return wizard;
    }
    public MagicalItem getItem(){
        return item;
    }
    public void setWizard(Wizard wizard){
        this.wizard = wizard;
    }
    public void setItem(MagicalItem item){
        this.item = item;
    }
    @Override
    public String toString() {
        StringBuilder ordr = new StringBuilder();
        ordr.append("Order{")
            .append("id=").append(id)
            .append(", wizard=").append(wizard)
            .append(", item=").append(item)
            .append('}');
        return ordr.toString();
    }
}



