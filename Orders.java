package eStoreProduct.model;

public class Orders {
	private int id;
	private String name;
	private double price;
	private String description;
	private String imageUrl;
	private int ordid;

	

	public Orders(int id, String name, double price, String description, String imageUrl,int ordid) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imageUrl = imageUrl;
		this.ordid=ordid;
	}

	// Getters and setters for the class properties
	public int getOrdId() {
		return ordid;
	}

	public void  setOrdId(int ordid) {
		this.ordid = ordid;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	
}