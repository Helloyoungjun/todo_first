<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>


<%--jstl 추가 코드--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../includes/header.jsp" %>

<div class="container-fluid px-4">
    <h1 class="mt-4">Tables</h1>
    <ol class="breadcrumb mb-4">
        <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
        <li class="breadcrumb-item active">Tables</li>
    </ol>
    <div class="card mb-4">
        <div class="card-body">
            TODO List <%--${work} ${result}--%>
        </div>
    </div>
    <div class="card mb-4">
        <div class="card-header">
            <i class="fas fa-table me-1"></i>
            DataTable Example
            <a href="/todo/add">
                <button type="button" class="btn btn-lg btn-primary float-end" aria-disabled="true">Add</button>
            </a>
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">tno</th>
                    <th scope="col">title</th>
                    <th scope="col">memo</th>
                    <th scope="col">regdate</th>
                    <th scope="col">complete</th>

                </tr>
                </thead>
                <tbody>
                <%--item 으로 java 데이터를 받아서 var에다가 변수명을 붙여준다.--%>


                <c:forEach items="${list}" var="list">



                    <tr style=" font-weight: bolder;
                        <c:if test='${list.complete }'>color : darkgrey;</c:if>
                    <c:if test='${!list.complete }'>color : red;</c:if>
                   ">


                        <th><a href="/todo/detail?tno=${list.tno}"><c:out value="${list.tno}"/><a/></th>
                        <td><c:out value="${list.title}"/></td>
                        <td><c:out value="${list.memo}"/></td>
                        <td><c:out value="${list.regDate}"/></td>
                        <td>
                            <c:if test="${list.complete}">
                            <input class="form-check-input" name="complete" id="complete" type="checkbox"
                                   placeholder="Complete" value="${list.complete}" checked disabled/>
                            </c:if>
                            <c:if test="${!list.complete}">
                                <input class="form-check-input" name="complete" id="complete" type="checkbox"
                                       placeholder="Complete" value="${list.complete}" disabled/>
                            </c:if>
                        </td>
                    </tr>







                </c:forEach>
                </tbody>


            </table>
            <nav aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                <li class="page-item"><a class="page-link" href="/todo/list?page=1">1</a></li>
                <li class="page-item"><a class="page-link" href="/todo/list?page=2">2</a></li>
                <li class="page-item"><a class="page-link" href="/todo/list?page=3">3</a></li>
                <li class="page-item"><a class="page-link" href="/todo/list?page=4">4</a></li>
                <li class="page-item"><a class="page-link" href="/todo/list?page=5">5</a></li>
                <li class="page-item"><a class="page-link" href="/todo/list?page=#">Next</a></li>
            </ul>
        </nav>





        </div>

        <div>


        </div>
    </div>
</div>


<%@ include file="../includes/footer.jsp" %>