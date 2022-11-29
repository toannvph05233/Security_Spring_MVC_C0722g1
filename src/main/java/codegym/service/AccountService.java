package codegym.service;

import codegym.model.Account;
import codegym.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    IAccountRepo iAccountRepo;

    public void Register(Account account){
        iAccountRepo.save(account);
    }

    public Account login(String username,String password){
        return iAccountRepo.login(username,password);
    }
}
