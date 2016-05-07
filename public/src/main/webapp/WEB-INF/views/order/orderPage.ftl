<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../template/template.ftl">
<@mainTemplate title="Оформление заказа"/>
<#macro m_body>

<div class="register_account">
    <div class="wrap">

        <h4 class="title">SECURE CHECKOUT</h4>
        <h4 class="title" style="text-align:center"><p>Hello
            dear, ${user.secondName} ${user.name} ${user.middleName}</p>

            <p>You have ${total_count} items on ${total_sum} rub.</p></h4>
        <@form.form commandName="orderForm" action="/order" acceptCharset="UTF-8" method="post">
            <input hidden name="total_sum" value="${total_sum}">
            <input hidden name="total_count" value="${total_count}">

            <div class="col_1_of_2 span_1_of_2">
                <div>

                    <p>Please, fill all fields to contents order</p>
                </div>
                <div> <@form.input placeholder="AREA" path="area" />
                    <@form.errors path="area" cssStyle="color: red;" /></div>
                <div> <@form.input placeholder="CITY" path="city" />
                    <@form.errors path="city" cssStyle="color: red;" /></div>
                <div> <@form.input placeholder="STREET" path="street" />
                    <@form.errors path="street" cssStyle="color: red;" /></div>

            </div>
            <div class="col_1_of_2 span_1_of_2">
                <div> <@form.input placeholder="HOUSE" path="house" />
                    <@form.errors path="house" cssStyle="color: red;" /></div>
                <div> <@form.input placeholder="FLAT" path="flat" />
                    <@form.errors path="flat" cssStyle="color: red;" /></div>
                <div> <@form.input placeholder="INDEX" path="index" />
                    <@form.errors path="index" cssStyle="color: red;" /></div>
                <div style="padding-top:30px;padding-bottom:30px"><p>PAYMENT METHOD:</p>

                    <div style="padding-left:200px;"><p>
                        <@form.radiobutton  path="pay_type" value="Creditcart"/> Credit cart</p>

                        <p><@form.radiobutton  path="pay_type" value="PayPal"/> PayPal </p>
                        <@form.errors path="pay_type" cssStyle="color: red;" /></div>
                </div>

                <div class="clear"></div>
                <button class="grey">Submit</button>
            </div>
        </@form.form>
        <div class="clear"></div>
    </div>
</div>

</#macro>
