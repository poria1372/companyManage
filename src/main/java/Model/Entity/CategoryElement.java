package Model.Entity;


import javax.persistence.*;

@Table(name = "categoryElement")
@Entity
public class CategoryElement {
    @Id
    @SequenceGenerator(name = "categoryEl", sequenceName = "categoryEl_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "categoryEl")
    @Column(name = "ID", columnDefinition = "number")
    private int id;

    @Column(columnDefinition = "varchar2(20)")
    private String name;

    @Column(columnDefinition = "varchar2(20)")
    private String role;


    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    public int getId() {
        return id;
    }

    public CategoryElement setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CategoryElement setName(String name) {
        this.name = name;
        return this;
    }

    public String getRole() {
        return role;
    }

    public CategoryElement setRole(String role) {
        this.role = role;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public CategoryElement setCategory(Category category) {
        this.category = category;
        return this;
    }
}
