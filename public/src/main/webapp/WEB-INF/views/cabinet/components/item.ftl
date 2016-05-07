<#macro item good>
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
</tr>
</#macro>