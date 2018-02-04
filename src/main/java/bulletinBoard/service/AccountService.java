package bulletinBoard.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bulletinBoard.domain.Account;

@Service
public class AccountService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional	
	public Account createAccount(Account account){
		Account newAccount =new Account();
		newAccount=account;
		entityManager.persist(newAccount);
		return newAccount;
	}
}
