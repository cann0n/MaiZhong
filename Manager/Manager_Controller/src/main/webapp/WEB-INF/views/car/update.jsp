<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<head>
    <jsp:include page="../common/head.jsp"/>
    <title>车辆添加</title>
    <!-- 引入kindEditor插件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/kindeditor-4.1.10/themes/default/default.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/kindeditor-4.1.10/kindeditor-all-min.js" charset="utf-8"></script>
    <script src="/resources/js/jquery.min.js" type="text/javascript"></script>
</head>
<body>
<div  class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>
            <a class="layui-btn layui-btn-small do-action" id="returnList" data-type="doAddEdit" data-href="/car/list"><i class="layui-icon">&#xe603;</i> 返回</a>
            汽车属性修改
        </h2>
    </blockquote>
    <div class="y-role">
        <fieldset class="layui-elem-field">
            <legend>车型

                <a class="layui-btn layui-btn-small do-action" id="toProp" data-type="doAddEdit" data-href="${seepropUrl}/"><i class="layui-icon">&#xe609;</i>点击查看属性</a>

            </legend>
            <div class="layui-field-box">

                <form class="layui-form" action="${updateCarUrl}"  method="post">
                        <input type="hidden" name="id" id="idInput" value="${car.id}">
                    <div class="layui-form-item layui-input-block">
                        <label class="layui-form-label">汽车编号</label>
                        <div class="layui-input-inline" style="width: 25%">
                            <input type="text" name="number" required value="${car.number}"  lay-verify="required" placeholder="请输入汽车编号" autocomplete="off" class="layui-input">
                        </div>
                        <label class="layui-form-label">汽车名称</label>
                        <div class="layui-input-inline"  style="width: 25%">
                            <input type="text" name="name" required  value="${car.name}"   lay-verify="required" placeholder="请输入汽车型号" autocomplete="off" class="layui-input">
                        </div>
                        <label class="layui-form-label">年款</label>
                        <div class="layui-input-inline"  style="width: 25%">
                            <input type="text" name="yearSku" required value="${car.yearSku}"   lay-verify="required" placeholder="请输入汽车型号" autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-input-block">
                        <div class="layui-form-item layui-input-inline">
                            <label class="layui-form-label">变速箱类型</label>
                            <div class="layui-input-block" style="width: 50%">
                                <select name="gearbox" lay-verify="required">
                                    <option value=""></option>
                                    <c:forEach items="${gaerboxList}" var="gaer">
                                        <c:if test="${car.gearbox==gaer.id}">
                                            <option value="${gaer.id}" selected="selected">${gaer.dicName}</option>
                                        </c:if>
                                        <c:if test="${car.gearbox!=gaer.id}">
                                            <option value="${gaer.id}">${gaer.dicName}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>



                        <div class="layui-form-item layui-input-inline">
                            <label class="layui-form-label">汽车分类</label>
                            <div class="layui-input-block" style="width: 50%">
                                <select name="carType" lay-verify="required">
                                    <option value=""></option>
                                    <c:forEach items="${carTypeList}" var="type">
                                        <c:if test="${car.carType==type.id}">
                                            <option value="${type.id}" selected="selected">${type.typeName}</option>
                                        </c:if>
                                        <c:if test="${car.carType!=type.id}">
                                            <option value="${type.id}">${type.typeName}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="layui-form-item layui-input-inline">
                            <label class="layui-form-label">汽车品牌</label>
                            <div class="layui-input-block"  style="width: 50%">
                                <select name="carBrand" lay-verify="required">
                                    <option value=""></option>
                                    <c:forEach items="${carBrandList}" var="brand" >
                                        <c:if test="${car.carBrand==brand.id}">
                                            <option value="${brand.id}" selected="selected">${brand.brandName}</option>
                                        </c:if>
                                        <c:if test="${car.carBrand!=brand.id}">
                                            <option value="${brand.id}">${brand.brandName}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="layui-form-item layui-input-inline">
                            <label class="layui-form-label">汽车颜色</label>
                            <div class="layui-input-inline">
                                <select name="color" lay-verify="required">
                                    <option value=""></option>
                                    <c:forEach items="${colorList}" var="color">
                                        <c:if test="${car.color==color.id}">
                                            <option value="${color.id}" selected="selected">${color.dicName}</option>
                                        </c:if>
                                        <c:if test="${car.color!=color.id}">
                                            <option value="${color.id}">${color.dicName}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>

                        </div>
                    </div>

                    <div class="layui-input-block">
                        <div class="layui-form-item  layui-input-inline">
                            <label class="layui-form-label">排量</label>
                            <div class="layui-input-inline">
                                <input type="text" name="capacity" required  value="${car.capacity}"  lay-verify="required" placeholder="请输入排量" autocomplete="off" class="layui-input">
                            </div>
                        </div>


                        <div class="layui-form-item layui-input-inline">
                            <label class="layui-form-label">是否上架</label>
                            <div class="layui-input-inline">
                                <c:if test="${car.unable==1}">
                                    <input type="radio" name="unable" value="1" title="上架"  checked="checked">
                                    <input type="radio" name="unable" value="0" title="下架">
                                </c:if>
                                <c:if test="${car.unable!=1}">
                                    <input type="radio" name="unable" value="1" title="上架" >
                                    <input type="radio" name="unable" value="0" title="下架"  checked="checked">
                                </c:if>
                            </div>
                        </div>


                        <div class="layui-form-item  layui-input-inline">
                            <label class="layui-form-label">权重</label>
                            <div class="layui-input-inline">
                                <input type="text" name="weight" value="${car.weight}"  lay-verify="required" placeholder="权重，数值越大出现越靠前" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>

                    <div class="layui-input-block">
                        <div class="layui-form-item  layui-input-inline">
                            <label class="layui-form-label">订金</label>
                            <div class="layui-input-inline">
                                <input type="text" name="reservePrice" value="${car.reservePrice}"  lay-verify="required" placeholder="页面显示金额" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item  layui-input-inline">
                            <label class="layui-form-label">售价</label>
                            <div class="layui-input-inline">
                                <input type="text" name="sellPrice"  value="${car.sellPrice}" lay-verify="required" placeholder="实际价格" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item  layui-input-inline">
                            <label class="layui-form-label">市场指导价</label>
                            <div class="layui-input-inline">
                                <input type="text" id="shopPrice" value="${car.shopPrice}"  placeholder="8.12-12.25  字符串形式" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>




                    <div class="layui-form-item layui-input-block">
                        <label class="layui-form-label">别名</label>
                        <div class="layui-input-block">
                            <input type="text" name="asname" value="${car.asname}"    lay-verify="required" placeholder="请添加搜索关键词 使用“，”分割" autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item layui-input-block">
                        <label class="layui-form-label">卖点</label>
                        <div class="layui-input-block">
                            <input type="text" name="sellpoint"  value="${car.sellpoint}"  lay-verify="required" placeholder="请输入商品卖点" autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item layui-input-block">
                        <div class="layui-form-label">图片上传</div>
                        <button type="button"  class="layui-btn layui-btn-normal" id="fileUpload">上传图片</button>
                        <div class="layui-input-block">
                            <input type="hidden" name="image" id="hiddenImgs" value="${car.image}" />
                        </div>
                    </div>

                    <div class="layui-input-block" id="imagesShow">
                    </div>

                    <%--<div class="layui-form-item layui-input-block">--%>
                        <%--<div class="layui-form-label">属性</div>--%>
                        <%--<div class="layui-input-block">--%>
                            <%--<a class="layui-btn layui-btn-small do-action" id="toProp" data-type="doAddEdit" data-href="${seepropUrl}/"><i class="layui-icon">&#xe609;</i>点击查看属性</a>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <div class="layui-input-block">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">普通文本域</label>
                            <div class="layui-input-block">
                                <textarea placeholder="请输入内容" name="details" id="cardetails" class="layui-textarea">
                                  ${car.details}
                                </textarea>
                            </div>
                        </div>
                    </div>



                    <div class="layui-form-item layui-input-block">
                        <div class="layui-input-inline">
                            <button class="layui-btn" lay-submit lay-filter="formDemo">立即更改</button>
                            <button class="layui-btn" type="button" onclick="javascript:history.go(-1);">返回</button>
                        </div>
                        <div class="layui-input-inline">

                        </div>
                    </div>
                </form>
            </div>
        </fieldset>
    </div>
</div>
<!-- js脚本 -->
<script type="text/javascript" src="/resources/js/event.js"></script>
<script type="text/javascript">



    layui.use('form', function(){
        var form = layui.form();

        //监听提交
        //ajax 提交
        //get请求
        form.on('submit(formDemo)', function(data){

            <!--富文本数据同步 同步方法-->
            itemAddEditor.sync();
            <!--添加参数-->
            data.field.details=$("#cardetails").val();
            <!--图片收集-->
            var imgArray = [];
             $.each($("#imagesShow img"),function(i,e){
                 imgArray.push($(e).attr("src"));
                 alert($(e).attr("src"));
             });
            data.field.image = imgArray.join(",");

//            layer.msg(JSON.stringify(data.field));
            //数据提交
            $.ajax({
                type:"POST",
                url:"${updateCarUrl}",
                dataType:"json",
                contentType:"application/json",
                data:JSON.stringify(data.field),
                success:function(result){
                    layer.msg(result.message);
                    if(result.status==200){
                        $("#returnList").click();
                    }
                }
            });
            return false;
        });
    });

    <!--图片上传以及富文本编译器-->
    $(function(){

        $("#toProp").attr("data-href","${seepropUrl}/"+$("#idInput").val());


        var kindEditorParams = {
            //指定上传文件参数名称
            filePostName  : "uploadFile",
            //指定上传文件请求的url。
            uploadJson : '/file/upload',
            //上传类型，分别为image、flash、media、file
            dir : "image",
            allowFileManager : true
        }

        //创建富文本编辑器
        itemAddEditor = KindEditor.create("#cardetails",kindEditorParams);
        $("#cardetails").click(function(){
            var _self = $(this);
            KindEditor.editor(kindEditorParams).loadPlugin('image', function() {
                this.plugin.imageDialog({
                    showRemote : false,
                    clickFn : function(url, title, width, height, border, align) {

                        //添加图片成功之后的回显
                        $("#imagesShow").append('<div class="layui-input-block" ><a href="'+url+'"  target="_blank"><img  style="width: 690px;height: 366px"  src="'+url+'"></a><button type="button" class="layui-btn layui-btn-warm" onclick="delImage(this)">删除<button/></div>');
                    }
                });
            });
        });

        <!--图片上传-->

        //给“上传图片按钮”绑定click事件
        $("#fileUpload").click(function(){
            var form = $(this).parentsUntil("form").parent("form");
            //打开图片上传窗口
            KindEditor.editor(kindEditorParams).loadPlugin('multiimage',function(){
                var editor = this;
                editor.plugin.multiImageDialog({
                    clickFn : function(urlList) {
                        var imgArray = [];
                        KindEditor.each(urlList, function(i, data) {
                            imgArray.push(data.url);
                            $("#imagesShow").append('<div class="layui-input-block" ><a href="'+data.url+'"  target="_blank"><img  style="width: 690px;height: 366px"  src="'+data.url+'"></a><button type="button" class="layui-btn layui-btn-warm" onclick="delImage(this)">删除<button/></div>');
                        });
                        form.find("[name=image]").val(imgArray.join(","));
                        editor.hideDialog();
                    }
                });
            });
        });
    })


    $(function(){
//        图片回显
        $.each($("#hiddenImgs").val().split(","),function(i,e){
            if($.trim(e).length > 0){
                $("#imagesShow").append('<div class="layui-input-block" ><a href="'+e+'"  target="_blank"><img  style="width: 690px;height: 366px"  src="'+e+'"></a><button type="button" class="layui-btn layui-btn-warm" onclick="delImage(this)">删除<button/></div>');
            }
        });
//        汽车详情回显
//        itemAddEditor.insertHtml($("#cardetails").html()+""+"test");
    })


    function delImage(obj){
        if(confirm("确定删除？")){
            $(obj).parent().remove();
        }

    }
</script>
</body>
</html>