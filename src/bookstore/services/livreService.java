/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import bookstore.entities.Livre;
import bookstore.Testing.DBConnection;

public class  livreService{
Connection cnx = DBConnection.getInstance().getCnx();

public void ajouter (Livre l) {
	 String req ="INSERT INTO Livre (id_livre, id_categorie,titre,auteur,genre,prix,image) VALUES ('"+l.getId_livre()+","+l.getId_categorie()+","+l.getTitre()+","+l.getAuteur()+","+l.getGenre()+","+l.getPrix()+","+l.getImage()+")";
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("Livre ajouté");
} catch (SQLException e) {
}
}
public void supprimer (Livre l) {
	 String req ="DELETE From Livre WHERE id="+l.getId_livre();
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("Livre");
} catch (SQLException e) {
}
}
public void modifier (Livre l) {
	 String req ="UPDATE Livre SET Prix='"+l.getPrix()+"' WHERE id="+l.getId_livre();
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("Livre modifié");
} catch (SQLException e) {
}
}

public List<Livre> afficher ( ) {
	List<Livre> list= new ArrayList<>();
	 String req = "SELECT * from Livre";
try {
	
	Statement st = cnx.createStatement();
ResultSet res =st.executeQuery(req);
while (res.next()) {
	list.add(new Livre(res.getInt("id_livre"),res.getInt("id_categorie"),res.getString("titre"),res.getString("auteur"),res.getFloat("prix"),res.getString("genre"),res.getString("image")));
}
System.out.println("Livre recupere");
} catch (SQLException e) {
}
return list;
}
}

    

