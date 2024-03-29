package com.epam.esm.tag;


import com.epam.esm.giftCertificate.GiftCertificate;
import com.epam.esm.utils.abstractClasses.Identifiable;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "tags")
public class Tag extends Identifiable {

    public Tag() {
    }

    @Column(name = "name")
    private String name;

    public Tag(String name) {
        this.name = name;
    }
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "tags")
    @JsonIgnore
    private Set<GiftCertificate> giftCertificateSet = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<GiftCertificate> getGiftCertificateSet() {
        return giftCertificateSet;
    }

    public void setGiftCertificateSet(Set<GiftCertificate> giftCertificateSet) {
        this.giftCertificateSet = giftCertificateSet;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name + '\'' +
                ", giftCertificateSet=" + giftCertificateSet +
                '}';
    }
}
