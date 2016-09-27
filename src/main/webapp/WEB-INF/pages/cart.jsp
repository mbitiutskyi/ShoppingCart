<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>

<div class="container">
    <h2 class="sub-header">Your Shopping Cart</h2>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Category</th>
                <th>Genre</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Item Price</th>
                <th>Total</th>
                <th>#</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="cartItem" items="${shoppingCart.cartItems}">
                <tr>
                    <td>${cartItem.product.category.name}</td>
                    <td>${cartItem.product.genre}</td>
                    <td>${cartItem.product.name}</td>
                    <td>${cartItem.quantity}</td>
                    <td>$${cartItem.product.price}</td>
                    <td>$${cartItem.itemPrice}</td>
                    <td><a href="/cart/removeProduct/${cartItem.product.productId}">
                        <span class="glyphicon glyphicon-remove"></span></a>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <th><span class="pull-right">Grand Total:</span></th>
                <th>${shoppingCart.totalQuantity}</th>
                <td></td>
                <th>$${shoppingCart.totalPrice}</th>
                <td></td>
            </tr>
            </tbody>
        </table>
    </div>
    <div>
        <a class="btn btn-default pull-left" href="<c:url value="/catalog"/>">Continue shopping..</a>
        <a class="btn btn-danger pull-right" href="<c:url value="/cart/clear"/>">Clear Cart</a>
    </div>
</div>
<!-- /.container -->

<jsp:include page="template/footer.jsp"/>
