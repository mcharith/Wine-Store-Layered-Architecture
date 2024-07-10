package lk.ijse.entity;

import lombok.*;

public class Package {
    private String packageId;
    private String Description;
    private  double Price;
    private int Qty ;

    public Package(String packageId, String description, double price, int qty) {
        this.packageId = packageId;
        Description = description;
        Price = price;
        Qty = qty;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    @Override
    public String toString() {
        return "Package{" +
                "packageId='" + packageId + '\'' +
                ", Description='" + Description + '\'' +
                ", Price=" + Price +
                ", Qty=" + Qty +
                '}';
    }

}
