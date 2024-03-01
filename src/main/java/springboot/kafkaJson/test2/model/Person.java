package springboot.kafkaJson.test2.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.UUID;

public class Person {
    ///@NotNull(message="Id shouldn't be null.")
    @Min(1)
    private long id;
    @NotBlank(message="Name shouldn't be blank")
    private String name;
    @NotNull(message="Age shouldn't be null.")
    @Min(1)
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
