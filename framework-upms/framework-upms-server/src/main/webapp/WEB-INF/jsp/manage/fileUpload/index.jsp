<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>文件上传</title>
    <jsp:include page="/resources/inc/head.jsp" flush="true"/>
    <jsp:include page="/resources/inc/footer.jsp" flush="true"/>

<style>
    .line_01{
        padding: 0 20px 0;
        margin: 20px 0;
        line-height: 1px;
        border-left: 200px solid #ddd;
        border-right: 200px solid #ddd;
        text-align: center;}

    .line_02{
        height: 1px;
        border-top: 1px solid #ddd;
        text-align: center;
    }
    .line_02 span {
        position: relative;
        top: -8px;
        background: #fff;
        padding: 0 20px;
    }

    .line_03{
        width:600px;
    }
    .line_03 b{
        background: #ddd;
        margin-top: 4px;
        display: inline-block;
        width: 180px;
        height: 1px;
        _overflow: hidden;
        vertical-align: middle;
    }
    .line_03 span {
        display: inline-block;
        width: 220px;
        vertical-align: middle;
    }

</style>
</head>
<body>
<div class="container">
    <div class="line_01">选项卡[小小分隔线 单标签实现]</div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                选项卡
            </h3>
            <div class="tabbable" id="tabs-641472">
                <ul class="nav nav-tabs">
                    <li>
                        <a href="#panel-1" data-toggle="tab">采用流的方式上传文件</a>
                    </li>
                    <li class="active">
                        <a href="#panel-2" data-toggle="tab">采用multipart提供的file.transfer方法上传文件1</a>
                    </li>
                    <li>
                        <a href="#panel-3" data-toggle="tab">采用multipart提供的file.transfer方法上传文件2</a>
                    </li>
                    <li>
                        <a href="#panel-4" data-toggle="tab">使用spring MVC提供的方法上传文件</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane" id="panel-1">
                        <form name="form1" action="${basePath}/manage/fileUpload/upload_01" method="post" enctype="multipart/form-data">
                            <input type="file" name="file_01"/>
                            <button type="submit" class="btn btn-success btn-sm" >采用流的方式上传文件</button>
                        </form>
                    </div>
                    <div class="tab-pane active" id="panel-2">
                        <form name="form2" action="${basePath}/manage/fileUpload/upload_02" method="post" enctype="multipart/form-data">
                            <input type="file" name="file_02"/>
                            <button type="submit" class="btn btn-success btn-sm" > 采用multipart提供的file.transfer方法上传文件1</button>
                        </form>
                    </div>
                    <div class="tab-pane" id="panel-3">
                        <form name="form3" action="${basePath}/manage/fileUpload/upload_03" method="post" enctype="multipart/form-data">
                            <input type="file" name="file_03"/>
                            <button type="submit" class="btn btn-success btn-sm">采用multipart提供的file.transfer方法上传文件2</button>
                        </form>
                    </div>
                    <div class="tab-pane" id="panel-4">
                        <form name="form4" action="${basePath}/manage/fileUpload/upload_spring" method="post" enctype="multipart/form-data">
                            <input type="file" name="file_04"/>
                            <button type="submit" class="btn btn-success btn-sm">使用spring MVC提供的方法上传文件</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br/>

    <div class="line_02"><span>btn[小小分隔线 巧用色实现]</span></div>
    <br/>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-4 column">
                    <button type="button" class="btn btn-default btn-info">按钮</button>
                </div>
                <div class="col-md-4 column">
                    <button type="button" class="btn btn-default btn-success">按钮</button>
                </div>
                <div class="col-md-4 column">
                    <button type="button" class="btn btn-default btn-danger">按钮</button>
                </div>
            </div>
        </div>
    </div>
    <br/>

    <div class="line_03"><b></b><span>dialog[小小分隔线 inline-block实现]</span><b></b></div>
    <br/>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                dialog
            </h3>
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <button type="button" class="btn btn-default btn-block btn-info" onclick="openDialog()">openDialog</button>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
<script>
    function openDialog(){
        pxconfirm.dialog("boootstrap-fileInput",'col-md-12','url:${basePath}/manage/fileUpload/openDialog',function(){
        })
    };

</script>

</html>
