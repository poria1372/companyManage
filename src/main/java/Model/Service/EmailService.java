package Model.Service;

import Model.Entity.Email;
import Model.Repozitory.EmailRepo;

import java.util.List;

public class EmailService {
    private  static EmailService service= new EmailService();
    public static EmailService getInstance(){
        return service;
    }

    public void insertEmail(Email email) {
        EmailRepo.getInstance().insertEmail(email);
    }

    public void updateEmail(Email email) {
        EmailRepo.getInstance().updateEmail(email);
    }

    public void removeEmail(Email email) {
        EmailRepo.getInstance().removeEmail(email);
    }

    public List<Email> selectEmail() {
        return EmailRepo.getInstance().selectEmail();
    }
}
