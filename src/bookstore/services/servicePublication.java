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

import bookstore.entities.Publication;
import bookstore.Testing.DBConnection;
import bookstore.entities.Publication;

public class  servicePublication {
Connection cnx = DBConnection.getInstance().getCnx();

public void ajouter (Publication p) {
	 String req ="INSERT INTO publication(id_publication,id_blog,id_client,contenue,commentaire) VALUES ('"+p.getId_publication()+"', '"+p.getId_blog()+"', '"+p.getId_client()+"', '"+p.getContenue()+"', '"+p.getCommentaire()+"')"; 
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("publication ajoutée");
} catch (SQLException e) {
	e.printStackTrace();
}
}
public void supprimer (Publication p) {
	 String req ="DELETE From publication WHERE id="+p.getId_publication();
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("publication supprimée");
} catch (SQLException e) {
	e.printStackTrace();
}
}
public void modifier (Publication p) {
	 String req ="UPDATE publication SET contenue='"+p.getContenue()+"' WHERE id="+p.getId_publication();
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("publication modifiée");
} catch (SQLException e) {
	e.printStackTrace();
}
}

public List<Publication> afficher ( ) {
	List<Publication> list= new ArrayList<>();
	 String req = "SELECT * from publication";
try {
	
	Statement st = cnx.createStatement();
ResultSet res =st.executeQuery(req);
while (res.next()) {
	list.add(new Publication(res.getInt("id_publication"),res.getInt("id_blog"),res.getInt("id_client"),res.getString("contenue"),res.getString("commentaire")));
}
System.out.println("blog recuperee");
} catch (SQLException e) {
	e.printStackTrace();
}
return list;
}
}


