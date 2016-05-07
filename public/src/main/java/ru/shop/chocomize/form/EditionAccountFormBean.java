package ru.shop.chocomize.form;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.validation.constraints.Pattern;


public class EditionAccountFormBean {
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "[A-Za-zА-Яа-я]+",message = "Введите верное имя")
    private String firstName;
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "[A-Za-zА-Яа-я]+",message = "Введите верное имя")
    private String lastName;
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "[A-Za-zА-Яа-я]+",message = "Введите верное имя")
    private String middleName;
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",
            message = "Неверный формат email")
    private String email;
    @Pattern(regexp = "(\\d{6,13})*",
            message = "Введите верный номер телефона")
    private String us_phone;

    private CommonsMultipartFile photo;

    public EditionAccountFormBean() {
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public EditionAccountFormBean(String firstName, String lastName, String middleName, String email, String phone, String currentPassword, String password, String confirmPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
        this.us_phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "RegistrationFormBean{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + us_phone + '\'' +
                '}';
    }

    public String getUs_phone() {
        return us_phone;
    }

    public void setUs_phone(String us_phone) {
        this.us_phone = us_phone;
    }

    public CommonsMultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(CommonsMultipartFile photo) {
        this.photo = photo;
    }
}
