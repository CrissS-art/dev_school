package fr.fms.business;

import java.util.ArrayList;

import fr.fms.entities.Category;
import fr.fms.entities.Product;

public interface ITeaching {
//
//			public void addToCart(Product product);		
//			
//			public void removeFromCart(int id);		
//			
//			public ArrayList<Product> getCart();	
//			
//			public int order(int idUser);		
			
			public ArrayList<Product> readProducts();	

			public Product readOneProduct(int id);	

			public ArrayList<Category> readCategories();
			
			public ArrayList<Product> readProductsByCatId(int idCategory);
			
			public ArrayList<Product> readByKeyWord(String keyWord);
			
			public ArrayList<Product> readByType(String type);
		}

/*
package fr.fms.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import fr.fms.entities.Account;
import fr.fms.entities.Current;
import fr.fms.entities.Customer;
import fr.fms.entities.Transaction;
import fr.fms.entities.Transfert;
import fr.fms.entities.Withdrawal;


public class IBankImpl implements IBank {
	private HashMap<Long,Account>	accounts;
	private HashMap<Long,Customer>	customers;
	//private HashMap<Long,Transaction>	transactions;
	
	private long numTransactions;
	
	public IBankImpl() {
		accounts = new HashMap<Long,Account>();		
		customers = new HashMap<Long,Customer>();
		numTransactions = 1;	//ToDo en attendant insertion en base, incrÃ©mentation automatique
	}


	@Override
	public void addAccount(Account account) {
		accounts.put(account.getAccountId(), account);		// ajouter un compte Ã  ma liste, s'il existe dÃ©jÃ , Ã§a ne marche pas	
		Customer customer = account.getCustomer(); 			// s'agissant du client de ce compte -> ToDo s'il n'existe pas dans le compte ajoutÃ© !
		customers.put(customer.getCustomerId(), customer);  // je veux le rajouter Ã  ma liste de clients s'il n'existe pas
		
		//l'Ã©tape suivante n'est pas indispensable ici puisque nous ajoutons le client Ã  notre collection de clients ci-dessus
		//en revanche, compte tenu du diagramme de classe, un client dispose d'une liste de comptes
		addAccountToCustomer(customer, account);			// j'ajoute au client son nouveau compte bancaire uniquement s'il ne l'a pas dÃ©jÃ 
	}
	

	@Override
	public Account consultAccount(long accountId) {		
		Account account = accounts.get(accountId);
		if(account == null)	System.out.println("Vous demandez un compte inexistant !");
		return account;
	}


	@Override
	public void pay(long accountId, double amount) {				
		Account account = consultAccount(accountId);
		if(account != null)	{
			account.setBalance(account.getBalance() + amount);
			Transaction trans = new Transfert(numTransactions++,new Date(),amount,accountId);
			account.getListTransactions().add(trans);				// crÃ©ation + ajout d'une opÃ©ration de versement
		}
	}

	@Override
	public boolean withdraw(long accountId, double amount) {			
		Account account = consultAccount(accountId);
		if(account != null) {
			double capacity = 0;
			if(account instanceof Current) {
				capacity = account.getBalance() + ((Current)account).getOverdraft();	//solde + decouvert autorisÃ©				
			}
			else capacity = account.getBalance();
			if(amount <= capacity) {
				account.setBalance(account.getBalance() - amount);
				Transaction trans = new Withdrawal(numTransactions++,new Date(),amount,accountId);
				account.getListTransactions().add(trans);		// crÃ©ation + ajout d'une opÃ©ration de retrait
			}
			else {
				System.out.println("vous avez dÃ©passÃ© vos capacitÃ©s de retrait !");
				return false;
			}
		}	
		else return false;	//compte inexistant -> retrait impossible
		return true;	//retrait effectuÃ©
	}

	
	@Override
	public void transfert(long accIdSrc, long accIdDest, double amount) {	//virement
		if(accIdSrc == accIdDest)	System.out.println("vous ne pouvez retirer et verser sur le mÃªme compte !");
		else {
			if(withdraw(accIdSrc, amount)) {		//retrait si c'est possible
				pay(accIdDest, amount);				//alors versement
			}
			else System.out.println("virement impossible");
		}
	}


	@Override
	public ArrayList<Transaction> listTransactions(long accountId) {
		return consultAccount(accountId).getListTransactions();
	}
	

	public ArrayList<Account> listAccounts() {		
		return new ArrayList<Account> (accounts.values());
	}
	

	private void addAccountToCustomer(Customer customer, Account account) {
		boolean exist = false;
		for(Account acc : customer.getListAccounts()) {
			if(acc.getAccountId() == account.getAccountId()) {
				exist = true;
				break;
			}
		}
		if(exist == false)	customer.getListAccounts().add(account);
	}
}
*/