<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js""></script>
</head>

<body>
<form name="icform" method="post">
	<input type="hidden" name="id" value="${id}"/>

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('shippingOrderAction_update','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   修改委托单
  </div> 
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">编号：</td>
	            <td class="tableContent"><input type="text" name="id" value="${id}" disabled="disabled"/></td>
	       
	            <td class="columnTitle">海运/空运：</td>
	            <td class="tableContent"><input type="text" name="orderType" value="${orderType}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">货主：</td>
	            <td class="tableContent"><input type="text" name="shipper" value="${shipper}"/></td>
	       
	            <td class="columnTitle">提单抬头：</td>
	            <td class="tableContent"><input type="text" name="consignee" value="${consignee}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">正本通知人：</td>
	            <td class="tableContent"><input type="text" name="notifyParty" value="${notifyParty}"/></td>
	       
	            <td class="columnTitle">信用证：</td>
	            <td class="tableContent"><input type="text" name="lcNo" value="${lcNo}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">装运港：</td>
	            <td class="tableContent"><input type="text" name="portOfLoading" value="${portOfLoading}"/></td>
	        
	            <td class="columnTitle">转船港：</td>
	            <td class="tableContent"><input type="text" name="portOfTrans" value="${portOfTrans}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">卸货港：</td>
	            <td class="tableContent"><input type="text" name="portOfDischarge" value="${portOfDischarge}"/></td>
	       
	            <td class="columnTitle">装期：</td>
	            <td class="tableContent">
	             <input type="text" style="width:90px;" name="loadingDate"
	            	 value="${loadingDate}"
	             	onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
	            </td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">效期：</td>
	            <td class="tableContent">
	             <input type="text" style="width:90px;" name=limitDate
	            	 value="${limitDate}"
	             	onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
	            </td>
	       
	            <td class="columnTitle">是否分批：</td>
	            <td class="tableContent">
	            	<select name="isBatch">
	            		<option value="0" <c:if test="${isBatch==0}">selected</c:if>>否</option>
	            		<option value="1" <c:if test="${isBatch==1}">selected</c:if>>是</option>
	            	</select>
	            </td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">是否转船：</td>
	            <td class="tableContent">
		            <select name="isTrans">
		            		<option value="0" <c:if test="${isTrans==0}">selected</c:if>>否</option>
		            		<option value="1" <c:if test="${isTrans==1}">selected</c:if>>是</option>
		            </select>
	            </td>
	       
	            <td class="columnTitle">份数：</td>
	            <td class="tableContent"><input type="text" name="copyNum" value="${copyNum}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">扼要说明：</td>
	            <td class="tableContent"><input type="text" name="remark" value="${remark}"/></td>
	       
	            <td class="columnTitle">运输要求：</td>
	            <td class="tableContent"><input type="text" name="specialCondition" value="${specialCondition}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">运费说明：</td>
	            <td class="tableContent"><input type="text" name="freight" value="${freight}"/></td>
	      
	            <td class="columnTitle">复核人：</td>
	            <td class="tableContent"><input type="text" name="checkBy" value="${checkBy}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle"> 状态 ：</td>
	            <td class="tableContent">
	            <c:if test="${state==0}">草稿</c:if>
	            <c:if test="${state==1}">已上报</c:if>		
	            </td>
	        </tr>	
	       
		</table>
	</div>
 
 
</form>
</body>
</html>

