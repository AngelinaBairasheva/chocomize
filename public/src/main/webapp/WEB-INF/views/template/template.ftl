<#macro mainTemplate title="Personalized Chocolate &amp; Custom Corporate Gifts | Chocomize" scripts=[] styles=[]>
<!DOCTYPE HTML>
<html>
<head>
    <title>${title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript" src="/resources/js/jquery-1.6.1.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.ui-slider.js"></script>
    <#--<script type="text/javascript" src="/resources/js/jquery.main.js"></script>-->
    <script type="text/javascript" src="/resources/js/jquery.jscrollpane.min.js"></script>
    <script type="text/javascript" src="/resources/js/own/catalog.js"></script>
    <link href="/resources/i/favicon.ico" rel="shortcut icon" type="image/x-icon">
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href="/resources/css/styles.css" rel="stylesheet" type="text/css" media="all" />
    <link href="/resources/css/form.css" rel="stylesheet" type="text/css" media="all" />
    <link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
    <script type="text/javascript" src="/resources/js/jquery1.min.js"></script>
    <#--<!-- start menu &ndash;&gt;-->
    <link href="/resources/css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="/resources/js/megamenu.js"></script>
    <script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
    <!--start slider -->
    <link rel="stylesheet" href="/resources/css/fwslider.css" media="all">
    <#--<script src="/resources/js/jquery-ui.min.js"></script>-->
    <#--<script src="/resources/js/jquery-ui.min.js"></script>-->
    <script src="/resources/js/css3-mediaqueries.js"></script>
    <script src="/resources/js/fwslider.js"></script>
    <#--<!--end slider &ndash;&gt;-->
 <link type="text/css" href="/resources/css/main.css" rel="stylesheet" media="all" />
    <#list styles as css>
        <link rel="stylesheet" href="/resources/${css}" type="text/css" />
    </#list>
    <!-- start details -->
    <script src="/resources/js/jquery.easydropdown.js"></script>
     <script src="/resources/js/slides.min.jquery.js"></script>
    <script>
        $(function(){
            $('#products').slides({
                preload: true,
                //preloadImage: 'img/loading.gif',
                effect: 'slide, fade',
                crossfade: true,
                slideSpeed: 350,
                fadeSpeed: 500,
                generateNextPrev: true,
                generatePagination: false
            });
        });
    </script>
    <link rel="stylesheet" href="/resources/css/etalage.css">
    <script src="/resources/js/jquery.etalage.min.js"></script>
    <script>
        jQuery(document).ready(function($){

            $('#etalage').etalage({
                thumb_image_width: 360,
                thumb_image_height: 360,
                source_image_width: 900,
                source_image_height: 900,
                show_hint: true,
                click_callback: function(image_anchor, instance_id){
                    alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
                }
            });

        });
    </script>
    <#list scripts as js>
        <script src="/resources/${js}" type="text/javascript" defer></script>
    </#list>
</head>
<body>
    <#include "components/header.ftl" />
    <@m_body />
    <#include "components/footer.ftl" />
</body>
</html>
</#macro>