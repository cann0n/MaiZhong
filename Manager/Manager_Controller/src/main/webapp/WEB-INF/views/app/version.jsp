<%--
  Created by IntelliJ IDEA.
  User: Wang
  Date: 2017/3/7 0030
  Time: 下午 7:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>APP版本</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>APP版本</h2>
    </blockquote>
    <div class="y-role">
        <!--工具栏-->
        <div id="floatHead" class="toolbar-wrap">
            <div class="toolbar">
                <div class="box-wrap">
                    <a class="menu-btn"></a>
                    <div class="l-list">
                        <a class="layui-btn layui-btn-small do-action" data-type="doAddEdit"
                           data-href="${handleUrl}/new"><i class="fa fa-plus"></i>新增版本</a>
                        <a class="layui-btn layui-btn-small do-action" data-type="doRefresh" data-href="${baseUrl}"><i
                                class="fa fa-refresh"></i>刷新</a>
                        <a class="layui-btn layui-btn-small layui-btn-warm do-action" data-type="doAjax"
                           data-href="/version/updateVersionRedis"><i class="fa fa-exchange"></i>同步缓存</a>
                    </div>
                </div>
            </div>
        </div>
        <!--/工具栏-->
        <!--列表-->
        <div class="fhui-admin-table-container" id="list" data-href="${listUrl}">
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col width="5%">
                    <col width="30%">
                    <col width="30%">
                    <col width="15%">
                </colgroup>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>版本名称</th>
                    <th>更新日期</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <script id="tpl" type="text/html">
                    {{#  layui.each(d.rows, function(index, item){ }}
                    <tr>
                        <td>{{ item.id }}</td>
                        <td>{{ item.versionNumber }}</td>
                        <td>{{ item.updateTime }}</td>
                        <td>
                            <a class="layui-btn layui-btn-small do-action" data-type="doAddEdit"
                               data-href="${handleUrl}/{{item.id}}"><i
                                    class="icon-edit  fa fa-pencil-square-o"></i>编辑</a>
                            <a class="layui-btn layui-btn-small layui-btn-danger do-action" data-type="doDelete"
                               data-text="确定删除<span class=red>{{item.versionNumber}}</span>吗？"
                               data-href="${deleteUrl}/{{item.id}}"><i class="icon-trash-o  fa fa-trash-o"></i>删除</a>
                        </td>
                    </tr>
                    {{#  }); }}
                </script>
                </tbody>
            </table>
        </div>
        <!--列表-->
        <!--分页 -->
        <div class="fhui-admin-pagelist">
            <div id="page"></div>
        </div>
        <!--分页 -->
    </div>
    <script type="text/javascript" src="/resources/js/event.js"></script>
    <script type="text/javascript">
        layui.use("pagelist", function () {
            layui.pagelist.basePagingInit(8);
        });
    </script>
</div>
</body>
</html>
