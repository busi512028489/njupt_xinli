(function ($) {
    /**
	 * show tip message.
	 */
    function showTip(target) {
        var options = $.data(target, "validatebox").options;
        var box = $(target);  
        box.tooltip($.extend({}, options.tipOptions, { content: options.missingMessage, position: options.tipPosition, deltaX: options.deltaX, deltaY: options.deltaY })).tooltip("show");
    }

    /**
	 * hide tip message.
	 */
    function hideTip(target) {

        box.tooltip("hide");
    }

$.extend($.fn.validatebox.methods, {
    tipshow: function (jq) {
        return showTip(jq[0]);
    },
    tiphidden: function (jq) {

        return hideTip(jq[0]);
    }
});
})(jQuery);