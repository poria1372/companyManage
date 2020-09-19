package Model.Entity;

import javax.persistence.*;

@Table(name = "leave")
@Entity()
public class Leave {
    @Id
    @SequenceGenerator(name = "leave",sequenceName = "leave_seq",initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "leave")
    @Column(name= "ID",columnDefinition = "number")
    private int id;

    @Column(columnDefinition = "varchar2(20)")
    private String leaveCondition;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_Applicant_ID")
    private Employee applicant;

    @Column(columnDefinition = "varchar2(20)")
    private String fromDate;

    @Column(columnDefinition = "varchar2(20)")
    private String upToDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LEAVE_TYPE_CAT_ELEMENT_ID", referencedColumnName = "ID")
    private CategoryElement leaveType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LEAVE_State_CAT_ELEMENT_ID", referencedColumnName = "ID")
    private CategoryElement leaveState;

    public int getId() {
        return id;
    }

    public Leave setId(int id) {
        this.id = id;
        return this;
    }

    public String getLeaveCondition() {
        return leaveCondition;
    }

    public Leave setLeaveCondition(String leaveCondition) {
        this.leaveCondition = leaveCondition;
        return this;
    }

    public Employee getApplicant() {
        return applicant;
    }

    public Leave setApplicant(Employee applicant) {
        this.applicant = applicant;
        return this;
    }

    public String getFromDate() {
        return fromDate;
    }

    public Leave setFromDate(String fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    public String getUpToDate() {
        return upToDate;
    }

    public Leave setUpToDate(String upToDate) {
        this.upToDate = upToDate;
        return this;
    }

    public CategoryElement getLeaveType() {
        return leaveType;
    }

    public Leave setLeaveType(CategoryElement leaveType) {
        this.leaveType = leaveType;
        return this;
    }

    public CategoryElement getLeaveState() {
        return leaveState;
    }

    public Leave setLeaveState(CategoryElement leaveState) {
        this.leaveState = leaveState;
        return this;
    }
}
