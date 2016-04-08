<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../template/template.ftl">
<@mainTemplate title="Оформление заказа"/>
<#macro m_body>

<div class="register_account">
    <div class="wrap">

        <h4 class="title">Оформление заказа</h4>
        <form action="/order"  method="post">
            <#if error??><div style="color: red;">${error}</div></#if>
            <div class="col_1_of_2 span_1_of_2">
                <div>
                    <p>Hello dear, ${lastName} ${firstName} ${middleName}</p>
                    <p>Please, fill all fields to contents order</p>
                </div>
                <div><input type="text" name="country" placeholder="country"></div>
                <div><input type=hidden name="user_login"></div>
                <div><input type="text" name="city" placeholder="city"></div>
                <div><input type="text" name="street" placeholder="street"></div>

            </div>
            <div class="col_1_of_2 span_1_of_2">
                <div><input type="text" name="house" placeholder="house"></div>
                <div><input type="text" name="flat" placeholder="flat"></div>
                <div><input type="text" name="pay_type" placeholder="pay type"></div>
            </div>


            <div class="clear"></div>
    </div>
</div>
</#macro>
