package Entities;

public final class ImportedProduct extends Product{
	
	private float customsFee; //Taxa alfandeg�ria == customsFee
	
	public ImportedProduct() {
		
	}

	public ImportedProduct(String name, float price, float customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public float getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(float customsFee) {
		this.customsFee = customsFee;
	}
	
	public float totalPrice() {
		return price + customsFee;
	}
	
	@Override
	public final String priceTag() {
			return name + " $ " + totalPrice() + " (Custos alfandeg�rios: $" +String.format("%.2f", customsFee);
		}
		
	
	

}
