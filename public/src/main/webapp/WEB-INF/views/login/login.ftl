<#-- @ftlvariable name="topGoods" type="java.util.List<com.springapp.mvc.common.GoodInfo>" -->
<#include "../template/template.ftl">
<@mainTemplate title="Авторизация" />
<#macro m_body>
<div class="register_account">
    <div class="wrap">
        <h4 class="title">Account</h4>

            <#if error?has_content>
                <div style="color: red;">Error! Please, check your email and password!</div>
            </#if>
            <form name="authForm" id="authForm" action="/j_spring_security_check" method="post">
                <div class="col_1_of_2 span_1_of_2">
                    <div>
                        <label for="modlgn_username">Email*</label>
                        <input type="text" name="j_username">
                    </div>

                    <div>
                        <label for="modlgn_username">Password*</label>
                        <input type="password" name="j_password">
                    </div>

                    <div class="remember">
                        <div>
                            <input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>
                            <label for="remember_me" class="inline">Remember me</label>
                        </div>
                        <input type="submit" value="Login"/>
                        <a href="/registration" style="margin-left: 15px;">Create an account</a>

                    </div>

                </div>

                <div class="col_1_of_2 span_1_of_2">
                    </div>

                <div class="clear"></div>
            </form>
        </div>
    </div>
</#macro>