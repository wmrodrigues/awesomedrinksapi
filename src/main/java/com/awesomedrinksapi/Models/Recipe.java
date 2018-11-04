package com.awesomedrinksapi.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String videoUri;
    private byte difficulty;
    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;
    private byte portionQty;
    private byte alcoholicStrength;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoUri() { return this.videoUri; }

    public void setVideoUri(String videoUri) { this.videoUri = videoUri; }

    public byte getDifficulty() { return this.difficulty; }

    public void setDifficulty(byte difficulty) { this.difficulty = difficulty; }

    public Account getAccount() { return this.account; }

    public void setAccount(Account account) { this.account = account; }

    public byte getPortionQty() { return this.portionQty; }

    public void setPortionQty(byte portionQty) { this.portionQty = portionQty; }

    public byte getAlcoholicStrength() { return this.alcoholicStrength; }

    public void setAlcoholicStrength() { this.alcoholicStrength = alcoholicStrength; }
}
