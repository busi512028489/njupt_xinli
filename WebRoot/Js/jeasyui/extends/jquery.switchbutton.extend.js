function IsChecked(target) {
    var opts = $(target).switchbutton('options');
    return opts.checked;
}


$.extend($.fn.switchbutton.methods, {
  
    IsChecked: function (jq) {
        return IsChecked(jq[0]);
    }
});