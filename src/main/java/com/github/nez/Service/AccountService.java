package com.github.nez.Service;

import com.github.nez.Model.Account;
import com.github.nez.Model.AccountBuilder;
import com.github.nez.Model.QAccount;
import com.github.nez.Respository.AccountRepository;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Service
public class AccountService {

    final private EntityManager entityManager;
    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, EntityManager entityManager) {
        this.accountRepository = accountRepository;
        this.entityManager = entityManager;
    }

    public Account createAccount(Account account) {
        account = new AccountBuilder().setUsername(account.getUsername()).setPassword(account.getPassword()).setEmail(account.getEmail()).createAccount();
        return this.accountRepository.save(account);

    }

    public Account login(Account account){
        JPAQuery query = new JPAQuery(this.entityManager);
        QAccount qAccount = QAccount.account;
        account =
      return null;
    }

//    public Account addFriend(String ourIds) {
//        String[] id = ourIds.split(",");
//        String friendId = id[0];
//        String myId = id[1];
//        if (accountRepository.existsById(friendId)) {
//            Account friendsAccount = accountRepository.findById(friendId).get();
//            Account myAccount = accountRepository.findById(myId).get();
//            myAccount.addFriend(friendsAccount);
//            return accountRepository.save(myAccount);
//        }
//        else{
//            System.out.println("sorry that account does not exist.");
//           return null;
//        }
//    }

//    public ArrayList<Account> getFriends(Account account){
//        account = accountRepository.findById(account.getId()).get();
//        return account.getFriends();
//    }

    public Account find(String id) {
    return accountRepository.findById(id).get();
    }
}

