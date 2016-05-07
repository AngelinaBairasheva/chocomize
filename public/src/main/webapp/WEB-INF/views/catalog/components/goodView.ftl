<#-- @ftlvariable name="Session.carts" type="java.util.List<com.springapp.mvc.api.Cart>" -->
<#macro goodView good >
<a href='/good/${good.id}?page=${currentPage}&limit=${limit}&sorttype=${sorttype}&dir=${dir}&brands=${brands}&costs=${costs}'>
    <div class="inner_content clearfix">
        <div class="product_image">
            <img src="${good.image}" alt=""/>
        </div>
        <#assign flag=false>
        <#if Session.carts?has_content>
            <#list Session.carts as cart1>
                <#if cart1.good.id=good.id>
                    <#assign flag=true>
                    <#break >
                </#if>
            </#list>
        </#if>
        <div id="remark${good.id}"><#if Session.cart?has_content&&Session.cart.containsGoodId(good.id) || flag>
            <div class="sale-box"><span class="on_sale title_shop">In Shop Cart</span></div></#if></div>
        <div class="price">
            <div class="cart-left">
                <p class="title">${good.name}</p>

                <div class="price1">
                    <span class="actual">${good.price} руб.</span>
                </div>
            </div>
            <a class="cart-right button js_addToCart" data-id="${good.id}" href="/cart"></a>

            <div class="clear"></div>
        </div>
    </div>
</a>
</#macro>