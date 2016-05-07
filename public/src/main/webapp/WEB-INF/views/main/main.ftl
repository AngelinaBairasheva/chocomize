<#-- @ftlvariable name="newGoods" type="java.util.List<com.springapp.mvc.api.domain.Good>" -->
<#-- @ftlvariable name="macarons" type="java.util.List<com.springapp.mvc.api.domain.Good>" -->
<#include "../template/template.ftl">
<@mainTemplate title="Personalized Chocolate &amp; Custom Corporate Gifts | Chocomize" scripts=['js/jquery-ui.min.js',
'js/jquery.main.js']/>
<#macro m_body>
    <#include "../template/components/slider.ftl">
<div class="main">
    <div class="wrap">
        <div class="section group">
            <div class="cont span_2_of_3">
                    <h2 class="head">Featured Products</h2>
                    <#list newGoods as good>
                        <#if good_index%3==0>
                        <div class="top-box"></#if>
                        <div class="col_1_of_3 span_1_of_3">
                            <a href="/good/${good.id}">
                                <div class="inner_content clearfix">
                                    <div class="product_image">
                                        <img src="${good.image}" alt="${good.name}"/>
                                    </div>
                                    <div class="sale-box"><span class="on_sale title_shop">New</span></div>
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
                        </div>
                        <#if good_index%3==0></div></#if>
                    </#list>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
    </div>
    </div>
    </div>
</#macro>