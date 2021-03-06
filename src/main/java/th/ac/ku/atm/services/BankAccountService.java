package th.ac.ku.atm.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ac.ku.atm.model.BankAccount;
import java.util.Arrays;
import java.util.List;

@Service
public class BankAccountService {

    private RestTemplate restTemplate;

    public BankAccountService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<BankAccount> getCustomerBankAccount(int customerId) {
        //connect to BankAccount API service
        String url = "http://localhost:8091/api/bankaccount/customer/" + customerId;

        ResponseEntity<BankAccount[]> response =
                restTemplate.getForEntity(url, BankAccount[].class);


        BankAccount[] accounts = response.getBody();
        return Arrays.asList(accounts);

    }

    public List<BankAccount> getBankAccounts() {
        String url = "http://localhost:8091/api/bankaccount/";
        ResponseEntity<BankAccount[]> response =
                restTemplate.getForEntity(url, BankAccount[].class);

        BankAccount[] accounts = response.getBody();

        return Arrays.asList(accounts);

    }

    public void openBankAccount(BankAccount bankAccount) {
        String url = "http://localhost:8091/api/bankaccount";
        restTemplate.postForEntity(url, bankAccount, BankAccount.class);

    }
}
