<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>



<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-7">
            <div class="card shadow-lg border-0 rounded-lg mt-5">
                <div class="card-header"><h3 class="text-center font-weight-light my-4">상세보기</h3></div>
                <div class="card-body">
                    <form action="/todo/delete" method="post">
                        <%-- tno --%>
                        <div class="row mb-3">
                            <div class="col-md-12">
                                <div class="form-floating mb-3 mb-md-0">
                                    <input class="form-control" name="tno" id="tno" type="text" placeholder="Todo No" value="${TodoDTO.tno}" readonly/>
                                    <label for="title">No</label>
                                </div>
                            </div>
                        </div>
                        <%-- title --%>
                        <div class="row mb-3">
                            <div class="col-md-12">
                                <div class="form-floating mb-3 mb-md-0">
                                    <input class="form-control" name="title" id="title" type="text" value="${TodoDTO.title}" placeholder="Title" readonly/>
                                    <label for="title">Title</label>
                                </div>
                            </div>
                        </div>
                        <%-- memo --%>
                        <div class="form-floating mb-3">
                            <textarea class="form-control" name="memo" id="memo" placeholder="Memo" style="height: 200px; resize: none;" readonly>${TodoDTO.memo}</textarea>
                            <label for="memo">Memo</label>
                        </div>
                        <%-- dueDate --%>


                        <%-- complete --%>
                        <div class="row mb-3">
                            <div class="col-md-12">
                                <div class="">
                                    <label for="title">IsComplete</label>
                                    <c:if test="${TodoDTO.complete}">
                                        <input class="form-check-input" name="complete" id="complete" type="checkbox" placeholder="Complete" value="${todo.complete}" checked disabled/>
                                    </c:if>
                                    <c:if test="${!TodoDTO.complete}">
                                        <input class="form-check-input" name="complete" id="complete" type="checkbox" placeholder="Complete" value="${todo.complete}" disabled/>
                                    </c:if>
                                </div>
                            </div>
                        </div>


                        <div class="row mt-4 mb-6">
                            <%--                <div class="d-grid"><a class="btn btn-primary btn-block" href="login.html">Create Account</a></div>--%>
                            <div class="form-floating col-md-4 d-grid">
                                <button type="button" class="btn btn-success btn-block"  onclick="location.href='/todo/list'">Go List</button>
                            </div>
                            <div class="form-floating col-md-4 d-grid">
                                <button type="submit" class="btn btn-danger btn-block">Delete</button>
                            </div>
                            <div class="form-floating col-md-4 d-grid">
                                <button type="button" class="btn btn-primary btn-block" onclick="location.href='/todo/update?tno=${TodoDTO.tno}'">Modify</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<%@ include file="../includes/footer.jsp"%>