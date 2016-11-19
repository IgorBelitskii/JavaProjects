package tel_ran.books.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Deal {
	@Id
	@GeneratedValue
	int id;
	int discount;
	Date date;
	@ManyToOne
	Buyer buyer;
	@ManyToOne
	Book book;
	public Deal(int discount, Date date, Buyer buyer, Book book) {
		super();
		this.discount = discount;
		this.date = date;
		this.buyer = buyer;
		this.book = book;
	}
	public Deal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	@Override
	public String toString() {
		return "Deal [discount=" + discount + ", date=" + date + ", buyer=" + buyer + "]";
	}

}
