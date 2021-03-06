package REST.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries( {
	@NamedQuery(name = "CartItems.findById", query = "select o from CartItems o where o.id=:id ")
})

@XmlRootElement
@Entity
@IdClass(CartItemsID.class)
public class CartItems {

	@Id
	@ManyToOne
	@JoinColumn(name="cart_id", referencedColumnName="id")
	private ShoppingCart cart;
	
	@Id
	@ManyToOne
	@JoinColumn(name="item_id", referencedColumnName="id")
	private Item item;
	
	private int amount;
	
	public CartItems() {
		
	}
	
	public CartItems(ShoppingCart cart, Item item, int amount) {
		this.cart=cart;
		this.item=item;
		this.amount=amount;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
