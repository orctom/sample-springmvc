$('#side-menu').metisMenu({
    toggle : false
});

$('table').on('click', 'tbody tr', function(event) {
    $(this).addClass('highlight').siblings().removeClass('highlight');
});

$('#confirm-delete').on('show.bs.modal', function(e) {
    var $target = $(e.relatedTarget);
    var $modal = $(this);
    if ($target.data('href')) {
        $modal.find('.danger').attr('href', $target.data('href'));
    } else if ($target.data('onclick')) {
        $modal.find('.danger').attr('onclick', $target.data('onclick'));
    }
    $modal.find('.danger').bind('click', function() {
        $modal.modal('hide');
    });
});

$('#modal').on('show.bs.modal', function(e) {
    var $target = $(e.relatedTarget);
    var $modal = $(this);
    var url = $target.data('url');
    var domain = $target.data('domain');
    if (url) {
        $.getJSON(url, function(data) {
            if (domain) {
                $modal.populateJson(data[domain]);
            } else {
                $modal.populateJson(data);
            }
        });
    }
});

var flashMsg = function(msg, alertLevel) {
    var level = "success";
    if (alertLevel) {        
        switch(alertLevel) {
        case "info":
            level = "info";
            break;
        case "danger":
            level = "danger";
            break;
        case "warning":
            level = "warning";
            break;
        }
    }
    $("<div class='alert alert-" + level + "'>" + msg + "</div>").appendTo($(".flashAlert"))
        .hide()
        .fadeIn(500)
        .delay(2000)
        .fadeOut(1000, function() {
            $(this).remove()}
        );
};

(function($) {
    $.fn.serializeObject = function() {
        "use strict";

        var result = {};
        var extend = function(i, element) {
            var node = result[element.name];

            if ('undefined' !== typeof node && node !== null) {
                if ($.isArray(node)) {
                    node.push(element.value);
                } else {
                    result[element.name] = [ node, element.value ];
                }
            } else {
                result[element.name] = element.value;
            }
        };

        $.each(this.serializeArray(), extend);
        return result;
    };
})(jQuery);

(function($) {
    $.fn.populateJson = function(json) {
        "use strict";

        var $this = this;
        $.each(json, function(key, value) {
            $('[name=' + key + '][type!=checkbox]', $this).val(value);
            $('[name=' + key + '][type=checkbox]', $this).prop('checked', value);
        });
    };
})(jQuery);