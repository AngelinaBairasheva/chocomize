<#-- @ftlvariable name="orders" type="java.util.List<com.springapp.mvc.api.domain.Order>" -->
<#include "item.ftl">
<#assign x=1>
<#if orders?has_content>
<#list orders as order>
<h4 class="title">Order ${x}</h4> <button data-orderid="${order.id}" title="Remove order" class="red button deleteOrder">Delete this order</button>
<#assign x=x+1>
<div class="fieldset_41" style="display:inline-block ; width:100% ; padding-top: 30px">
    <table id="shopping-cart-table" class="data-table cart-table">
        <thead>
        <tr>
            <th style="background-color: #bfba82;" class="td-image"  rowspan="1">
                &nbsp;</th>
            <th style="background-color: #bfba82;" class="td-name"
                rowspan="1"><span
                    class="nobr">Product Name</span>
            </th>
            <th style="background-color: #bfba82;" class="td-price"
                class="a-center"
                colspan="1"><span
                    class="nobr">Unit Price</span></th>
        </tr>
        </thead>
        <tbody>
            <#list order.goods as orderGood>
                <@item good=orderGood/>
            </#list>
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
                    <td class="a-right" colspan="1" style="text-align:left;">
                        <p class="cart">
                            <strong>Grand Total</strong>
                        </p>
                    </td>
                    <td class="a-right">
                        <p class="cart" style="text-align: right">
                            <strong><span id="total"
                                          class="price">${order.total_sum}</span></strong>
                        </p>

                    </td>
                </tr>
                </tfoot>

            </table>

        </div>

        <div class="clear"></div>
    </div>
    <div class="clear"></div>
</div>
</#list><#else>
<h4 class="title">You haven't orders</h4>
</#if>