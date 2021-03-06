package bookstore.services;

import bookstore.Testing.DBConnection;
import bookstore.entities.Livre;
import bookstore.entities.LivreKids;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class LivreKidsService{
    Connection cnx = DBConnection.getInstance().getCnx();
    public void ajouterLivreKids(LivreKids c) {
        try {
            String sql = "INSERT INTO livrekids () values (?,?,?,?) ";
            PreparedStatement st = cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            st.setString(1,c.getDescription());
            st.setString(2,c.getImage());
            st.setString(3,c.getSon());
            st.setString(4,c.getVideo());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            System.out.println("Livre ajoute");
            while(rs.next()){
                System.out.println(rs.getInt(1));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void afficherLesLivresKids(){
        //List<LivreKids> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM livrekids l INNER join categoriekids c on l.id_categorie_kids = c.id_categorie_kids";
            PreparedStatement st = cnx.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                //list.add(new LivreKids(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
                int idlivrekids = rs.getInt(1);
                int idcategoriekids = rs.getInt(2);
                String descriptionLivreKids = rs.getString(3);
                String Image = rs.getString(4);
                String Video = rs.getString(5);
                String Son = rs.getString(6);
                int idcategoriekids2 = rs.getInt(7);
                String descriptionCategorieKids = rs.getString(8);
                System.out.println(idlivrekids + " " + idcategoriekids + " " + descriptionLivreKids + " " + Image + " " + Video + " " + Son + " " + idcategoriekids2 + " " + descriptionCategorieKids);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //return list;
    }
    public void afficherLesUnLivre(){
        //List<LivreKids> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM livrekids l INNER join categoriekids c on l.id_categorie_kids = c.id_categorie_kids ";
            PreparedStatement st = cnx.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                int idlivrekids = rs.getInt(1);
                int idcategoriekids = rs.getInt(2);
                String descriptionLivreKids = rs.getString(3);
                String Image = rs.getString(4);
                String Video = rs.getString(5);
                String Son = rs.getString(6);
                int idcategoriekids2 = rs.getInt(7);
                String descriptionCategorieKids = rs.getString(8);
                System.out.println(idlivrekids + " " + idcategoriekids + " " + descriptionLivreKids + " " + Image + " " + Video + " " + Son + " " + idcategoriekids2 + " " + descriptionCategorieKids);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //return list;
    }
    public void SupprimerLivreKids(Livre c){
        try {
            String sql = "DELETE FROM livrekids where id_livre = ?";
            PreparedStatement st = cnx.prepareStatement(sql);
            st.setInt(1,c.getId_livre());
            st.executeUpdate();
            System.out.println("Livre Supprimer");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
