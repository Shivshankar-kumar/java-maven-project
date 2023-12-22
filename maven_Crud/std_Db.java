
package maven_Crud;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity(name = "std_Db")
public class std_Db {
    @Id
    @Column
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String mobile;

    public void setId(int id) throws Exception {
        if (id > 0)
            this.id = id;
        else {
            throw new Exception("Invalid Id ");
        }
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\n" + "Name: " + name + "\n" + "City: " + city + "\n" + "Mobile: " + mobile;
    }
}
