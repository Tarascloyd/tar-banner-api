package com.taras.tarbannerapi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Where(clause = "deleted = false")
public class Banner {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="name", unique = true)
    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 255, message
            = "Name must be between 2 and 255 characters")
    private String name;

    @Column(name="price")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price cannot be 0")
    @Digits(integer=8, fraction=2, message = "No more than 8 digits in integral part of the price, no more than 2 digits in fractional")
    @NotNull(message = "Price cannot be null")
    private BigDecimal price;

    @ManyToOne()
    @JoinColumn(name="category_id", nullable=false)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Category category;


    @Column(name="text")
    @NotBlank(message = "Text is mandatory")
    private String text;

    @Column(name="deleted")
    private boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
