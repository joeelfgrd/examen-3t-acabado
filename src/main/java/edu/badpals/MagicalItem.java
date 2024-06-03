package edu.badpals;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "t_items")
public class MagicalItem extends PanacheEntityBase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	public @Getter long id;

    @Column(name="item_name")
	@NotEmpty
	private @Getter @Setter String name;

    @Column(name="item_quality")
	@NotNull
	private @Getter @Setter int quality;

    @Column(name = "item_type")
	@NotEmpty
	private @Getter @Setter String type;

   
    @Override
    public String toString() {
        StringBuilder itm = new StringBuilder();
        itm.append("MagicalItem{")
            .append("id=").append(id)
            .append(", name='").append(name).append('\'')
            .append(", quality=").append(quality)
            .append(", tipo='").append(type).append('\'')
            .append('}');
        return itm.toString();
    }
    

}