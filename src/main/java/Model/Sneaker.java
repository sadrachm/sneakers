package Model;

public class Sneaker {
    public String color;
    public String name;
    public String brand;
    public String price;

    public Sneaker(){};

    public Sneaker(String name, String brand, String color, String price) {
        this.color = color;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public String getColor(){
        return this.color;
    }
    public void setColor(String color){
        this.color = color;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getBrand(){
        return this.brand;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getPrice(){
        return this.price;
    }
    public void setPrice(String price){
        this.price = price;
    }


}
