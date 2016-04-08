package ru.shop.chocomize.controllers;

import com.springapp.mvc.api.domain.Users;
import com.springapp.mvc.api.service.UsersService;
import com.springapp.mvc.api.util.Constants;
import mail.Mailing;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.shop.chocomize.aspects.annotation.IncludeMenuInfo;
import ru.shop.chocomize.form.EditionAccountFormBean;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Random;

@Controller
@RequestMapping("/cabinet")
public class CabinetController {


    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UsersService usersService;
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.GET)
    public String renderCabinPage(@RequestParam String login) {
        Users users=usersService.getUserByLogin(login);
        request.setAttribute("name",users.getName());
        request.setAttribute("lastName",users.getSecondName());
        request.setAttribute("middleName",users.getMiddleName());
        request.setAttribute("user_login",users.getLogin());
        request.setAttribute(Constants.ATTR_EDITION_FORM_BEAN, new EditionAccountFormBean());
        return Constants.ATTR_CABINET_PAGE;
    }
    /**
     * ќбработка формы
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.POST)
    public String editionForm(
            @Valid @ModelAttribute(Constants.ATTR_EDITION_FORM_BEAN) EditionAccountFormBean editionAccountFormBean,
            BindingResult bindingResult) {
        String firstName = editionAccountFormBean.getFirstName();
        String lastName = editionAccountFormBean.getLastName();
        String middleName = editionAccountFormBean.getMiddleName();
        String email = editionAccountFormBean.getEmail();
        String phone = editionAccountFormBean.getPhone();
        String currentPassword = editionAccountFormBean.getCurrentPassword();
        String password = editionAccountFormBean.getPassword();
        String confirmPassword = editionAccountFormBean.getConfirmPassword();
        String hashPass = DigestUtils.md5Hex(password);
        String hashPassCurrent = DigestUtils.md5Hex(currentPassword);
        String current_user=request.getParameter("current_user");
        System.out.println(firstName + ", " + lastName + ", " + middleName + ", " + email + ", " + phone + ", " + password);
        if (bindingResult.hasErrors() || !password.equals(confirmPassword)||
                !hashPassCurrent.equals(usersService.getUserByLogin(current_user).getHash_password())) {
            if (!password.equals(confirmPassword)) {
                request.setAttribute("errorConfirming", "ѕароли не совпадают");
            }
            if(!hashPassCurrent.equals(usersService.getUserByLogin(current_user).getHash_password())){
                request.setAttribute("wrongCurrentPassword", "Ќеверно введЄн старый пароль");
            }
            return Constants.ATTR_CABINET_PAGE;
        }
        Users user = new Users(hashPass, email, firstName, lastName, middleName, phone, false);
        usersService.addUser(user);
        Mailing mail = new Mailing();
        long range = 1234567L;
        Random r = new Random();
        //mail.sendMail("DigitalZoneTutor@gmail.com", "milronnie@mail.ru", "NewTest", "test message");
        mail.sendMail("chockomize.shop@gmail.com", email, "Chocomize Shop", "Welcome to Chocomize, dear "+firstName+"!\n" +
                "Help us secure your account in Chocomize by verifying your email address (" + email + ").\n" +
                "Paste the following link into your browser:\n" +
                "localhost:8080/registration/confirm/?user_login=" + email + "&key=" +(long)(r.nextDouble()*range) + "\n\n" +
                "YouТre receiving this email because you recently created a new account in BookStore. If this wasnТt you, please ignore this email.");
        System.out.print(mail.isStatus());
        // здесь должна происходить регистраци€ пользовател€
        System.out.println(editionAccountFormBean);
        return Constants.ATTR_CABINET_PAGE;
    }

}
