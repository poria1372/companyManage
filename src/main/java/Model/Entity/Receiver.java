package Model.Entity;


import javax.persistence.*;

@Table(name = "receiver")
@Entity()
public class Receiver {
    @Id
    @SequenceGenerator(name = "receiver", sequenceName = "receiver_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "receiver")
    @Column(columnDefinition = "number")
    private int id;

    @Column(columnDefinition = "varchar2(50)")
    private String receiver;

    @ManyToOne
    @JoinColumn(name = "emailId")
    private Email email;

    public int getId() {
        return id;
    }

    public Receiver setId(int id) {
        this.id = id;
        return this;
    }

    public String getReceiver() {
        return receiver;
    }

    public Receiver setReceiver(String receiver) {
        this.receiver = receiver;
        return this;
    }

    public Email getEmail() {
        return email;
    }

    public Receiver setEmail(Email email) {
        this.email = email;
        return this;
    }
}
