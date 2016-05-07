package ru.shop.chocomize.controllers;

import com.springapp.mvc.api.domain.Order;
import com.springapp.mvc.api.domain.User;
import com.springapp.mvc.api.service.OrdersService;
import com.springapp.mvc.api.service.UsersService;
import com.springapp.mvc.api.util.Constants;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import ru.shop.chocomize.aspects.annotation.IncludeMenuInfo;
import ru.shop.chocomize.form.EditionAccountFormBean;
import ru.shop.chocomize.security.AuthorizedUsersInfo;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Контроллер для работы с личным кабинетом пользователя
 */
@Controller
@RequestMapping("/cabinet")
public class CabinetController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UsersService usersService;
    @Autowired
    private OrdersService ordersService;

    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.GET)
    public String renderCabinPage(ModelMap modelMap) {
        User user = AuthorizedUsersInfo.getCurrentUser();
        modelMap.addAttribute("user", user);
        modelMap.addAttribute(Constants.ATTR_EDITION_FORM_BEAN, new EditionAccountFormBean());
        return Constants.ATTR_CABINET_PAGE;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showPasswordsLabels() {
        return Constants.ATTR_CABINET_COMPONENT;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String showOrders(ModelMap modelMap) {
        User user = AuthorizedUsersInfo.getCurrentUser();
        List<Order> orders = ordersService.getUsersOrders(user);
        modelMap.addAttribute("orders", orders);
        return Constants.ATTR_CABINET_ORDERS;
    }

    /**
     * Обработка формы
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.POST)
    public String editionForm(
              @Valid @ModelAttribute(Constants.ATTR_EDITION_FORM_BEAN) EditionAccountFormBean editionAccountFormBean,
            BindingResult bindingResult) {
        User user1 = AuthorizedUsersInfo.getCurrentUser();
        String firstName = editionAccountFormBean.getFirstName();
        String lastName = editionAccountFormBean.getLastName();
        String middleName = editionAccountFormBean.getMiddleName();
        String email = editionAccountFormBean.getEmail();
        String phone = editionAccountFormBean.getUs_phone();
        String current_password = request.getParameter("current_password");
        String new_password = request.getParameter("new_password");
        String confirmed_new_password = request.getParameter("confirmed_new_password");
        if (bindingResult.hasErrors() || !user1.getLogin().equals(email) && usersService.getUserByLogin(email) != null) {
            System.out.println(bindingResult.getAllErrors());
            if (!user1.getLogin().equals(email) && usersService.getUserByLogin(email) != null) {
                request.setAttribute("errorEmail", "Пользователь с таким E-mail уже зарегистрирован!");
            }
            request.setAttribute("user", user1);
            return Constants.ATTR_CABINET_PAGE;
        }

        CommonsMultipartFile photo = editionAccountFormBean.getPhoto();
            if (photo != null) {
                System.out.println("isEmpty: " + phone.isEmpty());
                if (!photo.isEmpty()) {
                    String filePath = request.getServletContext().getRealPath("");
                    String dirPath = filePath + "resources" + File.separator + "i" + File.separator;
                    try {
                        File dir = new File(dirPath + File.separator + photo.getOriginalFilename());
                        if (!dir.exists()) {
                            dir.createNewFile();
                        }
                        photo.transferTo(dir);
                        user1.setAvatar("/resources/i/" + photo.getOriginalFilename());
                        usersService.updateUser(user1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
                if (!user1.getName().equals(firstName) || !user1.getSecondName().equals(lastName) ||
                        !user1.getMiddleName().equals(middleName) || !user1.getPhone().equals(phone) || !user1.getLogin().equals(email)) {
                    user1.setName(firstName);
                    user1.setSecondName(lastName);
                    user1.setMiddleName(middleName);
                    user1.setPhone(phone);
                    user1.setLogin(email);
                    usersService.updateUser(user1);
                }
                System.out.println();
                if (current_password != null) {
                    System.out.println("current_password != null");
                    System.out.println("cur_pass=" + current_password);
                    System.out.println("new_pass=" + new_password);
                    System.out.println("conf_new_pass=" + confirmed_new_password);
                    if (new_password.matches(".{6,20}")
                            && DigestUtils.md5Hex(current_password).equals(user1.getHash_password()) &&
                            new_password.equals(confirmed_new_password)) {
                        user1.setHash_password(DigestUtils.md5Hex(new_password));
                        usersService.updateUser(user1);
                    } else {
                        if (!new_password.equals(confirmed_new_password)) {
                            request.setAttribute("errorConfirming", "Пароли не совпадают");
                        }
                        if (!DigestUtils.md5Hex(current_password).equals(user1.getHash_password())) {
                            request.setAttribute("wrongCurrentPassword", "Старый пароль неверный!");
                        }
                        if (!new_password.matches(".{6,20}")) {
                            request.setAttribute("errorNewPassword", "Пароль должен быть от 6 до 20 символов!");
                        }
                        request.setAttribute("user", user1);
                        return Constants.ATTR_CABINET_PAGE;
                    }
                }
                request.setAttribute("saved", "Изменения успешно сохранены.");
                request.setAttribute("user", user1);
                return Constants.ATTR_CABINET_PAGE;
            }
        }
