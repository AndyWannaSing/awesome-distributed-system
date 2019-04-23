package awesome.user.api.bean;

import java.io.Serializable;

/**
 * @author: Andy
 * @time: 2019/4/16 21:38
 * @since
 */
public class User implements Serializable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return new StringBuilder("User[")
                .append("id=").append(id)
                .append("name=").append(name)
                .append("]").toString();
    }
}
