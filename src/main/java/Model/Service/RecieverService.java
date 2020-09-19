package Model.Service;

import Model.Entity.Receiver;
import Model.Repozitory.ReceiverRepo;


import java.util.List;

public class RecieverService {
    private static RecieverService service = new RecieverService();

    public static RecieverService getInstance() {
        return service;
    }


    public void insertReceiver(Receiver receiver) {
        ReceiverRepo.getInstance().insertReceiver(receiver);
    }

    public void updateReceiver(Receiver receiver) {
        ReceiverRepo.getInstance().updateReceiver(receiver);
    }

    public void removeReceiver(Receiver receiver) {
        ReceiverRepo.getInstance().removeReceiver(receiver);
    }

    public List<Receiver> selectReciver() {
        return ReceiverRepo.getInstance().selectReceiver();
    }
}
