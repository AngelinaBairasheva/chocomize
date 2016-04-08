$(document).ready(function () {

    $(document).on('click', '.js_moveOnPage', function () {
        var $this = $(this);
        $.ajax({
            type: "POST",
            url: "/catalog/showMore",
            data: {
                id: $this.data('id'),
                page: $this.data('page'),
                limit: $this.data('limit'),
                sorttype: $this.data('sorttype'),
                dir: $this.data('dir'),
                costs: $this.data('costs'),
                brands: $this.data('brands')
            }
        }).done(function (data) {  // сюда приходит ответ при успехе
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
            url: "/catalog/setLimit",
            data: {
                id: $this.data('id'),
                page: page,
                limit: $value,
                dir: dir,
                sorttype: sorttype,
                costs: $this.data('costs'),
                brands: $this.data('brands')
            }
        }).done(function (data) {  // сюда приходит ответ при успехе
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
        }).fail(function () {      // сюда приходит ответ если на сервере прооизошла ошибка
            $this.hide();
            alert("Приносим извинения.<br/>На сервере произошла ошибка");
        });
    });
    $(document).on("change", "select#select_count", function () {
        var $this = $(this);
        var $value = $this.val();
        alert($this.data('goodid'));
        $.ajax({
            type: "POST",
            url: "/cart/setCount",
            data: {
                goodId: $this.data('goodid'),
                count: $value
            }}).done(function (data) {  // сюда приходит ответ при успехе
                //console.log(data);
                if (data != '') {
                    $('#listCart').empty();
                    $('#listCart').append(data);
                } else {
                    $this.hide();
                }
        }).fail(function () {      // сюда приходит ответ если на сервере прооизошла ошибка
            $this.hide();
            alert("Приносим извинения.<br/>На сервере произошла ошибка");
        });
    });
    $(document).on("click", ".deleteGood", function () {
        var $this = $(this);
        alert("delete");
        alert($this.data('goodid'));
        $.ajax({
            type: "POST",
            url: "/cart/deleteGood",
            data: {
                goodId: $this.data('goodid')
            }}).done(function (data) {  // сюда приходит ответ при успехе
            //console.log(data);
            if (data != '') {
                $('#listCart').empty();
                $('#listCart').append(data);
            } else {
                $this.hide();
            }
        }).fail(function () {      // сюда приходит ответ если на сервере прооизошла ошибка
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
            url: "/catalog/setLimit",
            data: {
                id: $this.data('id'),
                page: page,
                limit: $value,
                dir: dir,
                sorttype: sorttype,
                costs: $this.data('costs'),
                brands: $this.data('brands')
            }
        }).done(function (data) {  // сюда приходит ответ при успехе
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
        }).fail(function () {      // сюда приходит ответ если на сервере прооизошла ошибка
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
            url: "/catalog/sort",
            data: {
                id: $this.data('id'),
                page: page,
                limit: limit,
                sorttype: $values,
                dir: dir,
                costs: $this.data('costs'),
                brands: $this.data('brands')
            }
        }).done(function (data) {  // сюда приходит ответ при успехе
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
        }).fail(function () {      // сюда приходит ответ если на сервере прооизошла ошибка
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
            url: "/catalog/sort",
            data: {
                id: $this.data('id'),
                page: $this.data('page'),
                limit: $this.data('limit'),
                sorttype: $this.data('sorttype'),
                dir: $dir,
                costs: $this.data('costs'),
                brands: $this.data('brands')
            }
        }).done(function (data) {  // сюда приходит ответ при успехе
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
        }).fail(function () {      // сюда приходит ответ если на сервере прооизошла ошибка
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
            url: "/catalog/selectByPrice",
            data: {
                id: $this.data('id'),
                page: page,
                limit: limit,
                sorttype: $this.data('sorttype'),
                dir: dir,
                costs: str,
                brands: $this.data('brands')
            }
        }).done(function (data) {  // сюда приходит ответ при успехе
            //console.log(data);
            if (data != '') {
                $("#goodsList").empty();
                $("#goodsList").append(data);
                $('input#checkboxBrands').removeAttr('data-costs');
                $('input#checkboxBrands').attr('data-costs', str);
            } else {
                $this.hide();
            }
        }).fail(function () {      // сюда приходит ответ если на сервере прооизошла ошибка
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
            url: "/catalog/selectByBrands",
            data: {
                id: $this.data('id'),
                page: page,
                limit: limit,
                sorttype: $this.data('sorttype'),
                dir: dir,
                costs: $this.data('costs'),
                brands: strJson
            }
        }).done(function (data) {  // сюда приходит ответ при успехе
            //console.log(data);
            if (data != '') {
                $('input#radioPrice').removeAttr('data-brands');
                $('input#radioPrice').attr('data-brands', strJson);
                $("#goodsList").empty();
                $("#goodsList").append(data);
            } else {
                $this.hide();
            }
        }).fail(function () {      // сюда приходит ответ если на сервере прооизошла ошибка
            $this.hide();
            alert("Приносим извинения.<br/>На сервере произошла ошибка");
        });
    });

    $(document).on('click', '.js_addToCart', function () {
        // alert(3);
        event.preventDefault();
        var $this = $(this);
        $.ajax({
            type: 'POST',
            url: '/cart/add',
            data: {goodId: $this.data('id')},
            success: function (data, status) {  // успешное завершение работы
                console.log('/cart/add result: data=' + data + '; status=' + status);
                if (data == 'ok') {
                    $this.removeClass('js_addToCart').text('Go in cart').css('background', 'rgb(280, 124, 83)');
                }
            },
            error: function () {    // На сервере произошла ошибка
                alert('Приносим извинения.<br/>На сервере произошла ошибка');
            }
        });
    });

    /*  $(document).on('click', '.js_goodDetail', function () {
     event.preventDefault();
     $.ajax({
     type: 'POST',
     url: '/good/' + $(this).data('id'),
     dataType: 'json',
     success: function (data, status) {  // успешное завершение работы
     alert(JSON.stringify(data, "", 4));
     },
     error: function (error) {    // На сервере произошла ошибка
     alert('Приносим извинения.<br/>На сервере произошла ошибка<br/>' + error);
     }
     });
     });*/

});