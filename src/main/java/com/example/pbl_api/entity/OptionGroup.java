package com.example.pbl_api.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "option_group")
public class OptionGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    @OneToMany(mappedBy = "optionGroup")
    private Set<Attributes> attributesSet;

    public OptionGroup() {
    }

    public OptionGroup(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public OptionGroup(int id) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Attributes> getAttributesSet() {
        return attributesSet;
    }

    public void setAttributesSet(Set<Attributes> attributesSet) {
        this.attributesSet = attributesSet;
    }
}
