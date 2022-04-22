package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {

	private Date manufactureDate;
	private SimpleDateFormat dmy = new SimpleDateFormat("dd/MM/yyyy");
	
	public UsedProduct() {

	}

	public UsedProduct(String name, float price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	@Override
	public String priceTag() {
		return name + " (usado) $ " + price + " (Data de fabricação: " 
	+ dmy.format(manufactureDate) + ")";
	}

	
}
