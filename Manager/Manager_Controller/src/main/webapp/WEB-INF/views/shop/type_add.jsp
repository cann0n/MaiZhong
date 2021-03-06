<%--
  Created by IntelliJ IDEA.
  User: Wang
  Date: 2017/3/6 0006
  Time: 上午 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>类别添加</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap" data-href="${baseUrl}">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>类别添加</h2>
    </blockquote>
    <blockquote class="layui-elem-quote fhuaui-tip">
        <p><i class="fa fa-info-circle" aria-hidden="true"></i>类别默认显示顺序为999</p>
    </blockquote>
    <div class="site-text site-block">
        <form class="layui-form layui-form-pane">
            <div class="layui-form-item">
                <label class="layui-form-label">类别名称</label>
                <div class="layui-input-block">
                    <input name="typeName" autocomplete="off" lay-verify="required" maxlength="20"
                           placeholder="汽车类别名称" class="layui-input" type="text">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">类别顺序</label>
                <div class="layui-input-block">
                    <input name="typeSequence" autocomplete="off" lay-verify="number" maxlength="5"
                           placeholder="类别顺序" class="layui-input" type="text">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">是否启用</label>
                <div class="layui-input-block">
                    <input type="radio" name="status" value="1" title="启用"  <c:if test="${type==null||type.status==1}">checked="checked"</c:if> >
                    <input type="radio" name="status" value="0" title="停用"  <c:if test="${type.status==0}">checked="checked"</c:if>>
                </div>
            </div>

            <div class="layui-form-item" >
                <label class="layui-form-label" >示例图片</label>
                <div class="layui-input-block">
                    <div class="site-upload normal" style="height: 50px;width: 150px;" >
                        <img id="imgShow" src="/resources/images/logo_s.png" style="width: 150px;height: 50px;">
                        <input type="hidden" name="typeImg" id="typeImg" value=""/>
                        <div class="site-upbar">
                            <input type="file" name="advert" class="layui-upload-file" lay-ext="jpg|png|gif">
                        </div>
                        <span class="loading"></span>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="btnsubmit" data-href="${saveUrl}">添加类别</button>
                </div>
            </div>
        </form>
    </div>
    <script type="text/javascript" src="/resources/js/event.js"></script>
    <script type="text/javascript">
        layui.use(['form', 'upload', 'app'], function () {
            var $ = layui.jquery,
                    form = layui.form(),
                    app = layui.app;
                    app.fixBar();

            /**
             * 绑定上传事件
             */
            layui.upload({
              //url: '${uploadUrl}',
              url: '/type/advert/upload',
                before: function (input) {
                    $(".loading").show();
                },
                success: function (res) {
                    $(".loading").hide();
                    if (res.status == 200) {
                        app.layerAlertS(res.message);
                        document.getElementById("imgShow").src = res.data;
                        $("#typeImg").val(res.data);
                    } else {
                        app.layerAlertE(res.message);
                    }
                }
            });
            

            form.on("submit(btnsubmit)", function (formdata) {
                var logo = $("#typeImg").val();
                if (logo == "") {
                    app.layerMessageE("请上传类别示例！");
                } else {
                    formdata.field.typeImg = logo;
                    var url = $(formdata.elem).data("href");
                    app.ajaxPost(url, formdata.field, function (e, r) {
                        if (e) {
                            app.layerAlertE(e);
                        } else {
                            app.layerAlertS(r.message);
                            app.time(function () {
                                app.route("${baseUrl}");
                            });
                        }
                    });
                }
                return false;
            });
        });
    </script>
</div>
</body>
</html>
