<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<div id="createDialog" class="crudDialog">
	<form id="createForm" method="post" >
        <div class="col-sm-12">
            <div class="form-group  col-sm-6 div-bottom-0 div-top-5">
                <label for="company" class="col-sm-4 control-label div-paddingRight-3"><label style="color: red;">*</label><spring:message code="companyName"/></label>
                <div class="col-sm-8 div-paddingLeft-0">
                    <input id="company"   name="company" maxlength="20" style="width: 300px; height: 28px;" class="form-control input-h"/>
                </div>
            </div>
        </div>
        <div class="col-sm-12">
            <div class="form-group  col-sm-6 div-bottom-0 div-top-5">
                <label for="companyName"  class="col-sm-4 control-label div-paddingRight-3"><label style="color: red;">*</label><spring:message code="companyAbbreviation"/></label>
                <div class="col-sm-8 div-paddingLeft-0">
                    <input id="companyName" type="text" name="companyName" class="form-control input-hei-date" maxlength="20"/>
                </div>
            </div>
            <div class="form-group  col-sm-6 div-bottom-0 div-top-5">
                <label for="companyCode" class="col-sm-4 control-label div-paddingRight-3"><spring:message code="CompanyCode"/></label>
                <div class="col-sm-8 div-paddingLeft-0">
                    <input id="companyCode" type="text" name="companyCode" class="form-control input-hei-date" maxlength="20"/>
                </div>
            </div>
        </div>
        <div class="col-sm-12">
            <div class="form-group  col-sm-6 div-bottom-0 div-top-5">
                <label for="areaname" class="col-sm-4 control-label div-paddingRight-3"><spring:message code="area"/></label>
                <div class="form-group div-left-10">
                    <div class=" col-sm-8 div-paddingLeft-0">
                        <input id="areaname" type="text"  name="location" maxlength="20" class="form-tree-control  col-sm-10 input-hei-date">
                    </div>
                </div>
            </div>
            <div class="form-group  col-sm-6 div-bottom-0 div-top-5">
                <label for="type" class="col-sm-4 control-label div-paddingRight-3"><spring:message code="type"/></label>
                <div class="col-sm-8 div-paddingLeft-0">
                    <input id="type" type="text" name="type"  class="form-control input-hei-date" maxlength="20"/>
                </div>
            </div>
        </div>
        <div class="col-sm-12">
            <div class="form-group  col-sm-6 div-bottom-0 div-top-5">
                <label for="phone" class="col-sm-4 control-label div-paddingRight-3"><spring:message code="phone"/></label>
                <div class="col-sm-8 div-paddingLeft-0">
                    <input id="phone" type="text" name="phone" class="form-control input-hei-date" maxlength="20"/>
                </div>
            </div>
            <div class="form-group  col-sm-6 div-bottom-0 div-top-5">
                <label for="fax" class="col-sm-4 control-label div-paddingRight-3"><spring:message code="fax"/></label>
                <div class="col-sm-8 div-paddingLeft-0">
                    <input id="fax" type="text" name="fax" class="form-control input-hei-date" maxlength="20"/>
                </div>
            </div>
        </div>
        <div class="col-sm-12">
            <div class="form-group  col-sm-6 div-bottom-0 div-top-5">
                <label for="phone" class="col-sm-4 control-label div-paddingRight-3"><spring:message code="EnglishAbbreviations"/></label>
                <div class="col-sm-8 div-paddingLeft-0">
                    <input id="engAbbreviate" type="text" name="engAbbreviate" class="form-control input-hei-date" maxlength="20"/>
                </div>
            </div>
            <div class="form-group  col-sm-6 div-bottom-0 div-top-5">
                <label for="rate" class="col-sm-4 control-label div-paddingRight-3"><spring:message code="tax"/></label>
                <div class="col-sm-8 div-paddingLeft-0">
                    <input id="rate" type="number" name="rate" step="0.01" class="form-control input-hei-date" maxlength="20"/>
                </div>
            </div>
        </div>
        <div class="col-sm-12">
            <div class="form-group  col-sm-6 div-bottom-0 div-top-5">
                <label for="dueDates" class="col-sm-4 control-label div-paddingRight-3"><spring:message code="dueDate"/></label>
                <div class="col-sm-8 div-paddingLeft-0">
                    <input id="dueDates" type="text" name="dueDates" class="form-control input-hei-date Wdate"  style="height: 28px" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
                </div>
            </div>
        </div>
        <div class="col-sm-12">
            <div class="form-group  col-sm-6 div-bottom-0 div-top-5">
                <label for="website" class="col-sm-4 control-label div-paddingRight-3" ><spring:message code="url"/></label>
                <div class="col-sm-8 div-paddingLeft-0">
                    <input id="website"   name="website" maxlength="20" style="width: 300px; height: 28px;" class="form-control input-h"/>
                </div>
            </div>
        </div>
        <div class="col-sm-12">
            <div class="form-group  col-sm-6 div-bottom-0 div-top-5">
                <div>
                    <label for="address" class="col-sm-4 control-label div-paddingRight-3"><spring:message code="location"/></label>
                    <div class="col-sm-8 div-paddingLeft-0">
                        <input id="address"  rows="1" name="address" maxlength="20" style="width: 300px; height: 28px;" class="form-control input-h"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-12">
            <div class="form-group  col-sm-6 div-bottom-0 div-top-5">
                <div>
                    <label for="description" class="col-sm-4 control-label div-paddingRight-3"><spring:message code="remark"/></label>
                    <div class="col-sm-8 div-paddingLeft-0">
                        <textarea id="description"  rows="3" name="description" maxlength="20" style="width: 300px; height: 68px;" class="form-control"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-12">
            <div class="form-group  col-sm-6 div-bottom-0 div-top-5">
                <div>
                    <label for="description" class="col-sm-4 control-label div-paddingRight-3"><spring:message code="UploadLOGO"/></label>
                    <div class="col-sm-8" style="border: 1px solid #eee">
                        <img src="/resources/admin/images/add_mg.png" alt="" id="logos"  name="logos"  style="width: 100%; height: 100%;cursor: pointer" onclick="showInfo();"/>
                            <input type="file" name="uploadfile" id="uploadfile" style="display: none" onchange="changepic(this)" />
                        <input type="hidden" id="logo" name="logo"/>
                    </div>
                </div>
            </div>
        </div>
            <div class="form-group text-right dialog-buttons">
                <a class="btn btn-blue" href="javascript:;" onclick="createSubmit();"><spring:message code="save"/></a>
                <a class="btn btn-blue" href="javascript:;" onclick="createDialog.close();"><spring:message code="cancel"/></a>
            </div>
	</form>
</div>
<script>
    $(function () {
        var data = new Date();
        var resDay = new Date(data).format("yyyy-MM-dd");
        $("#dueDate").val(resDay);
        $("#createForm").bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                /*input状态样式图片*/
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                engAbbreviate:{
                    validators: {
                        regexp: {
                            regexp: /^[a-zA-Z_]+[a-zA-Z0-9_]*$/,
                            message: '<spring:message code="OnlyEnglishOrNumbersCanBeEnteredAndBeginInEnglish"/>'
                        },remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}
                            url: '/manage/upmsCompany/selectEngAbbreviate',//验证公司名称
                            message: '<spring:message code="abbreviationAlreadyExists"/>',//提示消息
                            delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                            type: 'POST',//请求方式
                            data: function(validator) {
                                return {
                                    id:0,
                                };
                            }
                        },
                    }
                },
                company: {
                    validators: {
                        notEmpty: {
                            message: '<spring:message code="CompanyNameCannotEmpty"/>'
                        },
                        remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}
                            url: '/manage/upmsCompany/selectComany',//验证公司名称
                            message: '<spring:message code="CompanyNameAlreadyExists"/>',//提示消息
                            delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                            type: 'POST',//请求方式
                            data: function(validator) {
                                return {
                                    id:0,
                                };
                            }
                        },
                    }
                },
                companyName: {
                    validators: {
                        notEmpty: {
                            message: '<spring:message code="CompanyAbbreviationCannotBeEmptyCompany"/>！'
                        },
                        remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}
                            url: '/manage/upmsCompany/selectComanyName',//验证公司简称
                            message: '<spring:message code="companyAbbreviationAlreadyExists"/>',//提示消息
                            delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                            type: 'POST',//请求方式
                            data: function(validator) {
                                return {
                                    id:0,
                                };
                            }
                        },
                    }
                },
            }
        });
    });
function createSubmit() {
var flag = $("#createForm").data("bootstrapValidator").validate().isValid();
    var dueDate = $("#dueDates").val();
    if(dueDate){
        dueDate =new Date(dueDate+" 23:59:59").getTime();
    }
    if(flag) {
        $.ajax({
            type: 'post',
            url: '${basePath}/manage/upmsCompany/create?dueDate='+dueDate,
            data: $('#createForm').serialize(),
            success: function(result) {
                if(result.success){
                    createDialog.close();
                    $table.bootstrapTable('refresh');
                }else{
                    $.confirm({
                        theme: 'dark',
                        animation: 'rotateX',
                        closeAnimation: 'rotateX',
                        title: false,
                        content: result.msg,
                        buttons: {
                            confirm: {
                                text: '<spring:message code="confirm"/>',
                                btnClass: 'waves-effect waves-button waves-light'
                            }
                        }
                    });
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                $.confirm({
                    theme: 'dark',
                    animation: 'rotateX',
                    closeAnimation: 'rotateX',
                    title: false,
                    content: textStatus,
                    buttons: {
                        confirm: {
                            text: '<spring:message code="confirm"/>',
                            btnClass: 'waves-effect waves-button waves-light'
                        }
                    }
                });
            }
        });
    }
}
function initLoTree() {
    $("#areaname").combotree({dataUrl:"${basePath}/manage/upmsCompany/treeData",viewName:"areaName", idname: "areaName"});
}
function showInfo() {
    $("#uploadfile").click();
}
function changepic() {
    $.ajaxFileUpload({
        url:'/manage/upmsCompany/upload?elementId=uploadfile',
        secureuri:false,
        fileElementId: "uploadfile",
        dataType: 'json',
        type:'post',
        success: function (data, status) {
            if(data.success == true){
                pxconfirm.pxalert("<spring:message code="UploadFileSuccessfully"/>");
                if(data.data!=null && data.data!=""){
                    $("#logo").val(data.data);
                    $("#logos").attr("src","/manage/upmsCompany/showImg?imgFile="+data.data);
                }
            } else{
                pxconfirm.pxalert(data.msg);
            }
        }
    });
}
</script>