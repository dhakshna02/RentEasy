package RentingApp.RentEasy.entity;


import jakarta.persistence.*;

import java.lang.reflect.Type;

@Entity
@Table(name = "Products")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nameOfProduct")
    private String nameOfProduct;

    @Column(name ="price")
    private int price;

    @Column(name = "brandName")
    private String brandName;

    @Column(name = "manufacturingDate")
    private String manufacturingDate;

    @Column(name = "aboutProduct")
    private String aboutProduct;

    @Column(name = "location" )
    private String location;

    @Column(name = "dateOfRental")
    private String dateOfRental;

    @Column(name = "rentalLocation")
    private String rentalLocation;

    @Column(name="type")
    private String type;


    public ProductDetails(){

    }

    public ProductDetails(String nameOfProduct, int price,
                          String brandName, String manufacturingDate, String aboutProduct,
                          String location,
                          String dateOfRental, String rentalLocation, String type) {
        this.nameOfProduct = nameOfProduct;
        this.price = price;
        this.brandName = brandName;
        this.manufacturingDate = manufacturingDate;
        this.aboutProduct = aboutProduct;
        this.location = location;
        this.dateOfRental = dateOfRental;
        this.rentalLocation = rentalLocation;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public String getAboutProduct() {
        return aboutProduct;
    }

    public void setAboutProduct(String aboutProduct) {
        this.aboutProduct = aboutProduct;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateOfRental() {
        return dateOfRental;
    }

    public void setDateOfRental(String dateOfRental) {
        this.dateOfRental = dateOfRental;
    }

    public String getRentalLocation() {
        return rentalLocation;
    }

    public void setRentalLocation(String rentalLocation) {
        this.rentalLocation = rentalLocation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "ProductDetails{" +
                "id=" + id +
                ", nameOfProduct='" + nameOfProduct + '\'' +
                ", price=" + price +
                ", brandName='" + brandName + '\'' +
                ", manufacturingDate='" + manufacturingDate + '\'' +
                ", aboutProduct='" + aboutProduct + '\'' +
                ", location='" + location + '\'' +
                ", dateOfRental='" + dateOfRental + '\'' +
                ", rentalLocation='" + rentalLocation + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

