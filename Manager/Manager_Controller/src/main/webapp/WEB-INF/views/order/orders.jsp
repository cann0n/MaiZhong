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
    <title>订单管理</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>订单审核</h2>
    </blockquote>
    <div class="y-role">
        <div class="search-bar">
            <!--查询区-->
            <form class="layui-form layui-form-pane">
                <div class="layui-inline">
                    <label class="layui-form-label">订单状态</label>
                    <div class="layui-input-inline">
                        <input type="text" name="status" value="" placeholder="订单状态" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">用户手机号</label>
                    <div class="layui-input-inline">
                        <input type="text" name="user_id" value="" placeholder="用户手机号" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <button class="layui-btn layui-btn-warm" lay-submit lay-filter="btnsearch">搜索</button>
                </div>
            </form>
        </div>
        <!--工具栏-->
        <div id="floatHead" class="toolbar-wrap">
            <div class="toolbar">
                <div class="box-wrap">
                    <a class="menu-btn"></a>
                    <div class="l-list">
                        <a class="layui-btn layui-btn-small do-action" data-type="doRefresh" data-href="${baseUrl}"><i
                                class="fa fa-refresh"></i>刷新</a>
                    </div>
                </div>
            </div>
        </div>
        <!--/工具栏-->
        <!--列表-->
        <div class="fhui-admin-table-container" id="list" data-href="${listUrl}">
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col width="10%">
                    <col width="10%">
                    <col width="20%">
                    <col width="5%">
                    <col width="10%">
                    <col width="10%">
                    <col width="15%">
                </colgroup>
                <thead>
                <tr>
                    <th>订单编号</th>
                    <th>用户手机号</th>
                    <th>车型名称</th>
                    <th>预估价格</th>
                    <th>预估时间</th>
                    <th>订单状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <script id="tpl" type="text/html">
                    {{#  layui.each(d.rows, function(index, item){ }}
                    <tr>
                        <td>{{ item.orderNumber }}</td>
                        <td>{{ item.userId }}</td>
                        <td>{{ item.modelName }}</td>
                        <td>{{ item.reckonPrice }}</td>
                        <td>{{ item.reckonTime }}</td>
                        <%--  <td>{{# if (item.status==0) { }}
                             未预约} #}}
                              else if (item.status==1){ }}
                              等待验收
                              {{ } else if (item.status==2){ }}
                              车辆处理
                              {{ }else if (item.status==3){ }}
                              等待过户
                              {{ }else if (item.status==4){ }}
                              过户完成
                              {{ }else if (item.status==5){ }}
                              更新指标
                              {{# }else { }}
                              已完结
                              {{# } }}
                          </td>--%>
                        <td>
                            {{# if (item.status==0) { }}
                            未预约
                            {{# } else if (item.status==1) { }}
                            等待验收
                            {{# } else if (item.status==2) { }}
                            车辆处理
                            {{# } else if (item.status==3) { }}
                            等待过户
                            {{# } else if (item.status==4) { }}
                            过户完成
                            {{# } else if (item.status==5) { }}
                            更新指标
                            {{# } else { }}
                            已完结
                            {{# }}}

                        </td>
                        <td>
                            <a class="layui-btn layui-btn-small do-action" data-type="doAddEdit"
                               data-href="${handleUrl}/{{item.id}}"><i
                                    class="icon-edit  fa fa-pencil-square-o"></i>编辑</a>
                            <a class="layui-btn layui-btn-small layui-btn-danger do-action" data-type="doDelete"
                               data-text="确定删除<span class=red>{{item.title}}</span>吗？"
                               data-href="${deleteUrl}/{{item.userId}}"><i
                                    class="icon-trash-o  fa fa-trash-o"></i>删除</a>
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