package edu.badpals;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_items")
public class MagicalItem extends PanacheEntityBase {
    public MagicalItem() {
    }
    public MagicalItem(String name, int quality, String tipo) {
        this.name = name;
        this.quality = quality;
        this.tipo = tipo;
    }
    @Id
    @Column(name = "item_id")
    public Long id=0L;

    @Column(name = " item_name")
    public String name ="";

    @Column(name = "item_quality")
    public int quality = 0;

    @Column(name = "item_type")
    public String tipo="";

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getQuality(){
        return quality;
    }

    public String getType(){
        return tipo;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setQuality(int quality){
        this.quality = quality;
    }
    public void setType(String tipo){
        this.tipo = tipo;
    }
    @Override
    public String toString() {
    return "MagicalItem{" +
        "id=" + id +
        ", nombre='" + name + '\'' +
        ", quality=" + quality +
        ", tipo='" + tipo + '\'' +
        '}';
}
}