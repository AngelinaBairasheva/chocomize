<#-- @ftlvariable name="rootCategories" type="java.util.List<com.springapp.mvc.api.domain.Categories>" -->
<#-- @ftlvariable name="endedCategories" type="java.util.List<com.springapp.mvc.api.domain.Categories>" -->
<#-- @ftlvariable name="items" type="java.util.List<com.springapp.mvc.api.domain.Goods>" -->
<#-- @ftlvariable name="catalog" type="com.springapp.mvc.api.domain.Categories" -->
<#-- @ftlvariable name="pagesCount" type="java.lang.Integer" -->
<#-- @ftlvariable name="currentPage" type="java.lang.Integer" -->
<#-- @ftlvariable name="limit" type="java.lang.Integer" -->
<#-- @ftlvariable name="max" type="java.math.BigDecimal" -->
<#-- @ftlvariable name="min" type="java.math.BigDecimal" -->
<#-- @ftlvariable name="brands" type="java.util.List<java.lang.String>" -->
<#-- @ftlvariable name="events" type="java.util.List<java.lang.String>" -->
<#include "../template/template.ftl">
<@mainTemplate title="${catalog.name} | Chocomize Bestsellers" />

<#macro recursion1 p1>
    <#list p1 as p>
        <#if p.categories ?has_content>
        <option disabled>${p.name}</option>
            <@recursion1 p1=p.categories/>
        <#else>
        <option value="${c}">${p.name}</option>
            <#assign c=c+1></#if>
    </#list>
</#macro>
<#macro m_body>
    <#assign c=1>
<div class="mens">
    <div class="main">
        <div class="wrap">
            <div class="cont span_2_of_3">
                <h2 class="head">${catalog.name}</h2>

                <div id="goodsList">
                    <#include "components/catalogToolbar.ftl">
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
                </div>
            </div>
        </div>
        <#include "components/catalogFilter.ftl">
        <div class="clear"></div>
    </div>
</div>
</div>
<script src="/resources/js/jquery.easydropdown.js"></script>
<div class="clear"></div>
</#macro>