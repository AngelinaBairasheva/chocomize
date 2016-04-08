<#-- @ftlvariable name="rootCategories" type="java.util.List<com.springapp.mvc.api.domain.Categories>" -->
<#macro recursion p1>
    <#list p1 as p>
        <#if p.categories ?has_content>
        <h4 class="color4">${p.name}</h4>
        <ul>
            <@recursion p1=p.categories/>
        </ul>
        <#else>
        <li><a href="/catalog/${p.id}">${p.name}</a></li></#if>
    </#list>
</#macro>
<div class="header-bottom">
    <div class="wrap">
        <div class="header-bottom-left">
            <div class="logo">
                <a href="/"><img src="/resources/i/logo.png" alt=""/></a>
            </div>
            <div class="menu">
                <ul class="megamenu skyblue">
                    <li class="active grid"><a href="/">Home</a></li>
                <#list rootCategories as category>
                    <#if  category.categories?has_content>
                        <li><a class="color4" href="#">${category.name}</a>

                            <div class="megapanel">
                                <div class="row">
                                    <div class="col1">
                                        <div class="h_nav">
                                            <ul><@recursion p1=category.categories/>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                    <#else>
                        <li><a class="color4" href="/catalog/${category.id}">${category.name}</a></li>
                    </#if>
                </#list>
                    <li><a class="color6" href="other.html">Other</a></li>
                    <li><a class="color7" href="other.html">Purchase</a></li>
                </ul>
            </div>
        </div>
        <div class="header-bottom-right">
            <div class="tag-list">
                <ul class="icon1 sub-icon1 profile_img">
                    <li><a class="active-icon c2" href="/cart"> </a>
                        <ul class="sub-icon1 list">
                        <#if (Session.cart.goods)??>
                            <li><h3>Your Products</h3><a href=""></a></li>
                            <li><p>You have items in your shopping cart. Click to the button!
                            </p>
                            </li>
                        <#else>
                            <li><h3>No Products</h3><a href=""></a></li>
                            <li><p>You have no items in your shopping cart.
                            </p>
                            </li>
                        </#if>
                        </ul>
                    </li>
                </ul>
                <ul class="last">
                    <li><a href="#">Cart(0)</a></li>
                </ul>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>