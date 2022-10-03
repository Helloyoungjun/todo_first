<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>




<div>
    안녕하세요 TODo 시작할게요
</div>
<div class="d-grid gap-2">
    <button class="btn btn-primary" type="button" onclick="location.href='http://localhost:8083/todo/list';">GO TO List</button>
</div>
<%@ include file="../includes/footer.jsp"%>