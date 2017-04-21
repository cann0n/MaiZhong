<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/18
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>迈众汽车</title>
    <meta http-equiv="X-UA-Compatible" content="IE=9">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>迈众汽车</title>
    <meta name="keywords" content="汽车,汽车买卖,汽车网,汽车报价,汽车图片,买车"/>
    <meta name="description" content="迈众汽车为您提供最新汽车报价，汽车图片，汽车价格大全，最精彩的汽车新闻、行情、评测、导购内容，是提供信息最快最全的中国汽车网站。"/>
     <link rel="stylesheet" type="text/css" href="/resources/css/index.css" />
    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="bans"><img src="../resources/img/1-3.jpg"></div>

<div class="x_nav">当前位置 :  <a href="/">首页</a> > <a href="javascript:;">估值</a> > ${result.city} &nbsp;${result.modelName} 二手车评估详情</div>

 <div class="can">
     <dl>
         <dt><img src="${result.seriesImg}?imageMogr2/thumbnail/x100" height="100" width="133"></dt>
         <dd class="dd1">${result.modelName}</dd>
         <dd><span>${result.city}</span>|<span>${result.regdate}上牌</span>|<span>${result.mail}万公里</span>|
             <span>${result.gearType}</span>|<span>排量${result.liter}</span>|<span>${result.dischargeStandard}</span>|
             <span>新车售价${result.modelPrice}万</span></dd>
     </dl>
 </div>

<!--估价选项-->
  <div class="guj">
      <div class="gu hover">
          <h2>车况优秀</h2>
          <span>${result.priceA}</span>
          <p>车况说明</p>
          <div>迈众作为独立第三方价格服务平台，为您
              提供精确的车辆估值服务，让您在交易前充分
              了解市场行情价</div>

          <dl>
              <dt>外观</dt>
              <dd>外观无可见瑕疵和色差</dd>
          </dl>

          <dl>
              <dt>内饰</dt>
              <dd>内饰干净整洁无明显可见磨损；
                  无异味</dd>
          </dl>

          <dl>
              <dt>工况</dt>
              <dd>2年且4万公里以内；
                  动力系统、机械部位运行正常且无维修；
                  按时保养且记录完整；电子系统无任何故障</dd>
          </dl>

      </div>


      <div class="gu">
          <h2>车况良好</h2>
          <span>${result.priceB}</span>
          <p>车况说明</p>
          <div>迈众作为独立第三方价格服务平台，为您
              提供精确的车辆估值服务，让您在交易前充分
              了解市场行情价</div>

          <dl>
              <dt>外观</dt>
              <dd>外观无可见瑕疵和色差</dd>
          </dl>

          <dl>
              <dt>内饰</dt>
              <dd>内饰干净整洁无明显可见磨损；
                  无异味</dd>
          </dl>

          <dl>
              <dt>工况</dt>
              <dd>2年且4万公里以内；
                  动力系统、机械部位运行正常且无维修；
                  按时保养且记录完整；电子系统无任何故障</dd>
          </dl>

      </div>


      <div class="gu">
          <h2>车况一般</h2>
          <span>${result.priceC}</span>
          <p>车况说明</p>
          <div>迈众作为独立第三方价格服务平台，为您
              提供精确的车辆估值服务，让您在交易前充分
              了解市场行情价</div>

          <dl>
              <dt>外观</dt>
              <dd>外观无可见瑕疵和色差</dd>
          </dl>

          <dl>
              <dt>内饰</dt>
              <dd>内饰干净整洁无明显可见磨损；
                  无异味</dd>
          </dl>

          <dl>
              <dt>工况</dt>
              <dd>2年且4万公里以内；
                  动力系统、机械部位运行正常且无维修；
                  按时保养且记录完整；电子系统无任何故障</dd>
          </dl>

      </div>


      <div class="gu none">
          <h2>车况较差</h2>
          <span>${result.priceD}</span>
          <p>车况说明</p>
          <div>迈众作为独立第三方价格服务平台，为您
              提供精确的车辆估值服务，让您在交易前充分
              了解市场行情价</div>

          <dl>
              <dt>外观</dt>
              <dd>外观无可见瑕疵和色差</dd>
          </dl>

          <dl>
              <dt>内饰</dt>
              <dd>内饰干净整洁无明显可见磨损；
                  无异味</dd>
          </dl>

          <dl>
              <dt>工况</dt>
              <dd>2年且4万公里以内；
                  动力系统、机械部位运行正常且无维修；
                  按时保养且记录完整；电子系统无任何故障</dd>
          </dl>

      </div>

  </div>
<div class="mc"><a style="display: block;color: #FFF" href="/sale/${ppap}">我要卖车</a></div>

<!--估价选项 end-->
<div class="bans"><img src="../resources/img/1-4.jpg"></div>



<!--流程-->
<div class="lius">
    <div class="l_cen">
        <h2>我们的流程 <span>快速成交，立马打款，及时有效</span></h2>
        <dl>
            <dt class="dt1"></dt>
            <dd>网上定价</dd>
        </dl>

        <dl>
            <dt class="dt2"></dt>
            <dd>预约检测</dd>
        </dl>

        <dl>
            <dt class="dt3"></dt>
            <dd>现场打款</dd>
        </dl>

        <dl>
            <dt class="dt4"></dt>
            <dd>售后保障</dd>
        </dl>
    </div>
</div>
<!--流程 end-->


<!--交易记录-->
<div class="jiaos">

    <h2>交易记录 <span> 真实记录、公正透明、超高效率</span></h2>

    <div class="j_cen">

        <div class="one">
            <span class="cl_one">成交车型</span>
            <span>新车指导价</span>
            <span>成交价</span>
            <span>上牌时间</span>
            <span>公里数</span>
            <span>成交日期</span>
            <span>城市</span>
            <span class="last">类别</span>
        </div>


        <div>
            <span class="cl_one">2012款 迈腾 1.4TSI DSG豪华型</span>
            <span>16.78万</span>
            <span>7.07万</span>
            <span>2012年12月 </span>
            <span>13万公里 </span>
            <span>2017年04月20日</span>
            <span>北京</span>
            <span class="last">车商</span>
        </div>


        <div>
            <span class="cl_one">2012款 迈腾 1.4TSI DSG豪华型</span>
            <span>16.7
                8万</span>
            <span>7.07万</span>
            <span>2012年6月 </span>
            <span>10.85万公里 </span>
            <span>2017年04月18日</span>
            <span>北京</span>
            <span class="last">车商</span>
        </div>



        <div>
            <span class="cl_one">2012款 高尔夫 1.6L 自动 时尚型</span>
            <span>13.09万 </span>
            <span>5.64万</span>
            <span>2012年11月 </span>
            <span>12.85万公里 </span>
            <span>2017年04月06日</span>
            <span>北京</span>
            <span class="last">车商</span>
        </div>

        <div>
            <span class="cl_one">2012款 高尔夫 1.4TSI 自动舒适型</span>
            <span>14.48万</span>
            <span>6.58万</span>
            <span>2012年5月 </span>
            <span>12万公里 </span>
            <span>2017年04月20日</span>
            <span>北京</span>
            <span class="last">车商</span>
        </div>


    </div>
</div>

<!--交易记录 end-->
<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
