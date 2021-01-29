package ma.youcode.dao;
import ma.youcode.model.Produit;
import ma.youcode.connexion.FileConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProduitDaoImpl implements ProduitDao {
    Statement statement = null;
    ResultSet rs = null;
    FileConnection conn;
   /* @Override
    public void ajouterProduit() throws SQLException, ClassNotFoundException {
        /*String query = "insert into produit(id_produit,nom,quantite, marque, prix) values(4,'PC', '50', 'accer', '60000')";
        statement = FileConnection.getConnexion().createStatement();
        int nmb = statement.executeUpdate(query);
    }*/
    @Override
    public List<Produit> showProduit() throws SQLException, ClassNotFoundException {
        List<Produit> prodts = new ArrayList<>();

        statement = FileConnection.getConnexion().createStatement();
        String query = "SELECT * FROM produit";
        rs = statement.executeQuery(query);

        while(rs.next()){
            int id_produit = rs.getInt("id_produit");
            String nom = rs.getString("nom");
            int quantite = rs.getInt("quantite");
            String marque = rs.getString("marque");
            int prix = rs.getInt("prix");
            System.out.println(id_produit +"\t\t"+ nom+"\t\t" + quantite + "\t\t"+marque + "\t\t"+prix );
        }
        return prodts;
    }

    @Override
    public void ajouterProduit(String nom, int quantite, String marque, int prix) throws SQLException, ClassNotFoundException {
         /*String query = "insert into produit(idProduit,nom,quantite, marque, prix) values(4,'PC', '50', 'accer', '60000')";
        statement = FileConnection.getConnexion().createStatement();
        int nmb = statement.executeUpdate(query);*/
        String query = "INSERT INTO produit (nom, quantite, marque, prix)" +
                "VALUES(?,?,?,?)";
        PreparedStatement prepstatement = FileConnection.getConnexion().prepareStatement(query);
        //prepstatement.setInt (1,idProduit);
        prepstatement.setString   (1, nom);
        prepstatement.setInt(2,quantite);
        prepstatement.setString    (3,marque);
        prepstatement.setInt   (4,prix);
        prepstatement.executeUpdate();
        System.out.println("added");
    }

    @Override
    public void deleteById(int idProduit) throws SQLException, ClassNotFoundException {
        String query = "delete from produit where id_produit = ?";
        PreparedStatement prepstatement = FileConnection.getConnexion().prepareStatement(query);
        prepstatement.setInt (1,idProduit);
        prepstatement.executeUpdate();
        System.out.println("the product " + idProduit +" was deleted");

    }

    @Override
    public void modifierProduit(int idProduit, String nom, int quantite, String marque, int prix) throws SQLException, ClassNotFoundException {
        //String query = "UPDATE produit SET nom=?, quantite = ?, marque =?, prix = ? WHERE id_produit = ?";
        String query = "UPDATE `produit` SET `nom`= ?,`quantite`= ?,`marque`= ?,`prix`= ? WHERE id_produit = ?";
        PreparedStatement prepstatement = FileConnection.getConnexion().prepareStatement(query);
        //idProduit = rs.getInt("id_produit");
        prepstatement.setString(1, nom);
        prepstatement.setInt   (2, quantite);
        prepstatement.setString(3, marque);
        prepstatement.setInt   (4, prix);
        prepstatement.setInt   (5,idProduit);
        prepstatement.executeUpdate();
        System.out.println("update done");

        //System.out.println("the product was updated" +"\t\t"+ nom+"\t\t" + quantite + "\t\t"+marque + "\t\t"+prix );
    }


}
