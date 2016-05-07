<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../template/template.ftl">
<@mainTemplate title="Личный кабинет"/>
<#macro m_body>
<div class="register_account">
    <div class="wrap">
        <div class="login-title">
            <h4 class="title">Edit Account Information</h4>
            <#if saved??><h4 class="title">${saved}</h4></#if>
            <div style="color: red;">${wrongCurrentPassword!}</div>

            <div style="color: red;">${errorNewPassword!}</div>

            <div style="color: red;">${errorConfirming!}</div>
        </div>
        <@form.form commandName="editForm" action="/cabinet" enctype="multipart/form-data" acceptCharset="UTF-8" method="post">
            <div class="col_1_of_2 span_1_of_2">
                <div>
                    <@form.input value="${user.name}" path="firstName" />
                    <@form.errors path="firstName" cssStyle="color: red;" />
                </div>
                <div>
                    <@form.input value="${user.secondName}" path="lastName" />
                    <@form.errors path="lastName" cssStyle="color: red;" />
                </div>
                <div>
                    <@form.input  value="${user.middleName}" path="middleName" />
                <@form.errors path="middleName" cssStyle="color: red;" />
                </div>
                <div>
                    <@form.input  value="${user.login}" path="email" />
                    <@form.errors path="email" cssStyle="color: red;" />
                    <div style="color: red;">${errorEmail!}</div>
                </div>
                <div class="clear"></div>
                <input type="checkbox" id="change_password" value="1" title="Change Password" class="checkbox">
                <label id="change_password">Change Password</label>

                <div style="height: 20px"></div>
                <div id="changePassword">

                </div>

                <div style="height: 20px"></div>
                <button class="red">Save</button>
            </div>
            <div class="col_1_of_2 span_1_of_2">
                <div>
                    <img width="200" height="200" src="${user.avatar!}" alt="альтернативный текст"/>
                </div>
                <div>
                    Добавить/изменить аватар: <@form.input path="photo" type="file"/><br/>
                </div>
                <div>
                    <div style="height: 20px"></div>
                    Phone number:
                    <@form.input value="${user.phone}" path="us_phone" />
                    <@form.errors path="us_phone" cssStyle="color: red;" />
                </div>
            </div>
            <div class="clear"></div>
        </@form.form>
        <button class="blue" id="showOrders">Show orders</button>
        <div style="height: 70px"></div>
        <div id="ordersList"></div>
    </div>
    <div class="clear"></div>
</div>
</#macro>
