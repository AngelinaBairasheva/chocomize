<#include "components/catalogToolbar.ftl">
<#include "components/goodView.ftl">
<#if items?has_content>
<#list items as good>
    <#if good_index%3==0 >
    <div class="top-box"></#if>
    <div class="col_1_of_3 span_1_of_3">
        <@goodView good=good/>
    </div>
    <#if (good_index+1)%3==0>
        <div class="clear"></div></div></#if>
</#list>
<#else>
<div class="top-box">
    <h2>Товаров по выбранным критериям нет</h2>
</div>
</#if>

