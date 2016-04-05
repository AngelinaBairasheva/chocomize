
<div class="rsidebar span_1_of_left">
    <section class="sky-form">
        <h4>Price</h4>

        <div class="row row1 scroll-pane">
        <#--<div class="col col-4">
            <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>Rs 500 - Rs 700</label>
        </div>-->
            <div class="col col-4">
                <input type="radio" name="radioPrice" id="radioPrice"
                       data-sorttype="${sorttype!"pstn"}"
                       data-dir="${dir!"asc"}" data-page="${currentPage}"
                       data-id="${catalog.id}" data-limit="${limit}" data-brands="${brands}" value="${min},${max}"><i></i>Не важно<br>
            <#assign price=min>
            <#list min..max as i>
            <#if (price+100) gt max > <input type="radio" name="radioPrice" id="radioPrice" data-brands="${brands}"
                                                                     data-sorttype="${sorttype!"pstn"}"
                                                                     data-dir="${dir!"asc"}" data-page="${currentPage}"
                    data-id="${catalog.id}" data-limit="${limit}" value="${price},${max}"><i></i>Rub ${price} - Rub ${max}<br><#else>
                <input type="radio" name="radioPrice"  id="radioPrice" data-brands="${brands}"
                                               data-sorttype="${sorttype!"pstn"}"
                                               data-dir="${dir!"asc"}" data-page="${currentPage}"
                                               data-id="${catalog.id}" data-limit="${limit}" value="${price},${price+100}"><i></i>
                    Rub ${price} - Rub ${price+100}
                <br>
            </#if>
            <#assign price=price+101>
            <#if price gt max><#break></#if>
            </#list>
            </div>
        </div>
    </section>
<#if brands??>
    <section class="sky-form">
        <h4>Brand Name</h4>

        <div class="row row1 scroll-pane">
        <#--<div class="col col-4">
            <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>John
                Jacobs</label>
        </div>-->
            <div class="col col-4">
            <#list brandses as brand>
                <label class="checkbox"><input type="checkbox" name="checkboxBrands" id="checkboxBrands"
                                               data-sorttype="${sorttype!"pstn"}"
                                               data-dir="${dir!"asc"}" data-page="${currentPage}"
                                               data-id="${catalog.id}" data-limit="${limit}" data-costs="${costs}" value="${brand}"><i></i>${brand}
                </label>
            </#list>
            </div>
        </div>
    </section>
</#if>
<#--<#if events??>
    <section class="sky-form">
        <h4>For special day</h4>

        <div class="row row1 scroll-pane">
        &lt;#&ndash;<div class="col col-4">
            <label class="checkbox"><input type="checkbox" name="checkbox"
                                           checked=""><i></i>Pilot</label>
        </div>&ndash;&gt;
            <div class="col col-4">
            <#list events as data>
                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>${data}
                </label></#list>
            </div>
        </div>
    </section></#if>-->
</div>
