package lk.ijse.dto;

import lombok.*;

import java.util.List;

public class PackageDTO {
    private String packageId;
    private String Description;
    private  double Price;
    private int Qty ;
    List<PackageDetailsDTO>packageDetailsDTOS;

    public PackageDTO() {

    }

    public List<PackageDetailsDTO>getPackageDetailsDTOS(){
        return packageDetailsDTOS;
    }

    public PackageDTO(String packageId, String description, double price, int qty) {
        this.packageId = packageId;
        this.Description = description;
        this.Price = price;
        this.Qty = qty;
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
}
