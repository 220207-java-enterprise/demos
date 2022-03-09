package com.revature.boot.models;

import javax.persistence.*;

// JPA Annotations:
//   - @Entity: declares that the annotated class maps to a table
//   - @Table: implicit, but if provided allows you to specify a table name and some constraints
//   - @Id: declares the annotated field as a primary key
//   - @GeneratedValue: allows for you to specify how the primary keys are generated
//   - @Column: implicit, but if provided allows you to specify a column name and some constraints
//   - @JoinColumn: declares that the annotated field is a foreign key
//   - @OneToMany: declares the multiplicity relationship between the entity class and core field type
//   - @Embeddable: declares that the annotated class can be embedded within an entity class
//   - @Embedded: simply allows for you to embed other columns into this entity class's table
@Entity
@Table(name = "boots")
public class Boot {

    @Id
    private String id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String material;

    @Column(columnDefinition = "varchar default 'beige'")
    private String color;

    @Column(nullable = false, columnDefinition = "numeric(4,2) check (size > 0 AND size <= 23)")
    private double size;

    @Column(nullable = false)
    private double price;

    @Column(columnDefinition = "boolean default false")
    private boolean waterproof;

    @ManyToOne
    @JoinColumn(name = "owner_id") // foreign keys are mapped using @JoinColumn
    private Customer owner;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isWaterproof() {
        return waterproof;
    }

    public void setWaterproof(boolean waterproof) {
        this.waterproof = waterproof;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Boot{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", material='" + material + '\'' +
                ", color='" + color + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", waterproof=" + waterproof +
                ", owner=" + owner +
                '}';
    }

}
