/**
 * jQuery EasyUI 1.4.3
 * 
 * Copyright (c) 2009-2015 www.jeasyui.com. All rights reserved.
 *
 * Licensed under the GPL license: http://www.gnu.org/licenses/gpl.txt
 * To use it on other terms please contact us at info@jeasyui.com
 *
 */
/**
 * linkbutton - jQuery EasyUI
 * 
 */
(function ($) {
    function create(target) {
        var opts = $.data(target, 'scrollbar').options;
        var t = $(target);
        
        var scrollbar = $("<div class=\"scrollbar\"></div>").insertBefore(target); 
        scrollbar.css({
            position: "relative",
            overflow: "hidden", 
            width: "auto",
            height: t.height() 
        });

        scrollbar[0].appendChild(target);
        t.css({ 
            overflow: "hidden", 
            width: "auto",
            height: t.height() 
        }); 

        var overflowY = $("<div class=\"scrollbarY\"></div>").appendTo(scrollbar);
        overflowY.css({ 
            position: "absolute",
            overflow: "hidden", 
            width: "7px",
            top: "21px",
            opacity: "0.4", 
            zindex: "auto",
            right:"1px",
            height: "102.965403624382px",
            background: "rgb(0, 0, 0)"
        });
        opts.overflowY = overflowY;
        var overflowX = $("<div class=\"scrollbarX\"></div>").appendTo(scrollbar);
        overflowX.css({
            position: "absolute",
            overflow: "hidden",
            height: "7px",
            bottom: "1px",
            opacity: "0.4",
            zindex: "auto",
            left: "21px",
            width: "102.965403624382px",
            background: "rgb(0, 0, 0)"
        });

        opts.overflowX = overflowX;
        // on rail over
        scrollbar.hover(function () {
            showBar(target);
        }, function () {
            hideBar(target);
        });
        var isDragg=false;
        overflowY.bind("mousedown", function (e) {
            var $doc = $(target);
            isDragg = true;
            var top  = parseFloat(overflowY.css('top'));
            pageY = e.pageY;
            $doc.bind("mousemove.scrollbar", function (e) {
                currTop = top + e.pageY - pageY;
                overflowY.css('top', currTop);

                $doc.scrollTop(currTop);
            });

            $doc.bind("mouseup.scrollbar", function (e) {
                isDragg = false; hideBar();
                $doc.unbind('.scrollbar');
            });
            return false;

        })
    }
    function scrollContent(y, isWheel, isJump) {
        releaseScroll = false;
        var delta = y;
        var maxTop = me.outerHeight() - bar.outerHeight();

        if (isWheel) {
            // move bar with mouse wheel
            delta = parseInt(bar.css('top')) + y * parseInt(o.wheelStep) / 100 * bar.outerHeight();

            // move bar, make sure it doesn't go out
            delta = Math.min(Math.max(delta, 0), maxTop);

            // if scrolling down, make sure a fractional change to the
            // scroll position isn't rounded away when the scrollbar's CSS is set
            // this flooring of delta would happened automatically when
            // bar.css is set below, but we floor here for clarity
            delta = (y > 0) ? Math.ceil(delta) : Math.floor(delta);

            // scroll the scrollbar
            bar.css({ top: delta + 'px' });
        }

        // calculate actual scroll amount
        percentScroll = parseInt(bar.css('top')) / (me.outerHeight() - bar.outerHeight());
        delta = percentScroll * (me[0].scrollHeight - me.outerHeight());

        if (isJump) {
            delta = y;
            var offsetTop = delta / me[0].scrollHeight * me.outerHeight();
            offsetTop = Math.min(Math.max(offsetTop, 0), maxTop);
            bar.css({ top: offsetTop + 'px' });
        }

        // scroll content
        me.scrollTop(delta);

        // fire scrolling event
        me.trigger('slimscrolling', delta);

        // ensure bar is visible
        showBar();

        // trigger hide when scroll is stopped
        hideBar();
    }
     
    function showBar(target) {

        var opts = $.data(target, 'scrollbar').options;
        opts.overflowY.fadeIn();
        opts.overflowX.fadeIn();
    }
    function hideBar(target) {

        var opts = $.data(target, 'scrollbar').options;
        opts.overflowY.fadeOut();
        opts.overflowX.fadeOut();
    }
    $.fn.scrollbar = function (options, param) {
        if (typeof options == 'string') {
            return $.fn.scrollbar.methods[options](this, param);
        }

        options = options || {};
        return this.each(function () {
            var state = $.data(this, 'scrollbar');
            if (state) {
                $.extend(state.options, options);
            } else {
                $.data(this, 'scrollbar', {
                    options: $.extend({}, $.fn.scrollbar.defaults, options)
                });
            }
            create(this);
             
        });
    };
    $.fn.scrollbar.defaults = {
        // width in pixels of the visible scroll area
        width: 'auto',

        // height in pixels of the visible scroll area
        height: '250px',

        // width in pixels of the scrollbar and rail
        size: '7px',

        // scrollbar color, accepts any hex/color value
        color: '#000',

        // scrollbar position - left/right
        position: 'right',

        // distance in pixels between the side edge and the scrollbar
        distance: '1px',

        // default scroll position on load - top / bottom / $('selector')
        start: 'top',

        // sets scrollbar opacity
        opacity: .4,

        // enables always-on mode for the scrollbar
        alwaysVisible: false,

        // check if we should hide the scrollbar when user is hovering over
        disableFadeOut: false,

        // sets visibility of the rail
        railVisible: false,

        // sets rail color
        railColor: '#333',

        // sets rail opacity
        railOpacity: .2,

        // whether  we should use jQuery UI Draggable to enable bar dragging
        railDraggable: true,

        // defautlt CSS class of the scrollbar rail
        railClass: 'scrollbarRail',

        // defautlt CSS class of the scrollbar bar
        barClass: 'scrollbarBar',

        // defautlt CSS class of the scrollbar wrapper
        wrapperClass: 'scrollbarDiv',

        // check if mousewheel should scroll the window if we reach top/bottom
        allowPageScroll: false,

        // scroll amount applied to each mouse wheel step
        wheelStep: 20,

        // scroll amount applied when user is using gestures
        touchScrollStep: 200,

        // sets border radius
        borderRadius: '7px',

        // sets border radius of the rail
        railBorderRadius: '7px'
    };

})(jQuery);