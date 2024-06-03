package edu.badpals;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "t_wizards")
public class Wizard extends PanacheEntityBase {
    @Id
    @Column(name = "wizard_name")
    public String name;

    @Column(name = "wizard_dexterity")
    public int dexterity;

    public enum PersonType {
        MUGGLE, SQUIB, NOMAJ, MUDBLOOD
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "wizard_person")
    public PersonType person;

    public String getName() {
        return name;
    }

    public String getPerson() {
        return person.toString();
    }

    public int getDexterity() {
        return dexterity;
    }

    @Override
    public String toString() {
        return "Wizard{" +
            "name='" + name + '\'' +
            ", dexterity=" + dexterity +
            ",wizard_person=" + person +
            '}';
    }

    public boolean isMudblood() {
        return person == PersonType.MUDBLOOD;
    }
}