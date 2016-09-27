<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>

<div class="container">

    <h2 class="header">Catalog</h2>
    <br>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>#</th>
                <th>Category</th>
                <th>Genre</th>
                <th>Name</th>
                <th>Price</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="product" items="${products}">
                <tr>
                    <td><a href="<c:url value="/cart/addProduct/${product.productId}"/>"><span
                            class="glyphicon glyphicon-shopping-cart"></span></a></td>
                    <td>${product.category.name}</td>
                    <td>${product.genre}</td>
                    <td>${product.name}</td>
                    <td>$ ${product.price}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
<!-- /.container -->

<jsp:include page="template/footer.jsp"/>
