package ma.youcode;

import ma.youcode.dao.ProduitDaoImpl;

import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ProduitDaoImpl test = new ProduitDaoImpl();
        test.ajouterProduit("pc", 2424, "MYMAC", 242424);
        test.deleteById(23);
        test.showProduit();
        test.modifierProduit(24,"andyANDY", 2424, "andyANDY", 242424);
        }
}
