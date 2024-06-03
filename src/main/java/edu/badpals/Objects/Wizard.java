package edu.badpals.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


    @Entity
    @Table(name="t_wizards")
    @NoArgsConstructor 
    public class Wizard {
    
    @Id
	@Column(name="wizard_name")
	private @Getter String name;
	
	@Column(name="wizard_dexterity")
	private @Getter @Setter int dexterity;

	@Column(name = "wizard_person")
	@Enumerated(EnumType.STRING)
	private @Getter @Setter Person person;

    @Override
    public String toString() {
       StringBuilder wzrd = new StringBuilder();
         wzrd.append("Wizard{")
              .append("name=").append(name)
              .append(", dexterity=").append(dexterity)
              .append(", person=").append(person)
              .append('}');
            return wzrd.toString();
    }
        

    
}