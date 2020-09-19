package Model.Entity;

import javax.persistence.*;
import java.util.Set;

@Table(name = "category")
@Entity()
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "category")
    @SequenceGenerator(name = "category",sequenceName = "category_seq",allocationSize = 1,initialValue = 1)
    @Column(name = "ID",columnDefinition = "number")
    private  int id;

    @Column(columnDefinition = "varchar2(20)")
    private String name;

    @Column(columnDefinition = "number")
    private int code;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private Set<CategoryElement> categoryElement;

    public int getId() {
        return id;
    }

    public Category setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Category setName(String name) {
        this.name = name;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Category setCode(int code) {
        this.code = code;
        return this;
    }

    public Set<CategoryElement> getCategoryElement() {
        return categoryElement;
    }

    public Category setCategoryElement(Set<CategoryElement> categoryElement) {
        this.categoryElement = categoryElement;
        return this;
    }
}
