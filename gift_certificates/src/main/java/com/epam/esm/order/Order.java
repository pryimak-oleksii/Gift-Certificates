package main.java.com.epam.esm.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import main.java.com.epam.esm.giftCertificate.GiftCertificate;
import main.java.com.epam.esm.user.User;
import main.java.com.epam.esm.utils.abstractClasses.Identifiable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order extends Identifiable {

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
//    @Column(name = "purchas   private LocalDateTime purchaseTime;\n" +
//            "\n" +
//            "    @Column(name = \"price\")\n" +
//            "    private BigDecimal price;e_time")


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "certificate_id")
    private GiftCertificate giftCertificate;

    @Column(name = "purchase_time")
    private LocalDateTime purchaseTime;

    @Column(name = "price")
    private BigDecimal price;

    public Order() {
    }

    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(LocalDateTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GiftCertificate getGiftCertificate() {
        return giftCertificate;
    }

    public void setGiftCertificate(GiftCertificate giftCertificate) {
        this.giftCertificate = giftCertificate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "purchaseTime=" + purchaseTime +
                ", price=" + price +
                ", user=" + user +
                ", giftCertificate=" + giftCertificate +
                '}';
    }
}
