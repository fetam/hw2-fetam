package hw2;

public class Car {
	    
	    String vin, _brand, _model;
	    int _year, _mileage;
	    double _price;
	    char _color;
	    boolean _brandnew;
	    
	    Car() {
	        vin = "NULL";
	        _brand = "NULL";
	        _model = "NULL";
	        _year = 0;
	        _mileage = 0;
	        _price = 0;
	        _color = ' ';
	        _brandnew = false;
	    }
	    
	    public void setVin(String v) { 
	        vin = v; 
	    }
	    
	    public String getVin() {
	        return vin; 
	    }
	    
	    public void setBrand(String b) {
	        _brand = b; 
	    }
	    
	    public String getBrand() {
	        return _brand; 
	    }
	    
	    public void setModel(String m)
	    { _model = m; }
	    
	    public String getModel() {
	        return _model;
	    }
	    
	    public void setYear(int y) {
	        _year = y;
	    }
	    
	    public int getYear() {
	        return _year;
	    }
	    
	    public void setMile(int mi) {
	        _mileage = mi; 
	    }
	    
	    public int getMile() {
	        return _mileage;
	    }
	    
	    public void setPrice(double p) {
	        _price = p;
	    }
	    
	    public double getPrice() {
	        return _price;
	    }
	    
	    public void setColor(char c) {
	        _color = c;
	    }
	    
	    public char getColor() {
	        return _color; 
	    }
	    
	    public void setBrandnew(boolean bn) {
	        _brandnew = bn;
	    }
	    
	    public boolean getBrandnew() {
	        return _brandnew; 
	    }
	}