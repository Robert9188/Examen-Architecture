/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Robert
 */
public class ModelsArticle {

    private int id;
    private String nom;
    private String description;
    private String contact;

    public ModelsArticle() {
    }

    public ModelsArticle(int id, String nom , String description, String contact) {
        this.id = id;
        this.nom = nom;
        this.description= description;
        this.contact= contact;
    }

    public String getContact() {
        return contact;
    }


    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public ModelsArticle(String nom, String description, String contact) {
        this.nom = nom;
        this.description = description;
        this.contact = contact;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
