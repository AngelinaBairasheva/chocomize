<#-- @ftlvariable name="Session.cart" type="com.springapp.mvc.api.domain.CartInfo" -->
<div class="register_account">
<div class="wrap">
<#if (Session.cart.goods)??>
<h4 class="title">Товары в корзине:</h4>
<p class="cart"> <#list Session.cart.goods?keys as goodId>
    товар: ${goodId}; кол-во: ${Session.cart.getCount(goodId)}</p>
    </#list>
<#else>
        <h4 class="title">Shopping cart is empty</h4>
        <p class="cart">You have no items in your shopping cart.<br>Click<a href="/catalog/1L"> here</a> to continue shopping</p>
</#if>
</div>
</div>
<#-- Страница в работе!
<br><br>
<#if (Session.cart.goods)??>
Товары в корзине:<br>
    <#list Session.cart.goods?keys as goodId>
    товар: ${goodId}; кол-во: ${Session.cart.getCount(goodId)}<br>
    </#list>
<#else>
Ваша корзина пуста!
</#if>-->
