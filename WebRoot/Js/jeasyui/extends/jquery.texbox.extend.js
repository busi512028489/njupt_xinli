
(function ($) {
    
    function inputreadonly(target, readonly) { 
        var opts = $.data(target, "textbox").options;
        var tb = $.data(target, "textbox").textbox;
        var text=tb.find(".textbox-text");
        opts.inputreadonly = readonly == undefined ? true : readonly;
        if (opts.inputreadonly) {
            text.triggerHandler("blur.textbox");
        }
        text.validatebox("readonly", opts.inputreadonly);
        tb.removeClass("textbox-readonly").addClass(opts.inputreadonly ? "textbox-readonly" : "");
    } 

    function buttondisable(target) {
        var tb = $.data(target, "textbox").textbox;
        var btn = tb.find(".textbox-button");
        btn.linkbutton("disable");
    }

    function buttonenable(target) {
        var tb = $.data(target, "textbox").textbox;
        var btn = tb.find(".textbox-button");
        btn.linkbutton("enable");
    }


    $.extend($.fn.textbox.defaults, {
        inputreadonly: false,
        buttonreadonly: false
    });

    $.extend($.fn.textbox.methods, {
        inputreadonly: function (jq, readonly) {
            return inputreadonly(jq[0], readonly);
        },
        buttondisable: function (jq) { 
            return buttondisable(jq[0]);
        },
        buttonenable: function (jq) {
            return buttonenable(jq[0]);
        }
    });
})(jQuery);