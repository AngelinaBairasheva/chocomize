<div class="mens-toolbar">
    <div class="sort">
        <div class="sort-by">
            <label>Sort By</label>
            <select>
                <option value="">
                    Position
                </option>
                <option value="">
                    Name
                </option>
                <option value="">
                    Price
                </option>
            </select>
            <a href=""><img src="/resources/i/arrow2.gif" alt="" class="v-middle"></a>
        </div>
    </div>
    <div class="pager">
        <div class="limiter visible-desktop">
            <label>Show</label>
            <select id="select_limit" data-page="${currentPage}" data-id="${catalog.id}">
                <#if limit=6><option selected value="6"><#else><option value="6"></#if>

                    6
                </option>
                <#if limit=9><option selected value="9"><#else><option value="9"></#if>
                    9
                </option>
                <#if limit=15><option selected value="15"><#else><option value="15"></#if>
                    15
                </option>
            </select> per page
        </div>
        <ul class="dc_pagination dc_paginationA dc_paginationA06">
            <li>
                <div class="previous">Pages</div>
            </li>
        <#if currentPage==1>
            <li class="disabled"><div class="show-more-button" style="max-width: 4px;max-height: 4px;">«</div></li> <#else>
            <li><div class="js_moveOnPage show-more-button"  data-page="${currentPage-1}" data-id="${catalog.id}" data-limit="${limit}">«</div>
            </li></#if>
        <#if pagesCount==1 || pagesCount==2|| pagesCount==3>
            <#list 1..pagesCount as i>
                <#if currentPage==i>
                    <li><div class="active js_moveOnPage show-more-button" data-id="${catalog.id}"
                           data-page="${i}" data-limit="${limit}">${i}</div>
                    </li><#else>
                    <li><div class="js_moveOnPage show-more-button"  data-id="${catalog.id}" data-page="${i}" data-limit="${limit}">${i}</div>
                    </li></#if></#list><#else>
            <#list 1..3 as i><#if currentPage==i>
                <li><div class="js_moveOnPage show-more-button" data-id="${catalog.id}" class="active"
                       data-page="${i}" data-limit="${limit}">${i}</div>
                </li><#else>
                <li><div class="js_moveOnPage show-more-button" data-id="${catalog.id}" data-page="${i}" data-limit="${limit}">${i}</div>
                </li></#if>  </#list>
            <li class="disabled"><a>...</a></li>
            <li>
                <div class="js_moveOnPage show-more-button" data-id="${catalog.id}" data-page="${pagesCount}" data-limit="${limit}">${pagesCount}</div>
            </li>
        </#if>
        <#if currentPage==pagesCount>
            <li class="disabled"><div style="max-width: 4px;max-height: 4px;" class="show-more-button">»</div></li><#else >
            <li><div  class="js_moveOnPage show-more-button" data-id="${catalog.id}" data-page="${currentPage+1}" data-limit="${limit}">»</div>
            </li></#if>
        </ul>
        <div class="clear"></div>
    </div>
    <div class="clear"></div>
</div>