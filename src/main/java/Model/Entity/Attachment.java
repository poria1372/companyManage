package Model.Entity;

import javax.persistence.*;


@Table(name = "attachment")
@Entity()
public class Attachment {
    @Id
    @SequenceGenerator(name = "att",sequenceName = "att_seq",initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "att")
    @Column(name="ID",columnDefinition = "number")
    private int id;


    @Lob
    @Column(name="attachment_file",columnDefinition = "BLOB")
    private byte[] file;


    @ManyToOne
    @JoinColumn(name = "email_id")
    private Email email;

    public int getId() {
        return id;
    }

    public Attachment setId(int id) {
        this.id = id;
        return this;
    }

    public byte[] getFile() {
        return file;
    }

    public Attachment setFile(byte[] file) {
        this.file = file;
        return this;
    }

    public Email getEmail() {
        return email;
    }

    public Attachment setEmail(Email email) {
        this.email = email;
        return this;
    }
}
