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
	<title>权限管理系统</title>

	<link href="${basePath}/resources/framework-admin/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="${basePath}/resources/framework-admin/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" rel="stylesheet"/>
	<link href="${basePath}/resources/framework-admin/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
	<link href="${basePath}/resources/framework-admin/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css" rel="stylesheet"/>
	<link href="${basePath}/resources/framework-admin/css/admin.css" rel="stylesheet"/>
	<style>
		/** skins **/
		/**














<c:forEach var="upmsSystem" items="${upmsSystems}">               **/
		/** #














${upmsSystem.name}













                                                                                                                  #heade {background:














        ${upmsSystem.theme}               ;}**/
		/** #














${upmsSystem.name}













                                                                                                                  .content_ta{background:














        ${upmsSystem.theme}               ;}**/
		/** #














${upmsSystem.name}













                                                                                                                  .s-profile>a{background: url(














        ${basePath}${upmsSystem.banner}               ) left top no-repeat;}**/
		/**














</c:forEach>               **/

		.over {
			overflow: hidden;
			text-overflow: ellipsis;
			white-space: nowrap;
		}
	</style>
</head>
<body>
<header id="header">
	<ul id="menu">
		<li id="guide" class="line-trigger">
			<div class="line-wrap">
				<div class="line top"></div>
				<div class="line center"></div>
				<div class="line bottom"></div>
			</div>
		</li>
		<li id="logo" class="hidden-xs">
			<a href="${basePath}/manage/index">
				<%--<img src="${basePath}/resources/framework-admin/images/logo.png"/>--%>
			</a>
			<span id="system_title">权限管理系统</span>
		</li>

		<li class="pull-right">
			<ul class="hi-menu">
				<li  style="color: white">
					${upmsUser.realname}，您好！
				</li>
				<!-- 搜索 -->
				<li class="dropdown">
					<a class="waves-effect waves-light" data-toggle="dropdown" href="javascript:;">
						<i class="him-icon zmdi zmdi-search"></i>
					</a>
					<ul class="dropdown-menu dm-icon pull-right">
						<form id="search-form" class="form-inline">
							<div class="input-group">
								<input id="keywords" type="text" name="keywords" class="form-control" placeholder="搜索"/>
								<div class="input-group-btn">
									<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
								</div>
							</div>
						</form>
					</ul>
				</li>
				<li class="dropdown">
					<a class="waves-effect waves-light" data-toggle="dropdown" href="javascript:;">
						<i class="him-icon zmdi zmdi-dropbox"></i>
					</a>
					<ul class="dropdown-menu dm-icon pull-right">
						<li class="skin-switch hidden-xs">
							请选择系统切换
						</li>
						<li class="divider hidden-xs"></li>
						<c:forEach var="upmsSystem" items="${upmsSystems}">
						<li>
							<a class="waves-effect switch-systems" href="javascript:;" systemid="${upmsSystem.systemId}" systemname="${upmsSystem.name}" systemtitle="${upmsSystem.title}"><i class="${upmsSystem.icon}"></i> ${upmsSystem.title}</a>
						</li>
						</c:forEach>
					</ul>
				</li>

				<li class="dropdown">
					<a class="waves-effect waves-light" data-toggle="dropdown" href="javascript:;">
						<i class="him-icon zmdi zmdi-more-vert"></i>
					</a>
					<ul class="dropdown-menu dm-icon pull-right">
						<li class="hidden-xs">
							<a class="waves-effect" data-ma-action="fullscreen" href="javascript:fullPage();"><i class="zmdi zmdi-fullscreen"></i> 全屏模式</a>
						</li>
						<li>
							<a class="waves-effect" data-ma-action="clear-localstorage" href="javascript:;"><i class="zmdi zmdi-delete"></i> 清除缓存</a>
						</li>
						<li>
							<a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-face"></i> 隐私管理</a>
						</li>
						<li>
							<a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-settings"></i> 系统设置</a>
						</li>
						<li>
							<a class="waves-effect" href="${basePath}/sso/logout"><i class="zmdi zmdi-run"></i> 退出登录</a>
						</li>
					</ul>
				</li>
			</ul>
		</li>
	</ul>
</header>
<section id="main">
	<!-- 左侧导航区 -->
	<aside id="sidebar">
		<!-- 资料区 -->
		<div class="s-profile">
			<a class="waves-effect waves-light" href="javascript:;">
				<div class="sp-pic">
					<img src="${basePath}${upmsUser.avatar}"/>
				</div>
			</a>
		</div>
		<!-- /个人资料区 -->
		<!-- 菜单区 -->
		<ul class="main-menu">
			<c:forEach var="upmsPermission" items="${upmsPermissions}" varStatus="status">
				<c:if test="${upmsPermission.pid == 0}">
				<li class="sub-menu system_menus system_${upmsPermission.systemId} ${status.index}" <c:if test="${upmsPermission.systemId != 1}">style="display:none;"</c:if>>
					<a class="waves-effect" href="javascript:;"><i class="${upmsPermission.icon}"></i> ${upmsPermission.name}</a>
					<ul>
						<c:forEach var="subUpmsPermission" items="${upmsPermissions}">
							<c:if test="${subUpmsPermission.pid == upmsPermission.permissionId}">
								<c:forEach var="upmsSystem" items="${upmsSystems}">
									<c:if test="${subUpmsPermission.systemId == upmsSystem.systemId}">
									<c:set var="systemBasePath" value="${upmsSystem.basepath}"/></c:if>
								</c:forEach>
								<li><a class="waves-effect" href="javascript:Tab.addTab('${subUpmsPermission.name}', '${systemBasePath}${subUpmsPermission.uri}');">${subUpmsPermission.name}</a></li>
							</c:if>
						</c:forEach>
					</ul>
				</li>
				</c:if>
			</c:forEach>
			<li>
				<div class="upms-version">&copy; FRAMEWORK-UPMS V1.0.0</div>
			</li>
		</ul>
		<!-- /菜单区 -->
	</aside>
	<!-- /左侧导航区 -->
	<section id="content">
		<div class="content_tab">
			<div class="tab_left">
				<a class="waves-effect waves-light" href="javascript:;"><i class="zmdi zmdi-chevron-left"></i></a>
			</div>
			<div class="tab_right">
				<a class="waves-effect waves-light" href="javascript:;"><i class="zmdi zmdi-chevron-right"></i></a>
			</div>
			<ul id="tabs" class="tabs">
				<li id="tab_home" data-index="home" data-closeable="false" class="cur">
					<a class="waves-effect waves-light" href="javascript:;">首页</a>
				</li>
			</ul>
		</div>
		<div class="content_main">
            <div id="iframe_home" class="iframe cur">
                <style>
                    .mod-app-item {
                        overflow: hidden;
                        padding: 0px;
                    }
                    .mod-app-item li {
                        width: 112px;
                        padding: 0 17px 5px 23px;
                        float: left;
                        height: 119px;
                        _height: 129px;
                        margin: 21px 0 0;
                        text-align: center;
                        display: inline;
                    }
                    .functions li{
                        border-bottom: 1px dashed #b7b7b7;
                    }
                    .mod-app-item li:hover .app-name a,.mod-app-item .hover .app-name a {
                        color: #8f3900
                    }

                    #iframe_home .app-img .shadow {
                        width: 30px;
                        height: 30px;
                        margin: -32px 0 0;
                        margin-top: -31px\9;
                        *margin-top: -34px;
                        background: url(../images/icon_mask_30.png) no-repeat;
                        position: relative;
                        z-index: 999
                    }

                    .mod-app-item .app-name {
                        margin: 7px 0 6px;
                        height: 20px;
                        overflow: hidden
                    }

                    .mod-app-item .app-name a {
                        line-height: 1.3;
                        font-size: 12px
                    }
                </style>
                <div style="border: 1px solid #e4e4e4;padding: 12px 15px 0;">
                <h1 style="font-size:14px;border-bottom: 1px solid #e0e0e0;line-height: 1.2;margin: 0px;height: 25px;">功能模块</h1>
                <ul class="mod-app-item daily-pick-ul">
                    <li>
                        <div class="app-img">
                            <a href="javascript:void(0)" class="switch-systems" systemid="1" systemname="activiti-web" systemtitle="权限管理">
                                <img src="${basePath}/resources/framework-admin/images/zheng-upms.png" width="72" height="72">
                            </a>
                        </div>
                        <p class="app-name"><a href="javascript:void(0)" class="switch-systems" systemid="1" systemname="activiti-web" systemtitle="权限管理">权限管理</a></p>
                    </li>
                    <li>
                        <div class="app-img">
                            <a href="javascript:void(0)" class="switch-systems" systemid="2" systemname="activiti-web" systemtitle="内容管理">
                                <img src="${basePath}/resources/framework-admin/images/zheng-cms.png" width="72" height="72">
                            </a>
                        </div>
                        <p class="app-name"><a href="javascript:void(0)" class="switch-systems" systemid="2" systemname="activiti-web" systemtitle="内容管理">内容管理</a></p>
                    </li>
                    <li>
                        <div class="app-img">
                            <a href="javascript:void(0)" class="switch-systems" systemid="3" systemname="activiti-web" systemtitle="支付系统">
                                <img src="${basePath}/resources/framework-admin/images/zheng-pay.png" width="72" height="72">
                            </a>
                        </div>
                        <p class="app-name"><a href="javascript:void(0)" class="switch-systems" systemid="3" systemname="activiti-web" systemtitle="支付系统">支付系统</a></p>
                    </li>
                    <li>
                        <div class="app-img">
                            <a href="javascript:void(0)" class="switch-systems" systemid="4" systemname="activiti-web" systemtitle="用户管理系统">
                                <img src="${basePath}/resources/framework-admin/images/zheng-ucenter.png" width="72" height="72">
                            </a>
                        </div>
                        <p class="app-name"><a href="javascript:void(0)" class="switch-systems" systemid="4" systemname="activiti-web" systemtitle="用户管理系统">用户管理系统</a></p>
                    </li>

                </ul>
            </div>
            </div>
		</div>
	</section>
</section>
<footer id="footer"></footer>
<script>var BASE_PATH = '${basePath}';</script>
<script src="${basePath}/resources/framework-admin/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/resources/framework-admin/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${basePath}/resources/framework-admin/plugins/waves-0.7.5/waves.min.js"></script>
<script src="${basePath}/resources/framework-admin/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="${basePath}/resources/framework-admin/plugins/BootstrapMenu.min.js"></script>
<script src="${basePath}/resources/framework-admin/plugins/device.min.js"></script>
<script src="${basePath}/resources/framework-admin/plugins/jquery.cookie.js"></script>
<script src="${basePath}/resources/framework-admin/js/admin.js"></script>
<script src="${basePath}/resources/framework-admin/plugins/fullPage/jquery.fullPage.min.js"></script>
<script src="${basePath}/resources/framework-admin/plugins/fullPage/jquery.jdirk.min.js"></script>
</body>
</html>