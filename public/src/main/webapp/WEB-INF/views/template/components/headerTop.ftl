<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<div class="header-top">
    <div class="wrap">
        <div class="header-top-left">
            <div class="clear"></div>
        </div>
        <div class="cssmenu">
            <ul>
            <@sec.authorize ifAnyGranted="ROLE_ANONYMOUS">
                <a style="color: #FFFFFF;" class="login" class="cd-signin" href="/login">Log In</a> |
                <a style="color: #FFFFFF;" class="login" class="cd-signup" href="/registration">Sign Up</a>
            </@sec.authorize>
            <@sec.authorize access="isAuthenticated()">
                <a style="color: #FFFFFF;" href="/cabinet"><@sec.authentication property="principal.username" /></a>
                <a style="color: #FFFFFF;" class="login" href="/logout">
                    <li class="user_desc" style="padding-left: 10px;">Logout</li>
                </a>
            </@sec.authorize><div class="clearfix"></div>
            </ul>
        </div>
        <div class="clear"></div>
    </div>
</div>

