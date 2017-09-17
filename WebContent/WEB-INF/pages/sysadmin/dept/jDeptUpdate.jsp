<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
<script type="text/javascript" src="${ctx }/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		$("option").each(function(i,n){
			var value=$('#e').val();
			if($(n).val()==value)
				$(n).prop("selected","selected");
		});
		
	});
</script>	
</head>

<body>
<form name="icform" method="post">
      <input type="hidden" name="deptId" value="${dept.deptId}"/>
      <input type="hidden" id="e" value="${dept.parentId }"/> 
      
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('deptAction_update.action','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   修改部门
  </div> 
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">上级部门：</td>
	            <td class="tableContent">
	             <!-- struts2标签默认具有自动回显     原理： 它默认会取值栈的栈顶 -->
	            <!--  <s:select name="parent.id" list="deptList"
	            		listKey="id" listValue="deptName"
	            		headerKey="" headerValue="--请选择--"
	            	></s:select> -->
	            <select name="parentId" id="DeptList">
	            	<c:forEach items="${list}" var="dept">
	            		<option value="${dept.deptId }">${dept.deptName}</option>
	            	</c:forEach>
	            </select>	
	        <!--       
	            <select>
	            
	            	
	            
	            	<option value=" ">--请选择--</option>
	            	<c:forEach items="${ deptList}" var="dept">
					      <c:if test="${dept.id!=id }">
								<option value="${dept.id }">${dept.deptName }</option>					       
	            		  </c:if>	
					    		
	            	</c:forEach>
	            </select>	
	          -->
	            </td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">部门名称：</td>
	            <td class="tableContent"><input type="text" name="deptName" value="${dept.deptName }"/>
	            </td>
	        </tr>		
		</table>
	</div>
 </form>
</body>
</html>