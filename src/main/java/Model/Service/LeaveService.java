package Model.Service;

import Model.Entity.Leave;
import Model.Repozitory.LeaveRepo;


import java.util.List;

public class LeaveService {
    private static LeaveService service= new LeaveService();
    public static LeaveService getInstance(){
        return service;
    }


    public void insertLeave(Leave leave) {
        LeaveRepo.getInstance().insertLeave(leave);
    }

    public void updateLeave(Leave leave) {
        LeaveRepo.getInstance().updateLeave(leave);
    }

    public void removeLeave(Leave leave) {
        LeaveRepo.getInstance().removeLeave(leave);
    }

    public List<Leave> selectLeave() {
        return LeaveRepo.getInstance().selectLeave();
    }

}
