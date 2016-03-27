
$(document).ready(function () {
    jQuery("input#minCost").change(function(){
        var value1=jQuery("input#minCost").val();
        var value2=jQuery("input#maxCost").val();
        if(parseInt(value1) > parseInt(value2)){
            value1 = value2;
            jQuery("input#minCost").val(value1);
        }
        jQuery("#slider").slider("values",0,value1);
    });
    jQuery("input#maxCost").change(function(){
        var value1=jQuery("input#minCost").val();
        var value2=jQuery("input#maxCost").val();
        if (value2 > 1000) { value2 = 1000; jQuery("input#maxCost").val(1000)}
        if(parseInt(value1) > parseInt(value2)){
            value2 = value1;
            jQuery("input#maxCost").val(value2);
        }
        jQuery("#slider").slider("values",1,value2);
    });
    jQuery("#slider").slider({
            min: 0,
    max: 1000,
    values: [0,1000],
    range: true,
    stop: function(event, ui) {
        jQuery("input#minCost").val(jQuery("#slider").slider("values",0));
        jQuery("input#maxCost").val(jQuery("#slider").slider("values",1));
    },
    slide: function(event, ui){
        jQuery("input#minCost").val(jQuery("#slider").slider("values",0));
        jQuery("input#maxCost").val(jQuery("#slider").slider("values",1));
    }
});














    $(document).on('click', '.js_moveOnPage', function () {
        var $this = $(this);
        var page = $this.data('page'),
            limit = $this.data('limit');
        $.ajax({
            type: "POST",
            url: "/catalog/showMore",
            data: {
                id: $this.data('id'),
                page: page,
                limit: limit
            }
        }).done(function (data) {  // сюда приходит ответ при успехе
            //console.log(data);
            if (data != '') {
                $("#goodsList").empty();
                $("#goodsList").append(data);
                updateCounter();
            } else {
                $this.hide();
                alert("ff");
            }
        }).fail(function () {      // сюда приходит ответ если на сервере прооизошла ошибка
            $this.hide();
            alert("fail");
        });

        function updateCounter() {
        }
    });
    $(document).on('click', '.js_addToCart', function () {
        //alert(3);
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

    $(document).on('click', '.js_goodDetail', function () {
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
    });

});