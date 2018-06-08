(function ($) {
    $.extend($.messager, { 
        waitting: function (title, msg) {
            var opts = typeof title == "object" ? title : { title: title, msg: msg };
            var cls = "messager-body-icon messager-body-loading";
            opts = $.extend({}, $.messager.defaults, {
                timeout: 0,
                closable: false
            }, opts, {
                msg: "<div class=\"" + cls + "\"></div>" + "<div>" + opts.msg + "</div>" + "<div style=\"clear:both;\"/>"
            });
            var win = $.messager.show(opts);
           
            return win;
        },
        closewatting: function () {
            var win = $("body>div.messager-window>div.messager-body:has(div.messager-body-loading)");
            if (win.length)
                win.window("close"); 
        }
    });
})(jQuery);