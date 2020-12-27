
public class OutdoorsArea extends Location {

	private String weather;

	public OutdoorsArea(String name, String description, String shortDescription, String weather) {
		super(name, description, shortDescription);
		this.weather = weather;
	}

	public void printLocation() {
		super.printLocation();
		System.out.println("The weather is " + weather);
	}

	// Getters och setters
	public void setWeather(String weather) {
		this.weather = weather;
	}
}