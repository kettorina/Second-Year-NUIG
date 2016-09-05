package warehouse;

public class Part {

	private CatalogueEntry entry;
	
	public Part(CatalogueEntry e){
		this.entry = e;
	}
	
	public String getName(){
		return this.entry.getName();
	}
	
	public long getNumber() {
		return this.entry.getNumber();
	}
	
	public double getCost() {
		return this.entry.getCost();
	}
}
