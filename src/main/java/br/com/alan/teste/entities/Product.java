package br.com.alan.teste.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 8659755704402623853L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUri;

	// @Transient //JPA não interpreta
	@ManyToMany
	@JoinTable(                                                // associação de muitos para muitos
			name = "tb_product_category",                      // nome da tabelz q eu quiser
			joinColumns = @JoinColumn(name = "product_id"),          // product_id eu criei, pode ser qualquer nome q eu quiser
			inverseJoinColumns = @JoinColumn(name = "category_id")) // category_id eu criei, pode ser qualquer nome q eu quiser, ele vai pegar do q tem dentro do <> e jogar ali
	private Set<Category> categories = new HashSet<>();             // gerante q não vai ter mais de uma categoria igual

	@OneToMany(mappedBy = "id.product") //id(OrderItemPK).order
	private Set<OrderItem> items = new HashSet<>(); 
	
	public Product() {

	}

	public Product(Long id, String name, String description, Double price, String imgUri) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUri = imgUri;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUri() {
		return imgUri;
	}

	public void setImgUri(String imgUri) {
		this.imgUri = imgUri;
	}
	
	@JsonIgnore
	public Set<Order> getOrders() {
		Set<Order> orders = new HashSet<>();
		for (OrderItem item: items) {
			orders.add(item.getOrder());
		}
		return orders;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
