package Model.Entity;

import javax.persistence.*;
import java.util.Set;

@Table(name = "employee")
@Entity
public class Employee {

    @Id
    @SequenceGenerator(name = "employee", sequenceName = "employee_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee")
    @Column(columnDefinition = "number")
    private long id;
    @Column(columnDefinition = "varchar2(30)")
    private String name;
    @Column(columnDefinition = "varchar2(30)")
    private String family;
    @Column(columnDefinition = "varchar2(30)")
    private String fatherName;
    @Column(columnDefinition = "varchar(20)")
    private String idCode;
    @Column(columnDefinition = "varchar2(20)")
    private String nationalCode;
   @Column(columnDefinition = "varchar2(30)")
    private String address;
    @Column(columnDefinition = "number")
    private long phoneNumber;
   @Column(columnDefinition = "varchar2(100)")
    private String email;
    @Column(columnDefinition = "varchar2(20)")
    private String field;
    @Column(columnDefinition = "varchar2(20)")
    private String certificate;
    @Column(columnDefinition = "varchar2(30)")
    private String surface;
    @Column(columnDefinition = "varchar2(50)")
    private String supervisor;


    @OneToOne
    @JoinColumn(name = "PARENT_ID")
    private Employee parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private Set<Employee> subordinates;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private Set<Email> emails;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL)
    private Set<Leave> leaves;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CATEGORY_EL", referencedColumnName = "ID")
    private CategoryElement role;

    public long getId() {
        return id;
    }

    public Employee setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Employee setFamily(String family) {
        this.family = family;
        return this;
    }

    public String getFatherName() {
        return fatherName;
    }

    public Employee setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public String getIdCode() {
        return idCode;
    }

    public Employee setIdCode(String idCode) {
        this.idCode = idCode;
        return this;
    }

    public String getAddress() {
        return address;
    }


    public String getNationalCode() {
        return nationalCode;
    }

    public Employee setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
        return this;
    }

    public Employee setAddress(String address) {
        this.address = address;
        return this;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public Employee setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Employee setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getField() {
        return field;
    }

    public Employee setField(String field) {
        this.field = field;
        return this;
    }

    public String getCertificate() {
        return certificate;
    }

    public Employee setCertificate(String certificate) {
        this.certificate = certificate;
        return this;
    }


    public String getSurface() {
        return surface;
    }

    public Employee setSurface(String surface) {
        this.surface = surface;
        return this;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public Employee setSupervisor(String supervisor) {
        this.supervisor = supervisor;
        return this;
    }

    public Employee getParent() {
        return parent;
    }

    public Employee setParent(Employee parent) {
        this.parent = parent;
        return this;
    }

    public Set<Employee> getSubordinates() {
        return subordinates;
    }

    public Employee setSubordinates(Set<Employee> subordinates) {
        this.subordinates = subordinates;
        return this;
    }

    public Set<Email> getEmails() {
        return emails;
    }

    public Employee setEmails(Set<Email> emails) {
        this.emails = emails;
        return this;
    }

    public Set<Leave> getLeaves() {
        return leaves;
    }

    public Employee setLeaves(Set<Leave> leaves) {
        this.leaves = leaves;
        return this;
    }

    public CategoryElement getRole() {
        return role;
    }

    public Employee setRole(CategoryElement role) {
        this.role = role;
        return this;
    }
}
