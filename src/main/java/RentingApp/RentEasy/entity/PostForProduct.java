package RentingApp.RentEasy.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PostFotProduct")
public class PostForProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ProductName")
    private String ProductName;

    @Column(name = "Brandname")
    private String Brand;

    @Column(name = "Location")
    private String Location;

    @Column(name = "Type")
    private String Type;

    public PostForProduct() {

    }

    public PostForProduct(int id, String productName, String brand, String location, String type) {
        this.id = id;
        ProductName = productName;
        Brand = brand;
        Location = location;
        Type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "PostForProduct{" +
                "id=" + id +
                ", ProductName='" + ProductName + '\'' +
                ", Brand='" + Brand + '\'' +
                ", Location='" + Location + '\'' +
                ", Type='" + Type + '\'' +
                '}';
    }
}