<#-- @ftlvariable name="item" type="com.springapp.mvc.api.domain.Goods" -->
<#include "../template/template.ftl">
<@mainTemplate title="${item.name} - ${item.category.name} | Chocomize Bestsellers" />
<#macro m_body>
<div class="mens">
    <div class="main">
        <div class="wrap">
            <ul class="breadcrumb breadcrumb__t"><a class="home" href="/">Home</a> / <a href="/catalog/${item.category.id}">${item.category.name}</a> / ${item.name}</ul>

            <article class="catalog-item-detail">
                <div class="grid images_3_of_2">
                    <ul id="etalage">
                        <li>
                                <img class="etalage_thumb_image img-holder" src="${item.image}" class="img-responsive" />
                                <img class="etalage_source_image img-holder" src="${item.image}" class="img-responsive" title="${item.name}" />
                        </li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <div class="  description" style="font-size: 15px;">
                    <h1>${item.name}</h1>
                    <p class="m_5">Rub. ${item.price} </p>
                    <div class="btn_form">
                        <form>
                            <input type="submit" value="buy" title="">
                        </form>
                    </div>
                        <div class="params">
                    <#if item.description??>${item.description}</#if>
                        <#if item.packaging??>
                            <div class="param-row">
                                <label>Упаковка</label>
                                <div class="param-value">${item.packaging}<br />
                                </div>
                            </div></#if>
                        <#if item.weight??>
                        <div class="param-row">
                            <label>Вес</label>
                            <div class="param-value">${item.weight}гр<br />
                            </div>
                        </div></#if>
                        <div class="param-row">
                            <label>Артикул</label>
                            <div class="param-value">${item.vendor_code}</div>
                        </div>
                        <#if item.brand??>
                            <div class="param-row">
                                <label>Брэнд</label>
                                <div class="param-value">${item.brand}</div>
                            </div></#if>
                        <#if item.pfc??>
                            <div class="param-row">
                                <label>Белки, жиры, углеводы</label>
                                <div class="param-value">${item.pfc}</div>
                            </div>
                        </#if>
                        <#if item.calories??>
                        <div class="param-row">
                            <label>Энергетическая ценность</label>
                            <div class="param-value">${item.calories*4.184} кДж/${item.calories} кКал</div>
                        </div></#if>
                        <#if item.composition??>
                        <div class="param-row">
                            <label>Состав</label>
                            <div class="param-value">${item.composition}</div>
                        </div></#if>
                        <#if item.size??>
                            <div class="param-row">
                                <label>Размер</label>
                                <div class="param-value">${item.size}</div>
                            </div></#if>
                        <div class="param-row">
                            <label>В наличии</label>
                            <div class="param-value">${item.count} штук</div>
                        </div>
                    </div>
                </div>
                    <a href='/catalog/${item.category.id}?page=${page}&limit=${limit}&sorttype=${sorttype}&dir=${dir}&brands=${brands}&costs=${costs}' class="back-link">Возврат в каталог</a></article>
                <div class="clear"></div>
            </div>

        </div>
        <div class="clear"></div><div class="clear"></div><div class="clear"></div>
    </div>
 </#macro>