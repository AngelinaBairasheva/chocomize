package ru.shop.chocomize.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by SDS on 06.04.2016.
 */
public class EditionAccountFormBean {
    @NotEmpty(message = "Поле обязательно для заполнения")
    private String firstName;

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String lastName;
    @NotEmpty(message = "Поле обязательно для заполнения")
    private String middleName;
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",
            message = "Неверный формат email")
    private String email;

    @Pattern(regexp = "\\d{3,13}",
            message = "Введите верный номер телефона")
    private String phone;

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    @Size(min = 6, max = 20, message = "Пароль должен быть от 6 до 20 символов")
    private String currentPassword;
    @Size(min = 6, max = 20, message = "Пароль должен быть от 6 до 20 символов")
    private String password;

    @Size(min = 6, max = 20, message = "Пароль должен быть от 6 до 20 символов")
    private String confirmPassword;

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
        this.phone = phone;
        this.currentPassword = currentPassword;
        this.password = password;
        this.confirmPassword = confirmPassword;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "RegistrationFormBean{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
