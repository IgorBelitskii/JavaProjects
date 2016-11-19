package tel_ran.books.entity;

import javax.persistence.Entity;

@Entity
public class BestSeller extends LiteratureBook {

	public BestSeller(int yearSeller) {
		super();
		this.yearSeller = yearSeller;
	}

	int yearSeller;

	public BestSeller() {
	}

}
