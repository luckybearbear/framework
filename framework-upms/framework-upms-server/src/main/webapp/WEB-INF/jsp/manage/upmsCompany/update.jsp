<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib uri="http://www.pexetech.com/jstl/tag" prefix="ptag" %>
<%@ taglib uri="http://www.pexetech.com/jstl/function" prefix="pfn" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<div id="updateDialog" class="crudDialog">
	<form id="updateForm" method="post">
		<input type="hidden" name="id" value="${upmsCompany.id}" id="companyId">
		<div class="col-sm-12">
			<div class="form-group  col-sm-6 div-bottom-0 div-top-5">
				<label for="company" class="col-sm-4 control-label div-paddingRight-3"><label style="color: red;">*</label><spring:message code="companyName"/></label>
				<div class="col-sm-8 div-paddingLeft-0">
					<input id="company"  rows="1" name="company" maxlength="20" style="width: 300px; height: 28px;" class="form-control input-h" value="${upmsCompany.company}">
				</div>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="form-group  col-sm-6 div-bottom-0 div-top-5">
				<label for="companyName"  class="col-sm-4 control-label div-paddingRight-3"><label style="color: red;">*</label><spring:message code="companyAbbreviation"/></label>
				<div class="col-sm-8 div-paddingLeft-0">
					<input id="companyName" type="text" name="companyName" class="form-control input-hei-date" maxlength="20" value="${upmsCompany.companyName}"/>
				</div>
			</div>
			<div class="form-group  col-sm-6 div-bottom-0 div-top-5">
				<label for="companyCode" class="col-sm-4 control-label div-paddingRight-3"><spring:message code="CompanyCode"/></label>
				<div class="col-sm-8 div-paddingLeft-0">
					<input id="companyCode" type="text" name="companyCode" class="form-control input-hei-date" maxlength="20" value="${upmsCompany.companyCode}"/>
				</div>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="form-group  col-sm-6 div-bottom-0 div-top-5">
				<label for="areaname" class="col-sm-4 control-label div-paddingRight-3"><spring:message code="area"/></label>
				<div class="form-group div-left-10">
					<div class=" col-sm-8 div-paddingLeft-0">
						<input id="areaname" type="text"  name="location" maxlength="20" class="form-tree-control  col-sm-10 input-hei-date" value="${upmsCompany.location}">
					</div>
				</div>
			</div>
			<div class="form-group  col-sm-6 div-bottom-0 div-top-5">
				<label for="type" class="col-sm-4 control-label div-paddingRight-3"><spring:message code="type"/></label>
				<div class="col-sm-8 div-paddingLeft-0">
					<input id="type" type="text" name="type"  class="form-control input-hei-date" maxlength="20" value="${upmsCompany.type}"/>
				</div>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="form-group  col-sm-6 div-bottom-0 div-top-5">
				<label for="phone" class="col-sm-4 control-label div-paddingRight-3"><spring:message code="phone"/></label>
				<div class="col-sm-8 div-paddingLeft-0">
					<input id="phone" type="text" name="phone" class="form-control input-hei-date" maxlength="20" value="${upmsCompany.phone}"/>
				</div>
			</div>
			<div class="form-group  col-sm-6 div-bottom-0 div-top-5">
				<label for="fax" class="col-sm-4 control-label div-paddingRight-3"><spring:message code="fax"/></label>
				<div class="col-sm-8 div-paddingLeft-0">
					<input id="fax" type="text" name="fax" class="form-control input-hei-date" maxlength="20" value="${upmsCompany.fax}"/>
				</div>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="form-group  col-sm-6 div-bottom-0 div-top-5">
				<label for="phone" class="col-sm-4 control-label div-paddingRight-3"><spring:message code="EnglishAbbreviations"/></label>
				<div class="col-sm-8 div-paddingLeft-0">
					<input id="engAbbreviate" type="text" name="engAbbreviate" class="form-control input-hei-date" maxlength="20" value="${upmsCompany.engAbbreviate}"/>
				</div>
			</div>
			<div class="form-group  col-sm-6 div-bottom-0 div-top-5">
				<label for="rate" class="col-sm-4 control-label div-paddingRight-3"><spring:message code="tax"/></label>
				<div class="col-sm-8 div-paddingLeft-0">
					<input id="rate" type="number" name="rate" step="0.01" class="form-control input-hei-date" maxlength="20" value="${upmsCompany.rate}" />
				</div>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="form-group  col-sm-6 div-bottom-0 div-top-5">
				<label for="dueDates" class="col-sm-4 control-label div-paddingRight-3"><spring:message code="dueDate"/></label>
				<div class="col-sm-8 div-paddingLeft-0">
					<input id="dueDates" type="text" name="dueDates" class="form-control input-hei-date Wdate"  style="height: 28px" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
						   value="<ptag:date value="${upmsCompany.dueDate}" pattern="yyyy-MM-dd"/>"
                            <c:if test="${upmsUser.companyId!=1}">
                                disabled
                            </c:if>
					/>
				</div>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="form-group  col-sm-6 div-bottom-0 div-top-5">
				<label for="website" class="col-sm-4 control-label div-paddingRight-3" ><spring:message code="url"/></label>
				<div class="col-sm-8 div-paddingLeft-0">
					<input id="website"  rows="1" name="website" maxlength="20" style="width: 300px; height: 28px;" class="form-control input-h" value="${upmsCompany.website}">
				</div>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="form-group  col-sm-6 div-bottom-0 div-top-5">
				<div>
					<label for="address" class="col-sm-4 control-label div-paddingRight-3"><spring:message code="location"/></label>
					<div class="col-sm-8 div-paddingLeft-0">
						<input id="address"  rows="1" name="address" maxlength="200" style="width: 300px; height: 28px;" class="form-control input-h" value="${upmsCompany.address}">
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="form-group  col-sm-6 div-bottom-0 div-top-5">
				<div>
					<label for="description" class="col-sm-4 control-label div-paddingRight-3"><spring:message code="remark"/></label>
					<div class="col-sm-8 div-paddingLeft-0">
						<textarea id="description"  rows="3" name="description" maxlength="20" style="width: 300px; height: 68px;" class="form-control">${upmsCompany.description}</textarea>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="form-group  col-sm-6 div-bottom-0 div-top-5">
				<div>
					<label for="description" class="col-sm-4 control-label div-paddingRight-3"><spring:message code="UploadLOGO"/></label>
					<div class="col-sm-8" style="border: 1px solid #eee">
						<c:if test="${upmsCompany.logo==null}">
							<img src="/resources/admin/images/add_mg.png" alt="" id="logos"  name="logos"  style="width: 100%; height: 100%;cursor: pointer" onclick="showInfo();"/>
						</c:if>
						<c:if test="${upmsCompany.logo!=null}">
							<img src="/manage/upmsCompany/showImg?imgFile=${upmsCompany.logo}" alt="" id="logos"  name="logos"  style="width: 100%; height: 100%;cursor: pointer" onclick="showInfo();"/>
						</c:if>
						<input type="file" name="uploadfile" id="uploadfile" style="display: none" onchange="changepic(this)" />
						<input type="hidden" id="logo" name="logo" value="${upmsCompany.logo}"/>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-12 div-top-5">
		<a class="btn btn-default button-hei" href="javascript:;" onclick="addCompanyConfig();" style="margin-left: 90px"><spring:message code="ParameterConfiguration"/></a>
		</div>
		<div class="form-group text-right dialog-buttons">
			<a class="btn btn-blue" href="javascript:;" onclick="createSubmit();"><spring:message code="save"/></a>
			<a class="btn btn-blue" href="javascript:;" onclick="updateDialog.close();"><spring:message code="cancel"/></a>
		</div>
	</form>
</div>
<script>
	$(function(){
		$("#updateForm").bootstrapValidator({
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
									id:${upmsCompany.id},
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
									id:${upmsCompany.id},
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
									id:${upmsCompany.id},
								};
							}
						},
					}
				},
			}
		});
		$("#updateForm").data("bootstrapValidator").validateField("company");
		$("#updateForm").data("bootstrapValidator").validateField("companyName");
		$("#updateForm").data("bootstrapValidator").validateField("engAbbreviate");
	});
function createSubmit() {
	var flag = $("#updateForm").data("bootstrapValidator").validate().isValid();
    var dueDate = $("#dueDates").val();
    if(dueDate){
        dueDate =new Date(dueDate+" 23:59:59").getTime();
    }
	if(flag) {
		$.ajax({
			type: 'post',
			url: '${basePath}/manage/upmsCompany/update?dueDate='+dueDate,
			data: $('#updateForm').serialize(),
			beforeSend: function() {
				if ($('#title').val() == '') {
					$('#title').focus();
					return false;
				}
				if ($('#name').val() == '') {
					$('#name').focus();
					return false;
				}
			},
			success: function(result) {
				if(result.success){
					updateDialog.close();
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
function addCompanyConfig() {
	this.companyConfig = createObj(CompanyConfig);
	this.companyConfig.open();
}
(function (win, $) {
	var companyConfigDialog;
	var companyConfig = createObj(baseEdit, {
		open: function () {
			var config = this;
			companyConfigDialog = pxconfirm.dialog('<spring:message code="ParameterConfiguration"/>', 'col-md-7 col-md-offset-2', 'url:${basePath}/manage/upmsCompanyConfig/detail/' + $("#companyId").val(), "",
					[{
						'<spring:message code="save"/>': function () {
							config.createSubmit();
							return false;
						}
					}]);
		},
		createSubmit: function () {
			var config = this;
			$.ajax({
				type: 'post',
				url: '${basePath}/manage/upmsCompanyConfig/update',
				data: $('#configForm').serialize(),
				dataType:'json',
				success: function (result) {
					if (result.success) {
						companyConfigDialog.close();
						pxconfirm.pxalert(result.msg, pxconfirm.alert.TYPE.SUCCESS);
					} else {
						pxconfirm.pxalert(result.msg, pxconfirm.alert.TYPE.WARNING);
					}
				},
				error: function (XMLHttpRequest, textStatus, errorThrown) {
					pxconfirm.pxalert(textStatus, pxconfirm.alert.TYPE.ERROR);
				}
			});
		},
	});
	win.CompanyConfig = companyConfig;
})(window, jQuery);

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