package info.sjd.model;

public class Product {
	private String name;
	private String display;
	private String cpu;
	private String ram;
	private String hdd;
	private String keyboard;
	private String color;
	private String product_number;
	private String os;
	private String battery;

	private final static String SEP = System.getProperty("line.separator");

	public Product() {
		super();
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public Product(String name, String display, String cpu, String ram, String hdd, String keyboard, String color,
			String product_number, String os, String battery) {
		super();
		this.name = name;
		this.display = display;
		this.cpu = cpu;
		this.ram = ram;
		this.hdd = hdd;
		this.keyboard = keyboard;
		this.color = color;
		this.product_number = product_number;
		this.os = os;
		this.battery = battery;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", display=" + display + ", cpu=" + cpu + ", ram=" + ram + ", hdd=" + hdd
				+ ", keyboard=" + keyboard + ", color=" + color + ", product_number=" + product_number + ", os=" + os
				+ ", battery=" + battery + "]";
	}

	public String toXML() {
		StringBuilder result = new StringBuilder();
		result.append("<ITEMS>" + SEP);
		result.append("<ITEM>" + SEP);
		result.append("<NAME>" + SEP);
		result.append(name);
		result.append(SEP);
		result.append("</NAME>" + SEP);
		
		result.append("<DISPLAY>" + SEP);
		result.append(display);
		result.append(SEP);
		result.append("</DISPLAY>" + SEP);
		
		result.append("<CPU>" + SEP);
		result.append(cpu);
		result.append(SEP);
		result.append("</CPU>" + SEP);

		result.append("<RAM>" + SEP);
		result.append(ram);
		result.append(SEP);
		result.append("</RAM>" + SEP);

		result.append("<HDD>" + SEP);
		result.append(hdd);
		result.append(SEP);
		result.append("</HDD>" + SEP);

		result.append("<KEYBOARD>" + SEP);
		result.append(keyboard);
		result.append(SEP);
		result.append("</KEYBOARD>" + SEP);

		result.append("<COLOR>" + SEP);
		result.append(color);
		result.append(SEP);
		result.append("</COLOR>" + SEP);

		result.append("<PRODUCT_NUMBER>" + SEP);
		result.append(product_number);
		result.append(SEP);
		result.append("</PRODUCT_NUMBER>" + SEP);

		result.append("<OS>" + SEP);
		result.append(os);
		result.append(SEP);
		result.append("</OS>" + SEP);

		result.append("<BATTERY>" + SEP);
		result.append(battery);
		result.append(SEP);
		result.append("</BATTERY>" + SEP);

		
		
		result.append("</ITEM>" + SEP);
		result.append("</ITEMS>");

		return result.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getHdd() {
		return hdd;
	}

	public void setHdd(String hdd) {
		this.hdd = hdd;
	}

	public String getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(String keyboard) {
		this.keyboard = keyboard;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getProduct_number() {
		return product_number;
	}

	public void setProduct_number(String product_number) {
		this.product_number = product_number;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

}
