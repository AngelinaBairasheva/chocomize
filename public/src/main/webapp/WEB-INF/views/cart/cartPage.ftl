<#-- @ftlvariable name="Session.cart" type="com.springapp.mvc.api.domain.CartInfo" -->
<#-- @ftlvariable name="carts" type="java.util.List<com.springapp.mvc.api.domain.Cart>" -->
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<#include "../template/template.ftl">
<#include "components/goodItem.ftl">
<@mainTemplate title="Корзина"/>
<#macro m_body>
    <#assign total=0>
    <#assign count=0>
<div class="mens">
    <div class="main">
        <div class="wrap">
            <#if (Session.cart.goods)?has_content || carts?has_content>
                <div class="main-container col1-layout">
                    <div class="main row clearfix">
                        <div class="col-main">
                            <div class="cart">
                                <div>
                                    <h1 class="shopingcart">Shopping Cart</h1>

                                    <div class="payment_checkout">
                                    </div>

                                    <div id="listCart">
                                        <div class="fieldset_41" style="display:inline-block ; width:100% ;">
                                            <table id="shopping-cart-table" class="data-table cart-table">

                                                <thead>
                                                <tr>
                                                    <th style="background-color: #bfba82;" class="td-image" rowspan="1">
                                                        &nbsp;</th>
                                                    <th style="background-color: #bfba82;" class="td-name"
                                                        rowspan="1"><span
                                                            class="nobr">Product Name</span>
                                                    </th>
                                                    <th style="background-color: #bfba82;" class="td-price"
                                                        class="a-center"
                                                        colspan="1"><span
                                                            class="nobr">Unit Price</span></th>
                                                    <th style="background-color: #bfba82;" class="td-qty" rowspan="1"
                                                        class="a-center">
                                                        Quantity
                                                    </th>
                                                    <th style="background-color: #bfba82;" class="td-price"
                                                        class="a-center"
                                                        colspan="1">
                                                        Subtotal
                                                    </th>
                                                    <th style="background-color: #bfba82;" class="td-delete" rowspan="1"
                                                        class="a-center">
                                                        &nbsp;</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                    <#if (Session.cart.goods)?has_content>
                                                    <#list Session.cart.goods?keys as goodId>
                                                        <#list Session.goodsList as item>
                                                            <#if goodId=item.id>
                                                                <#assign good=item>
                                                            </#if>
                                                        </#list>
                                                        <#assign total=total+Session.cart.getCount(goodId)*good.price>
                                                        <@goodItem good=good count=Session.cart.getCount(goodId)/>
                                                    </#list>
                                                <#else>
                                                        <#list Session.carts as cart>
                                                        <#assign count=count+cart.count>
                                                            <#assign total=total+cart.count*cart.good.price>
                                                            <@goodItem good=cart.good count=cart.count/>
                                                        </#list>
                                                    </#if>
                                                </tbody>
                                            </table>
                                        </div>
                                        <div class="card_position42">
                                            <div class="card_position_content">
                                                <div class="cart-block cart-total">
                                                    <table id="shopping-cart-totals-table">
                                                        <colgroup>
                                                            <col>
                                                            <col width="1">
                                                        </colgroup>
                                                        <tfoot>
                                                        <tr>
                                                            <td style="" class="a-right" colspan="1">
                                                                <p class="cart">
                                                                    <strong>Grand Total</strong>
                                                                </p>
                                                            </td>
                                                            <td style="" class="a-right">
                                                                <p class="cart" style="text-align: right">
                                                                    <strong><span id="total"
                                                                                  class="price">${total}</span></strong>
                                                                </p>

                                                                <@sec.authorize access="isAuthenticated()">
                                                                    <#if total!=0>
                                                                        <div class="btn_form">
                                                                            <form  action="/order" method="get">
                                                                                <input hidden name="total_sum" value="${total}">
                                                                                <input hidden name="total_count" value="${count}">
                                                                                <input style="padding-right: 100px;padding-left: 100px"
                                                                                       type="submit"
                                                                                       value="Proceed to Checkout"
                                                                                       class="js_proceedToCheckout"
                                                                                       data-id="19">
                                                                            </form>
                                                                        </div></#if>
                                                                </@sec.authorize>
                                                            </td>
                                                        </tr>
                                                        </tfoot>
                                                    </table>
                                                </div>
                                                <div class="clear"></div>
                                            </div>
                                            <div class="clear"></div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
            <#else>
                <div class="register_account">
                    <div class="wrap">
                        <h4 class="title">Shopping cart is empty</h4>

                        <p class="cart">You have no items in your shopping cart.<br>Click<a href="/catalog/4"> here</a>
                            to continue
                            shopping</p>
                    </div>
                </div>
            </#if>
        </div>
    </div>
</div>
</#macro>
