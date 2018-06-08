(function ($) {
    $.extend($.fn.treegrid.defaults, {
        iconField: null,
        parentField: null 
    });
    $.fn.treegrid.defaults.loadFilter = function (data, parentId) {
        var options = $(this).treegrid('options'); 
        if (options && options.parentField) {
            var idField = options.idField,
                parentField = options.parentField,
                iconField = options.iconField || 'icon';

            for (var i = 0, len = data.rows.length; i < len; i++) {
                if (data.rows[i][parentField] && data.rows[i][parentField] != '0' && data.rows[i][idField] != data.rows[i][parentField]) {
                    data.rows[i]['_parentId'] = data.rows[i][parentField];
                } else {
                    delete data.rows[i][parentField];
                }

                data.rows[i]['iconCls'] = data.rows[i][iconField];
            }
        }

        return data;
    }
})(jQuery);