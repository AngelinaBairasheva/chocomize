<div class="toolbar">
    <div class="sorter">
        <div class="sort-by toolbar-switch">
            <div class="toolbar-title">
                <label>Sort By</label>
                <span class="current">Default</span>
                <select onchange="setLocation(this.value)">
                    <option selected="selected"
                            value="http://www.chocomize.com/chocolate-shop/popular-chocolate-bars.html?dir=asc&amp;order=position">
                        Position
                    </option>
                    <option value="http://www.chocomize.com/chocolate-shop/popular-chocolate-bars.html?dir=asc&amp;order=name">
                        Name
                    </option>
                    <option value="http://www.chocomize.com/chocolate-shop/popular-chocolate-bars.html?dir=asc&amp;order=price">
                        Price
                    </option>
                </select>
            </div>
            <div class="toolbar-dropdown">
                <ul>
                    <li class="selected"><a
                            href="http://www.chocomize.com/chocolate-shop/popular-chocolate-bars.html?dir=asc&amp;order=position">Position</a>
                    </li>
                    <li>
                        <a href="http://www.chocomize.com/chocolate-shop/popular-chocolate-bars.html?dir=asc&amp;order=name">Name</a>
                    </li>
                    <li>
                        <a href="http://www.chocomize.com/chocolate-shop/popular-chocolate-bars.html?dir=asc&amp;order=price">Price</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="sort-order">
            <a href="http://www.chocomize.com/chocolate-shop/popular-chocolate-bars.html?dir=desc&amp;order=position"
               title="Set Descending Direction"><img
                    src="http://www.chocomize.com/skin/frontend/default/shopper/images/i_asc_arrow.gif"
                    width="27" height="27" alt="Set Descending Direction" class="v-middle"/></a>
        </div>

        <p class="view-mode">
            <label>View</label>
            <strong title="Grid" class="grid">Grid</strong>
            <a href="http://www.chocomize.com/chocolate-shop/popular-chocolate-bars.html?mode=list"
               title="List" class="list">List</a>
        </p>

        <div class="limiter toolbar-switch">
            <div class="toolbar-title">
                <label>Show</label>
                <span class="current">6</span>
                <select onchange="setLocation(this.value)">
                    <option value="http://www.chocomize.com/chocolate-shop/popular-chocolate-bars.html?limit=12">
                        12
                    </option>
                    <option selected="selected"
                            value="http://www.chocomize.com/chocolate-shop/popular-chocolate-bars.html?limit=18">
                        18
                    </option>
                </select>
                per page
            </div>
            <div class="toolbar-dropdown">
                <ul>
                    <li>
                        <a href="http://www.chocomize.com/chocolate-shop/popular-chocolate-bars.html?limit=15">15</a>
                    </li>
                    <li class="selected"><a
                            href="http://www.chocomize.com/chocolate-shop/popular-chocolate-bars.html?limit=30">30</a>
                    </li>
                    <li>
                        <a href="http://www.chocomize.com/chocolate-shop/popular-chocolate-bars.html?limit=45">45</a>
                    </li>
                </ul>
            </div>
        </div>


    </div>

    <div class="pager">

        <p class="amount">
            <strong>20 Item(s)</strong>
        </p>


    </div>
</div>