package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.services.BankAccountService;

@Controller
@RequestMapping("/bankaccount")
public class BankAccountController {

    private BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }


    @GetMapping
    public String getBankAccountPage(Model model){
        model.addAttribute("bankaccounts",bankAccountService.getBankAccounts());
        return "bankaccount";
    }

    @PostMapping
    public String openAccount(@ModelAttribute BankAccount bankAccount, Model model) {
        bankAccountService.openBankAccount(bankAccount);
        model.addAttribute("bankaccounts",bankAccountService.getBankAccounts());
        return "redirect:bankaccount";
    }

}