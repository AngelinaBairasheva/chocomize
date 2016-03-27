<#-- @ftlvariable name="rootCategories" type="java.util.List<com.springapp.mvc.api.domain.Categories>" -->
<#-- @ftlvariable name="endedCategories" type="java.util.List<com.springapp.mvc.api.domain.Categories>" -->
<#-- @ftlvariable name="items" type="java.util.List<com.springapp.mvc.api.domain.Goods>" -->
<#-- @ftlvariable name="catalog" type="com.springapp.mvc.api.domain.Categories" -->
<#-- @ftlvariable name="pagesCount" type="java.lang.Integer" -->
<#-- @ftlvariable name="currentPage" type="java.lang.Integer" -->
<#-- @ftlvariable name="max" type="java.math.BigDecimal" -->
<#-- @ftlvariable name="min" type="java.math.BigDecimal" -->
<#-- @ftlvariable name="brands" type="java.util.List<java.lang.String>" -->
<#-- @ftlvariable name="events" type="java.util.List<java.lang.String>" -->
<#include "../template/template.ftl">
<@mainTemplate title="${catalog.name} | Chocomize Bestsellers" styles=['css/main.css'] />

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

                <div class="mens-toolbar">
                    <div class="sort">
                        <div class="sort-by">
                            <label>Sort By</label>
                            <select>
                                <option value="">
                                    Position
                                </option>
                                <option value="">
                                    Name
                                </option>
                                <option value="">
                                    Price
                                </option>
                            </select>
                            <a href=""><img src="/resources/i/arrow2.gif" alt="" class="v-middle"></a>
                        </div>
                    </div>
                    <div class="pager">
                        <div class="limiter visible-desktop">
                            <label>Show</label>
                            <select>
                                <option value="" selected="selected">
                                    6
                                </option>
                                <option value="">
                                    9
                                </option>
                                <option value="">
                                    15
                                </option>
                            </select> per page
                        </div>
                        <ul class="dc_pagination dc_paginationA dc_paginationA06">
                            <li>
                                <div class="previous">Pages</div>
                            </li>
                            <#if currentPage==1>
                                <li class="disabled"><a>«</a></li> <#else>
                                <li><a href="/catalog/${catalog.id}?page=${currentPage-1}&from=${min}&to=${max}">«</a>
                                </li></#if>
                            <#if pagesCount==1 || pagesCount==2|| pagesCount==3>
                                <#list 1..pagesCount as i>
                                    <#if currentPage==i>
                                        <li><a class="active"
                                               href="/catalog/${catalog.id}?page=${i}">${i}</a>
                                        </li><#else>
                                        <li><a href="/catalog/${catalog.id}?page=${i}">${i}</a>
                                        </li></#if></#list><#else>
                                <#list 1..3 as i><#if currentPage==i>
                                    <li><a class="active"
                                           href="/catalog/${catalog.id}?page=${i}">${i}</a>
                                    </li><#else>
                                    <li><a href="/catalog/${catalog.id}?page=${i}">${i}</a>
                                    </li></#if>  </#list>
                                <li class="disabled"><a>...</a></li>
                                <li>
                                    <a href="/catalog/${catalog.id}?page=${pagesCount}">${pagesCount}</a>
                                </li>
                            </#if>
                            <#if currentPage==pagesCount>
                                <li class="disabled"><a>»</a></li><#else >
                                <li><a href="/catalog/${catalog.id}?page=${currentPage+1}">»</a>
                                </li></#if>
                        </ul>
                        <div class="clear"></div>
                    </div>
                    <div class="clear"></div>
                </div>
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
                    <#if (good_index+1)%3==0><div class="clear"></div></div></#if>
                </#list>
            </div>
            <#include "../template/components/catalogFilter.ftl">
        </div>
    </div>
</div>
<script src="/resources/js/jquery.easydropdown.js"></script>
</#macro>
<div class="top-box">
    <div class="col_1_of_3 span_1_of_3">
        <a href="/good/18">
            <div class="inner_content clearfix">
                <div class="product_image">
                    <img src="/resources/i/wedding-chocolate-favor-heart-bar-600x600.jpg" alt=""/>
                </div>
                <div class="price">
                    <div class="cart-left">
                        <p class="title">Signature Bars for Wedding Favors</p>

                        <div class="price1">
                            <span class="actual">170 руб.</span>
                        </div>
                    </div>
                    <div class="cart-right"></div>
                    <div class="clear"></div>
                </div>
            </div>
        </a>
    </div>


    <div class="col_1_of_3 span_1_of_3">
        <a href="/good/17">
            <div class="inner_content clearfix">
                <div class="product_image">
                    <img src="/resources/i/NBC-custom-corporate-gift-600x600.jpg" alt=""/>
                </div>
                <div class="price">
                    <div class="cart-left">
                        <p class="title">Signature Bars for Corporate Gifts</p>

                        <div class="price1">
                            <span class="actual">130 руб.</span>
                        </div>
                    </div>
                    <div class="cart-right"></div>
                    <div class="clear"></div>
                </div>
            </div>
        </a>
    </div>


    <div class="col_1_of_3 span_1_of_3">
        <a href="/good/8">
            <div class="inner_content clearfix">
                <div class="product_image">
                    <img src="/resources/i/salted-caramel_web.jpg" alt=""/>
                </div>
                <div class="price">
                    <div class="cart-left">
                        <p class="title">Salted Caramel Crunch</p>

                        <div class="price1">
                            <span class="actual">90 руб.</span>
                        </div>
                    </div>
                    <div class="cart-right"></div>
                    <div class="clear"></div>
                </div>
            </div>
        </a>
    </div>
</div>
<div class="top-box">
    <div class="col_1_of_3 span_1_of_3">
        <a href="/good/7">
            <div class="inner_content clearfix">
                <div class="product_image">
                    <img src="/resources/i/happy-birthday_web_1.jpg" alt=""/>
                </div>
                <div class="price">
                    <div class="cart-left">
                        <p class="title">Happy Birthday Bar</p>

                        <div class="price1">
                            <span class="actual">150 руб.</span>
                        </div>
                    </div>
                    <div class="cart-right"></div>
                    <div class="clear"></div>
                </div>
            </div>
        </a>
    </div>


    <div class="col_1_of_3 span_1_of_3">
        <a href="/good/6">
            <div class="inner_content clearfix">
                <div class="product_image">
                    <img src="/resources/i/zimmern_web.jpg" alt=""/>
                </div>
                <div class="price">
                    <div class="cart-left">
                        <p class="title">The Zimmern</p>

                        <div class="price1">
                            <span class="actual">200 руб.</span>
                        </div>
                    </div>
                    <div class="cart-right"></div>
                    <div class="clear"></div>
                </div>
            </div>
        </a>
    </div>


    <div class="col_1_of_3 span_1_of_3">
        <a href="/good/5">
            <div class="inner_content clearfix">
                <div class="product_image">
                    <img src="/resources/i/gold-rush_web.jpg" alt=""/>
                </div>
                <div class="price">
                    <div class="cart-left">
                        <p class="title">The Gold Rush</p>

                        <div class="price1">
                            <span class="actual">220 руб.</span>
                        </div>
                    </div>
                    <div class="cart-right"></div>
                    <div class="clear"></div>
                </div>
            </div>
        </a>
    </div>
</div>



