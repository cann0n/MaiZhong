<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/3/1 0023
  Time: 上午 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品管理</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>商品管理</h2>
    </blockquote>
    <div class="y-role">
        <div class="search-bar">
            <!--查询区-->
            <form class="layui-form layui-form-pane">
                <div class="layui-form-item">
                    <label class="layui-form-label" style="width: 10%">搜索</label>
                    <div class="layui-input-inline" style="width: 50%">
                        <input type="text" name="queryString" value="" placeholder="请输入关键字" class="layui-input">
                    </div>


                    <%--<div class="layui-form-item">--%>
                    <label class="layui-form-label">品牌</label>
                    <div class="layui-input-inline">
                        <select name="carBrand" lay-filter="aihao">
                            <option value="">宝马</option>
                            <option value="0">奥迪</option>
                            <option value="1" selected="">大众</option>
                        </select>
                    </div>
                    <%--</div>--%>


                    <%--<div class="layui-form-item">--%>
                    <label class="layui-form-label">车型</label>
                    <div class="layui-input-inline">
                        <select name="carType" id="carType"  lay-filter="carType">
                            <option value="">小型车</option>
                            <option value="0">中型车</option>
                            <option value="1" selected="">suv</option>
                        </select>
                    </div>


                </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label" >时间</label>
                        <div class="layui-input-inline">
                            <input class="layui-input" name="timeBegin" placeholder="开始日" lay-filter="LAY_TIME_S">
                        </div>
                        <div class="layui-input-inline">
                            <input class="layui-input" name="timeEnd" placeholder="截止日" lay-filter="LAY_TIME_E">
                        </div>
                    <%--</div>--%>

                        <label class="layui-form-label">价格范围</label>
                        <div class="layui-input-inline" style="width: 100px;">
                            <input type="text" name="priceMin" placeholder="￥" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-form-mid">-</div>
                        <div class="layui-input-inline" style="width: 100px;">
                            <input type="text" name="priceMax" placeholder="￥" autocomplete="off" class="layui-input">
                        </div>




                        <div class="layui-inline">
                            <button class="layui-btn layui-btn-warm" lay-submit  lay-filter="btnsearch">搜索</button>
                        </div>
                    </div>




            </form>
        </div>
        <!--工具栏-->
        <div id="floatHead" class="toolbar-wrap">
            <div class="toolbar">
                <div class="box-wrap">
                    <a class="menu-btn"></a>
                    <div class="l-list">
                        <a class="layui-btn layui-btn-small do-action" data-type="doAddEdit" data-href="${carAddUrl}"><i class="fa fa-plus"></i>新增</a>
                        <a class="layui-btn layui-btn-small do-action" data-type="doRefresh" data-href="${baseUrl}"><i class="fa fa-refresh"></i>刷新</a>
                    </div>
                </div>
            </div>
        </div>
        <!--/工具栏-->
        <!--列表-->
        <div class="fhui-admin-table-container"  id="list" data-href = "${carListUrl}">
            <table class="layui-table" lay-skin="line">
                <thead>
                <tr>
                    <th>
                        <font color="aqua">
                            <a href="javascript:;" ></a>
                        </font>
                        <%--<button class="layui-btn layui-btn-mini" >上一页</button>--%>
                    </th>
                    <%--车型主键',--%>
                    <%--'汽车编号 ',--%>
                    <th>编号</th>
                    <%--'车型名称 类似奥迪a4',--%>
                    <th>车型</th>
                    <%--'外键链接车辆品牌  类似奥迪',--%>
                    <th>品牌</th>
                    <%--'外键  链接车辆类型',--%>
                    <th>类型</th>
                    <%--年款式 类似 奥迪a42016款',--%>
                    <th>年款</th>
                    <%--'车辆颜色  外联数据字典表',--%>
                    <th>颜色</th>
                    <%--'汽车排量 1.7L',--%>
                    <th>排量</th>
                    <th>变速箱类型</th>
                    <%--'变速箱类型 外联数据字典表 ',--%>
                    <th>别名</th>
                    <%--MMENT '车辆别名  用于搜索',--%>
                    <th>卖点</th>
                    <%--MMENT '车辆卖点 用于搜索',--%>
                    <th>订金</th>
                    <%--LL COMMENT '订金价格',--%>
                    <th>售价</th>
                    <%--ULL COMMENT '售价',--%>
                    <th>厂家指导价</th>
                    <%--MMENT '厂家指导价  字符串存储的一个价格区间',--%>
                    <th>修改时间</th>
                    <%--ENT '添加时间',--%>
                    <%--ENT '修改时间',--%>
                    <th>图片</th>
                    <%--MMENT '商品图片，多张图片中间用符号分割',--%>
                    <th>是否可用</th>
                    <%--COMMENT '是否可用 用于搜索时是否展示',--%>
                    <th>详情</th>
                    <%--'商品详情的存储字段',--%>
                    <th>权重</th>
                    <%--' COMMENT '权重',--%>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <script id="tpl" type="text/html">
                    {{#  layui.each(d.rows, function(index, item){ }}
                    <tr>
                        <td><input type="checkbox" name="selectNum" value="{{ item.id }}"></td>
                    <%--车型主键',--%>
                        <%--<td>{{ item.id }}</td>--%>
                    <%--'汽车编号 ',--%>
                        <td>{{ item.number }}</td>
                    <%--'车型名称 类似奥迪a4',--%>
                        <td>{{ item.name }}</td>
                    <%--'外键链接车辆品牌  类似奥迪',--%>
                        <td>{{ item.carBrand }}</td><%--此字段需要遍历--%>
                    <%--'外键  链接车辆类型',--%>
                        <td>{{ item.carType }}</td>
                    <%--年款式 类似 奥迪a42016款',--%>
                        <td>{{ item.yearSku }}</td>
                    <%--'车辆颜色  外联数据字典表',--%>
                        <td>{{ item.color }}</td>
                    <%--'汽车排量 1.7L',--%>
                        <td>{{ item.capacity }}</td>
                    <%--'变速箱类型 外联数据字典表 ',--%>
                        <td>{{ item.gearbox }}</td>
                    <%--MMENT '车辆别名  用于搜索',--%>
                        <td>{{ item.asname }}</td>
                    <%--MMENT '车辆卖点 用于搜索',--%>
                        <td>{{ item.sellpoint }}</td>
                    <%--LL COMMENT '订金价格',--%>
                        <td>{{ item.reservePrice }}</td>
                    <%--ULL COMMENT '售价',--%>
                        <td>{{ item.sellPrice }}</td>
                    <%--MMENT '厂家指导价  字符串存储的一个价格区间',--%>
                        <td>{{ item.shopPrice }}</td>
                    <%--ENT '添加时间',--%>
                    <%--ENT '修改时间',--%>
                        <td>{{ item.updateTime }}</td>
                    <%--MMENT '商品图片，多张图片中间用符号分割',--%>
                        <td>{{ item.image }}</td>
                    <%--COMMENT '是否可用 用于搜索时是否展示',--%>
                        <%--<td>{{ item.unable }}</td>--%>
                        <td align="center">{{# if (item.unable==1) { }}
                            <i class="fa fa-toggle-on unlock"></i>
                            {{# } else { }}
                            <i class="fa fa-toggle-off islock"></i>
                            {{# } }}
                        </td>
                        <td><a href="javascript:;" onclick="seeDesc('{{ item.id }}','{{ item.name}}')">查看详情</a></td>
                    <%--'商品详情的存储字段',--%>
                        <td>{{ item.weight }}</td>
                    <%--' COMMENT '权重',--%>
                        <td>
                            <a class="layui-btn layui-btn-small do-action" data-type="doAddEdit" data-href="${handleUrl}/{{item.id}}"><i class="icon-edit  fa fa-pencil-square-o"></i>编辑</a>
                            <a class="layui-btn layui-btn-small layui-btn-danger do-action" data-type="doDelete" data-text="确定删除<span class=red>{{item.menuName}}</span>吗？" data-href="${deleteUrl}/{{item.id}}"><i class="icon-trash-o  fa fa-trash-o"></i>删除</a>
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
    <script src="/resources/js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        layui.use("pagelist",function(){
            var pagelist = layui.pagelist;
            pagelist.basePagingInit(10);
            pagelist.logTimeInit();

        });

        function seeDesc(id,name){
            $.post("/car/seeDesc",{"id":id},function (data){
                var title = "";
                var content = data.message;
                if(data.status==200){
                    title = name+"详情";
                }else{
                    title = "出错啦";
                }
                layer.open({
                    title: title,
                    content:content
                });
            },"text");
        }
    </script>
</div>
</body>
</html>
