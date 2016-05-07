<#-- @ftlvariable name="endedCategories" type="java.util.List<com.springapp.mvc.api.domain.Category>" -->
<div class="footer">
    <div class="footer-top">
        <div class="wrap">
            <div class="section group example">
                <div class="col_1_of_2 span_1_of_2">
                    <ul class="f-list">
                        <li><img src="/resources/i/2.png"><span class="f-text">Free Shipping on orders over $ 100</span><div class="clear"></div></li>
                    </ul>
                </div>
                <div class="col_1_of_2 span_1_of_2">
                    <ul class="f-list">
                        <li><img src="/resources/i/3.png"><span class="f-text">Call us! toll free-222-555-6666 </span><div class="clear"></div></li>
                    </ul>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
    <div class="footer-middle">
        <div class="wrap">
            <div class="section group example">
                <div class="col_1_of_f_1 span_1_of_f_1">
                    <div class="section group example">
                        <div class="col_1_of_f_2 span_1_of_f_2">
                            <h3>Production</h3>
                        <#assign x=0>
                        <ul><#list endedCategories as category>
                                <#if x%5==0></ul><ul><#else >
                                <li><a href="/catalog/${category.id}">${category.name}</a></li> </#if>
                            <#assign x=x+1>
                        </#list>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="col_1_of_f_1 span_1_of_f_1">
                    <div class="section group example">
                        <div class="col_1_of_f_2 span_1_of_f_2">
                            <h3>Information</h3>
                            <ul class="f-list1" style="color: white;">
                                    <li>Premium, fair trade certified Belgian chocolate</li>
                                    <li>600 million possible combinations</li>
                                    <li>Made fresh to order in NYC</li>
                                    <li>For orders over $40 shipping is on us!&nbsp;(US only)</li>
                                    <li>Orders arrive within approx. 4 business days <span>(US only)</span></li>
                                    <li>The perfect gift for any occasion</li>
                                    <li>Logos &amp; pictures on your chocolate bars for bulk orders over 50 bars</li>
                            </ul>
                        </div>
                        <div class="col_1_of_f_2 span_1_of_f_2">
                            <h3>Contact us</h3>
                            <div class="company_address">
                                <p>500 Lorem Ipsum Dolor Sit,</p>
                                <p>22-56-2-9 Sit Amet, Lorem,</p>
                                <p>Russia</p>
                                <p>Phone:(00) 222 666 444</p>
                                <p>Fax: (000) 000 00 00 0</p>
                                <p>Email: <span>chockomize.shop@gmail.com</span></p>

                            </div>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
    <div class="footer-bottom">
        <div class="wrap">
            <div class="copy" style="color: white;">
                <p><address>© 2016 Chocomize Inc.  All rights reserved.</address></p>
            </div>
            <div class="f-list2">
                <ul>
                    <li class="active"><a href="/about">About Us</a></li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>

