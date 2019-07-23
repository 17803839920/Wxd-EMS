package bean;

public class Person {
    private String id;//id唯一标识符
    private String name;
    private String phoneNumber;
    private String sex;
    private String email;
    private String address;
    private String birthday;

    public Person() {
    }

    public Person(String id, String name, String phoneNumber, String sex, String email, String address, String birthday) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
    }

    public Person(String name, String phoneNumber, String sex, String email, String address, String birthday) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
    }

    public Person(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
