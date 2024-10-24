package fr.fms.business;

import java.util.ArrayList;
import java.util.Scanner;

import fr.fms.dao.CategoryDao;
import fr.fms.dao.ProductDao;
import fr.fms.dao.Dao;
import fr.fms.entities.Category;
import fr.fms.entities.Product;

public class ITeachingImpl implements ITeaching {	
	
	private ArrayList<Product> products;
	private ProductDao productDao;
	private ArrayList<Category> categories;
	private CategoryDao categoryDao;

/*	Je ne m'occupe pas des commandes, tout ce qui compte c'est de:
	 l’application doit permettre à tous les utilisateurs non connectés d’afficher 	 toutes les formations disponibles, 
	 par catégorie ou pas, d’afficher toutes les formations contenant un mot clé, toutes les formations en présentiel ou distanciel.*/
	
	public ITeachingImpl () {
		products = new ArrayList<>();
		categories = new ArrayList<>();
		
		Scanner scanner = new Scanner(System.in);
		int choice = -1;
		
		while(choice != 0) {
			System.out.println("\n" + "Menu formations");
			System.out.println("1. Voir les articles");
			System.out.println("2. Voir les catégories");
			System.out.println("3. Recherche par mot clés");
			System.out.println("4. Recherche par type(presentiel ou distanciel)");
			System.out.println("5. Quitter");
			System.out.println("Veuillez faire un choix");
			
			choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
			case 1:
				products = productDao.readAll();
				for(Product product : products)
				System.out.println(product);
				break;
				/*	public ArrayList<Transaction> listTransactions(long accountId) {
		return consultAccount(accountId).getListTransactions();
	}*/
			case 2:
				categories = categoryDao.readAll();
				for(Category category = categories)
					System.out.println(category);
				break;
			case 3:
				System.out.println("Entrez le mot cle: dev, ia, data, bureautique, cyber securite");
				String keyWord = scanner.nextLine();
				readByKeyWord(keyWord);
				break;
			case 4:
				System.out.println("Chosissez le type: presentiel ou distanciel");
				String type = scanner.nextLine();
				readByType(type);
				break;
			case 5:
				System.out.println("A bientôt dans la boutique de notre ecole");
				break;
				default:
					System.out.println("Choix invalide, entrez un choix comme ci-dessus");
		}


		}
	}
}
	