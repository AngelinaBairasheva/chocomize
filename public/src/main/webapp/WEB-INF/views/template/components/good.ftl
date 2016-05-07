<#macro goods good count>
<tr>
    <td class="td-image" style="width: 80px;">
        <a href="/good/${good.id}" title="${good.name}"
           class="product-image"><img
                src="${good.image}" width="80" height="80"
                alt="${good.name}"/></a></td>
    <td class="a-center td-qty">
        <span class="td-title">Quantity ${count}</span>
    </td>
    <td class="a-center td-price">
        <span class="td-title">Subtotal</span>
                                <span class="cart-price">
                                    <span class="price">${good.price*count}</span>
                </span>
    </td>
</tr>
</#macro>