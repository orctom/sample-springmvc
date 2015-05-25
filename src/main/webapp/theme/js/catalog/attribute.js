$(function() {
    $('.tree').jstree({
        'core' : {
            "check_callback" : true,
            'data' : {
                "url" : $('.tree').data("data")
            }
        },
        "plugins" : [ "contextmenu", "dnd", "unique", "wholerow" ]
    });

    $('#saveBtn').on("click", function() {
        var data = JSON.stringify($('.tree').jstree(true).get_json());
        $.ajax ({
            url: $('.tree').data("post"),
            type: 'POST',
            dataType: 'json',
            data: data,
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function(data) {
                flashMsg("Saved successful!");
            },
            error: function(data, status, err) {
                flashMsg("Failed to save: " + err, "danger");
            }
        });
    });
});