<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>





<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-7">
            <div class="card shadow-lg border-0 rounded-lg mt-5">
                <div class="card-header"><h3 class="text-center font-weight-light my-4">Todo Add</h3></div>
                <div class="card-body">
                    <form action="/todo/add" method="post">
                        <%-- title --%>
                        <div class="row mb-3">
                            <div class="col-md-12">
                                <div class="form-floating mb-3 mb-md-0">
                                    <input class="form-control" name="title" id="title" type="text" placeholder="Title" />
                                    <label for="title">Title</label>
                                </div>
                            </div>
                        </div>
                        <%-- memo --%>
                        <div class="form-floating mb-3">
                            <textarea class="form-control" name="memo" id="memo" placeholder="Memo" style="height: 200px;"></textarea>
                            <label for="memo">Memo</label>
                        </div>
                        <%-- dueDate --%>

                        <div class="row mt-4 mb-6">
                            <%--                <div class="d-grid"><a class="btn btn-primary btn-block" href="login.html">Create Account</a></div>--%>
                            <div class="form-floating col-md-6 d-grid">
                                <button type="button" onclick="location.href='/todo/list?page=1';" class="btn btn-success btn-block">Go List</button>
                            </div>
                            <div class="form-floating col-md-6 d-grid">
                                <button type="submit" class="btn btn-primary btn-block">Add</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>





<%@ include file="../includes/footer.jsp"%>