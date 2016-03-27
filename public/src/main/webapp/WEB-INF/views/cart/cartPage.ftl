<div class="register_account">
    <div class="wrap">
        <h4 class="title">Shopping cart is empty</h4>
        <p class="cart">You have no items in your shopping cart.<br>Click<a href="index.html"> here</a> to continue shopping</p>
    </div>
</div>
<#--
&lt;#&ndash; @ftlvariable name="Session.cart" type="com.springapp.mvc.common.CartInfo" &ndash;&gt;
Страница в работе!
<br><br>
<#if (Session.cart.goods)??>
Товары в корзине:<br>
<#list Session.cart.goods?keys as goodId>
    товар: ${goodId}; кол-во: ${Session.cart.getCount(goodId)}<br>
</#list>
<#else>
    Ваша корзина пуста!
</#if>-->
