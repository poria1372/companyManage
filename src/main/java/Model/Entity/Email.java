package Model.Entity;

import javax.persistence.*;
import java.util.Set;

@Table(name = "email")
@Entity()
public class Email {
    @Id
    @SequenceGenerator(name = "email",sequenceName = "email_seq",allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "email")
    @Column(name="ID",columnDefinition = "number")
    private int id;

    @Column(columnDefinition = "varchar2(100)")
    private String user;

    @Column(columnDefinition = "varchar2(max)")
    private String pass;

    @Column(columnDefinition = "varchar2(100)")
    private String recipient;

    @Column(columnDefinition = "varchar2(400)")
    private String subject;

    @Column(columnDefinition = "varchar2(max)")
    private String content;


    @ManyToOne
    @JoinColumn(name = "Sende_Employee_id")
    private Employee sender;

    @OneToMany( mappedBy = "email",cascade = CascadeType.ALL)
    private Set<Receiver> receivers;

    @OneToMany(mappedBy = "email",cascade = CascadeType.ALL)
    private Set<Attachment> attachments;

    public int getId() {
        return id;
    }

    public Email setId(int id) {
        this.id = id;
        return this;
    }

    public String getUser() {
        return user;
    }

    public Email setUser(String user) {
        this.user = user;
        return this;
    }

    public String getPass() {
        return pass;
    }

    public Email setPass(String pass) {
        this.pass = pass;
        return this;
    }

    public String getRecipient() {
        return recipient;
    }

    public Email setRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Email setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Email setContent(String content) {
        this.content = content;
        return this;
    }

    public Employee getSender() {
        return sender;
    }

    public Email setSender(Employee sender) {
        this.sender = sender;
        return this;
    }

    public Set<Receiver> getReceivers() {
        return receivers;
    }

    public Email setReceivers(Set<Receiver> receivers) {
        this.receivers = receivers;
        return this;
    }

    public Set<Attachment> getAttachments() {
        return attachments;
    }

    public Email setAttachments(Set<Attachment> attachments) {
        this.attachments = attachments;
        return this;
    }
}
