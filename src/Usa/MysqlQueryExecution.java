package src.Usa;
import java.sql.*;

public class MysqlQueryExecution {
    private Connection connection;
    private String query;
    private Integer numeroQuery;

    public MysqlQueryExecution(Connection connection, String query, Integer numeroQuery) {
        this.connection = connection;
        this.query = query;
        this.numeroQuery = numeroQuery;
    }

    public void Execute(){
        try{
            Statement statement = this.connection.createStatement();
            ResultSet resultat = statement.executeQuery(query);
            System.out.println("\nUsa:");
            switch (numeroQuery) {
                case 0 -> {
                    System.out.println("0: le cout total des formations de l'annee derniere(2)");
                    System.out.println("-------------------------------------------------------");
                    System.out.println("nomDepartement,total_cout_formation");
                    System.out.println("-------------------------------------------------------");
                    while (resultat.next()) {
                        System.out.println(resultat.getString("nomDepartement") + "," + resultat.getString("total_cout_formation"));
                    }
                }
                case 1 -> {
                    System.out.println("1: Moyenne du salaire des employes ages entre 20 et 30 ans.");
                    System.out.println("-------------------------------------------------------");
                    System.out.println("Moyenne salaire");
                    System.out.println("-------------------------------------------------------");
                    while (resultat.next()) {
                        System.out.println(resultat.getString("moyenne_salaires"));
                    }
                }
                case 2 -> {
                    System.out.println("2: La liste des noms,fonctions, salaires des employes qui ont un salaire plus que 3500");
                    System.out.println("-------------------------------------------------------");
                    System.out.println("nom,libelle,salaire,dateDebutContrat");
                    System.out.println("-------------------------------------------------------");
                    while (resultat.next()) {
                        System.out.println(resultat.getString("nom") + "," + resultat.getString("libelle") + "," + resultat.getString("salaire") + "," + resultat.getString("dateDebutContrat"));
                    }
                }
                case 3 -> {
                    System.out.println("3: Le poste le plus performant de chaque departement avec le nom de l'emplyes et sa note (3)");
                    System.out.println("-------------------------------------------------------");
                    System.out.println("nomDepartement,libelle,nom,notePerformance");
                    System.out.println("-------------------------------------------------------");
                    while (resultat.next()) {
                        System.out.println(resultat.getString("nomDepartement") + "," + resultat.getString("libelle") + "," + resultat.getString("nom") + "," + resultat.getString("notePerformance"));
                    }
                }
                case 4 -> {
                    System.out.println("4: le nombre d'absence dans le departement ventes et marketing avec motif formation");
                    System.out.println("-------------------------------------------------------");
                    System.out.println("nb_absences");
                    System.out.println("-------------------------------------------------------\n");
                    while (resultat.next()) {
                        System.out.println(resultat.getString("nb_absences"));
                    }
                }
                case 5 -> {
                    System.out.println("5: les employes avec leur poste et departement qui possede comme moyenne de performance <=12 pour effectuer des formations");
                    System.out.println("-------------------------------------------------------");
                    System.out.println("nom,poste,departement,notePerformance");
                    System.out.println("-------------------------------------------------------");
                    while (resultat.next()) {
                        System.out.println(resultat.getString("nom") + "," + resultat.getString("poste") + "," + resultat.getString("departement") + "," + resultat.getString("notePerformance"));
                    }
                }
                case 6 -> {
                    System.out.println("6: la liste des postes libres class?? par ordre croissant des salaires de bases");
                    System.out.println("-------------------------------------------------------");
                    System.out.println("libelle,salaireBase,nombreHeuresParSemaine");
                    System.out.println("-------------------------------------------------------");
                    while (resultat.next()) {
                        System.out.println(resultat.getString("libelle") + "," + resultat.getString("salaireBase") + "," + resultat.getString("nombreHeuresParSemaine"));
                    }
                }
                case 7 -> {
                    System.out.println("7: l'impact des formations sur les performances");
                    System.out.println("-------------------------------------------------------");
                    System.out.println("nom,note_avant,date_note_avant,note_apres,date_note_apres,typeFormation,date_formation,");
                    System.out.println("-------------------------------------------------------");
                    while (resultat.next()) {
                        System.out.println(resultat.getString("nom") + "," + resultat.getString("note_avant") + "," + resultat.getString("date_note_avant") + "," + resultat.getString("note_apres") + "," + resultat.getString("date_note_apres") + "," + resultat.getString("typeFormation") + "," + resultat.getString("date_formation"));
                    }
                }
                case 8 -> {
                    System.out.println("8: le nom, la derniere performance, et le poste de l'employ?? qui a eu la plus grosse augmentation de salaire");
                    System.out.println("-------------------------------------------------------");
                    System.out.println("nom,libelle,augmentation,notePerformance");
                    System.out.println("-------------------------------------------------------");
                    while (resultat.next()) {
                        System.out.println(resultat.getString("nom") + "," + resultat.getString("libelle") + "," + resultat.getString("augmentation") + "," + resultat.getString("notePerformance"));
                    }
                }
                case 9 -> {
                    System.out.println("9: tous les employes qui ont une aaugmentation de salaire <=700 et une performance <=15");
                    System.out.println("-------------------------------------------------------");
                    System.out.println("nom,prenom,poste,departement,augmentation,performance");
                    System.out.println("-------------------------------------------------------");
                    while (resultat.next()) {
                        System.out.println(resultat.getString("nom") + "," + resultat.getString("prenom") + "," + resultat.getString("poste") + "," + resultat.getString("departement") + "," + resultat.getString("augmentation") + "," + resultat.getString("performance"));
                    }
                }
                default -> {
                    return;
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
