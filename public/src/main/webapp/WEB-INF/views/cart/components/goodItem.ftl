<#macro goodItem good count>
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
                <#if i=count>
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
                                                                        *count}</span>
                </span>
    </td>
    <td class="a-center td-delete">

        <a data-goodid="${good.id}"
           title="Remove item"
           class="button deleteGood button cart_delete">Delete</a>
    </td>
</tr>
</#macro>