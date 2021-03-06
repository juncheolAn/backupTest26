<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<jsp:include page="/WEB-INF/views/module/top.jsp" />

		<h2>country list</h2>
		<div class="row">
			<div class="col-sm-6 col-lg-6">				
				<p class="lead text-muted">목록 크기 : ${list.size()}</p>
				<p class="lead text-muted">검색</p>
				<form action="${pageContext.request.contextPath}/country/countryList" method="get">
				<input type="text" name="searchWord">
				<button type="submit">검색</button>
				</form>	
				
				<!--SELECT COUNT OPTION 시작 -->
				<div style="margin-bottom: 10;">
					<select name="rowPerPage" onchange="location.href=this.value">
						<option value="#">보여줄 개수 선택</option>
						<option
							value="${pageContext.request.contextPath}/country/countryList?rowPerPage=5">5개
							보여주기</option>
						<option
							value="${pageContext.request.contextPath}/country/countryList?rowPerPage=10">10개
							보여주기</option>
						<option
							value="${pageContext.request.contextPath}/country/countryList?rowPerPage=20">20개
							보여주기</option>
					</select><br>
				</div>
				<!--SELECT COUNT OPTION 끝 -->

				<table class="table table-striped" data-effect="fade">
					<thead>
						<tr>
							<th>country_id</th>
							<th>country_name</th>
							<th>수정</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="country" items="${list}">
							<tr>
								<td>${country.countryId }</td>
								<td>${country.countryName }</td>
								<td><a
									href="${pageContext.request.contextPath}/country/countryUpdate?countryId=${country.countryId }">수정</a></td>
								<td><a
									href="${pageContext.request.contextPath}/country/countryDelete?countryId=${country.countryId }">삭제</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- 이전, 다음 버튼 시작 -->
				<div class="col-sm-12" style="margin-bottom: 10;">
					<div>
						<a href="<c:if test="${currentPage>1}">${pageContext.request.contextPath}/country/countryList?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}</c:if>"><button type="button" class="btn btn-labeled btn-default">
								<span class="btn-label"> <i class="fa fa-arrow-left"></i>
								</span>이전</button></a> 
								${currentPage} 
						<a href="<c:if test="${currentPage<lastPage}">${pageContext.request.contextPath}/country/countryList?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}</c:if>"><button type="button" class="btn btn-labeled btn-default">
							    다음<span class="btn-label btn-label-right"> <i class="fa fa-arrow-right"></i>
								</span></button></a>
					</div>
				</div>
				<!-- 이전, 다음 버튼 끝 -->			
			</div>
		</div>

		<a class="btn btn-default"
			href="${pageContext.request.contextPath}/country/countryInsert">국가
			추가</a> <a class="btn btn-default"
			href="${pageContext.request.contextPath}/">홈으로</a>



<jsp:include page ="/WEB-INF/views/module/footer.jsp"/>
