<div class="mens-toolbar">
    <div class="sort">
        <div class="sort-by">
            <label>Sort By</label>
            <select id="select_sort" data-brands="${brands!"[]"}" data-costs="${costs}" data-dir="${dir!"asc"}" data-limit="${limit}" data-page="${currentPage}"
                    data-id="${catalog.id}">

            <#if (sorttype!"pstn")=="pstn">
                <option selected value="pstn"><#else>
            <option value="pstn"></#if>
                Position
            </option>
            <#if (sorttype!"pstn")=="Name">
                <option selected value="Name"><#else>
            <option value="Name"></#if>
                Name
            </option>
            <#if (sorttype!"pstn")=="Price">
                <option selected value="Price"><#else>
            <option value="Price"></#if>
                Price
            </option>
            </select>
                <img style="height: 18px;width: 8px;padding: 0;margin: 0;"
                     id="js_direction" src=<#if (dir!'asc')=='asc'>"/resources/i/arrow2.gif"<#else>
            "/resources/i/down.gif"</#if> data-brands="${brands!"[]"}"
            data-page="${currentPage}" data-limit="${limit}" data-id="${catalog.id}"
            data-sorttype="${sorttype!'pstn'}" data-costs="${costs}" alt="Set Direction" class="v-middle show-more-button">
        </div>
    </div>
<div class="pager">
    <div class="limiter visible-desktop">
        <label>Show</label>
        <select id="select_limit" data-costs="${costs}" data-brands="${brands!"[]"}" data-sorttype="${sorttype!"pstn"}" data-dir="${dir!"asc"}" data-page="${currentPage}"
                data-id="${catalog.id}" >
        <#if limit==6>
            <option selected value="6"><#else>
        <option value="6"></#if>
            6
        </option>
        <#if limit==9>
            <option selected value="9"><#else>
        <option value="9"></#if>
            9
        </option>
        <#if limit==15>
            <option selected value="15"><#else>
        <option value="15"></#if>
            15
        </option>
        </select> per page
    </div>
    <#if pagesCount!=0>
<ul class="dc_pagination dc_paginationA dc_paginationA06">
    <li>
        <div class="previous">Pages</div>
    </li>
<#if currentPage==1>
    <li class="disabled">
        <div class="show-more-button" style="max-width: 4px;max-height: 4px;">«</div>
    </li> <#else>
    <li>
        <div class="js_moveOnPage show-more-button" data-brands="${brands!"[]"}" data-costs="${costs}" data-sorttype="${sorttype!"pstn"}" data-dir="${dir!"asc"}"
             data-page="${currentPage-1}" data-id="${catalog.id}" data-limit="${limit}">«
        </div>
    </li></#if>
<#list 1..pagesCount as i>
    <#if currentPage==i>
        <li>
            <div class="active-page js_moveOnPage show-more-button" data-sorttype="${sorttype!"pstn"}" data-costs="${costs}"
                 data-dir="${dir!"asc"}" data-id="${catalog.id}" data-brands="${brands!"[]"}"
                 data-page="${i}" data-limit="${limit}">${i}</div>
        </li><#else>
        <li>
            <div class="js_moveOnPage show-more-button" data-dir="${dir!"asc"}" data-sorttype="${sorttype!"pstn"}" data-costs="${costs}"
                 data-brands="${brands!"[]"}" data-id="${catalog.id}" data-page="${i}" data-limit="${limit}">${i}</div>
        </li></#if></#list>
    <#if currentPage==pagesCount>
        <li class="disabled">
            <div style="max-width: 4px;max-height: 4px;" class="show-more-button">»</div>
        </li><#else >
        <li>
            <div class="js_moveOnPage show-more-button" data-sorttype="${sorttype!"pstn"}" data-dir="${dir!"asc"}" data-costs="${costs}"
                 data-brands="${brands!"[]"}" data-id="${catalog.id}" data-page="${currentPage+1}" data-limit="${limit}">»
            </div>
        </li></#if>
</ul></#if>
    <div class="clear"></div>
</div>
    <div class="clear"></div>
</div>