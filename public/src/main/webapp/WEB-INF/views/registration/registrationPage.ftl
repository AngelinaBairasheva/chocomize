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
                    <@form.input placeholder="First Name" path="firstName" />
                    <@form.errors path="firstName" cssStyle="color: red;" />
                </div>
                <div>
                    <@form.input   placeholder="Last Name" path="lastName" />
                    <@form.errors path="lastName" cssStyle="color: red;" />
                </div>
                <@form.input  placeholder="Middle Name" path="middleName" />
                <@form.errors path="middleName" cssStyle="color: red;" />
                <div>
                    <@form.input  placeholder="E-mail" path="email" />
                    <@form.errors path="email" cssStyle="color: red;" />
                    <#if errorEmail??><div style="color: red;">${errorEmail}</div></#if>
                </div>

                <i class="news-letter">
                    <label class="">
                        <@form.checkbox path="signIn" />
                        <i> </i>Sign Up for Newsletter
                        <@form.errors path="signIn" cssStyle="color: red;" />
                    </label>
                </i>

                <div class="clear"></div>

                <div>
                    <span>Password<label>*</label></span>
                    <@form.password cssStyle="font-size: 0.95em;
    color: #777;
    padding: 8px;
    outline: none;
    margin: 10px 0;
    width: 91%;
    font-family: 'Exo 2', sans-serif;
    border: none;
    box-shadow: 0 0 2px #aaa;
    -webkit-box-shadow: 0 0 2px #aaa;" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}"  path="password" />
                    <@form.errors name="j_password" path="password" cssStyle="color: red;" />
                </div>
                <div>
                    <span>Confirm Password<label>*</label></span>
                    <@form.password cssStyle="font-size: 0.95em;
    color: #777;
    padding: 8px;
    outline: none;
    margin: 10px 0;
    width: 91%;
    font-family: 'Exo 2', sans-serif;
    border: none;
    box-shadow: 0 0 2px #aaa;
    -webkit-box-shadow: 0 0 2px #aaa;" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Confirm Password';}" path="confirmPassword" />
                    <@form.errors path="confirmPassword" cssStyle="color: red;" /><br>
                <#if errorConfirming??><div style="color: red;">${errorConfirming}</div></#if>
                </div>
                <div class="clear"></div>
                <div style="color: red;">* Required Fields</div>
                <button class="grey">Submit</button>
                <p class="terms">By clicking 'Create Account' you agree to the <a href="#">Terms &amp; Conditions</a>.
                </p>
            </div>
            <div class="col_1_of_2 span_1_of_2">
                <div>
                    <@form.input placeholder="Phone" path="phone" />
                    <@form.errors path="phone" cssStyle="color: red;" />
                </div>
            </div>


            <div class="clear"></div>
        </@form.form>
    </div>
</div>
</#macro>
