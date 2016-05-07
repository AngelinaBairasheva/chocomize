<#-- @ftlvariable name="rootCategories" type="java.util.List<com.springapp.mvc.api.domain.Category>" -->
<#include "good.ftl">
<#macro recursion p1>
    <#list p1 as p>
        <#if p.categories ?has_content>
        <h4 class="color4">${p.name}</h4>
        <ul>
            <@recursion p1=p.categories/>
        </ul>
        <#else>
        <li><a href="/catalog/${p.id}">${p.name}</a></li></#if>
    </#list>
</#macro>
<#assign total=0>
<div class="header-bottom">
    <div class="wrap">
        <div class="header-bottom-left">
            <div class="logo">
                <a href="/"><img src="/resources/i/logo.png" alt=""/></a>
            </div>
            <div class="menu">
                <ul class="megamenu skyblue">
                    <li class="active grid"><a href="/">Home</a></li>
                <#list rootCategories as category>
                    <#if  category.categories?has_content>
                        <li><a class="color4" href="/catalog/${category.id}">${category.name}</a>
                            <div class="megapanel">
                                <div class="row">
                                    <div class="col1">
                                        <div class="h_nav">
                                            <ul><@recursion p1=category.categories/>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                    <#else>
                        <li><a class="color4" href="/catalog/${category.id}">${category.name}</a></li>
                    </#if>
                </#list>
                </ul>
            </div>
        </div>
        <div class="header-bottom-right">
            <div class="tag-list">
                <ul class="icon1 sub-icon1 profile_img">
                    <li><a class="active-icon c2" href="/cart"> </a>
                        <ul class="sub-icon1 list">
                        <#if (Session.cart.goods)?has_content || carts?has_content>
                            <li><h3>Your Products</h3><a href="/cart"></a></li>
                        <table>
                        <tbody tr="0" id="cartList">

                            <#if (Session.cart.goods)?has_content>
                                <#list Session.cart.goods?keys as goodId>
                            <#if goodId_index < 3>
                                    <#list Session.goodsList as item>
                                            <#if goodId=item.id>
                                            <#assign good=item>
                                        </#if>
                                    </#list>
                                    <#assign total=total+Session.cart.getCount(goodId)*good.price>
                                    <@goods good=good count=Session.cart.getCount(goodId)/>
                            <#else><a href="/cart">See all products</a><#break>
                            </#if>
                                </#list>
                            <#else>
                                <#list Session.carts as cart>
                                    <#if cart_index < 3>
                                    <@goods good=cart.good count=cart.count/>
                                    <#else><a href="/cart">See all products</a><#break>
                                    </#if>
                                </#list>
                                <#list Session.carts as cart>
                                    <#assign total=total+cart.count*cart.good.price>
                                </#list>
                            </#if>
                        </tbody>
                            </table>
                        <#else>
                            <li><h3>No Products</h3></li>
                            <li><p>You have items in your shopping cart. Click to the button!
                            </p>
                            </li></#if>
                        </ul>
                    </li>
                </ul>
                <ul class="last">
                    <li><a href="/cart">Cart(${total} rub.)</a></li>
                </ul>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>