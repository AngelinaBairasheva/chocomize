import com.springapp.mvc.api.domain.Category;
import com.springapp.mvc.api.domain.Good;
import com.springapp.mvc.api.domain.Order;
import com.springapp.mvc.api.service.CategoriesService;
import com.springapp.mvc.api.service.GoodsService;
import com.springapp.mvc.api.service.OrdersService;
import com.springapp.mvc.api.service.UsersService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.SQLException;
import java.util.List;

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
        // test();
    }

    public static void insert() {
        Category category = new Category(1L,"Chocolate");
        categoriesService.addCategory(category);
        Category categories = new Category(2L,"Hot Chocolate on a Spoon","Hot chocolate on a stick | Hot chocolate on a spoon",
                category, "/resources/i/Hot-Chocolate-On-A-Stick.png");
        categoriesService.addCategory(categories);
        Category category3 = new Category(3L,"Sweet-Stuffs");
        categoriesService.addCategory(category3);
        Category category1 =new Category(4L,"Popular Chocolate Bars","Premium Belgian chocolate bars | Chocomize Bestsellers",
                category,"/resources/Custom-Chocolate-Shop.png");
        categoriesService.addCategory(category1);
        Category category2 =new Category(5L,"Chocolate Sets",category);
        categoriesService.addCategory(category2);
        Category category4 =new Category(7L,"Luxury Truffles", "Luxury Truffle Gifts", category3,"/resources/Handmade-Chocolate-Truffles_1.png");
        categoriesService.addCategory(category4);
        Category category5 =new Category(8L,"Newest");
        categoriesService.addCategory(category5);
        Category category7 =new Category(9L,"Easter Specials (NEW)","Easter Specials (NEW) - Chocolate Shop", category5);
        categoriesService.addCategory(category7);
        Category category8 =new Category(10L,"Macarons (NEW)", "The best macarons in NYC | Chocomize", category5);
        categoriesService.addCategory(category8);
        Category category9 =new Category(11L,"Chocolate Covered Goodies","Chocolate covered gummy bears &amp; nuts", category3);
        categoriesService.addCategory(category9);
        Category category10 =new Category(12L,"Business Gifts","Chocolate business gifts | Chocomize", category2);
        categoriesService.addCategory(category10);

        Good good = new Good( 1L,"LOVE Bar", new BigDecimal(150), 10, "/resources/i/love-bar_web.jpg", "345L", 536,
                "сахар, какао-тертое, какао-масло, обезжиренный какао- порошок, эмульгатор- соевый лецитин, натуральный ароматизатор- ваниль, вишня, клубника\n" +
                        "Продукт может содержать следы орехов, фруктов, молока, яичного белка", 250, "картонная упаковка", category1,"190 x 80 x 10 мм",
        "ChocoART", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г","Corporate Chocolate Gifts");
        goodsService.addGood(good);
        Good good7 = new Good(2L,"Golden Love", new BigDecimal(155), 10, "/resources/i/golden-love_web.jpg", "355L", 536,
                " какао тертое, пудра сахарная, помело сушеный, ядро орехов фундука, какао масло, ядро фундука жареное дробленое, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин. ", 100, "пакет", category1,"190 x 80 x 10 мм",
                "ChocoART", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г","Wedding Favors");
        goodsService.addGood(good7);
        Good good6 = new Good(3L,"Cookie Bar", new BigDecimal(150), 10, "/resources/i/cookie-bar_1.jpg", "365L", 536,
                "какао тертое, пудра сахарная, вишня вяленая, ядро орехов фундука, какао масло, ядро фундука жареное дробленое, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин. ", 110, "картонная коробка", category1,"190 x 80 x 10 мм",
                "Mary Brussels", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г");
        goodsService.addGood(good6);
        Good good8 = new Good(4L,"Smores Bar", new BigDecimal(200), 10, "/resources/i/smores_web.jpg", "366L", 536,
                "какао тертое, пудра сахарная, ядро миндаля сладкого, ядро миндаля(струганное), кофе натуральный жареный молотый, какао масло, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин.", 110, "пакет", category1,"190 x 80 x 10 мм",
                "Mary Brussels", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г");
        goodsService.addGood(good8);
        Good good9 = new Good(5L,"The Gold Rush", new BigDecimal(220), 10, "/resources/i/gold-rush_web.jpg", "367L", 536,
                "какао тертое, пудра сахарная, ядро миндаля сладкого, ядро миндаля(струганное), кофе натуральный жареный молотый, какао масло, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин.", 110, "пакет", category1,"190 x 80 x 10 мм",
                "Mary Brussels", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г","Events & Party Favors");
        goodsService.addGood(good9);
        Good good10 = new Good(6L,"The Zimmern", new BigDecimal(200), 10, "/resources/i/zimmern_web.jpg", "368L", 536,
                "какао тертое, пудра сахарная, вишня вяленая, ядро орехов фундука, какао масло, ядро фундука жареное дробленое, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин. ", 100, "пластиковая упаковка", category1,"190 x 80 x 10 мм",
                "Newhaus", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г","Events & Party Favors");
        goodsService.addGood(good10);
        Good good11 = new Good(7L,"Happy Birthday Bar", new BigDecimal(150), 10, "/resources/i/happy-birthday_web_1.jpg", "369L", 536,
                " какао тертое, пудра сахарная, ядро миндаля сладкого, ядро миндаля(струганное), кофе натуральный жареный молотый, какао масло, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин.", 80, "пластиковая упаковка", category1,"190 x 80 x 10 мм",
                "Newhaus", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г","Events & Party Favors");
        goodsService.addGood(good11);
        Good good12 = new Good(8L,"Salted Caramel Crunch", new BigDecimal(90), 10, "/resources/i/salted-caramel_web.jpg", "370L", 536,
                " какао тертое, пудра сахарная, помело сушеный, ядро орехов фундука, какао масло, ядро фундука жареное дробленое, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин. ", 100, "пластиковая упаковка", category1,"190 x 80 x 10 мм",
                "Newhaus", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г","Events & Party Favors");
        goodsService.addGood(good12);
        Good good13 = new Good(9L,"Hot Chocolate on A Spoon - Pure Milk",new BigDecimal(90.95, MathContext.DECIMAL32),
                10, "/resources/i/hot_chocolate_on_a_stick_pure_milk_chocolate_2.jpg", "485L", 536,
                "Pure Belgian Milk Chocolate ", 250, "пластиковая упаковка", categories,"190 x 80 x 10 мм",
                "Godiva", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г","Events & Party Favors");
        goodsService.addGood(good13);
        Good good14 = new Good(10L,"The Love Collection",new BigDecimal(90.50, MathContext.DECIMAL32),
                10, "/resources/i/love-set-web.png", "489L", 536,
                "какао тертое, пудра сахарная, вишня вяленая, ядро орехов фундука, какао масло, ядро фундука жареное дробленое, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин.", 250, "пластиковая упаковка", category2,"190 x 80 x 10 мм",
                "Chocomize", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г","Wedding Favors");
        goodsService.addGood(good14);
        Good good1 = new Good(11L,"The Modern Collection", new BigDecimal(290), 11, "/resources/i/love-truffles.jpg", "371L", 537,
                "какао тертое, пудра сахарная, папайя сушеная, ядро миндаля сладкого, какао масло, ядро миндаля (струганное), эмульгатор лецитин, ароматизатор идентичный натуральному ванилин.", 100, "пластиковая упаковка", category4,"190 x 80 x 10 мм",
                "Godiva", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г");
        goodsService.addGood(good1);
        Good good2 = new Good(12L,"Dark Chocolate Easter Bunnies - Set of 8", new BigDecimal(110), 11, "/resources/i/dark-easter-bunnies-web.jpg", "372L", 537,
                " какао тертое, пудра сахарная, помело сушеный, ядро орехов фундука, какао масло, ядро фундука жареное дробленое, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин. ", 100, "пластиковая упаковка", category7,"190 x 80 x 10 мм",
                "Godiva", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г");
        goodsService.addGood(good2);
        Good good3 = new Good(13L,"French Macaron Collection- 6pcs", new BigDecimal(260), 11, "/resources/i/6pcs-macaron-set_2.jpg", "373L", 537,
                "какао тертое, пудра сахарная, вишня вяленая, ядро орехов фундука, какао масло, ядро фундука жареное дробленое, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин. ", 100, "пластиковая упаковка", category8,"190 x 80 x 10 мм",
                "Godiva", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г");
        goodsService.addGood(good3);
        Good good18 = new Good(18L,"French Macaron Collection- 12pcs", new BigDecimal(290), 11, "/resources/i/12-pcs-macaron-set_1.jpg", "379L", 537,
                "какао тертое, пудра сахарная, папайя сушеная, ядро миндаля сладкого, какао масло, ядро миндаля (струганное), эмульгатор лецитин, ароматизатор идентичный натуральному ванилин.", 100, "пластиковая упаковка", category8,"190 x 80 x 10 мм",
                "Godiva", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г");
        goodsService.addGood(good18);
        Good good4 = new Good(14L,"Chocolate Covered Cranberries", new BigDecimal(130), 11, "/resources/i/chocolate_covered_cranberries.jpg", "374L", 537,
                "Tangy cranberries covered in luscious dark chocolate!", 100, "пластиковая упаковка", category9,"190 x 80 x 10 мм",
                "Godiva", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г");
        goodsService.addGood(good4);
        Good good5 = new Good(15L,"Classic Collection", new BigDecimal(80), 11, "/resources/i/for-everyone-collection_1_1.jpg", "375L", 537,
                " какао тертое, пудра сахарная, помело сушеный, ядро орехов фундука, какао масло, ядро фундука жареное дробленое, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин. ", 100, "пластиковая упаковка", category10,"190 x 80 x 10 мм",
                "Godiva", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г");
        goodsService.addGood(good5);
        Good good15 =new Good(16L,"Signature Bars for Corporate Gifts", new BigDecimal(130), 11, "/resources/i/NBC-custom-corporate-gift-600x600.jpg", "376L", 537,
                "какао тертое, пудра сахарная, вишня вяленая, ядро орехов фундука, какао масло, ядро фундука жареное дробленое, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин.", 100, "пластиковая упаковка", category1,"190 x 80 x 10 мм",
                "Godiva", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г");
        goodsService.addGood(good15);
        Good good16 =new Good(17L,"Signature Bars for Wedding Favors", new BigDecimal(170), 11, "/resources/i/wedding-chocolate-favor-heart-bar-600x600.jpg", "377L", 537,
                "какао тертое, пудра сахарная, папайя сушеная, ядро миндаля сладкого, какао масло, ядро миндаля (струганное), эмульгатор лецитин, ароматизатор идентичный натуральному ванилин.", 100, "пластиковая упаковка", category1,"190 x 80 x 10 мм",
                "Godiva", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г","Wedding Favors");
        goodsService.addGood(good16);
        Good good17 =new Good(17L,"Hot Chocolate on a Spoon Event Favors", new BigDecimal(350), 11, "/resources/i/event_hc_design.jpg", "378L", 537,
                "какао тертое, пудра сахарная, вишня вяленая, ядро орехов фундука, какао масло, ядро фундука жареное дробленое, эмульгатор лецитин, ароматизатор идентичный натуральному ванилин.", 100, "пластиковая упаковка", categories,"190 x 80 x 10 мм",
                "Godiva", 565, "белки – 6,0 г, жиры – 36,1 г, углеводы –54г","Events & Party Favors");
        goodsService.addGood(good17);
    }

    public static void test() {
        OrdersService ordersService=new OrdersService();
        GoodsService goodsService=new GoodsService();
        CategoriesService categoriesService=new CategoriesService();
//        Categories categories1=categoriesService.getCategoryById(4L);
        //System.out.println(categories1);
        /*List<Goods> goodses=goodsService.getAllGoods();
        for(Goods goods:goodses){
            System.out.println(goods);
        }*/
        List<Order> orders= ordersService.getAllOrders();
        for(Order order1 :orders){
            System.out.println(order1.getGoods());
        }
//        System.out.println(categoriesService.getAllCategories());
//        System.out.println(categoriesService.getEndedCategories());
//       System.out.println(goodsService.getGoodsByCategorysId(2L));
//        System.out.println(goodsService.getNewGoods());
        /*System.out.println(goodsService.getGoodsByPage(goodsService.getGoodsByCategorysName("шоколадные композиции"), 2));
        System.out.println(goodsService.getGoodsByPage(goodsService.getGoodsByCategorysName("шоколадные композиции"), 3));*/
    }
}
