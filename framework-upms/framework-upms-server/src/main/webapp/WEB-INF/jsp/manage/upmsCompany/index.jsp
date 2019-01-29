<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>用户列表</title>
	<jsp:include page="/resources/inc/head.jsp" flush="true"/>
</head>
<body>
<div id="main">
	<div id="toolbar">
    </div>
	<table id="table"></table>
</div>
<jsp:include page="/resources/inc/footer.jsp" flush="true"/>
<script>
    var $table = $('#table');
    $(function() {
        // bootstrap table初始化
        $table.bootstrapTable({
            url: '${basePath}/manage/upmsCompany/list',
            height: getHeight(),
            striped: true,
            search: true,
            showRefresh: true,
            showColumns: true,
            minimumCountColumns: 2,
            clickToSelect: true,
            detailView: true,
            detailFormatter: 'detailFormatter',
            pagination: true,
            paginationLoop: false,
            sidePagination: 'server',
            silentSort: false,
            smartDisplay: false,
            escape: true,
            searchOnEnterKey: true,
            idField: 'userId',
            maintainSelected: true,
            toolbar: '#toolbar',
            columns: [
                {field: 'ck', checkbox: true},

                {
                    field: 'company',
                    title: '公司名称',
                    align: 'left',
                    halign: 'center',
                    valign: 'middle'
                },
                {
                    field: 'companyName',
                    title: '公司简称',
                    align: 'left',
                    halign: 'center',
                    valign: 'middle'
                },
                {
                    field: 'companyCode',
                    title: '公司编码',
                    align: 'left',
                    halign: 'center',
                    valign: 'middle'
                },
                {
                    field: 'location',
                    title: '区域',
                    align: 'left',
                    halign: 'center',
                    valign: 'middle'
                },
                {
                    field: 'phone',
                    title: '联系方式',
                    align: 'left',
                    halign: 'center',
                    valign: 'middle'
                },
                {
                    field: 'fax',
                    title: '传真',
                    align: 'center',
                    halign: 'center',
                    valign: 'middle'
                },
                {
                    field: 'website',
                    title: '公司网址',
                    align: 'left',
                    halign: 'center',
                    valign: 'middle'
                },
                {
                    field: 'address',
                    title: '公司地址',
                    align: 'left',
                    halign: 'center',
                    valign: 'middle'
                },
                {
                    field: 'description',
                    title: '备注',
                    align: 'left',
                    halign: 'center',
                    valign: 'middle'
                },

            ]
        });
    });
</script>
</body>
</html>