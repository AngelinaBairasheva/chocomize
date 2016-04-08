<#assign total=0>
<#if (Session.cart.goods)??>
<div class="fieldset_41" style="display:inline-block ; width:100% ;">
    <!-- 2014.4.1 end -->

    <table id="shopping-cart-table" class="data-table cart-table">

        <thead>
        <tr>
            <th style="background-color: #bfba82;" class="td-image" rowspan="1">&nbsp;</th>
            <th style="background-color: #bfba82;" class="td-name" rowspan="1"><span
                    class="nobr">Product Name</span>
            </th>
            <th style="background-color: #bfba82;" class="td-price" class="a-center"
                colspan="1"><span
                    class="nobr">Unit Price</span></th>
            <th style="background-color: #bfba82;" class="td-qty" rowspan="1"
                class="a-center">
                Quantity
            </th>
            <th style="background-color: #bfba82;" class="td-price" class="a-center"
                colspan="1">
                Subtotal
            </th>
            <th style="background-color: #bfba82;" class="td-delete" rowspan="1"
                class="a-center">
                &nbsp;</th>
        </tr>
        </thead>
        <tbody>

        <!-- 2014.4.2 start -->

            <#list Session.cart.goods?keys as goodId>
                <#list items as item>
                    <#if goodId=item.id>
                        <#assign good=item>
                    </#if>
                </#list>
                <#assign total=total+Session.cart.getCount(goodId)*good.price>
            <tr>
                <td class="td-image">
                    <a href="/good/${good.id}" title="${good.name}"
                       class="product-image"><img
                            src="${good.image}" width="200" height="200"
                            alt="${good.name}"/></a></td>
                <td class="td-name">

                    <h2 class="product-name">

                        <a href="/good/${good.id}">${good.name}</a>
                    </h2>
                </td>
                <td class="a-center td-price">
                    <span class="td-title">Unit Price</span>
                                        <span class="cart-price">
                                                                            <span class="price">${good.price}
                                                                                rub.</span>
                    </span>


                </td>
                <td class="a-center td-qty">
                    <span class="td-title">Quantity</span>
                    <select data-goodid="${good.id}" id="select_count">
                        <#list 1..good.count as i>
                            <#if i=Session.cart.getCount(goodId)>
                                <option value="${i}" selected=selected>
                                ${i}            </option><#else>
                                <option value="${i}">
                                ${i}            </option>
                            </#if>
                        </#list>
                    </select>
                </td>
                <td class="a-center td-price">
                    <span class="td-title">Subtotal</span>
                                <span class="cart-price">

                                                                        <span
                                                                                class="price">${good.price
                                                                        *Session.cart.getCount(goodId)}</span>
                </span>
                </td>
                <td class="a-center td-delete">

                    <a data-goodid="${goodId}"
                       title="Remove item" class="button deleteGood button cart_delete">Delete</a>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>

</div>

<!-- 2014.4.2 start -->
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
                        <p class="cart">
                            <strong><span id="total"
                                          class="price">${total}</span></strong>
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
<#else>
<h4 class="title">Shopping cart is empty</h4>

<p class="cart">You have no items in your shopping cart.<br>Click<a href="/catalog/4"> here</a> to continue
    shopping</p>
</#if>
