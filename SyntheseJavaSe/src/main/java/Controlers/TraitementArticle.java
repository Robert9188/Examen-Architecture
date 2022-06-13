/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;

import Dao.ConnexionBase;
import Models.ModelsArticle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Robert
 */
public class TraitementArticle {
    
    //1 Ajout Article 
    
     public void Ajout(ModelsArticle ma){
    
        // connexion a  la base de donnés
    ConnexionBase cb = new ConnexionBase();
    
    cb.conn();
    
    // Requet SQL
    
    String req = "Insert into article(nom, description, contact) values ('"+ma.getNom()+"','"+ma.getDescription()+ "','"+ma.getContact()+"')";
     
    //  Execution de la requete
        try {
            cb.Stat.executeUpdate(req);
            JOptionPane.showMessageDialog(null,"Enregistrement effectuer");
        } catch (SQLException ex) {
            Logger.getLogger(TraitementArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
     //2 Modifier Article
    public void Modifier(ModelsArticle ma ){
    
        ConnexionBase cb = new ConnexionBase();
        
        cb.conn();
        
        String req = "Update article set nom='"+ma.getNom()+"', description= '"+ma.getDescription()+"', contact= '"+ma.getContact()+"' where id='"+ma.getId()+"'";
    
        try {
            cb.Stat.executeUpdate(req);
             JOptionPane.showMessageDialog(null,"Modification effectuer");
            
        } catch (SQLException ex) {
            Logger.getLogger(TraitementArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
    //3 Supprimer Utilisateur
    
    public void Supp(int id){
    
        ConnexionBase cb = new ConnexionBase();
        
        cb.conn();
    
        String req= "Delete from article where id='"+id+"'";
        
        try {
            cb.Stat.executeUpdate(req);
            JOptionPane.showMessageDialog(null,"Suppression Effectuée");
        } catch (SQLException ex) {
            Logger.getLogger(TraitementArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
     //4 Recherche par Id
    public ModelsArticle RecherchebyID(int id){
    
        ModelsArticle ma = new ModelsArticle();
        
        ConnexionBase cb = new ConnexionBase();
        
        cb.conn();
        
        String req ="Select* from article where id='"+id+"'";
        
        try { 
            ResultSet res =  cb.Stat.executeQuery(req);
            if (res.next()){
                
            ma.setId(res.getInt("id"));
            ma.setNom(res.getString("nom"));
            ma.setDescription(res.getString("description"));
            ma.setContact(res.getString("contact"));
            }else{
             ma=null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TraitementArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ma;
        
    }
    

     
    //5 Liste Article 
     
     public ResultSet list (){
         
     ResultSet res =null;
     
     ConnexionBase cb = new ConnexionBase();
     
     cb.conn();
     String req ="Select* from article";
     try {
          res =  cb.Stat.executeQuery(req);
          
          while(res.next()){
              //System.out.println(res.getString("nom"));
            res.getString("nom");
            res.getString("description");
            res.getString("contact");
            }
	} catch (SQLException e) {
            
	// TODO Auto-generated catch block
	e.printStackTrace();
		}	
	return res;
     }
     
     
}
