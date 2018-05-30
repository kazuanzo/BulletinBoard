package bulletinBoard.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bulletinBoard.domain.Account;

@Service
public class AccountService {
	@Autowired
    private PasswordEncoder passwordEncoder;
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional	
	public Account createAccount(Account account){
		Account newAccount =new Account();
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		newAccount=account;
		entityManager.persist(newAccount);
		return newAccount;
	}
}
