package shop.spring.entities;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="\"CUSTOMER\"", schema="shop") // uses quotes for postgres sql dialect
public class Customer {
 
    private int id;
    private String name;
    private String surname;
 
    @Id
    @Column(name="id", unique = true, nullable = false)
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
    @Column(name="name", unique = true, nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name="surname", unique = true, nullable = false)
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", surname=" + surname	+ "]";
	}  
 }