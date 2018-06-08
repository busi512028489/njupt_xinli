
(function ($) {
    /**
     * 获得节点层级
     */
    function getLevel(target, node) {
        var n = 1;
        var parentNode = $(target).tree('getParent', node.target);
        if (!parentNode) {
            return 1;
        }
        return n + getLevel(target, parentNode);
    }
    /**
     * 获得节点层级
     */
    function updateData(target, param) {
        var options = $.data(target, "tree").options;
        $(target).tree('update', {
            target: param.node.target,
            text: param.data[options.textField]
        });
        $.extend(param.node, param.data);
        return param.node;
    }
    /**
     *判断是否标准数据格式
     */
    function isTransfrom(options) {
        var flag = options.idField ||
            options.textField ||
            options.iconField ||
            options.childrenField || false;

        return flag ? true : false;
    }

    /**
     *简单数据格式
     */
    function simpleDataTransform(options, data) {
        if (!isTransfrom(options)) return data;

        var idField = options.idField || 'id',
            textField = options.textField || 'text',
            iconField = options.iconField || 'iconCls',
            parentField = options.parentField || 'pid',
            attributes = options.attributes || [];

        var treeData = [], tmpMap = [];

        for (var i = 0, len = data.length; i < len; i++) {
            tmpMap[data[i][idField]] = data[i];
        }

        for (var i = 0, len = data.length; i < len; i++) {
            if (tmpMap[data[i][parentField]] && data[i][idField] != data[i][parentField]) {
                if (!tmpMap[data[i][parentField]]['children']) {
                    tmpMap[data[i][parentField]]['children'] = [];
                }

                data[i]['id'] = data[i][idField];
                data[i]['text'] = data[i][textField];
                data[i][iconField] && (data[i]['iconCls'] = data[i][iconField]);
                tmpMap[data[i][parentField]]['children'].push(data[i]);
            } else {
                data[i]['id'] = data[i][idField];
                data[i]['text'] = data[i][textField];
                data[i][iconField] && (data[i]['iconCls'] = data[i][iconField]);
                treeData.push(data[i]);
            }
        }

        return treeData;
    }

    /**
     *标准数据格式
     */
    function standardTransform(options, data) {
        if (!isTransfrom(options)) return data;

        var idField = options.idField || 'id',
            textField = options.textField || 'text',
            iconField = options.iconField || 'iconCls',
            childrenField = options.childrenField || 'children',
            attributesField = options.attributesField || 'attributes',
            attributes = options.attributes || [];

        var transform = function (node) {
            if (!node['id'] && node[idField]) node['id'] = node[idField];
            if (!node['text'] && node[textField]) node['text'] = node[textField];
            if (!node['iconCls'] && node[iconField]) node['iconCls'] = node[iconField];
            if (!node['children'] && node[childrenField]) node['children'] = node[childrenField];


            if (node['children']) {
                for (var i = 0; i < node['children'].length; i++) {
                    transform(node['children'][i]);
                }
            }
        }

        for (var i = 0; i < data.length; i++) {
            transform(data[i]);
        }

        return data;
    }
    $.fn.tree.defaults.loadFilter = function (data, parent) {
        var cusOptions = $(this).tree('options');
        if (cusOptions) {
            if (cusOptions.dataModel == 'simpleData') {
                return simpleDataTransform(cusOptions, data);
            } else {
                return standardTransform(cusOptions, data);
            }
        }
        return data;
    }
    $.fn.combotree.defaults.loadFilter = $.fn.tree.defaults.loadFilter;
    $.extend($.fn.tree.defaults, {
        idField: null,
        textField: null,
        parentField: null,
        childrenField: null,
        iconField: null,
        dataModel: null
    });

    $.extend($.fn.tree.methods, {
        /**
         * 获得节点层级
         */
        getLevel: function (jq, node) {
            return getLevel(jq[0], node);
        },
        /**
         * 获得节点层级
         */
        updateData: function (jq,  param) {
            return updateData(jq[0], param);
        }
    });
})(jQuery);