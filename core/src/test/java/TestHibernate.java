import com.springapp.mvc.api.domain.Categories;
import com.springapp.mvc.api.domain.Goods;
import com.springapp.mvc.api.domain.Users;
import com.springapp.mvc.api.service.CategoriesService;
import com.springapp.mvc.api.service.GoodsService;
import com.springapp.mvc.api.service.UsersService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.sql.SQLException;

public class TestHibernate {

    public static GoodsService goodsService;
    public static CategoriesService categoriesService;
    public static UsersService usersService;

    public static void init() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"shop-core.xml"}, true);

        goodsService = (GoodsService) context.getBean("goodsService");
        categoriesService = (CategoriesService) context.getBean("categoriesService");
        usersService= (UsersService) context.getBean("usersService");
    }

    public static void main(String[] args) throws SQLException {
        init();
        insert();
         //test();
    }

    public static void insert() {
        Categories category = new Categories(1L,"Chocolate");
        categoriesService.addCategory(category);
        Categories categories = new Categories(2L,"Hot Chocolate on a Spoon","Hot chocolate on a stick | Hot chocolate on a spoon",
                category, "/resources/i/Hot-Chocolate-On-A-Stick.png");
        categoriesService.addCategory(categories);
        Categories categories3 = new Categories(3L,"Sweet-Stuffs");
        categoriesService.addCategory(categories3);
        Categories categories1=new Categories(4L,"Popular Chocolate Bars","Premium Belgian chocolate bars | Chocomize Bestsellers",
                category,"/resources/Custom-Chocolate-Shop.png");
        categoriesService.addCategory(categories1);
        Categories categories2=new Categories(5L,"Chocolate Sets",category);
        categoriesService.addCategory(categories2);
        Categories categories4=new Categories(7L,"Luxury Truffles", "Luxury Truffle Gifts",categories3,"/resources/Handmade-Chocolate-Truffles_1.png");
        categoriesService.addCategory(categories4);
        Categories categories5=new Categories(8L,"Newest");
        categoriesService.addCategory(categories5);
        Categories categories7=new Categories(9L,"Easter Specials (NEW)","Easter Specials (NEW) - Chocolate Shop",categories5);
        categoriesService.addCategory(categories7);
        Categories categories8=new Categories(10L,"Macarons (NEW)", "The best macarons in NYC | Chocomize",categories5);
        categoriesService.addCategory(categories8);
        Categories categories9=new Categories(11L,"Chocolate Covered Goodies","Chocolate covered gummy bears &amp; nuts",categories3);
        categoriesService.addCategory(categories9);
        Categories categories10=new Categories(12L,"Business Gifts","Chocolate business gifts | Chocomize",categories2);
        categoriesService.addCategory(categories10);

        Goods goods = new Goods( 1L,"LOVE Bar", new BigDecimal(150), 10, "/resources/i/love-bar_web.jpg", "345L", 536,
                "сахар, какао-тертое, какао-масло, обезжиренный какао- порошок, эмульгатор- соевый лецитин, натуральный ароматизатор- ваниль, вишня, клубника\n" +
                        "Продукт может содержать следы орехов, фруктов, молока, яичного белка", 250, "картонная упаковка",  categories1,"190 x 80 x 10 мм",
        "ChocoART", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г","Corporate Chocolate Gifts");
        goodsService.addGood(goods);
        Goods goods7 = new Goods(2L,"Golden Love", new BigDecimal(155), 10, "/resources/i/golden-love_web.jpg", "355L", 536,
                " какао тертое, пудра сахарная, помело сушеный, ядро орехов фундука, какао масло, ядро фундука жареное дробленое, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин. ", 100, "пакет",  categories1,"190 x 80 x 10 мм",
                "ChocoART", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г","Wedding Favors");
        goodsService.addGood(goods7);
        Goods goods6 = new Goods(3L,"Cookie Bar", new BigDecimal(150), 10, "/resources/i/cookie-bar_1.jpg", "365L", 536,
                "какао тертое, пудра сахарная, вишня вяленая, ядро орехов фундука, какао масло, ядро фундука жареное дробленое, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин. ", 110, "картонная коробка", categories1,"190 x 80 x 10 мм",
                "Mary Brussels", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г");
        goodsService.addGood(goods6);
        Goods goods8 = new Goods(4L,"Smores Bar", new BigDecimal(200), 10, "/resources/i/smores_web.jpg", "366L", 536,
                "какао тертое, пудра сахарная, ядро миндаля сладкого, ядро миндаля(струганное), кофе натуральный жареный молотый, какао масло, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин.", 110, "пакет", categories1,"190 x 80 x 10 мм",
                "Mary Brussels", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г");
        goodsService.addGood(goods8);
        Goods goods9 = new Goods(5L,"The Gold Rush", new BigDecimal(220), 10, "/resources/i/gold-rush_web.jpg", "367L", 536,
                "какао тертое, пудра сахарная, ядро миндаля сладкого, ядро миндаля(струганное), кофе натуральный жареный молотый, какао масло, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин.", 110, "пакет", categories1,"190 x 80 x 10 мм",
                "Mary Brussels", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г","Events & Party Favors");
        goodsService.addGood(goods9);
        Goods goods10 = new Goods(6L,"The Zimmern", new BigDecimal(200), 10, "/resources/i/zimmern_web.jpg", "368L", 536,
                "какао тертое, пудра сахарная, вишня вяленая, ядро орехов фундука, какао масло, ядро фундука жареное дробленое, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин. ", 100, "пластиковая упаковка", categories1,"190 x 80 x 10 мм",
                "Newhaus", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г","Events & Party Favors");
        goodsService.addGood(goods10);
        Goods goods11 = new Goods(7L,"Happy Birthday Bar", new BigDecimal(150), 10, "/resources/i/happy-birthday_web_1.jpg", "369L", 536,
                " какао тертое, пудра сахарная, ядро миндаля сладкого, ядро миндаля(струганное), кофе натуральный жареный молотый, какао масло, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин.", 80, "пластиковая упаковка", categories1,"190 x 80 x 10 мм",
                "Newhaus", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г","Events & Party Favors");
        goodsService.addGood(goods11);
        Goods goods12 = new Goods(8L,"Salted Caramel Crunch", new BigDecimal(90), 10, "/resources/i/salted-caramel_web.jpg", "370L", 536,
                " какао тертое, пудра сахарная, помело сушеный, ядро орехов фундука, какао масло, ядро фундука жареное дробленое, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин. ", 100, "пластиковая упаковка", categories1,"190 x 80 x 10 мм",
                "Newhaus", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г","Events & Party Favors");
        goodsService.addGood(goods12);
        Goods goods13 = new Goods(9L,"Hot Chocolate on A Spoon - Pure Milk",new BigDecimal(90.95),
                10, "/resources/i/hot_chocolate_on_a_stick_pure_milk_chocolate_2.jpg", "485L", 536,
                "Pure Belgian Milk Chocolate ", 250, "пластиковая упаковка", categories,"190 x 80 x 10 мм",
                "Godiva", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г","Events & Party Favors");
        goodsService.addGood(goods13);
        Goods goods14 = new Goods(10L,"The Love Collection",new BigDecimal(90.50),
                10, "/resources/i/love-set-web.png", "489L", 536,
                "какао тертое, пудра сахарная, вишня вяленая, ядро орехов фундука, какао масло, ядро фундука жареное дробленое, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин.", 250, "пластиковая упаковка", categories2,"190 x 80 x 10 мм",
                "Chocomize", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г","Wedding Favors");
        goodsService.addGood(goods14);
        Goods goods1 = new Goods(11L,"The Modern Collection", new BigDecimal(290), 11, "/resources/i/love-truffles.jpg", "371L", 537,
                "какао тертое, пудра сахарная, папайя сушеная, ядро миндаля сладкого, какао масло, ядро миндаля (струганное), эмульгатор лецитин, ароматизатор идентичный натуральному ванилин.", 100, "пластиковая упаковка", categories4,"190 x 80 x 10 мм",
                "Godiva", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г");
        goodsService.addGood(goods1);
        Goods goods2 = new Goods(12L,"Dark Chocolate Easter Bunnies - Set of 8", new BigDecimal(110), 11, "/resources/i/dark-easter-bunnies-web.jpg", "372L", 537,
                " какао тертое, пудра сахарная, помело сушеный, ядро орехов фундука, какао масло, ядро фундука жареное дробленое, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин. ", 100, "пластиковая упаковка", categories7,"190 x 80 x 10 мм",
                "Godiva", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г");
        goodsService.addGood(goods2);
        Goods goods3 = new Goods(13L,"French Macaron Collection- 6pcs", new BigDecimal(260), 11, "/resources/i/6pcs-macaron-set_2.jpg", "373L", 537,
                "какао тертое, пудра сахарная, вишня вяленая, ядро орехов фундука, какао масло, ядро фундука жареное дробленое, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин. ", 100, "пластиковая упаковка", categories8,"190 x 80 x 10 мм",
                "Godiva", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г");
        goodsService.addGood(goods3);
        Goods goods18 = new Goods(18L,"French Macaron Collection- 12pcs", new BigDecimal(290), 11, "/resources/i/12-pcs-macaron-set_1.jpg", "379L", 537,
                "какао тертое, пудра сахарная, папайя сушеная, ядро миндаля сладкого, какао масло, ядро миндаля (струганное), эмульгатор лецитин, ароматизатор идентичный натуральному ванилин.", 100, "пластиковая упаковка", categories8,"190 x 80 x 10 мм",
                "Godiva", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г");
        goodsService.addGood(goods18);
        Goods goods4 = new Goods(14L,"Chocolate Covered Cranberries", new BigDecimal(130), 11, "/resources/i/chocolate_covered_cranberries.jpg", "374L", 537,
                "Tangy cranberries covered in luscious dark chocolate!", 100, "пластиковая упаковка", categories9,"190 x 80 x 10 мм",
                "Godiva", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г");
        goodsService.addGood(goods4);
        Goods goods5 = new Goods(15L,"Classic Collection", new BigDecimal(80), 11, "/resources/i/for-everyone-collection_1_1.jpg", "375L", 537,
                " какао тертое, пудра сахарная, помело сушеный, ядро орехов фундука, какао масло, ядро фундука жареное дробленое, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин. ", 100, "пластиковая упаковка", categories10,"190 x 80 x 10 мм",
                "Godiva", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г");
        goodsService.addGood(goods5);
        Goods goods15=new Goods(16L,"Signature Bars for Corporate Gifts", new BigDecimal(130), 11, "/resources/i/NBC-custom-corporate-gift-600x600.jpg", "376L", 537,
                "какао тертое, пудра сахарная, вишня вяленая, ядро орехов фундука, какао масло, ядро фундука жареное дробленое, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин.", 100, "пластиковая упаковка", categories1,"190 x 80 x 10 мм",
                "Godiva", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г");
        goodsService.addGood(goods15);
        Goods goods16=new Goods(17L,"Signature Bars for Wedding Favors", new BigDecimal(170), 11, "/resources/i/wedding-chocolate-favor-heart-bar-600x600.jpg", "377L", 537,
                "какао тертое, пудра сахарная, папайя сушеная, ядро миндаля сладкого, какао масло, ядро миндаля (струганное), эмульгатор лецитин, ароматизатор идентичный натуральному ванилин.", 100, "пластиковая упаковка", categories1,"190 x 80 x 10 мм",
                "Godiva", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г","Wedding Favors");
        goodsService.addGood(goods16);
        Goods goods17=new Goods(17L,"Hot Chocolate on a Spoon Event Favors", new BigDecimal(350), 11, "/resources/i/event_hc_design.jpg", "378L", 537,
                "какао тертое, пудра сахарная, вишня вяленая, ядро орехов фундука, какао масло, ядро фундука жареное дробленое, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин.", 100, "пластиковая упаковка", categories,"190 x 80 x 10 мм",
                "Godiva", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г","Events & Party Favors");
        goodsService.addGood(goods17);
        Users user = new Users("e10adc3949ba59abbe56e057f20f883e", "milronnie@mail.ru", "Darya", "Cambell", "SS", "123", true);
        user.setRole("ROLE_USER");
        user.setKey(3434534L);
        usersService.addUser(user);
    }

    public static void test() {
        System.out.println(usersService.getUserByLogin("milronnie@mail.ru"));
//        System.out.println(categoriesService.getAllCategories());
//        System.out.println(categoriesService.getEndedCategories());
//       System.out.println(goodsService.getGoodsByCategorysId(2L));
//        System.out.println(goodsService.getNewGoods());
        /*System.out.println(goodsService.getGoodsByPage(goodsService.getGoodsByCategorysName("шоколадные композиции"), 2));
        System.out.println(goodsService.getGoodsByPage(goodsService.getGoodsByCategorysName("шоколадные композиции"), 3));*/
    }
}
