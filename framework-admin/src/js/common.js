$(function() {
	// Waves初始化
	Waves.displayEffect();
	// 数据表格动态高度
	$(window).resize(function () {
		$('#table').bootstrapTable('resetView', {
			height: getHeight()
		});
	});
	// 设置input特效
	$(document).on('focus', 'input[type="text"]', function() {
		$(this).parent().find('label').addClass('active');
	}).on('blur', 'input[type="text"]', function() {
		if ($(this).val() == '') {
			$(this).parent().find('label').removeClass('active');
		}
	});
	// select2初始化
	$('select').select2();
});
// 动态高度
function getHeight() {
	return $(window).height() - 20;
}
// 数据表格展开内容
function detailFormatter(index, row) {
	var html = [];
	$.each(row, function (key, value) {
		html.push('<p><b>' + key + ':</b> ' + value + '</p>');
	});
	return html.join('');
}
// 初始化input特效
function initMaterialInput() {
	$('form input[type="text"]').each(function () {
		if ($(this).val() != '') {
			$(this).parent().find('label').addClass('active');
		}
	});
}
var pxconfirm = {};
(function (px, $) {
    var alert = {
        TYPE: {
            SUCCESS: 1,
            INFO: 2,
            WARNING: 3,
            ERROR: 4
        },
        BUTTON: {
            SUCCESS: {
                text: '确认',
                btnClass: 'waves-effect waves-button waves-center btn-green'
            },
            INFO: {
                text: '确认',
                btnClass: 'waves-effect waves-button waves-center btn-blue'
            },
            WARNING: {
                text: '确认',
                btnClass: 'waves-effect waves-button waves-center btn-orange'
            },
            ERROR: {
                text: '确认',
                btnClass: 'waves-effect waves-button waves-center btn-red'
            }
        },
        ICON: {
            SUCCESS: "glyphicon glyphicon-ok-sign",
            INFO: "glyphicon glyphicon-info-sign",
            WARNING: "glyphicon glyphicon-exclamation-sign",
            ERROR: "glyphicon glyphicon-remove-sign"
        }
    }
    px.alert = alert;
    px.pxalert = function (msg, btype) {
        var buttons;
        var types;
        var title;
        var icon;
        if (btype) {
            switch (btype) {
                case 1 :
                    types = "green";
                    buttons = px.alert.BUTTON.SUCCESS;
                    title = "信息";
                    icon = px.alert.ICON.SUCCESS;
                    break;
                case 2 :
                    types = "blue";
                    title = "信息";
                    buttons = px.alert.BUTTON.INFO;
                    icon = px.alert.ICON.INFO;
                    break;
                case 3 :
                    types = "orange";
                    title = "警告";
                    buttons = px.alert.BUTTON.WARNING;
                    icon = px.alert.ICON.WARNING;
                    break;
                case 4 :
                    types = "red";
                    title = "错误";
                    buttons = px.alert.BUTTON.ERROR;
                    icon = px.alert.ICON.ERROR;
                    break;
                default:
                    types = "blue";
                    title = "信息";
                    buttons = px.alert.BUTTON.INFO;
                    icon = px.alert.ICON.INFO;
                    break;
            }
        } else {
            types = "blue";
            title = "信息";
            buttons = px.alert.BUTTON.INFO;
            icon = px.alert.ICON.INFO;
        }

        // debugger;
        $.alert({
            icon: icon,
            title: title,
            titleClass: "jconfirm-red",
            theme: 'light',
            animation: 'rotateX',
            closeAnimation: 'rotateX',
            type: types,
            content: msg,
            buttons: {confirm: buttons}
        });
    }

})
(pxconfirm, jQuery);

(function (px, $) {
    px.pxconfirm=function (msg,okfun,cancelfun) {
        var dialog = $.confirm({
            icon:pxconfirm.alert.ICON.SUCCESS,
            type: 'blue',
            animationSpeed: 300,
            title: "信息确认",
            content: msg,
            buttons: {
                confirm: {
                    text: '确认',
                    btnClass: 'waves-effect waves-button btn-blue',
                    action: function () {
                        dialog.close();
                        if(okfun){
                            okfun();
                        }
                    }
                },
                cancel: {
                    text: '取消',
                    btnClass: 'waves-effect waves-button btn-blue',
                    action: function () {
                        dialog.close();
                        if(cancelfun){
                            cancelfun();
                        }
                    }
                }
            }
        });
    }

})(pxconfirm, jQuery);

(function (px, $) {
    var dialog={};
    px.dialog=function (title,columnClass,content,contentReady,buttongrps,close) {
        var bts={};
        // debugger;
        if(buttongrps && buttongrps.length>0){
            for(var i=0;i<buttongrps.length;i++){
                var btts=buttongrps[i];
                // debugger;
                for(var key in btts){
                    var act=btts[key];
                    var btn={
                        text: key,
                        btnClass: 'btn-blue',
                        action: act
                    }
                    btts[key]=btn;
                    break;
                }
                $.extend(bts,btts);
            }
        }
        $.extend(bts,{'关闭':{
                text: '关闭',
                btnClass: 'btn-blue'
            }});

        dialog = $.confirm({
            icon: 'glyphicon glyphicon-th-large',
            animationSpeed: 300,
            type:'blue',
            title: title,
            draggable:true,
            alignMiddle:false,
            closeIcon:true,
            columnClass: columnClass,
            content: content,
            onContentReady: function () {
                initMaterialInput();
                if(contentReady && $.isFunction(contentReady)){
                    contentReady();
                }
            },
            buttons:bts,
            onClose:function () {
                if(close && $.isFunction(close)){
                    close(dialog);
                }
            }
        });
        return dialog;
    }
})(pxconfirm, jQuery);
