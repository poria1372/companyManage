package Model.Service;

import Model.Entity.Attachment;
import Model.Repozitory.AttachmentRepo;

import java.util.List;

public class AttachmentService {
    private static AttachmentService service = new AttachmentService();


    public static AttachmentService getInstance() {
        return service;
    }

    public void insertAttachment(Attachment attachment) {
        AttachmentRepo.getInstance().insertAttachment(attachment);
    }

    public void updateAttachment(Attachment attachment) {
        AttachmentRepo.getInstance().updateAttachment(attachment);
    }

    public void removeAttachment(Attachment attachment) {
        AttachmentRepo.getInstance().updateAttachment(attachment);
    }

    public List<Attachment> selectAttachment() {
        return AttachmentRepo.getInstance().selectAttachment();
    }
}
