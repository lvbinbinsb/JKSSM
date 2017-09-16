<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('invoiceAction_insert','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   新增发票
  </div> 
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	      
	        <tr>
	            <td class="columnTitle">发票号：</td>
	            <td class="tableContent"><input type="text" name="scNo" value=""/></td>
	      
	            <td class="columnTitle">提单号：</td>
	            <td class="tableContent"><input type="text" name="blNo" value=""/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">贸易条款：</td>
	            <td class="tableContent"><input type="text" name="tradeTerms" value=""/></td>
	        </tr>	
	       
	        
		</table>
	</div>
 
 	 <div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>	<!-- onclick="checkAll('id',this)"<input type="radio" name="id" > -->
		<td class="tableHeader"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">编号</td>
		<td class="tableHeader">海运/空运</td>
		<td class="tableHeader">货主</td>
		<td class="tableHeader">信用证</td>
		<td class="tableHeader">装期</td>
		<td class="tableHeader">复核人</td>
		<td class="tableHeader">状态</td>
	</tr>
	</thead>
<div class="textbox-title">委托单列表</div>	
	<tbody class="tableBody">
${links}
	
	<c:forEach items="${results}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="radio" name="id" value="${o.id}"/></td>
		<td>${status.index+1}</td>
		<td>${o.id}</td>
		<td>${o.orderType}</td>
		<td>${o.shipper}</td>
		<td>${o.lcNo}</td>
		<td>${o.loadingDate}</td>
		<td>${o.checkBy}</td>
		<td>
		<c:if test="${o.state==0 }">草稿</c:if>
		<c:if test="${o.state==1 }">已上报</c:if>
		</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</form>
</body>
</html>

