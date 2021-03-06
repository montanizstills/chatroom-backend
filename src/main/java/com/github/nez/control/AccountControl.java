package com.github.nez.control;

import com.github.nez.model.Account;
import com.github.nez.model.AccountBuilder;
import com.github.nez.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller @RequestMapping(value="/account")
@CrossOrigin("http://localhost:4200")
public class AccountControl {
    private AccountService accountService;

    @Autowired
    public AccountControl(AccountService accountService){
        this.accountService=accountService;
    }

    @RequestMapping(value="/create-account", method= RequestMethod.POST)
    public ResponseEntity create(@RequestBody Account account){
         account = new AccountBuilder().setUsername(account.getUsername()).setPassword(account.getPassword()).setEmail(account.getEmail()).createAccount();
        account=accountService.createAccount(account);
        ResponseEntity<?> responseEntity = new ResponseEntity<>(account, HttpStatus.CREATED);
        System.out.println("Account: "+account +" has been created!");
        return responseEntity;
    }

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody Account account){
       account = accountService.login(account);
        ResponseEntity<?> responseEntity = new ResponseEntity<>(account, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value="find-account", method=RequestMethod.GET)
    public ResponseEntity find(@RequestBody Account account){
        account = accountService.find(account.getId());
        ResponseEntity responseEntity = new ResponseEntity<>(account,HttpStatus.OK);
        return responseEntity;
    }

//    @RequestMapping(value = "/add-friend", method=RequestMethod.PUT)
//    public ResponseEntity addFriend(@RequestBody String friendId, String myId){
//        String ourId = friendId+","+myId;
//        accountService.addFriend(ourId);
//        ResponseEntity<?> responseEntity = new ResponseEntity<>(friendId,HttpStatus.ACCEPTED);
//        return responseEntity;
//    }

//    @RequestMapping(value="get-friends-list", method=RequestMethod.GET)
//    public ResponseEntity getFriends(@PathVariable String id){
//        Account account = new AccountBuilder().setId(id).createAccount();
//        ArrayList friends = accountService.getFriends(account);
//        ResponseEntity responseEntity = new ResponseEntity(friends, HttpStatus.OK);
//        return responseEntity;
//    }

}
