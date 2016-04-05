<#include "components/catalogToolbar.ftl">
<#if items?? && items?has_content>
<#list items as good>
    <#if good_index%3==0 >
    <div class="top-box"></#if>
    <div class="col_1_of_3 span_1_of_3">
        <a href="/good/${good.id}">
            <div class="inner_content clearfix">
                <div class="product_image">
                    <img src="${good.image}" alt=""/>
                </div>
                <div class="price">
                    <div class="cart-left">
                        <p class="title">${good.name}</p>

                        <div class="price1">
                            <span class="actual">${good.price} руб.</span>
                        </div>
                    </div>
                    <div class="cart-right"></div>
                    <div class="clear"></div>
                </div>
            </div>
        </a>
    </div>
    <#if (good_index+1)%3==0>
        <div class="clear"></div></div></#if>
</#list>
<#else>
<div class="top-box">
    <h2>Товаров по выбранным критериям нет</h2>
</div>
</#if>

