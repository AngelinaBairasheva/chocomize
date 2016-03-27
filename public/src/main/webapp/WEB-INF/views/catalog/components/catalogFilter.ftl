<div class="rsidebar span_1_of_left">
    <section class="sky-form">
        <h5>Price</h5>

        <div class="row row1 scroll-pane">
            <div class="col col-4">
                <div class="formCost">
                    <label for="minCost">Цена: от</label> <input type="text" id="minCost" value="${min}"/>
                    <label for="maxCost">до</label> <input type="text" id="maxCost" value="${max}"/>
                </div>
                <div class="sliderCont">
                    <div id="slider"></div>
                </div>
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

                <#list brands as brand>
                    <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>${brand}
                    </label>
                </#list>
            </div>
        </div>
    </section>
</#if>
<#if events??>
    <section class="sky-form">
        <h4>For special day</h4>

        <div class="row row1 scroll-pane">
        <#--<div class="col col-4">
            <label class="checkbox"><input type="checkbox" name="checkbox"
                                           checked=""><i></i>Pilot</label>
        </div>-->
            <div class="col col-4">
                <#list events as data>
                    <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>${data}
                    </label></#list>
            </div>
        </div>
    </section></#if>
</div>
