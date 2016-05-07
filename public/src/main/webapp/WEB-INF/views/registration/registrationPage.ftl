<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../template/template.ftl">
<@mainTemplate title="Регистрация"/>
<#macro m_body>

<div class="register_account">
    <div class="wrap">

        <h4 class="title">Create an Account</h4>
        <@form.form commandName="regForm" action="/registration" acceptCharset="UTF-8" method="post">
            <div class="col_1_of_2 span_1_of_2">
                <div>
                    <@form.input placeholder="First Name *" path="firstName" />
                    <@form.errors path="firstName" cssStyle="color: red;" />
                </div>
                <div>
                    <@form.input   placeholder="Last Name *" path="lastName" />
                    <@form.errors path="lastName" cssStyle="color: red;" />
                </div>
                <@form.input  placeholder="Middle Name *" path="middleName" />
                <@form.errors path="middleName" cssStyle="color: red;" />
                <div>
                    <@form.input placeholder="Phone" path="phone" />
                    <@form.errors path="phone" cssStyle="color: red;" />
                </div>
                <div>
                    <@form.input  placeholder="E-mail *" path="email" />
                    <@form.errors path="email" cssStyle="color: red;" />
                     <div style="color: red;">${errorEmail!}</div>
                </div>
                <div class="clear"></div>

                <div>
                    <span>Password<label>*</label></span>
                    <@form.password  path="password" />
                    <@form.errors name="j_password" path="password" cssStyle="color: red;" />
                </div>
                <div>
                    <span>Confirm Password<label>*</label></span>
                    <@form.password path="confirmPassword" />
                    <@form.errors path="confirmPassword" cssStyle="color: red;" /><br>
                 <div style="color: red;">${errorConfirming!}</div>
                </div>
                <div class="clear"></div>
                <div style="color: red;">* Required Fields</div>
                <div style="height: 20px"></div>
                <button class="grey">Create Account</button>
                <p class="terms">By clicking 'Create Account' you agree to the  Terms &amp; Conditions.
                </p>
            </div>


            <div class="clear"></div>
        </@form.form>
    </div>
</div>
</#macro>
