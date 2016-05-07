$(document).ready(function () {

    $(document).on('click', '.js_moveOnPage', function () {
        var $this = $(this);
        var brands = $this.data('brands');
        $.ajax({
            type: "POST",
            url: "/catalog/filter",
            data: {
                id: $this.data('id'),
                page: $this.data('page'),
                limit: $this.data('limit'),
                sorttype: $this.data('sorttype'),
                dir: $this.data('dir'),
                costs: $this.data('costs'),
                brands: JSON.stringify(brands)
            }
        }).done(function (data) {
            //console.log(data);
            if (data != '') {
                $("#goodsList").empty();
                $("#goodsList").append(data);
                $('input#radioPrice').removeAttr('data-page');
                $('input#radioPrice').attr('data-page', $this.data('page'));
                $('input#checkboxBrands').removeAttr('data-page');
                $('input#checkboxBrands').attr('data-page', $this.data('page'));
            } else {
                $this.hide();
            }
        }).fail(function () {
            alert("Приносим извинения.<br/>На сервере произошла ошибка");
            $this.hide();
        });
    });
    $(document).on("change", "select#select_limit", function () {
        var $this = $(this);
        var $value = $this.val();
        var page = $this.data('page'),
            dir = $this.data('dir'),
            sorttype = $this.data('sorttype');
        $.ajax({
            type: "POST",
            url: "/catalog/filter",
            data: {
                id: $this.data('id'),
                page: page,
                limit: $value,
                dir: dir,
                sorttype: sorttype,
                costs: $this.data('costs'),
                brands: JSON.stringify($this.data('brands'))
            }
        }).done(function (data) {
            //console.log(data);
            if (data != '') {
                $("#goodsList").empty();
                $("#goodsList").append(data);
                $('input#radioPrice').removeAttr('data-limit');
                $('input#radioPrice').attr('data-limit', $value);
                $('input#checkboxBrands').removeAttr('data-limit');
                $('input#checkboxBrands').attr('data-limit', $value);
            } else {
                $this.hide();
            }
        }).fail(function () {
            $this.hide();
            alert("Приносим извинения.<br/>На сервере произошла ошибка");
        });
    });
    $(document).on("change", "select#select_count", function () {
        var $this = $(this);
        var $value = $this.val();
        $.ajax({
            type: "POST",
            url: "/cart/setCount",
            data: {
                goodId: $this.data('goodid'),
                count: $value
            }
        }).done(function (data) {
            //console.log(data);
            if (data != '') {
                $('#listCart').empty();
                $('#listCart').append(data);
            } else {
                $this.hide();
            }
        }).fail(function () {
            $this.hide();
            alert("Приносим извинения.<br/>На сервере произошла ошибка");
        });
    });
    $(document).on("click", ".deleteGood", function () {
        var $this = $(this);
        $.ajax({
            type: "POST",
            url: "/cart/deleteGood",
            data: {
                goodId: $this.data('goodid')
            }
        }).done(function (data) {
            //console.log(data);
            if (data != '') {
                $('#listCart').empty();
                $('#listCart').append(data);
            } else {
                $this.hide();
            }
        }).fail(function () {
            $this.hide();
            alert("Приносим извинения.<br/>На сервере произошла ошибка");
        });
    });
    $(document).on("change", "select#select_limit", function () {
        var $this = $(this);
        var $value = $this.val();
        var page = $this.data('page'),
            dir = $this.data('dir'),
            sorttype = $this.data('sorttype');
        $.ajax({
            type: "POST",
            url: "/catalog/filter",
            data: {
                id: $this.data('id'),
                page: page,
                limit: $value,
                dir: dir,
                sorttype: sorttype,
                costs: $this.data('costs'),
                brands: JSON.stringify($this.data('brands'))
            }
        }).done(function (data) {
            //console.log(data);
            if (data != '') {
                $("#goodsList").empty();
                $("#goodsList").append(data);
                $('input#radioPrice').removeAttr('data-limit');
                $('input#radioPrice').attr('data-limit', $value);
                $('input#checkboxBrands').removeAttr('data-limit');
                $('input#checkboxBrands').attr('data-limit', $value);
            } else {
                $this.hide();
            }
        }).fail(function () {
            $this.hide();
            alert("Приносим извинения.<br/>На сервере произошла ошибка");
        });
    });
    $(document).on("change", "select#select_sort", function () {
        var $this = $(this);
        var $values = $this.val();
        var page = $this.data('page');
        var limit = $this.data('limit');
        var dir = $this.data('dir');
        $.ajax({
            type: "POST",
            url: "/catalog/filter",
            data: {
                id: $this.data('id'),
                page: page,
                limit: limit,
                sorttype: $values,
                dir: dir,
                costs: $this.data('costs'),
                brands: JSON.stringify($this.data('brands'))
            }
        }).done(function (data) {
            //console.log(data);
            if (data != '') {
                $("#goodsList").empty();
                $("#goodsList").append(data);
                $('input#radioPrice').removeAttr('data-sorttype');
                $('input#radioPrice').attr('data-sorttype', $values);
                $('input#checkboxBrands').removeAttr('data-sorttype');
                $('input#checkboxBrands').attr('data-sorttype', $values);
            } else {
                $this.hide();
            }
        }).fail(function () {
            $this.hide();
            alert("Приносим извинения.<br/>На сервере произошла ошибка");
        });
    });
    $(document).on("click", "img#js_direction", function () {
        var $this = $(this);
        var $dir;
        var $path = $this.attr('src');
        if ($path == '/resources/i/arrow2.gif') {
            $dir = 'desc';
            $(this).attr('src', $(this).attr('src').replace('arrow2', 'down'));
        } else {
            $dir = 'asc';
            $(this).attr('src', $(this).attr('src').replace('down', 'arrow2'));
        }
        $.ajax({
            type: "POST",
            url: "/catalog/filter",
            data: {
                id: $this.data('id'),
                page: $this.data('page'),
                limit: $this.data('limit'),
                sorttype: $this.data('sorttype'),
                dir: $dir,
                costs: $this.data('costs'),
                brands: JSON.stringify($this.data('brands'))
            }
        }).done(function (data) {
            //console.log(data);
            if (data != '') {
                $("#goodsList").empty();
                $("#goodsList").append(data);
                $('input#radioPrice').removeAttr('data-dir');
                $('input#radioPrice').attr('data-dir', $dir);
                $('input#checkboxBrands').removeAttr('data-dir');
                $('input#checkboxBrands').attr('data-dir', $dir);
            } else {
                $this.hide();
            }
        }).fail(function () {
            $this.hide();
            alert("Приносим извинения.<br/>На сервере произошла ошибка");
        });
    });
    $(document).on("change", "input#radioPrice", function () {
        var $this = $(this);
        var page = $this.data('page');
        var limit = $this.data('limit');
        var dir = $this.data('dir');
        var str = $('input#radioPrice:checked').val();
        $.ajax({
            type: "POST",
            url: "/catalog/filter",
            data: {
                id: $this.data('id'),
                page: page,
                limit: limit,
                sorttype: $this.data('sorttype'),
                dir: dir,
                costs: str,
                brands: JSON.stringify($this.data('brands'))
            }
        }).done(function (data) {
            //console.log(data);
            if (data != '') {
                $("#goodsList").empty();
                $("#goodsList").append(data);
                $('input#checkboxBrands').removeAttr('data-costs');
                $('input#checkboxBrands').attr('data-costs', str);
            } else {
                $this.hide();
            }
        }).fail(function () {
            $this.hide();
            alert("Приносим извинения.<br/>На сервере произошла ошибка");
        });
    });
    $(document).on("change", "input#checkboxBrands", function () {
        var $this = $(this);
        var page = $this.data('page');
        var limit = $this.data('limit');
        var dir = $this.data('dir');
        var selectedItems = new Array();
        $('input#checkboxBrands:checked').each(function () {
            selectedItems.push($(this).val());
        });
        var strJson = JSON.stringify(selectedItems);
        $.ajax({
            type: "POST",
            url: "/catalog/filter",
            data: {
                id: $this.data('id'),
                page: page,
                limit: limit,
                sorttype: $this.data('sorttype'),
                dir: dir,
                costs: $this.data('costs'),
                brands: strJson
            }
        }).done(function (data) {
            if (data != '') {
                $('input#radioPrice').removeAttr('data-brands');
                $('input#radioPrice').attr('data-brands', strJson);
                $("#goodsList").empty();
                $("#goodsList").append(data);
            } else {
                $this.hide();
            }
        }).fail(function () {
            $this.hide();
            alert("Приносим извинения.<br/>На сервере произошла ошибка");
        });
    });

    $(document).on('click', '.js_addToCart', function () {
        event.preventDefault();
        var $this = $(this);
        var r='#remark'+$this.data('id');
        $.ajax({
            type: 'POST',
            url: '/cart/add',
            data: {goodId: $this.data('id')},
            success: function (data, status) {
                console.log('/cart/add result: data=' + data + '; status=' + status);
                if (data == 'ok') {
                    $(r).empty();
                    $(r).append('<div class="sale-box"><span class="on_sale title_shop">In Shop Cart</span></div>');
                    $this.empty('value');
                    $this.attr('value', 'Go in cart');
                    $this.removeClass('js_addToCart').text('Go in cart').css('background', 'rgb(280, 124, 83)');
                }
            },
            error: function () {
                alert('Приносим извинения.<br/>На сервере произошла ошибка');
            }
        });
    });
    $(document).on('change', 'input#change_password', function () {
        var $this = $(this);
        $.ajax({
            type: "GET",
            url: "/cabinet/edit"
        }).done(function (data) {  // сюда приходит ответ при успехе
            //console.log(data);
            if (data != '') {
                if ($this.attr("checked")) {
                    $this.attr("checked", "checked");
                    $("#changePassword").append(data);

                } else {
                    $this.removeAttr("checked");
                    $("#changePassword").empty();
                }
            } else {
                $this.hide();
            }
        }).fail(function () {      // сюда приходит ответ если на сервере прооизошла ошибка
            $this.hide();
            alert('Приносим извинения.<br/>На сервере произошла ошибка');
        });
    });

    $(document).on('click', 'button#showOrders', function () {
        var $this = $(this);
        $.ajax({
            type: "GET",
            url: "/cabinet/orders"
        }).done(function (data) {  // сюда приходит ответ при успехе
            //console.log(data);
            if (data != '') {
                if ($this.attr("show")) {
                    $this.removeAttr("show");
                    $("#ordersList").empty();

                } else {

                    $this.attr("show", "true");
                    $("#ordersList").append(data);
                }
            } else {
                $this.hide();
            }
        }).fail(function () {      // сюда приходит ответ если на сервере прооизошла ошибка
            $this.hide();
            alert('Приносим извинения.<br/>На сервере произошла ошибка');
        });
    });

    $(document).on("click", ".deleteOrder", function () {
        var $this = $(this);
        $.ajax({
            type: "POST",
            url: "/order/deleteOrder",
            data: {
               orderId: $this.data('orderid')
            }
        }).done(function (data) {
            //console.log(data);
            if (data != '') {
                $('#ordersList').empty();
                $('#ordersList').append(data);
            } else {
                $this.hide();
            }
        }).fail(function () {
            $this.hide();
            alert("Приносим извинения.<br/>На сервере произошла ошибка");
        });
    });
});